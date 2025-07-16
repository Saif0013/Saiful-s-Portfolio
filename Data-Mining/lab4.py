# -*- coding: utf-8 -*-
"""
@author: CSE5DMI Lab Tutor
"""

import pandas as pd

df = pd.read_csv("US.csv")

"""
Task 1: Data cleaning (i)
Deleting missing tuples
"""
missingWorkclass = pd.isna(df["Workclass"])
missingOccupation = pd.isna(df["Occupation"])
missingIndices = df[missingWorkclass | missingOccupation].index

df = df.drop(missingIndices, axis=0)

"""
Task 1 (ii):
Replace the missing country values with the most popular country
"""

mostPopularCountry = pd.value_counts(df["Native country"]).index[0]
missingCountries = pd.isna(df["Native country"])
df["Native country"].where(~ missingCountries, mostPopularCountry, inplace=True)

"""
Alternative solution similar to numpy arrays
Finding the indices of only the missing countries and replacing them with the 
most popular country.
"""
#missingCountriesIndices = df[missingCountries].index
#df["Native country"].loc[missingCountriesIndices] = mostPopularCountry


"""
Task 1 (iii):
Replace the missing working hours per week values with its mean value
"""

meanWorkingHoursPerWeek = round(df["Working hours per week"].mean())
missingWorkingHours = pd.isna(df["Working hours per week"])
df["Working hours per week"].where(~ missingWorkingHours, 
                                  meanWorkingHoursPerWeek, inplace=True)


"""
Task 2: Keep only important attributes:
We can simply delete the unwanted columns

Have a look at the column names by using df.columns
"""
unwantedColumns = ["Final sampling weight", "Years of education",
                 "Capital gain", "Capital loss"]

df.drop(unwantedColumns, axis=1, inplace=True)

"""
Alternate solution: instead of using df.drop
"""
#for column in unwantedColumns:
#    del(df[column])
    
"""
Task 3: Data Transformation
Sub task (i)
"""

predictedIncome = df['Predicted income']

def transformIncome(income):
    if income =="<=50K":
        income = 1
    else:
        income = 2
    return income


transfomedPredictedIncomes = []
for income in df["Predicted income"]:
    newIncome = transformIncome(income)
    transfomedPredictedIncomes.append(newIncome)

df["Predicted income"] = transfomedPredictedIncomes


"""
Task 3: Data Transformation
Sub task (ii)
"""
def transformAgeToGroup(age):
    if age < 20:
        ageGroup = "<20"
    elif 20<= age <=29:
        ageGroup = "20-29"
    elif 30 <= age <=39:
        ageGroup = "30-39"
    elif 40 <= age <= 49:
        ageGroup = "40-49"
    elif 50 <= age <= 59:
        ageGroup = "50-59"
    else:
        ageGroup = ">=60"
    
    return ageGroup

ageGroup = []
for age in df["Age"]:
    group = transformAgeToGroup(age)
    ageGroup.append(group)

df["Age Group"] = ageGroup


"""
Alternative solution to task 3: Instead of writing loops just use DataFrame.apply() method.
"""
#df["Predicted income"] = df["Predicted income"].apply(transformIncome)
#df["Age Group"] = df["Age"].apply(transformAgeToGroup)

df.to_csv('US_census_preprocessed.csv', index=False)