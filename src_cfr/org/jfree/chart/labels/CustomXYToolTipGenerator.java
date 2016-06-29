/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class CustomXYToolTipGenerator
implements Serializable,
Cloneable,
XYToolTipGenerator,
PublicCloneable {
    private static final long serialVersionUID = 8636030004670141362L;
    private List toolTipSeries = new ArrayList();

    public int getListCount() {
        return this.toolTipSeries.size();
    }

    public int getToolTipCount(int n2) {
        int n3 = 0;
        List list = (List)this.toolTipSeries.get(n2);
        if (list == null) return n3;
        return list.size();
    }

    public String getToolTipText(int n2, int n3) {
        String string = null;
        if (n2 >= this.getListCount()) return string;
        List list = (List)this.toolTipSeries.get(n2);
        if (list == null) return string;
        if (n3 >= list.size()) return string;
        return (String)list.get(n3);
    }

    public void addToolTipSeries(List list) {
        this.toolTipSeries.add(list);
    }

    @Override
    public String generateToolTip(XYDataset xYDataset, int n2, int n3) {
        return this.getToolTipText(n2, n3);
    }

    @Override
    public Object clone() {
        CustomXYToolTipGenerator customXYToolTipGenerator = (CustomXYToolTipGenerator)super.clone();
        if (this.toolTipSeries == null) return customXYToolTipGenerator;
        customXYToolTipGenerator.toolTipSeries = new ArrayList(this.toolTipSeries);
        return customXYToolTipGenerator;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CustomXYToolTipGenerator)) return false;
        CustomXYToolTipGenerator customXYToolTipGenerator = (CustomXYToolTipGenerator)object;
        boolean bl2 = true;
        int n2 = 0;
        while (n2 < this.getListCount()) {
            for (int i2 = 0; i2 < this.getToolTipCount(n2); ++i2) {
                String string = this.getToolTipText(n2, i2);
                String string2 = customXYToolTipGenerator.getToolTipText(n2, i2);
                bl2 = string != null ? bl2 && string.equals(string2) : bl2 && string2 == null;
            }
            ++n2;
        }
        return bl2;
    }
}

