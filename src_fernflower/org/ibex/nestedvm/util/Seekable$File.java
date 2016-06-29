package org.ibex.nestedvm.util;

import java.io.File;
import java.io.RandomAccessFile;
import org.ibex.nestedvm.util.Platform;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$Lock;

public class Seekable$File extends Seekable {
   private final File file;
   private final RandomAccessFile raf;

   public Seekable$File(String var1) {
      this(var1, false);
   }

   public Seekable$File(String var1, boolean var2) {
      this(new File(var1), var2, false);
   }

   public Seekable$File(File var1, boolean var2, boolean var3) {
      this.file = var1;
      String var4 = var2?"rw":"r";
      this.raf = new RandomAccessFile(var1, var4);
      if(var3) {
         Platform.setFileLength(this.raf, 0);
      }

   }

   public int read(byte[] var1, int var2, int var3) {
      return this.raf.read(var1, var2, var3);
   }

   public int write(byte[] var1, int var2, int var3) {
      this.raf.write(var1, var2, var3);
      return var3;
   }

   public void sync() {
      this.raf.getFD().sync();
   }

   public void seek(int var1) {
      this.raf.seek((long)var1);
   }

   public int pos() {
      return (int)this.raf.getFilePointer();
   }

   public int length() {
      return (int)this.raf.length();
   }

   public void close() {
      this.raf.close();
   }

   public void resize(long var1) {
      Platform.setFileLength(this.raf, (int)var1);
   }

   public boolean equals(Object var1) {
      return var1 != null && var1 instanceof Seekable$File && this.file.equals(((Seekable$File)var1).file);
   }

   public Seekable$Lock lock(long var1, long var3, boolean var5) {
      return Platform.lockFile(this, this.raf, var1, var3, var5);
   }
}
