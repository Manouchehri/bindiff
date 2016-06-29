package org.jfree.data.category;

import java.util.Collections;
import java.util.List;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.PieDataset;
import org.jfree.util.TableOrder;

public class CategoryToPieDataset extends AbstractDataset implements DatasetChangeListener, PieDataset {
   static final long serialVersionUID = 5516396319762189617L;
   private CategoryDataset source;
   private TableOrder extract;
   private int index;

   public CategoryToPieDataset(CategoryDataset var1, TableOrder var2, int var3) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'extract\' argument.");
      } else {
         this.source = var1;
         if(this.source != null) {
            this.source.addChangeListener(this);
         }

         this.extract = var2;
         this.index = var3;
      }
   }

   public CategoryDataset getUnderlyingDataset() {
      return this.source;
   }

   public TableOrder getExtractType() {
      return this.extract;
   }

   public int getExtractIndex() {
      return this.index;
   }

   public int getItemCount() {
      int var1 = 0;
      if(this.source != null) {
         if(this.extract == TableOrder.BY_ROW) {
            var1 = this.source.getColumnCount();
         } else if(this.extract == TableOrder.BY_COLUMN) {
            var1 = this.source.getRowCount();
         }
      }

      return var1;
   }

   public Number getValue(int var1) {
      Number var2 = null;
      if(var1 >= 0 && var1 < this.getItemCount()) {
         if(this.extract == TableOrder.BY_ROW) {
            var2 = this.source.getValue(this.index, var1);
         } else if(this.extract == TableOrder.BY_COLUMN) {
            var2 = this.source.getValue(var1, this.index);
         }

         return var2;
      } else {
         throw new IndexOutOfBoundsException("The \'item\' index is out of bounds.");
      }
   }

   public Comparable getKey(int var1) {
      Comparable var2 = null;
      if(var1 >= 0 && var1 < this.getItemCount()) {
         if(this.extract == TableOrder.BY_ROW) {
            var2 = this.source.getColumnKey(var1);
         } else if(this.extract == TableOrder.BY_COLUMN) {
            var2 = this.source.getRowKey(var1);
         }

         return var2;
      } else {
         throw new IndexOutOfBoundsException("Invalid \'index\': " + var1);
      }
   }

   public int getIndex(Comparable var1) {
      int var2 = -1;
      if(this.source != null) {
         if(this.extract == TableOrder.BY_ROW) {
            var2 = this.source.getColumnIndex(var1);
         } else if(this.extract == TableOrder.BY_COLUMN) {
            var2 = this.source.getRowIndex(var1);
         }
      }

      return var2;
   }

   public List getKeys() {
      List var1 = Collections.EMPTY_LIST;
      if(this.source != null) {
         if(this.extract == TableOrder.BY_ROW) {
            var1 = this.source.getColumnKeys();
         } else if(this.extract == TableOrder.BY_COLUMN) {
            var1 = this.source.getRowKeys();
         }
      }

      return var1;
   }

   public Number getValue(Comparable var1) {
      Number var2 = null;
      int var3 = this.getIndex(var1);
      if(var3 != -1) {
         if(this.extract == TableOrder.BY_ROW) {
            var2 = this.source.getValue(this.index, var3);
         } else if(this.extract == TableOrder.BY_COLUMN) {
            var2 = this.source.getValue(var3, this.index);
         }
      }

      return var2;
   }

   public void datasetChanged(DatasetChangeEvent var1) {
      this.fireDatasetChanged();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof PieDataset)) {
         return false;
      } else {
         PieDataset var2 = (PieDataset)var1;
         int var3 = this.getItemCount();
         if(var2.getItemCount() != var3) {
            return false;
         } else {
            for(int var4 = 0; var4 < var3; ++var4) {
               Comparable var5 = this.getKey(var4);
               Comparable var6 = var2.getKey(var4);
               if(!var5.equals(var6)) {
                  return false;
               }

               Number var7 = this.getValue(var4);
               Number var8 = var2.getValue(var4);
               if(var7 == null) {
                  if(var8 != null) {
                     return false;
                  }
               } else if(!var7.equals(var8)) {
                  return false;
               }
            }

            return true;
         }
      }
   }
}
