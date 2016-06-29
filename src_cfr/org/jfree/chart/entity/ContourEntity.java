/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.entity;

import java.awt.Shape;
import java.io.Serializable;
import org.jfree.chart.entity.ChartEntity;

public class ContourEntity
extends ChartEntity
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 1249570520505992847L;
    private int index = -1;

    public ContourEntity(Shape shape, String string) {
        super(shape, string);
    }

    public ContourEntity(Shape shape, String string, String string2) {
        super(shape, string, string2);
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int n2) {
        this.index = n2;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ContourEntity)) return false;
        if (!super.equals(object)) return false;
        ContourEntity contourEntity = (ContourEntity)object;
        if (this.index == contourEntity.index) return true;
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

