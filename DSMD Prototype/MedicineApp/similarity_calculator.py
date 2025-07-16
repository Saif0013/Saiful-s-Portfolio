import math

class SimilarityCalculator:
    def __init__(self, ontology_df):
        self.df = ontology_df

    def _build_ontology(self, b1, b2):
        ontology = {}
        triples = self.df[((self.df['Subject'] == b1) | (self.df['Subject'] == b2)) &
                          (self.df['Predicate'] != 'alternative brand')]
        for _, row in triples.iterrows():
            subject = row['Subject']
            if subject not in ontology:
                ontology[subject] = {'ancestors': [], 'associations': []}
            if row['Predicate'] == 'generic name is':
                ontology[subject]['ancestors'].append(row['Object'])
            else:
                ontology[subject]['associations'].append(row['Object'])
        return ontology

    def pca(self, b1, b2, ontology):
        a1 = set(ontology[b1]['ancestors'])
        a2 = set(ontology[b2]['ancestors'])
        return len(a1 & a2) / len(a1 | a2) if a1 | a2 else 0

    def pcas(self, b1, b2, ontology):
        a1 = set(ontology[b1]['associations'])
        a2 = set(ontology[b2]['associations'])
        return len(a1 & a2) / len(a1 | a2) if a1 | a2 else 0

    def pbas(self, b1, b2, ontology):
        return self.pcas(b1, b2, ontology)  # same logic for now

    def similarity(self, b1, b2, f_ca=0.5, f_cas=0.5):
        ontology = self._build_ontology(b1, b2)
        return f_ca * self.pca(b1, b2, ontology) + f_cas * self.pcas(b1, b2, ontology)

    def distance(self, b1, b2, w_ca=1.0, w_cas=1.0, w_ab=1.0):
        ontology = self._build_ontology(b1, b2)
        pca_val = self.pca(b1, b2, ontology)
        pcas_val = self.pcas(b1, b2, ontology)
        pbas_val = self.pbas(b1, b2, ontology)

        distance = 0
        if pca_val: distance += w_ca * math.log(1 / pca_val)
        if pcas_val: distance += w_cas * math.log(1 / pcas_val)
        distance += w_ab * pbas_val
        return distance
