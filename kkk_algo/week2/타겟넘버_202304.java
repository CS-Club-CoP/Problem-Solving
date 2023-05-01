/**
 * 2023.04.24 - 30
 * Ÿ�� �ѹ�
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class Ÿ�ٳѹ�_202304 {
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
		
		//���� �������� ���� ���ϴ� ����� ���� ���� ����� ���� ���� ����
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
 * ��Ȯ���׽�Ʈ
 * �׽�Ʈ 1 ��	��� (4.30ms, 75.2MB)
 * �׽�Ʈ 2 ��	��� (6.64ms, 79.1MB)
 * �׽�Ʈ 3 ��	��� (0.23ms, 75.5MB)
 * �׽�Ʈ 4 ��	��� (0.33ms, 76.3MB)
 * �׽�Ʈ 5 ��	��� (0.80ms, 75.7MB)
 * �׽�Ʈ 6 ��	��� (0.23ms, 76.6MB)
 * �׽�Ʈ 7 ��	��� (0.21ms, 75.8MB)
 * �׽�Ʈ 8 ��	��� (0.35ms, 85.8MB)
 */