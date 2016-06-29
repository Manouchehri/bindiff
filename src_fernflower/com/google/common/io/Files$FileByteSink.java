package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.ByteSink;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files$1;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

final class Files$FileByteSink extends ByteSink {
   private final File file;
   private final ImmutableSet modes;

   private Files$FileByteSink(File var1, FileWriteMode... var2) {
      this.file = (File)Preconditions.checkNotNull(var1);
      this.modes = ImmutableSet.copyOf((Object[])var2);
   }

   public FileOutputStream openStream() {
      return new FileOutputStream(this.file, this.modes.contains(FileWriteMode.APPEND));
   }

   @GoogleInternal
   public FileChannel openChannel() {
      return this.openStream().getChannel();
   }

   public String toString() {
      String var1 = String.valueOf(this.file);
      String var2 = String.valueOf(this.modes);
      return (new StringBuilder(20 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("Files.asByteSink(").append(var1).append(", ").append(var2).append(")").toString();
   }

   // $FF: synthetic method
   Files$FileByteSink(File var1, FileWriteMode[] var2, Files$1 var3) {
      this(var1, var2);
   }
}
