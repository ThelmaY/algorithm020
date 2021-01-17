class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0;i<chars.length;i=i+2*k){
            int end = Math.min(i+k-1, chars.length-1);
            int j = i;
            while(j<end){
                char temp = chars[j];
                chars[j++] = chars[end];
                chars[end--] = temp;
            }
        }
        return new String(chars);
    }
}