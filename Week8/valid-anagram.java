class Solution {
    public boolean isAnagram(String s, String t) {
        //1. 自己解法，使用Java自带的HashMap类，时间空间效率都比较低
        // HashMap<Character,Integer> mapS = new HashMap<Character,Integer>();

        // char[] schars = s.toCharArray();
        // char[] tchars = t.toCharArray();

        // for (int i = 0; i < schars.length;i++){
        //     if (mapS.containsKey(schars[i])){
        //         int count = mapS.get(schars[i]);
        //         count++;
        //         mapS.put(schars[i],count);
        //     }else{
        //         mapS.put(schars[i],1);
        //     }
        // }

        // for (int i = 0; i < tchars.length;i++){
        //     if (mapS.containsKey(tchars[i])){
        //         int count = mapS.get(tchars[i]);
        //         count--;
        //         if (count>0){
        //             mapS.put(tchars[i],count);
        //         }else{
        //             mapS.remove(tchars[i]);
        //         }
        //     }else{
        //         return false;
        //     }
        // }

        // if (mapS.isEmpty()){
        //     return true;
        // }else{
        //     return false;
        // }

        //2. 精选题解，用数组来做hash table，用char-‘a’的值做下标（key）
        if(s.length() != t.length())
            return false;
        int[] hashTable = new int[26];
        for (int i = 0;i<s.length();i++){
            hashTable[s.charAt(i)-'a']++;
            hashTable[t.charAt(i)-'a']--;
        }
        for (int i = 0;i<26;i++){
            if (hashTable[i]!=0){
                return false;
            }
        }
        return true;

    }
}
