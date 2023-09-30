import java.util.Scanner;

public class Main {

    private static int CHAR_RANGE = 128;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Solution of task №1");
        System.out.println();
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

        insertionSort(arr);

        return arr;
    }
}