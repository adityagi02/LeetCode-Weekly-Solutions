// Aditya Tyagi 

public int countCollisions(String d) {
        int r=0;
        int count =0;
        char[] s = d.toCharArray();
        for(int i=0; i< s.length; i++){
            if( s[i]=='R'){
                r++;
            }else {
                count += r;
                r=0;
            }
        }
        int l=0;
        for(int i=d.length()-1; i>=0; i--){
            if( s[i]=='L'){
                l++;
            }else{
                count +=  l;
                l=0;
            }
        }        
        return count;
    }
