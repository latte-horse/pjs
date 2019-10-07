package lab.komoran;

import java.util.List;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;

public class komoranWansung  {   
	   public static void main(String[] args) throws IOException {	        
		   Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);  //komoran선언	   
		   Stream<Path> stream_paths = Files.walk(Paths.get("C:/before"));  //폴더내 파일 다 읽기 위한 Files.walk
		   List<String> list = new ArrayList<String>();  //파일들 담을 list선언
		   Iterator<Path> paths = stream_paths.iterator();  //담은애들 읽기위한 Iterator선언		   
		   BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream("C:/after/Output.txt", true)); //결과값 외부파일로 저장을 위한 버퍼선언
		   
		   while(paths.hasNext()) {  //hasNext()로 Iterator가 가르키는 위치가 맞는지 체크하고
			   Path filePath = paths.next();  //next()로 실제 이동
			   if (Files.isRegularFile(filePath)) {  //isRegularFile()로 Path가 일반파일 가르키는것이 맞는지(폴더같은게 아닌) 묻고
				   Charset cs = StandardCharsets.UTF_8;  		   	    	      
			   		
				   try{
					   list = Files.readAllLines(filePath,cs);  //Files 다 읽어와서 
			   		   String listTap = String.join(" ", list); //String.join으로 문자열화해주고 		   		  		   		  		   		  
			   		   KomoranResult analyzeResultList = komoran.analyze(listTap); //komoran분석들어가게 해주고
			   		   List<String> listNo = analyzeResultList.getNouns();  //분석되면 다시 리스트화가 된다..
			   		   String listFin = String.join("\t", listNo);  //리스트화된 분석결과를 다시 붙여주고
			   		   String listFar = listFin + "\r\n";
					   System.out.println(listFar);
		  	   		   bs.write(listFar.getBytes()); //Byte형으로만 넣을 수 있음, 파일쓰기
			   	   }catch(IOException e){
			   		   e.printStackTrace();
			   	   }finally {
//			   		   bs.close(); //반드시 닫는다. error..
			   	   }		   	  
			   	  	   bs.flush();
			   	  	   
		      }
		  }

		   
	}
}
