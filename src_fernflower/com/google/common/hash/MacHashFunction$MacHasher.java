package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractByteHasher;
import com.google.common.hash.HashCode;
import com.google.common.hash.MacHashFunction$1;
import javax.crypto.Mac;

final class MacHashFunction$MacHasher extends AbstractByteHasher {
   private final Mac mac;
   private boolean done;

   private MacHashFunction$MacHasher(Mac var1) {
      this.mac = var1;
   }

   protected void update(byte var1) {
      this.checkNotDone();
      this.mac.update(var1);
   }

   protected void update(byte[] var1) {
      this.checkNotDone();
      this.mac.update(var1);
   }

   protected void update(byte[] var1, int var2, int var3) {
      this.checkNotDone();
      this.mac.update(var1, var2, var3);
   }

   private void checkNotDone() {
      Preconditions.checkState(!this.done, "Cannot re-use a Hasher after calling hash() on it");
   }

   public HashCode hash() {
      this.checkNotDone();
      this.done = true;
      return HashCode.fromBytesNoCopy(this.mac.doFinal());
   }

   // $FF: synthetic method
   MacHashFunction$MacHasher(Mac var1, MacHashFunction$1 var2) {
      this(var1);
   }
}
