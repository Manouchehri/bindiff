package org.jfree.data.category;

import java.io.Serializable;
import java.util.List;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.AbstractDataset;

public class DefaultCategoryDataset extends AbstractDataset implements Serializable, CategoryDataset {
   private static final long serialVersionUID = -8168173757291644622L;
   private DefaultKeyedValues2D data = new DefaultKeyedValues2D();

   public int getRowCount() {
      return this.data.getRowCount();
   }

   public int getColumnCount() {
      return this.data.getColumnCount();
   }

   public Number getValue(int var1, int var2) {
      return this.data.getValue(var1, var2);
   }

   public Comparable getRowKey(int var1) {
      return this.data.getRowKey(var1);
   }

   public int getRowIndex(Comparable var1) {
      return this.data.getRowIndex(var1);
   }

   public List getRowKeys() {
      return this.data.getRowKeys();
   }

   public Comparable getColumnKey(int var1) {
      return this.data.getColumnKey(var1);
   }

   public int getColumnIndex(Comparable var1) {
      return this.data.getColumnIndex(var1);
   }

   public List getColumnKeys() {
      return this.data.getColumnKeys();
   }

   public Number getValue(Comparable var1, Comparable var2) {
      return this.data.getValue(var1, var2);
   }

   public void addValue(Number var1, Comparable var2, Comparable var3) {
      this.data.addValue(var1, var2, var3);
      this.fireDatasetChanged();
   }

   public void addValue(double var1, Comparable var3, Comparable var4) {
      this.addValue(new Double(var1), var3, var4);
   }

   public void setValue(Number var1, Comparable var2, Comparable var3) {
      this.data.setValue(var1, var2, var3);
      this.fireDatasetChanged();
   }

   public void setValue(double var1, Comparable var3, Comparable var4) {
      this.setValue(new Double(var1), var3, var4);
   }

   public void incrementValue(double var1, Comparable var3, Comparable var4) {
      double var5 = 0.0D;
      Number var7 = this.getValue(var3, var4);
      if(var7 != null) {
         var5 = var7.doubleValue();
      }

      this.setValue(var5 + var1, var3, var4);
   }

   public void removeValue(Comparable var1, Comparable var2) {
      this.data.removeValue(var1, var2);
      this.fireDatasetChanged();
   }

   public void removeRow(int var1) {
      this.data.removeRow(var1);
      this.fireDatasetChanged();
   }

   public void removeRow(Comparable var1) {
      this.data.removeRow(var1);
      this.fireDatasetChanged();
   }

   public void removeColumn(int var1) {
      this.data.removeColumn(var1);
      this.fireDatasetChanged();
   }

   public void removeColumn(Comparable var1) {
      this.data.removeColumn(var1);
      this.fireDatasetChanged();
   }

   public void clear() {
      this.data.clear();
      this.fireDatasetChanged();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CategoryDataset)) {
         return false;
      } else {
         CategoryDataset var2 = (CategoryDataset)var1;
         if(!this.getRowKeys().equals(var2.getRowKeys())) {
            return false;
         } else if(!this.getColumnKeys().equals(var2.getColumnKeys())) {
            return false;
         } else {
            int var3 = this.getRowCount();
            int var4 = this.getColumnCount();

            for(int var5 = 0; var5 < var3; ++var5) {
               for(int var6 = 0; var6 < var4; ++var6) {
                  Number var7 = this.getValue(var5, var6);
                  Number var8 = var2.getValue(var5, var6);
                  if(var7 == null) {
                     if(var8 != null) {
                        return false;
                     }
                  } else if(!var7.equals(var8)) {
                     return false;
                  }
               }
            }

            return true;
         }
      }
   }

   public int hashCode() {
      return this.data.hashCode();
   }

   public Object clone() {
      DefaultCategoryDataset var1 = (DefaultCategoryDataset)super.clone();
      var1.data = (DefaultKeyedValues2D)this.data.clone();
      return var1;
   }
}
