import java.util.Scanner;

public class Main {

    private static int CHAR_RANGE = 128;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Solution of task №1");
        System.out.println("Input a string: ");

        String str = in.nextLine();
        str = findLargSubstrUniqChars(str);

        System.out.printf("The largest substring with unique characters is %s." + "\n", str);

        System.out.println();

        System.out.println("Solution of task №2");

        System.out.println("Input a number of elements of the first array: ");
        int FirstSize = in.nextInt();

        System.out.println("Input a number of elements of the second array: ");
        int SecondSize = in.nextInt();

        int[] arr1 = new int[FirstSize];
        int[] arr2 = new int[SecondSize];

        System.out.println("Input elements of the first array: ");
        for (int i = 0; i < arr1.length; ++i){
            arr1[i] = in.nextInt();
        }

        insertionSort(arr1);

        for (int i = 0; i < arr1.length; ++i){
            System.out.print(arr1[i] + " ");
        }

        System.out.println();

        System.out.println("Input elements of the second array: ");
        for (int i = 0; i < arr2.length; ++i){
            arr2[i] = in.nextInt();
        }

        insertionSort(arr2);

        for (int i = 0; i < arr2.length; ++i){
            System.out.print(arr2[i] + " ");
        }

        int[] arr = new int[FirstSize + SecondSize];

        arr = getTwoInOneArr(arr1, arr2, arr);

        System.out.println();

        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        System.out.println("Solution of task №3");

        System.out.println("Input a number of elements of an array: ");

        int Size = in.nextInt();
        int[] arr3 = new int[Size];

        System.out.println("Input elements of array: ");
        for (int i = 0; i < arr3.length; ++i){
            arr3[i] = in.nextInt();
        }

        int MaxSumOfSubarray = findMaxSumOfSubarray(arr3);
        System.out.printf("Maximum sum of array is %d.", MaxSumOfSubarray);

        System.out.println();

        System.out.println("Solution of task №4");

        System.out.println("Input a number of rows of an array: ");
        int rows = in.nextInt();

        System.out.println("Input a number of columns of an array: ");
        int cols = in.nextInt();

        int[][] arr2D = new int[rows][cols];

