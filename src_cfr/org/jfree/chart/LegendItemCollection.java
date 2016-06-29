/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.LegendItem;

public class LegendItemCollection
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 1365215565589815953L;
    private List items = new ArrayList();

    public void add(LegendItem legendItem) {
        this.items.add(legendItem);
    }

    public void addAll(LegendItemCollection legendItemCollection) {
        this.items.addAll(legendItemCollection.items);
    }

    public LegendItem get(int n2) {
        return (LegendItem)this.items.get(n2);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public Iterator iterator() {
        return this.items.iterator();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LegendItemCollection)) {
            return false;
        }
        LegendItemCollection legendItemCollection = (LegendItemCollection)object;
        if (this.items.equals(legendItemCollection.items)) return true;
        return false;
    }

    public Object clone() {
        return super.clone();
    }
}

