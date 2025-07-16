# -*- coding: utf-8 -*-
"""
Created on Wed Sep  7 10:59:56 2022

@author: saifu
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
# building decission tree and cross-validation

# load data
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

m_accuracy = calculateAccuracy(testClassLabels, predictions)
print(" ")
print("Accuracy report acquired by training and testing data.")
print("Data split: train- 80% and test- 20%")
print("Accuracy of the model = ", m_accuracy)
print("------------------------------------------------------------------------")
print(" ")








 
"""

# print results
print("Result of cross validation:")
print("---------------------------")
print(evaluation_results)
print("------------------------------------------------------------------------")
print("------------------------------------------------------------------------")
mean_accuracy = evaluation_results['test_accuracy'].mean()
print("Mean test accuracy of cross validation: ", mean_accuracy)
mean_roc_auc = evaluation_results['test_roc_auc'].mean()
print("Mean test roc_auc of cross validation: ", mean_roc_auc)

"""



def custom_performance_eval(attributes):
    # cross-validation 
    # load data
    my_data = pd.read_csv("winequality_processed_data.csv")


    # label data into features and classlabel
    classLabels = my_data["quality"] 
    features = my_data.drop(attributes, axis=1)



    # initialise decision tee classifier
    # put it into a random state
    new_treelearner = DecisionTreeClassifier(random_state=1)


    # initialise a 10 fold cross validation and calculate accuracy and roc_auc
    evaluation_results = cross_validate(new_treelearner, X = features,
                                        y = classLabels, cv=10, 
                                        scoring=["accuracy", "roc_auc"])
    
    print("Mean Test Accuracy: ", evaluation_results['test_accuracy'].mean())
    print("Mean Test Roc_Auc: ", evaluation_results['test_roc_auc'].mean())




my_attributes = ["quality", "density"]
custom_performance_eval(my_attributes)

























































































