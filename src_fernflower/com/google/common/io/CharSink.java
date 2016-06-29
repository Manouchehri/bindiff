package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.CharStreams;
import com.google.common.io.Closer;
import java.io.BufferedWriter;
import java.io.Writer;
import java.util.Iterator;

public abstract class CharSink {
   public abstract Writer openStream();

   public Writer openBufferedStream() {
      Writer var1 = this.openStream();
      return var1 instanceof BufferedWriter?(BufferedWriter)var1:new BufferedWriter(var1);
   }

   public void write(CharSequence var1) {
      Preconditions.checkNotNull(var1);
      Closer var2 = Closer.create();

      try {
         Writer var3 = (Writer)var2.register(this.openStream());
         var3.append(var1);
         var3.flush();
      } catch (Throwable var7) {
         throw var2.rethrow(var7);
      } finally {
         var2.close();
      }

   }

   public void writeLines(Iterable var1) {
      this.writeLines(var1, System.getProperty("line.separator"));
   }

   public void writeLines(Iterable var1, String var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      Closer var3 = Closer.create();

      try {
         Writer var4 = (Writer)var3.register(this.openBufferedStream());
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            CharSequence var6 = (CharSequence)var5.next();
            var4.append(var6).append(var2);
         }

         var4.flush();
      } catch (Throwable var10) {
         throw var3.rethrow(var10);
      } finally {
         var3.close();
      }
   }

   public long writeFrom(Readable var1) {
      Preconditions.checkNotNull(var1);
      Closer var2 = Closer.create();

      long var6;
      try {
         Writer var3 = (Writer)var2.register(this.openStream());
         long var4 = CharStreams.copy(var1, var3);
         var3.flush();
         var6 = var4;
      } catch (Throwable var11) {
         throw var2.rethrow(var11);
      } finally {
         var2.close();
      }

      return var6;
   }
}
