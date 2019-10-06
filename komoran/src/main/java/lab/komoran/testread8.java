package lab.komoran;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;



public class testread8  {   
	   public static void main(String[] args) throws IOException {	        
		 
		   
		   Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
		   
		   Stream<Path> stream_paths = Files.walk(Paths.get("C:/before"));
		   
		   
		   int[] list = new int[30];
		   Iterator<Path> paths = stream_paths.iterator();
		   
		   BufferedOutputStream bs = null;
		   bs = new BufferedOutputStream(new FileOutputStream("C:/after/Output.txt", true));
		   
		   while(paths.hasNext()) {
		      Path filePath = paths.next();
		      
		      if (Files.isRegularFile(filePath)) {
		    	  Charset cs = StandardCharsets.UTF_8;  		   	    	      
		   	  try{
		   		  for(int i=0; i<30;  i++) {
		   			list = Files.readAllLines(filePath,cs);
		   			
		   			return list;
		   		    System.out.println(list);
		   	        
		   		  }
		   	    	
		   	       
		   	        String listTap = String.join("\t", list);
//		   	        System.out.println(listTap);
			        
			        KomoranResult analyzeResultList = komoran.analyze(listTap);
			        List<String> listNo = analyzeResultList.getNouns();
			    //  System.out.println(listNo);
			        
			        String message = String.join("\t", listNo);
			        

		    		bs.write(message.getBytes()); //Byte형으로만 넣을 수 있음
//				    System.out.println(message);		    		
		    		
		    		bs.flush();
		            
		   	    }catch(IOException e){
		   	    	  e.printStackTrace();
		   	   }finally {
		   	 	//bs.close(); //반드시 닫는다.
		   	   }
		   }
		   }
		   
		   
	        
	        
	        
	        
	        
	        
	        
	        
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
//	    		bs = new BufferedOutputStream(new FileOutputStream("C:/after/Output.txt", true));
//	    		bs.write(message.getBytes()); //Byte형으로만 넣을 수 있음
//	    	} catch (Exception e) {
//	    		e.getStackTrace();
//	    	}finally {
//	    		bs.close(); //반드시 닫는다.
//	    	} 
	     
	        

	    }
}