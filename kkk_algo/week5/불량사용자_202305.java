import java.util.*;

/**
 * 2023.05.15 - 05.21
 * 불량사용자
 * https://school.programmers.co.kr/learn/courses/30/lessons/64064
 */
public class 불량사용자_202305 {
    static boolean[] visited;
    static List<Integer>[] idlist;

    static Set<String>  idset;

    public static int solution(String[] user_id, String[] banned_id) {

        visited = new boolean[user_id.length];
        idlist = new ArrayList[banned_id.length];
        idset = new HashSet<>();

        for(int i = 0; i < banned_id.length; i++){
            idlist[i] = new ArrayList<>();
        }

        for(int i = 0; i < banned_id.length; i++){
            String ban = banned_id[i];

            for(int j = 0; j < user_id.length; j++){
                String user = user_id[j];

                if(compareStr(ban, user)){
                    idlist[i].add(j);
                }
            }
        }

        int len = idlist[0].size();
        int[] johab = new int[banned_id.length];
        for(int i = 0; i < len; i++){
            visited[idlist[0].get(i)] = true;
            johab[0] = idlist[0].get(i);
            GoJohab(1, johab);
            visited[idlist[0].get(i)] = false;
        }

        return idset.size();
    }

    public static void GoJohab(int level, int[] johab){
        int[] tmpjo = Arrays.copyOf(johab, johab.length);

        if(level == idlist.length){
            Arrays.sort(tmpjo);
            StringBuffer sb = new StringBuffer();
            for(int a : tmpjo) sb.append(a);
            idset.add(sb.toString());
            return;
        }

        int len = idlist[level].size();
        for(int i = 0; i < len; i++){
            if(visited[idlist[level].get(i)] == false){
                visited[idlist[level].get(i)] = true;
                tmpjo[level] = idlist[level].get(i);
                GoJohab(level+1, tmpjo);
                visited[idlist[level].get(i)] = false;
            }
        }
    }

    public static boolean compareStr(String ban, String user){
        int banLen = ban.length();
        int userLen = user.length();

        if(banLen != userLen){
            return false;
        }

        for(int i = 0; i < banLen; i++){
            if(ban.charAt(i) == '*'){
                continue;
            }

            if(ban.charAt(i) != user.charAt(i)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int a = solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"});
        int b = solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"});
        int c = solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"});
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

/**
 * 정확도테스트
 * 테스트 1 〉	통과 (0.46ms, 75.1MB)
 * 테스트 2 〉	통과 (0.65ms, 65.7MB)
 * 테스트 3 〉	통과 (0.54ms, 77.6MB)
 * 테스트 4 〉	통과 (0.67ms, 73.5MB)
 * 테스트 5 〉	통과 (31.65ms, 104MB)
 * 테스트 6 〉	통과 (2.05ms, 75.3MB)
 * 테스트 7 〉	통과 (0.51ms, 70.4MB)
 * 테스트 8 〉	통과 (0.54ms, 78.4MB)
 * 테스트 9 〉	통과 (0.58ms, 75.6MB)
 * 테스트 10 〉	통과 (0.46ms, 77.2MB)
 * 테스트 11 〉	통과 (0.57ms, 77.8MB)
 */