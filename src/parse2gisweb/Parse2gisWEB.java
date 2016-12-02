/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parse2gisweb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Parse2gisWEB {

   private static String csvFile = "/root/проекты/2gis/DgdatToXlsx-mysql/Download/Data_Dubai_en.csv";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      ArrayList<String[]> orgList = parseCSV();
      
      
      
        System.out.println("parse2gisweb.Parse2gisWEB.main()");
        
    }
    
    private static ArrayList<String[]> parseCSV(){
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        ArrayList<String[]> orgList = new ArrayList();
        String[] org = new String[6];

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] orgFull = line.split(cvsSplitBy);
                try{
                org[0] = orgFull[2];
                org[1] = orgFull[4];
                org[2] = orgFull[5];
                org[3] = orgFull[6];
                org[4] = orgFull[10];
                org[5] = "";                
                }catch (ArrayIndexOutOfBoundsException e){
                    e.printStackTrace();
                }
                                
                System.out.println(org[0] + " | " + org[4]);

                if(!org[4].equals("")) orgList.add(org);
                
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return orgList;
        
    }
    
}
