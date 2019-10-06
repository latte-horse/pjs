package lab.komoran;

import java.io.*;

class TxtRead{

String file_name = "기사";
String file_extend_name = "txt";
BufferedReader br;
BufferedWriter bw;
FileOutputStream fos = null;
FileInputStream fin = null;

public TxtRead(){
 try{
  fos = new FileOutputStream( "C:/before" );
  bw = new BufferedWriter( new OutputStreamWriter( fos ) );
 }catch(Exception e ){}


}

public void start(){
 try{
  String line = "";
  String msg = "";
  for( int i = 1 ; i < 8 ; i ++ ){

   System.out.println( file_name +""+i+"."+file_extend_name );
   
   fin = new FileInputStream( file_name +""+i+"."+file_extend_name );

   br = new BufferedReader( new InputStreamReader( fin , "euc-kr" ) );

   while( ( line = br.readLine() ) != null ){

    msg += line+"\r\n";

   }

  }

  write_msg( msg );
 }catch(Exception e){}
 
}

public void write_msg( String msg ){

 try{

  bw.write( msg );

  bw.flush();

 }catch(Exception e){}
}

public static void main(String[] args)
{
 new TxtRead().start();
}
}
