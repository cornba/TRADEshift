/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangleapp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author cbaia
 */
public class TriangleApp {
    
public static final short N = 3;  // number of sides in a triangle
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TriangleType triangleType; //enum with Triangle type
        short i;
        int[] poly = new int[N];
        
        try{
            File file = new File("triangles.txt");   
            Scanner scanner = new Scanner(file);
    //I read the int values from the text file in an int array
                while (scanner.hasNext()) {

                    for(i = 0; i < N ; i++) {
                        if (scanner.hasNextInt()) {  //read an int value from the file in the int array
                            poly[i] = scanner.nextInt();
                        } else {
                            if (scanner.hasNext()) {
                                scanner.next();
                            }
                        }
                        System.out.print(poly[i] + ",\t");  // print the lengths of the triangle sides
                    }
                    if (i == N) {// if complete triangle was read
                         try{
                             triangleType = Triangle.classifyTriangle(poly); // get the triangle type

                             System.out.println("Triangle is " + triangleType.toString());
                         }
                         catch (IllegalArgumentException e) {
                             System.out.println(e.getMessage());
                         }
                    }
                }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }  
}
