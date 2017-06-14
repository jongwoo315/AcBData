package File;
import java.io.*;

public class FileOutput implements Output{
	private String filePath;
	
	public void output123(String message) throws IOException{
		FileWriter out = new FileWriter(filePath, true);
		out.write(message);
		out.close();
	}
	
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	
}
