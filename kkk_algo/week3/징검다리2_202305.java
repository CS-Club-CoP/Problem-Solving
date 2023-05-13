import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * 2023.05.01 - 05.07
 * 징검다리
 * https://school.programmers.co.kr/learn/courses/30/lessons/43236
 */
public class 징검다리2_202305 {
    public static int solution(int distance, int[] rocks, int n) {
        /*
        1. 각 바위 사이의 거리를 배열에 계산(최대 50001, 시작점과 종점을 포함하기 때문)
        2. 가장 작은값을 찾아 없앤다는 느낌으로 처리
        * 정렬은 안됨 -> 바위의 위치가 고려되기 때문
        * 자료구조는 동적배열 or 정적배열?
        ** 동적배열 : 진행할 수록 탐색할 배열의 크기가 줄어듬
           ㄴ list형일 경우 배열의 크기 조정이 강제됨
           ㄴ linked list형일 경우 값 삭제는 빠르나 이분탐색이 어려움(한 인덱스를 조회하는데 풀서치)
        ** 정적배열 : 진행해도 배열의 크기가 고정
           ㄴ 직접 배열크기 조정? -> n이 최악의경우(50000근처)면 동적배열이 낫지만 아니면 걍 넘겨도됨
           ㄴ 탐색한 지점의 값 처리에 로직이 더 요구됨
        *** 탐색이 주 로직이므로 linked list보단 list로, 일단 동적배열로 구현시도
         */
        int answer = 0;

        //input에서도 rocks는 정렬 안되있음
        Arrays.sort(rocks);

        //각 바위간 거리 계산
        int[] dist = new int[rocks.length+1];

        //처음위치 거리 미리계산
        dist[0] = rocks[0];
        //마지막위치 거리 계산
        dist[rocks.length]=distance-rocks[rocks.length-1];

        //나머지 거리계산
        for(int i = 1; i < rocks.length; i++){
            dist[i] = rocks[i]-rocks[i-1];
        }

        jing_Node head = new jing_Node(null, null, dist[0]);
        jing_Node cur = head;

        for(int i = 1; i < dist.length; i++){
            jing_Node next = new jing_Node(cur, null, dist[i]);
            cur.setNext(next);
            cur = next;
        }

        for(int i = 0; i < n; i++){
            //최소값 array
            ArrayList<jing_Node> tmp = new ArrayList<>();

            jing_Node node = head;
            int minVal = node.getValue();
            while(node.getNext() != null){
                node = node.getNext();
                if(minVal > node.getValue()){
                    minVal = node.getValue();
                }
            }

            node = head;
            while(node.getNext() != null){
                if(node.getValue() == minVal){
                    tmp.add(node);
                }
                node = node.getNext();
            }

            //양 옆값 계산
            jing_Node last = null;
            int dir = -1; // 1 < ,2 >
            int val = -1;

            for(int j = 0, len = tmp.size(); j < len; j++){
                jing_Node tmpNode = tmp.get(j);
                int left = -1;
                int right = -1;

                if(tmpNode.prev != null){
                    left = tmpNode.getValue() + tmpNode.getPrev().getValue();
                }

                if(tmpNode.next != null){
                    right = tmpNode.getValue() + tmpNode.getNext().getValue();
                }

                if(left != -1){
                    if(last == null){
                        last = tmpNode;
                        dir = 1;
                        val = left;
                    }
                    else{
                        if(val > left){
                            last = tmpNode;
                            dir = 1;
                            val = left;
                        }
                    }
                }

                if(right != -1){
                    if(last == null){
                        last = tmpNode;
                        dir = 2;
                        val = right;
                    }
                    else{
                        if(val > right){
                            last = tmpNode;
                            dir = 2;
                            val = right;
                        }
                    }
                }
            }

            if(dir == 1){
                last.setValue(val);
                jing_Node prev = last.getPrev().getPrev();
                if(prev != null) prev.setNext(last);
                last.setPrev(prev);
            }
            else if(dir == 2){
                last.setValue(val);
                jing_Node next = last.getNext().getNext();
                if(next != null) next.setPrev(last);
                last.setNext(next);
            }

            jing_Node t = head;
            while(t != null){
                System.out.print(t.getValue() + " ");
                t = t.getNext();
            }
            System.out.println();

        }

        jing_Node test = head;
        answer = test.getValue();
        while(test.getNext() != null){
            test = test.getNext();

            if(test.getValue() == 0) continue;
            if(answer > test.getValue()){
                answer = test.getValue();
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        //System.out.println(solution(25, new int[]{2, 14, 11, 21, 17}, 2));
        //System.out.println(solution(100, new int[]{100}, 1));
        System.out.println(solution(18, new int[]{2,8,9,10,11,12,13}, 6));
    }

}

class jing_Node{
    jing_Node prev, next;
    int value;

    public jing_Node(jing_Node prev, jing_Node next, int value){
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public jing_Node getNext() {
        return next;
    }

    public jing_Node getPrev() {
        return prev;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(jing_Node next) {
        this.next = next;
    }

    public void setPrev(jing_Node prev) {
        this.prev = prev;
    }
}
