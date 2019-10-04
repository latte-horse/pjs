package lab.komoran;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
        String strToAnalyze = "대한민국은 민주공화국이다.";

        KomoranResult analyzeResultList = komoran.analyze(strToAnalyze);
        List<String> str = analyzeResultList.getNouns();
        String message = String.join(" ", str);
        String message2 = String.join("\t", str);

        
        
        System.out.println(str);
        System.out.println(message);
        System.out.println(message2);
        
        
        
//        List<String> str = analyzeResultList.getNouns();
//        str = str.replaceAll("[", "]");
        
//        System.out.println(analyzeResultList.getNouns());
        //System.out.format("(%2d, %2d) %s/%s\n", analyzeResultList.getNouns());
        
        

//        List<Token> tokenList = analyzeResultList.getTokenList();
//        for (Token token : tokenList) {            
//            System.out.format("(%2d, %2d) %s/%s\n", token.getBeginIndex(), token.getEndIndex(), token.getMorph(), token.getPos());
//        }

    }
}