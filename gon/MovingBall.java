package csclub;

public class MovingBall {

    static int[] dx = {0, 0, 1, -1}; // 행(반대로)
    static int[] dy = {1, -1, 0, 0}; // 열(반대로)

    public static void main(String[] args) {
        int n = 2;
        int m = 5;
        int x = 0; // 행
        int y = 1; // 열

        int[][] queries = {{3, 1}, {2, 2}, {1, 1}, {2, 3}, {0, 1}, {2, 1}};
        System.out.println(solution(n, m, x, y, queries));
    }

    public static long solution(int n, int m, int x, int y, int[][] queries) {

        int x1 = x, x2 = x;
        int y1 = y, y2 = y;

        for (int i = queries.length - 1; i >= 0; i--) {

            int direction = queries[i][0];
            int moveLength = queries[i][1];

            switch (direction) {
                case 0: // 열+1, 오른쪽
                    y2 += moveLength;
                    if (y2 >= m) y2 = m - 1;
                    if (y1 != 0) y1 += moveLength;
                    if (y1 >= m) return 0;
                    break;
                case 1: // 열-1, 왼쪽
                    y1 -= moveLength;
                    if (y1 < 0) y1 = 0;
                    if (y2 < m - 1) y2 -= moveLength;
                    if (y2 < 0) return 0;
                    break;
                case 2: // 행+1, 아래쪽
                    x2 += moveLength;
                    if (x2 >= n) x2 = n - 1;
                    if (x1 != 0) x1 += moveLength;
                    if (x1 >= n) return 0;
                    break;
                case 3: // 행-1, 위쪽
                    x1 -= moveLength;
                    if (x1 < 0) x1 = 0;
                    if (x2 < n - 1) x2 -= moveLength;
                    if (x2 < 0) return 0;
                    break;
            }
        }

        return (long)(x2 - x1 + 1) * (y2 - y1 + 1);
    }
}
