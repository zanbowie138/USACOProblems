import java.util.StringTokenizer;
import java.io.*;
import java.util.Arrays;
import java.lang.Math;

public class HC{
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader r = new BufferedReader(new FileReader("input.in"));
		StringTokenizer st = new StringTokenizer(r.readLine());

		long lines = Integer.parseInt(st.nextToken());
		long days = Integer.parseInt(st.nextToken());

		long current_bales = 0;
		long eaten = 0;

		st = new StringTokenizer(r.readLine());
		long past_day = Long.parseLong(st.nextToken());
		current_bales += Long.parseLong(st.nextToken());

		for (int i = 0; i < lines-1; i++) {
			//pw.println("iteration: " + i + "");
			st = new StringTokenizer(r.readLine());
			long day = Long.parseLong(st.nextToken());

			long diff = day-past_day;
			if (i == 0) {
				diff++;
			}

			long added_bales = Long.parseLong(st.nextToken());
			if (day >= days) {
				eaten += Math.min(current_bales, diff);
				current_bales -= Math.min(current_bales, diff);
				if (added_bales > 0 && current_bales == 0) {
					// Accounts for the last day
					eaten++;
				}
				past_day = days;
				break;
			}
			
			current_bales += added_bales;
			long eat = Math.min(current_bales, diff);
			current_bales -= eat;
			eaten += eat;
			past_day = day;
			//pw.println("eaten: " + eaten + " current_bales: " + current_bales + " past_day: " + past_day + " diff: " + diff + " added_bales: " + added_bales + " day: " + day);
		}

		if (days > past_day) {
			eaten += Math.min(current_bales, days-past_day);
		}

		pw.println(eaten);


		pw.close();
		r.close();
	}
}
