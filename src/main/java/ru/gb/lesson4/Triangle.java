package ru.gb.lesson4;

public class Triangle {
    //Расчет площади треугольника по 3 сторонам (формула Герона)
    public double areaOfTriangle (int a, int b, int c) {
        double p = (a + b + c)/2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }
}
