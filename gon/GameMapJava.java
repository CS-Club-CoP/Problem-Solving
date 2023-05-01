package csclub;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapJava {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int n = maps.length; //y
        int m = maps[0].length; //x
        visited = new boolean[n][m];

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0, 1));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Pair node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;

                if (visited[ny][nx])
                    continue;

                if (maps[ny][nx] == 0)
                    continue;

                if (nx == m - 1 && ny == n - 1) {
                    return node.depth+1;
                }

                if (maps[ny][nx] == 1) {
                    q.add(new Pair(nx, ny, node.depth + 1));
                    visited[ny][nx] = true;
                }
            }
        }

        return -1;
    }
}

class Pair {
    int x;
    int y;
    int depth;

    Pair(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}
