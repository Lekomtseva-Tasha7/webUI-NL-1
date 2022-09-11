package ru.gb.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExamplesTest {
    @Test
    void assertJTest(){
        //Assumptionsm прерывают тест если предусловие не выполнено
        Assumptions.assumeTrue(1 == 1);

        List<String> stringList = Arrays.asList("test1", "test2", "test3");
        //Assertions проверяет соответствие между ожидаемым и фактическим результатом
        // В такой группе ассертов если один падает, то другие все равно доделываются и отчет выдают.
        Assertions.assertAll(
                () -> assertThat(new Functions().isPalindrome("123")).isFalse(),
                () -> assertThat(5).isGreaterThan(4).isLessThan(6),
                () -> assertThat(stringList).containsAnyOf("test6", "test1")
        );
    }
}
