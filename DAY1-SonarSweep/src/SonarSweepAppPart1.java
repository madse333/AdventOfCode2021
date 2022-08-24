import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SonarSweepAppPart1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(getFile("C:/Users/madse/OneDrive/Desktop/Datamatikeruddannelsen/Programmering/AdventOfCode/input1.txt"));
        int count = 0;
        int prev = scan.nextInt();
        while (scan.hasNext()){
            int next = scan.nextInt();
            if (prev < next){
                count++;
            }
            prev = next;
        }

        System.out.println(count);
    }

    private static File getFile(String uri){
        File file = new File(uri);
        return file;
    }
}
