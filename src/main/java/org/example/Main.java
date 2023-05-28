package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("one");
        s.add("two");
        s.add("three");
        String[] array = s.toArray(new String[s.size()]);
        int n = (int) Math. floor(Math. random() * array.length);
        System.out.println(s.toString());
    }
}