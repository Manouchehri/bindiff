package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

final class ZipFiles$ZipEntryByteSource extends ByteSource {
   private final ZipFile file;
   private final ZipEntry entry;

   ZipFiles$ZipEntryByteSource(ZipFile var1, ZipEntry var2) {
      this.file = (ZipFile)Preconditions.checkNotNull(var1);
      this.entry = (ZipEntry)Preconditions.checkNotNull(var2);
   }

   public InputStream openStream() {
      return this.file.getInputStream(this.entry);
   }

   public String toString() {
      String var1 = String.valueOf(this.file);
      String var2 = String.valueOf(this.entry);
      return (new StringBuilder(25 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("ZipFiles.asByteSource(").append(var1).append(", ").append(var2).append(")").toString();
   }
}
