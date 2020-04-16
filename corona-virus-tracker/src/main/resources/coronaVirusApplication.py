'''
Created on Mar 30, 2020

@author: Bishwajit.
'''

import requests
from bs4 import BeautifulSoup
import pandas as pd
import matplotlib.pyplot as pl


uri = "https://www.worldometers.info/coronavirus/"
req = requests.get(uri)

print(req)

html = req.text
soup = BeautifulSoup(html,'html.parser')
titleCorona = soup.title
print(titleCorona)
print(titleCorona.text)
print()

liveData = soup.find_all("div", id="maincounter-wrap")
for i in liveData:
    print(i.text)

tableBody = soup.find("tbody")
tableRows = tableBody.find_all("tr")


countries = []
totalCases = []
newCases = []
totalDeath = []
newDeath = []
totalRecovered = []

for i in tableRows:
    td = i.find_all("td")
    countries.append(td[0].text)
    totalCases.append(td[1].text)
    newCases.append(td[2].text)
    totalDeath.append(td[3].text)
    newDeath.append(td[4].text)
    totalRecovered.append(td[5].text)
    
headers = ["Countries", "Total Cases", "New Cases", "Total Death", "New Death", "Total Recovered"]
prepared_list = list(zip(countries, totalCases, newCases, totalDeath, newDeath, totalRecovered))
del prepared_list[:8]
#print(prepared_list)

dataFrames = pd.DataFrame(prepared_list, columns=headers)

dataFrames.to_csv("/Bishwajit/Corona-SprintBoot/corona-virus-tracker/src/main/resources/covid19_data.csv", index=False)
print("==========Writing to a file Done==================")

