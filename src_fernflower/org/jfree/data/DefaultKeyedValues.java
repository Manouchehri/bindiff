package org.jfree.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.DefaultKeyedValue;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValueComparator;
import org.jfree.data.KeyedValueComparatorType;
import org.jfree.data.KeyedValues;
import org.jfree.data.UnknownKeyException;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.SortOrder;

public class DefaultKeyedValues implements Serializable, Cloneable, KeyedValues, PublicCloneable {
   private static final long serialVersionUID = 8468154364608194797L;
   private List data = new ArrayList();

   public int getItemCount() {
      return this.data.size();
   }

   public Number getValue(int var1) {
      Number var2 = null;
      KeyedValue var3 = (KeyedValue)this.data.get(var1);
      if(var3 != null) {
         var2 = var3.getValue();
      }

      return var2;
   }

   public Comparable getKey(int var1) {
      Comparable var2 = null;
      KeyedValue var3 = (KeyedValue)this.data.get(var1);
      if(var3 != null) {
         var2 = var3.getKey();
      }

      return var2;
   }

   public int getIndex(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         int var2 = 0;

         for(Iterator var3 = this.data.iterator(); var3.hasNext(); ++var2) {
            KeyedValue var4 = (KeyedValue)var3.next();
            if(var4.getKey().equals(var1)) {
               return var2;
            }
         }

         return -1;
      }
   }

   public List getKeys() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.data.iterator();

      while(var2.hasNext()) {
         KeyedValue var3 = (KeyedValue)var2.next();
         var1.add(var3.getKey());
      }

      return var1;
   }

   public Number getValue(Comparable var1) {
      int var2 = this.getIndex(var1);
      if(var2 < 0) {
         throw new UnknownKeyException("Key not found: " + var1);
      } else {
         return this.getValue(var2);
      }
   }

   public void addValue(Comparable var1, double var2) {
      this.addValue(var1, new Double(var2));
   }

   public void addValue(Comparable var1, Number var2) {
      this.setValue(var1, var2);
   }

   public void setValue(Comparable var1, double var2) {
      this.setValue(var1, new Double(var2));
   }

   public void setValue(Comparable var1, Number var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         int var3 = this.getIndex(var1);
         DefaultKeyedValue var4;
         if(var3 >= 0) {
            var4 = (DefaultKeyedValue)this.data.get(var3);
            var4.setValue(var2);
         } else {
            var4 = new DefaultKeyedValue(var1, var2);
            this.data.add(var4);
         }

      }
   }

   public void removeValue(int var1) {
      this.data.remove(var1);
   }

   public void removeValue(Comparable var1) {
      int var2 = this.getIndex(var1);
      if(var2 >= 0) {
         this.removeValue(var2);
      }

   }

   public void clear() {
      this.data.clear();
   }

   public void sortByKeys(SortOrder var1) {
      KeyedValueComparator var2 = new KeyedValueComparator(KeyedValueComparatorType.BY_KEY, var1);
      Collections.sort(this.data, var2);
   }

   public void sortByValues(SortOrder var1) {
      KeyedValueComparator var2 = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, var1);
      Collections.sort(this.data, var2);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof KeyedValues)) {
         return false;
      } else {
         KeyedValues var2 = (KeyedValues)var1;
         int var3 = this.getItemCount();
         if(var3 != var2.getItemCount()) {
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
      return this.data != null?this.data.hashCode():0;
   }

   public Object clone() {
      DefaultKeyedValues var1 = (DefaultKeyedValues)super.clone();
      var1.data = (List)ObjectUtilities.deepClone(this.data);
      return var1;
   }
}
