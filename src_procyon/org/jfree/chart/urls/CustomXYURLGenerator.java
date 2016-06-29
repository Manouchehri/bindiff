package org.jfree.chart.urls;

import java.io.*;
import java.util.*;
import org.jfree.data.xy.*;

public class CustomXYURLGenerator implements Serializable, XYURLGenerator
{
    private static final long serialVersionUID = -8565933356596551832L;
    private ArrayList urlSeries;
    
    public CustomXYURLGenerator() {
        this.urlSeries = new ArrayList();
    }
    
    public int getListCount() {
        return this.urlSeries.size();
    }
    
    public int getURLCount(final int n) {
        int size = 0;
        final List list = this.urlSeries.get(n);
        if (list != null) {
            size = list.size();
        }
        return size;
    }
    
    public String getURL(final int n, final int n2) {
        String s = null;
        if (n < this.getListCount()) {
            final List<String> list = this.urlSeries.get(n);
            if (list != null && n2 < list.size()) {
                s = list.get(n2);
            }
        }
        return s;
    }
    
    public String generateURL(final XYDataset xyDataset, final int n, final int n2) {
        return this.getURL(n, n2);
    }
    
    public void addURLSeries(final List list) {
        this.urlSeries.add(list);
    }
    
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof CustomXYURLGenerator)) {
            return false;
        }
        final CustomXYURLGenerator customXYURLGenerator = (CustomXYURLGenerator)o;
        final int listCount = this.getListCount();
        if (listCount != customXYURLGenerator.getListCount()) {
            return false;
        }
        for (int i = 0; i < listCount; ++i) {
            final int urlCount = this.getURLCount(i);
            if (urlCount != customXYURLGenerator.getURLCount(i)) {
                return false;
            }
            for (int j = 0; j < urlCount; ++j) {
                final String url = this.getURL(i, j);
                final String url2 = customXYURLGenerator.getURL(i, j);
                if (url != null) {
                    if (!url.equals(url2)) {
                        return false;
                    }
                }
                else if (url2 != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
