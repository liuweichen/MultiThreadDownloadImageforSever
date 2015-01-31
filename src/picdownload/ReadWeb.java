package picdownload;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class ReadWeb {
	String url;
	public ReadWeb(String s) {
		url = s;
	}
	public String readWeb() throws Exception {
		// 临时标准网页的内存字节数组输出流，长度自动增长
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// 打开网络连接
		URL startUrl;
		URLConnection urlConnection;

		// 获取网络输入流
		InputStream is = null;

		// 重置保存网页内容的内存字节数组输出流
		baos.reset();

		// 创建网页连接
		startUrl = new URL(url);
		urlConnection = startUrl.openConnection();

		// 获取网页的输入流
		is = urlConnection.getInputStream();
		
		
		// 读取网页内容，保存在网页内容的内存字节数组输出流
		int oneByte = is.read();		
		while (oneByte > 0) {
			// 忽略网页内容开头处的空格字符、回车、换行符			
//			if (oneByte <= 32) {
//				oneByte = is.read();
//				System.out.println("内层oneByte:" + oneByte);
//				continue;
//			}
			// 将读取的网页字符内容写入内存字节数组输出流
			baos.write(oneByte);
			// 继续读下一个网页字符
			oneByte = is.read();
		}		
		// 获取网页文本内容
		String webBody;
		webBody = new String(baos.toByteArray(), "UTF-8");		
		
		return webBody;
	}
}
