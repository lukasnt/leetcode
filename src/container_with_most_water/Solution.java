package container_with_most_water;

class Solution {

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] * (height.length - i - 1) < max) continue;
            for (int j = i + 1; j < height.length; j++) {
                int l = j - i;
                int area = Math.min(height[i], height[j]) * l;
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[] {1, 1}));
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,25,7}));
        System.out.println(maxArea(new int[] {1,3,2,5,25,24,5}));

    }
}