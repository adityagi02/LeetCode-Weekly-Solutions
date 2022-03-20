class Solution {
public:
    int countCollisions(string directions) {
        int n=directions.length();
        int col=0;
        int rtrain=1;
        for(int i=0;i<n-1;i++)
        {
            
            if(directions[i]=='R'&&directions[i+1]=='L')
            {
                
                directions[i+1]='S';
                col+=rtrain+1;
                rtrain=1;
            }
            else if(directions[i]=='R'&&directions[i+1]=='S')
            {col+=rtrain;
             rtrain=1;
            }
            else if(directions[i]=='R'&&directions[i+1]=='R')rtrain++;
            else if(directions[i]=='S'&&directions[i+1]=='L')
            {
                directions[i+1]='S';
                col+=1;
                
            }
        }
        return(col);
        
    }
};
