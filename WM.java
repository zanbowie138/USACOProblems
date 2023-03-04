import java.util.StringTokenizer;
import java.io.*;
import java.util.Arrays;

public class WM{
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader r = new BufferedReader(new FileReader("input.in"));
		StringTokenizer st = new StringTokenizer(r.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        if (n == 1) {
            pw.println(1+k);
            pw.close();
            r.close();
            return;
        }

        st = new StringTokenizer(r.readLine());
        long past_day = Long.parseLong(st.nextToken());
        long cost = 0;
        long days_acc = 0;
        long sub_acc = 0;
        boolean linked = false;
        long single_cost = 1 + k;
        //pw.println("single: " + single_cost);
        for (int i = 0; i < n-1; i++) {
            long current_day = Long.parseLong(st.nextToken());
            if (linked) {
                if (days_acc + current_day - past_day + k < single_cost * (sub_acc*2)) {
                    days_acc += current_day - past_day;
                    sub_acc++;
                    past_day = current_day;
                } else {
                    cost += days_acc + k + single_cost;
                    days_acc = 0;
                    sub_acc = 0;
                    linked = false;
                    past_day = current_day;
                }
            } else {
                if (current_day - past_day + k < single_cost * 2) {
                    linked = true;
                    days_acc += current_day - past_day + 1;
                    sub_acc+=2;
                    past_day = current_day;
                    if (i != 0) {
                        cost -= single_cost;
                    }
                    //pw.println("starting link");
                } else {
                    if (i == 0)
                        cost += single_cost;
                    cost += single_cost;
                    past_day = current_day;
                }
            }
            //pw.println(cost);
        }

        if (linked) {
            cost += days_acc + k;
        }

        pw.println(cost);

		pw.close();
		r.close();


	}
}