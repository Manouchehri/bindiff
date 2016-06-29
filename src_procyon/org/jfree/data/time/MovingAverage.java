package org.jfree.data.time;

import org.jfree.data.xy.*;

public class MovingAverage
{
    public static TimeSeriesCollection createMovingAverage(final TimeSeriesCollection collection, final String s, final int n, final int n2) {
        if (collection == null) {
            throw new IllegalArgumentException("MovingAverage.createMovingAverage() : null source.");
        }
        if (n < 1) {
            throw new IllegalArgumentException("periodCount must be greater than or equal to 1.");
        }
        final TimeSeriesCollection collection2 = new TimeSeriesCollection();
        for (int i = 0; i < collection.getSeriesCount(); ++i) {
            final TimeSeries series = collection.getSeries(i);
            collection2.addSeries(createMovingAverage(series, series.getKey() + s, n, n2));
        }
        return collection2;
    }
    
    public static TimeSeries createMovingAverage(final TimeSeries timeSeries, final String s, final int n, final int n2) {
        if (timeSeries == null) {
            throw new IllegalArgumentException("Null source.");
        }
        if (n < 1) {
            throw new IllegalArgumentException("periodCount must be greater than or equal to 1.");
        }
        final TimeSeries timeSeries2 = new TimeSeries(s, timeSeries.getTimePeriodClass());
        if (timeSeries.getItemCount() > 0) {
            final long n3 = timeSeries.getDataItem(0).getPeriod().getSerialIndex() + n2;
            for (int i = timeSeries.getItemCount() - 1; i >= 0; --i) {
                final RegularTimePeriod period = timeSeries.getDataItem(i).getPeriod();
                if (period.getSerialIndex() >= n3) {
                    int n4 = 0;
                    double n5 = 0.0;
                    final long n6 = period.getSerialIndex() - n;
                    for (int n7 = 0, n8 = 0; n7 < n && n8 == 0; ++n7) {
                        if (i - n7 >= 0) {
                            final TimeSeriesDataItem dataItem = timeSeries.getDataItem(i - n7);
                            final RegularTimePeriod period2 = dataItem.getPeriod();
                            final Number value = dataItem.getValue();
                            if (period2.getSerialIndex() > n6) {
                                if (value != null) {
                                    n5 += value.doubleValue();
                                    ++n4;
                                }
                            }
                            else {
                                n8 = 1;
                            }
                        }
                    }
                    if (n4 > 0) {
                        timeSeries2.add(period, n5 / n4);
                    }
                    else {
                        timeSeries2.add(period, null);
                    }
                }
            }
        }
        return timeSeries2;
    }
    
    public static TimeSeries createPointMovingAverage(final TimeSeries timeSeries, final String s, final int n) {
        if (timeSeries == null) {
            throw new IllegalArgumentException("Null 'source'.");
        }
        if (n < 2) {
            throw new IllegalArgumentException("periodCount must be greater than or equal to 2.");
        }
        final TimeSeries timeSeries2 = new TimeSeries(s, timeSeries.getTimePeriodClass());
        double n2 = 0.0;
        for (int i = 0; i < timeSeries.getItemCount(); ++i) {
            final TimeSeriesDataItem dataItem = timeSeries.getDataItem(i);
            final RegularTimePeriod period = dataItem.getPeriod();
            n2 += dataItem.getValue().doubleValue();
            if (i > n - 1) {
                n2 -= timeSeries.getDataItem(i - n).getValue().doubleValue();
                timeSeries2.add(period, n2 / n);
            }
            else if (i == n - 1) {
                timeSeries2.add(period, n2 / n);
            }
        }
        return timeSeries2;
    }
    
    public static XYDataset createMovingAverage(final XYDataset xyDataset, final String s, final long n, final long n2) {
        return createMovingAverage(xyDataset, s, n, (double)n2);
    }
    
    public static XYDataset createMovingAverage(final XYDataset xyDataset, final String s, final double n, final double n2) {
        if (xyDataset == null) {
            throw new IllegalArgumentException("Null source (XYDataset).");
        }
        final XYSeriesCollection collection = new XYSeriesCollection();
        for (int i = 0; i < xyDataset.getSeriesCount(); ++i) {
            collection.addSeries(createMovingAverage(xyDataset, i, xyDataset.getSeriesKey(i) + s, n, n2));
        }
        return collection;
    }
    
    public static XYSeries createMovingAverage(final XYDataset xyDataset, final int n, final String s, final double n2, final double n3) {
        if (xyDataset == null) {
            throw new IllegalArgumentException("Null source (XYDataset).");
        }
        if (n2 < Double.MIN_VALUE) {
            throw new IllegalArgumentException("period must be positive.");
        }
        if (n3 < 0.0) {
            throw new IllegalArgumentException("skip must be >= 0.0.");
        }
        final XYSeries xySeries = new XYSeries(s);
        if (xyDataset.getItemCount(n) > 0) {
            final double n4 = xyDataset.getXValue(n, 0) + n3;
            for (int i = xyDataset.getItemCount(n) - 1; i >= 0; --i) {
                final double xValue = xyDataset.getXValue(n, i);
                if (xValue >= n4) {
                    int n5 = 0;
                    double n6 = 0.0;
                    final double n7 = xValue - n2;
                    int n8 = 0;
                    int j = 0;
                    while (j == 0) {
                        if (i - n8 >= 0) {
                            final double xValue2 = xyDataset.getXValue(n, i - n8);
                            final Number y = xyDataset.getY(n, i - n8);
                            if (xValue2 > n7) {
                                if (y != null) {
                                    n6 += y.doubleValue();
                                    ++n5;
                                }
                            }
                            else {
                                j = 1;
                            }
                        }
                        else {
                            j = 1;
                        }
                        ++n8;
                    }
                    if (n5 > 0) {
                        xySeries.add(xValue, n6 / n5);
                    }
                    else {
                        xySeries.add(xValue, null);
                    }
                }
            }
        }
        return xySeries;
    }
}
