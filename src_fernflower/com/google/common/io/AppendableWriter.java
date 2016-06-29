package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import javax.annotation.Nullable;

class AppendableWriter extends Writer {
   private final Appendable target;
   private boolean closed;

   AppendableWriter(Appendable var1) {
      this.target = (Appendable)Preconditions.checkNotNull(var1);
   }

   public void write(char[] var1, int var2, int var3) {
      this.checkNotClosed();
      this.target.append(new String(var1, var2, var3));
   }

   public void flush() {
      this.checkNotClosed();
      if(this.target instanceof Flushable) {
         ((Flushable)this.target).flush();
      }

   }

   public void close() {
      this.closed = true;
      if(this.target instanceof Closeable) {
         ((Closeable)this.target).close();
      }

   }

   public void write(int var1) {
      this.checkNotClosed();
      this.target.append((char)var1);
   }

   public void write(@Nullable String var1) {
      this.checkNotClosed();
      this.target.append(var1);
   }

   public void write(@Nullable String var1, int var2, int var3) {
      this.checkNotClosed();
      this.target.append(var1, var2, var2 + var3);
   }

   public Writer append(char var1) {
      this.checkNotClosed();
      this.target.append(var1);
      return this;
   }

   public Writer append(@Nullable CharSequence var1) {
      this.checkNotClosed();
      this.target.append(var1);
      return this;
   }

   public Writer append(@Nullable CharSequence var1, int var2, int var3) {
      this.checkNotClosed();
      this.target.append(var1, var2, var3);
      return this;
   }

   private void checkNotClosed() {
      if(this.closed) {
         throw new IOException("Cannot write to a closed writer.");
      }
   }
}
