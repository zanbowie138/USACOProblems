import java.util.StringTokenizer;
import java.io.*;
import java.util.Arrays;

public class Boilerplate{
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		//BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader r = new BufferedReader(new FileReader("AirCownditioning/test/1.in"));
		int testAmount = Integer.parseInt(r.readLine());

		int[] target = new int[testAmount];
		StringTokenizer st = new StringTokenizer(r.readLine());
		for (int t = 0; t < testAmount; t++) {
			target[t] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr = new int[testAmount];
		st = new StringTokenizer(r.readLine());
		for (int t = 0; t < testAmount; t++) {
			arr[t] = Integer.parseInt(st.nextToken());
		}

		boolean finished = false;
		int iters = 0;
		while (!finished) {
			finished = true;
			int maxLength = 0;
			int pos = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] != target[j]) {
					finished = false;
					int length = 0;
					for (int k = j; k < arr.length; k++) {
						if (arr[k] == target[j]) {
							break;
						}
						length++;
					}
					if (length > maxLength) {
						maxLength = length;
					}
				}
			}
			iters++;
		}
		pw.println(iters);
		pw.close();
		r.close();


	}
}
