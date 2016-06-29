package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.Files;
import com.google.common.io.MoreFiles$1;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

final class MoreFiles$PathByteSource extends ByteSource {
   private static final LinkOption[] FOLLOW_LINKS = new LinkOption[0];
   private final Path path;
   private final OpenOption[] options;
   private final boolean followLinks;

   private MoreFiles$PathByteSource(Path var1, OpenOption... var2) {
      this.path = (Path)Preconditions.checkNotNull(var1);
      this.options = (OpenOption[])var2.clone();
      this.followLinks = followLinks(this.options);
   }

   private static boolean followLinks(OpenOption[] var0) {
      OpenOption[] var1 = var0;
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         OpenOption var4 = var1[var3];
         if(var4 == LinkOption.NOFOLLOW_LINKS) {
            return false;
         }
      }

      return true;
   }

   public InputStream openStream() {
      return java.nio.file.Files.newInputStream(this.path, this.options);
   }

   public SeekableByteChannel openChannel() {
      return java.nio.file.Files.newByteChannel(this.path, this.options);
   }

   private BasicFileAttributes readAttributes() {
      return java.nio.file.Files.readAttributes(this.path, BasicFileAttributes.class, this.followLinks?FOLLOW_LINKS:new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
   }

   public Optional sizeIfKnown() {
      BasicFileAttributes var1;
      try {
         var1 = this.readAttributes();
      } catch (IOException var3) {
         return Optional.absent();
      }

      return !var1.isDirectory() && !var1.isSymbolicLink()?Optional.of(Long.valueOf(var1.size())):Optional.absent();
   }

   public long size() {
      BasicFileAttributes var1 = this.readAttributes();
      if(var1.isDirectory()) {
         throw new IOException("can\'t read: is a directory");
      } else if(var1.isSymbolicLink()) {
         throw new IOException("can\'t read: is a symbolic link");
      } else {
         return var1.size();
      }
   }

   public byte[] read() {
      SeekableByteChannel var1 = this.openChannel();
      Throwable var2 = null;

      byte[] var3;
      try {
         var3 = Files.readFile(Channels.newInputStream(var1), var1.size());
      } catch (Throwable var12) {
         var2 = var12;
         throw var12;
      } finally {
         if(var1 != null) {
            if(var2 != null) {
               try {
                  var1.close();
               } catch (Throwable var11) {
                  var2.addSuppressed(var11);
               }
            } else {
               var1.close();
            }
         }

      }

      return var3;
   }

   public String toString() {
      String var1 = String.valueOf(this.path);
      String var2 = String.valueOf(Arrays.toString(this.options));
      return (new StringBuilder(26 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("MoreFiles.asByteSource(").append(var1).append(", ").append(var2).append(")").toString();
   }

   // $FF: synthetic method
   MoreFiles$PathByteSource(Path var1, OpenOption[] var2, MoreFiles$1 var3) {
      this(var1, var2);
   }
}
