# -*- coding: utf-8 -*-
"""
Created on Wed Sep  7 20:45:31 2022

@author: saifu
"""

import numpy as np
import pandas as pd
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import cross_validate



# Part b
# building decission tree and cross-validation

# load data
new_data = pd.read_csv("winequality_processed_data.csv")



# label data into features and classlabel
classLabels = new_data["quality"] 
features = new_data.drop(["quality"], axis=1)



# shuffle data and put it in random state
features = features.sample(frac=1, random_state=0)
classLabels = classLabels.sample(frac=1, random_state=0)



# verify the indices
assert all(features.index == classLabels.index)

# find index for spliting data
# using 80 percent for training 
# using 20 percent for testing
x = round(0.8 * len(new_data))



# split data for training and testing
trainFeatures = features.iloc[:x]
trainClassLabels = classLabels.iloc[:x]
testFeatures = features.iloc[x:]
testClassLabels = classLabels.iloc[x:]



# initialise decission tree algorithm to train
# initialise to a random state
tree_learner = DecisionTreeClassifier(random_state=0)
classifier = tree_learner.fit(trainFeatures, trainClassLabels)


# use the trained model to predict test data
predictions = classifier.predict(testFeatures)



# create a function to compute accuracy
def calculateAccuracy(target, predicted):
    accuracy = (predictions == target).sum()/len(target)
    return accuracy

m_accuracy = calculateAccuracy(testClassLabels, predictions)

# print results 
print(" ")
print("Accuracy report acquired by training and testing data.")
print("Data split: train- 80% and test- 20%")
print("Accuracy of the model = ", m_accuracy)
print("-----------------------------------------------------------------------------------------------------------------")
print(" ")





# cross-validation 
# load data
my_data = pd.read_csv("winequality_processed_data.csv")


# label data into features and classlabel
classLabels = my_data["quality"] 
features = my_data.drop(["quality"], axis=1)

# initialise classLabels and features to y and X
X = features 
y = classLabels


# initialise decision tee classifier
# put it into a random state
new_treelearner = DecisionTreeClassifier(random_state=1)




from sklearn.metrics import make_scorer
from custom_scorer_module import custom_confusion_matrix_score

score = {'Acc': 'accuracy', 'Roc_Auc': 'roc_auc',
         'Conf': make_scorer(custom_confusion_matrix_score)}


# initialise a 10 fold cross validation and calculate accuracy and roc_auc
evaluation_results = cross_validate(new_treelearner, X,
                                    y, cv=10, 
                                    scoring = score)



"""
# initialise a 10 fold cross validation and calculate confusion matrix
evaluation_results_cm = cross_validate(new_treelearner, X,
                                    y, cv=10,
                                    scoring= confusion_matrix_score)
"""
"""
# accuracy calculation
TP = evaluation_results_cm["test_tp"]
TN = evaluation_results_cm["test_tn"]
FP = evaluation_results_cm["test_fp"]
FN = evaluation_results_cm["test_fn"]

accuracy_cm = (TP + TN)/(TP + TN + FP + FN)

"""

mean_accuracy = evaluation_results['test_Acc'].mean()
mean_roc_auc = evaluation_results['test_Roc_Auc'].mean()

# mean_cm_accuracy = accuracy_cm.mean()



print("Cross Validation Starting Point.")
print("Performance Evaluation Results With Test Accuracy and ROC_AUC Score: ")
print(" ")
print(evaluation_results)
print(" ")
print(" ")
print(" ")
print("Performace Evaluation Results With Confusion Matrix Score:")
print(" ")
# print(evaluation_results_cm)
print(" ")
print(" ")
print(" ")
print("Confusion Matrix Summary: ")
print(" ")
# print("True positive: ", evaluation_results_cm["test_tp"])
# print("True negative: ", evaluation_results_cm["test_tn"])
# print("False positive: ", evaluation_results_cm["test_fp"])
# print("False negative: ", evaluation_results_cm["test_fn"])

print(" ")
print(" ")
print("Test accuracy calulated from confusion matrix: ")
print(" ")

# print(accuracy_cm)
print(" ")
# print(all(evaluation_results["test_accuracy"] == accuracy_cm))
print(" ")
print("Mean Performance Evaluation Results: ")
print(" ")

print("Mean:- Test Accuracy - Cross Validation With Accuracy Score: ", mean_accuracy)

print("Mean:- Test ROC_AUC - Cross Validation With ROC_AUC Score: ", mean_roc_auc)

# print("Mean:- Test Accuracy - Cross Validation With Confusion Matrix Score: ", mean_cm_accuracy)


































