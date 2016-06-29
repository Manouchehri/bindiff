/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.data.statistics.Statistics;

public abstract class BoxAndWhiskerCalculator {
    public static BoxAndWhiskerItem calculateBoxAndWhiskerStatistics(List list) {
        return BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(list, true);
    }

    public static BoxAndWhiskerItem calculateBoxAndWhiskerStatistics(List arrayList, boolean bl2) {
        ArrayList<Number> arrayList2;
        if (arrayList == null) {
            throw new IllegalArgumentException("Null 'values' argument.");
        }
        if (bl2) {
            arrayList2 = new ArrayList<Number>(arrayList.size());
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                double d2;
                Number number;
                Object e2 = listIterator.next();
                if (!(e2 instanceof Number) || Double.isNaN(d2 = (number = (Number)e2).doubleValue())) continue;
                arrayList2.add(number);
            }
        } else {
            arrayList2 = arrayList;
        }
        Collections.sort(arrayList2);
        double d3 = Statistics.calculateMean(arrayList2, false);
        double d4 = Statistics.calculateMedian(arrayList2, false);
        double d5 = BoxAndWhiskerCalculator.calculateQ1(arrayList2);
        double d6 = BoxAndWhiskerCalculator.calculateQ3(arrayList2);
        double d7 = d6 - d5;
        double d8 = d6 + d7 * 1.5;
        double d9 = d5 - d7 * 1.5;
        double d10 = d6 + d7 * 2.0;
        double d11 = d5 - d7 * 2.0;
        double d12 = Double.POSITIVE_INFINITY;
        double d13 = Double.NEGATIVE_INFINITY;
        double d14 = Double.POSITIVE_INFINITY;
        double d15 = Double.NEGATIVE_INFINITY;
        ArrayList<Number> arrayList3 = new ArrayList<Number>();
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            Number number = (Number)iterator.next();
            double d16 = number.doubleValue();
            if (d16 > d8) {
                arrayList3.add(number);
                if (d16 > d15 && d16 <= d10) {
                    d15 = d16;
                }
            } else if (d16 < d9) {
                arrayList3.add(number);
                if (d16 < d14 && d16 >= d11) {
                    d14 = d16;
                }
            } else {
                d12 = Math.min(d12, d16);
                d13 = Math.max(d13, d16);
            }
            d14 = Math.min(d14, d12);
            d15 = Math.max(d15, d13);
        }
        return new BoxAndWhiskerItem(new Double(d3), new Double(d4), new Double(d5), new Double(d6), new Double(d12), new Double(d13), new Double(d14), new Double(d15), arrayList3);
    }

    public static double calculateQ1(List list) {
        if (list == null) {
            throw new IllegalArgumentException("Null 'values' argument.");
        }
        double d2 = Double.NaN;
        int n2 = list.size();
        if (n2 <= 0) return d2;
        if (n2 % 2 != 1) {
            return Statistics.calculateMedian(list, 0, n2 / 2 - 1);
        }
        if (n2 <= 1) return Statistics.calculateMedian(list, 0, 0);
        return Statistics.calculateMedian(list, 0, n2 / 2);
    }

    public static double calculateQ3(List list) {
        if (list == null) {
            throw new IllegalArgumentException("Null 'values' argument.");
        }
        double d2 = Double.NaN;
        int n2 = list.size();
        if (n2 <= 0) return d2;
        if (n2 % 2 != 1) {
            return Statistics.calculateMedian(list, n2 / 2, n2 - 1);
        }
        if (n2 <= 1) return Statistics.calculateMedian(list, 0, 0);
        return Statistics.calculateMedian(list, n2 / 2, n2 - 1);
    }
}

