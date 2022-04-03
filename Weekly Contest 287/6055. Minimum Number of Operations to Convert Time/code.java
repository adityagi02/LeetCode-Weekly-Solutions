// 6055. Minimum Number of Operations to Convert Time
// Solution in JAVA


class Solution {
    public int convertTime(String current, String correct) {
        String[] arrOfCurr = current.split(":");
        String[] arrOfCorr = correct.split(":");
        int[] arr = new int[2];
        int[] carr = new int[2];
         
        arr[0] =  Integer.parseInt(arrOfCurr[0])*60 + Integer.parseInt(arrOfCurr[1]);
        carr[0] =  Integer.parseInt(arrOfCorr[0])*60 + Integer.parseInt(arrOfCorr[1]);
        
        int n = Math.abs(arr[0]-carr[0]);
        System.out.println(n);
        
        
        int count = 0;
        while(n != 0){
            if(n>=60){
                count = count + n/60;
                n = n%60;
            }
            if(n>=15){
                count = count + n/15;
                n = n%15;
            }
            else if(n>=5 && n<15){
                count = count + n/5;
                n = n%5;
            }
            else if(n>=1 && n<5){
                count = count + n/1;
                n = n%1;
            }
        }
        
        return count;
    }
}
