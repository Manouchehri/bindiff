package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

final class CharSequenceReader extends Reader {
   private CharSequence seq;
   private int pos;
   private int mark;

   public CharSequenceReader(CharSequence var1) {
      this.seq = (CharSequence)Preconditions.checkNotNull(var1);
   }

   private void checkOpen() {
      if(this.seq == null) {
         throw new IOException("reader closed");
      }
   }

   private boolean hasRemaining() {
      return this.remaining() > 0;
   }

   private int remaining() {
      return this.seq.length() - this.pos;
   }

   public synchronized int read(CharBuffer var1) {
      Preconditions.checkNotNull(var1);
      this.checkOpen();
      if(!this.hasRemaining()) {
         return -1;
      } else {
         int var2 = Math.min(var1.remaining(), this.remaining());

         for(int var3 = 0; var3 < var2; ++var3) {
            var1.put(this.seq.charAt(this.pos++));
         }

         return var2;
      }
   }

   public synchronized int read() {
      this.checkOpen();
      return this.hasRemaining()?this.seq.charAt(this.pos++):-1;
   }

   public synchronized int read(char[] var1, int var2, int var3) {
      Preconditions.checkPositionIndexes(var2, var2 + var3, var1.length);
      this.checkOpen();
      if(!this.hasRemaining()) {
         return -1;
      } else {
         int var4 = Math.min(var3, this.remaining());

         for(int var5 = 0; var5 < var4; ++var5) {
            var1[var2 + var5] = this.seq.charAt(this.pos++);
         }

         return var4;
      }
   }

   public synchronized long skip(long var1) {
      Preconditions.checkArgument(var1 >= 0L, "n (%s) may not be negative", new Object[]{Long.valueOf(var1)});
      this.checkOpen();
      int var3 = (int)Math.min((long)this.remaining(), var1);
      this.pos += var3;
      return (long)var3;
   }

   public synchronized boolean ready() {
      this.checkOpen();
      return true;
   }

   public boolean markSupported() {
      return true;
   }

   public synchronized void mark(int var1) {
      Preconditions.checkArgument(var1 >= 0, "readAheadLimit (%s) may not be negative", new Object[]{Integer.valueOf(var1)});
      this.checkOpen();
      this.mark = this.pos;
   }

   public synchronized void reset() {
      this.checkOpen();
      this.pos = this.mark;
   }

   public synchronized void close() {
      this.seq = null;
   }
}
