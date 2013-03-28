package com.capella.babynames.comparator;

import java.util.Comparator;
import java.util.Map;

/**
 * Sorting the total count
 * @author rrajendran
 */
public class BabyNameComparator implements Comparator<String> {

    Map<String, Integer> base;
    public BabyNameComparator(Map<String, Integer> base) {
        this.base = base;
    }

    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } 
    }
}