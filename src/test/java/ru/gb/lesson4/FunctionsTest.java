package ru.gb.lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class FunctionsTest {
    private static final Logger logger = LoggerFactory.getLogger(FunctionsTest.class);

    @BeforeAll // метод должен быть статическим
    static void beforeAll (){
        //System.out.println("Выполнится 1 раз перед всеми тестами класса");
        logger.info("logger: Выполнится 1 раз перед всеми тестами класса");
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach // метод НЕ должен быть статическим
    void beforeEach (){
        //System.out.println("Выполнится перед запуском каждого теста");
        logger.error("logger: Выполнится перед запуском каждого теста");
    }

    @Test
    @Disabled("Здесь моджно указать причину") //Задизейбили тест чтобы он не выполнялся в общем прогоне (удобно, когда функционал еще не доделан)
    @DisplayName("Проверка метода isPalindrome со словом-палиндромом")
    void isPalindromeTest () {
        Boolean result = new Functions().isPalindrome("123321");
        Assertions.assertEquals(true, result);
    }

    @ParameterizedTest // Параметризованный тест
    @ValueSource(strings = {"АЛЛА", "123321", "1234321"}) // Тест только с тестовыми данными
    @DisplayName("Проверка метода isPalindrome со словами палиндромами (чет и нечет кол-во символов)")
    void isPalindromeTest2(String testWord){
        boolean result = new Functions().isPalindrome(testWord);
        //Assertions.assertEquals(true, result);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest // Параметризованный тест
    @CsvSource({"123, false", "123321, true"})// Тест с тестовыми данными и ожидаемым результатом
    void isPalindromeTest3(String testWord, boolean expectedResult){
        Assertions.assertEquals(expectedResult, new Functions().isPalindrome(testWord));
    }
//-----------------------------------------------------------
    @ParameterizedTest
    @MethodSource("catAndAgeDataProvider")
    void catAndAgeTest (Cat cat, Integer age){
        Assertions.assertEquals(cat.getAge(), age);
    }

    private static List<Arguments> catAndAgeDataProvider() {
        return Arrays.asList(
                Arguments.of(new Cat("Барсик", 10), 10),
                Arguments.of(new Cat("Мурзик", 11), 12)
        );
    }
//------------------------------------------------------------
    @AfterEach
    void afterEach (){
        System.out.println("Метод выполнится после каждого теста");
    }

    @AfterAll
    static void afterAll (){
        System.out.println("Метод выполнится 1 раз после выполнения всех тестов класса");
    }
}
