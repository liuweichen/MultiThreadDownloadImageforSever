package picdownload;

import java.io.File;
import java.io.IOException;
import java.util.Timer;

public class Bootstrap {

   public static void main(String arg[]) {	
	    File fileName = new File("logFile/log.txt");
		File fileName1 = new File("logFile");
		if(!fileName.exists()) {
			try {
				fileName1.mkdir();
				fileName.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileName = null;
			fileName1 = null;
		}
		
		Timer timer = new Timer();
		timer.schedule(new PictureDownloadService(), 1000,1000*60*60);
	}
   
}



