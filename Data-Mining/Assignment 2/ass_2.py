# -*- coding: utf-8 -*-
"""
Created on Sun Oct 16 09:52:58 2022

@author: Md Saiful Islam
Student Id: 18882762

"""


# Part I
# 1.
# Data preprocessing 
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.neural_network import MLPClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import classification_report,confusion_matrix, accuracy_score
from sklearn.preprocessing import StandardScaler


# import data 
data = pd.read_csv("USAUniSubject.csv")


# find missing value columns 
# data.isna().sum() 
# the above command allows us to find.. 
# missing value in any column
# missing value column  number of rows
# HSGPA                    448
# LAST_ACT_ENGL_SCORE     1001
# LAST_ACT_MATH_SCORE     1004
# LAST_ACT_READ_SCORE     1111
# LAST_ACT_SCIRE_SCORE    1114
# LAST_ACT_COMP_SCORE     1001


# identify missing value rows for HSGPA
m_hsgpa = pd.isna(data["HSGPA"])

# identify missing value rows for LAST_ACT_ENGL_SCORE
m_eng = pd.isna(data["LAST_ACT_ENGL_SCORE"])

# identify missing value rows for LAST_ACT_MATH_SCORE
m_math = pd.isna(data["LAST_ACT_MATH_SCORE"])

# identify missing value rows for LAST_ACT_READ_SCORE
m_read = pd.isna(data["LAST_ACT_READ_SCORE"])

# identify missing value rows for LAST_ACT_SCIRE_SCORE
m_scire = pd.isna(data["LAST_ACT_SCIRE_SCORE"])

# identify missing value rows for LAST_ACT_COMP_SCORE
m_comp = pd.isna(data["LAST_ACT_COMP_SCORE"])


# replace missing values with mean values of each column
# calculate mean value for hsgpa
# most of the value in hsgpa column..
# has 1 or 2 decimal place.. that's why
# rounded the mean to 2 decimal place
avg_hsgpa = round(data["HSGPA"].mean(), 2)

# calculate mean value for LAST_ACT_ENGL_SCORE 
avg_eng = round(data["LAST_ACT_ENGL_SCORE"].mean())

# calculate mean value for LAST_ACT_ENGL_SCORE 
avg_math = round(data["LAST_ACT_MATH_SCORE"].mean())

# calculate mean value for LAST_ACT_READ_SCORE 
avg_read = round(data["LAST_ACT_READ_SCORE"].mean())

# calculate mean value for LAST_ACT_SCIRE_SCORE
avg_scire = round(data["LAST_ACT_SCIRE_SCORE"].mean())

# calculate mean value for LAST_ACT_COMP_SCORE
avg_comp = round(data["LAST_ACT_COMP_SCORE"].mean())


# update missing value for hsgpa
data["HSGPA"].where(~ m_hsgpa, avg_hsgpa,
                    inplace=True)

# update missing value for LAST_ACT_ENGL_SCORE 
data["LAST_ACT_ENGL_SCORE"].where(~ m_eng, avg_eng,
                    inplace=True)

# update missing value for LAST_ACT_MATH_SCORE 
data["LAST_ACT_MATH_SCORE"].where(~ m_math, avg_math,
                    inplace=True)

# update missing value for LAST_ACT_READ_SCORE 
data["LAST_ACT_READ_SCORE"].where(~ m_read, avg_read,
                    inplace=True)

# update missing value for LAST_ACT_SCIRE_SCORE 
data["LAST_ACT_SCIRE_SCORE"].where(~ m_scire, avg_scire,
                    inplace=True)

# update missing value for LAST_ACT_COMP_SCORE 
data["LAST_ACT_COMP_SCORE"].where(~ m_comp, avg_comp,
                    inplace=True)


# categorical variable cannot be used..
# for mlp classification
# drop SEX attribute
data = data.drop("SEX", axis=1)

# export data to a new csv file
data.to_csv("USAUniSubjectProcessed.csv", index=False)




# 2.
# Create NN Classifier

# load data
my_data = pd.read_csv("USAUniSubjectProcessed.csv")

# data preparation
# divide features and classLabels
classLabels = my_data["At_Risk"]
features = my_data.drop("At_Risk", axis=1)

# assign features and classLabels
X = features
Y = classLabels 

# use the sklearn train test algorithm
# train and test ratio 75% to 25%
X_train,X_test,Y_train,Y_test = train_test_split(X,Y, test_size=0.25,
                                                 random_state=0)

# Initialise scaler
scaler = StandardScaler()
# Standardise train data
X_train = scaler.fit_transform(X_train)
# Standardise test data
X_test = scaler.fit_transform(X_test)

# Initialise the algorithm
# used default learning rate as 0.001
# optimizer adam 
# 1 layer with 10 neurons
mlp = MLPClassifier(hidden_layer_sizes=(10), max_iter=1500,
                            solver="adam", verbose=True,
                            random_state=0)

       
# Train the algorithm
mlp.fit(X_train,Y_train) 
# Make predictions
predictions = mlp.predict(X_test)

