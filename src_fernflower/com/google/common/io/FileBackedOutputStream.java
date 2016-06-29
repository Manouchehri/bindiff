package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.io.ByteSource;
import com.google.common.io.FileBackedOutputStream$1;
import com.google.common.io.FileBackedOutputStream$2;
import com.google.common.io.FileBackedOutputStream$MemoryOutput;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Beta
public final class FileBackedOutputStream extends OutputStream {
   private final int fileThreshold;
   private final boolean resetOnFinalize;
   private final ByteSource source;
   private OutputStream out;
   private FileBackedOutputStream$MemoryOutput memory;
   private File file;

   @VisibleForTesting
   synchronized File getFile() {
      return this.file;
   }

   public FileBackedOutputStream(int var1) {
      this(var1, false);
   }

   public FileBackedOutputStream(int var1, boolean var2) {
      this.fileThreshold = var1;
      this.resetOnFinalize = var2;
      this.memory = new FileBackedOutputStream$MemoryOutput((FileBackedOutputStream$1)null);
      this.out = this.memory;
      if(var2) {
         this.source = new FileBackedOutputStream$1(this);
      } else {
         this.source = new FileBackedOutputStream$2(this);
      }

   }

   public ByteSource asByteSource() {
      return this.source;
   }

   private synchronized InputStream openInputStream() {
      return (InputStream)(this.file != null?new FileInputStream(this.file):new ByteArrayInputStream(this.memory.getBuffer(), 0, this.memory.getCount()));
   }

   public synchronized void reset() {
      boolean var7 = false;

      try {
         var7 = true;
         this.close();
         var7 = false;
      } finally {
         if(var7) {
            if(this.memory == null) {
               this.memory = new FileBackedOutputStream$MemoryOutput((FileBackedOutputStream$1)null);
            } else {
               this.memory.reset();
            }

            this.out = this.memory;
            if(this.file != null) {
               File var4 = this.file;
               this.file = null;
               if(!var4.delete()) {
                  String var5 = String.valueOf(var4);
                  throw new IOException((new StringBuilder(18 + String.valueOf(var5).length())).append("Could not delete: ").append(var5).toString());
               }
            }

         }
      }

      if(this.memory == null) {
         this.memory = new FileBackedOutputStream$MemoryOutput((FileBackedOutputStream$1)null);
      } else {
         this.memory.reset();
      }

      this.out = this.memory;
      if(this.file != null) {
         File var1 = this.file;
         this.file = null;
         if(!var1.delete()) {
            String var2 = String.valueOf(var1);
            throw new IOException((new StringBuilder(18 + String.valueOf(var2).length())).append("Could not delete: ").append(var2).toString());
         }
      }

   }

   public synchronized void write(int var1) {
      this.update(1);
      this.out.write(var1);
   }

   public synchronized void write(byte[] var1) {
      this.write(var1, 0, var1.length);
   }

   public synchronized void write(byte[] var1, int var2, int var3) {
      this.update(var3);
      this.out.write(var1, var2, var3);
   }

   public synchronized void close() {
      this.out.close();
   }

   public synchronized void flush() {
      this.out.flush();
   }

   private void update(int var1) {
      if(this.file == null && this.memory.getCount() + var1 > this.fileThreshold) {
         File var2 = File.createTempFile("FileBackedOutputStream", (String)null);
         if(this.resetOnFinalize) {
            var2.deleteOnExit();
         }

         FileOutputStream var3 = new FileOutputStream(var2);
         var3.write(this.memory.getBuffer(), 0, this.memory.getCount());
         var3.flush();
         this.out = var3;
         this.file = var2;
         this.memory = null;
      }

   }

   // $FF: synthetic method
   static InputStream access$100(FileBackedOutputStream var0) {
      return var0.openInputStream();
   }
}
