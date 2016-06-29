package com.google.common.io;

import com.google.common.io.ByteStreams;
import com.google.common.io.LittleEndianDataInputStream;
import com.google.common.io.RandomAccessZipStream;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class RandomAccessZipStream$ZipStreamEntry implements Serializable {
   private static final long serialVersionUID = -3699231327290802232L;
   private final int versionMadeBy;
   private final int versionForExtraction;
   private final int bitFlags;
   private final int method;
   private final long time;
   private final long crc;
   private final long compressedSize;
   private final long size;
   private final int nameLen;
   private final int internalFileAttributes;
   private final long externalFileAttributes;
   private final long relativeOffsetToLocalHeader;
   private final String name;
   private final byte[] extra;
   private final String comment;

   RandomAccessZipStream$ZipStreamEntry(LittleEndianDataInputStream var1, InputStream var2) {
      this.versionMadeBy = var1.readUnsignedShort();
      this.versionForExtraction = var1.readUnsignedShort();
      this.bitFlags = var1.readUnsignedShort();
      this.method = var1.readUnsignedShort();
      this.time = RandomAccessZipStream.access$200(var1.readUnsignedShort(), var1.readUnsignedShort());
      this.crc = 4294967295L & (long)var1.readInt();
      this.compressedSize = (long)var1.readInt();
      this.size = (long)var1.readInt();
      this.nameLen = var1.readUnsignedShort();
      int var3 = var1.readUnsignedShort();
      int var4 = var1.readUnsignedShort();
      var1.readUnsignedShort();
      this.internalFileAttributes = var1.readUnsignedShort();
      this.externalFileAttributes = (long)var1.readInt();
      this.relativeOffsetToLocalHeader = (long)var1.readInt();
      byte[] var5 = new byte[this.nameLen];
      ByteStreams.readFully(var2, var5);
      if(var3 > 0) {
         this.extra = new byte[var3];
         ByteStreams.readFully(var2, this.extra);
      } else {
         this.extra = null;
      }

      byte[] var6 = null;
      if(var4 > 0) {
         var6 = new byte[var4];
         ByteStreams.readFully(var2, var6);
      }

      Charset var7 = this.getEncoding();
      this.name = new String(var5, var7);
      this.comment = var6 == null?null:new String(var6, var7);
   }

   public String getComment() {
      return this.comment;
   }

   public long getCompressedSize() {
      return this.compressedSize;
   }

   public long getCrc() {
      return this.crc;
   }

   public Charset getEncoding() {
      return 0 != (this.bitFlags >>> 11 & 1)?StandardCharsets.UTF_8:StandardCharsets.ISO_8859_1;
   }

   public byte[] getExtra() {
      return this.extra != null?(byte[])this.extra.clone():null;
   }

   public int getMethod() {
      return this.method;
   }

   public String getName() {
      return this.name;
   }

   public long getSize() {
      return this.size;
   }

   public long getTime() {
      return this.time;
   }

   public boolean isDirectory() {
      return this.name.endsWith("/");
   }

   public int getInternalFileAttributes() {
      return this.internalFileAttributes;
   }

   public long getExternalFileAttributes() {
      return this.externalFileAttributes;
   }

   public int getVersionMadeBy() {
      return this.versionMadeBy;
   }

   public long getRelativeOffsetToLocalHeader() {
      return this.relativeOffsetToLocalHeader;
   }

   public int getVersionForExtraction() {
      return this.versionForExtraction;
   }

   public String toString() {
      return this.name;
   }

   // $FF: synthetic method
   static long access$000(RandomAccessZipStream$ZipStreamEntry var0) {
      return var0.relativeOffsetToLocalHeader;
   }

   // $FF: synthetic method
   static int access$100(RandomAccessZipStream$ZipStreamEntry var0) {
      return var0.nameLen;
   }
}
