/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.DomainInfo;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.KeyedValues;
import org.jfree.data.Range;
import org.jfree.data.RangeInfo;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.function.Function2D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ArrayUtilities;

public final class DatasetUtilities {
    private DatasetUtilities() {
    }

    public static double calculatePieDatasetTotal(PieDataset pieDataset) {
        if (pieDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        List list = pieDataset.getKeys();
        double d2 = 0.0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Comparable comparable = (Comparable)iterator.next();
            if (comparable == null) continue;
            Number number = pieDataset.getValue(comparable);
            double d3 = 0.0;
            if (number != null) {
                d3 = number.doubleValue();
            }
            if (d3 <= 0.0) continue;
            d2 += d3;
        }
        return d2;
    }

    public static PieDataset createPieDatasetForRow(CategoryDataset categoryDataset, Comparable comparable) {
        int n2 = categoryDataset.getRowIndex(comparable);
        return DatasetUtilities.createPieDatasetForRow(categoryDataset, n2);
    }

    public static PieDataset createPieDatasetForRow(CategoryDataset categoryDataset, int n2) {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        int n3 = categoryDataset.getColumnCount();
        int n4 = 0;
        while (n4 < n3) {
            Comparable comparable = categoryDataset.getColumnKey(n4);
            defaultPieDataset.setValue(comparable, categoryDataset.getValue(n2, n4));
            ++n4;
        }
        return defaultPieDataset;
    }

    public static PieDataset createPieDatasetForColumn(CategoryDataset categoryDataset, Comparable comparable) {
        int n2 = categoryDataset.getColumnIndex(comparable);
        return DatasetUtilities.createPieDatasetForColumn(categoryDataset, n2);
    }

    public static PieDataset createPieDatasetForColumn(CategoryDataset categoryDataset, int n2) {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        int n3 = categoryDataset.getRowCount();
        int n4 = 0;
        while (n4 < n3) {
            Comparable comparable = categoryDataset.getRowKey(n4);
            defaultPieDataset.setValue(comparable, categoryDataset.getValue(n4, n2));
            ++n4;
        }
        return defaultPieDataset;
    }

    public static PieDataset createConsolidatedPieDataset(PieDataset pieDataset, Comparable comparable, double d2) {
        return DatasetUtilities.createConsolidatedPieDataset(pieDataset, comparable, d2, 2);
    }

    public static PieDataset createConsolidatedPieDataset(PieDataset pieDataset, Comparable comparable, double d2, int n2) {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        double d3 = DatasetUtilities.calculatePieDatasetTotal(pieDataset);
        List list = pieDataset.getKeys();
        ArrayList<Comparable> arrayList = new ArrayList<Comparable>();
        for (Comparable comparable2 : list) {
            double d4;
            Number number = pieDataset.getValue(comparable2);
            if (number == null || (d4 = number.doubleValue()) / d3 >= d2) continue;
            arrayList.add(comparable2);
        }
        Iterator iterator = list.iterator();
        double d5 = 0.0;
        do {
            if (!iterator.hasNext()) {
                if (arrayList.size() < n2) return defaultPieDataset;
                defaultPieDataset.setValue(comparable, d5);
                return defaultPieDataset;
            }
            Comparable comparable3 = (Comparable)iterator.next();
            Number number = pieDataset.getValue(comparable3);
            if (number == null) continue;
            if (arrayList.contains(comparable3) && arrayList.size() >= n2) {
                d5 += number.doubleValue();
                continue;
            }
            defaultPieDataset.setValue(comparable3, number);
        } while (true);
    }

    public static CategoryDataset createCategoryDataset(String string, String string2, double[][] arrd) {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        int n2 = 0;
        while (n2 < arrd.length) {
            String string3 = new StringBuffer().append(string).append(n2 + 1).toString();
            for (int i2 = 0; i2 < arrd[n2].length; ++i2) {
                String string4 = new StringBuffer().append(string2).append(i2 + 1).toString();
                defaultCategoryDataset.addValue(new Double(arrd[n2][i2]), (Comparable)((Object)string3), (Comparable)((Object)string4));
            }
            ++n2;
        }
        return defaultCategoryDataset;
    }

