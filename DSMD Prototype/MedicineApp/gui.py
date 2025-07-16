import tkinter as tk
from tkinter import ttk
import textwrap
from shutil import get_terminal_size
from .medicine_ontology import MedicineOntology
from .medicine_query_engine import MedicineQueryEngine
from .similarity_calculator import SimilarityCalculator


class MedicineAppGUI:
    def __init__(self, master, csv_path):
        self.master = master
        self.master.title("Domain Specific Medicine Dictionary")
        self.master.geometry("800x600")
        self.master.configure(bg="lightblue")

        # Initialize ontology and logic engines
        self.ontology = MedicineOntology(csv_path)
        self.query_engine = MedicineQueryEngine(self.ontology)
        self.similarity_engine = SimilarityCalculator(self.ontology.get_all())
        self.terminal_width = get_terminal_size().columns

        self._build_gui()

    def _build_gui(self):
        custom_font = ("Times New Roman", 14)

        label = tk.Label(self.master, text="Query Engine", font=custom_font, bg="lightblue")
        label.pack(pady=8)

        self.entry = tk.Entry(self.master, width=70, font=custom_font)
        self.entry.pack()

        search_button = ttk.Button(self.master, text="Search", command=self._on_search)
        search_button.pack(pady=10)

        result_frame = ttk.Frame(self.master)
        result_frame.pack(fill=tk.BOTH, expand=True, padx=40, pady=20)

        self.result_text = tk.Text(result_frame, font=custom_font)
        self.result_text.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)

        scrollbar = ttk.Scrollbar(result_frame, command=self.result_text.yview)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
        self.result_text.config(yscrollcommand=scrollbar.set)
        self.result_text.config(state='disabled')

        clear_button = tk.Button(self.master, text="Clear", command=self._clear_text)
        clear_button.pack()

    def _clear_text(self):
        self.result_text.config(state='normal')
        self.result_text.delete(1.0, tk.END)
        self.result_text.config(state='disabled')
        self.entry.delete(0, tk.END)

    def _on_search(self):
        query = self.entry.get().strip()
        output = self._process_query(query)
        self.result_text.config(state='normal')
        self.result_text.delete(1.0, tk.END)
        self.result_text.insert(tk.END, output)
        self.result_text.config(state='disabled')

    def _process_query(self, query):
        query = query.strip()

        if query.lower().startswith("similarity:"):
            return self._handle_similarity_query(query[len("similarity:"):].strip())

        elif query.lower().startswith("distance:"):
            return self._handle_distance_query(query[len("distance:"):].strip())

        elif "(" in query and ")" in query:
            return self._handle_question(query)

        elif "," in query:
            return self._handle_two_part_query(query)

        else:
            return self._handle_single_query(query)

    def _handle_single_query(self, brand_name):
        result = self.query_engine.get_brand_info(brand_name)
        if result:
            return "\n".join(f"{k}: {v}" for k, v in result.items() if v)
        return "Brand not found."

    def _handle_two_part_query(self, input_str):
        parts = [p.strip() for p in input_str.split(",")]
        if len(parts) != 2:
            return "Invalid query format. Use: Brand, Predicate"

        subject, predicate = parts

        if predicate == "alternative brand":
            alternatives = self.query_engine.get_alternatives(subject)
            if not alternatives:
                return f"No alternative brands found for {subject}."
            output = "\nAlternative medicine brands:\n\n"
            max_len = max(len(a) for a in alternatives)
            for i, alt in enumerate(alternatives, 1):
                output += f"{i:2}. {alt.ljust(max_len)}"
                output += "\n" if i % 2 == 0 else "     "
            return output

        elif predicate in ["pharmacology description", "side effects"]:
            return self._query_special(subject, predicate)

        else:
            values = self.ontology.get_related(subject, predicate)
            if values:
                return f"{predicate.title()} of {subject}: {values[0]}"
            else:
                return f"No data found for '{predicate}' of '{subject}'."
    

    def _transform_input(self, input_str):
        try:
            middle_part = input_str[:input_str.index("(")].replace('_', ' ')
            if '(' in input_str and ')' in input_str:
                inner_content = input_str[input_str.index('(')+1:input_str.index(')')]
                parts = inner_content.split(', ')
                if len(parts) != 2:
                    return None
                return f"{parts[0]}, {middle_part}, {parts[1]}"
            return input_str
        except Exception:
            return None

    def _handle_question(self, query):
        transformed = self._transform_input(query)
        if not transformed:
            return "Invalid question format."

        try:
            parts = [p.strip() for p in transformed.split(",")]
            if len(parts) != 3:
                return "Invalid question format."

            sub, pred, obj = parts
            df = self.ontology.get_all()

            if pred in ['pharmacology description', 'side effects']:
                return "Invalid question!"

            if pred == 'alternative brand':
                match1 = ((df['Subject'] == sub) & (df['Predicate'] == pred) & (df['Object'] == obj)).any()
                match2 = ((df['Subject'] == obj) & (df['Predicate'] == pred) & (df['Object'] == sub)).any()
                return "Yes" if match1 or match2 else "No"
            else:
                match = ((df['Subject'] == sub) & (df['Predicate'] == pred) & (df['Object'] == obj)).any()
                return "Yes" if match else "No"

        except Exception as e:
            return f"Error: {str(e)}"


    def _handle_similarity_query(self, input_str):
        try:
            b1, b2 = [x.strip() for x in input_str.split(",")]
            score = self.similarity_engine.similarity(b1, b2)
            return f"Similarity Score between '{b1}' and '{b2}': {score:.4f}"
        except Exception as e:
            return f"Error in similarity calculation: {e}"

    def _handle_distance_query(self, input_str):
        try:
            b1, b2 = [x.strip() for x in input_str.split(",")]
            score = self.similarity_engine.distance(b1, b2)
            return f"Distance Score between '{b1}' and '{b2}': {score:.4f}"
        except Exception as e:
            return f"Error in distance calculation: {e}"

    def _query_special(self, subject, predicate):
        generic = self.ontology.get_related(subject, 'generic name is')
        if not generic:
            return f"Generic name not found for {subject}."
        values = self.ontology.get_related(generic[0], predicate)
        if values:
            return f"{predicate.title()}:\n{textwrap.fill(values[0], self.terminal_width)}"
        return f"{predicate.title()} not found for {generic[0]}."


# Entry point
if __name__ == "__main__":
    root = tk.Tk()
    app = MedicineAppGUI(root, csv_path="Data/dictionary.csv")
    root.mainloop()
