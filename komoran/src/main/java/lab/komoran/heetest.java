package lab.komoran;


import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.interfaces.FileAccessible;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

//https://docs.komoran.kr/firststep/tutorial.html 사이트 참고!!!!
//shineware의 KOMORAN이용!!!


public class heetest  {

	
	public static void main(String[] args) {
	  
		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
		File file= new  File("C:/before"); //파일 경로 저장
		
		//파일인지 확인
		FileFilter fileFilter =new FileFilter() {
			public boolean accept(File file) {
				return file.isFile();
			}
		};
		//파일목록을 저장
		File[] tab=file.listFiles(fileFilter);
		
		//파일목록리스트 저장 할 리스트 선언
		List<String> listre=new ArrayList();
		//파일목록리스트 저장
		for (File current:tab) {
			
			String pth=file+current.getAbsolutePath();
			//System.out.println(pth); 파일명이 제대로 뽑히는지 확인
			listre.add(pth); //파일루트와+파일명을 합친것을 파일 총 경로 list에 추가한다.
			
			
	}
//		for(String re:listre) {
//			System.out.println(re);
//		} 파일명이 제대로 뽑히는지 확인!
		//파일 읽기
		//캐릭터셋 지정???
		Charset cs=StandardCharsets.UTF_8;
		//파일 본문 담을 리스트
	  List<String> listcont=new ArrayList<String>();
	 
	  int i=1;
	  PrintWriter pw=null;
	  for(String re:listre) {
		  //파일 읽기
		  Scanner scan=new Scanner(re);
		 String scanre=scan.nextLine();
		  
		 
		  KomoranResult analyzeResultList = komoran.analyze(scanre);
		  List<Token> tokenList = analyzeResultList.getTokenList();
		  
		  
		  File file1=new File("C:/after"+ i++ +".txt");
		  System.out.print(re);
		  try {
		  pw=new  PrintWriter(file1);
		  
		   if(file1.isFile() && file1.canWrite()) {
			   
			   for(Token token:tokenList) {
				   
			 
			   pw.format("(%2d, %2d) %s/%s\n", token.getBeginIndex(), token.getEndIndex(), token.getMorph(), token.getPos());
			  
			   pw.flush();
			   }
		   }
			}catch(IOException e) {
				e.printStackTrace();
			}
				 
				 
			   
		   }
		  
//			/*
//			 * for (Token token : tokenList) {
//			 * 
//			 * System.out.format("(%2d, %2d) %s/%s\n", token.getBeginIndex(),
//			 * token.getEndIndex(), token.getMorph(), token.getPos()); }
//			 */

	  }
	   
      
    
       


	}

