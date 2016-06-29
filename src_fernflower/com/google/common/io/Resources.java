package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.LineProcessor;
import com.google.common.io.Resources$1;
import com.google.common.io.Resources$UrlByteSource;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@Beta
public final class Resources {
   public static ByteSource asByteSource(URL var0) {
      return new Resources$UrlByteSource(var0, (Resources$1)null);
   }

   public static CharSource asCharSource(URL var0, Charset var1) {
      return asByteSource(var0).asCharSource(var1);
   }

   public static byte[] toByteArray(URL var0) {
      return asByteSource(var0).read();
   }

   public static String toString(URL var0, Charset var1) {
      return asCharSource(var0, var1).read();
   }

   public static Object readLines(URL var0, Charset var1, LineProcessor var2) {
      return asCharSource(var0, var1).readLines(var2);
   }

   public static List readLines(URL var0, Charset var1) {
      return (List)readLines(var0, var1, new Resources$1());
   }

   public static void copy(URL var0, OutputStream var1) {
      asByteSource(var0).copyTo(var1);
   }

   public static URL getResource(String var0) {
      ClassLoader var1 = (ClassLoader)MoreObjects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader());
      URL var2 = var1.getResource(var0);
      Preconditions.checkArgument(var2 != null, "resource %s not found.", new Object[]{var0});
      return var2;
   }

   public static URL getResource(Class var0, String var1) {
      URL var2 = var0.getResource(var1);
      Preconditions.checkArgument(var2 != null, "resource %s relative to %s not found.", new Object[]{var1, var0.getName()});
      return var2;
   }
}
