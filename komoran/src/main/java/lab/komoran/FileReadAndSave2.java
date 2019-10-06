package lab.komoran;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 특정 폴더에 있는 파일 리스트를 읽어와 
 * 특정 문자열만 편집해서
 * output 폴더를 만들고  _del.txt 파일로 다시 저장한다.
 * 
 * @author NDAY
 *
 */
public class FileReadAndSave2 {
	public static void main(String[] args) {
		String path = "C:/before";
		File dirFile = new File(path);
		File[] fileList = dirFile.listFiles();
		
		FileReader fileReader = null;
		BufferedReader bufReader = null;
		
		File newFile = null;
		BufferedWriter bufferedWriter = null;
		
		for (File tempFile : fileList) {
			if (tempFile.isFile()) {
				String tempPath = tempFile.getParent();
				String tempFileName = tempFile.getName();
				//System.out.println("Path=" + tempPath+", FileName="+tempFileName);
				
				try {
					fileReader = new FileReader(tempFile);
					bufReader = new BufferedReader(fileReader);
					String line="";
					
					// output 폴더 생성 
					String newFileDirPath = path + File.separator + "../output";
					File dir = new File(newFileDirPath);
					if(!dir.exists()){
						dir.mkdirs(); //디렉토리 생성 메서드
			        }
					
					
					// 새로 생성될 파일
					newFile = new File(newFileDirPath+File.separator + tempFileName + "_del.txt");
					
					bufferedWriter = new BufferedWriter(new FileWriter(newFile));
					bufferedWriter.write( "#!/bin/sh" );
					//bufferedWriter.newLine(); // 돌아가는 OS에 따라서 다른 문자가 찍히기때문에 리눅스용은 별도로 해줘야 한다.
					bufferedWriter.write("\n"); // 리눅스는 \n 으로 줄바꿈
					
					System.out.println("fileName="+newFile.getName());
					
					while((line = bufReader.readLine()) != null ){
						
						if(line.indexOf("cmdStr:rm") > -1){
							//System.out.println(">> "+line.substring( line.indexOf("rm")) );
							
							//bufferedWriter.newLine(); // 윈도우 -> \r\n
							bufferedWriter.write("\n"); // 리눅스 -> \n
							bufferedWriter.write( line.substring( line.indexOf("rm")) );
							
						}
						else{
							//System.out.println(">> "+line);
						}
						
					}
					
					bufReader.close();
					fileReader.close();
					bufferedWriter.close();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		}
	}
}