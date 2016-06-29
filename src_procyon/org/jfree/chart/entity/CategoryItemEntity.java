package org.jfree.chart.entity;

import java.io.*;
import org.jfree.data.category.*;
import java.awt.*;
import org.jfree.util.*;

public class CategoryItemEntity extends ChartEntity implements Serializable, Cloneable
{
    private static final long serialVersionUID = -8657249457902337349L;
    private transient CategoryDataset dataset;
    private int series;
    private Object category;
    private int categoryIndex;
    
    public CategoryItemEntity(final Shape shape, final String s, final String s2, final CategoryDataset dataset, final int series, final Object category, final int categoryIndex) {
        super(shape, s, s2);
        this.dataset = dataset;
        this.series = series;
        this.category = category;
        this.categoryIndex = categoryIndex;
    }
    
    public CategoryDataset getDataset() {
        return this.dataset;
    }
    
    public void setDataset(final CategoryDataset dataset) {
        this.dataset = dataset;
    }
    
    public int getSeries() {
        return this.series;
    }
    
    public void setSeries(final int series) {
        this.series = series;
    }
    
    public Object getCategory() {
        return this.category;
    }
    
    public void setCategory(final Object category) {
        this.category = category;
    }
    
    public int getCategoryIndex() {
        return this.categoryIndex;
    }
    
    public void setCategoryIndex(final int categoryIndex) {
        this.categoryIndex = categoryIndex;
    }
    
    public String toString() {
        return "Category Item: series=" + this.series + ", category=" + this.category.toString();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof CategoryItemEntity && super.equals(o)) {
            final CategoryItemEntity categoryItemEntity = (CategoryItemEntity)o;
            return this.categoryIndex == categoryItemEntity.categoryIndex && this.series == categoryItemEntity.series && ObjectUtilities.equal(this.category, categoryItemEntity.category);
        }
        return false;
    }
}
