# -*- coding: utf-8 -*-
"""
Created on Wed Sep 23 18:18:17 2020

@author: 19191600
"""

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.svm import LinearSVC
from sklearn.svm import SVC
from sklearn.model_selection import train_test_split
from sklearn.metrics import classification_report, confusion_matrix
from sklearn.metrics import accuracy_score
from sklearn.model_selection import cross_validate

"""
Task 1
"""
# Data loading
iris = pd.read_csv('iris.csv')
features = iris.drop('variety', axis=1)
labels = iris['variety']


# Splitting Data
X_train, X_test, y_train, y_test = train_test_split(features, labels, 
                                                    test_size=0.3, 
                                                    random_state=0)
"""
Task 2
"""
model = LinearSVC(random_state=0) # Initialise the algorithm
model.fit(X_train,y_train) # Train the algorithm
predictions = model.predict(X_test) # Make predictions

# Compute performance metrics
print("Accuracy =", accuracy_score(y_test, predictions))
print(confusion_matrix(y_test, predictions))
print(classification_report(y_test,predictions))

evalResults = cross_validate(model, X=features, 
                               y=labels, cv=10,
                               scoring=["accuracy"])
print("Test accuracy of each fold =", evalResults["test_accuracy"])
print("Mean accuracy =", evalResults["test_accuracy"].mean())


"""
Task 3 
""" 
miniDF = iris.loc[:, ["sepal.width","sepal.length",  "variety"]]
condition1 = miniDF["variety"] == "Setosa"
condition2 = miniDF["variety"] == "Virginica"
miniDF = miniDF[condition1 | condition2]

features = miniDF.drop('variety', axis=1)
labels = miniDF['variety']
labels = labels.apply(lambda x: 0 if x == "Setosa" else 1)
# Task 
linearSvmModel2 = LinearSVC(random_state=0) 
linearSvmModel2.fit(X=features, y=labels)

# Data Generation
area_x_min = miniDF["sepal.width"].min() - 0.2 
area_x_max = miniDF["sepal.width"].max() + 0.2 
area_y_min = miniDF["sepal.length"].min() - 0.2
area_y_max = miniDF["sepal.length"].max() + 0.2

area_x_range_vals = np.arange(area_x_min, area_x_max, 0.01)
area_y_range_vals = np.arange(area_y_min, area_y_max, 0.01)

area_pts_x, area_pts_y = np.meshgrid(area_x_range_vals, area_y_range_vals)
area_pts = np.c_[area_pts_x.flatten(), area_pts_y.flatten()]

# Model predictions on the new data
area_pts_class = linearSvmModel2.predict(area_pts)
area_pts_class = area_pts_class.reshape(area_pts_x.shape) 


plt.figure(dpi=125)
plt.pcolormesh(area_pts_x, area_pts_y, area_pts_class,cmap=plt.cm.Set3)
plt.scatter(miniDF['sepal.width'], miniDF['sepal.length'], 
            c=labels, cmap=plt.cm.Set1, edgecolors='k')
plt.xlim(area_x_min, area_x_max)
plt.ylim(area_y_min, area_y_max)
plt.xlabel('sepal width')
plt.ylabel('sepal length')
plt.title("SVM Classifier on IRIS dataset")
plt.show()


"""
Task 4
"""
def create_disc_pts(num_of_tuples, max_rad, min_rad=0):
    rad = min_rad + (max_rad - min_rad) * np.random.rand(num_of_tuples)
    ang = 2 * np.pi * np.random.rand(num_of_tuples)
    pt_x = np.multiply(rad, np.cos(ang))
    pt_y = np.multiply(rad, np.sin(ang))
    return np.c_[pt_x, pt_y]

train_disc_pts1 = create_disc_pts(75, 2)
train_disc_pts2 = create_disc_pts(75, 3.5, 2)

plt.figure(dpi=125)
plt.scatter(train_disc_pts1[:, 0], train_disc_pts1[:, 1], c='r')
plt.scatter(train_disc_pts2[:, 0], train_disc_pts2[:, 1], c='b')

bound_ang = np.arange(0, 2 * np.pi, 0.01)
plt.plot(2 * np.cos(bound_ang), 2 * np.sin(bound_ang))
plt.xlim(-4, 4)
plt.ylim(-4, 4)
plt.show()

train_disc_pts = np.append(train_disc_pts1, train_disc_pts2, axis=0)
train_disc_pt_labels = np.append(np.zeros(75), np.ones(75))


"""
Task 5
"""

nonLinearmodel3 = SVC(random_state=0) # Initialise the algorithm

evalResults = cross_validate(nonLinearmodel3, X=train_disc_pts, 
                               y=train_disc_pt_labels, cv=10,
                               scoring=["accuracy"])
print("Test accuracy of each fold =", evalResults["test_accuracy"])
print("Mean accuracy =", evalResults["test_accuracy"].mean())


"""
Bonus Task
"""
nonLinearSvmModel4 = SVC(random_state=0) # Initialise the algorithm
nonLinearSvmModel4.fit(train_disc_pts, train_disc_pt_labels) # Train the algorithm

# Generating a meshgrid and area of points
area_x_range_vals = np.arange(-3.5, 3.5, 0.01)
area_y_range_vals = np.arange(-3.5, 3.5, 0.01)
area_pts_x, area_pts_y = np.meshgrid(area_x_range_vals, area_y_range_vals)
area_pts = np.c_[area_pts_x.flatten(), area_pts_y.flatten()]

area_pts_class = nonLinearSvmModel4.predict(area_pts)
area_pts_class = area_pts_class.reshape(area_pts_x.shape)

plt.figure(dpi=125)
plt.scatter(train_disc_pts1[:, 0], train_disc_pts1[:, 1], c='r')
plt.scatter(train_disc_pts2[:, 0], train_disc_pts2[:, 1], c='b')
margin_ang = np.arange(0, 2 * np.pi, 0.01)
plt.plot(2 * np.cos(margin_ang), 2 * np.sin(margin_ang))
#plt.pcolormesh(area_pts_x, area_pts_y, area_pts_class, cmap=plt.cm.Set3)
plt.contour(area_pts_x, area_pts_y, area_pts_class, colors='k', 
            linestyles='dashed')
plt.xlim(-4, 4)
plt.ylim(-4, 4)
plt.show()
