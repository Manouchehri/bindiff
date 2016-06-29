package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels$StringCharsetFunnel$SerializedForm;
import com.google.common.hash.PrimitiveSink;
import java.io.Serializable;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

class Funnels$StringCharsetFunnel implements Funnel, Serializable {
   private final Charset charset;

   Funnels$StringCharsetFunnel(Charset var1) {
      this.charset = (Charset)Preconditions.checkNotNull(var1);
   }

   public void funnel(CharSequence var1, PrimitiveSink var2) {
      var2.putString(var1, this.charset);
   }

   public String toString() {
      String var1 = String.valueOf(this.charset.name());
      return (new StringBuilder(22 + String.valueOf(var1).length())).append("Funnels.stringFunnel(").append(var1).append(")").toString();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Funnels$StringCharsetFunnel) {
         Funnels$StringCharsetFunnel var2 = (Funnels$StringCharsetFunnel)var1;
         return this.charset.equals(var2.charset);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Funnels$StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
   }

   Object writeReplace() {
      return new Funnels$StringCharsetFunnel$SerializedForm(this.charset);
   }
}
