class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length-1; i>=0;i--){
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }
        // if (digits[0] == 0){
        //     int[] result = new int[length+1];
        //     result[0] = 1;
        //     for (int i = 0;i<length;i++){
        //         result[i+1] = digits[i];
        //     }
        //     return result;
        // }

        //可以用更简洁的方法写
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}