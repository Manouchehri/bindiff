package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.io.AppendableWriter;
import com.google.common.io.CharStreams$1;
import com.google.common.io.CharStreams$NullWriter;
import com.google.common.io.LineProcessor;
import com.google.common.io.LineReader;
import java.io.EOFException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

@Beta
public final class CharStreams {
   private static final int BUF_SIZE = 2048;

   public static long copy(Readable var0, Appendable var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      CharBuffer var2 = CharBuffer.allocate(2048);
      long var3 = 0L;

      while(var0.read(var2) != -1) {
         var2.flip();
         var1.append(var2);
         var3 += (long)var2.remaining();
         var2.clear();
      }

      return var3;
   }

   public static String toString(Readable var0) {
      return toStringBuilder(var0).toString();
   }

   private static StringBuilder toStringBuilder(Readable var0) {
      StringBuilder var1 = new StringBuilder();
      copy(var0, var1);
      return var1;
   }

   public static List readLines(Readable var0) {
      ArrayList var1 = new ArrayList();
      LineReader var2 = new LineReader(var0);

      String var3;
      while((var3 = var2.readLine()) != null) {
         var1.add(var3);
      }

      return var1;
   }

   public static Object readLines(Readable var0, LineProcessor var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      LineReader var2 = new LineReader(var0);

      String var3;
      while((var3 = var2.readLine()) != null && var1.processLine(var3)) {
         ;
      }

      return var1.getResult();
   }

   public static void skipFully(Reader var0, long var1) {
      Preconditions.checkNotNull(var0);

      while(var1 > 0L) {
         long var3 = var0.skip(var1);
         if(var3 == 0L) {
            throw new EOFException();
         }

         var1 -= var3;
      }

   }

   public static Writer nullWriter() {
      return CharStreams$NullWriter.access$000();
   }

   public static Writer asWriter(Appendable var0) {
      return (Writer)(var0 instanceof Writer?(Writer)var0:new AppendableWriter(var0));
   }

   static Reader asReader(Readable var0) {
      Preconditions.checkNotNull(var0);
      return (Reader)(var0 instanceof Reader?(Reader)var0:new CharStreams$1(var0));
   }
}
