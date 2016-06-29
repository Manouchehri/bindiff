package org.jfree.chart.entity;

import java.awt.Shape;
import java.io.Serializable;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.data.category.CategoryDataset;
import org.jfree.util.ObjectUtilities;

public class CategoryItemEntity extends ChartEntity implements Serializable, Cloneable {
   private static final long serialVersionUID = -8657249457902337349L;
   private transient CategoryDataset dataset;
   private int series;
   private Object category;
   private int categoryIndex;

   public CategoryItemEntity(Shape var1, String var2, String var3, CategoryDataset var4, int var5, Object var6, int var7) {
      super(var1, var2, var3);
      this.dataset = var4;
      this.series = var5;
      this.category = var6;
      this.categoryIndex = var7;
   }

   public CategoryDataset getDataset() {
      return this.dataset;
   }

   public void setDataset(CategoryDataset var1) {
      this.dataset = var1;
   }

   public int getSeries() {
      return this.series;
   }

   public void setSeries(int var1) {
      this.series = var1;
   }

   public Object getCategory() {
      return this.category;
   }

   public void setCategory(Object var1) {
      this.category = var1;
   }

   public int getCategoryIndex() {
      return this.categoryIndex;
   }

   public void setCategoryIndex(int var1) {
      this.categoryIndex = var1;
   }

   public String toString() {
      return "Category Item: series=" + this.series + ", category=" + this.category.toString();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof CategoryItemEntity && super.equals(var1)) {
         CategoryItemEntity var2 = (CategoryItemEntity)var1;
         return this.categoryIndex != var2.categoryIndex?false:(this.series != var2.series?false:ObjectUtilities.equal(this.category, var2.category));
      } else {
         return false;
      }
   }
}
