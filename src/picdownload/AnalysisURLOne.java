package picdownload;

public class AnalysisURLOne {
	String webBody;
	String tieba = "http://www.jma.go.jp/jmh";
	public AnalysisURLOne(String s) {
		webBody = s;
	}
public String analysisURL() {		
		int beginPosition = 0;
		int endPosition = 0;
		String oneUrl = "";
		while (true) {		
			beginPosition = webBody.indexOf("href='", endPosition);
			endPosition = webBody.indexOf("'>", beginPosition);
			if (beginPosition == -1 || endPosition == -1)
				break;
			oneUrl = tieba + "/" + webBody.substring(beginPosition+6, endPosition);
			System.out.println("tiqule**" + oneUrl);
		}
		return oneUrl;
	}
}
