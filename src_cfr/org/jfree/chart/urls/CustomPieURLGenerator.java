/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.urls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.data.general.PieDataset;
import org.jfree.util.PublicCloneable;

public class CustomPieURLGenerator
implements Serializable,
Cloneable,
PieURLGenerator,
PublicCloneable {
    private static final long serialVersionUID = 7100607670144900503L;
    private ArrayList urls = new ArrayList();

    @Override
    public String generateURL(PieDataset pieDataset, Comparable comparable, int n2) {
        return this.getURL(comparable, n2);
    }

    public int getListCount() {
        return this.urls.size();
    }

    public int getURLCount(int n2) {
        int n3 = 0;
        Map map = (Map)this.urls.get(n2);
        if (map == null) return n3;
        return map.size();
    }

    public String getURL(Comparable comparable, int n2) {
        String string = null;
        if (n2 >= this.getListCount()) return string;
        Map map = (Map)this.urls.get(n2);
        if (map == null) return string;
        return (String)map.get(comparable);
    }

    public void addURLs(Map map) {
        this.urls.add(map);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CustomPieURLGenerator)) return false;
        CustomPieURLGenerator customPieURLGenerator = (CustomPieURLGenerator)object;
        if (this.getListCount() != customPieURLGenerator.getListCount()) {
            return false;
        }
        int n2 = 0;
        while (n2 < this.getListCount()) {
            if (this.getURLCount(n2) != customPieURLGenerator.getURLCount(n2)) {
                return false;
            }
            Set set = ((HashMap)this.urls.get(n2)).keySet();
            for (String string : set) {
                if (this.getURL((Comparable)((Object)string), n2).equals(customPieURLGenerator.getURL((Comparable)((Object)string), n2))) continue;
                return false;
            }
            ++n2;
        }
        return true;
    }

    @Override
    public Object clone() {
        CustomPieURLGenerator customPieURLGenerator = new CustomPieURLGenerator();
        Iterator iterator = this.urls.iterator();
        while (iterator.hasNext()) {
            Map map = (Map)iterator.next();
            HashMap hashMap = new HashMap();
            for (String string : map.keySet()) {
                hashMap.put(string, map.get(string));
            }
            customPieURLGenerator.addURLs(hashMap);
            hashMap = null;
        }
        return customPieURLGenerator;
    }
}

