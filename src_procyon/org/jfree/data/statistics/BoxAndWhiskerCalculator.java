package org.jfree.data.statistics;

import java.util.*;

public abstract class BoxAndWhiskerCalculator
{
    public static BoxAndWhiskerItem calculateBoxAndWhiskerStatistics(final List list) {
        return calculateBoxAndWhiskerStatistics(list, true);
    }
    
    public static BoxAndWhiskerItem calculateBoxAndWhiskerStatistics(final List list, final boolean b) {
        if (list == null) {
            throw new IllegalArgumentException("Null 'values' argument.");
        }
        List<Comparable> list2;
        if (b) {
            list2 = new ArrayList<Comparable>(list.size());
            final ListIterator<Comparable> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                final Number next = listIterator.next();
                if (next instanceof Number) {
                    final Number n = next;
                    if (Double.isNaN(n.doubleValue())) {
                        continue;
                    }
                    list2.add((Comparable)n);
                }
            }
        }
        else {
            list2 = (List<Comparable>)list;
        }
        Collections.sort(list2);
        final double calculateMean = Statistics.calculateMean(list2, false);
        final double calculateMedian = Statistics.calculateMedian(list2, false);
        final double calculateQ1 = calculateQ1(list2);
        final double calculateQ2 = calculateQ3(list2);
        final double n2 = calculateQ2 - calculateQ1;
        final double n3 = calculateQ2 + n2 * 1.5;
        final double n4 = calculateQ1 - n2 * 1.5;
        final double n5 = calculateQ2 + n2 * 2.0;
        final double n6 = calculateQ1 - n2 * 2.0;
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        double min2 = Double.POSITIVE_INFINITY;
        double max2 = Double.NEGATIVE_INFINITY;
        final ArrayList<Number> list3 = new ArrayList<Number>();
        for (final Number n7 : list2) {
            final double doubleValue = n7.doubleValue();
            if (doubleValue > n3) {
                list3.add(n7);
                if (doubleValue > max2 && doubleValue <= n5) {
                    max2 = doubleValue;
                }
            }
            else if (doubleValue < n4) {
                list3.add(n7);
                if (doubleValue < min2 && doubleValue >= n6) {
                    min2 = doubleValue;
                }
            }
            else {
                min = Math.min(min, doubleValue);
                max = Math.max(max, doubleValue);
            }
            min2 = Math.min(min2, min);
            max2 = Math.max(max2, max);
        }
        return new BoxAndWhiskerItem(new Double(calculateMean), new Double(calculateMedian), new Double(calculateQ1), new Double(calculateQ2), new Double(min), new Double(max), new Double(min2), new Double(max2), list3);
    }
    
    public static double calculateQ1(final List list) {
        if (list == null) {
            throw new IllegalArgumentException("Null 'values' argument.");
        }
        double n = Double.NaN;
        final int size = list.size();
        if (size > 0) {
            if (size % 2 == 1) {
                if (size > 1) {
                    n = Statistics.calculateMedian(list, 0, size / 2);
                }
                else {
                    n = Statistics.calculateMedian(list, 0, 0);
                }
            }
            else {
                n = Statistics.calculateMedian(list, 0, size / 2 - 1);
            }
        }
        return n;
    }
    
    public static double calculateQ3(final List list) {
        if (list == null) {
            throw new IllegalArgumentException("Null 'values' argument.");
        }
        double n = Double.NaN;
        final int size = list.size();
        if (size > 0) {
            if (size % 2 == 1) {
                if (size > 1) {
                    n = Statistics.calculateMedian(list, size / 2, size - 1);
                }
                else {
                    n = Statistics.calculateMedian(list, 0, 0);
                }
            }
            else {
                n = Statistics.calculateMedian(list, size / 2, size - 1);
            }
        }
        return n;
    }
}
