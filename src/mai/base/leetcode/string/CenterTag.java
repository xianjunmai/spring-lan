package mai.base.leetcode.string;

public class CenterTag {

    public static void main(String[] args) {
        int[] list = new int[]{1,2,3,2,1};
        int tag = doCenterTagV2(list);
        System.out.println("tag: "+ tag);
    }

    /**
     * 寻找数组中心下标
     * 思路：循环数组 当前循环下标作为 假设中心下标 不符合则跳过
     *
     * @param list
     * @return
     */
    public static int doCenterTag(int[] list){
        int length = list.length;
        int tag = -1;
        for(int i=0;i<list.length;i++){
            int rightSl = i + 1;
            if(rightSl == 1){
                //走到最左边
                int rightAll = 0;
                for(int j=1;j<length;j++){
                    rightAll += list[j];
                }
                if(rightAll == 0){
                    tag = i;
                    break;
                }
            }else if(rightSl == length){
                //走到最右边
                int leftAll = 0;
                for(int j=0;j<i;j++){
                    leftAll += list[j];
                }
                if(leftAll == 0){
                    tag = i;
                    break;
                }
            }else{
                //走到中间
                int leftAll = 0;
                int rightAll = 0;
                for(int j=0;j<i;j++){
                    leftAll += list[j];
                }
                for(int k=rightSl;k<length;k++){
                    rightAll += list[k];
                }
                if(leftAll == rightAll){
                    tag = i;
                    break;
                }
            }
        }
        return tag;
    }

    /**
     * 思路：算总和 - 中心点 为偶数 有为中心点可能 算左边的总和是否为一半
     * 1. 计算数字值总和 count
     * 2. 计算除检查点x外的总和 afterCount = count - x
     * 2.1 afterCount&2 ==0 时为偶数 不为偶数时跳过当前循环
     * 3. 计算检查点左边的总和 for(0 -> ix){ leftCount += list[ix]}
     * 4. 判断 leftCount ？=  afterCount/2
     *  4.1 == return x
     *  4.3 != 检查下个点
     * @param list
     * @return
     */
    public static int doCenterTagV2(int[] list) {
        int allCount = 0;
        int tag = -1;
        for(int i=0;i<list.length;i++){
            allCount += list[i];
        }
        for(int i=0;i<list.length;i++){
            int afterCount = allCount - list[i];
            if(afterCount%2 != 0){
                continue;
            }
            int leftCount = 0;
            for(int j=0;j<i;j++){
                leftCount +=list[j];
            }
            if(afterCount/2 == leftCount){
                tag = i;
                break;
            }
        }
        return tag;
    }
}
