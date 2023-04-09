/**
 * 2023.04.03 - 09
 * 마법의 엘리베이터
 * https://school.programmers.co.kr/learn/courses/30/lessons/148653
 */
public class 마법의엘리베이터_202304 {
    public static int solution(int storey) {
        int answer = 0;

        /*
         - 1의 자리(c)부터 한자리씩 역으로 계산
         1. c  >  5 : 올림
         2. c  == 5 :
            - 앞자리(f) 숫자에 따라 변동
            2-1. f >=  5 :  올림
            2-2. f < 5 : 내림
         3. c  <  5 : 내림
         - storey값을 10으로 나눈 후 0이 될 때까지 1~3을 반복
         */

        while(storey > 0){
            int c = storey % 10;
            storey /= 10;

            //1.
            if(c > 5){
               answer += (10-c);
               storey++;
            }
            //2.
            else if(c == 5){
                int f = storey % 10;

                //2-1.
                if(f >= 5){
                    answer += (10-c);
                    storey++;
                }
                //2-2.
                else{
                    answer += c;
                }
            }
            //3.
            else{
                answer += c;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        /*
        storey  result
        16      6
        2554    16
         */

        int input1 = 16;
        int input2 = 2554;

        System.out.println(solution(input1));
        System.out.println(solution(input2));
    }
}

/**
 * 정확성 테스트
 * 테스트 1 〉	통과 (0.02ms, 75.2MB)
 * 테스트 2 〉	통과 (0.03ms, 76.3MB)
 * 테스트 3 〉	통과 (0.02ms, 74.3MB)
 * 테스트 4 〉	통과 (0.01ms, 72MB)
 * 테스트 5 〉	통과 (0.02ms, 77.5MB)
 * 테스트 6 〉	통과 (0.02ms, 77.2MB)
 * 테스트 7 〉	통과 (0.02ms, 72.3MB)
 * 테스트 8 〉	통과 (0.02ms, 76.2MB)
 * 테스트 9 〉	통과 (0.02ms, 75.6MB)
 * 테스트 10 〉	통과 (0.01ms, 86.9MB)
 * 테스트 11 〉	통과 (0.01ms, 77.3MB)
 * 테스트 12 〉	통과 (0.01ms, 77MB)
 * 테스트 13 〉	통과 (0.02ms, 75.5MB)
 */