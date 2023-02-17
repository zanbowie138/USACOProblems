import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Boilerplate {
	public static void main(String[] args) throws IOException {
		IoManager io = new IoManager();
		io.close();
	}

	static class IoManager extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
		
        // Default constructor
		public IoManager() {
			super(System.out);
			r = new BufferedReader(new InputStreamReader(System.in));
		}

        // Constructor with custom files (for testing)
        public IoManager(String input) throws IOException {
			super(System.out);
			r = new BufferedReader(new FileReader(input));
		}

		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}

		public int nextInt() { return Integer.parseInt(next()); }
	}
}
