package cn.ch.test;

import cn.ch.enums.ShareTypeEnum;
import cn.ch.enums.UpdateCycleEnum;

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

    public static void main(String[] args) {
        int[][] matrix = {
                {11,74,0,93},
                {40,11,74,7},
        };
        isToeplitzMatrix(matrix);

    }
}
