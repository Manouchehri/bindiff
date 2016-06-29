/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.WindDataItem;
import org.jfree.data.xy.WindDataset;

public class DefaultWindDataset
extends AbstractXYDataset
implements WindDataset {
    private List seriesKeys;
    private List allSeriesData;

    public DefaultWindDataset() {
        this.seriesKeys = new ArrayList();
        this.allSeriesData = new ArrayList();
    }

    public DefaultWindDataset(Object[][][] arrobject) {
        this(DefaultWindDataset.seriesNameListFromDataArray((Object[][])arrobject), arrobject);
    }

    public DefaultWindDataset(String[] arrstring, Object[][][] arrobject) {
        this(Arrays.asList(arrstring), arrobject);
    }

    public DefaultWindDataset(List list, Object[][][] arrobject) {
        if (list == null) {
            throw new IllegalArgumentException("Null 'seriesKeys' argument.");
        }
        if (list.size() != arrobject.length) {
            throw new IllegalArgumentException("The number of series keys does not match the number of series in the data array.");
        }
        this.seriesKeys = list;
        int n2 = arrobject.length;
        this.allSeriesData = new ArrayList(n2);
        int n3 = 0;
        while (n3 < n2) {
            ArrayList<WindDataItem> arrayList = new ArrayList<WindDataItem>();
            int n4 = arrobject[n3].length;
            for (int i2 = 0; i2 < n4; ++i2) {
                Number number;
                Object object = arrobject[n3][i2][0];
                if (object == null) continue;
                if (object instanceof Number) {
                    number = (Number)object;
                } else if (object instanceof Date) {
                    Date date = (Date)object;
                    number = new Long(date.getTime());
                } else {
                    number = new Integer(0);
                }
                Number date = (Number)arrobject[n3][i2][1];
                Number number2 = (Number)arrobject[n3][i2][2];
                arrayList.add(new WindDataItem(number, date, number2));
            }
            Collections.sort(arrayList);
            this.allSeriesData.add(n3, arrayList);
            ++n3;
        }
    }

    @Override
    public int getSeriesCount() {
        return this.allSeriesData.size();
    }

    @Override
    public int getItemCount(int n2) {
        if (n2 < 0) throw new IllegalArgumentException(new StringBuffer().append("Invalid series index: ").append(n2).toString());
        if (n2 >= this.getSeriesCount()) {
            throw new IllegalArgumentException(new StringBuffer().append("Invalid series index: ").append(n2).toString());
        }
        List list = (List)this.allSeriesData.get(n2);
        return list.size();
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        if (n2 < 0) throw new IllegalArgumentException(new StringBuffer().append("Invalid series index: ").append(n2).toString());
        if (n2 < this.getSeriesCount()) return (Comparable)this.seriesKeys.get(n2);
        throw new IllegalArgumentException(new StringBuffer().append("Invalid series index: ").append(n2).toString());
    }

    @Override
    public Number getX(int n2, int n3) {
        List list = (List)this.allSeriesData.get(n2);
        WindDataItem windDataItem = (WindDataItem)list.get(n3);
        return windDataItem.getX();
    }

    @Override
    public Number getY(int n2, int n3) {
        return this.getWindForce(n2, n3);
    }

    @Override
    public Number getWindDirection(int n2, int n3) {
        List list = (List)this.allSeriesData.get(n2);
        WindDataItem windDataItem = (WindDataItem)list.get(n3);
        return windDataItem.getWindDirection();
    }

    @Override
    public Number getWindForce(int n2, int n3) {
        List list = (List)this.allSeriesData.get(n2);
        WindDataItem windDataItem = (WindDataItem)list.get(n3);
        return windDataItem.getWindForce();
    }

    public static List seriesNameListFromDataArray(Object[][] arrobject) {
        int n2 = arrobject.length;
        ArrayList<String> arrayList = new ArrayList<String>(n2);
        int n3 = 0;
        while (n3 < n2) {
            arrayList.add(new StringBuffer().append("Series ").append(n3 + 1).toString());
            ++n3;
        }
        return arrayList;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DefaultWindDataset)) {
            return false;
        }
        DefaultWindDataset defaultWindDataset = (DefaultWindDataset)object;
        if (!this.seriesKeys.equals(defaultWindDataset.seriesKeys)) {
            return false;
        }
        if (this.allSeriesData.equals(defaultWindDataset.allSeriesData)) return true;
        return false;
    }
}

