import java.util.*;

/**
 * 2023.05.01 - 05.07
 * 징검다리
 * https://school.programmers.co.kr/learn/courses/30/lessons/43236
 */
public class 징검다리3_202305 {
    public static int solution(int distance, int[] rocks, int n) {
        /*
        - 그리디로는 최적의 해가 나오지 않음
        - 이분탐색을 계산전 거리값이 아닌 결과값에 적용해 결과값을 가정
         */
        Arrays.sort(rocks);

        //바위간 거리계산
        int[] dist = new int[rocks.length+1];

        dist[0] = rocks[0];
        dist[rocks.length] = distance - rocks[rocks.length-1];

        for(int i = 1; i < rocks.length; i++){
            dist[i] = rocks[i] - rocks[i-1];
        }

        int left = 0;
        int right = distance;
        int mid = 0;

        //이분탐색 변수
        while(left <= right) {
            int cnt = 0;
            int cur = 0;
            mid = (left+right)/2;

            for (int i = 0; i < dist.length; i++) {
                cur += dist[i];
                if (cur < mid) {
                    cnt++;
                } else {
                    cur = 0;
                }
            }

            if(cnt > n){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return (left+right)/2;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(solution(25, new int[]{2, 14, 11, 21, 17}, 2));
        System.out.println(solution(100, new int[]{100}, 1));
        System.out.println(solution(18, new int[]{2,8,9,10,11,12,13}, 6));
    }

}
