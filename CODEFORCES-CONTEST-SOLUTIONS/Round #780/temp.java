

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays; 
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Collections;
        
public class temp {
      public static void main(String args[])
    { 
                Scanner sc = new Scanner(System.in);
                int t = sc.nextInt();
                for(int i =0;i<t;i++){
                  int p = sc.nextInt();
                  int arr[] = new int[p];
                  int carr[] = new int[p];
                  for(int j =0;j<p;j++){
                    arr[j] = sc.nextInt();
                  }
                  for(int g =0;g<p;g++){
                    carr[g] = arr[g];
                  }
                  Arrays.sort(arr); 
                  int f =0;
                  int x =0;
                  int e =0;
                  while(arr[p-2] != 0){
                      for(int b = e;b<p;b++){
                        f = carr[x];
                        arr[b] = arr[b] - f; 
                      }
                      e = e+1;
                      x = x+1;
                  }
                   if(arr[p-1]>=2) System.out.print("NO\n");
                   else System.out.print("YES\n");
                }
            }
        }
        
