/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class MovingAverage {
    public static TimeSeriesCollection createMovingAverage(TimeSeriesCollection timeSeriesCollection, String string, int n2, int n3) {
        if (timeSeriesCollection == null) {
            throw new IllegalArgumentException("MovingAverage.createMovingAverage() : null source.");
        }
        if (n2 < 1) {
            throw new IllegalArgumentException("periodCount must be greater than or equal to 1.");
        }
        TimeSeriesCollection timeSeriesCollection2 = new TimeSeriesCollection();
        int n4 = 0;
        while (n4 < timeSeriesCollection.getSeriesCount()) {
            TimeSeries timeSeries = timeSeriesCollection.getSeries(n4);
            TimeSeries timeSeries2 = MovingAverage.createMovingAverage(timeSeries, new StringBuffer().append(timeSeries.getKey()).append(string).toString(), n2, n3);
            timeSeriesCollection2.addSeries(timeSeries2);
            ++n4;
        }
        return timeSeriesCollection2;
    }

    public static TimeSeries createMovingAverage(TimeSeries timeSeries, String string, int n2, int n3) {
        if (timeSeries == null) {
            throw new IllegalArgumentException("Null source.");
        }
        if (n2 < 1) {
            throw new IllegalArgumentException("periodCount must be greater than or equal to 1.");
        }
        TimeSeries timeSeries2 = new TimeSeries(string, timeSeries.getTimePeriodClass());
        if (timeSeries.getItemCount() <= 0) return timeSeries2;
        long l2 = timeSeries.getDataItem(0).getPeriod().getSerialIndex() + (long)n3;
        int n4 = timeSeries.getItemCount() - 1;
        while (n4 >= 0) {
            TimeSeriesDataItem timeSeriesDataItem = timeSeries.getDataItem(n4);
            RegularTimePeriod regularTimePeriod = timeSeriesDataItem.getPeriod();
            long l3 = regularTimePeriod.getSerialIndex();
            if (l3 >= l2) {
                int n5 = 0;
                double d2 = 0.0;
                long l4 = regularTimePeriod.getSerialIndex() - (long)n2;
                boolean bl2 = false;
                for (int i2 = 0; i2 < n2 && !bl2; ++i2) {
                    if (n4 - i2 < 0) continue;
                    TimeSeriesDataItem timeSeriesDataItem2 = timeSeries.getDataItem(n4 - i2);
                    RegularTimePeriod regularTimePeriod2 = timeSeriesDataItem2.getPeriod();
                    Number number = timeSeriesDataItem2.getValue();
                    long l5 = regularTimePeriod2.getSerialIndex();
                    if (l5 > l4) {
                        if (number == null) continue;
                        d2 += number.doubleValue();
                        ++n5;
                        continue;
                    }
                    bl2 = true;
                }
                if (n5 > 0) {
                    timeSeries2.add(regularTimePeriod, d2 / (double)n5);
                } else {
                    timeSeries2.add(regularTimePeriod, null);
                }
            }
            --n4;
        }
        return timeSeries2;
    }

    public static TimeSeries createPointMovingAverage(TimeSeries timeSeries, String string, int n2) {
        if (timeSeries == null) {
            throw new IllegalArgumentException("Null 'source'.");
        }
        if (n2 < 2) {
            throw new IllegalArgumentException("periodCount must be greater than or equal to 2.");
        }
        TimeSeries timeSeries2 = new TimeSeries(string, timeSeries.getTimePeriodClass());
        double d2 = 0.0;
        int n3 = 0;
        while (n3 < timeSeries.getItemCount()) {
            TimeSeriesDataItem timeSeriesDataItem = timeSeries.getDataItem(n3);
            RegularTimePeriod regularTimePeriod = timeSeriesDataItem.getPeriod();
            d2 += timeSeriesDataItem.getValue().doubleValue();
            if (n3 > n2 - 1) {
                TimeSeriesDataItem timeSeriesDataItem2 = timeSeries.getDataItem(n3 - n2);
                timeSeries2.add(regularTimePeriod, (d2 -= timeSeriesDataItem2.getValue().doubleValue()) / (double)n2);
            } else if (n3 == n2 - 1) {
                timeSeries2.add(regularTimePeriod, d2 / (double)n2);
            }
            ++n3;
        }
        return timeSeries2;
    }

    public static XYDataset createMovingAverage(XYDataset xYDataset, String string, long l2, long l3) {
        return MovingAverage.createMovingAverage(xYDataset, string, (double)l2, (double)l3);
    }

    public static XYDataset createMovingAverage(XYDataset xYDataset, String string, double d2, double d3) {
        if (xYDataset == null) {
            throw new IllegalArgumentException("Null source (XYDataset).");
        }
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        int n2 = 0;
        while (n2 < xYDataset.getSeriesCount()) {
            XYSeries xYSeries = MovingAverage.createMovingAverage(xYDataset, n2, new StringBuffer().append(xYDataset.getSeriesKey(n2)).append(string).toString(), d2, d3);
            xYSeriesCollection.addSeries(xYSeries);
            ++n2;
        }
        return xYSeriesCollection;
    }

    public static XYSeries createMovingAverage(XYDataset xYDataset, int n2, String string, double d2, double d3) {
        if (xYDataset == null) {
            throw new IllegalArgumentException("Null source (XYDataset).");
        }
        if (d2 < Double.MIN_VALUE) {
            throw new IllegalArgumentException("period must be positive.");
        }
        if (d3 < 0.0) {
            throw new IllegalArgumentException("skip must be >= 0.0.");
        }
        XYSeries xYSeries = new XYSeries((Comparable)((Object)string));
        if (xYDataset.getItemCount(n2) <= 0) return xYSeries;
        double d4 = xYDataset.getXValue(n2, 0) + d3;
        int n3 = xYDataset.getItemCount(n2) - 1;
        while (n3 >= 0) {
            double d5 = xYDataset.getXValue(n2, n3);
            if (d5 >= d4) {
                int n4 = 0;
                double d6 = 0.0;
                double d7 = d5 - d2;
                int n5 = 0;
                boolean bl2 = false;
                while (!bl2) {
                    if (n3 - n5 >= 0) {
                        double d8 = xYDataset.getXValue(n2, n3 - n5);
                        Number number = xYDataset.getY(n2, n3 - n5);
                        if (d8 > d7) {
                            if (number != null) {
                                d6 += number.doubleValue();
                                ++n4;
                            }
                        } else {
                            bl2 = true;
                        }
                    } else {
                        bl2 = true;
                    }
                    ++n5;
                }
                if (n4 > 0) {
                    xYSeries.add(d5, d6 / (double)n4);
                } else {
                    xYSeries.add(d5, (Number)null);
                }
            }
            --n3;
        }
        return xYSeries;
    }
}

