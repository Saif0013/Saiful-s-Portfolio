import numpy as np
import pandas as pd
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import cross_validate

df = pd.read_csv("mushroom.csv")
print(df)
print(df.shape)

"""
Exercise 1
"""
def convertCategoricalData(dataframe):
    for column in dataframe.columns:
        if dataframe[column].dtype == "object":
            dataframe[column] = dataframe[column].astype("category").cat.codes
    return dataframe

df = convertCategoricalData(df)

features = df.drop("edible", axis=1)
classLabels = df["edible"]


# Splitting Training Test Datasets
features = features.sample(frac=1, random_state=0)
classLabels = classLabels.sample(frac=1, random_state=0)

#verify the indices
assert all(features.index == classLabels.index)
x= round(0.8*len(df))
trainFeatures, trainClassLabels = features.iloc[:x], classLabels.iloc[:x]
testFeatures, testClassLabels = features.iloc[x:], classLabels.iloc[x:]


treeLearner = DecisionTreeClassifier(random_state=0)
classifier = treeLearner.fit(trainFeatures, trainClassLabels)

predictions = classifier.predict(testFeatures)

def computeAccuracy(target, predicted):
    accuracy = (predictions == target).sum()/len(target)
    return accuracy

accuracy = computeAccuracy(testClassLabels, predictions)
print("Accuracy of the model =", accuracy)



'''Task 3'''
"""
Here we are doing cross validation from the scratch.
"""

df = pd.read_csv("mushroom.csv")
print(df)
print(df.shape)

def convertCategoricalData(dataframe):
    for column in dataframe.columns:
        if dataframe[column].dtype == "object":
            dataframe[column] = dataframe[column].astype("category").cat.codes
    return dataframe

df = convertCategoricalData(df)

features = df.drop("edible", axis=1)
classLabels = df["edible"]

# Cross Validation

treeLearner2 = DecisionTreeClassifier(random_state=0)
evalResults = cross_validate(treeLearner2, X=features, 
                               y=classLabels, cv=10,
                               scoring=["accuracy","roc_auc"])
print(evalResults)



