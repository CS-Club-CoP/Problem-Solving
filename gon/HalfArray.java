import java.util.*;
import java.util.stream.Collectors;

public class HalfArray {
    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int[] queue2) {
        int sumQ1 = Arrays.stream(queue1).sum();
        int sumQ2 = Arrays.stream(queue2).sum();
        int sum = sumQ1 + sumQ2;

        // 홀수면 종료
        if (sum % 2 == 1)
            return -1;
        sum /= 2;

        Queue<Integer> q1 = Arrays.stream(queue1).boxed().collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> q2 = Arrays.stream(queue2).boxed().collect(Collectors.toCollection(LinkedList::new));

        int p1 = 0;
        int p2 = 0;
        int limit = queue1.length * 2;

        while (p1 <= limit && p2 <= limit) {
            if (sumQ1 == sum) return p1 + p2;
            if (sumQ1 > sum) {
                int node = q1.poll();
                q2.add(node);
                sumQ1 -= node;
                sumQ2 += node;
                p1 ++;
            } else {
                int node = q2.poll();
                q1.add(node);
                sumQ2 -= node;
                sumQ1 += node;
                p2 ++;
            }
        }
        return -1;
    }
}
