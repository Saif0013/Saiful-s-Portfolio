import pandas as pd
import matplotlib.pyplot as plt
from sklearn.neural_network import MLPClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import classification_report,confusion_matrix, accuracy_score
from sklearn.preprocessing import StandardScaler

# Data loading
iris = pd.read_csv('iris.csv')
features = iris.drop('variety',axis=1)
labels = iris['variety']

# Splitting Data
X_train, X_test, y_train, y_test = train_test_split(features, labels)


"""
scaler = StandardScaler()
#StandardScaler(copy=True, with_mean=True, with_std=True)
X_train = scaler.fit_transform(X_train)
X_test = scaler.fit_transform(X_test)
"""

# Exercise 1
mlp = MLPClassifier(hidden_layer_sizes=(10)) # Initialise the algorithm
mlp.fit(X_train, y_train) # Train the algorithm
predictions = mlp.predict(X_test) # Make predictions

# Compute performance metrics
print("Accuracy =", accuracy_score(y_test, predictions))
print(confusion_matrix(y_test, predictions))
print(classification_report(y_test,predictions))

# Exercise 2
mlp2 = MLPClassifier(hidden_layer_sizes=(5,5),solver="sgd", 
                     max_iter=500, verbose=True) # Initialise the algorithm
mlp2.fit(X_train, y_train) # Train the algorithm

predictions = mlp2.predict(X_test) # Make predictions
print("Accuracy =", accuracy_score(y_test, predictions))

"""
Plotting the loss curve
"""
lossPerIteration = mlp2.loss_curve_ #model loss curve
plt.figure(dpi=125)
plt.plot(lossPerIteration)
plt.title("Loss curve")
plt.xlabel("Number of iterations")
plt.ylabel("Training Loss")
plt.show()

"""
Exercise 3 
"""
def plotLossCurves():
    learningRates = [0.001, 0.01, 0.1, 0.5, 1, 3]
    for rate in learningRates:
        # Initialise the algorithm
        mlp = MLPClassifier(hidden_layer_sizes=(10,10),
                            learning_rate_init=rate)
        mlp.fit(X_train, y_train) # Train the algorithm
        predictions = mlp.predict(X_test) # Make predictions
    
        print("Accuracy =", accuracy_score(y_test, predictions))
    
        """
        Plotting the loss curve
        """
        lossPerIteration = mlp.loss_curve_
        plt.figure(dpi=125)
        plt.plot(lossPerIteration)
        plt.title("Loss curve for learningRate ="+ str(rate))
        plt.xlabel("Number of iterations")
        plt.ylabel("Training Loss")
        plt.show()
        
    pass

plotLossCurves()