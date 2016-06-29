package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.Closer;
import com.google.common.io.Files;
import com.google.common.io.Files$1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.channels.FileChannel;

final class Files$FileByteSource extends ByteSource {
   private final File file;

   private Files$FileByteSource(File var1) {
      this.file = (File)Preconditions.checkNotNull(var1);
   }

   public FileInputStream openStream() {
      return new FileInputStream(this.file);
   }

   @GoogleInternal
   public FileChannel openChannel() {
      return this.openStream().getChannel();
   }

   public Optional sizeIfKnown() {
      return this.file.isFile()?Optional.of(Long.valueOf(this.file.length())):Optional.absent();
   }

   public long size() {
      if(!this.file.isFile()) {
         throw new FileNotFoundException(this.file.toString());
      } else {
         return this.file.length();
      }
   }

   public byte[] read() {
      Closer var1 = Closer.create();

      byte[] var3;
      try {
         FileInputStream var2 = (FileInputStream)var1.register(this.openStream());
         var3 = Files.readFile(var2, var2.getChannel().size());
      } catch (Throwable var7) {
         throw var1.rethrow(var7);
      } finally {
         var1.close();
      }

      return var3;
   }

   public String toString() {
      String var1 = String.valueOf(this.file);
      return (new StringBuilder(20 + String.valueOf(var1).length())).append("Files.asByteSource(").append(var1).append(")").toString();
   }

   // $FF: synthetic method
   Files$FileByteSource(File var1, Files$1 var2) {
      this(var1);
   }
}
