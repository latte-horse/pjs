package lab.komoran;

import java.util.*;
//StringTokenizer 클래스 사용을 위해서 java.util 클래스를 import 

public class StringTokenProg {	
	public static void main(String[] args) { 
		StringTokenizer str = new StringTokenizer("2012/09/23", "/");
		//StringTokenizer 클래스 생성,파싱하려는 문자열 "2012/09/23", 구분자 "/" 
		int count; 
		
		count = str.countTokens(); 
		//파싱한 결과로 구한 토큰이 모두 몇개인지 반환
		System.out.println("파싱할 문자열의 수는 총" + count + " 개"); 
		
		while (str.hasMoreTokens()) { 
		//아직 파싱할 토큰이 더 있는지 여부를 확인한다 
			System.out.println(str.nextToken()); 
			//파싱해서 구한 다음토큰을 반환한다.
		}
	}
}