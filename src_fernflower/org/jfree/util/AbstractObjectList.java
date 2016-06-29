package org.jfree.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import org.jfree.util.ObjectUtilities;

public class AbstractObjectList implements Serializable, Cloneable {
   private static final long serialVersionUID = 7789833772597351595L;
   public static final int DEFAULT_INITIAL_CAPACITY = 8;
   private transient Object[] objects;
   private int size;
   private int increment;

   protected AbstractObjectList() {
      this(8);
   }

   protected AbstractObjectList(int var1) {
      this(var1, var1);
   }

   protected AbstractObjectList(int var1, int var2) {
      this.size = 0;
      this.increment = 8;
      this.objects = new Object[var1];
      this.increment = var2;
   }

   protected Object get(int var1) {
      Object var2 = null;
      if(var1 >= 0 && var1 < this.size) {
         var2 = this.objects[var1];
      }

      return var2;
   }

   protected void set(int var1, Object var2) {
      if(var1 < 0) {
         throw new IllegalArgumentException("Requires index >= 0.");
      } else {
         if(var1 >= this.objects.length) {
            Object[] var3 = new Object[var1 + this.increment];
            System.arraycopy(this.objects, 0, var3, 0, this.objects.length);
            this.objects = var3;
         }

         this.objects[var1] = var2;
         this.size = Math.max(this.size, var1 + 1);
      }
   }

   public void clear() {
      Arrays.fill(this.objects, (Object)null);
      this.size = 0;
   }

   public int size() {
      return this.size;
   }

   protected int indexOf(Object var1) {
      for(int var2 = 0; var2 < this.size; ++var2) {
         if(this.objects[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else if(!(var1 instanceof AbstractObjectList)) {
         return false;
      } else {
         AbstractObjectList var2 = (AbstractObjectList)var1;
         int var3 = this.size();

         for(int var4 = 0; var4 < var3; ++var4) {
            if(!ObjectUtilities.equal(this.get(var4), var2.get(var4))) {
               return false;
            }
         }

         return true;
      }
   }

   public int hashCode() {
      return super.hashCode();
   }

   public Object clone() {
      AbstractObjectList var1 = (AbstractObjectList)super.clone();
      if(this.objects != null) {
         var1.objects = new Object[this.objects.length];
         System.arraycopy(this.objects, 0, var1.objects, 0, this.objects.length);
      }

      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      int var2 = this.size();
      var1.writeInt(var2);

      for(int var3 = 0; var3 < var2; ++var3) {
         Object var4 = this.get(var3);
         if(var4 != null && var4 instanceof Serializable) {
            var1.writeInt(var3);
            var1.writeObject(var4);
         } else {
            var1.writeInt(-1);
         }
      }

   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.objects = new Object[this.size];
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = var1.readInt();
         if(var4 != -1) {
            this.set(var4, var1.readObject());
         }
      }

   }
}
