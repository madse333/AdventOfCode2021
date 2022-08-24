import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SonarSweepAppPart2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(getFile("C:/Users/madse/OneDrive/Desktop/Datamatikeruddannelsen/Programmering/AdventOfCode/input1.txt"));
        int count = 0;
        int first = scan.nextInt();
        int middle = scan.nextInt();
        int last = scan.nextInt();
        int sum;
        while (scan.hasNext()){
            sum = first + middle + last;
            first = middle;
            middle = last;
            last = scan.nextInt();
            if (sum < first + middle + last){
                count++;
            }
        }
        System.out.println(count);
    }

    private static File getFile(String uri){
        File file = new File(uri);
        return file;
    }
}
