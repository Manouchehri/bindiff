package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSink;
import com.google.common.io.MoreFiles$1;
import java.io.OutputStream;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;

final class MoreFiles$PathByteSink extends ByteSink {
   private final Path path;
   private final OpenOption[] options;

   private MoreFiles$PathByteSink(Path var1, OpenOption... var2) {
      this.path = (Path)Preconditions.checkNotNull(var1);
      this.options = (OpenOption[])var2.clone();
   }

   public OutputStream openStream() {
      return java.nio.file.Files.newOutputStream(this.path, this.options);
   }

   public String toString() {
      String var1 = String.valueOf(this.path);
      String var2 = String.valueOf(Arrays.toString(this.options));
      return (new StringBuilder(24 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("MoreFiles.asByteSink(").append(var1).append(", ").append(var2).append(")").toString();
   }

   // $FF: synthetic method
   MoreFiles$PathByteSink(Path var1, OpenOption[] var2, MoreFiles$1 var3) {
      this(var1, var2);
   }
}
