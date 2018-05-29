package org.eda1.practica02.ejercicio03;

public class ComputoDistancia {
	
    private static int minimum(int a, int b, int c) {
       	if(a<=b && a<=c)  return a;
        if(b<=a && b<=c)  return b;
        return c;
    }
 
    public static int computeLevenshteinDistance(String str1, String str2) {
    	char[] cStr1 = str1.trim().toCharArray();
    	char[] cStr2 = str2.trim().toCharArray();
    	int [][]distance = new int[cStr1.length+1][cStr2.length+1];
 
        for (int i=0;i<=cStr1.length;i++)
           distance[i][0]=i;
        
        for (int j=0;j<=cStr2.length;j++)
           distance[0][j]=j;
        
        for (int i=1;i<=cStr1.length;i++)
           for(int j=1;j<=cStr2.length;j++)
              distance[i][j]= minimum(distance[i-1][j]+1, distance[i][j-1]+1, distance[i-1][j-1]+ ((cStr1[i-1]==cStr2[j-1])?0:1));
          return distance[cStr1.length][cStr2.length];
    }
}
