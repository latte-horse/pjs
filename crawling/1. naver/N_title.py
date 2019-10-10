import requests
from bs4 import BeautifulSoup

html = requests.get('https://www.naver.com/').text
soup = BeautifulSoup(html, 'html.parser')
title_list = soup.select('.PM_CL_realtimeKeyword_rolling span[class*=ah_k]')

#print(title_list)

info = []

for a in title_list :
    info.append(a.get_text())

#print(info)

N_title = info[:10]

print(N_title)





    







