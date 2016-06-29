package org.jfree.chart.urls;

import java.io.*;
import org.jfree.util.*;
import org.jfree.data.general.*;
import java.util.*;

public class CustomPieURLGenerator implements Serializable, Cloneable, PieURLGenerator, PublicCloneable
{
    private static final long serialVersionUID = 7100607670144900503L;
    private ArrayList urls;
    
    public CustomPieURLGenerator() {
        this.urls = new ArrayList();
    }
    
    public String generateURL(final PieDataset pieDataset, final Comparable comparable, final int n) {
        return this.getURL(comparable, n);
    }
    
    public int getListCount() {
        return this.urls.size();
    }
    
    public int getURLCount(final int n) {
        int size = 0;
        final Map map = this.urls.get(n);
        if (map != null) {
            size = map.size();
        }
        return size;
    }
    
    public String getURL(final Comparable comparable, final int n) {
        String s = null;
        if (n < this.getListCount()) {
            final Map<K, String> map = this.urls.get(n);
            if (map != null) {
                s = map.get(comparable);
            }
        }
        return s;
    }
    
    public void addURLs(final Map map) {
        this.urls.add(map);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CustomPieURLGenerator)) {
            return false;
        }
        final CustomPieURLGenerator customPieURLGenerator = (CustomPieURLGenerator)o;
        if (this.getListCount() != customPieURLGenerator.getListCount()) {
            return false;
        }
        for (int i = 0; i < this.getListCount(); ++i) {
            if (this.getURLCount(i) != customPieURLGenerator.getURLCount(i)) {
                return false;
            }
            for (final String s : this.urls.get(i).keySet()) {
                if (!this.getURL(s, i).equals(customPieURLGenerator.getURL(s, i))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public Object clone() {
        final CustomPieURLGenerator customPieURLGenerator = new CustomPieURLGenerator();
        for (final Map<String, V> map : this.urls) {
            final HashMap<String, Object> hashMap = new HashMap<String, Object>();
            for (final String s : map.keySet()) {
                hashMap.put(s, map.get(s));
            }
            customPieURLGenerator.addURLs(hashMap);
        }
        return customPieURLGenerator;
    }
}
