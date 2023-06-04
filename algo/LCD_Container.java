package algo;

public class LCD_Container {

    public static int maxArea(int[] height) {
        int left = 0;
        int width = height.length - 1;
        int right = width;
        int water = 0;

        while (width != 0) {
            int temp = height[left] < height[right] ? height[left] : height[right];
            water = water < temp * width ? temp * width : water;

            width--;
            if (height[left] <= height[right]) left++;
            else right--;
        }
        return water;
    }
}
