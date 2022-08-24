import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DriveAppPart1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(getFile("C:/Users/madse/OneDrive/Desktop/Datamatikeruddannelsen/Programmering/AdventOfCode/input2.txt"));
        int[] position = new int[2];

        while (scan.hasNext()){
            String line = scan.nextLine();
            String[] linesplit = line.split(" ");
            if (linesplit[0].equals("down")){
                position[0] += Integer.parseInt(linesplit[1]);
            }
            else if(linesplit[0].equals("up")) {
                position[0] -= Integer.parseInt(linesplit[1]);
            }
            else{
                position[1] += Integer.parseInt(linesplit[1]);
            }
        }
        System.out.println(position[0] * position[1]);
    }


    private static File getFile(String uri){
        File file = new File(uri);
        return file;
    }
}
