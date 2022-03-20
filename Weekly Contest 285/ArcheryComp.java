// Aditya Tyagi




public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {

    /*
     keep track of bitmask vs ( score gained , min arrowsConsumed)
     
     Ex : 000000000100 vs (2 , 5 )
     represents we have gained score for 2nd target only 
     for that state -- how much score we have gained, how many min arrows we consumed. 
     -- we gained 2 points , had to spend 5 arrows.
     
     at each step , we add min arrows required to gain the score.
     base case -> for 000000000000 --> score = 0 , arrowConsumed = 0 
     map just contains  1 mask as of now
     i = 1 --> for 000000000010 -->  score = 1 , arrowConsumed = aliceArrows + 1 
     so , now map contains two masks 000000000000 , 000000000010.
     
     .. at every step, we atmost double the number of entries in our map .  
     .. before adding to map , we check if newArrowsConsumed is within numArrows.
     .. In the end , we iterate over whole map , find mask with best score.
     .. convert bestmask to bobArray.Or We can modify aliceArrows in place.
     .. If there are some arrow still left after allocation 
     , they can go to any target. lets put them to target 0. 
    
    */
    
    //  keep track of bitmask vs ( score , arrowsConsumed)
    HashMap<Integer , Node> map = new HashMap();
    
    map.put(0 , new Node(0,0)); // bottom case - when 0th target is seen and 0 arrows are consumed. 
    
    for(int i = 1 ;  i <= 11; i++){
        
        HashMap<Integer , Node> newMap = new HashMap();
        
        for(HashMap.Entry<Integer , Node> entry :   map.entrySet()){
            
            // add current element, if arrows consumed is less than numArrows 
            
            int arrowConsumed = entry.getValue().arrow + aliceArrows[i] + 1 ;
            int mask = entry.getKey();
            int score = entry.getValue().score ;
            
            if(arrowConsumed <= numArrows){
                newMap.put( mask | (1 << i) , new Node(score + i , arrowConsumed));
            }
            
            
            
        }
        
        // augment new values to map.
        for(HashMap.Entry<Integer , Node> entry :   newMap.entrySet()){
            
            map.put(entry.getKey() , entry.getValue());
        }
        
    
        
    }
    
    // find best mask
    int bestMask = 0 ; int maxScore = 0 ;
    for(HashMap.Entry<Integer , Node> entry :   map.entrySet()){
        
        int score = entry.getValue().score ;
        
        if(score > maxScore){
            maxScore = score ;
            bestMask = entry.getKey();
        }
        
        
    }
    
    // convert best mask to array. 
    int arrowsLeft = numArrows ; 
   for(int i = 0 ;  i <= 11; i++){
       
       boolean shouldUse =  ( ( bestMask & (1 <<i)  )!= 0 ) ;
       
       if(shouldUse){
           aliceArrows[i] =  (aliceArrows[i] +1);
           arrowsLeft -= aliceArrows[i];
       }
       else 
           aliceArrows[i] = 0 ;
       
       
   }
    
    // allocate extra arrows to 0th target. 
    aliceArrows[0] = arrowsLeft ;
    
    return aliceArrows ;
}


class Node{
    int score ; int arrow ;
    Node(int score , int arrow ){
        this.score = score ;
        this.arrow = arrow ;
    }
}
