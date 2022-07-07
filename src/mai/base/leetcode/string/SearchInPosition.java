package mai.base.leetcode.string;

public class SearchInPosition {

    public static void main(String[] args) {
        int i = doSearch(new int[]{1,2,4,5},3);
        System.out.println(i);
    }

    /**
     * 搜索插入位置
     * 二分法 [1,2,4,5] 3
     * 思路：游标法，初始化左右游标，获取游标之间的中心点，中心点的值与待插入的值对比，
     *      若小于中心值，说明符合位置在左游标和中心点之间，不包括中心点
     *      若大于中心值，说明符合位置在中心点和右游标之间，不包括中心点
     *      1： left=0 right=3  <   mod=1  2<3  left = 2
     *      2:  left=2 right=3  <   mod=2  4>3  right = 1
     *      3:  left=2 right=1  >   return left=2
     * @param nums
     * @param target
     * @return
     */
    public static int doSearch(int[] nums, int target) {
        // 二分法
        int left = 0, right = nums.length - 1;
        while(left <= right){   // left <= right ？ 为啥这样判断
            // 防止 left+right 整型溢出
            int mid = left + (right - left) / 2;    // x + (y-x)/2 = z    ==> 2x + y-x = 2z   =>   (x + y)/2 = z
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return left;    //为啥是返回left
    }
}
