---

```markdown
# 🧠 Domain Specific Medicine Dictionary (DSMD)

**DSMD** is an intelligent, ontology-driven application for retrieving structured medicine information, answering factual queries, and measuring semantic similarity between brands. It was developed as part of a Master's thesis and is intended for use in healthcare, education, and intelligent AI systems.

---

## 📁 Project Structure

```

NewDic/
├── app.py                        # Entry point of the application
├── MedicineApp/                 # Main application package
│   ├── **init**.py              # Marks the folder as a Python package
│   ├── gui.py                   # Tkinter GUI interface
│   ├── medicine\_ontology.py     # Ontology graph builder
│   ├── medicine\_query\_engine.py # Query engine for search & reasoning
│   ├── similarity\_calculator.py # PCA, PCAS, PBAS & distance metrics
│   └── Data/
│       └── dictionary.csv       # Core medicine knowledge graph (CSV)

```

---

## 📖 About

The **Domain Specific Medicine Dictionary (DSMD)** enables users to:

- Retrieve detailed attributes of medicine brands (type, dosage, strength, etc.)
- Explore alternative medicine brands
- Fetch pharmacological or side-effect descriptions of generics
- Ask fact-based questions and get “Yes” or “No” answers
- Calculate **similarity scores** and **semantic distances** between two brands based on ontology reasoning

---

## 🔍 Key Features

### Information Retrieval
Query brand names directly or with a specific attribute, e.g.:
```

A-Care
A-Care, generic name is

```

### Question Answering
Ask structured true/false questions like:
```

type\_of(A-Care, allopathic)
alternative\_brand(Xinc OT, Zinoret)

```

### Similarity Score
Calculate semantic similarity (0 to 1) between two brands:
```

similarity: A-Cal DX, A-Calm

```

### Distance Score
Get structural/semantic difference between brands:
```

distance: A-Cal DX, A-Calm

````

---

##  How to Use

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/DSMD.git
   cd DSMD/NewDic
````

2. **Install requirements**:

   ```bash
   pip install -r requirements.txt
   ```

3. **Run the application**:

   ```bash
   python app.py
   ```

---

## 🧪 Example Queries

| Input                                  | Description                       |
| -------------------------------------- | --------------------------------- |
| `A-Care`                               | Full information about A-Care     |
| `A-Care, generic name is`              | Shows the generic of A-Care       |
| `A-Care, alternative brand`            | Shows alternative brands          |
| `A-Care, pharmacology description`     | Description of the generic        |
| `type_of(A-Care, allopathic)`          | Returns Yes or No                 |
| `alternative_brand(ZincFast, Zinoret)` | Returns Yes or No                 |
| `similarity: A-Cal DX, A-Calm`         | Returns similarity score (0 to 1) |
| `distance: A-Cal DX, A-Calm`           | Returns semantic distance score   |

---

## 📦 Requirements

* Python 3.7 or higher

Install Python package:

```bash
pip install pandas
```

> `tkinter`, `ttk`, `shutil`, and `textwrap` are included in the standard Python distribution.

---

## 📄 License

📘 *This project was developed as part of a Master's thesis and is provided for academic and reference use only.*

---

##  Contact

If you find this project helpful or plan to use it, feel free to cite the original thesis or reach out for collaboration opportunities. Contributions and improvements are welcome!

---



