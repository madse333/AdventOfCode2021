import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinaryDiagnosticPart2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(getFile("C:/Users/madse/OneDrive/Desktop/Datamatikeruddannelsen/Programmering/AdventOfCode/input3.txt"));
        ArrayList<String> totalSearchAmount = new ArrayList<>();
        while (scan.hasNext()){
            totalSearchAmount.add(scan.nextLine());
        }

        System.out.println(returnOxyOrCO2(totalSearchAmount,0));
        System.out.println(returnOxyOrCO2(totalSearchAmount,1));
        System.out.println();
        int oxyDec = Integer.parseInt(returnOxyOrCO2(totalSearchAmount,0),2);
        int co2Dec = Integer.parseInt(returnOxyOrCO2(totalSearchAmount,1),2);
        System.out.println(oxyDec);
        System.out.println(co2Dec);
        System.out.println();
        System.out.println(oxyDec * co2Dec);


    }
    public static String returnOxyOrCO2(ArrayList<String> searchAmount, int Oxy0CO21){
        return returnOxyOrCO2(searchAmount,0,Oxy0CO21);
    }

    private static String returnOxyOrCO2(ArrayList<String> searchAmount, int position, int Oxy0CO21){
        if (searchAmount.size() == 1) {
            return searchAmount.get(0);
        }
        else{
            ArrayList<String> newSearchAmount = new ArrayList<>();
            if (Oxy0CO21 == 0){
                int countZeroes = 0;
                int countOnes = 0;
                for (String s : searchAmount){
                    if (s.charAt(position) == '0'){
                        countZeroes++;
                    }
                    else{
                        countOnes++;
                    }
                }
                if (countZeroes > countOnes){
                    for (String s : searchAmount){
                        if (s.charAt(position) == '0'){
                            newSearchAmount.add(s);
                        }

                    }
                }
                else{
                    for (String s : searchAmount){
                        if (s.charAt(position) == '1'){
                            newSearchAmount.add(s);
                        }
                    }
                }
            }
            else{
                int countZeroes = 0;
                int countOnes = 0;
                for (String s : searchAmount){
                    if (s.charAt(position) == '0'){
                        countZeroes++;
                    }
                    else{
                        countOnes++;
                    }
                }
                if (countZeroes > countOnes){
                    for (String s : searchAmount){
                        if (s.charAt(position) == '1'){
                            newSearchAmount.add(s);
                        }

                    }
                }
                else{
                    for (String s : searchAmount){
                        if (s.charAt(position) == '0'){
                            newSearchAmount.add(s);
                        }
                    }
                }
            }
            return returnOxyOrCO2(newSearchAmount,position + 1, Oxy0CO21);
        }
    }



    private static File getFile(String uri){
        File file = new File(uri);
        return file;
    }
}
