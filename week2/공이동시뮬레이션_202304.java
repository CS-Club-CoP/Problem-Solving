/**
 * 2023.04.24 - 30
 * �� �̵� �ùķ��̼�
 * https://school.programmers.co.kr/learn/courses/30/lessons/87391
 */
public class ���̵��ùķ��̼�_202304 {
	
	static public long solution(int n, int m, int x, int y, int[][] queries) {
        /*
         * 1. ���� �ٴٸ��� �� �̵�x -> query(0,2) �϶�, (0,1)�� (0,2) �Ѵ� (0,0)�� ������
         * 2. ��������� �ùķ��̼��� �����°� �ƴ�, ������������ �������� �̵��ؼ� ������ �� �ִ� ���� ���� ���Ѵ�.
         */
        
        //���� ������ ������ ������ ��Ÿ���� �� ��
        long x1 = x, x2 = x;
        long y1 = y, y2 = y;
        
        //queries�� �������� Ž��
        int len = queries.length;
        
        for(int i = len-1; i >= 0; i--) {
        	 int dir = queries[i][0];
        	 int dist = queries[i][1];
        	 
        	 if(dir == 0) {//��
        		 if(y1 == 0) {
        			 y2 = y2+dist >= m ? m-1 : y2+dist; 
        		 }else {
        			 if(y1+dist >= m) return 0;
        			 y1 = y1+dist >= m ? m-1 : y1+dist;
        			 y2 = y2+dist >= m ? m-1 : y2+dist; 
        		 }
        	 }else if(dir == 1) {//��
        		 if(y2 == m-1) {
        			 y1 = y1-dist < 0 ? 0 : y1-dist; 
        		 }else {
        			 if(y2-dist < 0) return 0;
        			 y1 = y1-dist < 0 ? 0 : y1-dist; 
        			 y2 = y2-dist < 0 ? 0 : y2-dist; 
        		 }
        	 }else if(dir == 2) {//��
        		 if(x1 == 0) {
        			 x2 = x2+dist >= n ? n-1 : x2+dist;
        		 }else {
        			 if(x1+dist >= n) return 0;
        			 x1 = x1+dist >= n ? n-1 : x1+dist;
        			 x2 = x2+dist >= n ? n-1 : x2+dist;
        		 }
        	 }else {//��
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
 * ��Ȯ���׽�Ʈ
 * �׽�Ʈ 1 ��	��� (0.11ms, 72.6MB)
 * �׽�Ʈ 2 ��	��� (0.15ms, 77.9MB)
 * �׽�Ʈ 3 ��	��� (0.18ms, 81.7MB)
 * �׽�Ʈ 4 ��	��� (0.15ms, 78MB)
 * �׽�Ʈ 5 ��	��� (6.56ms, 114MB)
 * �׽�Ʈ 6 ��	��� (8.42ms, 120MB)
 * �׽�Ʈ 7 ��	��� (11.02ms, 112MB)
 * �׽�Ʈ 8 ��	��� (8.94ms, 124MB)
 * �׽�Ʈ 9 ��	��� (8.02ms, 133MB)
 * �׽�Ʈ 10 ��	��� (11.84ms, 105MB)
 * �׽�Ʈ 11 ��	��� (13.42ms, 117MB)
 * �׽�Ʈ 12 ��	��� (8.12ms, 127MB)
 * �׽�Ʈ 13 ��	��� (14.40ms, 116MB)
 * �׽�Ʈ 14 ��	��� (10.67ms, 113MB)
 * �׽�Ʈ 15 ��	��� (16.20ms, 126MB)
 * �׽�Ʈ 16 ��	��� (9.69ms, 123MB)
 * �׽�Ʈ 17 ��	��� (8.80ms, 128MB)
 * �׽�Ʈ 18 ��	��� (18.36ms, 121MB)
 * �׽�Ʈ 19 ��	��� (12.89ms, 122MB)
 * �׽�Ʈ 20 ��	��� (10.33ms, 133MB)
 * �׽�Ʈ 21 ��	��� (9.83ms, 134MB)
 * �׽�Ʈ 22 ��	��� (10.08ms, 123MB)
 * �׽�Ʈ 23 ��	��� (8.29ms, 138MB)
 * �׽�Ʈ 24 ��	��� (9.09ms, 137MB)
 * �׽�Ʈ 25 ��	��� (0.21ms, 72.7MB)
 * �׽�Ʈ 26 ��	��� (0.63ms, 76.5MB)
 * �׽�Ʈ 27 ��	��� (0.23ms, 77.8MB)
 * �׽�Ʈ 28 ��	��� (0.08ms, 76.5MB)
 * �׽�Ʈ 29 ��	��� (0.18ms, 75.2MB)
 * �׽�Ʈ 30 ��	��� (0.12ms, 70.2MB)
 * �׽�Ʈ 31 ��	��� (0.10ms, 79.3MB)
 * �׽�Ʈ 32 ��	��� (1.00ms, 83.5MB)
 * �׽�Ʈ 33 ��	��� (0.82ms, 124MB)
 * �׽�Ʈ 34 ��	��� (0.14ms, 110MB)
 */