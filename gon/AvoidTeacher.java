package csclub;

import java.util.Scanner;

public class AvoidTeacher {

    static int N;
    static String[][] map;
    static String[][] copyMap;
    static int[] dx = {0, 0, -1, 1}; // 열
    static int[] dy = {-1, 1, 0, 0}; // 행

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        N = sc.nextInt();

        map = new String[N][N];
        copyMap = new String[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.next();
                copyMap[i][j] = map[i][j];
            }
            sc.nextLine();
        }

        System.out.println(simulation());
    }

    private static String simulation() {
        if (putBarrier( 0))
            return "YES";
        else
            return "NO";
    }

    private static boolean putBarrier(int depth) {
        if (depth == 3) { // 장애물 3개를 두고 나서
            // 학생을 가릴 수 있는지 체크해본다.
            return check();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (map[i][j].equals("T") || map[i][j].equals("S"))
                    continue;

                if (copyMap[i][j].equals("O"))
                    continue;

                copyMap[i][j] = "O";
                if (putBarrier(depth + 1))
                    return true;
                copyMap[i][j] = "X";
            }
        }
        return false;
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (map[i][j].equals("T")) {
//                    System.out.println("선생님 : [" + i + "행" + j + "열]");
                    for (int k = 0; k < 4; k++) {
                        int ni = i;
                        int nj = j;

                        while (true) {
                            ni += dy[k];
                            nj += dx[k];

                            if (ni < 0 || nj < 0 || ni >= N || nj >= N)
                                break;

//                            System.out.println("[" + ni + "행" + nj + "열]=" + map[ni][nj]);

                            if (map[ni][nj].equals("S")) {
//                                System.out.println("S를 만나버림");
                                return false;
                            }

                            if (copyMap[ni][nj].equals("O")) {
//                                System.out.println("O를 만나버림 -> 이쪽 탐색을 끝낸다.");
                                break;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
