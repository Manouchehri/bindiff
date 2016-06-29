package com.google.common.hash;

import com.google.common.hash.MessageDigestHashFunction;
import com.google.common.hash.MessageDigestHashFunction$1;
import java.io.Serializable;

final class MessageDigestHashFunction$SerializedForm implements Serializable {
   private final String algorithmName;
   private final int bytes;
   private final String toString;
   private static final long serialVersionUID = 0L;

   private MessageDigestHashFunction$SerializedForm(String var1, int var2, String var3) {
      this.algorithmName = var1;
      this.bytes = var2;
      this.toString = var3;
   }

   private Object readResolve() {
      return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
   }

   // $FF: synthetic method
   MessageDigestHashFunction$SerializedForm(String var1, int var2, String var3, MessageDigestHashFunction$1 var4) {
      this(var1, var2, var3);
   }
}
