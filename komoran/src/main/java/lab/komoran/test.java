package lab.komoran;

import java.util.List;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

//https://docs.komoran.kr/firststep/tutorial.html 사이트 참고!!!!


public class test  {

   
   public static void main(String[] args) {
       Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
        String strToAnalyze = ("NASA 수석 과학자 경고..\"코페르니쿠스적 혁명적 사고 전환 가져올 것\"\r\n" + 
              "화성 생명체 존재를 확인하게 될 마즈2020 [NASA/JPL-Caltech 제공]\r\n" + 
              "화성 생명체 존재를 확인하게 될 엑소\r\n" + 
              "(서울=연합뉴스) 엄남석 기자 = 인류는 2021년 중반께면 화성에 보낸 로버를 통해 생명체가 존재하는지에 대한 확답을 얻을 수 있지만 외계 생명체 존재가 확인됐을 때 갖는 혁명적 의미를 받아들일 준비가 아직 안 돼 있다고 미국항공우주국(NASA) 수석 과학자가 경고했다.\r\n" + 
              "\r\n" + 
              "NASA와 유럽우주국(ESA)이 나란히 발사할 화성 탐사 로버 '마즈(Mars)2020'과 '엑소마즈(ExoMars)' 프로젝트에 핵심 역할을 해온 NASA 수석과학자 짐 그린 박사는 29일 영국 선데이 텔레그래프와의 회견에서 두 로버가 생명체 탐사에 답을 해줄 최상의 기회가 될 것이라며 이런 우려를 나타냈다.\r\n" + 
              "\r\n" + 
              "두 로버는 내년 7~8월에 발사돼 마즈2020은 이듬해 2월, 엑소마즈는 3월에 화성에 도착한다. 특히 영국 화학자 로잘린드 프랭클린의 이름을 따 '로잘린드'로도 불리는 엑소마즈는 2ｍ가량 땅을 파고 샘플을 채취한 로버에 탑재된 장비로 유기물 존재 여부를 검사할 수 있다. 따라서 착륙 후 수주에서 몇 달 안에 생명체 존재 여부를 확인할 수 있다.\r\n" + 
              "\r\n" + 
              "마즈2020도 화성의 생명체 탐사를 주요임무로 하고 있어, 두 로버가 2021년 여름께 경쟁적으로 생명체 탐사결과를 보내올 것으로 기대되고 있다.\r\n" + 
              "\r\n" + 
              "기자회견 중인 그린 박사 [자료사진] [EPA=연합뉴스]\r\n" + 
              "\r\n" + 
              "기자회견 중인 그린 박사 [자료사진] [EPA=연합뉴스]\r\n" + 
              "그린 박사는 과거든 현재든 생명체 존재가 확인되면 \"혁명적일 것\"이라면서 \"코페르니쿠스가 지동설을 주장했을 때처럼 사고를 완전히 바꿔놓기 시작하겠지만 우리가 그런 결과에 준비가 돼 있다고 생각하지 않는다\"고 했다.\r\n" + 
              "\r\n" + 
              "그러면서 \"생명체를 발견하고 결과를 발표해야 할 시점에 점점 더 다가서고 있다고 생각하기 때문에 걱정하고 있다\"고 덧붙였다.\r\n" + 
              "\r\n" + 
              "NASA에서 38년간 일해온 그린 박사는 다른 행성에 작은 유기체가 존재하는 것으로 믿고 있으며, 더 나아가 토성의 위성(달) 타이탄에 '이상한 생명체'가 있을 수 있으며 멀지않은 다른 은하에 외계문명이 존재할 수 있다고 믿고있다.\r\n" + 
              "\r\n" + 
              "그린 박사는 수십억년 전 생명체가 살았을지도 모를 고대 바다 인근을 탐색하게 되는 두 로버가 \"정말로 생명체를 찾을 가능성이 있고 그러길 바라기 때문에 이번 탐사 프로젝트에 기대감을 갖고 있다\"면서 \"생명체는 환경이 극단적으로 나빠지면 바위 속으로 들어가는데 우리는 이 깊이까지 파본 적이 없다\"고 했다.\r\n" + 
              "\r\n" + 
              "그러면서 \"1990년대에 우주생물학을 시작할 때 극단적인 환경에서 사는 생물을 찾기 시작했다\"면서 \"아무것도 살 수 없을 것으로 여겨졌던 핵 오수도 생명체로 넘쳐났으며 물이 있는 곳에 생명체가 있었다\"고 덧붙였다.\r\n" + 
              "\r\n" + 
              "그린 박사는 또 화성에 로버를 안착시키는 것은 \"뉴욕에서 골프공을 쳐 로스앤젤레스(골프장)에 홀인원 시키는 것과 같다\"면서 \"NASA와 ESA는 이런 불가능한 일을 매일 하고 있으며, 항상 기적 같은 일을 수행하고 있다\"고 했다.\r\n" + 
              "\r\n" + 
              "eomns@yna.co.kr\r\n" + 
              "\r\n" + 
              "이슈 · 화성 탐사\r\n" + 
              "저작권자(c)연합뉴스. 무단전재-재배포금지마즈 궤도선과 로버 [ESA/ATG 미디어랩]");

        KomoranResult analyzeResultList = komoran.analyze(strToAnalyze);

        System.out.println(analyzeResultList.getPlainText());

        List<Token> tokenList = analyzeResultList.getTokenList();
       
       
    
       
        for (Token token : tokenList) {
           
            System.out.format("(%2d, %2d) %s/%s\n", token.getBeginIndex(), token.getEndIndex(), token.getMorph(), token.getPos());
        }


   }

}