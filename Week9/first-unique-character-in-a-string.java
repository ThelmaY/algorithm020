class Solution {
    public int firstUniqChar(String s) {
        char[] charArr = s.toCharArray();
        int[] sortArr = new int[26];

        for (int i = 0;i<charArr.length;i++){
            sortArr[charArr[i]-'a']++;
        }

        for (int i = 0;i<charArr.length;i++){
            if (sortArr[charArr[i]-'a'] == 1) return i;
        }

        return -1;
    }
}