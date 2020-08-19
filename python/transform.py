# -*- coding: utf-8 -*-
import json
import sys
from bs4 import BeautifulSoup
import numpy as np
import pandas as pd
import os

with open('Pupils_by_Race_and_Sex.xls', 'r') as f:
    contents = f.read()

soup = BeautifulSoup(contents, 'lxml')

df = pd.read_html(str(soup), keep_default_na=False, header=0)

## Read_html places everything under a single array, so we rework the dataframe to look/work at the top level normally, and rework the naming conventions
df = df[0].rename(columns={"Year": "reportCardStartYear","____LEA Name____" : "agency", "INDIAN Male" : "pupilsIndianMale", "INDIAN Female" : "pupilsIndianFemale", "ASIAN Male" : "pupilsAsianMale", "ASIAN Female" : "pupilsAsianFemale", "HISPANIC Male" : "pupilsHispanicMale", "HISPANIC Female" : "pupilsHispanicFemale", "BLACK Male" : "pupilsBlackMale", "BLACK Female" : "pupilsBlackFemale", "WHITE Male" : "pupilsWhiteMale", "WHITE Female" : "pupilsWhiteFemale", "PACIFIC ISLAND\u00a0 Male" : "pupilsPacificIslanderMale", "PACIFIC ISLAND\u00a0 Female" : "pupilsPacificIslanderFemale", "TWO OR MORE Male" : "pupilsMultiRacialMale", "TWO OR MOREFemale" : "pupilsMultiRacialFemale"})
df.insert(1, "pk", df["reportCardStartYear"]+df["LEA"] )

saves_array = [ "pupilsIndianFemale", "reportCardStartYear", "pupilsPacificIslanderMale", "pupilsWhiteFemale", "inheritPk", "pupilsHispanicFemale", "pupilsAsianFemale", "pupilsHispanicMale", "pupilsBlackMale", "userId", "pupilsMultiRacialMale", "pupilsIndianMale", "pupilsWhiteMale", "pupilsMultiRacialFemale", "pupilsBlackFemale", "pupilsTotal", "pupilsAsianMale", "pupilsPacificIslanderFemale", "countyKey" ]


results = df.to_json( orient='index')
python_dict = json.loads(results)



final_result = { "list": [] }
for i in python_dict:
    final_result["list"].append(python_dict[i])

for i in final_result["list"]:
    i.update({"saves" : saves_array})

with open('results.json', 'w') as json_file:
  json.dump(final_result, json_file, indent=4)



