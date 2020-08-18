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


df_revised = df[0].rename(columns={"Year": "reportCardStartYear", "INDIAN Male" : "pupilsIndianMale", "INDIAN Female" : "pupilsIndianFemale", "ASIAN Male" : "pupilsAsianMale", "ASIAN Female" : "pupilsAsianFemale", "HISPANIC Male" : "pupilsHispanicMale", "HISPANIC Female" : "pupilsHispanicFemale", "BLACK Male" : "pupilsBlackMale", "BLACK Female" : "pupilsBlackFemale", "WHITE Male" : "pupilsWhiteMale", "WHITE Female" : "pupilsWhiteFemale", "PACIFIC ISLAND  Male" : "pupilsPacificIslanderMale", "PACIFIC ISLAND  Female" : "pupilsPacificIslanderFemale", "TWO OR MORE Male" : "pupilsMultiRacialMale", "TWO OR MOREFemale" : "pupilsMultiRacialFemale"})


df_revised.to_json('results.json', orient='index')
