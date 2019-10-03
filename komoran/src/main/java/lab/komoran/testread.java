package lab.komoran;

import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;


//https://docs.komoran.kr/firststep/tutorial.html 사이트 참고!!!!

public class testread  {   
	   public static void main(String[] args){
	        
		    Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
		    
		    //파일 객체 생성
	        Path path = Paths.get("C:/before/1.txt");
	        // 캐릭터셋 지정
	        Charset cs = StandardCharsets.UTF_8;
	        //파일 내용담을 리스트
	        List<String> list = new ArrayList<String>();
	        try{
	            list = Files.readAllLines(path,cs);
	        }catch(IOException e){
	            e.printStackTrace();
	        }
	        for(String readLine : list){
	            System.out.println(readLine);
	        }
	        
	        
	        String strToAnalyze = (" ");
	        KomoranResult analyzeResultList = komoran.analyze(strToAnalyze);
	        	        
	        System.out.println(analyzeResultList.getNouns());
	    }
}
