package org.jfree.chart;

import java.awt.Paint;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jfree.io.SerialUtilities;
import org.jfree.util.PaintUtilities;

public class PaintMap implements Serializable, Cloneable {
   private transient Map store = new HashMap();

   public Paint getPaint(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         return (Paint)this.store.get(var1);
      }
   }

   public boolean containsKey(Comparable var1) {
      return this.store.containsKey(var1);
   }

   public void put(Comparable var1, Paint var2) {
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
      } else if(!(var1 instanceof PaintMap)) {
         return false;
      } else {
         PaintMap var2 = (PaintMap)var1;
         if(this.store.size() != var2.store.size()) {
            return false;
         } else {
            Set var3 = this.store.keySet();
            Iterator var4 = var3.iterator();

            Paint var6;
            Paint var7;
            do {
               if(!var4.hasNext()) {
                  return true;
               }

               Comparable var5 = (Comparable)var4.next();
               var6 = this.getPaint(var5);
               var7 = var2.getPaint(var5);
            } while(PaintUtilities.equal(var6, var7));

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
         Paint var5 = this.getPaint(var4);
         SerialUtilities.writePaint(var5, var1);
      }

   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.store = new HashMap();
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         Comparable var4 = (Comparable)var1.readObject();
         Paint var5 = SerialUtilities.readPaint(var1);
         this.store.put(var4, var5);
      }

   }
}
