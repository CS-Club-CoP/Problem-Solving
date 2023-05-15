package csclub;

import java.util.*;

public class Banned {

    static HashSet<HashSet<String>> answer;

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};
        System.out.println(solution(user_id, banned_id));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        answer = new HashSet<>();

        dfs(new LinkedHashSet<>(), user_id, banned_id);

        return answer.size();
    }

    private static void dfs(HashSet<String> set, String[] user_id, String[] banned_id) {
        if (set.size() == banned_id.length) {
            if (isBanList(set, banned_id)) {
                answer.add(new HashSet<>(set));
            }
            return;
        }

        for (String userId : user_id) {
           if (set.add(userId)) {
               dfs(set, user_id, banned_id);
               set.remove(userId);
           }
        }
    }

    private static boolean isBanList(HashSet<String> set, String[] banned_id) {
        int idx = 0;
        for (String userId : set) {
            String banID = banned_id[idx++];
            if (userId.length() != banID.length()) {
                return false;
            }
            for (int i = 0; i < banID.length(); i++) {
                if (banID.charAt(i) == '*')
                    continue;

                if (userId.charAt(i) != banID.charAt(i))
                    return false;
            }
        }
        return true;
    }
}