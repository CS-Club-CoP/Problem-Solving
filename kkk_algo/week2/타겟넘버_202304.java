/**
 * 2023.04.24 - 30
 * 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class 타겟넘버_202304 {
	static int[] arr;
	static int num;
	static int answer = 0;
	
	static public int solution(int[] numbers, int target) {
        arr = numbers;
        num = target;
        
        rec(0,0);
        
        return answer;
    }
	
	static void rec(int cur, int idx) {
		if(idx == arr.length) {
			if(cur == num) answer++;
			return;
		}
		
		int next = arr[idx];
		
		//다음 순서값에 대해 더하는 경우의 수와 빼는 경우의 수를 각각 실행
		rec(cur+next, idx+1);
		rec(cur-next, idx+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputex1 = {1,1,1,1,1};
		int[] inputex2 = {4,1,2,1};
		System.out.println(solution(inputex2, 4));
	}
}

/**
 * 정확성테스트
 * 테스트 1 〉	통과 (4.30ms, 75.2MB)
 * 테스트 2 〉	통과 (6.64ms, 79.1MB)
 * 테스트 3 〉	통과 (0.23ms, 75.5MB)
 * 테스트 4 〉	통과 (0.33ms, 76.3MB)
 * 테스트 5 〉	통과 (0.80ms, 75.7MB)
 * 테스트 6 〉	통과 (0.23ms, 76.6MB)
 * 테스트 7 〉	통과 (0.21ms, 75.8MB)
 * 테스트 8 〉	통과 (0.35ms, 85.8MB)
 */