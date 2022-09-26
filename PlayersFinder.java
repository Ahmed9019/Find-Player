import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.awt.Point;

interface IPlayersFinder {

    java.awt.Point[] findPlayers(String[] photo, int team, int threshold);

}

public class PlayersFinder implements IPlayersFinder {
    static int numbE = 0;
    static int numbR = 0;
    static int maxY = -1, maxX = -1, minY = 51, minX = 51;

    public static void search(char[][] photo, int team, int i, int j) {

        if ((i) < photo.length && (j) < photo[0].length && (i) >= 0 && (j) >= 0) {
            if (photo[i][j] == ('0' + team)) {
                photo[i][j] = 'a';
                numbR++;
                if (i > maxY) {
                    maxY = i;
                }
                if (i < minY) {
                    minY = i;
                }
                if (j > maxX) {
                    maxX = j;
                }
                if (j < minX) {
                    minX = j;
                }
                search(photo, team, i + 1, j);
                search(photo, team, i - 1, j);
                search(photo, team, i, j + 1);
                search(photo, team, i, j - 1);
            }
        }
    }

    public Point[] findPlayers(String[] photo, int team, int threshold) {

        char[][] ph = new char[photo.length][photo[0].length()];
        Point[] po = new Point[100];

        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[0].length(); j++) {
                ph[i][j] = photo[i].charAt(j);
            }
        }
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[0].length(); j++) {
                if (ph[i][j] == ('0' + team)) {
                    search(ph, team, i, j);
                }
                if (numbR >= ((double) threshold / 4.0)) {
                    po[numbE] = new Point((maxX + minX + 1), (maxY + minY + 1));
                    numbE++;
                }
                maxY = -1;
                maxX = -1;
                minY = 51;
                minX = 51;
                numbR = 0;
            }
        }
        return po;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String y = sc.nextLine();
        String[] s = y.split(", ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; ++i) {
            arr[i] = Integer.parseInt(s[i]);
        }
        String[] array = new String[arr[0]];
        if (arr[0] == 0 && arr[1] == 0) {
            System.out.println("[]");
        } else {
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextLine();
            }
        }
        int team = sc.nextInt();
        int threshold = sc.nextInt();

        Point[] f = new PlayersFinder().findPlayers(array, team, threshold);
        Point temp;
        for (int i = 0; i < numbE; i++) {
            for (int j = i + 1; j < numbE; j++) {
                if (f[i].x > f[j].x) {
                    temp = f[i];
                    f[i] = f[j];
                    f[j] = temp;
                } else if (f[i].x == f[j].x) {
                    if (f[i].y > f[j].y) {
                        temp = f[i];
                        f[i] = f[j];
                        f[j] = temp;
                    }
                }
            }
        }
        System.out.print("[");
        for (int i = 0; i < numbE; i++) {
            System.out.print("(" + f[i].x + ", " + f[i].y + ")");
            if (i != numbE - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");

    }
}