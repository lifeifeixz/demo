package com.example.demo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author flysLi
 * @date 2018/2/28
 */
public class WordCountService implements Serializable {

    private static final Pattern SPACE = Pattern.compile(" ");


    public Map<String, Integer> run() {
        Map<String, Integer> result = new HashMap<>(100);
        return null;
    }
}
