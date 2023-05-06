class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0);
        return answer;
    }
    
    public static void dfs(int[] numbers, int target, int index) {
        // 기저
        if(index == numbers.length) {
            int sum = 0;
            for(int i=0; i<numbers.length; i++) {
                sum += numbers[i];
            }
            
            if(sum == target) {
                answer++;
            }
            return;
        }
        
        numbers[index] *= 1;
        dfs(numbers, target, index+1);
        
        numbers[index] *= -1;
        dfs(numbers, target, index+1);
    }
}