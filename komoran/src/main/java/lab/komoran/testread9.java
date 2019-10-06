package lab.komoran;

import java.io.*;

public class testread9 {
    public static void main(String[] args) {
        String fDir = "./C:before/";
        String fName1 = "1.txt";
        File f;
 
        try {
            // File 객체 생성(존재하는 파일)
            f = new File(fDir + fName1);
 
            // 파일 쓰기(주석부분은 간략화)
            FileWriter fileWriter = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            //BufferedWriter writer = new BufferedWriter(new FileWriter(f));
 
            writer.write("witerTest1");
            writer.append("\n"); // 개행문자 삽입
            writer.append("witerTest2");
            writer.newLine(); // 개행 메서드
            writer.write("witerTest3");
            writer.close(); // 파일 닫기
 
            // 파일 읽기
            FileReader fileReader = new FileReader(f);
            BufferedReader reader = new BufferedReader(fileReader);
 
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close(); // 파일 닫기
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
 
    }
}