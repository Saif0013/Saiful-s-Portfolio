import pandas as pd

class MedicineOntology:
    def __init__(self, csv_path):
        self.column_names = ['Subject', 'Predicate', 'Object']
        self.df = pd.read_csv(csv_path, names=self.column_names)

    def get_triples(self, subject=None, predicate=None):
        df = self.df
        if subject:
            df = df[df['Subject'] == subject]
        if predicate:
            df = df[df['Predicate'] == predicate]
        return df

    def get_related(self, subject, predicate):
        df = self.get_triples(subject=subject, predicate=predicate)
        return df['Object'].tolist()

    def get_all(self):
        return self.df
