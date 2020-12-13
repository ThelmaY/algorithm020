class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;

        for (int i = 0;i<bills.length;i++){
            if (bills[i] == 5){
                count5++;
                continue;
            }else if (bills[i] == 10 && count5>0){
                count5--;
                count10++;
                continue;
            }else if (bills[i] == 20){
                if (count10 > 0 && count5>0){
                    count10--;
                    count5--;
                    continue;
                }else if (count5>2){
                    count5 = count5 - 3;
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}