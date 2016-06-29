package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.ChecksumHashFunction$1;
import com.google.common.hash.ChecksumHashFunction$ChecksumHasher;
import com.google.common.hash.Hasher;
import java.io.Serializable;
import java.util.zip.Checksum;

final class ChecksumHashFunction extends AbstractStreamingHashFunction implements Serializable {
   private final Supplier checksumSupplier;
   private final int bits;
   private final String toString;
   private static final long serialVersionUID = 0L;

   ChecksumHashFunction(Supplier var1, int var2, String var3) {
      this.checksumSupplier = (Supplier)Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(var2 == 32 || var2 == 64, "bits (%s) must be either 32 or 64", new Object[]{Integer.valueOf(var2)});
      this.bits = var2;
      this.toString = (String)Preconditions.checkNotNull(var3);
   }

   public int bits() {
      return this.bits;
   }

   public Hasher newHasher() {
      return new ChecksumHashFunction$ChecksumHasher(this, (Checksum)this.checksumSupplier.get(), (ChecksumHashFunction$1)null);
   }

   public String toString() {
      return this.toString;
   }

   // $FF: synthetic method
   static int access$100(ChecksumHashFunction var0) {
      return var0.bits;
   }
}
