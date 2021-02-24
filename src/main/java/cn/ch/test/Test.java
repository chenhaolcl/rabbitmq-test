package cn.ch.test;

import cn.ch.enums.ShareTypeEnum;
import cn.ch.enums.UpdateCycleEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * @Classname Test
 * @Description
 * @create 2021/2/4
 * @Author random
 */
public class Test {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null){
            return true;
        }
        if (matrix.length == 1 || matrix[0].length == 1){
            return true;
        }
        int a = matrix.length-2;
        int b = 0;
        for (int i = a, j = b; a>=0 ; a--, j = b, i = a){
            while (i <= matrix.length - 2 && j <= matrix[0].length - 2){
                if (matrix[i][j] != matrix[i+1][j+1]){
                    return false;
                }
                i++;
                j++;
            }
        }
        a = 0;
        b = 1;
        for (int i = a, j = b; b <= matrix[0].length - 2 ; b++, i = a, j = b){
            while (j <= matrix[0].length - 2 && i <= matrix.length - 2){
                if (matrix[i][j] != matrix[i+1][j+1]){
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int num = 0;
        for (int i = 0; i < customers.length; i++){
            if (grumpy[i] == 0){
                num+=customers[i];
            }
        }
        int max = 0,save = 0;
        for (int i = 0; i < X; i++){
            save += customers[i] * grumpy[i];
            max = save;
        }
        for (int i = X; i < customers.length; i++){
            save = save + customers[i]*grumpy[i] - customers[i-X]*grumpy[i-X];
            max = Math.max(save,max);
        }
        return num+max;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n/2; j++){
                int num = A[i][j];
                A[i][j] = A[i][n-j-1];
                A[i][n-j-1] = num;
                if (A[i][j] == 1){
                    A[i][j] = 0;
                }else {
                    A[i][j] = 1;
                }
                if (A[i][n-j-1] == 1){
                    A[i][n-j-1] = 0;
                }else {
                    A[i][n-j-1] = 1;
                }
            }
        }
        if (n % 2 == 1){
            int j = n / 2;
            for (int i = 0; i < m; i++){
                if (A[i][j] == 1){
                    A[i][j] = 0;
                }else {
                    A[i][j] = 1;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {11,74,0,93},
//                {40,11,74,7},
//        };
//        isToeplitzMatrix(matrix);


//        int [] c = {1,0,1,2,1,1,7,5};
//        int [] g = {0,1,0,1,0,1,0,1};
//        maxSatisfied(c,g,3);
        String s = "正则";
        System.out.println(s.matches("[0-9]+"));

    }
}
