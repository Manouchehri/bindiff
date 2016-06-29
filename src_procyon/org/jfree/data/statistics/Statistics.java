package org.jfree.data.statistics;

import java.util.*;

public abstract class Statistics
{
    public static double calculateMean(final Number[] array) {
        return calculateMean(array, true);
    }
    
    public static double calculateMean(final Number[] array, final boolean b) {
        if (array == null) {
            throw new IllegalArgumentException("Null 'values' argument.");
        }
        double n = 0.0;
        int n2 = 0;
        for (int i = 0; i < array.length; ++i) {
            double doubleValue;
            if (array[i] != null) {
                doubleValue = array[i].doubleValue();
            }
            else {
                doubleValue = Double.NaN;
            }
            if (b || !Double.isNaN(doubleValue)) {
                n += doubleValue;
                ++n2;
            }
        }
        return n / n2;
    }
    
    public static double calculateMean(final Collection collection) {
        return calculateMean(collection, true);
    }
    
    public static double calculateMean(final Collection collection, final boolean b) {
        if (collection == null) {
            throw new IllegalArgumentException("Null 'values' argument.");
        }
        int n = 0;
        double n2 = 0.0;
        for (final Number next : collection) {
            if (next == null) {
                if (b) {
                    return Double.NaN;
                }
                continue;
            }
            else {
                if (!(next instanceof Number)) {
                    continue;
                }
                final Number n3 = next;
                if (Double.isNaN(n3.doubleValue())) {
                    if (b) {
                        return Double.NaN;
                    }
                    continue;
                }
                else {
                    n2 += n3.doubleValue();
                    ++n;
                }
            }
        }
        return n2 / n;
    }
    
    public static double calculateMedian(final List list) {
        return calculateMedian(list, true);
    }
    
    public static double calculateMedian(List list, final boolean b) {
        double n = Double.NaN;
        if (list != null) {
            if (b) {
                final int size = list.size();
                final ArrayList list2 = new ArrayList<Object>(size);
                for (int i = 0; i < size; ++i) {
                    list2.add(i, list.get(i));
                }
                Collections.sort((List<Comparable>)list2);
                list = list2;
            }
            final int size2 = list.size();
            if (size2 > 0) {
                if (size2 % 2 == 1) {
                    if (size2 > 1) {
                        n = ((Number)list.get((size2 - 1) / 2)).doubleValue();
                    }
                    else {
                        n = ((Number)list.get(0)).doubleValue();
                    }
                }
                else {
                    n = (((Number)list.get(size2 / 2 - 1)).doubleValue() + ((Number)list.get(size2 / 2)).doubleValue()) / 2.0;
                }
            }
        }
        return n;
    }
    
    public static double calculateMedian(final List list, final int n, final int n2) {
        return calculateMedian(list, n, n2, true);
    }
    
    public static double calculateMedian(final List list, final int n, final int n2, final boolean b) {
        double n3 = Double.NaN;
        if (b) {
            final ArrayList<Comparable<? super T>> list2 = (ArrayList<Comparable<? super T>>)new ArrayList<Comparable>(n2 - n + 1);
            for (int i = n; i <= n2; ++i) {
                list2.add(list.get(i));
            }
            Collections.sort((List<Comparable>)list2);
            n3 = calculateMedian(list2, false);
        }
        else {
            final int n4 = n2 - n + 1;
            if (n4 > 0) {
                if (n4 % 2 == 1) {
                    if (n4 > 1) {
                        n3 = ((Number)list.get(n + (n4 - 1) / 2)).doubleValue();
                    }
                    else {
                        n3 = ((Number)list.get(n)).doubleValue();
                    }
                }
                else {
                    n3 = (((Number)list.get(n + n4 / 2 - 1)).doubleValue() + ((Number)list.get(n + n4 / 2)).doubleValue()) / 2.0;
                }
            }
        }
        return n3;
    }
    
    public static double getStdDev(final Number[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Null 'data' array.");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Zero length 'data' array.");
        }
        final double calculateMean = calculateMean(array);
        double n = 0.0;
        for (int i = 0; i < array.length; ++i) {
            final double n2 = array[i].doubleValue() - calculateMean;
            n += n2 * n2;
        }
        return Math.sqrt(n / (array.length - 1));
    }
    
    public static double[] getLinearFit(final Number[] array, final Number[] array2) {
        if (array == null) {
            throw new IllegalArgumentException("Null 'xData' argument.");
        }
        if (array2 == null) {
            throw new IllegalArgumentException("Null 'yData' argument.");
        }
        if (array.length != array2.length) {
            throw new IllegalArgumentException("Statistics.getLinearFit(): array lengths must be equal.");
        }
        final double[] array3 = { 0.0, getSlope(array, array2) };
        array3[0] = calculateMean(array2) - array3[1] * calculateMean(array);
        return array3;
    }
    
    public static double getSlope(final Number[] array, final Number[] array2) {
        if (array == null) {
            throw new IllegalArgumentException("Null 'xData' argument.");
        }
        if (array2 == null) {
            throw new IllegalArgumentException("Null 'yData' argument.");
        }
        if (array.length != array2.length) {
            throw new IllegalArgumentException("Array lengths must be equal.");
        }
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        double n4 = 0.0;
        int i;
        for (i = 0; i < array.length; ++i) {
            n += array[i].doubleValue();
            n2 += Math.pow(array[i].doubleValue(), 2.0);
            n3 += array2[i].doubleValue() * array[i].doubleValue();
            n4 += array2[i].doubleValue();
        }
        return (n3 - n * n4 / i) / (n2 - n * n / i);
    }
    
    public static double getCorrelation(final Number[] array, final Number[] array2) {
        if (array == null) {
            throw new IllegalArgumentException("Null 'data1' argument.");
        }
        if (array2 == null) {
            throw new IllegalArgumentException("Null 'data2' argument.");
        }
        if (array.length != array2.length) {
            throw new IllegalArgumentException("'data1' and 'data2' arrays must have same length.");
        }
        final int length = array.length;
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        double n4 = 0.0;
        double n5 = 0.0;
        for (int i = 0; i < length; ++i) {
            double doubleValue = 0.0;
            if (array[i] != null) {
                doubleValue = array[i].doubleValue();
            }
            double doubleValue2 = 0.0;
            if (array2[i] != null) {
                doubleValue2 = array2[i].doubleValue();
            }
            n += doubleValue;
            n2 += doubleValue2;
            n5 += doubleValue * doubleValue2;
            n3 += doubleValue * doubleValue;
            n4 += doubleValue2 * doubleValue2;
        }
        return (length * n5 - n * n2) / Math.pow((length * n3 - n * n) * (length * n4 - n2 * n2), 0.5);
    }
    
    public static double[][] getMovingAverage(final Number[] array, final Number[] array2, final int n) {
        if (array.length != array2.length) {
            throw new IllegalArgumentException("Array lengths must be equal.");
        }
        if (n > array.length) {
            throw new IllegalArgumentException("Period can't be longer than dataset.");
        }
        final double[][] array3 = new double[array.length - n][2];
        for (int i = 0; i < array3.length; ++i) {
            array3[i][0] = array[i + n].doubleValue();
            double n2 = 0.0;
            for (int j = 0; j < n; ++j) {
                n2 += array2[i + j].doubleValue();
            }
            array3[i][1] = n2 / n;
        }
        return array3;
    }
}
