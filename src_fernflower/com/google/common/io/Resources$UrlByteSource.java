package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.Resources$1;
import java.io.InputStream;
import java.net.URL;

final class Resources$UrlByteSource extends ByteSource {
   private final URL url;

   private Resources$UrlByteSource(URL var1) {
      this.url = (URL)Preconditions.checkNotNull(var1);
   }

   public InputStream openStream() {
      return this.url.openStream();
   }

   public String toString() {
      String var1 = String.valueOf(this.url);
      return (new StringBuilder(24 + String.valueOf(var1).length())).append("Resources.asByteSource(").append(var1).append(")").toString();
   }

   // $FF: synthetic method
   Resources$UrlByteSource(URL var1, Resources$1 var2) {
      this(var1);
   }
}
