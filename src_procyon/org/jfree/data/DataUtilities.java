package org.jfree.data;

public abstract class DataUtilities
{
    public static double calculateColumnTotal(final Values2D values2D, final int n) {
        double n2 = 0.0;
        for (int rowCount = values2D.getRowCount(), i = 0; i < rowCount; ++i) {
            final Number value = values2D.getValue(i, n);
            if (value != null) {
                n2 += value.doubleValue();
            }
        }
        return n2;
    }
    
    public static double calculateRowTotal(final Values2D values2D, final int n) {
        double n2 = 0.0;
        for (int columnCount = values2D.getColumnCount(), i = 0; i < columnCount; ++i) {
            final Number value = values2D.getValue(n, i);
            if (value != null) {
                n2 += value.doubleValue();
            }
        }
        return n2;
    }
    
    public static Number[] createNumberArray(final double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Null 'data' argument.");
        }
        final Number[] array2 = new Number[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = new Double(array[i]);
        }
        return array2;
    }
    
    public static Number[][] createNumberArray2D(final double[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Null 'data' argument.");
        }
        final int length = array.length;
        final Number[][] array2 = new Number[length][];
        for (int i = 0; i < length; ++i) {
            array2[i] = createNumberArray(array[i]);
        }
        return array2;
    }
    
    public static KeyedValues getCumulativePercentages(final KeyedValues keyedValues) {
        if (keyedValues == null) {
            throw new IllegalArgumentException("Null 'data' argument.");
        }
        final DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        double n = 0.0;
        for (int i = 0; i < keyedValues.getItemCount(); ++i) {
            final Number value = keyedValues.getValue(i);
            if (value != null) {
                n += value.doubleValue();
            }
        }
        double n2 = 0.0;
        for (int j = 0; j < keyedValues.getItemCount(); ++j) {
            final Number value2 = keyedValues.getValue(j);
            if (value2 != null) {
                n2 += value2.doubleValue();
            }
            defaultKeyedValues.addValue(keyedValues.getKey(j), new Double(n2 / n));
        }
        return defaultKeyedValues;
    }
}
