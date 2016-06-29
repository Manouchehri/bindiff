/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.entity;

import java.awt.Shape;
import org.jfree.chart.entity.TickLabelEntity;

public class CategoryLabelEntity
extends TickLabelEntity {
    private Comparable key;

    public CategoryLabelEntity(Comparable comparable, Shape shape, String string, String string2) {
        super(shape, string, string2);
        this.key = comparable;
    }

    public Comparable getKey() {
        return this.key;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("CategoryLabelEntity: ");
        stringBuffer.append("category=");
        stringBuffer.append(this.key);
        stringBuffer.append(new StringBuffer().append(", tooltip=").append(this.getToolTipText()).toString());
        stringBuffer.append(new StringBuffer().append(", url=").append(this.getURLText()).toString());
        return stringBuffer.toString();
    }
}

