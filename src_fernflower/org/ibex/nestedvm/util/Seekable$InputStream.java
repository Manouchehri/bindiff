package org.ibex.nestedvm.util;

import java.io.IOException;
import java.io.InputStream;
import org.ibex.nestedvm.util.Seekable;

public class Seekable$InputStream extends Seekable {
   private byte[] buffer = new byte[4096];
   private int bytesRead = 0;
   private boolean eof = false;
   private int pos;
   private InputStream is;

   public Seekable$InputStream(InputStream var1) {
      this.is = var1;
   }

   public int read(byte[] var1, int var2, int var3) {
      if(this.pos >= this.bytesRead && !this.eof) {
         this.readTo(this.pos + 1);
      }

      var3 = Math.min(var3, this.bytesRead - this.pos);
      if(var3 <= 0) {
         return -1;
      } else {
         System.arraycopy(this.buffer, this.pos, var1, var2, var3);
         this.pos += var3;
         return var3;
      }
   }

   private void readTo(int var1) {
      if(var1 >= this.buffer.length) {
         byte[] var2 = new byte[Math.max(this.buffer.length + Math.min(this.buffer.length, 65536), var1)];
         System.arraycopy(this.buffer, 0, var2, 0, this.bytesRead);
         this.buffer = var2;
      }

      while(this.bytesRead < var1) {
         int var3 = this.is.read(this.buffer, this.bytesRead, this.buffer.length - this.bytesRead);
         if(var3 == -1) {
            this.eof = true;
            break;
         }

         this.bytesRead += var3;
      }

   }

   public int length() {
      while(!this.eof) {
         this.readTo(this.bytesRead + 4096);
      }

      return this.bytesRead;
   }

   public int write(byte[] var1, int var2, int var3) {
      throw new IOException("read-only");
   }

   public void seek(int var1) {
      this.pos = var1;
   }

   public int pos() {
      return this.pos;
   }

   public void close() {
      this.is.close();
   }
}
