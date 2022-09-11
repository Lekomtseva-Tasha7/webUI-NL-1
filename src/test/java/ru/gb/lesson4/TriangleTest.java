package ru.gb.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    //TRACE, DEBUG, INFO, WARN, ERROR
    @BeforeEach
    void beforeEach (){
        logger.info("LOGGER: Расчет площади треугольника");
    }

    @Test
    @DisplayName("Проверка расчета площади треугольника (метод areaOfTriangle)")
    void areaOfTriangleTest(){
        Double s = new Triangle().areaOfTriangle(1, 2, 3);
        Assertions.assertEquals(0, s);
    }

}
