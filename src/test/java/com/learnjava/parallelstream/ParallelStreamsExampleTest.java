package com.learnjava.parallelstream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.learnjava.util.CommonUtil.startTimer;
import static com.learnjava.util.CommonUtil.timeTaken;
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

}