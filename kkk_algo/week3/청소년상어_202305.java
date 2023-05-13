import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 청소년상어_202305 {
    static int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] fishMap = new int[4][4];
        int[][] dirMap = new int[4][4];

        for(int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++){
                fishMap[i][j] = Integer.parseInt(st.nextToken());
                dirMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        goShark(fishMap, dirMap, new int[]{0,0}, 0);

        System.out.println(answer);
    }

    static void goShark(int[][] map1, int[][] map2, int[] shark, int nyam){
        int[][] fishMap = new int[4][4];
        int[][] dirMap = new int[4][4];



        //배열복사
        for(int i = 0; i < 4; i++){
            fishMap[i] = Arrays.copyOf(map1[i], map1[i].length);
            dirMap[i] = Arrays.copyOf(map2[i], map2[i].length);
        }

        //1. 상어투입
        int sX = shark[0];
        int sY = shark[1];
        int sD = dirMap[sX][sY];
        int sN = nyam + fishMap[sX][sY];

        if(sN > answer) answer = sN;

        fishMap[sX][sY] = 0;

        //2. 물고기 이동
        for(int fish = 1; fish <= 16; fish++){
            int fX = -1, fY = -1, fD = -1;

            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    if(fishMap[i][j] == fish){
                        fX = i;
                        fY = j;
                        fD = dirMap[i][j];
                    }
                }
            }

            if(fX != -1){
                for(int i = 0; i < 8; i++){
                    int dx = fX + dir[fD-1][0];
                    int dy = fY + dir[fD-1][1];

                    if(dx >= 0 && dx < 4 && dy >= 0 && dy < 4){
                        if(!(sX == dx && sY == dy)){
                            int tmpfish = fishMap[dx][dy];
                            int tmpdir = dirMap[dx][dy];

                            fishMap[dx][dy] = fishMap[fX][fY];
                            dirMap[dx][dy] = dirMap[fX][fY];

                            fishMap[fX][fY] = tmpfish;
                            dirMap[fX][fY] =tmpdir;

                            break;
                        }
                    }

                    if(fD == 8) fD = 1;
                    else fD++;

                    dirMap[fX][fY] = fD;
                }
            }
        }

        //3. 상어이동
        int w = 1;
        while(true){
            int dx = sX + dir[sD-1][0]*w;
            int dy = sY + dir[sD-1][1]*w;

            if(dx >= 0 && dx < 4 && dy >= 0 && dy < 4){
                if(fishMap[dx][dy] > 0){
                    goShark(fishMap, dirMap, new int[]{dx, dy}, sN);
                }
            }else{
                break;
            }
            w++;
        }
    }
}