    public static CategoryDataset createCategoryDataset(String string, String string2, Number[][] arrnumber) {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        int n2 = 0;
        while (n2 < arrnumber.length) {
            String string3 = new StringBuffer().append(string).append(n2 + 1).toString();
            for (int i2 = 0; i2 < arrnumber[n2].length; ++i2) {
                String string4 = new StringBuffer().append(string2).append(i2 + 1).toString();
                defaultCategoryDataset.addValue(arrnumber[n2][i2], (Comparable)((Object)string3), (Comparable)((Object)string4));
            }
            ++n2;
        }
        return defaultCategoryDataset;
    }

    public static CategoryDataset createCategoryDataset(Comparable[] arrcomparable, Comparable[] arrcomparable2, double[][] arrd) {
        if (arrcomparable == null) {
            throw new IllegalArgumentException("Null 'rowKeys' argument.");
        }
        if (arrcomparable2 == null) {
            throw new IllegalArgumentException("Null 'columnKeys' argument.");
        }
        if (ArrayUtilities.hasDuplicateItems(arrcomparable)) {
            throw new IllegalArgumentException("Duplicate items in 'rowKeys'.");
        }
        if (ArrayUtilities.hasDuplicateItems(arrcomparable2)) {
            throw new IllegalArgumentException("Duplicate items in 'columnKeys'.");
        }
        if (arrcomparable.length != arrd.length) {
            throw new IllegalArgumentException("The number of row keys does not match the number of rows in the data array.");
        }
        int n2 = 0;
        for (int i2 = 0; i2 < arrd.length; ++i2) {
            n2 = Math.max(n2, arrd[i2].length);
        }
        if (arrcomparable2.length != n2) {
            throw new IllegalArgumentException("The number of column keys does not match the number of columns in the data array.");
        }
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        int n3 = 0;
        while (n3 < arrd.length) {
            Comparable comparable = arrcomparable[n3];
            for (int i3 = 0; i3 < arrd[n3].length; ++i3) {
                Comparable comparable2 = arrcomparable2[i3];
                defaultCategoryDataset.addValue(new Double(arrd[n3][i3]), comparable, comparable2);
            }
            ++n3;
        }
        return defaultCategoryDataset;
    }

