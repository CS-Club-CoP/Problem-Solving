import java.io.*;
import java.util.*;

/**
 * 2023.05.15 - 05.21
 * 감시 피하기
 * https://www.acmicpc.net/problem/18428
 */

public class 감시피하기_202305 {

    static char[][] map;
    static boolean answer = false;

    static boolean[] visited;

    static ArrayList<Integer> tx;
    static ArrayList<Integer> ty;
    static ArrayList<Integer> xx;
    static ArrayList<Integer> xy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        tx = new ArrayList<>();
        ty = new ArrayList<>();
        xx = new ArrayList<>();
        xy = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);

                if (map[i][j] == 'T') {
                    tx.add(i);
                    ty.add(j);
                } else if (map[i][j] == 'X') {
                    xx.add(i);
                    xy.add(j);
                }
            }
        }

        visited = new boolean[xx.size()];

        goJohab(visited, 0, 3);

        if (answer) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void goJohab(boolean[] visited, int depth, int r) {
        if (answer) {
            return;
        }

        if (r == 0) {
            answer = checkMap(visited);
            return;
        }

        if (depth == visited.length) {
            return;
        } else {
            visited[depth] = true;
            goJohab(visited, depth + 1, r - 1);

            visited[depth] = false;
            goJohab(visited, depth + 1, r);
        }
    }

    public static boolean checkMap(boolean[] visited) {
        boolean res = true;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                int x = xx.get(i);
                int y = xy.get(i);
                map[x][y] = 'O';
            }
        }

        for (int i = 0; i < tx.size(); i++) {
            int x = tx.get(i);
            int y = ty.get(i);

            //위 -1 0
            int dx = x - 1;
            int dy = y;
            while (dx >= 0 && res) {
                if (map[dx][dy] == 'S') {
                    res = false;
                    break;
                } else if (map[dx][dy] == 'O') {
                    break;
                }

                dx--;
            }

            //하 1 0
            dx = x + 1;
            dy = y;
            while (dx < map.length && res) {
                if (map[dx][dy] == 'S') {
                    res = false;
                    break;
                } else if (map[dx][dy] == 'O') {
                    break;
                }

                dx++;
            }

            //좌 0 -1
            dx = x;
            dy = y - 1;
            while (dy >= 0 && res) {
                if (map[dx][dy] == 'S') {
                    res = false;
                    break;
                } else if (map[dx][dy] == 'O') {
                    break;
                }

                dy--;
            }

            //우 0 1
            dx = x;
            dy = y + 1;
            while (dy < map.length && res) {
                if (map[dx][dy] == 'S') {
                    res = false;
                    break;
                } else if (map[dx][dy] == 'O') {
                    break;
                }

                dy++;
            }
        }


        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                int x = xx.get(i);
                int y = xy.get(i);
                map[x][y] = 'X';
            }
        }
        return res;
    }
}

/***
 * 메모리 : 15616KB
 * 시간 : 140ms
 */