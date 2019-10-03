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
        String strToAnalyze = ("여자화장실서 일면식도 없는 남성 '묻지마 폭행'\r\n" + 
        		"뛰쳐나간 여성 따라가 지속해서 폭행\r\n" + 
        		"피해자 뇌진탕 증세 호소, 트라우마로 화장실 못 가\r\n" + 
        		"자료사진.사진은 기사 중 특정표현과 관계없음. [이미지출처=연합뉴스]\r\n" + 
        		"[아시아경제 한승곤 기자] 한 남성이 여자화장실에서 일면식도 없는 여성을 무차별 폭행하고 달아나 경찰이 수사에 나섰다. 여성은 온라인을 통해 피해 사실과 용의자 인상착의를 공개했다. 현재 이 여성은 전치 3주 수준의 피해를 입고 정신과 치료도 병행하고 있는 것으로 알려졌다.\r\n" + 
        		"\r\n" + 
        		"사건을 수사하고 있는 경기 일산 경찰서에 따르면 지난 22일 새벽 1시30분께 일산 마두동 한 건물 3층 여자화장실서 30대 중반 여성 A 씨가 한 화장실 칸에서 일면식도 없는 남성에게 이른바 '묻지마 폭행'을 당했다.\r\n" + 
        		"\r\n" + 
        		"A 씨는 남편과 함께 노래방에 놀러온 뒤, 잠시 화장실로 갔다가 변을 당한 것으로 알려졌다.\r\n" + 
        		"\r\n" + 
        		"A 씨에 따르면 이 남성은 A 씨가 화장실 칸에서 나오지도 못하게 막고 얼굴 등 머리를 집중적으로 폭행했다.\r\n" + 
        		"\r\n" + 
        		"A 씨는 비명 등을 지르며 도와달라고 소리쳤지만, 폭행 장소가 벌어진 3층에는 노래방이 있어 A 씨 목소리는 밖으로 들리지 않은 것으로 전해졌다.\r\n" + 
        		"\r\n" + 
        		"이 남성은 폭행을 당하다 밖으로 뛰쳐나온 여성을 계속 쫓아가 지속해서 폭행을 저지른 것으로 알려졌다.\r\n" + 
        		"\r\n" + 
        		"그러다 A 씨는 남편이 있던 노래방으로 들어가 겨우 폭행에서 벗어날 수 있었고, 피해 사실을 확인한 남편과 노래방 사장이 이 남성을 쫓으러 나왔을 때는 이미 남성은 도주하고 사라진 상태였다.\r\n" + 
        		"\r\n" + 
        		"현재 피해 여성은 당시 폭행으로 전치 3주(뇌진탕)의 진단서를 받고 정신과치료를 병행하고 있는 것으로 알려졌다.\r\n" + 
        		"\r\n" + 
        		"피해 여성은 현재 불면증과 함께, 당시 폭행 외상 후 스트레스 장애(PTSD) 등으로 집이 아닌 외부 화장실은 전혀 이용하지 못하고 있는 것으로 알려졌다.\r\n" + 
        		"\r\n" + 
        		"경찰 관계자는 \"용의자가 도주할 당시 현장에 모자를 떨어트려 이를 국립수사과학연구원에 의뢰를 맡긴 상태\"라며 \"현재 용의자 검거에 최선을 다하고 있다\"고 밝혔다.\r\n" + 
        		"\r\n" + 
        		"한승곤 기자 hsg@asiae.co.kr\r\n" + 
        		"\r\n" + 
        		"이슈 · 수원 초등생 집단폭행\r\n" + 
        		"ⓒ세계를 보는 창 경제를 보는 눈, 아시아경제(www.asiae.co.kr)");
        KomoranResult analyzeResultList = komoran.analyze(strToAnalyze);

        
        System.out.println(analyzeResultList.getNouns());
        
        
//이건 가로로 뽑는 코드
//      System.out.println(analyzeResultList.getPlainText());
     

//첫번째 명사만 뽑는 코드      
//      System.out.println(analyzeResultList.getMorphesByTags("NP", "NNP", "JKB"));


//전체 분석해서 뽑는 코드    	
//      List<Token> tokenList = analyzeResultList.getTokenList();  
//        for (Token token : tokenList) {           
//        	System.out.format("(%2d, %2d) %s/%s\n", token.getBeginIndex(), token.getEndIndex(), token.getMorph(), token.getPos());
//        }


   }
}
