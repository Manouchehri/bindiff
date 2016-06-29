package org.jfree.data.xy;

import java.util.*;

public class DefaultWindDataset extends AbstractXYDataset implements WindDataset
{
    private List seriesKeys;
    private List allSeriesData;
    
    public DefaultWindDataset() {
        this.seriesKeys = new ArrayList();
        this.allSeriesData = new ArrayList();
    }
    
    public DefaultWindDataset(final Object[][][] array) {
        this(seriesNameListFromDataArray(array), array);
    }
    
    public DefaultWindDataset(final String[] array, final Object[][][] array2) {
        this(Arrays.asList(array), array2);
    }
    
    public DefaultWindDataset(final List seriesKeys, final Object[][][] array) {
        if (seriesKeys == null) {
            throw new IllegalArgumentException("Null 'seriesKeys' argument.");
        }
        if (seriesKeys.size() != array.length) {
            throw new IllegalArgumentException("The number of series keys does not match the number of series in the data array.");
        }
        this.seriesKeys = seriesKeys;
        final int length = array.length;
        this.allSeriesData = new ArrayList(length);
        for (int i = 0; i < length; ++i) {
            final ArrayList<WindDataItem> list = new ArrayList<WindDataItem>();
            for (int length2 = array[i].length, j = 0; j < length2; ++j) {
                final Object o = array[i][j][0];
                if (o != null) {
                    Number n;
                    if (o instanceof Number) {
                        n = (Number)o;
                    }
                    else if (o instanceof Date) {
                        n = new Long(((Date)o).getTime());
                    }
                    else {
                        n = new Integer(0);
                    }
                    list.add(new WindDataItem(n, (Number)array[i][j][1], (Number)array[i][j][2]));
                }
            }
            Collections.sort((List<Comparable>)list);
            this.allSeriesData.add(i, list);
        }
    }
    
    public int getSeriesCount() {
        return this.allSeriesData.size();
    }
    
    public int getItemCount(final int n) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("Invalid series index: " + n);
        }
        return this.allSeriesData.get(n).size();
    }
    
    public Comparable getSeriesKey(final int n) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("Invalid series index: " + n);
        }
        return this.seriesKeys.get(n);
    }
    
    public Number getX(final int n, final int n2) {
        return this.allSeriesData.get(n).get(n2).getX();
    }
    
    public Number getY(final int n, final int n2) {
        return this.getWindForce(n, n2);
    }
    
    public Number getWindDirection(final int n, final int n2) {
        return this.allSeriesData.get(n).get(n2).getWindDirection();
    }
    
    public Number getWindForce(final int n, final int n2) {
        return this.allSeriesData.get(n).get(n2).getWindForce();
    }
    
    public static List seriesNameListFromDataArray(final Object[][] array) {
        final int length = array.length;
        final ArrayList list = new ArrayList<String>(length);
        for (int i = 0; i < length; ++i) {
            list.add("Series " + (i + 1));
        }
        return list;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DefaultWindDataset)) {
            return false;
        }
        final DefaultWindDataset defaultWindDataset = (DefaultWindDataset)o;
        return this.seriesKeys.equals(defaultWindDataset.seriesKeys) && this.allSeriesData.equals(defaultWindDataset.allSeriesData);
    }
}
