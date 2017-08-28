/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            }
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
    }

    public void yearOfHighestrank(int start, int end, String name, String gender){
        int rank =0;
        int highestRank = 99999999;
        int highRankedYear =0;
        for(int i = start; i <= end; i++){
         FileResource fr = new FileResource("testing/yob"+i+"short.csv");
            rank = 0;
           for(CSVRecord rec : fr.getCSVParser(false)){
               if(rec.get(1).equals(gender)){
                    rank++;
                    if(rec.get(0).equals(name) && rank < highestRank){
                        highestRank = rank;
                        highRankedYear = i;

                    }
                }
            }
            
        }
            System.out.println(name +" Highest Rank is " + highestRank + " in " + highRankedYear);
    }
    public void testYearOfHighestRank(){
        int start = 2012;
        int end = 2014;
        String name = "William";
        String gender = "M";
        yearOfHighestrank(start, end, name, gender);
    }
       
    public void testTotalBirths () {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource("testing/yob2014short.csv");
        totalBirths(fr);
    }
}
