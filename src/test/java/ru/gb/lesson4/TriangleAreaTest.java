package ru.gb.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ru.gb.lesson4.TriangleArea.areaOfTriangle;

public class TriangleAreaTest {
    private static final Logger logger = LoggerFactory.getLogger(TriangleAreaTest.class);

    //TRACE, DEBUG, INFO, WARN, ERROR
    @BeforeAll
    static void beforeAll () {
        logger.info("LOGGER: Расчет площади треугольника");
    }

    @ParameterizedTest // Параметризованный тест
    @CsvSource({"1, 2, 2, 0.96824", "2, 3, 4, 2.9047", "5, 10, 7, 16.24807"}) // Дата провайдер
    @DisplayName("Проверка расчета площади треугольника (метод areaOfTriangle)")
    void areaOfTriangleTest(double a, double b, double c, double expectedResult) throws Exception {
        Assertions.assertEquals(expectedResult, areaOfTriangle(a, b, c), 0.001);
    }

    @Test
    @DisplayName("Проверка выброса Exception при значении стороны <= 0 (метод areaOfTriangle)")
    void negativeTest (){
        Assertions.assertThrows(Exception.class, () -> areaOfTriangle(-1, 2, 2));
    }

    @Test
    @DisplayName("Проверка выброса Exception, если сумма двух сторон равна третьей (метод areaOfTriangle)")
    void lineTest (){
        Assertions.assertThrows(Exception.class, () -> areaOfTriangle(1, 2, 3));
    }

}
