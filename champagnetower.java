import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public static void champagneTower(int poured) {
        // double dp[102][102];
        // double[][] dp = new double[query_row + 2][query_row + 2];
        double[][] dp = new double[15][15];
        dp[0][0] = (double)poured;
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < i + 1; j++){
                if(dp[i][j] >= (double)1){
                    double remaining = dp[i][j] - 1;
                    dp[i + 1][j] = dp[i + 1][j] + remaining/(double)2;
                    dp[i + 1][j + 1] = dp[i + 1][j + 1] + remaining/(double)2;
                    dp[i][j] = (double)1;
                } else {
                    continue;
                }
            }
        }
        for(int i = 0; i < 15; i++){
            for(int j = (15 - i)/2; j >= 0; j--){
                System.out.print(" ");
            }
            for(int j = 0; j < i + 1; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        // return dp[query_row][query_glass];
    }

    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i < n; i++){
            champagneTower(i);
        }
    }
};