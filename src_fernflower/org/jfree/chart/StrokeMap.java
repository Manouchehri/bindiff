package org.jfree.chart;

import java.awt.Stroke;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.jfree.io.SerialUtilities;
import org.jfree.util.ObjectUtilities;

public class StrokeMap implements Serializable, Cloneable {
   private transient Map store = new TreeMap();

   public Stroke getStroke(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         return (Stroke)this.store.get(var1);
      }
   }

   public boolean containsKey(Comparable var1) {
      return this.store.containsKey(var1);
   }

   public void put(Comparable var1, Stroke var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         this.store.put(var1, var2);
      }
   }

   public void clear() {
      this.store.clear();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StrokeMap)) {
         return false;
      } else {
         StrokeMap var2 = (StrokeMap)var1;
         if(this.store.size() != var2.store.size()) {
            return false;
         } else {
            Set var3 = this.store.keySet();
            Iterator var4 = var3.iterator();

            Stroke var6;
            Stroke var7;
            do {
               if(!var4.hasNext()) {
                  return true;
               }

               Comparable var5 = (Comparable)var4.next();
               var6 = this.getStroke(var5);
               var7 = var2.getStroke(var5);
            } while(ObjectUtilities.equal(var6, var7));

            return false;
         }
      }
   }

   public Object clone() {
      return super.clone();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeInt(this.store.size());
      Set var2 = this.store.keySet();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Comparable var4 = (Comparable)var3.next();
         var1.writeObject(var4);
         Stroke var5 = this.getStroke(var4);
         SerialUtilities.writeStroke(var5, var1);
      }

   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.store = new TreeMap();
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         Comparable var4 = (Comparable)var1.readObject();
         Stroke var5 = SerialUtilities.readStroke(var1);
         this.store.put(var4, var5);
      }

   }
}
