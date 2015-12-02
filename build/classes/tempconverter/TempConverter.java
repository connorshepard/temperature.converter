/*
 * University of Central Florida
 * COP3330 - Fall 2015
 * Author: Connor Shepard
 */
package tempconverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class TempConverter {
    
    public static void main(String[] args) {
        
        if(args.length > 0) {
            File file = new File(args[0]);
        
        DecimalFormat df = new DecimalFormat("#.##"); 
        Double [] oldTemps = new Double[100];
        String [] oldTempsType = new String[100]; 
        String [] newTempsType = new String[100];
        String [] table = new String[100];
        
        try{
            System.out.println("Temperature Converter by Connor Shepard\n");
            System.out.println("Input   Type    Conversion");
            System.out.println("--------------------------");
            Scanner input = new Scanner(new FileInputStream(file));
            int lineNumber = 0;
            while(input.hasNextDouble() ) {
                oldTemps[lineNumber] = input.nextDouble();
                if (input.hasNext("C"))
                {
                   oldTempsType[lineNumber] = "C"; 
                   newTempsType[lineNumber] = "F"; 
                }
                else if (input.hasNext("F"))
                {
                   oldTempsType[lineNumber] = "F"; 
                   newTempsType[lineNumber] = "C"; 
                }
                
                double newTemp = conversion(oldTempsType[lineNumber], oldTemps[lineNumber]);
                int length = String.valueOf(oldTemps[lineNumber]).length();
                
                if (length == 4)
                {
                  table[lineNumber] = (oldTemps[lineNumber]+ "0" + "    " + oldTempsType[lineNumber]) + "        " + String.format("%.2f", newTemp) + " " + newTempsType[lineNumber];
                }
                else if (length == 5)
                {
                  table[lineNumber] = (oldTemps[lineNumber]+ "0" + "   " + oldTempsType[lineNumber]) + "        " + String.format("%.2f", newTemp) + " " + newTempsType[lineNumber];
                }
                System.out.println(table[lineNumber]);
                lineNumber++;
                input.next();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    }
    
    public static double conversion(String oldType, double oldTemp)
    {
        double newTemp;
        if (oldType == "C")
        {
            newTemp = ((oldTemp*9)/5)+ 32;
            return newTemp;
        }
        else 
        {
            newTemp = ((oldTemp*5)-160)/9;
            return newTemp;
        }
        
    }
    }
    
