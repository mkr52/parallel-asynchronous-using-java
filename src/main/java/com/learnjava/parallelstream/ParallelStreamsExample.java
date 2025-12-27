package com.learnjava.parallelstream;

import com.learnjava.util.DataSet;

import java.util.List;

import static com.learnjava.util.CommonUtil.*;
import static com.learnjava.util.LoggerUtil.log;

public class ParallelStreamsExample {

    public List<String> stringTransform(List<String> namesList) {
        return namesList.parallelStream()
                .map(ParallelStreamsExample::addNameLengthTransform)
                .toList();
    }

    public static void main(String[] args) {
        List<String> namesList = DataSet.namesList();
        ParallelStreamsExample example = new ParallelStreamsExample();
        startTimer();
        List<String> resultList = example.stringTransform(namesList);
        log("resultList : "+ resultList);
        timeTaken();
    }

    private static String addNameLengthTransform(String name) {
        delay(500);
        return name.length()+" - "+name ;
    }
}
