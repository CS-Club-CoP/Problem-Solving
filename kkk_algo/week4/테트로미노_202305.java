import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2023.05.08 - 05.14
 * 테트로미노
 * https://www.acmicpc.net/problem/14500
 */
public class 테트로미노_202305 {
    public static void main(String[] args) throws IOException {
        int Max = 0;
        int[] shape_x = {0,0,0,1,2,3,0,1,1,0,0,1,0,0,-1,1,2,1,1,2,1,1,2,2,0,0,1,0,1,2,1,1,1,0,-1,-2,1,1,1,0,1,2,0,0,1,0,-1,-1,0,1,1,1,1,2,1,1,2};
        int[] shape_y = {1,2,3,0,0,0,1,0,1,1,2,1,1,2,1,0,0,1,0,0,-1,0,0,1,1,2,0,1,1,1,0,-1,-2,1,1,1,0,1,2,1,0,0,1,2,2,1,1,2,1,1,2,0,1,1,0,-1,-1};


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < 57; k += 3) {
                    if(i+shape_x[k] < N && i+shape_x[k] >= 0 && j+shape_y[k] < M && j+shape_y[k] >= 0
                            && i+shape_x[k+1] < N && i+shape_x[k+1] >= 0 && j+shape_y[k+1] < M && j+shape_y[k+1] >= 0
                            && i+shape_x[k+2] < N && i+shape_x[k+2] >= 0 && j+shape_y[k+2] < M && j+shape_y[k+2] >= 0 ) {
                        Max = Math.max(Max, map[i][j] + map[i+shape_x[k]][j+shape_y[k]] + map[i+shape_x[k+1]][j+shape_y[k+1]] + map[i+shape_x[k+2]][j+shape_y[k+2]]);
                    }
                }
            }
        }

        System.out.println(Max);
    }

}

/**
 * 메모리 : 34104KB
 * 시간 : 556ms
 */