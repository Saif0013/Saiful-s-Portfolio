import textwrap
from shutil import get_terminal_size 
from .medicine_ontology import MedicineOntology


class MedicineQueryEngine:
    def __init__(self, ontology: MedicineOntology):
        self.ontology = ontology
        self.width = get_terminal_size().columns

    def get_brand_info(self, brand_name):
        df = self.ontology.get_all()
        info = {
            'Brand Name': brand_name,
            'generic name is': None,
            'type of': None,
            'has dosage form': None,
            'has strength of': None,
            'manufactured by': None,
            'pharmacology description': None,
            'side effects': None
        }

        rows = df[df['Subject'] == brand_name]
        for _, row in rows.iterrows():
            if row['Predicate'] in info:
                info[row['Predicate']] = row['Object']

        generic_name = info['generic name is']
        if generic_name:
            pharm_desc = self.ontology.get_related(generic_name, 'pharmacology description')
            side_eff = self.ontology.get_related(generic_name, 'side effects')
            info['pharmacology description'] = textwrap.fill(pharm_desc[0], self.width) if pharm_desc else None
            info['side effects'] = textwrap.fill(side_eff[0], self.width) if side_eff else None

        return info

    def get_alternatives(self, brand_name):
        df = self.ontology.get_all()
        alts = []
        rows = df[(df['Subject'] == brand_name) | (df['Object'] == brand_name)]
        for _, row in rows.iterrows():
            if row['Predicate'] == 'alternative brand':
                alt = row['Object'] if row['Subject'] == brand_name else row['Subject']
                alts.append(alt)
        return alts
