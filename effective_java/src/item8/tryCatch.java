package item8;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class tryCatch {
	public static void main(String args[]) throws IOException {
	    FileInputStream is = null;
	    BufferedInputStream bis = null;
	    try {
	        is = new FileInputStream("file.txt");
	        bis = new BufferedInputStream(is);
	        int data = -1;
	        while((data = bis.read()) != -1){
	            System.out.print((char) data);
	        }
	    } finally {
	        // close resources
	        if (is != null) is.close();
	        if (bis != null) bis.close();
	    }
	}
}
