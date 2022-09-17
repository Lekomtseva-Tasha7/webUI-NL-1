package ru.gb.lesson4;

public class TriangleArea {
    //Расчет площади треугольника по 3 сторонам
    public static double areaOfTriangle(double a, double b, double c) throws Exception {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new Exception("side length <= 0");
        }

        if ( (a + b) == c || (a + c) == b || (c + b) == a) {
            throw new Exception("it's not a triangle, it's a line");
        }

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
