/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.entity;

import java.awt.Shape;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.data.xy.XYDataset;

public class XYItemEntity
extends ChartEntity {
    private static final long serialVersionUID = -3870862224880283771L;
    private transient XYDataset dataset;
    private int series;
    private int item;

    public XYItemEntity(Shape shape, XYDataset xYDataset, int n2, int n3, String string, String string2) {
        super(shape, string, string2);
        this.dataset = xYDataset;
        this.series = n2;
        this.item = n3;
    }

    public XYDataset getDataset() {
        return this.dataset;
    }

    public void setDataset(XYDataset xYDataset) {
        this.dataset = xYDataset;
    }

    public int getSeriesIndex() {
        return this.series;
    }

    public void setSeriesIndex(int n2) {
        this.series = n2;
    }

    public int getItem() {
        return this.item;
    }

    public void setItem(int n2) {
        this.item = n2;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYItemEntity)) return false;
        if (!super.equals(object)) return false;
        XYItemEntity xYItemEntity = (XYItemEntity)object;
        if (this.series != xYItemEntity.series) {
            return false;
        }
        if (this.item == xYItemEntity.item) return true;
        return false;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("XYItemEntity: series = ").append(this.getSeriesIndex()).append(", item = ").append(this.getItem()).append(", dataset = ").append(this.getDataset()).toString();
    }
}

