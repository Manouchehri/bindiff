package org.jfree.data.statistics;

import org.jfree.data.xy.*;

public abstract class Regression
{
    public static double[] getOLSRegression(final double[][] array) {
        final int length = array.length;
        if (length < 2) {
            throw new IllegalArgumentException("Not enough data.");
        }
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        double n4 = 0.0;
        for (int i = 0; i < length; ++i) {
            final double n5 = array[i][0];
            final double n6 = array[i][1];
            n += n5;
            n2 += n6;
            n3 += n5 * n5;
            n4 += n5 * n6;
        }
        final double n7 = n3 - n * n / length;
        final double n8 = n4 - n * n2 / length;
        final double n9 = n / length;
        final double n10 = n2 / length;
        final double[] array2 = { 0.0, n8 / n7 };
        array2[0] = n10 - array2[1] * n9;
        return array2;
    }
    
    public static double[] getOLSRegression(final XYDataset xyDataset, final int n) {
        final int itemCount = xyDataset.getItemCount(n);
        if (itemCount < 2) {
            throw new IllegalArgumentException("Not enough data.");
        }
        double n2 = 0.0;
        double n3 = 0.0;
        double n4 = 0.0;
        double n5 = 0.0;
        for (int i = 0; i < itemCount; ++i) {
            final double xValue = xyDataset.getXValue(n, i);
            final double yValue = xyDataset.getYValue(n, i);
            n2 += xValue;
            n3 += yValue;
            n4 += xValue * xValue;
            n5 += xValue * yValue;
        }
        final double n6 = n4 - n2 * n2 / itemCount;
        final double n7 = n5 - n2 * n3 / itemCount;
        final double n8 = n2 / itemCount;
        final double n9 = n3 / itemCount;
        final double[] array = { 0.0, n7 / n6 };
        array[0] = n9 - array[1] * n8;
        return array;
    }
    
    public static double[] getPowerRegression(final double[][] array) {
        final int length = array.length;
        if (length < 2) {
            throw new IllegalArgumentException("Not enough data.");
        }
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        double n4 = 0.0;
        for (int i = 0; i < length; ++i) {
            final double log = Math.log(array[i][0]);
            final double log2 = Math.log(array[i][1]);
            n += log;
            n2 += log2;
            n3 += log * log;
            n4 += log * log2;
        }
        final double n5 = n3 - n * n / length;
        final double n6 = n4 - n * n2 / length;
        final double n7 = n / length;
        final double n8 = n2 / length;
        final double[] array2 = { 0.0, n6 / n5 };
        array2[0] = Math.pow(Math.exp(1.0), n8 - array2[1] * n7);
        return array2;
    }
    
    public static double[] getPowerRegression(final XYDataset xyDataset, final int n) {
        final int itemCount = xyDataset.getItemCount(n);
        if (itemCount < 2) {
            throw new IllegalArgumentException("Not enough data.");
        }
        double n2 = 0.0;
        double n3 = 0.0;
        double n4 = 0.0;
        double n5 = 0.0;
        for (int i = 0; i < itemCount; ++i) {
            final double log = Math.log(xyDataset.getXValue(n, i));
            final double log2 = Math.log(xyDataset.getYValue(n, i));
            n2 += log;
            n3 += log2;
            n4 += log * log;
            n5 += log * log2;
        }
        final double n6 = n4 - n2 * n2 / itemCount;
        final double n7 = n5 - n2 * n3 / itemCount;
        final double n8 = n2 / itemCount;
        final double n9 = n3 / itemCount;
        final double[] array = { 0.0, n7 / n6 };
        array[0] = Math.pow(Math.exp(1.0), n9 - array[1] * n8);
        return array;
    }
}
