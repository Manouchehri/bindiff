package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.math.IntMath;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;

final class BaseEncoding$SeparatedBaseEncoding extends BaseEncoding {
   private final BaseEncoding delegate;
   private final String separator;
   private final int afterEveryChars;
   private final CharMatcher separatorChars;

   BaseEncoding$SeparatedBaseEncoding(BaseEncoding var1, String var2, int var3) {
      this.delegate = (BaseEncoding)Preconditions.checkNotNull(var1);
      this.separator = (String)Preconditions.checkNotNull(var2);
      this.afterEveryChars = var3;
      Preconditions.checkArgument(var3 > 0, "Cannot add a separator after every %s chars", new Object[]{Integer.valueOf(var3)});
      this.separatorChars = CharMatcher.anyOf(var2).precomputed();
   }

   CharMatcher padding() {
      return this.delegate.padding();
   }

   int maxEncodedSize(int var1) {
      int var2 = this.delegate.maxEncodedSize(var1);
      return var2 + this.separator.length() * IntMath.divide(Math.max(0, var2 - 1), this.afterEveryChars, RoundingMode.FLOOR);
   }

   @GwtIncompatible("Writer,OutputStream")
   public OutputStream encodingStream(Writer var1) {
      return this.delegate.encodingStream(separatingWriter(var1, this.separator, this.afterEveryChars));
   }

   void encodeTo(Appendable var1, byte[] var2, int var3, int var4) {
      this.delegate.encodeTo(separatingAppendable(var1, this.separator, this.afterEveryChars), var2, var3, var4);
   }

   int maxDecodedSize(int var1) {
      return this.delegate.maxDecodedSize(var1);
   }

   int decodeTo(byte[] var1, CharSequence var2) {
      return this.delegate.decodeTo(var1, this.separatorChars.removeFrom(var2));
   }

   @GwtIncompatible("Reader,InputStream")
   public InputStream decodingStream(Reader var1) {
      return this.delegate.decodingStream(ignoringReader(var1, this.separatorChars));
   }

   public BaseEncoding omitPadding() {
      return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
   }

   public BaseEncoding withPadChar(char var1) {
      return this.delegate.withPadChar(var1).withSeparator(this.separator, this.afterEveryChars);
   }

   public BaseEncoding withSeparator(String var1, int var2) {
      throw new UnsupportedOperationException("Already have a separator");
   }

   public BaseEncoding upperCase() {
      return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
   }

   public BaseEncoding lowerCase() {
      return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
   }

   public String toString() {
      String var1 = String.valueOf(this.delegate.toString());
      String var2 = this.separator;
      int var3 = this.afterEveryChars;
      return (new StringBuilder(31 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(".withSeparator(\"").append(var2).append("\", ").append(var3).append(")").toString();
   }
}
