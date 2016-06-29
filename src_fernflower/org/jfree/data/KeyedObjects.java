package org.jfree.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.KeyedObject;
import org.jfree.util.PublicCloneable;

public class KeyedObjects implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 1321582394193530984L;
   private List data = new ArrayList();

   public int getItemCount() {
      return this.data.size();
   }

   public Object getObject(int var1) {
      Object var2 = null;
      if(var1 >= 0 && var1 < this.data.size()) {
         KeyedObject var3 = (KeyedObject)this.data.get(var1);
         if(var3 != null) {
            var2 = var3.getObject();
         }
      }

      return var2;
   }

   public Comparable getKey(int var1) {
      Comparable var2 = null;
      if(var1 >= 0 && var1 < this.data.size()) {
         KeyedObject var3 = (KeyedObject)this.data.get(var1);
         if(var3 != null) {
            var2 = var3.getKey();
         }
      }

      return var2;
   }

   public int getIndex(Comparable var1) {
      int var2 = -1;
      int var3 = 0;

      for(Iterator var4 = this.data.iterator(); var4.hasNext(); ++var3) {
         KeyedObject var5 = (KeyedObject)var4.next();
         if(var5.getKey().equals(var1)) {
            var2 = var3;
         }
      }

      return var2;
   }

   public List getKeys() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.data.iterator();

      while(var2.hasNext()) {
         KeyedObject var3 = (KeyedObject)var2.next();
         var1.add(var3.getKey());
      }

      return var1;
   }

   public Object getObject(Comparable var1) {
      return this.getObject(this.getIndex(var1));
   }

   public void addObject(Comparable var1, Object var2) {
      this.setObject(var1, var2);
   }

   public void setObject(Comparable var1, Object var2) {
      int var3 = this.getIndex(var1);
      KeyedObject var4;
      if(var3 >= 0) {
         var4 = (KeyedObject)this.data.get(var3);
         var4.setObject(var2);
      } else {
         var4 = new KeyedObject(var1, var2);
         this.data.add(var4);
      }

   }

   public void removeValue(int var1) {
      this.data.remove(var1);
   }

   public void removeValue(Comparable var1) {
      this.removeValue(this.getIndex(var1));
   }

   public Object clone() {
      KeyedObjects var1 = (KeyedObjects)super.clone();
      var1.data = new ArrayList();
      Iterator var2 = this.data.iterator();

      while(var2.hasNext()) {
         KeyedObject var3 = (KeyedObject)var2.next();
         var1.data.add(var3.clone());
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else if(!(var1 instanceof KeyedObjects)) {
         return false;
      } else {
         KeyedObjects var2 = (KeyedObjects)var1;
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

               Object var7 = this.getObject(var4);
               Object var8 = var2.getObject(var4);
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
