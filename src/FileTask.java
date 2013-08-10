import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileTask {

	public static void main(String[] args) {
		// fields receiving user input
		String dirStr = ""; // directory name
		String name = ""; // contact name
		String num = ""; // contact number

		// get user input
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\\n+|\\s+");
		if (args.length == 0) {
			dirStr = scanner.next();
			name = scanner.next();
			num = scanner.next();
		} else if (args.length == 1) {
			dirStr = args[0];
			name = scanner.next();
			num = scanner.next();
		} else if (args.length == 2) {
			dirStr = args[0];
			name = args[1];
			num = scanner.next();
		} else if (args.length == 3) {
			dirStr = args[0];
			name = args[1];
			num = args[2];
		} else {
			System.out.println("Invalid number of arguments provided.");
			System.out.println("Usage: java FileTask [dir [name [num]]]");
			return;
		}
		if (dirStr.charAt(dirStr.length() - 1) != '/') {
			dirStr = new String(dirStr + '/');
		}

		// get an available file name!
		File f;
		f = new File(dirStr + name + ".contact");
		int i = 0;
		if (f.exists()) {
			i = 1;
			while (true) {
				File nf = new File(dirStr + name + "(" + Integer.toString(i)
						+ ").contact");
				if (!nf.exists()) {
					try {
						nf.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				} else {
					i++;
				}
			}
		} else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (i != 0) {
			f = new File(dirStr + name + "(" + Integer.toString(i)
					+ ").contact");
		}

		// make output - write to the file!
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(num);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
