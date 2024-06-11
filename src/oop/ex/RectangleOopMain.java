package oop.ex;

import static oop.ex.RectangleProceduralMain.*;

public class RectangleOopMain {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();

        int area = calculateArea(5,8);
        System.out.println("넓이: " + area);

        int perimeter = calculatePerimeter(5,8);
        System.out.println("둘레 길이: " + perimeter);

        boolean square = isSquare(5,8);
        System.out.println("정사각형 여부" + square);
    }
}
