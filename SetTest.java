import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class SetTest {
	public static void main(String[] args){
		Set<String> ss = new HashSet<String>();
		String a = "a";
		String b = "b";
		String c = "a";
		ss.add(a);
		ss.add(b);
		ss.add(c);
		for (String s : ss) {
			System.out.println(s);
		}

		System.out.println();
		System.out.println("11".compareTo("12"));
		try {
			File f = new File("./outfile");
			if(!f.exists()){
				f.createNewFile();
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write("buffered write!!");
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
