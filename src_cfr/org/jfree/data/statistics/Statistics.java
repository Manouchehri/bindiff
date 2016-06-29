/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Statistics {
    public static double calculateMean(Number[] arrnumber) {
        return Statistics.calculateMean(arrnumber, true);
    }

    public static double calculateMean(Number[] arrnumber, boolean bl2) {
        if (arrnumber == null) {
            throw new IllegalArgumentException("Null 'values' argument.");
        }
        double d2 = 0.0;
        int n2 = 0;
        int n3 = 0;
        while (n3 < arrnumber.length) {
            double d3 = arrnumber[n3] != null ? arrnumber[n3].doubleValue() : Double.NaN;
            if (bl2 || !Double.isNaN(d3)) {
                d2 += d3;
                ++n2;
            }
            ++n3;
        }
        return d2 / (double)n2;
    }

    public static double calculateMean(Collection collection) {
        return Statistics.calculateMean(collection, true);
    }

    public static double calculateMean(Collection collection, boolean bl2) {
        if (collection == null) {
            throw new IllegalArgumentException("Null 'values' argument.");
        }
        int n2 = 0;
        double d2 = 0.0;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (e2 == null) {
                if (!bl2) continue;
                return Double.NaN;
            }
            if (!(e2 instanceof Number)) continue;
            Number number = (Number)e2;
            double d3 = number.doubleValue();
            if (Double.isNaN(d3)) {
                if (!bl2) continue;
                return Double.NaN;
            }
            d2 += number.doubleValue();
            ++n2;
        }
        return d2 / (double)n2;
    }

    public static double calculateMedian(List list) {
        return Statistics.calculateMedian(list, true);
    }

    public static double calculateMedian(List arrayList, boolean bl2) {
        ArrayList arrayList2;
        int n2;
        double d2 = Double.NaN;
        if (arrayList == null) return d2;
        if (bl2) {
            n2 = arrayList.size();
            arrayList2 = new ArrayList(n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                arrayList2.add(i2, arrayList.get(i2));
            }
            Collections.sort(arrayList2);
            arrayList = arrayList2;
        }
        if ((n2 = arrayList.size()) <= 0) return d2;
        if (n2 % 2 != 1) {
            arrayList2 = (Number)arrayList.get(n2 / 2 - 1);
            Number number = (Number)arrayList.get(n2 / 2);
            return (arrayList2.doubleValue() + number.doubleValue()) / 2.0;
        }
        if (n2 > 1) {
            arrayList2 = (Number)arrayList.get((n2 - 1) / 2);
            return arrayList2.doubleValue();
        }
        arrayList2 = (Number)arrayList.get(0);
        return arrayList2.doubleValue();
    }

    public static double calculateMedian(List list, int n2, int n3) {
        return Statistics.calculateMedian(list, n2, n3, true);
    }

    public static double calculateMedian(List list, int n2, int n3, boolean bl2) {
        double d2 = Double.NaN;
        if (bl2) {
            ArrayList arrayList = new ArrayList(n3 - n2 + 1);
            int n4 = n2;
            do {
                if (n4 > n3) {
                    Collections.sort(arrayList);
                    return Statistics.calculateMedian(arrayList, false);
                }
                arrayList.add(list.get(n4));
                ++n4;
            } while (true);
        }
        int n5 = n3 - n2 + 1;
        if (n5 <= 0) return d2;
        if (n5 % 2 != 1) {
            Number number = (Number)list.get(n2 + n5 / 2 - 1);
            Number number2 = (Number)list.get(n2 + n5 / 2);
            return (number.doubleValue() + number2.doubleValue()) / 2.0;
        }
        if (n5 > 1) {
            Number number = (Number)list.get(n2 + (n5 - 1) / 2);
            return number.doubleValue();
        }
        Number number = (Number)list.get(n2);
        return number.doubleValue();
    }

    public static double getStdDev(Number[] arrnumber) {
        if (arrnumber == null) {
            throw new IllegalArgumentException("Null 'data' array.");
        }
        if (arrnumber.length == 0) {
            throw new IllegalArgumentException("Zero length 'data' array.");
        }
        double d2 = Statistics.calculateMean(arrnumber);
        double d3 = 0.0;
        int n2 = 0;
        while (n2 < arrnumber.length) {
            double d4 = arrnumber[n2].doubleValue() - d2;
            d3 += d4 * d4;
            ++n2;
        }
        return Math.sqrt(d3 / (double)(arrnumber.length - 1));
    }

    public static double[] getLinearFit(Number[] arrnumber, Number[] arrnumber2) {
        if (arrnumber == null) {
            throw new IllegalArgumentException("Null 'xData' argument.");
        }
        if (arrnumber2 == null) {
            throw new IllegalArgumentException("Null 'yData' argument.");
        }
        if (arrnumber.length != arrnumber2.length) {
            throw new IllegalArgumentException("Statistics.getLinearFit(): array lengths must be equal.");
        }
        double[] arrd = new double[2];
        arrd[1] = Statistics.getSlope(arrnumber, arrnumber2);
        arrd[0] = Statistics.calculateMean(arrnumber2) - arrd[1] * Statistics.calculateMean(arrnumber);
        return arrd;
    }

    public static double getSlope(Number[] arrnumber, Number[] arrnumber2) {
        if (arrnumber == null) {
            throw new IllegalArgumentException("Null 'xData' argument.");
        }
        if (arrnumber2 == null) {
            throw new IllegalArgumentException("Null 'yData' argument.");
        }
        if (arrnumber.length != arrnumber2.length) {
            throw new IllegalArgumentException("Array lengths must be equal.");
        }
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        int n2 = 0;
        while (n2 < arrnumber.length) {
            d2 += arrnumber[n2].doubleValue();
            d3 += Math.pow(arrnumber[n2].doubleValue(), 2.0);
            d4 += arrnumber2[n2].doubleValue() * arrnumber[n2].doubleValue();
            d5 += arrnumber2[n2].doubleValue();
            ++n2;
        }
        return (d4 - d2 * d5 / (double)n2) / (d3 - d2 * d2 / (double)n2);
    }

    public static double getCorrelation(Number[] arrnumber, Number[] arrnumber2) {
        if (arrnumber == null) {
            throw new IllegalArgumentException("Null 'data1' argument.");
        }
        if (arrnumber2 == null) {
            throw new IllegalArgumentException("Null 'data2' argument.");
        }
        if (arrnumber.length != arrnumber2.length) {
            throw new IllegalArgumentException("'data1' and 'data2' arrays must have same length.");
        }
        int n2 = arrnumber.length;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        int n3 = 0;
        while (n3 < n2) {
            double d7 = 0.0;
            if (arrnumber[n3] != null) {
                d7 = arrnumber[n3].doubleValue();
            }
            double d8 = 0.0;
            if (arrnumber2[n3] != null) {
                d8 = arrnumber2[n3].doubleValue();
            }
            d2 += d7;
            d3 += d8;
            d6 += d7 * d8;
            d4 += d7 * d7;
            d5 += d8 * d8;
            ++n3;
        }
        return ((double)n2 * d6 - d2 * d3) / Math.pow(((double)n2 * d4 - d2 * d2) * ((double)n2 * d5 - d3 * d3), 0.5);
    }

    public static double[][] getMovingAverage(Number[] arrnumber, Number[] arrnumber2, int n2) {
        if (arrnumber.length != arrnumber2.length) {
            throw new IllegalArgumentException("Array lengths must be equal.");
        }
        if (n2 > arrnumber.length) {
            throw new IllegalArgumentException("Period can't be longer than dataset.");
        }
        double[][] arrd = new double[arrnumber.length - n2][2];
        int n3 = 0;
        while (n3 < arrd.length) {
            arrd[n3][0] = arrnumber[n3 + n2].doubleValue();
            double d2 = 0.0;
            for (int i2 = 0; i2 < n2; d2 += arrnumber2[n3 + i2].doubleValue(), ++i2) {
            }
            arrd[n3][1] = d2 /= (double)n2;
            ++n3;
        }
        return arrd;
    }
}

