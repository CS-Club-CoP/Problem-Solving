class Solution {
    public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxWater = 0;

		while (left <= right) {
			// 계산해보기
			int water = calculate(right - left, Math.min(height[left], height[right]));
			maxWater = Math.max(maxWater, water);
			
			// 왼/오 어디를 옮겨볼지 결정
			// 더 짧은 쪽을 포기하고 옮김
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		
		return maxWater;        
    }
    
    private int calculate(int width, int height) {
		int water = width * height;
		return water;
	}

}