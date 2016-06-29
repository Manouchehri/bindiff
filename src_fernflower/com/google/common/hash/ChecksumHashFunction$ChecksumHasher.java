package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractByteHasher;
import com.google.common.hash.ChecksumHashFunction;
import com.google.common.hash.ChecksumHashFunction$1;
import com.google.common.hash.HashCode;
import java.util.zip.Checksum;

final class ChecksumHashFunction$ChecksumHasher extends AbstractByteHasher {
   private final Checksum checksum;
   // $FF: synthetic field
   final ChecksumHashFunction this$0;

   private ChecksumHashFunction$ChecksumHasher(ChecksumHashFunction var1, Checksum var2) {
      this.this$0 = var1;
      this.checksum = (Checksum)Preconditions.checkNotNull(var2);
   }

   protected void update(byte var1) {
      this.checksum.update(var1);
   }

   protected void update(byte[] var1, int var2, int var3) {
      this.checksum.update(var1, var2, var3);
   }

   public HashCode hash() {
      long var1 = this.checksum.getValue();
      return ChecksumHashFunction.access$100(this.this$0) == 32?HashCode.fromInt((int)var1):HashCode.fromLong(var1);
   }

   // $FF: synthetic method
   ChecksumHashFunction$ChecksumHasher(ChecksumHashFunction var1, Checksum var2, ChecksumHashFunction$1 var3) {
      this(var1, var2);
   }
}
