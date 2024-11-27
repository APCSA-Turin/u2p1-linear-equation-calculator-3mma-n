package com.example.project;

/** This class represents a pair of coordinates 
 * @author Emma Nichols
*/
public class LinearCalculator{
    /** The x coordinate of the first point */
    private int x1;

    /** The y coordinate of the first point */
    private int y1;
    /** The x coordinate of the second point */
    private int x2;

    /** The y coordinate of the second point */
    private int y2;

    /** Instantiates a LinearCalculator object
     * @param coord1 The first point represented as a String
     * @param coord2 The second point represented as a String 
     */
    public LinearCalculator(String coord1, String coord2){ // add 2 string parameters to this constructor
        int idx = coord1.indexOf(","); // finds the index of the comma in the coordinate pair
        x1 = Integer.parseInt(coord1.substring(1, idx)); // picks out characters between the open parenthesis and the comma
        y1 = Integer.parseInt(coord1.substring(idx + 1, coord1.length() - 1)); // picks out characters after the comma and before the closing parenthesis
        idx = coord2.indexOf(","); // process is repeated for coord2
        x2 = Integer.parseInt(coord2.substring(1, idx)); 
        y2 = Integer.parseInt(coord2.substring(idx + 1, coord2.length() - 1)); 
    }



    /** Gets the x value of the first point
     * @return The first x value
     */
    public int getX1(){return x1;}

    /** Gets the y value of the first point
     * @return The first y value
     */
    public int getY1(){return y1;}

    /** Gets the x value of the second point
     * @return The second x value
     */
    public int getX2(){return x2;}

    /** Gets the y value of the second point
     * @return The second y value
     */
    public int getY2(){return y2;}

    /** Sets the x value of the first point to a new one
     * @param newVal The new value set by the client
     */
    public void setX1(int newVal){x1 = newVal;}

    /** Sets the y value of the first point to a new one
     * @param newVal The new value set by the client
     */
    public void setY1(int newVal){y1 = newVal;}

    /** Sets the x value of the second point to a new one
     * @param newVal The new value set by the client
     */
    public void setX2(int newVal){x2 = newVal;}

    /** Sets the y value of the second point to a new one
     * @param newVal The new value set by the client
     */
    public void setY2(int newVal){y2 = newVal;}


    /** Returns the distance between the two points to the nearest HUNDREDTH
     * @return The distance between the two points
    */
    public double distance(){
        double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // calculates distance using distance formula
        return roundedToHundredth(dist);
    }

    /** returns the y intercept of the equation to the nearest HUNDREDTH 
     * @return The y intercept
    */
    public double yInt(){
        if ((x2 - x1) != 0) { // executes if slope is not undefined
            return roundedToHundredth(y1 - (x1 * slope())); // uses the first point and the slope to calculate y Intercept working backwards
        }
        return -999.99;
    }

    /** returns the slope of the line formed by the two points to the nearest HUNDREDTH
     * @return The slope
    */
    public double slope(){
        if ((x2 - x1) != 0) {
            return roundedToHundredth((double) (y2 - y1) / (x2 - x1)); // divides the y difference by the y difference (rise over run)
        }
        return -999.99;
    }

    /** returns the final equation in y=mx+b form as a string
     * @return The full equation
    */
    public String equation(){
        double slope = slope();
        double yInt = yInt(); 
        if (slope == -999.99) { // checks if slope is undefined (in which case it returns undefined immediately)
            return "undefined";
        }
        String str = "y="; // starts equation with y=
        if (slope != 0) {
            str += slope + "x"; // adds the slope and x if the slope isn't zero

            if (yInt > 0) {
                str += "+"; // adds a plus if the slope isn't zero and the yInt is greater 0 (not less than 0 because negatives already include a - sign)
            }
        }
        if (yInt != 0) {
            str += yInt; // adds the y-Int if it's not zero
        }
        return str; // returns the final equation
    }


    
    /** returns the input rounded to the nearest hundredth 
     * @param x The value to be rounded
     * @return The rounded value
    */
    public double roundedToHundredth(double x){
        if (x > 0) { // checks if x is > or less than or equal to 0 to decide whether to add or subtract 0.5
            return (int) (x * 100 + 0.5) / 100.0; // uses multiplication, casting, & division to round to 2 ints
        }
        return (int) (x * 100 - 0.5) / 100.0;
    }

    /** returns a string of info about the points 
     * @return The info string
    */
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")"; // ever line simply uses functions and values to append to the given strings
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();

        return str;
    }



}