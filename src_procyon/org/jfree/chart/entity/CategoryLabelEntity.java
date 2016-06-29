package org.jfree.chart.entity;

import java.awt.*;

public class CategoryLabelEntity extends TickLabelEntity
{
    private Comparable key;
    
    public CategoryLabelEntity(final Comparable key, final Shape shape, final String s, final String s2) {
        super(shape, s, s2);
        this.key = key;
    }
    
    public Comparable getKey() {
        return this.key;
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer("CategoryLabelEntity: ");
        sb.append("category=");
        sb.append(this.key);
        sb.append(", tooltip=" + this.getToolTipText());
        sb.append(", url=" + this.getURLText());
        return sb.toString();
    }
}
