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
        int idx = coord1.getIndexOf(","); // finds the index of the comma in the coordinate pair
        x1 = (int) coord1.substring(1, idx); // picks out characters between the open parenthesis and the comma
        y1 = (int) coord1.substring(idx + 1, coord1.length() - 2); // picks out characters after the comma and before the closing parenthesis
        int idx2 = coord2.getIndexOf(","); // process is repeated for coord2
        x2 = (int) coord2.substring(1, idx); 
        y2 = (int) coord2.substring(idx + 1, coord2.length() - 2); 
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total)
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newVal){x1 = newVal;}
    public void setY1(int newVal){y1 = newVal;}
    public void setX2(int newVal){y1 = newVal;}
    public void setY2(int newVal){y2 = newVal;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // calculates distance using distance formula
        return roundedToHundredth(dist);
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if ((x2 - x1) != 0) {
            return y1 - (x1 * slope());
        }
        return -999.99;
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if ((x2 - x1) != 0) {
            return roundedToHundredth((y2 - y1) / (x2 - x1));
        }
        return -999.99;
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        return "y=" + slope() + "x+" + yInt;
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return (int) (x * 100) / 100;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + /*insert var here*/ + "," +/*insert var here*/  + ")";
        str += " and " + "(" + /*insert var here*/ + "," + /*insert var here*/ + ")";
        str += "\nThe equation of the line between these points is: " ;
        str += "\nThe slope of this line is: ";
        str += "\nThe y-intercept of the line is: ";
        str += "\nThe distance between the two points is: ";
 
        return str;
    }



}