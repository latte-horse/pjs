#!/usr/bin/python
#-*- coding: utf-8 -*-
import requests
from bs4 import BeautifulSoup

########### 검색어 가져오기 ######################################
html = requests.get('https://www.naver.com/').text
soup = BeautifulSoup(html, 'html.parser')
title_list = soup.select('.PM_CL_realtimeKeyword_rolling span[class*=ah_k]')
#print(title_list)

######### 검색어 10개로 해서 배열에 넣기 ##########################
info = []
for a in title_list :
    info.append(a.get_text())
#print(info)
N_title = info[:10]
#print(N_title)

############ 검색어30개로 새로운 배열로 우선 만들기 ###############
a = ['가', '나'] #다른검색어 가져왔다는 예
b = ['다', '라']
# ##각 배열들 가져와서 하나의 배열로 만들어야됨
total_title = N_title + a + b
#print(total_title)

# ############ 검색어30개로 뉴스검색하기 ##########################
import os
import sys
import urllib.request
client_id = "AcSs8vk1vXfmzpFkSX4h"
client_secret = "WBwj2IuI0D"

# bust = []

# for c in total_title :
    




encText = urllib.parse.quote("조국")
url = "https://openapi.naver.com/v1/search/news?query=" + encText + "&display=1&start=1&sort=sim" # json결과

request = urllib.request.Request(url)
request.add_header("X-Naver-Client-Id",client_id)
request.add_header("X-Naver-Client-Secret",client_secret)
response = urllib.request.urlopen(request)
rescode = response.getcode()
if(rescode==200):
    response_body = response.read()
    print(response_body.decode('utf-8'))
    file = open('C:/after/output.json','w')
    file.write(response_body.decode('utf-8'))
    file.close()
else:
    print("Error Code:" + rescode)