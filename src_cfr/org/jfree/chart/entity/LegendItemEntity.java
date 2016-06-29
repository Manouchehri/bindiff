/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.entity;

import java.awt.Shape;
import java.io.Serializable;
import org.jfree.chart.entity.ChartEntity;

public class LegendItemEntity
extends ChartEntity
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -7435683933545666702L;
    private int seriesIndex;

    public LegendItemEntity(Shape shape) {
        super(shape);
    }

    public int getSeriesIndex() {
        return this.seriesIndex;
    }

    public void setSeriesIndex(int n2) {
        this.seriesIndex = n2;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LegendItemEntity)) return false;
        if (!super.equals(object)) return false;
        LegendItemEntity legendItemEntity = (LegendItemEntity)object;
        if (this.seriesIndex == legendItemEntity.seriesIndex) return true;
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

