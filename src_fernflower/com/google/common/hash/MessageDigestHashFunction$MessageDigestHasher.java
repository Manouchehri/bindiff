package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractByteHasher;
import com.google.common.hash.HashCode;
import com.google.common.hash.MessageDigestHashFunction$1;
import java.security.MessageDigest;
import java.util.Arrays;

final class MessageDigestHashFunction$MessageDigestHasher extends AbstractByteHasher {
   private final MessageDigest digest;
   private final int bytes;
   private boolean done;

   private MessageDigestHashFunction$MessageDigestHasher(MessageDigest var1, int var2) {
      this.digest = var1;
      this.bytes = var2;
   }

   protected void update(byte var1) {
      this.checkNotDone();
      this.digest.update(var1);
   }

   protected void update(byte[] var1) {
      this.checkNotDone();
      this.digest.update(var1);
   }

   protected void update(byte[] var1, int var2, int var3) {
      this.checkNotDone();
      this.digest.update(var1, var2, var3);
   }

   private void checkNotDone() {
      Preconditions.checkState(!this.done, "Cannot re-use a Hasher after calling hash() on it");
   }

   public HashCode hash() {
      this.checkNotDone();
      this.done = true;
      return this.bytes == this.digest.getDigestLength()?HashCode.fromBytesNoCopy(this.digest.digest()):HashCode.fromBytesNoCopy(Arrays.copyOf(this.digest.digest(), this.bytes));
   }

   // $FF: synthetic method
   MessageDigestHashFunction$MessageDigestHasher(MessageDigest var1, int var2, MessageDigestHashFunction$1 var3) {
      this(var1, var2);
   }
}
