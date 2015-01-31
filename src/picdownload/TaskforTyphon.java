package picdownload;

public class TaskforTyphon {
	public String url;
	public String url2;
	public String url3;
	public String webBody;
	public static int i = 61;
	public TaskforTyphon(String s) {
		url = s;
	}
	
	public void startTask() {
		ReadWeb rw = new ReadWeb(url);
		try {
			webBody = rw.readWeb();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(webBody.contains("href=")) {
			AnalysisURLOne auo = new AnalysisURLOne(webBody);
			url2 = auo.analysisURL();
			rw = new ReadWeb(url2);
			try {
				webBody = rw.readWeb();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		AnalysisURLTwo  aut = new AnalysisURLTwo(webBody);
		url3 = aut.analysisURL();
		PictureDownloadTask df = new PictureDownloadTask(url3,i++);
		df.run();
	}	
}
