package picdownload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import picdownload.util.DateString;

public class PictureDownloadTask implements Runnable {
	private	String urlString;	
	private int trycount = 0;
    private	int id;
	public PictureDownloadTask(String url,int Id) {
		// 设置属性
		urlString = url;
		this.id = Id;
	}

	public void run() {
		try{
			downLoadFile();
		} catch(IOException e) {
			e.printStackTrace();
			if((++trycount)<10) {
				run();
				System.out.println("id="+id+" error,try again,trycount="+trycount);
			} else {
				System.out.println("fatal error");
			}			
		}		
	}

	public synchronized void downLoadFile() throws IOException {		
		
			// 网络文件的URL
			URL url = new URL(urlString);		
			// 打开该网络文件的URL连接
			URLConnection urlConn = url.openConnection();
			/*
			// 网络文件的相关信息
			StringBuffer info = new StringBuffer();
			// 添加网络文件的相关信息
			info.append("主机：" + url.getHost() + "\n");
			info.append("端口：" + url.getDefaultPort() + "\n");
			info.append("网络文件的类型：" + urlConn.getContentType() + "\n");
			info.append("长度：" + urlConn.getContentLength() + "\n");
			info.append("正在下载···");
			System.out.println(info.toString());
			*/
			DateString time = new DateString();
			// 创建网络文件的输入流
			InputStream is = urlConn.getInputStream();			
			String localFileName = time.strAdd6Hours+"_"
					+url.getFile().substring(url.getFile().lastIndexOf("/") + 1);			
			// 创建本地文件输出流
			File f = new File(time.strAdd6Hours+"/");
			f.mkdirs();
			FileOutputStream fos = new FileOutputStream(time.strAdd6Hours+"/" + localFileName);			
			// 读取网络文件到本地文件
			int data;
			while ((data = is.read()) != -1) {
				fos.write(data);			
			} 
			// 关闭流
			is.close();
			fos.close();		
		System.out.println(id+"下载完毕！");
	}
}
