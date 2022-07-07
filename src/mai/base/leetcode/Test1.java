package mai.base.leetcode;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 * 大写字母：A-Z 65-90    小写字母： a-z 97-122
 *
 */
public class Test1 {

    public static void main(String[] args) {
        int i = longesPalindrome("abccccdd"); // dccaccd
        System.out.println(i);
        int[] rel = new int[122];
        rel['A'] = 199;
        System.out.println(rel);
    }

    /**
     * 方法1
     *  思路： 回文串即是正反可读的字符串：能组成回文的条件是：相同字符成偶 可加单一字符方中间
     *  1.1 如何判断同一字符出现的次数？
     *  答： 通过数组记录：字符的ascii码作为数组的下标 次数作为对应下标的数值
     * @param test
     * @return
     */
    public static int longesPalindrome(String test) {
       int[] rel = new int[128];
       char[] arr = test.toCharArray();
       for(char c : arr) rel[c]++;
       int res = 0;
       // i - (i % 2): 计算得小于或等于i的最大偶数数量 2的倍数必然是可以回文的
       // for(int i:rel) res += i - (i & 1);
       for(int i:rel) res += i - (i % 2);
       //最终长度==源字符串长度 ： 每个字符都符合回文链
       //最终长度<源字符串长度 ： 存在单独的字符 取1方中间位置符合回文规则
       return res == arr.length ? res :res +1;
    }

    /**
     * java8用法
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int sum = (int) s.chars().boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .mapToLong(Long::longValue)
                .map(i -> i - (i & 1))
                .sum();
        return sum < s.length() ? sum + 1 : sum;
    }
}
