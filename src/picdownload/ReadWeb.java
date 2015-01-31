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
		// ��ʱ��׼��ҳ���ڴ��ֽ�����������������Զ�����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// ����������
		URL startUrl;
		URLConnection urlConnection;

		// ��ȡ����������
		InputStream is = null;

		// ���ñ�����ҳ���ݵ��ڴ��ֽ����������
		baos.reset();

		// ������ҳ����
		startUrl = new URL(url);
		urlConnection = startUrl.openConnection();

		// ��ȡ��ҳ��������
		is = urlConnection.getInputStream();
		
		
		// ��ȡ��ҳ���ݣ���������ҳ���ݵ��ڴ��ֽ����������
		int oneByte = is.read();		
		while (oneByte > 0) {
			// ������ҳ���ݿ�ͷ���Ŀո��ַ����س������з�			
//			if (oneByte <= 32) {
//				oneByte = is.read();
//				System.out.println("�ڲ�oneByte:" + oneByte);
//				continue;
//			}
			// ����ȡ����ҳ�ַ�����д���ڴ��ֽ����������
			baos.write(oneByte);
			// ��������һ����ҳ�ַ�
			oneByte = is.read();
		}		
		// ��ȡ��ҳ�ı�����
		String webBody;
		webBody = new String(baos.toByteArray(), "UTF-8");		
		
		return webBody;
	}
}
