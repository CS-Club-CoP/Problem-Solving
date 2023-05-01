package algo;

public class PRG43165 {

    class Solution {
        int answer = 0;

        public int Main(int[] numbers, int target) {

            dfs(numbers, 0, target, 0);
            return answer;
        }

        public void dfs(int[] numbers, int d, int target, int sum, int i){
            if(d == numbers.length){
                if(target == sum) answer++;
            } else {
                dfs(numbers, d + 1, target, sum + numbers[d]); // 해당 노드의 값을 더하고 다음 깊이 탐색
                dfs(numbers, d + 1, target, sum - numbers[d]); // 해당 노드의 값을 빼고 다음 깊이 탐색
            }
        }
    }
}
