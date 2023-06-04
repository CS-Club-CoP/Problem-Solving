/**
 * 2023.05.29 - 06.04
 * Container With Most Water
 * ContainerWithMostWater
 */

public class ContainerWithMostWater_202306 {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0, r = height.length-1;

        while(l < r){
            int min = height[l] < height[r] ? height[l] : height[r];
            int val = ((r-l)* min);
            max = max > val ? max : val;

            if(height[l] > height[r]) r--;
            else l++;
        }

        return max;
    }
}