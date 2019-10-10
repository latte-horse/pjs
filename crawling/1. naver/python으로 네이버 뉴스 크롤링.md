### python으로 네이버 뉴스 크롤링

1. OS : 윈도우 // 아직 VMware가 제대로 안돌아간다... 리눅스 환경 구성 실패로...

2. python 설치

3. python에 필요한 라이브러리 설치

4. 라이브러리 설치를 위한 pip

   pip을 이용해서 python shell실행 전 설치해야될 것들이 있다.

   

5. cmd창 > 

   5-1. pip install requests

   5-2. pip install  BeautifulSoup4

6. python shell 실행

7. import하기

   

### 네이버 실시간 검색어 전체 가져와서 보여주는 중

```python
import requests
from bs4 import BeautifulSoup

html = requests.get('https://www.naver.com/').text
soup = BeautifulSoup(html, 'html.parser')
title_list = soup.select('.PM_CL_realtimeKeyword_rolling span[class*=ah_k]')
	
for top in title_list:
	print(top.text)
```



#### 아직 가져온 소스를 어떻게 저장할 것인가가 문제다.. console 프린트로만 되니


```python
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
```


