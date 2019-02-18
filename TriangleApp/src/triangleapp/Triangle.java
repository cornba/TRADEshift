/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangleapp;

enum TriangleType {
    EQUILATERAL, ISOSCELES, SCALENE, INVALID
}
public class Triangle {
    public static TriangleType classifyTriangle(int[] vSides) {
        
        byte _nEqualitiesBetweenAdjacentSides = Polygon.validateAndCountEqual(vSides);
        
        TriangleType returnValue;
        //determine the triangle type
        switch (_nEqualitiesBetweenAdjacentSides) {
            case 1: //2 equal sides
               returnValue = TriangleType.ISOSCELES;
               break;
            case 3: //all 3 sides are equal
               returnValue = TriangleType.EQUILATERAL;
               break;
            case 0: //no 2 sides are equal
               returnValue = TriangleType.SCALENE;
               break;
            default: // invalid case
                returnValue = TriangleType.INVALID;
        }
        return returnValue;
    }
}