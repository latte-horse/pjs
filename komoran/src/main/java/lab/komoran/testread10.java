package lab.komoran;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class testread10 {
	 public static void main(String[] args) {
		 
		    String str = args[0];
	        final File folder = new File(str);
//	      listFilesForFolder(folder);
	        listFilesForFolder(str);
	    }

	    public static void listFilesForFolder(String str) {
	        try (Stream<Path> paths = Files.walk(Paths.get(str))) {
	            paths.filter(Files::isRegularFile).forEach(System.out::println);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void listFilesForFolder(final File folder) {
	        for (final File fileEntry : folder.listFiles()) {
	            if (fileEntry.isDirectory()) {
	                listFilesForFolder(fileEntry);
	            } else {
	                System.out.println(fileEntry.getName());
	            }
	        }
	    }
		 
		 
		 
		 
	 
}
