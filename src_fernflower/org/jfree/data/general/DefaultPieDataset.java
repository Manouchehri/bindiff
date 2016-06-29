package org.jfree.data.general;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.PublicCloneable;
import org.jfree.util.SortOrder;

public class DefaultPieDataset extends AbstractDataset implements Serializable, Cloneable, PieDataset, PublicCloneable {
   private static final long serialVersionUID = 2904745139106540618L;
   private DefaultKeyedValues data;

   public DefaultPieDataset() {
      this.data = new DefaultKeyedValues();
   }

   public DefaultPieDataset(KeyedValues var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'data\' argument.");
      } else {
         this.data = new DefaultKeyedValues();

         for(int var2 = 0; var2 < var1.getItemCount(); ++var2) {
            this.data.addValue(var1.getKey(var2), var1.getValue(var2));
         }

      }
   }

   public int getItemCount() {
      return this.data.getItemCount();
   }

   public List getKeys() {
      return Collections.unmodifiableList(this.data.getKeys());
   }

   public Comparable getKey(int var1) {
      return this.data.getKey(var1);
   }

   public int getIndex(Comparable var1) {
      return this.data.getIndex(var1);
   }

   public Number getValue(int var1) {
      Number var2 = null;
      if(this.getItemCount() > var1) {
         var2 = this.data.getValue(var1);
      }

      return var2;
   }

   public Number getValue(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         return this.data.getValue(var1);
      }
   }

   public void setValue(Comparable var1, Number var2) {
      this.data.setValue(var1, var2);
      this.fireDatasetChanged();
   }

   public void setValue(Comparable var1, double var2) {
      this.setValue(var1, new Double(var2));
   }

   public void remove(Comparable var1) {
      this.data.removeValue(var1);
      this.fireDatasetChanged();
   }

   public void clear() {
      if(this.getItemCount() > 0) {
         this.data.clear();
         this.fireDatasetChanged();
      }

   }

   public void sortByKeys(SortOrder var1) {
      this.data.sortByKeys(var1);
      this.fireDatasetChanged();
   }

   public void sortByValues(SortOrder var1) {
      this.data.sortByValues(var1);
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

   public int hashCode() {
      return this.data.hashCode();
   }

   public Object clone() {
      DefaultPieDataset var1 = (DefaultPieDataset)super.clone();
      var1.data = (DefaultKeyedValues)this.data.clone();
      return var1;
   }
}
