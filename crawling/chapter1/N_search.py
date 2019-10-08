import requests
from bs4 import BeautifulSoup


# urlf = "https://search.naver.com/search.naver?&where=news&query=" #고정값
# urls = "조국"
# urlt = "&start=" #고정값
# urlf = "1" 


# params = {
#     'query': '조국',
#     'where': 'post',
 
# }
 
# response = requests.get(url, params=params)
# html = response.text
 
# #뷰티풀소프의 인자값 지정
# soup = BeautifulSoup(html, 'html.parser')
 
# #쪼개기
# title_list = soup.select('.sh_blog_title')
 
# for tag in title_list:
#     print(tag.text)

for page in range(3):
    raw = requests.get('https://search.naver.com/search.naver?&where=news&query=조국&start=' + str(page * 10 + 1), headers={'User-Agent': 'Mozilla/5.0'}).text
    html = BeautifulSoup(raw, 'html.parser')
    articles = html.select('.type01 > li')

    for article in articles:
        journal = article.select_one('span._sp_each_source').text
        title = article.select_one('a._sp_each_title').text

        print(title)
