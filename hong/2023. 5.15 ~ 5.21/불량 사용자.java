import java.util.*;
class Solution {
    
    HashSet<HashSet<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        dfs(new HashSet<String>(), user_id, banned_id, 0);
		return result.size();
    }
    
    private void dfs(HashSet<String> set, String[] users, String[] banns, int depth) {
		// 기저: 모든 불량사용자 처리완료
		if (depth == banns.length) {
			result.add(set);
			return;
		}
		
		// 모든 아이디 검사
		for (int i=0; i<users.length; i++) {
            if (set.contains(users[i]))
				continue;

			// 불량사용자 검사 
			if (isBanned(users[i], banns[depth])) {
				set.add(users[i]);
				dfs(new HashSet<String>(set), users, banns, depth+1);
				set.remove(users[i]);
			}
		}
	}
	
	private boolean isBanned(String userId, String bannedId) {
		// 길이 다르면 ㄴ
		if (userId.length() != bannedId.length()) {
			return false;
		}
		
		for (int i=0; i<userId.length(); i++) {
			char userChar = userId.charAt(i);
			char bannChar = bannedId.charAt(i);
			
			// 와일드카드이면 pass
			if (bannChar == '*')
				continue;
			
			if (userChar != bannChar) {
				return false;
			}
		}
		
		return true;
	}
}