# cost matrix is similar to confusion matrix
# using confusion matrix to custom made cost matrix
# function to calculate cost matrix
def cost_matrix(y, y_pred):
    cm = confusion_matrix(y, y_pred)
    return {'tn': cm[0, 0], 'fp': cm[0, 1],
            'fn': cm[1, 0], 'tp': cm[1, 1]}

# calculate cost_matrix
CostMatrix = cost_matrix(Y_test, predictions)

# Identify results from cost matrix
FN = CostMatrix['fn']
FP = CostMatrix['fp']
TP = CostMatrix['tp']
TN = CostMatrix['tn']

# Accuracy from Cost matrix in percentage
accuracy_costmatrix = round((TP+TN)/(TP+TN+FP+FN)*100, 2)

# Cost from cost matrix
cost = (TP*(-1))+(FN*100)+(FP*1)+(TN*0) 

# Calculate accuracy score
accuracy = accuracy_score(Y_test, predictions)

# Confusion matrix
ConfMatrix = confusion_matrix(Y_test, predictions)

# Calculate sensitivity
sensitivity = TP/(TP+FN)

# Calculate specificity
specificity = TN/(FP+TN)

# Classification report 
ClassReport = classification_report(Y_test,predictions)

# Compute Results
print("Accuracy From Cost Matrix = ", accuracy_costmatrix)
print("Cost Calculated From Cost Matrix = ", cost)

print(" ")
print(" ")
print("Accuracy Score = ", accuracy)
print("Confusion Matrix: ")
print(ConfMatrix)

print(" ")
print("Sensitivity Score = ", sensitivity)
print("Specificity Score = ", specificity)
 
print(" ")
print("Classification Report: ")
print(ClassReport)

# Plotting the loss curve
#model loss curve
lossPerIteration = mlp.loss_curve_ 
plt.figure(dpi=125)
plt.plot(lossPerIteration)
plt.title("Loss curve")
plt.xlabel("Number of iterations")
plt.ylabel("Training Loss")
plt.show()




# To fine tune I have used the following code
# I have put it in multiline comment..
# so that the program output stay short

"""
def train_test_mlp(neuron, layer, maxiter, solver):
    # Initialise the algorithm
    mlp2 = MLPClassifier(hidden_layer_sizes=(neuron, layer), max_iter=maxiter,
                            solver=solver, verbose=True)
                            
        
    # Train the algorithm
    mlp2.fit(X_train,Y_train) 
    # Make predictions
    predictions = mlp2.predict(X_test)
        
    # Compute performance metrics
    print("Accuracy =", accuracy_score(Y_test, predictions))
    print(confusion_matrix(Y_test, predictions))
    print(classification_report(Y_test,predictions))
    
   
train_test_mlp(10,1, 1000, "adam")
train_test_mlp(10,2, 1000, "adam")
train_test_mlp(5,5, 1000, "sgd")
train_test_mlp(10, 1, 1500, "sgd")


# tested learning rate and loss curve
def plotLossCurves():
    learningRates = [0.001, 0.01, 0.1, 0.5, 1, 3]
    for rate in learningRates:
        # Initialise the algorithm
        mlp = MLPClassifier(hidden_layer_sizes=(10,10),
                            learning_rate_init=rate, verbose=True)
        mlp.fit(X_train, Y_train) # Train the algorithm
        predictions = mlp.predict(X_test) # Make predictions
    
        print("Accuracy =", accuracy_score(Y_test, predictions))
    
        
        # Plotting the loss curve
        
        lossPerIteration = mlp.loss_curve_
        plt.figure(dpi=125)
        plt.plot(lossPerIteration)
        plt.title("Loss curve for learningRate ="+ str(rate))
        plt.xlabel("Number of iterations")
        plt.ylabel("Training Loss")
        plt.show()
        
    pass

plotLossCurves()

"""





# Part II
# a.

import numpy as np
import pandas as pd
from sklearn.cluster import KMeans

# load data 
io_data = pd.read_csv("ionoshpere.csv")

# Identify features and classLabels
features = io_data.drop("y", axis=1)
classLabels = io_data["y"]

# Initialising the algorithm
kmeans_estimator = KMeans(n_clusters=2, random_state=0)
k_clusters = kmeans_estimator.fit(features)

# cluster labels
clusters = k_clusters.labels_


# b.
# count class labels 

# find the indexes of cluster 0
zero_ind = features[clusters == 0].index 

# find the indexes of cluster 1
one_ind = features[clusters == 1].index 

# identify cluster 0 inside target variable
cluster_0 = classLabels[zero_ind]

# identify cluster 1 inside target variable
cluster_1 = classLabels[one_ind] 

# count y="b" in cluster 0
cluster_0_b = (cluster_0 == "b").sum()

# count y="g" in cluster 0
cluster_0_g = (cluster_0 == "g").sum()

# count y="b" in cluster 1
cluster_1_b = (cluster_1 == "b").sum()

# count y="g" in cluster 1
cluster_1_g = (cluster_1 == "g").sum()

# Print the results on the screen
print("Cluster 0 y=b total: " ,cluster_0_b)
print("Cluster 0 y=g total: " ,cluster_0_g)
print("Cluster 1 y=b total: " ,cluster_1_b)
print("Cluster 1 y=g total: " ,cluster_1_g)
















