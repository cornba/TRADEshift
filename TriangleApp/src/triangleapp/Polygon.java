/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangleapp;

/**
 *
 * @author cbaia
 */
public class Polygon {
/**
 * validate that the sides can form a polygon
 * input parameter an array with the sizes of the sides 
 * return value: the number of equalities between adjacent sides
 */
    public static byte validateAndCountEqual(int[] sides) {
        int perimeter = 0;
        byte equalities = 0;  // the number of equal relation between adjacent sides
        int i;
        int _nSides = sides.length;    //get the array size
        
        for (i = 0; i<_nSides; i++)
        {
                if(sides[i] <= 0) { // verify that sides are positive integer values
                        throw new IllegalArgumentException("Side of zero or negative length"); 
                } else {
                // calculate the perimeter of the polygon
                        perimeter += sides[i];
                }
        }
        for (i = 0; i < _nSides - 1; i++)
        {
                if(perimeter - sides[i] <= sides[i]) {
                    // side i is greater than or equal to the sum of all the other sides
                        throw new IllegalArgumentException("Can't form a polygon");
                } else {
                    if (sides[i] == sides[i+1]) {//increment the number of equalities 
                        equalities++;
                    }
                }   
        }
        if(perimeter - sides[_nSides - 1] <= sides[_nSides - 1]) {
        //verify the validity of the N'th side
        //if the last side is greater than or equal to the sum of all the other sides
            throw new IllegalArgumentException("Can't form a polygon");
        }
        if (equalities == _nSides - 1 || sides[0] == sides[_nSides - 1]) {
        //if number of equalities between adjacent sides is N-1  then make it N, the transitivity quality.
        //if number of equalities between adjacent sides is less than N-1 then verify if first side is equal to last side
        //     and increment the number of equalities.
                equalities++;
        }
        return equalities;
    }
}
