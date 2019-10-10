#!/usr/bin/python
# -*- coding: utf8-*-

import os
from datetime import datetime


daum = ["다음1", "다음2", "다음3", "다음4", "다음4"]
naver = ["네이버1", "네이버2", "네이버3", "네이버4", "네이버5"]



def make_folder(folder_name) :
    if not os.path.isdir(folder_name) :
        os.mkdir(folder_name)

datetime = datetime.now()
day = "%s%s%s" % (datetime.year, datetime.month, datetime.day)
today = day[2:8]
CurrentTime = "%s%s" % (datetime.hour, datetime.minute)

root_dir = "C:/after"
day_dir = root_dir + "/" + today
time_dir = day_dir + "/" + CurrentTime

make_folder(day_dir)
make_folder(time_dir)

for i in range(len(daum)) :       
    key_dir ="D_K_%02d" % (i+1)
    make_folder(time_dir + "/" + key_dir)

for i in range(len(naver)) :       
    key_dir ="N_K_%02d" % (i+1)
    make_folder(time_dir + "/" + key_dir)
