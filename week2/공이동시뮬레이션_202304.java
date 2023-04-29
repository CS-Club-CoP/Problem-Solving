/**
 * 2023.04.24 - 30
 * 공 이동 시뮬레이션
 * https://school.programmers.co.kr/learn/courses/30/lessons/87391
 */
public class 공이동시뮬레이션_202304 {
	
	static public long solution(int n, int m, int x, int y, int[][] queries) {
        /*
         * 1. 벽에 다다르면 못 이동x -> query(0,2) 일때, (0,1)과 (0,2) 둘다 (0,0)에 도착함
         * 2. 모든점에서 시뮬레이션을 돌리는게 아닌, 마지막점에서 역순으로 이동해서 도달할 수 있는 점의 수를 구한다.
         */
        
        //도달 가능한 점들의 범위를 나타내는 두 점
        long x1 = x, x2 = x;
        long y1 = y, y2 = y;
        
        //queries의 역순으로 탐색
        int len = queries.length;
        
        for(int i = len-1; i >= 0; i--) {
        	 int dir = queries[i][0];
        	 int dist = queries[i][1];
        	 
        	 if(dir == 0) {//좌
        		 if(y1 == 0) {
        			 y2 = y2+dist >= m ? m-1 : y2+dist; 
        		 }else {
        			 if(y1+dist >= m) return 0;
        			 y1 = y1+dist >= m ? m-1 : y1+dist;
        			 y2 = y2+dist >= m ? m-1 : y2+dist; 
        		 }
        	 }else if(dir == 1) {//우
        		 if(y2 == m-1) {
        			 y1 = y1-dist < 0 ? 0 : y1-dist; 
        		 }else {
        			 if(y2-dist < 0) return 0;
        			 y1 = y1-dist < 0 ? 0 : y1-dist; 
        			 y2 = y2-dist < 0 ? 0 : y2-dist; 
        		 }
        	 }else if(dir == 2) {//상
        		 if(x1 == 0) {
        			 x2 = x2+dist >= n ? n-1 : x2+dist;
        		 }else {
        			 if(x1+dist >= n) return 0;
        			 x1 = x1+dist >= n ? n-1 : x1+dist;
        			 x2 = x2+dist >= n ? n-1 : x2+dist;
        		 }
        	 }else {//하
        		 if(x2 == n-1) {
        			 x1 = x1-dist < 0 ? 0 : x1-dist;
        		 }else {
        			 if(x2-dist < 0) return 0;
        			 x1 = x1-dist < 0 ? 0 : x1-dist;
        			 x2 = x2-dist < 0 ? 0 : x2-dist;
        		 }
        	 }
        }
        
        return (x2-x1+1) * (y2-y1+1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] inputex1 = {
				{2,1},
				{0,1},
				{1,1},
				{0,1},
				{2,1}
		};
		int[][] inputex2 = {
				{3,1},
				{2,2},
				{1,1},
				{2,3},
				{0,1},
				{2,1}
		};
		
		System.out.println(solution(2,2,0,0,inputex1));
		System.out.println(solution(2,5,0,1,inputex2));
	}

}

/**
 * 정확도테스트
 * 테스트 1 〉	통과 (0.11ms, 72.6MB)
 * 테스트 2 〉	통과 (0.15ms, 77.9MB)
 * 테스트 3 〉	통과 (0.18ms, 81.7MB)
 * 테스트 4 〉	통과 (0.15ms, 78MB)
 * 테스트 5 〉	통과 (6.56ms, 114MB)
 * 테스트 6 〉	통과 (8.42ms, 120MB)
 * 테스트 7 〉	통과 (11.02ms, 112MB)
 * 테스트 8 〉	통과 (8.94ms, 124MB)
 * 테스트 9 〉	통과 (8.02ms, 133MB)
 * 테스트 10 〉	통과 (11.84ms, 105MB)
 * 테스트 11 〉	통과 (13.42ms, 117MB)
 * 테스트 12 〉	통과 (8.12ms, 127MB)
 * 테스트 13 〉	통과 (14.40ms, 116MB)
 * 테스트 14 〉	통과 (10.67ms, 113MB)
 * 테스트 15 〉	통과 (16.20ms, 126MB)
 * 테스트 16 〉	통과 (9.69ms, 123MB)
 * 테스트 17 〉	통과 (8.80ms, 128MB)
 * 테스트 18 〉	통과 (18.36ms, 121MB)
 * 테스트 19 〉	통과 (12.89ms, 122MB)
 * 테스트 20 〉	통과 (10.33ms, 133MB)
 * 테스트 21 〉	통과 (9.83ms, 134MB)
 * 테스트 22 〉	통과 (10.08ms, 123MB)
 * 테스트 23 〉	통과 (8.29ms, 138MB)
 * 테스트 24 〉	통과 (9.09ms, 137MB)
 * 테스트 25 〉	통과 (0.21ms, 72.7MB)
 * 테스트 26 〉	통과 (0.63ms, 76.5MB)
 * 테스트 27 〉	통과 (0.23ms, 77.8MB)
 * 테스트 28 〉	통과 (0.08ms, 76.5MB)
 * 테스트 29 〉	통과 (0.18ms, 75.2MB)
 * 테스트 30 〉	통과 (0.12ms, 70.2MB)
 * 테스트 31 〉	통과 (0.10ms, 79.3MB)
 * 테스트 32 〉	통과 (1.00ms, 83.5MB)
 * 테스트 33 〉	통과 (0.82ms, 124MB)
 * 테스트 34 〉	통과 (0.14ms, 110MB)
 */