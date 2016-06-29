package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.MessageDigestHashFunction$1;
import com.google.common.hash.MessageDigestHashFunction$MessageDigestHasher;
import com.google.common.hash.MessageDigestHashFunction$SerializedForm;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class MessageDigestHashFunction extends AbstractStreamingHashFunction implements Serializable {
   private final MessageDigest prototype;
   private final int bytes;
   private final boolean supportsClone;
   private final String toString;

   MessageDigestHashFunction(String var1, String var2) {
      this.prototype = getMessageDigest(var1);
      this.bytes = this.prototype.getDigestLength();
      this.toString = (String)Preconditions.checkNotNull(var2);
      this.supportsClone = this.supportsClone();
   }

   MessageDigestHashFunction(String var1, int var2, String var3) {
      this.toString = (String)Preconditions.checkNotNull(var3);
      this.prototype = getMessageDigest(var1);
      int var4 = this.prototype.getDigestLength();
      Preconditions.checkArgument(var2 >= 4 && var2 <= var4, "bytes (%s) must be >= 4 and < %s", new Object[]{Integer.valueOf(var2), Integer.valueOf(var4)});
      this.bytes = var2;
      this.supportsClone = this.supportsClone();
   }

   private boolean supportsClone() {
      try {
         this.prototype.clone();
         return true;
      } catch (CloneNotSupportedException var2) {
         return false;
      }
   }

   public int bits() {
      return this.bytes * 8;
   }

   public String toString() {
      return this.toString;
   }

   private static MessageDigest getMessageDigest(String var0) {
      try {
         return MessageDigest.getInstance(var0);
      } catch (NoSuchAlgorithmException var2) {
         throw new AssertionError(var2);
      }
   }

   public Hasher newHasher() {
      if(this.supportsClone) {
         try {
            return new MessageDigestHashFunction$MessageDigestHasher((MessageDigest)this.prototype.clone(), this.bytes, (MessageDigestHashFunction$1)null);
         } catch (CloneNotSupportedException var2) {
            ;
         }
      }

      return new MessageDigestHashFunction$MessageDigestHasher(getMessageDigest(this.prototype.getAlgorithm()), this.bytes, (MessageDigestHashFunction$1)null);
   }

   Object writeReplace() {
      return new MessageDigestHashFunction$SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString, (MessageDigestHashFunction$1)null);
   }
}
