import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2023.05.08 - 05.14
 * N-Queen
 * https://www.acmicpc.net/problem/9663
 */
public class NQUEEN_202305 {
    static int answer = 0;
    static int N = 0;
    static int[] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        배열을 1차원으로 구현, 해당 인덱스(행)에 몇번째 위치(열)에 있는지를 계산해서 처리

        십자부분 : 전체 행을 검색, 같은 번호(열)이면 못놓는다.
        대각부분 : 대각선에 위치한 애들은 각 행-열의 값이 동일하다(반대위치 계산도 커버하기 위해 절대값)
                  ex) (2,1) (3,2)면 3-2 = 1, 2-1 = 1, 1 == 1

         */

        N = Integer.parseInt(br.readLine());

        map = new int[N];

        nQueen(0);

        System.out.println(answer);

    }

    public static void nQueen(int idx){
        if(idx == N){
            answer++;
            return;
        }

        for(int i = 0; i < N; i++){
            map[idx] = i;

            boolean possible = true;

            for(int j = 0; j < idx; j++){
                //십자
                if(map[j] == map[idx]){
                    possible = false;
                    break;
                }
                //대각
                else if(Math.abs(idx-j) == Math.abs(map[idx] - map[j])){
                    possible = false;
                    break;
                }
            }

            if(possible){
                nQueen(idx+1);
            }
        }
    }
}
/***
 * 메모리 : 14700KB
 * 시간 : 5344ms
 */