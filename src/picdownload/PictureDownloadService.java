package picdownload;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import picdownload.util.DateString;
import picdownload.util.PictureUrls;

class PictureDownloadService  extends TimerTask {
	boolean flag;
	DateString time;
	File fileName;
	File fileName1;
	PictureUrls URLS;
	String urls;
	
	public static String Urls[] = {"http://www.jma.go.jp/jmh/typh.html",
	"http://www.jma.go.jp/jmh/typh5.html"};
	
	public void run() {	
		time = new DateString();
		fileName = new File("logFile/log.txt");
		fileName1 = new File("logFile");
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
		
	    flag = false;	
		try {			
			fileName = new File("logFile/log.txt");
			InputStreamReader reader;
			reader = new InputStreamReader(new FileInputStream(fileName));			 
			BufferedReader bufReader = new BufferedReader(reader);			
			String br;
			while((br = bufReader.readLine()) !=null) {
				if(br.equals(time.strAdd6Hours)) {
					flag = true;
				}
		}	
			fileName = null;
			bufReader.close();
			reader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		if(flag) {
			System.out.println("already download");
		} else {
			try {
				fileName = new File("logFile/log.txt");
				OutputStreamWriter outWriter = new OutputStreamWriter(new FileOutputStream(fileName,true));
				BufferedWriter bufWriter = new BufferedWriter(outWriter);				    
				System.out.println();
				bufWriter.append(time.strAdd6Hours +"\r\n");					
			    bufWriter.flush();
			    bufWriter.close();
			} catch (IOException e) {
				e.printStackTrace();		
			}
			fileName = null;
			System.out.println("start download");
		}	
		if(!flag) {
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);	
			URLS = new PictureUrls();
			Runnable task;
			for(int i=0; i<URLS.urls.length; i++){
				urls=URLS.getUrls(i);
				task=new PictureDownloadTask(urls,i);
				executor.execute(task);				
			}
			executor = null;
			task = null;
			URLS = null;
			System.out.println("The end of Download");
			//ÏÂÔØÌ¨·çÍ¼Æ¬
			for(int i = 0; i < Urls.length; i++) {
				TaskforTyphon t = new TaskforTyphon(Urls[i]);
				t.startTask();
			}	
		 }
	}
	

}
