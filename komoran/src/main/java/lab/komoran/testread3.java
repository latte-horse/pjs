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
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;



public class testread3  {   
	   public static void main(String[] args) throws IOException {	        
		    
		    
//		    //파일 객체 생성
//	        Path path = Paths.get("C:/before/1.txt");
//	        //캐릭터셋 지정
//	        Charset cs = StandardCharsets.UTF_8;	        
//	        //파일 내용담을 리스트
//	        List<String> list = new ArrayList<String>();
//	        try{
//	            list = Files.readAllLines(path,cs);
//	        }catch(IOException e){
//	            e.printStackTrace();
//	        }
	        
		   
	        
//	        try {
//	 	       // 바이트 단위로 파일읽기
//	 	        String filePath = "C:/before/1.txt"; // 대상 파일
//	 	        FileInputStream fileStream = null; // 파일 스트림	 	        
//	 	        fileStream = new FileInputStream( filePath );// 파일 스트림 생성
//	 	        
//	 	        //버퍼 선언
//	 	        byte[ ] readBuffer = new byte[fileStream.available()];
//	 	        while (fileStream.read( readBuffer ) != -1){}
////	 	        System.out.println(new String(readBuffer)); //출력
//
//	 	        fileStream.close(); //스트림 닫기
//	 	    } catch (Exception e) {
//	 	    	e.getStackTrace();
//	 	    }
	     
		   
		   
		   
	        Files.walk(Paths.get("C:/before")).forEach(filePath -> {
	            if (Files.isRegularFile(filePath)) {
//	    	        //캐릭터셋 지정
	    	        Charset cs = StandardCharsets.UTF_8;	        
//	    	        //파일 내용담을 리스트
	    	        List<String> list = new ArrayList<String>();
	    	        try{
	    	            list = Files.readAllLines(filePath,cs);
	    	        }catch(IOException e){
	    	            e.printStackTrace();
	    	        }
//	                System.out.println(filePath);
	                System.out.println(list);
	                
	                
	                
	    	        //sample파일의 경우 input전에 띄어쓰기나 줄바꿈 등이 불규칙적으로 있기 때문에 우선 규칙적으로 정렬된 리스트 객체를 만듬. 
	    	        //리스트객체의 내용을 하나의 문자열로 붙여서 만들어줌
	    	        String listTap = String.join(" ", list);
//	    	        System.out.println(listTap);        
	    	        	        
	    	        //문자열로 된 listTap의 내용을 komoran으로 분석해야한다.
	    	        //KomoranResult의 경우 list형식.
	    	        //KomoranResult 변수명 = 코모란변수명.analyze(분석할객체)      
	    	        Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
	    	        KomoranResult analyzeResultList = komoran.analyze(listTap);
	    	        List<String> listNo =  analyzeResultList.getNouns();
//	    	        System.out.println(listNo);
	    	        
	    	        //리스트객체의 내용을 하나의 문자열로 붙여서 만들어줌(중간에 탭을 기준으로)
	    	        String message = String.join("\t", listNo);
	    	        System.out.println(message);
	    	        
	    	        
	        
	            }
	                
	        });
	        
	        
	   
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
//	        //sample파일의 경우 input전에 띄어쓰기나 줄바꿈 등이 불규칙적으로 있기 때문에 우선 규칙적으로 정렬된 리스트 객체를 만듬. 
//	        //리스트객체의 내용을 하나의 문자열로 붙여서 만들어줌
//	        String listTap = String.join(" ", list);
////	        System.out.println(listTap);        
//	        	        
//	        //문자열로 된 listTap의 내용을 komoran으로 분석해야한다.
//	        //KomoranResult의 경우 list형식.
//	        //KomoranResult 변수명 = 코모란변수명.analyze(분석할객체)      
//	        Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
//	        KomoranResult analyzeResultList = komoran.analyze(listTap);
//	        List<String> listNo =  analyzeResultList.getNouns();
////	        System.out.println(listNo);
//	        
//	        //리스트객체의 내용을 하나의 문자열로 붙여서 만들어줌(중간에 탭을 기준으로)
//	        String message = String.join("\t", listNo);
//	        System.out.println(message);
	        
	        
//	        BufferedOutputStream bs = null;
//	    	try {
//	    		bs = new BufferedOutputStream(new FileOutputStream("C:/after/Output.txt"));
//	    		bs.write(message.getBytes()); //Byte형으로만 넣을 수 있음
//	    	} catch (Exception e) {
//	    		e.getStackTrace();
//	    	}finally {
//	    		bs.close(); //반드시 닫는다.
//	    	} 
	     
	        

	    }
}