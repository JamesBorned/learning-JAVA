// Laboratory work №1
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //getNumOfStepsOfSyracuseSeq();
        //findSumOfSeries();
        //findTreasure();
        //logisticMaximin();
        isTwiceEvenNumber();
    }

    public static void getNumOfStepsOfSyracuseSeq(){
        System.out.print("Input N: ");

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int count = 0;

        if (N > 0) {
            while (N != 1) {
                if (N % 2 == 0) {
                    N = N / 2;
                    ++count;
                } else {
                    N = 3 * N + 1;
                    ++count;
                }
            }

            System.out.printf("The number of steps required by the Syracuse sequence\n" +
                    "starting from n to reach 1 for the first time:\n" +
                    "count = %d", count);
        }
        else {
                System.out.print("Error");
            }
    }

    public static void findSumOfSeries (){
        System.out.print("Input N: ");

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int SumOfSeries = 0;

        while (N > 0){
            int num = in.nextInt();

            if (N % 2 == 0){
                SumOfSeries += num;
            }
            else {
                SumOfSeries -= num;
            }

            --N;
        }

        System.out.printf("The sum of the series: " + SumOfSeries);
    }

    public static void findTreasure (){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

        System.out.printf("x = %d\n",x);
        System.out.printf("y = %d\n",y);

        String Direction = new String();
        int steps = 0;
        int minNumOfInstruct = 0;
        int minNumOfInstruct2 = 0;

        int[] startPoint = {0, 0};

        if (x == 0 && y == 0){
            System.out.print(0);
        }

        Direction = in.next();

        while(!Direction.equals("stop")) {
            steps = in.nextInt();
            minNumOfInstruct += 1;

            if (Direction.equals("sever")){
                startPoint[1] += steps;
            }
            else if (Direction.equals("zapad")){
                startPoint[0] -= steps;
            }
            else if (Direction.equals("youg")){
                startPoint[1] -= steps;
            }
            else if (Direction.equals("vostok")){
                startPoint[0] += steps;
            }
            if (x == startPoint[0] && y == startPoint[1]){
                minNumOfInstruct2 = minNumOfInstruct;
            }
            Direction = in.next();
        }

        System.out.println(minNumOfInstruct2);
    }

    public static void logisticMaximin (){
        System.out.print("Input number of roads: ");

        Scanner in = new Scanner(System.in);
        int roads = in.nextInt();
        int tunnels = 0;
        int height = 0;
        int tmp = 0;
        int maxHeight = Integer.MAX_VALUE;
        int count = 0;

        while (roads > 0){
            tunnels = in.nextInt();

            while (tunnels > 0){
                height = in.nextInt();

                if (height < maxHeight){
                    maxHeight = height;
                }

                tunnels--;
            }

            if (tmp < maxHeight) {
                tmp = maxHeight;
            }

            maxHeight = Integer.MAX_VALUE;

            ++count;
            --roads;
        }

        System.out.println(count + " " + tmp);
    }

    public static void isTwiceEvenNumber(){
        System.out.print("Input number: ");

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int first = num/100%10;
        int second = num/10%10;
        int third = num%10;

        if ((first + second + third) % 2 == 0 && (first*second*third) % 2 == 0){
            System.out.printf("%d is a 'twice even number'.", num);
        }
        else {
            System.out.printf("%d is not a 'twice even number'.", num);
        }
    }
}