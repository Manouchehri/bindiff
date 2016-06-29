package org.jfree.data.xy;

import java.io.*;

class WindDataItem implements Serializable, Comparable
{
    private Number x;
    private Number windDir;
    private Number windForce;
    
    public WindDataItem(final Number x, final Number windDir, final Number windForce) {
        this.x = x;
        this.windDir = windDir;
        this.windForce = windForce;
    }
    
    public Number getX() {
        return this.x;
    }
    
    public Number getWindDirection() {
        return this.windDir;
    }
    
    public Number getWindForce() {
        return this.windForce;
    }
    
    public int compareTo(final Object o) {
        if (!(o instanceof WindDataItem)) {
            throw new ClassCastException("WindDataItem.compareTo(error)");
        }
        final WindDataItem windDataItem = (WindDataItem)o;
        if (this.x.doubleValue() > windDataItem.x.doubleValue()) {
            return 1;
        }
        if (this.x.equals(windDataItem.x)) {
            return 0;
        }
        return -1;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return false;
        }
        if (!(o instanceof WindDataItem)) {
            return false;
        }
        final WindDataItem windDataItem = (WindDataItem)o;
        return this.x.equals(windDataItem.x) && this.windDir.equals(windDataItem.windDir) && this.windForce.equals(windDataItem.windForce);
    }
}
