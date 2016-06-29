/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.urls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;

public class CustomXYURLGenerator
implements Serializable,
XYURLGenerator {
    private static final long serialVersionUID = -8565933356596551832L;
    private ArrayList urlSeries = new ArrayList();

    public int getListCount() {
        return this.urlSeries.size();
    }

    public int getURLCount(int n2) {
        int n3 = 0;
        List list = (List)this.urlSeries.get(n2);
        if (list == null) return n3;
        return list.size();
    }

    public String getURL(int n2, int n3) {
        String string = null;
        if (n2 >= this.getListCount()) return string;
        List list = (List)this.urlSeries.get(n2);
        if (list == null) return string;
        if (n3 >= list.size()) return string;
        return (String)list.get(n3);
    }

    @Override
    public String generateURL(XYDataset xYDataset, int n2, int n3) {
        return this.getURL(n2, n3);
    }

    public void addURLSeries(List list) {
        this.urlSeries.add(list);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof CustomXYURLGenerator)) {
            return false;
        }
        CustomXYURLGenerator customXYURLGenerator = (CustomXYURLGenerator)object;
        int n2 = this.getListCount();
        if (n2 != customXYURLGenerator.getListCount()) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            int n4 = this.getURLCount(n3);
            if (n4 != customXYURLGenerator.getURLCount(n3)) {
                return false;
            }
            for (int i2 = 0; i2 < n4; ++i2) {
                String string = this.getURL(n3, i2);
                String string2 = customXYURLGenerator.getURL(n3, i2);
                if (!(string != null ? !string.equals(string2) : string2 != null)) continue;
                return false;
            }
            ++n3;
        }
        return true;
    }
}

