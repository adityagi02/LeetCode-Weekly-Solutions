class Solution {
public:
    int minBitFlips(int start, int goal) {
        int n = 0;
        unsigned int count = 0;
        n = start ^ goal;
          while (n) {
          count += n & 1;
           n >>= 1;
           }
         return count;
      }
};
