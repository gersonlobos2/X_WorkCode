

	

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.util.*;

	public class TP {

		private static InputStream in;

		static String read() {

			try {
				in = new FileInputStream("../input.dat");
			} catch (IOException ioe) {
				System.out.println("ERROR:  reading the saved file.");

			}

			String s = new String();
			char next = 0;
			boolean more = true;
			do {

				try {
					int b = (in.read());
					if (b == -1) {
						more = false;
					} else {
						next = (char) b;
						s += next;
					}
				} catch (IOException ioe) {
					more = false;
				}

			} while (more);
			try {
				in.close();
			} catch (IOException ioe) {
				System.out.println("ERROR:  reading the saved file.");
			}
			return s;

		}

		public static void main(String[] args) {
			System.out.println(read());

		}
	}


