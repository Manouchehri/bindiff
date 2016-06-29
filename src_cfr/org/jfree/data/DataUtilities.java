/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;

public abstract class DataUtilities {
    public static double calculateColumnTotal(Values2D values2D, int n2) {
        double d2 = 0.0;
        int n3 = values2D.getRowCount();
        int n4 = 0;
        while (n4 < n3) {
            Number number = values2D.getValue(n4, n2);
            if (number != null) {
                d2 += number.doubleValue();
            }
            ++n4;
        }
        return d2;
    }

    public static double calculateRowTotal(Values2D values2D, int n2) {
        double d2 = 0.0;
        int n3 = values2D.getColumnCount();
        int n4 = 0;
        while (n4 < n3) {
            Number number = values2D.getValue(n2, n4);
            if (number != null) {
                d2 += number.doubleValue();
            }
            ++n4;
        }
        return d2;
    }

    public static Number[] createNumberArray(double[] arrd) {
        if (arrd == null) {
            throw new IllegalArgumentException("Null 'data' argument.");
        }
        Number[] arrnumber = new Number[arrd.length];
        int n2 = 0;
        while (n2 < arrd.length) {
            arrnumber[n2] = new Double(arrd[n2]);
            ++n2;
        }
        return arrnumber;
    }

    public static Number[][] createNumberArray2D(double[][] arrd) {
        if (arrd == null) {
            throw new IllegalArgumentException("Null 'data' argument.");
        }
        int n2 = arrd.length;
        Number[][] arrnumber = new Number[n2][];
        int n3 = 0;
        while (n3 < n2) {
            arrnumber[n3] = DataUtilities.createNumberArray(arrd[n3]);
            ++n3;
        }
        return arrnumber;
    }

    public static KeyedValues getCumulativePercentages(KeyedValues keyedValues) {
        if (keyedValues == null) {
            throw new IllegalArgumentException("Null 'data' argument.");
        }
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        double d2 = 0.0;
        for (int i2 = 0; i2 < keyedValues.getItemCount(); ++i2) {
            Number number = keyedValues.getValue(i2);
            if (number == null) continue;
            d2 += number.doubleValue();
        }
        double d3 = 0.0;
        int n2 = 0;
        while (n2 < keyedValues.getItemCount()) {
            Number number = keyedValues.getValue(n2);
            if (number != null) {
                d3 += number.doubleValue();
            }
            defaultKeyedValues.addValue(keyedValues.getKey(n2), new Double(d3 / d2));
            ++n2;
        }
        return defaultKeyedValues;
    }
}

