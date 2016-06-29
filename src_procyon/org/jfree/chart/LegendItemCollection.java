package org.jfree.chart;

import java.io.*;
import java.util.*;

public class LegendItemCollection implements Serializable, Cloneable
{
    private static final long serialVersionUID = 1365215565589815953L;
    private List items;
    
    public LegendItemCollection() {
        this.items = new ArrayList();
    }
    
    public void add(final LegendItem legendItem) {
        this.items.add(legendItem);
    }
    
    public void addAll(final LegendItemCollection collection) {
        this.items.addAll(collection.items);
    }
    
    public LegendItem get(final int n) {
        return this.items.get(n);
    }
    
    public int getItemCount() {
        return this.items.size();
    }
    
    public Iterator iterator() {
        return this.items.iterator();
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof LegendItemCollection && this.items.equals(((LegendItemCollection)o).items));
    }
    
    public Object clone() {
        return super.clone();
    }
}
