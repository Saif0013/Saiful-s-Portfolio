# -*- coding: utf-8 -*-
"""
Created on Fri Sep  9 08:39:34 2022

@author: Md Saiful Islam
Student Id: 18882762
"""

import numpy as np
import pandas as pd
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import cross_validate
from sklearn.metrics import confusion_matrix


# Part a
# Data preprocessing 
# load data 
data = pd.read_csv("winequality-RED-v3_2022.csv")


# find missing value columns 
# data.isna().sum() 
# the above command allows us to find.. 
# missing value in any column
# There are 8 missing value for density
# and 14 missing value for chlorides 


# identify missing value rows for density
m_density = pd.isna(data["density"])


# identify missing value rows for chlorides
m_chlorides = pd.isna(data["chlorides"])


# calculate mean value for density
# most of the value in density column..
# has 5 decimal place.. that's why
# rounded the mean to 5 decimal place
average_density = round(data["density"].mean(), 5)


# calculate mean value for chlorides 
# most of the value in chlorides column..
# has 3 decimal place.. that's why
# rounded the mean to 3 decimal place
average_chlorides = round(data["chlorides"].mean(), 3) 


# update missing value for density
data["density"].where(~ m_density, average_density, 
                      inplace=True)


# update missing value for chlorides
data["chlorides"].where(~ m_chlorides, average_chlorides,
                        inplace=True)


# export data to a new csv file
data.to_csv("winequality_processed_data.csv", index=False)




# Part b
# building decision tree and cross-validation
# First I am building a decision tree, spliting data manually
# data ratio is 80% for training and 20% for testing 
# and calculating accuracy manually 
# cross validation is done in the next part using the whole dataset



# load the data saved from previous task
new_data = pd.read_csv("winequality_processed_data.csv")


# label data into features and classlabel
classLabels = new_data["quality"] 
features = new_data.drop("quality", axis=1)


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


# calculate accuracy for the decision tree model
m_accuracy = calculateAccuracy(testClassLabels, predictions)


# print results 
print(" ")
print("Accuracy Report Calculated Manually.")
print("Data split: training- 80% and testing- 20%")
print("Accuracy of the model = ", m_accuracy)
print("--------------------------------------------------------------------------------------")
print("--------------------------------------------------------------------------------------")
print(" ")






# Cross-Validation using the whole dataset
# Performance Evaluation with confusion matrix, 
# accuracy and roc_auc


# load the exported data
my_data = pd.read_csv("winequality_processed_data.csv")


# label data into features and classlabel
classLabels = my_data["quality"] 
features = my_data.drop(["quality"], axis=1)


# initialise classLabels and features to y and X
X = features 
y = classLabels


# initialise decision tee classifier
# and put it into a random state
new_treelearner = DecisionTreeClassifier(random_state=1)


# function to calculate confusion matrix
def confusion_matrix_score(new_treelearner, X, y):
    y_pred = new_treelearner.predict(X)
    cm = confusion_matrix(y, y_pred)
    return {'tn': cm[0, 0], 'fp': cm[0, 1],
            'fn': cm[1, 0], 'tp': cm[1, 1]}


# initialise a 10 fold cross validation and calculate accuracy and roc_auc
evaluation_results = cross_validate(new_treelearner, X,
                                    y, cv=10, 
                                    scoring=["accuracy", "roc_auc"])


# initialise a 10 fold cross validation and calculate confusion matrix
evaluation_results_cm = cross_validate(new_treelearner, X,
                                    y, cv=10,
                                    scoring= confusion_matrix_score)


# Extract true positive (TP), true negative (TN), 
# false positive (FP), false negative (FN)
TP = evaluation_results_cm["test_tp"]
TN = evaluation_results_cm["test_tn"]
FP = evaluation_results_cm["test_fp"]
FN = evaluation_results_cm["test_fn"]


# Calculate accuracy from confusion matrix values
accuracy_cm = (TP + TN)/(TP + TN + FP + FN)


# Calculate the mean accuracy of 10 fold cross validation
mean_accuracy = evaluation_results['test_accuracy'].mean()


# Calculate the mean roc_auc of 10 fold cross validation
mean_roc_auc = evaluation_results['test_roc_auc'].mean()


# Calculate the mean accuracy of values 
# acquired from confusion matrix
mean_cm_accuracy = accuracy_cm.mean()


# print outputs on the screen
print("Ten Fold Cross Validation Performed On The Whole Dataset.")
print("Performance Evaluation Results With Test Accuracy and ROC_AUC Score: ")
print(" ")
print(evaluation_results)


print(" ")
print(" ")
print(" ")


print("Performace Evaluation Results With Confusion Matrix Score:")
print(" ")
print(evaluation_results_cm)


print(" ")
print(" ")
print(" ")


print("Confusion Matrix Summary: ")
print(" ")
print("True positive: ", TP)
print("True negative: ", TN)
print("False positive: ", FP)
print("False negative: ", FN)


print(" ")
print("Test Accuracy And ROC_AUC Summary: ")
print(" ")
print("Test Accuracy: ", evaluation_results['test_accuracy'])
print(" ")
print("ROC_AUC: ", evaluation_results['test_roc_auc'])


print(" ")
print(" ")


print("Mean Performance Evaluation Results Of Ten Fold Cross Validation: ")

print("Mean:- Test Accuracy Score: ", mean_accuracy)

print("Mean:- Test ROC_AUC Score: ", mean_roc_auc)
print(" ")

print("Test Accuracy Calculated Manually From Confusion Matrix Results: ")
print("Mean:- Test Accuracy: ", mean_cm_accuracy)







# Part I
# Below codes are for open discussion question
# I have tried computing mean test accuracy and test roc_auc
# by dropping different attributes

def custom_performance_eval(attributes):
    # cross-validation 
    # load data
    my_data = pd.read_csv("winequality_processed_data.csv")


    # label data into features and classlabel
    classLabels = my_data["quality"] 
    features = my_data.drop(attributes, axis=1)



    # initialise decision tee classifier
    # put it into a random state
    new_treelearner = DecisionTreeClassifier(random_state=5)


    # initialise a 10 fold cross validation and calculate accuracy and roc_auc
    evaluation_results = cross_validate(new_treelearner, X = features,
                                        y = classLabels, cv=10, 
                                        scoring=["accuracy", "roc_auc"])
    
    print("Mean Test Accuracy: ", evaluation_results['test_accuracy'].mean())
    print("Mean Test Roc_Auc: ", evaluation_results['test_roc_auc'].mean())



# Every trial consists of dropped attributes from the features
my_trial1 = ["quality", "sulphates", "citric acid"]
my_trial2 = ["quality", "density"]
my_trial3 = ["quality", "alcohol"]
my_trial4 = ["quality", "alcohol", "density"]
my_trial5 = ["quality", "chlorides"]


# print results from the trials

print(" ")
print(" ")
print("Question c:")
print("Open discussion question trial and error results: \n")
print("This trial excludes: sulphates and citric acid from the features.")
custom_performance_eval(my_trial1)

print("\nThis trial excludes: density from the features.")
custom_performance_eval(my_trial2)

print("\nThis trial excludes: alcohol from the features.")
custom_performance_eval(my_trial3)

print("\nThis trial excludes: alcohol and density from the features.")
custom_performance_eval(my_trial4)

print("\nThis trial excludes: chlorides from the features.")
custom_performance_eval(my_trial5)







































