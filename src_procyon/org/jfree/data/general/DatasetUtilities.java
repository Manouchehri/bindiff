package org.jfree.data.general;

import java.util.*;
import org.jfree.util.*;
import org.jfree.data.function.*;
import org.jfree.data.category.*;
import org.jfree.data.*;
import org.jfree.data.xy.*;

public final class DatasetUtilities
{
    public static double calculatePieDatasetTotal(final PieDataset pieDataset) {
        if (pieDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        final List keys = pieDataset.getKeys();
        double n = 0.0;
        for (final Comparable comparable : keys) {
            if (comparable != null) {
                final Number value = pieDataset.getValue(comparable);
                double doubleValue = 0.0;
                if (value != null) {
                    doubleValue = value.doubleValue();
                }
                if (doubleValue <= 0.0) {
                    continue;
                }
                n += doubleValue;
            }
        }
        return n;
    }
    
    public static PieDataset createPieDatasetForRow(final CategoryDataset categoryDataset, final Comparable comparable) {
        return createPieDatasetForRow(categoryDataset, categoryDataset.getRowIndex(comparable));
    }
    
    public static PieDataset createPieDatasetForRow(final CategoryDataset categoryDataset, final int n) {
        final DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        for (int columnCount = categoryDataset.getColumnCount(), i = 0; i < columnCount; ++i) {
            defaultPieDataset.setValue(categoryDataset.getColumnKey(i), categoryDataset.getValue(n, i));
        }
        return defaultPieDataset;
    }
    
    public static PieDataset createPieDatasetForColumn(final CategoryDataset categoryDataset, final Comparable comparable) {
        return createPieDatasetForColumn(categoryDataset, categoryDataset.getColumnIndex(comparable));
    }
    
    public static PieDataset createPieDatasetForColumn(final CategoryDataset categoryDataset, final int n) {
        final DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        for (int rowCount = categoryDataset.getRowCount(), i = 0; i < rowCount; ++i) {
            defaultPieDataset.setValue(categoryDataset.getRowKey(i), categoryDataset.getValue(i, n));
        }
        return defaultPieDataset;
    }
    
    public static PieDataset createConsolidatedPieDataset(final PieDataset pieDataset, final Comparable comparable, final double n) {
        return createConsolidatedPieDataset(pieDataset, comparable, n, 2);
    }
    
    public static PieDataset createConsolidatedPieDataset(final PieDataset pieDataset, final Comparable comparable, final double n, final int n2) {
        final DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        final double calculatePieDatasetTotal = calculatePieDatasetTotal(pieDataset);
        final List keys = pieDataset.getKeys();
        final ArrayList list = new ArrayList<Comparable>();
        for (final Comparable comparable2 : keys) {
            final Number value = pieDataset.getValue(comparable2);
            if (value != null && value.doubleValue() / calculatePieDatasetTotal < n) {
                list.add(comparable2);
            }
        }
        final Iterator<Comparable> iterator2 = keys.iterator();
        double n3 = 0.0;
        while (iterator2.hasNext()) {
            final Comparable comparable3 = iterator2.next();
            final Number value2 = pieDataset.getValue(comparable3);
            if (value2 != null) {
                if (list.contains(comparable3) && list.size() >= n2) {
                    n3 += value2.doubleValue();
                }
                else {
                    defaultPieDataset.setValue(comparable3, value2);
                }
            }
        }
        if (list.size() >= n2) {
            defaultPieDataset.setValue(comparable, n3);
        }
        return defaultPieDataset;
    }
    
    public static CategoryDataset createCategoryDataset(final String s, final String s2, final double[][] array) {
        final DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        for (int i = 0; i < array.length; ++i) {
            final String string = s + (i + 1);
            for (int j = 0; j < array[i].length; ++j) {
                defaultCategoryDataset.addValue(new Double(array[i][j]), string, s2 + (j + 1));
            }
        }
        return defaultCategoryDataset;
    }
    
    public static CategoryDataset createCategoryDataset(final String s, final String s2, final Number[][] array) {
        final DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        for (int i = 0; i < array.length; ++i) {
            final String string = s + (i + 1);
            for (int j = 0; j < array[i].length; ++j) {
                defaultCategoryDataset.addValue(array[i][j], string, s2 + (j + 1));
            }
        }
        return defaultCategoryDataset;
    }
    
    public static CategoryDataset createCategoryDataset(final Comparable[] array, final Comparable[] array2, final double[][] array3) {
        if (array == null) {
            throw new IllegalArgumentException("Null 'rowKeys' argument.");
        }
        if (array2 == null) {
            throw new IllegalArgumentException("Null 'columnKeys' argument.");
        }
        if (ArrayUtilities.hasDuplicateItems(array)) {
            throw new IllegalArgumentException("Duplicate items in 'rowKeys'.");
        }
        if (ArrayUtilities.hasDuplicateItems(array2)) {
            throw new IllegalArgumentException("Duplicate items in 'columnKeys'.");
        }
        if (array.length != array3.length) {
            throw new IllegalArgumentException("The number of row keys does not match the number of rows in the data array.");
        }
        int max = 0;
        for (int i = 0; i < array3.length; ++i) {
            max = Math.max(max, array3[i].length);
        }
        if (array2.length != max) {
            throw new IllegalArgumentException("The number of column keys does not match the number of columns in the data array.");
        }
        final DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        for (int j = 0; j < array3.length; ++j) {
            final Comparable comparable = array[j];
            for (int k = 0; k < array3[j].length; ++k) {
                defaultCategoryDataset.addValue(new Double(array3[j][k]), comparable, array2[k]);
            }
        }
        return defaultCategoryDataset;
    }
    
    public static CategoryDataset createCategoryDataset(final Comparable comparable, final KeyedValues keyedValues) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'rowKey' argument.");
        }
        if (keyedValues == null) {
            throw new IllegalArgumentException("Null 'rowData' argument.");
        }
        final DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        for (int i = 0; i < keyedValues.getItemCount(); ++i) {
            defaultCategoryDataset.addValue(keyedValues.getValue(i), comparable, keyedValues.getKey(i));
        }
        return defaultCategoryDataset;
    }
    
    public static XYDataset sampleFunction2D(final Function2D function2D, final double n, final double n2, final int n3, final Comparable comparable) {
        if (function2D == null) {
            throw new IllegalArgumentException("Null 'f' argument.");
        }
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'seriesKey' argument.");
        }
        if (n >= n2) {
            throw new IllegalArgumentException("Requires 'start' < 'end'.");
        }
        if (n3 < 2) {
            throw new IllegalArgumentException("Requires 'samples' > 1");
        }
        final XYSeries xySeries = new XYSeries(comparable);
        final double n4 = (n2 - n) / n3;
        for (int i = 0; i <= n3; ++i) {
            final double n5 = n + n4 * i;
            xySeries.add(n5, function2D.getValue(n5));
        }
        return new XYSeriesCollection(xySeries);
    }
    
    public static boolean isEmptyOrNull(final PieDataset pieDataset) {
        if (pieDataset == null) {
            return true;
        }
        final int itemCount = pieDataset.getItemCount();
        if (itemCount == 0) {
            return true;
        }
        for (int i = 0; i < itemCount; ++i) {
            final Number value = pieDataset.getValue(i);
            if (value != null && value.doubleValue() > 0.0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isEmptyOrNull(final CategoryDataset categoryDataset) {
        if (categoryDataset == null) {
            return true;
        }
        final int rowCount = categoryDataset.getRowCount();
        final int columnCount = categoryDataset.getColumnCount();
        if (rowCount == 0 || columnCount == 0) {
            return true;
        }
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                if (categoryDataset.getValue(i, j) != null) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isEmptyOrNull(final XYDataset xyDataset) {
        boolean b = true;
        if (xyDataset != null) {
            for (int i = 0; i < xyDataset.getSeriesCount(); ++i) {
                if (xyDataset.getItemCount(i) > 0) {
                    b = false;
                }
            }
        }
        return b;
    }
    
    public static Range findDomainBounds(final XYDataset xyDataset) {
        return findDomainBounds(xyDataset, true);
    }
    
    public static Range findDomainBounds(final XYDataset xyDataset, final boolean b) {
        if (xyDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        Range range;
        if (xyDataset instanceof DomainInfo) {
            range = ((DomainInfo)xyDataset).getDomainBounds(b);
        }
        else {
            range = iterateDomainBounds(xyDataset, b);
        }
        return range;
    }
    
    public static Range iterateDomainBounds(final XYDataset xyDataset) {
        return iterateDomainBounds(xyDataset, true);
    }
    
    public static Range iterateDomainBounds(final XYDataset xyDataset, final boolean b) {
        if (xyDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        double n = Double.POSITIVE_INFINITY;
        double n2 = Double.NEGATIVE_INFINITY;
        final int seriesCount = xyDataset.getSeriesCount();
        if (b && xyDataset instanceof IntervalXYDataset) {
            final IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xyDataset;
            for (int i = 0; i < seriesCount; ++i) {
                for (int itemCount = xyDataset.getItemCount(i), j = 0; j < itemCount; ++j) {
                    final double startXValue = intervalXYDataset.getStartXValue(i, j);
                    final double endXValue = intervalXYDataset.getEndXValue(i, j);
                    n = Math.min(n, startXValue);
                    n2 = Math.max(n2, endXValue);
                }
            }
        }
        else {
            for (int k = 0; k < seriesCount; ++k) {
                for (int itemCount2 = xyDataset.getItemCount(k), l = 0; l < itemCount2; ++l) {
                    final double xValue;
                    n = Math.min(n, xValue = xyDataset.getXValue(k, l));
                    n2 = Math.max(n2, xValue);
                }
            }
        }
        if (n > n2) {
            return null;
        }
        return new Range(n, n2);
    }
    
    public static Range findRangeBounds(final CategoryDataset categoryDataset) {
        return findRangeBounds(categoryDataset, true);
    }
    
    public static Range findRangeBounds(final CategoryDataset categoryDataset, final boolean b) {
        if (categoryDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        Range range;
        if (categoryDataset instanceof RangeInfo) {
            range = ((RangeInfo)categoryDataset).getRangeBounds(b);
        }
        else {
            range = iterateCategoryRangeBounds(categoryDataset, b);
        }
        return range;
    }
    
    public static Range findRangeBounds(final XYDataset xyDataset) {
        return findRangeBounds(xyDataset, true);
    }
    
    public static Range findRangeBounds(final XYDataset xyDataset, final boolean b) {
        if (xyDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        Range range;
        if (xyDataset instanceof RangeInfo) {
            range = ((RangeInfo)xyDataset).getRangeBounds(b);
        }
        else {
            range = iterateXYRangeBounds(xyDataset);
        }
        return range;
    }
    
    public static Range iterateCategoryRangeBounds(final CategoryDataset categoryDataset, final boolean b) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        final boolean b2 = b && categoryDataset instanceof IntervalCategoryDataset;
        final int rowCount = categoryDataset.getRowCount();
        final int columnCount = categoryDataset.getColumnCount();
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                Number startValue;
                Number n;
                if (b2) {
                    final IntervalCategoryDataset intervalCategoryDataset = (IntervalCategoryDataset)categoryDataset;
                    startValue = intervalCategoryDataset.getStartValue(i, j);
                    n = intervalCategoryDataset.getEndValue(i, j);
                }
                else {
                    startValue = (n = categoryDataset.getValue(i, j));
                }
                if (startValue != null) {
                    min = Math.min(min, startValue.doubleValue());
                }
                if (n != null) {
                    max = Math.max(max, n.doubleValue());
                }
            }
        }
        if (min == Double.POSITIVE_INFINITY) {
            return null;
        }
        return new Range(min, max);
    }
    
    public static Range iterateXYRangeBounds(final XYDataset xyDataset) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (int seriesCount = xyDataset.getSeriesCount(), i = 0; i < seriesCount; ++i) {
            for (int itemCount = xyDataset.getItemCount(i), j = 0; j < itemCount; ++j) {
                double n;
                double n2;
                if (xyDataset instanceof IntervalXYDataset) {
                    final IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xyDataset;
                    n = intervalXYDataset.getStartYValue(i, j);
                    n2 = intervalXYDataset.getEndYValue(i, j);
                }
                else if (xyDataset instanceof OHLCDataset) {
                    final OHLCDataset ohlcDataset = (OHLCDataset)xyDataset;
                    n = ohlcDataset.getLowValue(i, j);
                    n2 = ohlcDataset.getHighValue(i, j);
                }
                else {
                    n = (n2 = xyDataset.getYValue(i, j));
                }
                if (!Double.isNaN(n)) {
                    min = Math.min(min, n);
                }
                if (!Double.isNaN(n2)) {
                    max = Math.max(max, n2);
                }
            }
        }
        if (min == Double.POSITIVE_INFINITY) {
            return null;
        }
        return new Range(min, max);
    }
    
    public static Number findMinimumDomainValue(final XYDataset xyDataset) {
        if (xyDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        if (xyDataset instanceof DomainInfo) {
            return new Double(((DomainInfo)xyDataset).getDomainLowerBound(true));
        }
        double min = Double.POSITIVE_INFINITY;
        for (int seriesCount = xyDataset.getSeriesCount(), i = 0; i < seriesCount; ++i) {
            for (int itemCount = xyDataset.getItemCount(i), j = 0; j < itemCount; ++j) {
                double n;
                if (xyDataset instanceof IntervalXYDataset) {
                    n = ((IntervalXYDataset)xyDataset).getStartXValue(i, j);
                }
                else {
                    n = xyDataset.getXValue(i, j);
                }
                if (!Double.isNaN(n)) {
                    min = Math.min(min, n);
                }
            }
        }
        Number n2;
        if (min == Double.POSITIVE_INFINITY) {
            n2 = null;
        }
        else {
            n2 = new Double(min);
        }
        return n2;
    }
    
    public static Number findMaximumDomainValue(final XYDataset xyDataset) {
        if (xyDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        if (xyDataset instanceof DomainInfo) {
            return new Double(((DomainInfo)xyDataset).getDomainUpperBound(true));
        }
        double max = Double.NEGATIVE_INFINITY;
        for (int seriesCount = xyDataset.getSeriesCount(), i = 0; i < seriesCount; ++i) {
            for (int itemCount = xyDataset.getItemCount(i), j = 0; j < itemCount; ++j) {
                double n;
                if (xyDataset instanceof IntervalXYDataset) {
                    n = ((IntervalXYDataset)xyDataset).getEndXValue(i, j);
                }
                else {
                    n = xyDataset.getXValue(i, j);
                }
                if (!Double.isNaN(n)) {
                    max = Math.max(max, n);
                }
            }
        }
        Number n2;
        if (max == Double.NEGATIVE_INFINITY) {
            n2 = null;
        }
        else {
            n2 = new Double(max);
        }
        return n2;
    }
    
    public static Number findMinimumRangeValue(final CategoryDataset categoryDataset) {
        if (categoryDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        if (categoryDataset instanceof RangeInfo) {
            return new Double(((RangeInfo)categoryDataset).getRangeLowerBound(true));
        }
        double min = Double.POSITIVE_INFINITY;
        final int rowCount = categoryDataset.getRowCount();
        final int columnCount = categoryDataset.getColumnCount();
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                Number n;
                if (categoryDataset instanceof IntervalCategoryDataset) {
                    n = ((IntervalCategoryDataset)categoryDataset).getStartValue(i, j);
                }
                else {
                    n = categoryDataset.getValue(i, j);
                }
                if (n != null) {
                    min = Math.min(min, n.doubleValue());
                }
            }
        }
        if (min == Double.POSITIVE_INFINITY) {
            return null;
        }
        return new Double(min);
    }
    
    public static Number findMinimumRangeValue(final XYDataset xyDataset) {
        if (xyDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        if (xyDataset instanceof RangeInfo) {
            return new Double(((RangeInfo)xyDataset).getRangeLowerBound(true));
        }
        double min = Double.POSITIVE_INFINITY;
        for (int seriesCount = xyDataset.getSeriesCount(), i = 0; i < seriesCount; ++i) {
            for (int itemCount = xyDataset.getItemCount(i), j = 0; j < itemCount; ++j) {
                double n;
                if (xyDataset instanceof IntervalXYDataset) {
                    n = ((IntervalXYDataset)xyDataset).getStartYValue(i, j);
                }
                else if (xyDataset instanceof OHLCDataset) {
                    n = ((OHLCDataset)xyDataset).getLowValue(i, j);
                }
                else {
                    n = xyDataset.getYValue(i, j);
                }
                if (!Double.isNaN(n)) {
                    min = Math.min(min, n);
                }
            }
        }
        if (min == Double.POSITIVE_INFINITY) {
            return null;
        }
        return new Double(min);
    }
    
    public static Number findMaximumRangeValue(final CategoryDataset categoryDataset) {
        if (categoryDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        if (categoryDataset instanceof RangeInfo) {
            return new Double(((RangeInfo)categoryDataset).getRangeUpperBound(true));
        }
        double max = Double.NEGATIVE_INFINITY;
        final int rowCount = categoryDataset.getRowCount();
        final int columnCount = categoryDataset.getColumnCount();
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                Number n;
                if (categoryDataset instanceof IntervalCategoryDataset) {
                    n = ((IntervalCategoryDataset)categoryDataset).getEndValue(i, j);
                }
                else {
                    n = categoryDataset.getValue(i, j);
                }
                if (n != null) {
                    max = Math.max(max, n.doubleValue());
                }
            }
        }
        if (max == Double.NEGATIVE_INFINITY) {
            return null;
        }
        return new Double(max);
    }
    
    public static Number findMaximumRangeValue(final XYDataset xyDataset) {
        if (xyDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        if (xyDataset instanceof RangeInfo) {
            return new Double(((RangeInfo)xyDataset).getRangeUpperBound(true));
        }
        double max = Double.NEGATIVE_INFINITY;
        for (int seriesCount = xyDataset.getSeriesCount(), i = 0; i < seriesCount; ++i) {
            for (int itemCount = xyDataset.getItemCount(i), j = 0; j < itemCount; ++j) {
                double n;
                if (xyDataset instanceof IntervalXYDataset) {
                    n = ((IntervalXYDataset)xyDataset).getEndYValue(i, j);
                }
                else if (xyDataset instanceof OHLCDataset) {
                    n = ((OHLCDataset)xyDataset).getHighValue(i, j);
                }
                else {
                    n = xyDataset.getYValue(i, j);
                }
                if (!Double.isNaN(n)) {
                    max = Math.max(max, n);
                }
            }
        }
        if (max == Double.NEGATIVE_INFINITY) {
            return null;
        }
        return new Double(max);
    }
    
    public static Range findStackedRangeBounds(final CategoryDataset categoryDataset) {
        return findStackedRangeBounds(categoryDataset, 0.0);
    }
    
    public static Range findStackedRangeBounds(final CategoryDataset categoryDataset, final double n) {
        if (categoryDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        Range range = null;
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (int columnCount = categoryDataset.getColumnCount(), i = 0; i < columnCount; ++i) {
            double n2 = n;
            double n3 = n;
            for (int rowCount = categoryDataset.getRowCount(), j = 0; j < rowCount; ++j) {
                final Number value = categoryDataset.getValue(j, i);
                if (value != null) {
                    final double doubleValue = value.doubleValue();
                    if (doubleValue > 0.0) {
                        n2 += doubleValue;
                    }
                    if (doubleValue < 0.0) {
                        n3 += doubleValue;
                    }
                }
            }
            min = Math.min(min, n3);
            max = Math.max(max, n2);
        }
        if (min <= max) {
            range = new Range(min, max);
        }
        return range;
    }
    
    public static Range findStackedRangeBounds(final CategoryDataset categoryDataset, final KeyToGroupMap keyToGroupMap) {
        Range combine = null;
        if (categoryDataset != null) {
            final int[] array = new int[categoryDataset.getRowCount()];
            for (int i = 0; i < categoryDataset.getRowCount(); ++i) {
                array[i] = keyToGroupMap.getGroupIndex(keyToGroupMap.getGroup(categoryDataset.getRowKey(i)));
            }
            final int groupCount = keyToGroupMap.getGroupCount();
            final double[] array2 = new double[groupCount];
            final double[] array3 = new double[groupCount];
            for (int columnCount = categoryDataset.getColumnCount(), j = 0; j < columnCount; ++j) {
                final double[] array4 = new double[groupCount];
                final double[] array5 = new double[groupCount];
                for (int rowCount = categoryDataset.getRowCount(), k = 0; k < rowCount; ++k) {
                    final Number value = categoryDataset.getValue(k, j);
                    if (value != null) {
                        final double doubleValue = value.doubleValue();
                        if (doubleValue > 0.0) {
                            array4[array[k]] += doubleValue;
                        }
                        if (doubleValue < 0.0) {
                            array5[array[k]] += doubleValue;
                        }
                    }
                }
                for (int l = 0; l < groupCount; ++l) {
                    array2[l] = Math.min(array2[l], array5[l]);
                    array3[l] = Math.max(array3[l], array4[l]);
                }
            }
            for (int n = 0; n < groupCount; ++n) {
                combine = Range.combine(combine, new Range(array2[n], array3[n]));
            }
        }
        return combine;
    }
    
    public static Number findMinimumStackedRangeValue(final CategoryDataset categoryDataset) {
        Number n = null;
        if (categoryDataset != null) {
            double min = 0.0;
            for (int rowCount = categoryDataset.getRowCount(), i = 0; i < rowCount; ++i) {
                double n2 = 0.0;
                for (int columnCount = categoryDataset.getColumnCount(), j = 0; j < columnCount; ++j) {
                    final Number value = categoryDataset.getValue(j, i);
                    if (value != null) {
                        final double doubleValue = value.doubleValue();
                        if (doubleValue < 0.0) {
                            n2 += doubleValue;
                        }
                    }
                }
                min = Math.min(min, n2);
            }
            n = new Double(min);
        }
        return n;
    }
    
    public static Number findMaximumStackedRangeValue(final CategoryDataset categoryDataset) {
        Number n = null;
        if (categoryDataset != null) {
            double max = 0.0;
            for (int columnCount = categoryDataset.getColumnCount(), i = 0; i < columnCount; ++i) {
                double n2 = 0.0;
                for (int rowCount = categoryDataset.getRowCount(), j = 0; j < rowCount; ++j) {
                    final Number value = categoryDataset.getValue(j, i);
                    if (value != null) {
                        final double doubleValue = value.doubleValue();
                        if (doubleValue > 0.0) {
                            n2 += doubleValue;
                        }
                    }
                }
                max = Math.max(max, n2);
            }
            n = new Double(max);
        }
        return n;
    }
    
    public static Range findStackedRangeBounds(final TableXYDataset tableXYDataset) {
        return findStackedRangeBounds(tableXYDataset, 0.0);
    }
    
    public static Range findStackedRangeBounds(final TableXYDataset tableXYDataset, final double n) {
        if (tableXYDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        double n2 = n;
        double n3 = n;
        for (int i = 0; i < tableXYDataset.getItemCount(); ++i) {
            double n4 = n;
            double n5 = n;
            for (int seriesCount = tableXYDataset.getSeriesCount(), j = 0; j < seriesCount; ++j) {
                final double yValue = tableXYDataset.getYValue(j, i);
                if (!Double.isNaN(yValue)) {
                    if (yValue > 0.0) {
                        n4 += yValue;
                    }
                    else {
                        n5 += yValue;
                    }
                }
            }
            if (n4 > n3) {
                n3 = n4;
            }
            if (n5 < n2) {
                n2 = n5;
            }
        }
        if (n2 <= n3) {
            return new Range(n2, n3);
        }
        return null;
    }
    
    public static double calculateStackTotal(final TableXYDataset tableXYDataset, final int n) {
        double n2 = 0.0;
        for (int seriesCount = tableXYDataset.getSeriesCount(), i = 0; i < seriesCount; ++i) {
            final double yValue = tableXYDataset.getYValue(i, n);
            if (!Double.isNaN(yValue)) {
                n2 += yValue;
            }
        }
        return n2;
    }
    
    public static Range findCumulativeRangeBounds(final CategoryDataset categoryDataset) {
        if (categoryDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        boolean b = true;
        double min = 0.0;
        double max = 0.0;
        for (int i = 0; i < categoryDataset.getRowCount(); ++i) {
            double n = 0.0;
            for (int j = 0; j < categoryDataset.getColumnCount() - 1; ++j) {
                final Number value = categoryDataset.getValue(i, j);
                if (value != null) {
                    b = false;
                    n += value.doubleValue();
                    min = Math.min(min, n);
                    max = Math.max(max, n);
                }
            }
        }
        if (!b) {
            return new Range(min, max);
        }
        return null;
    }
}
