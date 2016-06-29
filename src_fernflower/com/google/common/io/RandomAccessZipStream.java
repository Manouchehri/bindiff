package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.io.LittleEndianDataInputStream;
import com.google.common.io.RandomAccessZipStream$ZipStreamEntry;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
@GoogleInternal
public final class RandomAccessZipStream {
   private static final int MINIMUM_INFLATER_BUFFER_SIZE = 1024;
   private static final int MAXIMUM_INFLATER_BUFFER_SIZE = 65535;
   private static final int MAXIMUM_ZIP_COMMENT_SIZE = 65535;
   private static final int CENSIG = 33639248;
   private static final int ENDSIG = 101010256;
   private static final int ENDSIG64 = 101075792;
   private static final int ENDHDR = 22;
   private static final int LOCAL_FILE_NAME_LENGTH = 26;
   private static final int LOCEXT = 28;
   private static final String ZIP_PATH_SEPARATOR = "/";
   private final int streamLength;
   private final InputStream underlyingZipStream;
   private final LittleEndianDataInputStream littleEndianInputStream;
   private final LinkedHashMap entries;

   public RandomAccessZipStream(InputStream var1, int var2) {
      this.entries = new LinkedHashMap();
      Preconditions.checkArgument(0 < var2, "Must specify the length of the ZIP archive");
      Preconditions.checkArgument(var1.markSupported(), "InputStream must support marking and resetting");
      this.streamLength = var2;
      this.underlyingZipStream = var1;
      this.littleEndianInputStream = new LittleEndianDataInputStream(var1);
      var1.mark(var2);
      this.initializeCentralDirectory();
   }

   public RandomAccessZipStream(byte[] var1) {
      this(new ByteArrayInputStream(var1), var1.length);
   }

   public Collection getEntries() {
      return Collections.unmodifiableCollection(this.entries.values());
   }

   public RandomAccessZipStream$ZipStreamEntry getEntry(String var1) {
      // $FF: Couldn't be decompiled
   }

   public InputStream getInputStream(RandomAccessZipStream$ZipStreamEntry var1) {
      Preconditions.checkNotNull(var1, "entry");
      Preconditions.checkArgument(var1 == this.getEntry(var1.getName()), "Entry doesn\'t belong to this RandomAccessZipStream");

      try {
         this.underlyingZipStream.reset();
         ByteStreams.skipFully(this.underlyingZipStream, RandomAccessZipStream$ZipStreamEntry.access$000(var1) + 28L);
         int var2 = this.littleEndianInputStream.readUnsignedShort();
         ByteStreams.skipFully(this.underlyingZipStream, (long)(RandomAccessZipStream$ZipStreamEntry.access$100(var1) + var2));
      } catch (IOException var4) {
         ZipException var3 = new ZipException("Error finding local record in ZIP.");
         var3.initCause(var4);
         throw var3;
      }

      Object var5;
      switch(var1.getMethod()) {
      case 0:
         var5 = this.underlyingZipStream;
         break;
      case 8:
         int var6 = (int)Math.max(1024L, Math.min(var1.getSize(), 65535L));
         var5 = new InflaterInputStream(this.underlyingZipStream, new Inflater(true), var6);
         break;
      default:
         throw new ZipException("Unsupported ZIP compression method.");
      }

      return ByteStreams.limit((InputStream)var5, var1.getSize());
   }

   public String getLocalFileHeaderName(RandomAccessZipStream$ZipStreamEntry var1) {
      Preconditions.checkNotNull(var1, "entry");
      Preconditions.checkArgument(var1 == this.getEntry(var1.getName()), "Entry doesn\'t belong to this RandomAccessZipStream");
      this.underlyingZipStream.reset();
      ByteStreams.skipFully(this.underlyingZipStream, RandomAccessZipStream$ZipStreamEntry.access$000(var1) + 26L);
      int var2 = this.littleEndianInputStream.readUnsignedShort();
      ByteStreams.skipFully(this.underlyingZipStream, 2L);
      byte[] var3 = new byte[var2];
      this.underlyingZipStream.read(var3);
      return new String(var3, var1.getEncoding());
   }

   public int size() {
      return this.entries.size();
   }

   private void initializeCentralDirectory() {
      long var1 = (long)(this.streamLength - 22);
      if(var1 < 0L) {
         throw new ZipException("Too short to be a valid ZIP archive.");
      } else {
         long var3 = Math.max(0L, var1 - 65535L);

         try {
            do {
               this.underlyingZipStream.reset();
               ByteStreams.skipFully(this.underlyingZipStream, var1);
               if(this.littleEndianInputStream.readInt() == 101010256) {
                  int var5 = this.littleEndianInputStream.readUnsignedShort();
                  int var14 = this.littleEndianInputStream.readUnsignedShort();
                  int var7 = this.littleEndianInputStream.readUnsignedShort();
                  int var8 = this.littleEndianInputStream.readUnsignedShort();
                  this.littleEndianInputStream.readInt();
                  long var9 = (long)this.littleEndianInputStream.readInt();
                  this.littleEndianInputStream.readUnsignedShort();
                  if(var7 == var8 && var5 == 0 && var14 == 0) {
                     this.underlyingZipStream.reset();
                     ByteStreams.skipFully(this.underlyingZipStream, var9);

                     while(true) {
                        int var11 = this.littleEndianInputStream.readInt();
                        if(var11 == 101010256 || var11 == 101075792) {
                           return;
                        }

                        if(var11 != 33639248) {
                           throw new ZipException("Local entry header NOT found");
                        }

                        RandomAccessZipStream$ZipStreamEntry var12 = new RandomAccessZipStream$ZipStreamEntry(this.littleEndianInputStream, this.underlyingZipStream);
                        this.entries.put(var12.getName(), var12);
                     }
                  } else {
                     throw new ZipException("Spanned ZIP archives NOT supported.");
                  }
               }

               --var1;
            } while(var1 >= var3);

            throw new ZipException("ZIP directory not found, not a ZIP archive.");
         } catch (IOException var13) {
            ZipException var6 = new ZipException("Invalid ZIP archive.");
            var6.initCause(var13);
            throw var6;
         }
      }
   }

   private static long dosToJavaTime(int var0, int var1) {
      GregorianCalendar var2 = new GregorianCalendar();
      var2.set(14, 0);
      var2.set(1980 + (var1 >> 9 & 127), (var1 >> 5 & 15) - 1, var1 & 31, var0 >> 11 & 31, var0 >> 5 & 63, (var0 & 31) << 1);
      return var2.getTime().getTime();
   }

   // $FF: synthetic method
   static long access$200(int var0, int var1) {
      return dosToJavaTime(var0, var1);
   }
}
