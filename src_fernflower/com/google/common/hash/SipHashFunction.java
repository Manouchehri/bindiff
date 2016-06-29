package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.SipHashFunction$SipHasher;
import java.io.Serializable;
import javax.annotation.Nullable;

final class SipHashFunction extends AbstractStreamingHashFunction implements Serializable {
   private final int c;
   private final int d;
   private final long k0;
   private final long k1;
   private static final long serialVersionUID = 0L;

   SipHashFunction(int var1, int var2, long var3, long var5) {
      Preconditions.checkArgument(var1 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", new Object[]{Integer.valueOf(var1)});
      Preconditions.checkArgument(var2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", new Object[]{Integer.valueOf(var2)});
      this.c = var1;
      this.d = var2;
      this.k0 = var3;
      this.k1 = var5;
   }

   public int bits() {
      return 64;
   }

   public Hasher newHasher() {
      return new SipHashFunction$SipHasher(this.c, this.d, this.k0, this.k1);
   }

   public String toString() {
      int var1 = this.c;
      int var2 = this.d;
      long var3 = this.k0;
      long var5 = this.k1;
      return (new StringBuilder(81)).append("Hashing.sipHash").append(var1).append(var2).append("(").append(var3).append(", ").append(var5).append(")").toString();
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof SipHashFunction)) {
         return false;
      } else {
         SipHashFunction var2 = (SipHashFunction)var1;
         return this.c == var2.c && this.d == var2.d && this.k0 == var2.k0 && this.k1 == var2.k1;
      }
   }

   public int hashCode() {
      return (int)((long)(this.getClass().hashCode() ^ this.c ^ this.d) ^ this.k0 ^ this.k1);
   }
}
