package cn.ch.test;

import cn.ch.enums.ShareTypeEnum;
import cn.ch.enums.UpdateCycleEnum;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

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

        return A;
    }

    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length ; j++){
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    TrieNode root;

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        root = new TrieNode();

        for (String word : words) {
            // 将 word 中的字母按照字典序排序并去重
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < arr.length; ++i) {
                if (i == 0 || arr[i] != arr[i - 1]) {
                    sb.append(arr[i]);
                }
            }
            // 加入字典树中
            add(root, sb.toString());
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (String puzzle : puzzles) {
            char required = puzzle.charAt(0);
            char[] arr = puzzle.toCharArray();
            Arrays.sort(arr);
            ans.add(find(new String(arr), required, root, 0));
        }
        return ans;
    }

    public void add(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (cur.child[ch - 'a'] == null) {
                cur.child[ch - 'a'] = new TrieNode();
            }
            cur = cur.child[ch - 'a'];
        }
        ++cur.frequency;
    }

    // 在回溯的过程中枚举 puzzle 的所有子集并统计答案
    // find(puzzle, required, cur, pos) 表示 puzzle 的首字母为 required, 当前搜索到字典树上的 cur 节点，并且准备枚举 puzzle 的第 pos 个字母是否选择（放入子集中）
    // find 函数的返回值即为谜底的数量
    public int find(String puzzle, char required, TrieNode cur, int pos) {
        // 搜索到空节点，不合法，返回 0
        if (cur == null) {
            return 0;
        }
        // 整个 puzzle 搜索完毕，返回谜底的数量
        if (pos == 7) {
            return cur.frequency;
        }

        // 选择第 pos 个字母
        int ret = find(puzzle, required, cur.child[puzzle.charAt(pos) - 'a'], pos + 1);

        // 当 puzzle.charAt(pos) 不为首字母时，可以不选择第 pos 个字母
        if (puzzle.charAt(pos) != required) {
            ret += find(puzzle, required, cur, pos + 1);
        }
        return ret;
    }

    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, k);
    }

    public int dfs(String s, int k) {
        if (s.length() < k){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (char c : map.keySet()){
            if (map.get(c) < k){
                int res = 0;
                for (String t : s.split(String.valueOf(c))){
                    res = Math.max(res, dfs(t,k));
                }
                return res;
            }
        }
        return s.length();
    }


    public boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        int n = A.length;
        for (int i = 0; i < n - 1; ++i) {
            if (A[i] > A[i + 1]) {
                inc = false;
            }
            if (A[i] < A[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }


//    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
//        Map<Integer,Integer> state = new HashMap<>();
////        for (int i = 0; i < words.length; i++){
////            String s = words[i];
////            int temp = 0;
////            for (int j = 0;j < s.length(); j++){
////                temp = temp | (1 << s.charAt(j) - 'a');
////            }
////            state.put(temp, state.getOrDefault(temp,0)+1);
////        }
//    }

//    int[][] sums;
//    int[][] oneSums;
//
//    public NumMatrix(int[][] matrix) {
//        int m = matrix.length;
//        if (m > 0){
//            int n = matrix[0].length;
//            sums = new int[m][n+1];
//            for (int i = 0; i < m; i++){
//                for (int j = 0; j < n; j++){
//                    sums[i][j+1] = sums[i][j] + matrix[i][j];
//                }
//            }
//        }
//       int m = matrix.length;
//       if (m > 0){
//            int n = matrix[0].length;
//            sums = new int [m+1][n+1];
//            oneSums = new int [m][n+1];
//            for (int i = 0; i < m; i++){
//                for (int j = 0; j < n; j++){
//                    oneSums[i][j+1] = oneSums[i][j] + matrix[i][j];
//                    sums[i+1][j+1] = sums[i][j+1] + oneSums[i][j+1];
//                }
//            }
//       }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//        for (int i = row1; i <= row2; i++){
//            sum = sum + sums[i][col2] - sums[i][col1];
//        }
//        return sum;
//        return sums[row2][col2] - sums[row2][col1] - sums[row1][col2] + sums[row1][col1];
//    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, (e1,e2)->{
            if (e1[0] != e2[0]) {
                return e1[0] - e2[0];
            } else {
                return e2[1] - e1[1];
            }
        });

        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }


    public int[] countBits(int num) {
        int [] bits = new int[num+1];
        int high = 0;
        for (int i = 1; i <= num; i++){
            if ((i & (i - 1)) == 0){
                high = i;
            }
            bits[i] = bits[i - high] + 1;
        }
        return bits;
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int n = points.length;
        int min = Integer.MAX_VALUE;
        int retx = -1;
        int rety = -1;
        for (int i = 0; i < n; i++){
            if (x == points[i][0]){
                min = Math.min(min,Math.abs(points[i][1] - y));
                if (min == Math.abs(points[i][1] - y)){
                    retx = points[i][0];
                    rety = points[i][1];
                }
            }
            if (y == points[i][1]){
                min = Math.min(min,Math.abs(points[i][0] - x));
                if (min == Math.abs(points[i][0] - x)){
                    retx = points[i][0];
                    rety = points[i][1];
                }
            }
        }
        return x == retx ? retx : rety;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {11,74,0,93},
//                {40,11,74,7},
//        };
//        isToeplitzMatrix(matrix);
        UpdateCycleEnum updateCycleEnum = UpdateCycleEnum.getKey("自定");
        if (updateCycleEnum != null){
            System.out.println(updateCycleEnum.getKey());
        }

//        int [] c = {1,0,1,2,1,1,7,5};
//        int [] g = {0,1,0,1,0,1,0,1};
//        maxSatisfied(c,g,3);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,1);
        Date tomorrowTime = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String s = "";
        int x = 10;
        System.out.println(!s.matches("[0-9]+"));
        System.out.println(false||false);
        x &= x-1;
        x &= x-1;
        System.out.println(x);
        int[] num = new int[10];
        System.out.println(num[0]);
        System.out.println(formatter.format(date));
        System.out.println(formatter.format(tomorrowTime));
        System.out.println(Math.abs(0));
        LocalDate localDate = null;
       // LocalDate tom = localDate.plusDays(1);
     //   System.out.println(tom.format(formatter1));
        List<String> list = new ArrayList<>();
        System.out.println(LocalDate.parse("2019-12-05"));
     //   System.out.println(Optional.ofNullable(localDate).isPresent());
        Optional.ofNullable(localDate).ifPresent(e->{
            System.out.println(localDate);
        });
        UploadFinanceDataReq req = new UploadFinanceDataReq();
        req.setBeginTime(null);
        Optional.ofNullable(req).ifPresent(e->{
            if (req.getBeginTime() != null){
                System.out.println(11111);
            }
        });

        System.out.println(UUID.randomUUID().toString());
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastYearDay = today.plusYears(-1);
        System.out.println(firstDay.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(lastYearDay.format(DateTimeFormatter.ISO_LOCAL_DATE));
        BigDecimal n = new BigDecimal(99999.99);
        BigDecimal numTest = new BigDecimal("10000");
        System.out.println(LocalDate.now().minusYears(1).format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.of(2018,11,23,18,0,0)));
        StringBuilder sb = new StringBuilder();
        sb.append("aaaaaaaaaaaaaa"+"\r\n");
        sb.append("bbbbbbbbbbbbbb");
        System.out.println(sb.toString());

    }
}
