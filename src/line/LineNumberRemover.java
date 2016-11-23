package line;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LineNumberRemover {
	
	public static void main(String[] args){
		File src = new File("src/audio/JavaStreamingAudioPlayerO.java");
		File dst = new File("src/audio/JavaStreamingAudioPlayer.java");
	
		try {
			BufferedReader input = new BufferedReader( new InputStreamReader(new FileInputStream(src)));
			PrintWriter output = new PrintWriter(dst);
			
			while(input.ready()){
				String line = input.readLine();
				char[] l = line.toCharArray();
				if(l==null || l.length==0) continue; 
				if(l[0]<'0'||l[0]>'9')
					output.println(line);
				else{
					int colon = line.indexOf(':');
					output.println(line.substring(colon+1));
				}
			}
			output.flush();
			input.close();
			output.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
