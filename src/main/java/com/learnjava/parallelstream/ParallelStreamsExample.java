package com.learnjava.parallelstream;

import com.learnjava.util.DataSet;

import java.util.List;
import java.util.stream.Stream;

import static com.learnjava.util.CommonUtil.*;
import static com.learnjava.util.LoggerUtil.log;

public class ParallelStreamsExample {

    public List<String> stringTransform(List<String> namesList) {
        return namesList.parallelStream()
                .map(ParallelStreamsExample::addNameLengthTransform)
                .toList();
    }

    public List<String> stringTransform_1(List<String> namesList ,boolean isParallel) {
        Stream<String> nameStream = namesList.stream();
        if(isParallel)
            nameStream.parallel();
        return nameStream
                .map(ParallelStreamsExample::addNameLengthTransform)
                .toList();
    }

    // call lowercase transform function based on isParallel flag
    public List<String> stringTransform_2(List<String> namesList ,boolean isParallel) {
        Stream<String> nameStream = namesList.stream();
        if(isParallel)
            nameStream = nameStream.parallel();
        return nameStream
                .map(String::toLowerCase)
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

    // Create a function that takes in a list of names and
    // transform all the elements to lowercase using parallelstreams() method.
    private static List<String> transformToLowerCase(List<String> namesList) {
        return namesList.parallelStream()
                .map(String::toLowerCase)
                .toList();
    }

}
