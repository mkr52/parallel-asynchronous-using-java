package com.learnjava.parallelstream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.learnjava.util.CommonUtil.*;
import static com.learnjava.util.LoggerUtil.log;
import static org.junit.jupiter.api.Assertions.*;

class ParallelStreamsExampleTest {

    ParallelStreamsExample parallelStreamsExample = new ParallelStreamsExample();

    @Test
    void stringTransformSuccess() {
        //given
        List<String> namesList = List.of("Adam", "Eve", "John", "Doe");

        //when
        startTimer();
        List<String> resultList = parallelStreamsExample.stringTransform(namesList);
        timeTaken();

        //then
        assertEquals(4, resultList.size());
        assertTrue(resultList.contains("4 - Adam"));
        assertTrue(resultList.contains("3 - Eve"));
        assertTrue(resultList.contains("4 - John"));
        assertTrue(resultList.contains("3 - Doe"));
        assertFalse(resultList.contains(5 + " - Alice"));
    }

    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    void stringTransformSuccess_StreamFlag(boolean isParallel) {
        //given
        List<String> namesList = List.of("Adam", "Eve", "John", "Doe");

        //when
        startTimer();
        List<String> resultList = parallelStreamsExample.stringTransform_1(namesList, isParallel);
        timeTaken();

        //then
        assertEquals(4, resultList.size());
        assertTrue(resultList.contains("4 - Adam"));
        assertTrue(resultList.contains("3 - Eve"));
        assertTrue(resultList.contains("4 - John"));
        assertTrue(resultList.contains("3 - Doe"));
        stopWatchReset();
    }

    // Add test for stringTransform_2 method
    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    void stringTransformToLowerCaseSuccess_StreamFlag(boolean isParallel) {
        //given
        List<String> namesList = List.of("Adam", "Eve", "John", "Doe");

        //when
        startTimer();
        List<String> resultList = parallelStreamsExample.stringTransform_2(namesList, isParallel);
        log("resultList : " + resultList);
        timeTaken();

        //then
        assertEquals(4, resultList.size());
        assertTrue(resultList.contains("adam"));
        assertTrue(resultList.contains("eve"));
        assertTrue(resultList.contains("john"));
        assertTrue(resultList.contains("doe"));
        stopWatchReset();
    }

}