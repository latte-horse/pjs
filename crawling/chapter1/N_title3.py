import requests
from bs4 import BeautifulSoup

fw = open('sample.txt', 'w')
html = requests.get('https://www.naver.com/').text
soup = BeautifulSoup(html, 'html.parser')
title_list = soup.select('.PM_CL_realtimeKeyword_rolling span[class*=ah_k]')
	
for top in title_list:
	print(top.text)
    

    
fw.write

fw.close()