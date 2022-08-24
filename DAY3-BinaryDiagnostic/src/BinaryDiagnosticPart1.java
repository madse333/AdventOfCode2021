import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinaryDiagnosticPart1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(getFile("C:/Users/madse/OneDrive/Desktop/Datamatikeruddannelsen/Programmering/AdventOfCode/input3.txt"));
        int binaryLength = scan.nextLine().length();
        String gammaRate = "";

        int position = 0;
        int countOnes = 0;
        int countZeroes = 0;
        for (int i = 0; i < binaryLength; i++){
            scan = new Scanner(getFile("C:/Users/madse/OneDrive/Desktop/Datamatikeruddannelsen/Programmering/AdventOfCode/input3.txt"));
            while (scan.hasNext()){
                if (scan.nextLine().charAt(position) == '1'){
                    countOnes++;
                }
                else{
                    countZeroes++;
                }
            }
            if (countOnes > countZeroes){
                gammaRate += 1;
            }
            else{
                gammaRate += 0;
            }
            countOnes = 0;
            countZeroes = 0;
            position++;
        }
        System.out.println(gammaRate);
        String epsilonRate = returnEpsilonRate(gammaRate);
        System.out.println(epsilonRate);

        int gammaRateDec = Integer.parseInt(gammaRate,2);
        int epsilonRateDec = Integer.parseInt(epsilonRate,2);
        System.out.println();
        System.out.println(gammaRateDec);
        System.out.println(epsilonRateDec);
        System.out.println(gammaRateDec * epsilonRateDec);



    }

    private static File getFile(String uri){
        File file = new File(uri);
        return file;
    }

    private static String returnEpsilonRate(String gammaRate){
        String epsilonRate = "";
        for (int i = 0; i < gammaRate.length(); i++){
            if (gammaRate.charAt(i) == '1'){
                epsilonRate += 0;
            }
            else{
                epsilonRate += 1;
            }
        }
        return epsilonRate;
    }
}
