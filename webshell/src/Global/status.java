package Global;

import java.util.Vector;

public class status {
	
	private static  String filepath;
	private static Vector<String> pro;

	
	public static void setFilePath(String  file) {
		status.filepath = file;
	}
	
	public static String  getFilePath() {
		return status.filepath;
	}

}
