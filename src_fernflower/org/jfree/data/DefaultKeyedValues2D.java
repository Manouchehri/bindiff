package org.jfree.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues2D;
import org.jfree.data.UnknownKeyException;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class DefaultKeyedValues2D implements Serializable, Cloneable, KeyedValues2D, PublicCloneable {
   private static final long serialVersionUID = -5514169970951994748L;
   private List rowKeys;
   private List columnKeys;
   private List rows;
   private boolean sortRowKeys;

   public DefaultKeyedValues2D() {
      this(false);
   }

   public DefaultKeyedValues2D(boolean var1) {
      this.rowKeys = new ArrayList();
      this.columnKeys = new ArrayList();
      this.rows = new ArrayList();
      this.sortRowKeys = var1;
   }

   public int getRowCount() {
      return this.rowKeys.size();
   }

   public int getColumnCount() {
      return this.columnKeys.size();
   }

   public Number getValue(int var1, int var2) {
      Number var3 = null;
      DefaultKeyedValues var4 = (DefaultKeyedValues)this.rows.get(var1);
      if(var4 != null) {
         Comparable var5 = (Comparable)this.columnKeys.get(var2);
         int var6 = var4.getIndex(var5);
         if(var6 >= 0) {
            var3 = var4.getValue(var6);
         }
      }

      return var3;
   }

   public Comparable getRowKey(int var1) {
      return (Comparable)this.rowKeys.get(var1);
   }

   public int getRowIndex(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         return this.sortRowKeys?Collections.binarySearch(this.rowKeys, var1):this.rowKeys.indexOf(var1);
      }
   }

   public List getRowKeys() {
      return Collections.unmodifiableList(this.rowKeys);
   }

   public Comparable getColumnKey(int var1) {
      return (Comparable)this.columnKeys.get(var1);
   }

   public int getColumnIndex(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         return this.columnKeys.indexOf(var1);
      }
   }

   public List getColumnKeys() {
      return Collections.unmodifiableList(this.columnKeys);
   }

   public Number getValue(Comparable var1, Comparable var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'rowKey\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'columnKey\' argument.");
      } else if(!this.columnKeys.contains(var2)) {
         throw new UnknownKeyException("Unrecognised columnKey: " + var2);
      } else {
         int var3 = this.getRowIndex(var1);
         if(var3 >= 0) {
            DefaultKeyedValues var4 = (DefaultKeyedValues)this.rows.get(var3);
            int var5 = var4.getIndex(var2);
            return var5 >= 0?var4.getValue(var5):null;
         } else {
            throw new UnknownKeyException("Unrecognised rowKey: " + var1);
         }
      }
   }

   public void addValue(Number var1, Comparable var2, Comparable var3) {
      this.setValue(var1, var2, var3);
   }

   public void setValue(Number var1, Comparable var2, Comparable var3) {
      int var5 = this.getRowIndex(var2);
      DefaultKeyedValues var4;
      if(var5 >= 0) {
         var4 = (DefaultKeyedValues)this.rows.get(var5);
      } else {
         var4 = new DefaultKeyedValues();
         if(this.sortRowKeys) {
            var5 = -var5 - 1;
            this.rowKeys.add(var5, var2);
            this.rows.add(var5, var4);
         } else {
            this.rowKeys.add(var2);
            this.rows.add(var4);
         }
      }

      var4.setValue(var3, var1);
      int var6 = this.columnKeys.indexOf(var3);
      if(var6 < 0) {
         this.columnKeys.add(var3);
      }

   }

   public void removeValue(Comparable var1, Comparable var2) {
      this.setValue((Number)null, var1, var2);
      boolean var3 = true;
      int var4 = this.getRowIndex(var1);
      DefaultKeyedValues var5 = (DefaultKeyedValues)this.rows.get(var4);
      int var6 = 0;

      int var7;
      for(var7 = var5.getItemCount(); var6 < var7; ++var6) {
         if(var5.getValue(var6) != null) {
            var3 = false;
            break;
         }
      }

      if(var3) {
         this.rowKeys.remove(var4);
         this.rows.remove(var4);
      }

      var3 = true;
      var6 = this.getColumnIndex(var2);
      var7 = 0;

      int var8;
      for(var8 = this.rows.size(); var7 < var8; ++var7) {
         var5 = (DefaultKeyedValues)this.rows.get(var7);
         if(var5.getValue(var6) != null) {
            var3 = false;
            break;
         }
      }

      if(var3) {
         var7 = 0;

         for(var8 = this.rows.size(); var7 < var8; ++var7) {
            var5 = (DefaultKeyedValues)this.rows.get(var7);
            var5.removeValue(var6);
         }

         this.columnKeys.remove(var6);
      }

   }

   public void removeRow(int var1) {
      this.rowKeys.remove(var1);
      this.rows.remove(var1);
   }

   public void removeRow(Comparable var1) {
      this.removeRow(this.getRowIndex(var1));
   }

   public void removeColumn(int var1) {
      Comparable var2 = this.getColumnKey(var1);
      this.removeColumn(var2);
   }

   public void removeColumn(Comparable var1) {
      Iterator var2 = this.rows.iterator();

      while(var2.hasNext()) {
         DefaultKeyedValues var3 = (DefaultKeyedValues)var2.next();
         var3.removeValue(var1);
      }

      this.columnKeys.remove(var1);
   }

   public void clear() {
      this.rowKeys.clear();
      this.columnKeys.clear();
      this.rows.clear();
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else if(!(var1 instanceof KeyedValues2D)) {
         return false;
      } else {
         KeyedValues2D var2 = (KeyedValues2D)var1;
         if(!this.getRowKeys().equals(var2.getRowKeys())) {
            return false;
         } else if(!this.getColumnKeys().equals(var2.getColumnKeys())) {
            return false;
         } else {
            int var3 = this.getRowCount();
            if(var3 != var2.getRowCount()) {
               return false;
            } else {
               int var4 = this.getColumnCount();
               if(var4 != var2.getColumnCount()) {
                  return false;
               } else {
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
      }
   }

   public int hashCode() {
      int var1 = this.rowKeys.hashCode();
      var1 = 29 * var1 + this.columnKeys.hashCode();
      var1 = 29 * var1 + this.rows.hashCode();
      return var1;
   }

   public Object clone() {
      DefaultKeyedValues2D var1 = (DefaultKeyedValues2D)super.clone();
      var1.columnKeys = new ArrayList(this.columnKeys);
      var1.rowKeys = new ArrayList(this.rowKeys);
      var1.rows = (List)ObjectUtilities.deepClone(this.rows);
      return var1;
   }
}
