import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataTask {

	public static void main(String[] args) {
		
		// setup file reading stuff.
		String curDirStr = ".";
		File curDir = new File(curDirStr);
		File[] fileArr = curDir.listFiles();
		
		// create a set to store contact numbers (i.e. file contents).
		Set<String> fileContentsSet = new HashSet<String>();
		
		// loop through all files/dirs under ".".
		for (int i = 0; i < fileArr.length; i++) {
			File f = fileArr[i];
			
			// ignoring folders.
			if (f.isFile()) {
				String fn = f.getName(); // File Name.
				
				// check file name for 'contact'
				if (fn.contains("contact")) {
					
					// read file contents to the set.
					try {
						@SuppressWarnings("resource")
						BufferedReader br = new BufferedReader(new FileReader(
								f)); // only one line to read! :)
						String curFileContent = br.readLine();
						fileContentsSet.add(curFileContent);
						
						// clean up!
						br.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		// process data.
		List<String> fileContentsList = new ArrayList<String>(fileContentsSet);
		Collections.sort(fileContentsList);

		// doing output.
		try {
			
			// setup file writing stuff.
			File outFile = new File("./data.txt"); // supposed file path.
			if (outFile.exists()){
				outFile.delete();
			}
			outFile.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
			
			// write the sorted list to file
			for (String s: fileContentsList){
				bw.write(s);
				bw.newLine();
			}
			
			// clean up!
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
