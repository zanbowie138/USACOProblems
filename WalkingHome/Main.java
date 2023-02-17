import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("WalkingHome/test/10.in"));
        int testAmount = s.nextInt();
        s.nextLine();
        for (int t = 0; t < testAmount; t++) {
            int lines = s.nextInt();
            int maxTurns = s.nextInt();
            boolean[][] field = new boolean[lines][lines];
            s.nextLine();

            for (int i = 0; i < lines; i++) {
                String[] lineString = s.nextLine().split("");
                boolean[] line = new boolean[lineString.length];
                for (int c = 0; c < lineString.length; c++) {
                    switch (lineString[c]) {
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
            System.out.println(calcPath(0, 0, field, maxTurns, 0, true));
        }
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

}