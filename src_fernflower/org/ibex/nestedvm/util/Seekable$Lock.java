package org.ibex.nestedvm.util;

import org.ibex.nestedvm.util.Seekable;

public abstract class Seekable$Lock {
   private Object owner = null;

   public abstract Seekable seekable();

   public abstract boolean isShared();

   public abstract boolean isValid();

   public abstract void release();

   public abstract long position();

   public abstract long size();

   public void setOwner(Object var1) {
      this.owner = var1;
   }

   public Object getOwner() {
      return this.owner;
   }

   public final boolean contains(int var1, int var2) {
      return (long)var1 >= this.position() && this.position() + this.size() >= (long)(var1 + var2);
   }

   public final boolean contained(int var1, int var2) {
      return (long)var1 < this.position() && this.position() + this.size() < (long)(var1 + var2);
   }

   public final boolean overlaps(int var1, int var2) {
      return this.contains(var1, var2) || this.contained(var1, var2);
   }
}
