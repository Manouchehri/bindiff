/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.entity;

import java.awt.Shape;
import java.io.Serializable;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.data.category.CategoryDataset;
import org.jfree.util.ObjectUtilities;

public class CategoryItemEntity
extends ChartEntity
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -8657249457902337349L;
    private transient CategoryDataset dataset;
    private int series;
    private Object category;
    private int categoryIndex;

    public CategoryItemEntity(Shape shape, String string, String string2, CategoryDataset categoryDataset, int n2, Object object, int n3) {
        super(shape, string, string2);
        this.dataset = categoryDataset;
        this.series = n2;
        this.category = object;
        this.categoryIndex = n3;
    }

    public CategoryDataset getDataset() {
        return this.dataset;
    }

    public void setDataset(CategoryDataset categoryDataset) {
        this.dataset = categoryDataset;
    }

    public int getSeries() {
        return this.series;
    }

    public void setSeries(int n2) {
        this.series = n2;
    }

    public Object getCategory() {
        return this.category;
    }

    public void setCategory(Object object) {
        this.category = object;
    }

    public int getCategoryIndex() {
        return this.categoryIndex;
    }

    public void setCategoryIndex(int n2) {
        this.categoryIndex = n2;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("Category Item: series=").append(this.series).append(", category=").append(this.category.toString()).toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CategoryItemEntity)) return false;
        if (!super.equals(object)) return false;
        CategoryItemEntity categoryItemEntity = (CategoryItemEntity)object;
        if (this.categoryIndex != categoryItemEntity.categoryIndex) {
            return false;
        }
        if (this.series != categoryItemEntity.series) {
            return false;
        }
        if (ObjectUtilities.equal(this.category, categoryItemEntity.category)) return true;
        return false;
    }
}

