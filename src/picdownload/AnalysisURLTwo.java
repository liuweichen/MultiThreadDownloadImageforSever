package picdownload;

public class AnalysisURLTwo {
	String webBody;
	String tieba = "http://www.jma.go.jp/";
	public AnalysisURLTwo(String s) {
		webBody = s;
	}
	public String analysisURL() {
		int beginPosition = 0;
		int endPosition = 0;
		String oneUrl = "";
		while (true) {	
			beginPosition = webBody.indexOf("src=\"..", endPosition);
			endPosition = webBody.indexOf(".png", beginPosition);
			if (beginPosition == -1 || endPosition == -1)
				break;
			oneUrl = tieba + webBody.substring(beginPosition+8, endPosition)+".png";							
			System.out.println("¥Ê¥¢¡ÀÕ¯÷∑£∫" + oneUrl);
		}
		return oneUrl;
	}
}
