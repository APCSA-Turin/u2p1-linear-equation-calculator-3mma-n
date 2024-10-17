package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
        int idx = coord1.indexOf(","); // finds the index of the comma in the coordinate pair
        x1 = Integer.parseInt(coord1.substring(1, idx)); // picks out characters between the open parenthesis and the comma
        y1 = Integer.parseInt(coord1.substring(idx + 1, coord1.length() - 1)); // picks out characters after the comma and before the closing parenthesis
        idx = coord2.indexOf(","); // process is repeated for coord2
        x2 = Integer.parseInt(coord2.substring(1, idx)); 
        y2 = Integer.parseInt(coord2.substring(idx + 1, coord2.length() - 1)); 
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total)
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newVal){x1 = newVal;}
    public void setY1(int newVal){y1 = newVal;}
    public void setX2(int newVal){x2 = newVal;}
    public void setY2(int newVal){y2 = newVal;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // calculates distance using distance formula
        return roundedToHundredth(dist);
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if ((x2 - x1) != 0) {
            return roundedToHundredth(y1 - (x1 * slope()));
        }
        return -999.99;
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if ((x2 - x1) != 0) {
            return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
        }
        return -999.99;
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        double slope = slope();
        double yInt = yInt(); 
        if (slope == -999.99) {
            return "undefined";
        }
        String str = "y=";
        if (slope != 0) {
            str += slope + "x";

            if (yInt > 0) {
                str += "+";
            }
        }
        if (yInt != 0) {
            str += yInt;
        }
        return str;
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        if (x > 0) {
            return (int) (x * 100 + 0.5) / 100.0;
        }
        return (int) (x * 100 - 0.5) / 100.0;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
 
        return str;
    }



}