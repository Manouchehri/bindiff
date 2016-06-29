package org.jfree.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.KeyedObjects;

public class KeyedObjects2D implements Serializable, Cloneable {
   private static final long serialVersionUID = -1015873563138522374L;
   private List rowKeys = new ArrayList();
   private List columnKeys = new ArrayList();
   private List rows = new ArrayList();

   public int getRowCount() {
      return this.rowKeys.size();
   }

   public int getColumnCount() {
      return this.columnKeys.size();
   }

   public Object getObject(int var1, int var2) {
      Object var3 = null;
      KeyedObjects var4 = (KeyedObjects)this.rows.get(var1);
      if(var4 != null) {
         Comparable var5 = (Comparable)this.columnKeys.get(var2);
         if(var5 != null) {
            var3 = var4.getObject(var5);
         }
      }

      return var3;
   }

   public Comparable getRowKey(int var1) {
      return (Comparable)this.rowKeys.get(var1);
   }

   public int getRowIndex(Comparable var1) {
      return this.rowKeys.indexOf(var1);
   }

   public List getRowKeys() {
      return Collections.unmodifiableList(this.rowKeys);
   }

   public Comparable getColumnKey(int var1) {
      return (Comparable)this.columnKeys.get(var1);
   }

   public int getColumnIndex(Comparable var1) {
      return this.columnKeys.indexOf(var1);
   }

   public List getColumnKeys() {
      return Collections.unmodifiableList(this.columnKeys);
   }

   public Object getObject(Comparable var1, Comparable var2) {
      Object var3 = null;
      int var4 = this.rowKeys.indexOf(var1);
      if(var4 >= 0) {
         KeyedObjects var5 = (KeyedObjects)this.rows.get(var4);
         var3 = var5.getObject(var2);
      }

      return var3;
   }

   public void addObject(Object var1, Comparable var2, Comparable var3) {
      this.setObject(var1, var2, var3);
   }

   public void setObject(Object var1, Comparable var2, Comparable var3) {
      int var5 = this.rowKeys.indexOf(var2);
      KeyedObjects var4;
      if(var5 >= 0) {
         var4 = (KeyedObjects)this.rows.get(var5);
      } else {
         this.rowKeys.add(var2);
         var4 = new KeyedObjects();
         this.rows.add(var4);
      }

      var4.setObject(var3, var1);
      int var6 = this.columnKeys.indexOf(var3);
      if(var6 < 0) {
         this.columnKeys.add(var3);
      }

   }

   public void removeObject(Comparable var1, Comparable var2) {
      this.setObject((Object)null, var1, var2);
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
         KeyedObjects var3 = (KeyedObjects)var2.next();
         var3.removeValue(var1);
      }

      this.columnKeys.remove(var1);
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else if(!(var1 instanceof KeyedObjects2D)) {
         return false;
      } else {
         KeyedObjects2D var2 = (KeyedObjects2D)var1;
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
                        Object var7 = this.getObject(var5, var6);
                        Object var8 = var2.getObject(var5, var6);
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
      return super.clone();
   }
}
