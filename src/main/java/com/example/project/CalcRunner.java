package com.example.project;

public class CalcRunner {
    public static void main(String[] args) {
        LinearCalculator c = new LinearCalculator("(-5,1)","(1,1)");
        String expectedOutput = "The two points are: (-5,1)";
        expectedOutput += " and " + "(1,1)";
        expectedOutput += "\nThe equation of the line between these points is: y=1.0";
        expectedOutput += "\nThe slope of this line is: 0.0";
        expectedOutput += "\nThe y-intercept of the line is: 1.0";
        expectedOutput += "\nThe distance between the two points is: 6.0";

        String studentOutput = "The two points are: (" + c.getX1() + "," + c.getY1() + ")";
        studentOutput += " and " + "(" + c.getX2() + "," + c.getY2() + ")";
        studentOutput += "\nThe equation of the line between these points is: " + c.equation();
        studentOutput += "\nThe slope of this line is: " + c.slope();
        studentOutput += "\nThe y-intercept of the line is: " + c.yInt();
        studentOutput += "\nThe distance between the two points is: " + c.distance();
        System.out.println(expectedOutput);
        System.out.println("\n" + studentOutput);
        System.out.println(studentOutput.equals(expectedOutput));
    }
}
