
class Solution {
    public int solution(int storey) {
        
        // init variables
        int answer = 0;
        int quotients = 0;
        int remains = 0;
        int loopCount = (int)(Math.log10(storey)) +1;
            
        // logic
        while (loopCount >= 0) {
            quotients = storey / 10;
            remains = storey % 10;
            
            if ((remains == 5) && ((quotients%10) >=5)) {
                answer += (10-remains);
                quotients += 1;
            } else if (remains <= 5){
                answer += remains;
            } else {
               answer += (10-remains);
                quotients += 1;
            }
            storey = quotients;
            loopCount--;
        }
        
        return answer;
    }
}
