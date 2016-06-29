package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Writer;

final class CharStreams$NullWriter extends Writer {
   private static final CharStreams$NullWriter INSTANCE = new CharStreams$NullWriter();

   public void write(int var1) {
   }

   public void write(char[] var1) {
      Preconditions.checkNotNull(var1);
   }

   public void write(char[] var1, int var2, int var3) {
      Preconditions.checkPositionIndexes(var2, var2 + var3, var1.length);
   }

   public void write(String var1) {
      Preconditions.checkNotNull(var1);
   }

   public void write(String var1, int var2, int var3) {
      Preconditions.checkPositionIndexes(var2, var2 + var3, var1.length());
   }

   public Writer append(CharSequence var1) {
      Preconditions.checkNotNull(var1);
      return this;
   }

   public Writer append(CharSequence var1, int var2, int var3) {
      Preconditions.checkPositionIndexes(var2, var3, var1.length());
      return this;
   }

   public Writer append(char var1) {
      return this;
   }

   public void flush() {
   }

   public void close() {
   }

   public String toString() {
      return "CharStreams.nullWriter()";
   }

   // $FF: synthetic method
   static CharStreams$NullWriter access$000() {
      return INSTANCE;
   }
}
