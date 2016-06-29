package com.google.protobuf;

import java.io.IOException;

public class TextFormat$ParseException extends IOException {
   private static final long serialVersionUID = 3196188060225107702L;
   private final int line;
   private final int column;

   public TextFormat$ParseException(String var1) {
      this(-1, -1, var1);
   }

   public TextFormat$ParseException(int var1, int var2, String var3) {
      String var4 = String.valueOf(String.valueOf(Integer.toString(var1)));
      String var6 = String.valueOf(String.valueOf(var3));
      super((new StringBuilder(14 + var4.length() + var6.length())).append(var4).append(":").append(var2).append(": ").append(var6).toString());
      this.line = var1;
      this.column = var2;
   }

   public int getLine() {
      return this.line;
   }

   public int getColumn() {
      return this.column;
   }
}
