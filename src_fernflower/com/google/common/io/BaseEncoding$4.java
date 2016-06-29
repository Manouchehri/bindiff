package com.google.common.io;

final class BaseEncoding$4 implements Appendable {
   int charsUntilSeparator;
   // $FF: synthetic field
   final int val$afterEveryChars;
   // $FF: synthetic field
   final Appendable val$delegate;
   // $FF: synthetic field
   final String val$separator;

   BaseEncoding$4(int var1, Appendable var2, String var3) {
      this.val$afterEveryChars = var1;
      this.val$delegate = var2;
      this.val$separator = var3;
      this.charsUntilSeparator = this.val$afterEveryChars;
   }

   public Appendable append(char var1) {
      if(this.charsUntilSeparator == 0) {
         this.val$delegate.append(this.val$separator);
         this.charsUntilSeparator = this.val$afterEveryChars;
      }

      this.val$delegate.append(var1);
      --this.charsUntilSeparator;
      return this;
   }

   public Appendable append(CharSequence var1, int var2, int var3) {
      throw new UnsupportedOperationException();
   }

   public Appendable append(CharSequence var1) {
      throw new UnsupportedOperationException();
   }
}
