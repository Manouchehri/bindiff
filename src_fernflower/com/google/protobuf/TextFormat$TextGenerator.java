package com.google.protobuf;

import com.google.protobuf.TextFormat$1;

final class TextFormat$TextGenerator {
   private final Appendable output;
   private final StringBuilder indent;
   private boolean atStartOfLine;

   private TextFormat$TextGenerator(Appendable var1) {
      this.indent = new StringBuilder();
      this.atStartOfLine = true;
      this.output = var1;
   }

   public void indent() {
      this.indent.append("  ");
   }

   public void outdent() {
      int var1 = this.indent.length();
      if(var1 == 0) {
         throw new IllegalArgumentException(" Outdent() without matching Indent().");
      } else {
         this.indent.delete(var1 - 2, var1);
      }
   }

   public void print(CharSequence var1) {
      int var2 = var1.length();
      int var3 = 0;

      for(int var4 = 0; var4 < var2; ++var4) {
         if(var1.charAt(var4) == 10) {
            this.write(var1.subSequence(var3, var4 + 1));
            var3 = var4 + 1;
            this.atStartOfLine = true;
         }
      }

      this.write(var1.subSequence(var3, var2));
   }

   private void write(CharSequence var1) {
      if(var1.length() != 0) {
         if(this.atStartOfLine) {
            this.atStartOfLine = false;
            this.output.append(this.indent);
         }

         this.output.append(var1);
      }
   }

   // $FF: synthetic method
   TextFormat$TextGenerator(Appendable var1, TextFormat$1 var2) {
      this(var1);
   }
}
