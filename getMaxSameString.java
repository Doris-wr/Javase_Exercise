package 常用类.练习题;

import org.junit.Test;

/**
 * @Author:wangrui
 * @Date:2020/3/8 15:13
 */
public class StringDemo3 {
    /*
     * 功能描述：获取两个字符串中最大相同字串
     * @return java.lang.String
     */
    //提示：将短的那个串进行长度依次递减的字串与较长的串比较
    public String getMaxSameString(String str1,String str2){
        if(str1!=null&&str2!=null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();
            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }
                }
            }
        }
        return null;
    }
    @Test
    public void testgetMaxSameString(){
        String str1="abcwerthello1yuiodefabcdef";
        String str2="cvhello1bum";
        String maxSameString=getMaxSameString(str1,str2);
        System.out.println(maxSameString);
    }
}
