import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        IoManager io = new IoManager();
        int testAmount = io.nextInt();
        for (int t = 0; t < testAmount; t++) {
            int lines = io.nextInt();
            int maxTurns = io.nextInt();
            boolean[][] field = new boolean[lines][lines];

            for (int i = 0; i < lines; i++) {
                String[] lineStr = io.next().split("");
                boolean[] line = new boolean[lines];
                for (int c = 0; c < lines; c++) {
                    switch (lineStr[c]) {
                        case ".":
                            line[c] = true;
                            break;
                        case "H":
                            line[c] = false;
                            break;
                    }
                }
                field[i] = line;
            }
            io.println(calcPath(0, 0, field, maxTurns, 0, true));
        }
        io.close();
    }

    public static int calcPath(int x, int y, boolean[][] field, int maxTurns, int turns, boolean down) {
        if (x < 0 || y < 0 || x >= field.length || y >= field.length) {
            return 0;
        }

        if (field[x][y] == false) {
            return 0;
        }
        if (turns > maxTurns) {
            return 0;
        }
        if (x == field.length - 1 && y == field.length - 1) {
            return 1;
        }
        if (x == 0 && y == 0) {
            return calcPath(x + 1, y, field, maxTurns, turns, true) + calcPath(x, y + 1, field, maxTurns, turns, false);
        }
        if (down == true) {
            return calcPath(x + 1, y, field, maxTurns, turns, true) + calcPath(x, y + 1, field, maxTurns, turns + 1, false);
        } else {
            return calcPath(x + 1, y, field, maxTurns, turns + 1, true) + calcPath(x, y + 1, field, maxTurns, turns, false);
        }
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