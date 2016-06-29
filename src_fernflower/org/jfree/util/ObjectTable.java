package org.jfree.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import org.jfree.util.ObjectUtilities;

public class ObjectTable implements Serializable {
   private static final long serialVersionUID = -3968322452944912066L;
   private int rows;
   private int columns;
   private transient Object[][] data;
   private int rowIncrement;
   private int columnIncrement;

   public ObjectTable() {
      this(5, 5);
   }

   public ObjectTable(int var1) {
      this(var1, var1);
   }

   public ObjectTable(int var1, int var2) {
      if(var1 < 1) {
         throw new IllegalArgumentException("Increment must be positive.");
      } else if(var2 < 1) {
         throw new IllegalArgumentException("Increment must be positive.");
      } else {
         this.rows = 0;
         this.columns = 0;
         this.rowIncrement = var1;
         this.columnIncrement = var2;
         this.data = new Object[var1][];
      }
   }

   public int getColumnIncrement() {
      return this.columnIncrement;
   }

   public int getRowIncrement() {
      return this.rowIncrement;
   }

   protected void ensureRowCapacity(int var1) {
      if(var1 >= this.data.length) {
         Object[][] var2 = new Object[var1 + this.rowIncrement][];
         System.arraycopy(this.data, 0, var2, 0, this.data.length);
         this.data = var2;
      }

   }

   public void ensureCapacity(int var1, int var2) {
      if(var1 < 0) {
         throw new IndexOutOfBoundsException("Row is invalid. " + var1);
      } else if(var2 < 0) {
         throw new IndexOutOfBoundsException("Column is invalid. " + var2);
      } else {
         this.ensureRowCapacity(var1);
         Object[] var3 = this.data[var1];
         Object[] var4;
         if(var3 == null) {
            var4 = new Object[Math.max(var2 + 1, this.columnIncrement)];
            this.data[var1] = var4;
         } else if(var2 >= var3.length) {
            var4 = new Object[var2 + this.columnIncrement];
            System.arraycopy(var3, 0, var4, 0, var3.length);
            this.data[var1] = var4;
         }

      }
   }

   public int getRowCount() {
      return this.rows;
   }

   public int getColumnCount() {
      return this.columns;
   }

   protected Object getObject(int var1, int var2) {
      if(var1 < this.data.length) {
         Object[] var3 = this.data[var1];
         if(var3 == null) {
            return null;
         }

         if(var2 < var3.length) {
            return var3[var2];
         }
      }

      return null;
   }

   protected void setObject(int var1, int var2, Object var3) {
      this.ensureCapacity(var1, var2);
      this.data[var1][var2] = var3;
      this.rows = Math.max(this.rows, var1 + 1);
      this.columns = Math.max(this.columns, var2 + 1);
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(this == var1) {
         return true;
      } else if(!(var1 instanceof ObjectTable)) {
         return false;
      } else {
         ObjectTable var2 = (ObjectTable)var1;
         if(this.getRowCount() != var2.getRowCount()) {
            return false;
         } else if(this.getColumnCount() != var2.getColumnCount()) {
            return false;
         } else {
            for(int var3 = 0; var3 < this.getRowCount(); ++var3) {
               for(int var4 = 0; var4 < this.getColumnCount(); ++var4) {
                  if(!ObjectUtilities.equal(this.getObject(var3, var4), var2.getObject(var3, var4))) {
                     return false;
                  }
               }
            }

            return true;
         }
      }
   }

   public int hashCode() {
      int var1 = this.rows;
      var1 = 29 * var1 + this.columns;
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      int var2 = this.data.length;
      var1.writeInt(var2);

      for(int var3 = 0; var3 < var2; ++var3) {
         Object[] var4 = this.data[var3];
         var1.writeBoolean(var4 != null);
         if(var4 != null) {
            int var5 = var4.length;
            var1.writeInt(var5);

            for(int var6 = 0; var6 < var5; ++var6) {
               this.writeSerializedData(var1, var4[var6]);
            }
         }
      }

   }

   protected void writeSerializedData(ObjectOutputStream var1, Object var2) {
      var1.writeObject(var2);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      int var2 = var1.readInt();
      this.data = new Object[var2][];

      for(int var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var1.readBoolean();
         if(var4) {
            int var5 = var1.readInt();
            Object[] var6 = new Object[var5];
            this.data[var3] = var6;

            for(int var7 = 0; var7 < var5; ++var7) {
               var6[var7] = this.readSerializedData(var1);
            }
         }
      }

   }

   protected Object readSerializedData(ObjectInputStream var1) {
      return var1.readObject();
   }

   public void clear() {
      this.rows = 0;
      this.columns = 0;

      for(int var1 = 0; var1 < this.data.length; ++var1) {
         if(this.data[var1] != null) {
            Arrays.fill(this.data[var1], (Object)null);
         }
      }

   }

   protected void copyColumn(int var1, int var2) {
      for(int var3 = 0; var3 < this.getRowCount(); ++var3) {
         this.setObject(var3, var2, this.getObject(var3, var1));
      }

   }

   protected void copyRow(int var1, int var2) {
      this.ensureCapacity(var2, this.getColumnCount());
      Object[] var3 = this.data[var1];
      if(var3 == null) {
         Object[] var4 = this.data[var2];
         if(var4 != null) {
            Arrays.fill(var4, (Object)null);
         }
      } else {
         this.data[var2] = (Object[])((Object[])var3.clone());
      }

   }

   protected void setData(Object[][] var1, int var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else if(var2 < 0) {
         throw new IndexOutOfBoundsException();
      } else {
         this.data = var1;
         this.rows = var1.length;
         this.columns = var2;
      }
   }

   protected Object[][] getData() {
      return this.data;
   }
}