    public static CategoryDataset createCategoryDataset(Comparable comparable, KeyedValues keyedValues) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'rowKey' argument.");
        }
        if (keyedValues == null) {
            throw new IllegalArgumentException("Null 'rowData' argument.");
        }
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        int n2 = 0;
        while (n2 < keyedValues.getItemCount()) {
            defaultCategoryDataset.addValue(keyedValues.getValue(n2), comparable, keyedValues.getKey(n2));
            ++n2;
        }
        return defaultCategoryDataset;
    }

    public static XYDataset sampleFunction2D(Function2D function2D, double d2, double d3, int n2, Comparable comparable) {
        if (function2D == null) {
            throw new IllegalArgumentException("Null 'f' argument.");
        }
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'seriesKey' argument.");
        }
        if (d2 >= d3) {
            throw new IllegalArgumentException("Requires 'start' < 'end'.");
        }
        if (n2 < 2) {
            throw new IllegalArgumentException("Requires 'samples' > 1");
        }
        XYSeries xYSeries = new XYSeries(comparable);
        double d4 = (d3 - d2) / (double)n2;
        int n3 = 0;
        while (n3 <= n2) {
            double d5 = d2 + d4 * (double)n3;
            xYSeries.add(d5, function2D.getValue(d5));
            ++n3;
        }
        return new XYSeriesCollection(xYSeries);
    }

    public static boolean isEmptyOrNull(PieDataset pieDataset) {
        if (pieDataset == null) {
            return true;
        }
        int n2 = pieDataset.getItemCount();
        if (n2 == 0) {
            return true;
        }
        int n3 = 0;
        while (n3 < n2) {
            double d2;
            Number number = pieDataset.getValue(n3);
            if (number != null && (d2 = number.doubleValue()) > 0.0) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    public static boolean isEmptyOrNull(CategoryDataset categoryDataset) {
        if (categoryDataset == null) {
            return true;
        }
        int n2 = categoryDataset.getRowCount();
        int n3 = categoryDataset.getColumnCount();
        if (n2 == 0) return true;
        if (n3 == 0) {
            return true;
        }
        int n4 = 0;
        while (n4 < n2) {
            for (int i2 = 0; i2 < n3; ++i2) {
                if (categoryDataset.getValue(n4, i2) == null) continue;
                return false;
            }
            ++n4;
        }
        return true;
    }

    public static boolean isEmptyOrNull(XYDataset xYDataset) {
        boolean bl2 = true;
        if (xYDataset == null) return bl2;
        int n2 = 0;
        while (n2 < xYDataset.getSeriesCount()) {
            if (xYDataset.getItemCount(n2) > 0) {
                bl2 = false;
            }
            ++n2;
        }
        return bl2;
    }

    public static Range findDomainBounds(XYDataset xYDataset) {
        return DatasetUtilities.findDomainBounds(xYDataset, true);
    }

    public static Range findDomainBounds(XYDataset xYDataset, boolean bl2) {
        if (xYDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        Range range = null;
        if (!(xYDataset instanceof DomainInfo)) return DatasetUtilities.iterateDomainBounds(xYDataset, bl2);
        DomainInfo domainInfo = (DomainInfo)((Object)xYDataset);
        return domainInfo.getDomainBounds(bl2);
    }

    public static Range iterateDomainBounds(XYDataset xYDataset) {
        return DatasetUtilities.iterateDomainBounds(xYDataset, true);
    }

    public static Range iterateDomainBounds(XYDataset xYDataset, boolean bl2) {
        if (xYDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        double d2 = Double.POSITIVE_INFINITY;
        double d3 = Double.NEGATIVE_INFINITY;
        int n2 = xYDataset.getSeriesCount();
        if (bl2 && xYDataset instanceof IntervalXYDataset) {
            IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xYDataset;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = xYDataset.getItemCount(i2);
                for (int i3 = 0; i3 < n3; ++i3) {
                    double d4 = intervalXYDataset.getStartXValue(i2, i3);
                    double d5 = intervalXYDataset.getEndXValue(i2, i3);
                    d2 = Math.min(d2, d4);
                    d3 = Math.max(d3, d5);
                }
            }
        } else {
            for (int i4 = 0; i4 < n2; ++i4) {
                int n4 = xYDataset.getItemCount(i4);
                for (int i5 = 0; i5 < n4; ++i5) {
                    double d6;
                    double d7 = d6 = xYDataset.getXValue(i4, i5);
                    d2 = Math.min(d2, d6);
                    d3 = Math.max(d3, d7);
                }
            }
        }
        if (d2 <= d3) return new Range(d2, d3);
        return null;
    }

    public static Range findRangeBounds(CategoryDataset categoryDataset) {
        return DatasetUtilities.findRangeBounds(categoryDataset, true);
    }

    public static Range findRangeBounds(CategoryDataset categoryDataset, boolean bl2) {
        if (categoryDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        Range range = null;
        if (!(categoryDataset instanceof RangeInfo)) return DatasetUtilities.iterateCategoryRangeBounds(categoryDataset, bl2);
        RangeInfo rangeInfo = (RangeInfo)((Object)categoryDataset);
        return rangeInfo.getRangeBounds(bl2);
    }

    public static Range findRangeBounds(XYDataset xYDataset) {
        return DatasetUtilities.findRangeBounds(xYDataset, true);
    }

    public static Range findRangeBounds(XYDataset xYDataset, boolean bl2) {
        if (xYDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        Range range = null;
        if (!(xYDataset instanceof RangeInfo)) return DatasetUtilities.iterateXYRangeBounds(xYDataset);
        RangeInfo rangeInfo = (RangeInfo)((Object)xYDataset);
        return rangeInfo.getRangeBounds(bl2);
    }

    public static Range iterateCategoryRangeBounds(CategoryDataset categoryDataset, boolean bl2) {
        double d2 = Double.POSITIVE_INFINITY;
        double d3 = Double.NEGATIVE_INFINITY;
        boolean bl3 = bl2 && categoryDataset instanceof IntervalCategoryDataset;
        int n2 = categoryDataset.getRowCount();
        int n3 = categoryDataset.getColumnCount();
        int n4 = 0;
        do {
            if (n4 >= n2) {
                if (d2 != Double.POSITIVE_INFINITY) return new Range(d2, d3);
                return null;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                Number number;
                Number number2;
                if (bl3) {
                    IntervalCategoryDataset intervalCategoryDataset = (IntervalCategoryDataset)categoryDataset;
                    number2 = intervalCategoryDataset.getStartValue(n4, i2);
                    number = intervalCategoryDataset.getEndValue(n4, i2);
                } else {
                    number = number2 = categoryDataset.getValue(n4, i2);
                }
                if (number2 != null) {
                    d2 = Math.min(d2, number2.doubleValue());
                }
                if (number == null) continue;
                d3 = Math.max(d3, number.doubleValue());
            }
            ++n4;
        } while (true);
    }

    public static Range iterateXYRangeBounds(XYDataset xYDataset) {
        double d2 = Double.POSITIVE_INFINITY;
        double d3 = Double.NEGATIVE_INFINITY;
        int n2 = xYDataset.getSeriesCount();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                if (d2 != Double.POSITIVE_INFINITY) return new Range(d2, d3);
                return null;
            }
            int n4 = xYDataset.getItemCount(n3);
            for (int i2 = 0; i2 < n4; ++i2) {
                IntervalXYDataset intervalXYDataset;
                double d4;
                double d5;
                if (xYDataset instanceof IntervalXYDataset) {
                    intervalXYDataset = (IntervalXYDataset)xYDataset;
                    d5 = intervalXYDataset.getStartYValue(n3, i2);
                    d4 = intervalXYDataset.getEndYValue(n3, i2);
                } else if (xYDataset instanceof OHLCDataset) {
                    intervalXYDataset = (OHLCDataset)xYDataset;
                    d5 = intervalXYDataset.getLowValue(n3, i2);
                    d4 = intervalXYDataset.getHighValue(n3, i2);
                } else {
                    d4 = d5 = xYDataset.getYValue(n3, i2);
                }
                if (!Double.isNaN(d5)) {
                    d2 = Math.min(d2, d5);
                }
                if (Double.isNaN(d4)) continue;
                d3 = Math.max(d3, d4);
            }
            ++n3;
        } while (true);
    }

    public static Number findMinimumDomainValue(XYDataset xYDataset) {
        if (xYDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        Double d2 = null;
        if (xYDataset instanceof DomainInfo) {
            DomainInfo domainInfo = (DomainInfo)((Object)xYDataset);
            return new Double(domainInfo.getDomainLowerBound(true));
        }
        double d3 = Double.POSITIVE_INFINITY;
        int n2 = xYDataset.getSeriesCount();
        int n3 = 0;
        do {
            int n4;
            if (n3 < n2) {
                n4 = xYDataset.getItemCount(n3);
            } else {
                if (d3 != Double.POSITIVE_INFINITY) return new Double(d3);
                return null;
            }
            for (int i2 = 0; i2 < n4; ++i2) {
                double d4;
                if (xYDataset instanceof IntervalXYDataset) {
                    IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xYDataset;
                    d4 = intervalXYDataset.getStartXValue(n3, i2);
                } else {
                    d4 = xYDataset.getXValue(n3, i2);
                }
                if (Double.isNaN(d4)) continue;
                d3 = Math.min(d3, d4);
            }
            ++n3;
        } while (true);
    }

    public static Number findMaximumDomainValue(XYDataset xYDataset) {
        if (xYDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        Double d2 = null;
        if (xYDataset instanceof DomainInfo) {
            DomainInfo domainInfo = (DomainInfo)((Object)xYDataset);
            return new Double(domainInfo.getDomainUpperBound(true));
        }
        double d3 = Double.NEGATIVE_INFINITY;
        int n2 = xYDataset.getSeriesCount();
        int n3 = 0;
        do {
            int n4;
            if (n3 < n2) {
                n4 = xYDataset.getItemCount(n3);
            } else {
                if (d3 != Double.NEGATIVE_INFINITY) return new Double(d3);
                return null;
            }
            for (int i2 = 0; i2 < n4; ++i2) {
                double d4;
                if (xYDataset instanceof IntervalXYDataset) {
                    IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xYDataset;
                    d4 = intervalXYDataset.getEndXValue(n3, i2);
                } else {
                    d4 = xYDataset.getXValue(n3, i2);
                }
                if (Double.isNaN(d4)) continue;
                d3 = Math.max(d3, d4);
            }
            ++n3;
        } while (true);
    }

    public static Number findMinimumRangeValue(CategoryDataset categoryDataset) {
        if (categoryDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        if (categoryDataset instanceof RangeInfo) {
            RangeInfo rangeInfo = (RangeInfo)((Object)categoryDataset);
            return new Double(rangeInfo.getRangeLowerBound(true));
        }
        double d2 = Double.POSITIVE_INFINITY;
        int n2 = categoryDataset.getRowCount();
        int n3 = categoryDataset.getColumnCount();
        int n4 = 0;
        do {
            if (n4 >= n2) {
                if (d2 != Double.POSITIVE_INFINITY) return new Double(d2);
                return null;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                Number number;
                if (categoryDataset instanceof IntervalCategoryDataset) {
                    IntervalCategoryDataset intervalCategoryDataset = (IntervalCategoryDataset)categoryDataset;
                    number = intervalCategoryDataset.getStartValue(n4, i2);
                } else {
                    number = categoryDataset.getValue(n4, i2);
                }
                if (number == null) continue;
                d2 = Math.min(d2, number.doubleValue());
            }
            ++n4;
        } while (true);
    }

    public static Number findMinimumRangeValue(XYDataset xYDataset) {
        if (xYDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        if (xYDataset instanceof RangeInfo) {
            RangeInfo rangeInfo = (RangeInfo)((Object)xYDataset);
            return new Double(rangeInfo.getRangeLowerBound(true));
        }
        double d2 = Double.POSITIVE_INFINITY;
        int n2 = xYDataset.getSeriesCount();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                if (d2 != Double.POSITIVE_INFINITY) return new Double(d2);
                return null;
            }
            int n4 = xYDataset.getItemCount(n3);
            for (int i2 = 0; i2 < n4; ++i2) {
                double d3;
                if (xYDataset instanceof IntervalXYDataset) {
                    IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xYDataset;
                    d3 = intervalXYDataset.getStartYValue(n3, i2);
                } else if (xYDataset instanceof OHLCDataset) {
                    OHLCDataset oHLCDataset = (OHLCDataset)xYDataset;
                    d3 = oHLCDataset.getLowValue(n3, i2);
                } else {
                    d3 = xYDataset.getYValue(n3, i2);
                }
                if (Double.isNaN(d3)) continue;
                d2 = Math.min(d2, d3);
            }
            ++n3;
        } while (true);
    }

    public static Number findMaximumRangeValue(CategoryDataset categoryDataset) {
        if (categoryDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        if (categoryDataset instanceof RangeInfo) {
            RangeInfo rangeInfo = (RangeInfo)((Object)categoryDataset);
            return new Double(rangeInfo.getRangeUpperBound(true));
        }
        double d2 = Double.NEGATIVE_INFINITY;
        int n2 = categoryDataset.getRowCount();
        int n3 = categoryDataset.getColumnCount();
        int n4 = 0;
        do {
            if (n4 >= n2) {
                if (d2 != Double.NEGATIVE_INFINITY) return new Double(d2);
                return null;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                Number number;
                if (categoryDataset instanceof IntervalCategoryDataset) {
                    IntervalCategoryDataset intervalCategoryDataset = (IntervalCategoryDataset)categoryDataset;
                    number = intervalCategoryDataset.getEndValue(n4, i2);
                } else {
                    number = categoryDataset.getValue(n4, i2);
                }
                if (number == null) continue;
                d2 = Math.max(d2, number.doubleValue());
            }
            ++n4;
        } while (true);
    }

    public static Number findMaximumRangeValue(XYDataset xYDataset) {
        if (xYDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        if (xYDataset instanceof RangeInfo) {
            RangeInfo rangeInfo = (RangeInfo)((Object)xYDataset);
            return new Double(rangeInfo.getRangeUpperBound(true));
        }
        double d2 = Double.NEGATIVE_INFINITY;
        int n2 = xYDataset.getSeriesCount();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                if (d2 != Double.NEGATIVE_INFINITY) return new Double(d2);
                return null;
            }
            int n4 = xYDataset.getItemCount(n3);
            for (int i2 = 0; i2 < n4; ++i2) {
                double d3;
                if (xYDataset instanceof IntervalXYDataset) {
                    IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xYDataset;
                    d3 = intervalXYDataset.getEndYValue(n3, i2);
                } else if (xYDataset instanceof OHLCDataset) {
                    OHLCDataset oHLCDataset = (OHLCDataset)xYDataset;
                    d3 = oHLCDataset.getHighValue(n3, i2);
                } else {
                    d3 = xYDataset.getYValue(n3, i2);
                }
                if (Double.isNaN(d3)) continue;
                d2 = Math.max(d2, d3);
            }
            ++n3;
        } while (true);
    }

    public static Range findStackedRangeBounds(CategoryDataset categoryDataset) {
        return DatasetUtilities.findStackedRangeBounds(categoryDataset, 0.0);
    }

    public static Range findStackedRangeBounds(CategoryDataset categoryDataset, double d2) {
        if (categoryDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        Range range = null;
        double d3 = Double.POSITIVE_INFINITY;
        double d4 = Double.NEGATIVE_INFINITY;
        int n2 = categoryDataset.getColumnCount();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                if (d3 > d4) return range;
                return new Range(d3, d4);
            }
            double d5 = d2;
            double d6 = d2;
            int n4 = categoryDataset.getRowCount();
            for (int i2 = 0; i2 < n4; ++i2) {
                Number number = categoryDataset.getValue(i2, n3);
                if (number == null) continue;
                double d7 = number.doubleValue();
                if (d7 > 0.0) {
                    d5 += d7;
                }
                if (d7 >= 0.0) continue;
                d6 += d7;
            }
            d3 = Math.min(d3, d6);
            d4 = Math.max(d4, d5);
            ++n3;
        } while (true);
    }

    public static Range findStackedRangeBounds(CategoryDataset categoryDataset, KeyToGroupMap keyToGroupMap) {
        int n2;
        int n3;
        Range range = null;
        if (categoryDataset == null) return range;
        int[] arrn = new int[categoryDataset.getRowCount()];
        for (n3 = 0; n3 < categoryDataset.getRowCount(); ++n3) {
            arrn[n3] = keyToGroupMap.getGroupIndex(keyToGroupMap.getGroup(categoryDataset.getRowKey(n3)));
        }
        n3 = keyToGroupMap.getGroupCount();
        double[] arrd = new double[n3];
        double[] arrd2 = new double[n3];
        int n4 = categoryDataset.getColumnCount();
        for (n2 = 0; n2 < n4; ++n2) {
            int n5;
            double[] arrd3 = new double[n3];
            double[] arrd4 = new double[n3];
            int n6 = categoryDataset.getRowCount();
            for (n5 = 0; n5 < n6; ++n5) {
                Number number = categoryDataset.getValue(n5, n2);
                if (number == null) continue;
                double d2 = number.doubleValue();
                if (d2 > 0.0) {
                    arrd3[arrn[n5]] = arrd3[arrn[n5]] + d2;
                }
                if (d2 >= 0.0) continue;
                arrd4[arrn[n5]] = arrd4[arrn[n5]] + d2;
            }
            for (n5 = 0; n5 < n3; ++n5) {
                arrd[n5] = Math.min(arrd[n5], arrd4[n5]);
                arrd2[n5] = Math.max(arrd2[n5], arrd3[n5]);
            }
        }
        n2 = 0;
        while (n2 < n3) {
            range = Range.combine(range, new Range(arrd[n2], arrd2[n2]));
            ++n2;
        }
        return range;
    }

    public static Number findMinimumStackedRangeValue(CategoryDataset categoryDataset) {
        Double d2 = null;
        if (categoryDataset == null) return d2;
        double d3 = 0.0;
        int n2 = categoryDataset.getRowCount();
        int n3 = 0;
        while (n3 < n2) {
            double d4 = 0.0;
            int n4 = categoryDataset.getColumnCount();
            for (int i2 = 0; i2 < n4; ++i2) {
                double d5;
                Number number = categoryDataset.getValue(i2, n3);
                if (number == null || (d5 = number.doubleValue()) >= 0.0) continue;
                d4 += d5;
            }
            d3 = Math.min(d3, d4);
            ++n3;
        }
        return new Double(d3);
    }

    public static Number findMaximumStackedRangeValue(CategoryDataset categoryDataset) {
        Double d2 = null;
        if (categoryDataset == null) return d2;
        double d3 = 0.0;
        int n2 = categoryDataset.getColumnCount();
        int n3 = 0;
        while (n3 < n2) {
            double d4 = 0.0;
            int n4 = categoryDataset.getRowCount();
            for (int i2 = 0; i2 < n4; ++i2) {
                double d5;
                Number number = categoryDataset.getValue(i2, n3);
                if (number == null || (d5 = number.doubleValue()) <= 0.0) continue;
                d4 += d5;
            }
            d3 = Math.max(d3, d4);
            ++n3;
        }
        return new Double(d3);
    }

    public static Range findStackedRangeBounds(TableXYDataset tableXYDataset) {
        return DatasetUtilities.findStackedRangeBounds(tableXYDataset, 0.0);
    }

    public static Range findStackedRangeBounds(TableXYDataset tableXYDataset, double d2) {
        if (tableXYDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        double d3 = d2;
        double d4 = d2;
        int n2 = 0;
        do {
            if (n2 >= tableXYDataset.getItemCount()) {
                if (d3 > d4) return null;
                return new Range(d3, d4);
            }
            double d5 = d2;
            double d6 = d2;
            int n3 = tableXYDataset.getSeriesCount();
            for (int i2 = 0; i2 < n3; ++i2) {
                double d7 = tableXYDataset.getYValue(i2, n2);
                if (Double.isNaN(d7)) continue;
                if (d7 > 0.0) {
                    d5 += d7;
                    continue;
                }
                d6 += d7;
            }
            if (d5 > d4) {
                d4 = d5;
            }
            if (d6 < d3) {
                d3 = d6;
            }
            ++n2;
        } while (true);
    }

    public static double calculateStackTotal(TableXYDataset tableXYDataset, int n2) {
        double d2 = 0.0;
        int n3 = tableXYDataset.getSeriesCount();
        int n4 = 0;
        while (n4 < n3) {
            double d3 = tableXYDataset.getYValue(n4, n2);
            if (!Double.isNaN(d3)) {
                d2 += d3;
            }
            ++n4;
        }
        return d2;
    }

    public static Range findCumulativeRangeBounds(CategoryDataset categoryDataset) {
        if (categoryDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        boolean bl2 = true;
        double d2 = 0.0;
        double d3 = 0.0;
        int n2 = 0;
        while (n2 < categoryDataset.getRowCount()) {
            double d4 = 0.0;
            for (int i2 = 0; i2 < categoryDataset.getColumnCount() - 1; ++i2) {
                Number number = categoryDataset.getValue(n2, i2);
                if (number == null) continue;
                bl2 = false;
                double d5 = number.doubleValue();
                d2 = Math.min(d2, d4 += d5);
                d3 = Math.max(d3, d4);
            }
            ++n2;
        }
        return null;
    }
}

