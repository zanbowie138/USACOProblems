import java.io.*;
import java.util.Arrays;

public class SG{
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader r = new BufferedReader(new FileReader("input.in"));
		int iters = Integer.parseInt(r.readLine());
		for (int i = 0; i < iters; i++) {
			r.readLine();
			int size = Integer.parseInt(r.readLine());
			boolean[][] arr = new boolean[size][size];
			for (int l = 0; l < size; l++) {
				String line = r.readLine();
				for (int j = 0; j < size; j++) {
					if (line.charAt(j) == '*') {
						arr[l][j] = true;
					}
				}
			}
			int s_size = Integer.parseInt(r.readLine());
			boolean[][] stamp = new boolean[s_size][s_size];
			for (int l = 0; l < s_size; l++) {
				String line = r.readLine();
				for (int j = 0; j < s_size; j++) {
					if (line.charAt(j) == '*') {
						stamp[l][j] = true;
					}
				}
			}

			if (s_size == 1) {
				if (stamp[0][0]) {
					pw.println("YES");
					continue;
				}
				else {
					pw.println("NO");
					continue;
				}
			}

			/* 
			if (size == s_size) {
				for (int rot = 0; rot < 4; rot++) {
					if (rot != 0)
						stamp = rotate(stamp);
					if (Arrays.deepEquals(arr, stamp)) {
						pw.println("YES");
						continue;
					}
				}
				pw.println("NO");
				continue;
			}*/ 

			boolean[][] temp = new boolean[size][size];

			for (int rot = 0; rot < 4; rot++) {
				if (rot != 0)
					stamp = rotate(stamp);
				for (int x = 0; x < size - s_size + 1; x++) {
					for (int y = 0; y < size - s_size + 1; y++) {
						boolean found = true;
						for (int p = 0; p < s_size*s_size; p++) {
							int x1 = p / s_size;
							int y1 = p % s_size;
							if (stamp[x1][y1] && !arr[x + x1][y + y1]) {
								found = false;
								break;
							}
						}
						if (found) {
							for (int p = 0; p < s_size*s_size; p++) {
								int x1 = p / s_size;
								int y1 = p % s_size;
								if (stamp[x1][y1]) {
									temp[x + x1][y + y1] = true;
								}
							}
						}
					}
				}
			}
			if (Arrays.deepEquals(arr, temp)) {
				pw.println("YES");
			}
			else {
				pw.println("NO");
			}
		}

		pw.close();
		r.close();

	}
	static boolean[][] rotate(boolean[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		boolean[][] output = new boolean[n][m];
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				output[c][m-1-r] = arr[r][c];
			}
		}
		return output;
	}
}