        System.out.println("Input elements of array: ");
        for (int i = 0; i < arr2D.length; ++i){
            for (int j = 0; j < arr2D[i].length; ++j) {
                arr2D[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < arr2D.length; ++i){
            for (int j = 0; j < arr2D[i].length; ++j) {
                System.out.print(arr2D[i][j] + " ");
            }
            System.out.println();
        }

        int[][] NewArr2D = rightRotateArray90deg(arr2D);

        for (int i = 0; i < arr2D.length; ++i){
            for (int j = 0; j < arr2D[i].length; ++j) {
                System.out.print(NewArr2D[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Solution of task №5");

        System.out.println("Input a number of elements of an array: ");

        int Size5 = in.nextInt();
        int[] arr5 = new int[Size5];

        System.out.println("Input elements of array: ");
        for (int i = 0; i < arr5.length; ++i){
            arr5[i] = in.nextInt();
        }

        System.out.println("Input a target: ");
        int target = in.nextInt();

        int[] Pair = findPair(arr5, target);
        System.out.printf("Pair of elements: %d + %d = %d", Pair[0], Pair[1], target);

        System.out.println();

        System.out.println("Solution of task №6");

        System.out.println("Input a number of rows of an array: ");
        rows = in.nextInt();

        System.out.println("Input a number of columns of an array: ");
        cols = in.nextInt();

        arr2D = new int[rows][cols];

        System.out.println("Input elements of array: ");
        for (int i = 0; i < arr2D.length; ++i){
            for (int j = 0; j < arr2D[i].length; ++j) {
                arr2D[i][j] = in.nextInt();
            }
        }

        int Sum = findSumOfAllElements(arr2D);
        System.out.printf("Sum of all elements of array: %d.", Sum);

        System.out.println();

        System.out.println("Solution of task №7");

        System.out.println("Input a number of rows of an array: ");
        rows = in.nextInt();

        System.out.println("Input a number of columns of an array: ");

        arr2D = new int[rows][cols];

        System.out.println("Input elements of array: ");
        for (int i = 0; i < arr2D.length; ++i){
            for (int j = 0; j < arr2D[i].length; ++j) {
                arr2D[i][j] = in.nextInt();
            }
        }

        arr = findMaxItemOfEachRow(arr2D);
        System.out.println();

        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        System.out.println("Solution of task №8");

        System.out.println("Input a number of rows of an array: ");
        rows = in.nextInt();

        System.out.println("Input a number of columns of an array: ");
        cols = in.nextInt();

        arr2D = new int[rows][cols];

        System.out.println("Input elements of array: ");
        for (int i = 0; i < arr2D.length; ++i){
            for (int j = 0; j < arr2D[i].length; ++j) {
                arr2D[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < arr2D.length; ++i){
            for (int j = 0; j < arr2D[i].length; ++j) {
                System.out.print(arr2D[i][j] + " ");
            }
            System.out.println();
        }

        NewArr2D = leftRotateArray90deg(arr2D);

        for (int i = 0; i < arr2D.length; ++i){
            for (int j = 0; j < arr2D[i].length; ++j) {
                System.out.print(NewArr2D[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String findLargSubstrUniqChars (String str){
        if (str == null || str.isEmpty()){
            return str;
        }
        // Sliding window algorithm
        boolean[] SlidWindow = new boolean[CHAR_RANGE];

        int LeftFrame = 0, RightFrame = 0;

        char lastWindChar;

        for (int LeftSlid = 0, RightSlid = 0; RightSlid < str.length(); RightSlid++){
            lastWindChar = str.charAt(RightSlid);

            if (SlidWindow[lastWindChar]){
                while (str.charAt(LeftSlid) != str.charAt(RightSlid)){
                    SlidWindow[str.charAt(LeftSlid)] = false;
                    LeftSlid++;
                }

                LeftSlid++;
            }
            else {
                SlidWindow[lastWindChar] = true;
                // Change a size of a window frame
                if (RightFrame - LeftFrame < RightSlid - LeftSlid) {
                    LeftFrame = LeftSlid;
                    RightFrame = RightSlid;
                }
            }
        }

        return str.substring(LeftFrame, RightFrame + 1);
    }

    public static int[] insertionSort (int[] arr) {
        int key = 0;
        int j = 0;
        for (int i = 1; i < arr.length; ++i){
            key = arr[i];
            j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        return arr;
    }

    public static int[] getTwoInOneArr (int[] arr1, int[] arr2, int[] arr){
        int i = 0, j = 0;
//        while (i < arr1.length){
//            arr[i] = arr1[i];
//            ++i;
//        }
//        while (i < arr.length && j < arr2.length){
//            arr[i] = arr2[j];
//            ++i;
//            ++j;
//        }

        while (i + j < arr1.length + arr2.length){
            // if arr2 is empty, or at least there is one element remained in both arr1 and arr2
            if (j >= arr2.length || (i < arr1.length && arr1[i] <= arr2[j])){
                arr[i + j] = arr1[i];
                ++i;
            }
            else {
                arr[i + j] = arr2[j];
                ++j;
            }
        }

        return arr;
    }

    public static int findMaxSumOfSubarray(int[] arr){
        //Kadane's algorithm
        int MaxSumOfSubarray = arr[0],
//                LeftPos = 0,
//                RightPos = 0,
                Sum = 0;
//                OverrideLeftPos = -1;

        for (int right = 0; right < arr.length; ++right){
              Sum += arr[right];
              MaxSumOfSubarray = Math.max(MaxSumOfSubarray, Sum);
              Sum = Math.max(Sum, 0);
//
//            if (Sum > MaxSumOfSubarray){
//                MaxSumOfSubarray = Sum;
//                LeftPos = OverrideLeftPos + 1;
//                RightPos = right;
//            }
//            if (Sum < 0){
//                Sum = 0;
//                OverrideLeftPos = right;
//            }
        }

        return MaxSumOfSubarray;
    }

    public static int[][] rightRotateArray90deg(int[][] arr){
        int[][] NewArr = new int[arr.length][arr[0].length];

        for (int i = 0; i < NewArr.length; ++i){
            for (int j = 0; j < NewArr[i].length; ++j){
                NewArr[j][NewArr.length - i - 1] = arr[i][j];
            }
        }

        return NewArr;
    }

    public static int[] findPair (int[] arr, int target){
        int[] Pair = {0, 0};
        for (int i = 0; i < arr.length - 1; ++i){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] + arr[j] == target){
                    Pair[0] = arr[i];
                    Pair[1] = arr[j];
                    return Pair;
                }
            }
        }

        return null;
    }

    public static int findSumOfAllElements(int[][] arr){
        int Sum = 0;
        for (int i = 0; i < arr.length; ++i){
            for (int j = 0; j < arr[i].length; j++){
                Sum += arr[i][j];
            }
        }

        return Sum;
    }

    public static int[] findMaxItemOfEachRow(int[][] arr){
        int[] MaxItems = new int[arr.length];
        int Row = 0;

        for (int i = 0; i < arr.length; ++i){
            for (int j = 0; j < arr[i].length; ++j){
                    MaxItems[i] = Math.max(arr[i][j], MaxItems[i]);
            }
        }

        return MaxItems;
    }

    public static int[][] leftRotateArray90deg(int[][] arr){
        int[][] NewArr = new int[arr.length][arr[0].length];

        for (int i = 0; i < NewArr.length; ++i){
            for (int j = 0; j < NewArr[i].length; ++j){
                NewArr[i][j] = arr[i][NewArr.length - j - 1];
            }
        }

        for (int i = 0; i < NewArr.length; ++i){
            for (int j = 0; j < NewArr[i].length; ++j){
                arr[i][j] = NewArr[j][i];
            }
        }

        return arr;
    }
}