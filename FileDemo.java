import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileDemo{

	public static void main(String[] args){
		//String dir = args[0];
		//String name = args[1];
		//String content = args[2];
		//
		String dir="";
		String name="";
		String content="";

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			dir = br
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(dir);
		System.out.println(name);
		System.out.println(content);

		if (dir.charAt(dir.length() - 1) != '/'){
			dir = new String(dir + '/');
		}

		System.out.println(dir);

		File f = new File(dir + name);
		try {
			f.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(content);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
