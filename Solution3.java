package com.burk.solution3;

import java.util.HashMap;
import java.util.Random;
import java.util.RandomAccess;

public class Solution3 {

    Random rand = new Random();
    public int penalty = rand.nextInt(1195)+7;
//    public int penalty = 10;
    public static HashMap <Character, Integer> letterFrequency = new HashMap<Character, Integer>();
    public void initLetterFrequencyTable(){
        letterFrequency.put('E', 1202);
        letterFrequency.put('T', 910);
        letterFrequency.put('A', 812);
        letterFrequency.put('O', 768);
        letterFrequency.put('I', 731);
        letterFrequency.put('N', 695);
        letterFrequency.put('S', 628);
        letterFrequency.put('R', 602);
        letterFrequency.put('H', 592);
        letterFrequency.put('D', 432);
        letterFrequency.put('L', 398);
        letterFrequency.put('U', 288);
        letterFrequency.put('C', 271);
        letterFrequency.put('M', 261);
        letterFrequency.put('F', 230);
        letterFrequency.put('Y', 211);
        letterFrequency.put('W', 209);
        letterFrequency.put('G', 203);
        letterFrequency.put('P', 182);
        letterFrequency.put('B', 149);
        letterFrequency.put('V', 111);
        letterFrequency.put('K', 69);
        letterFrequency.put('X', 17);
        letterFrequency.put('Q', 11);
        letterFrequency.put('J', 10);
        letterFrequency.put('Z', 7);
    }


    // 计算最长公共子串的权重
    // 构建resMatrix矩阵
    public void LCS(String str1, String str2){

        int length1 = str1.length();
        int length2 = str2.length();

        int[][] resMatrix = new int[length1 + 1][length2 + 1];
        int maxWeight = 0;
        StringBuilder LCsubtring = new StringBuilder();

        long startTime = System.currentTimeMillis();

        for(int i = 1; i < length1 + 1; i++){
            for(int j = 1; j < length2 + 1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    resMatrix[i][j] = resMatrix[i-1][j-1] + Solution3.letterFrequency.get(str1.charAt(i-1));
//                    resMatrix[i][j] = resMatrix[i-1][j-1] + 1;
                    maxWeight = Math.max(maxWeight, resMatrix[i][j]);
                }
                else{
                    resMatrix[i][j] = resMatrix[i-1][j-1] - penalty;
//                    resMatrix[i][j] = resMatrix[i-1][j-1] - 10;

                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("This algorithm spend " + (endTime - startTime) + "ms.");

        // 打印最长公共子串的权重
        System.out.println( "Maxweight: " + maxWeight);
        System.out.println("Penalty: " + penalty);


        // 打印最长公共子串及其长度
        label: for(int i = 1; i < str1.length() + 1; i++){
            for(int j = 1; j < str2.length() + 1; j++){
                if(maxWeight == resMatrix[i][j]){
                    while(resMatrix[i][j] > 0){
                        // 从头开始插入
                        LCsubtring.insert(0, str1.charAt(i - 1));
                        i--;
                        j--;
                    }
                    System.out.println("This substring is: " + LCsubtring);
                    System.out.println("Length of this substring: " + LCsubtring.length());
                    break label;
                }
            }
        }
        // 打印resMatrix矩阵方便比对
//        for(int i = 0; i < str1.length() + 1; i++){
//            for(int j = 0; j < str2.length() + 1; j++){
//                System.out.printf("%7s", resMatrix[i][j]);
//            }
//            System.out.println("\n");
//        }
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.initLetterFrequencyTable();
        solution3.LCS("ABCAABCAA","ABBCAACCBBBBBB");




    }
}
