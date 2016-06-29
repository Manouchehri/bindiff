package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding$1;
import com.google.common.io.BaseEncoding$2;
import com.google.common.io.BaseEncoding$3;
import com.google.common.io.BaseEncoding$4;
import com.google.common.io.BaseEncoding$5;
import com.google.common.io.BaseEncoding$Base16Encoding;
import com.google.common.io.BaseEncoding$Base64Encoding;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible(
   emulated = true
)
public abstract class BaseEncoding {
   private static final BaseEncoding BASE64 = new BaseEncoding$Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", Character.valueOf('='));
   private static final BaseEncoding BASE64_URL = new BaseEncoding$Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", Character.valueOf('='));
   private static final BaseEncoding BASE32 = new BaseEncoding$StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", Character.valueOf('='));
   private static final BaseEncoding BASE32_HEX = new BaseEncoding$StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", Character.valueOf('='));
   private static final BaseEncoding BASE16 = new BaseEncoding$Base16Encoding("base16()", "0123456789ABCDEF");

   public String encode(byte[] var1) {
      return this.encode(var1, 0, var1.length);
   }

   public final String encode(byte[] var1, int var2, int var3) {
      Preconditions.checkPositionIndexes(var2, var2 + var3, var1.length);
      StringBuilder var4 = new StringBuilder(this.maxEncodedSize(var3));

      try {
         this.encodeTo(var4, var1, var2, var3);
      } catch (IOException var6) {
         throw new AssertionError(var6);
      }

      return var4.toString();
   }

   @GwtIncompatible("Writer,OutputStream")
   public abstract OutputStream encodingStream(Writer var1);

   @GwtIncompatible("ByteSink,CharSink")
   public final ByteSink encodingSink(CharSink var1) {
      Preconditions.checkNotNull(var1);
      return new BaseEncoding$1(this, var1);
   }

   private static byte[] extract(byte[] var0, int var1) {
      if(var1 == var0.length) {
         return var0;
      } else {
         byte[] var2 = new byte[var1];
         System.arraycopy(var0, 0, var2, 0, var1);
         return var2;
      }
   }

   public final byte[] decode(CharSequence var1) {
      try {
         return this.decodeChecked(var1);
      } catch (BaseEncoding$DecodingException var3) {
         throw new IllegalArgumentException(var3);
      }
   }

   public final byte[] decodeChecked(CharSequence var1) {
      String var4 = this.padding().trimTrailingFrom(var1);
      byte[] var2 = new byte[this.maxDecodedSize(var4.length())];
      int var3 = this.decodeTo(var2, var4);
      return extract(var2, var3);
   }

   @GwtIncompatible("Reader,InputStream")
   public abstract InputStream decodingStream(Reader var1);

   @GwtIncompatible("ByteSource,CharSource")
   public final ByteSource decodingSource(CharSource var1) {
      Preconditions.checkNotNull(var1);
      return new BaseEncoding$2(this, var1);
   }

   abstract int maxEncodedSize(int var1);

   abstract void encodeTo(Appendable var1, byte[] var2, int var3, int var4);

   abstract int maxDecodedSize(int var1);

   abstract int decodeTo(byte[] var1, CharSequence var2);

   abstract CharMatcher padding();

   @CheckReturnValue
   public abstract BaseEncoding omitPadding();

   @CheckReturnValue
   public abstract BaseEncoding withPadChar(char var1);

   @CheckReturnValue
   public abstract BaseEncoding withSeparator(String var1, int var2);

   @CheckReturnValue
   public abstract BaseEncoding upperCase();

   @CheckReturnValue
   public abstract BaseEncoding lowerCase();

   public static BaseEncoding base64() {
      return BASE64;
   }

   public static BaseEncoding base64Url() {
      return BASE64_URL;
   }

   public static BaseEncoding base32() {
      return BASE32;
   }

   public static BaseEncoding base32Hex() {
      return BASE32_HEX;
   }

   public static BaseEncoding base16() {
      return BASE16;
   }

   @GwtIncompatible("Reader")
   static Reader ignoringReader(Reader var0, CharMatcher var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new BaseEncoding$3(var0, var1);
   }

   static Appendable separatingAppendable(Appendable var0, String var1, int var2) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(var2 > 0);
      return new BaseEncoding$4(var2, var0, var1);
   }

   @GwtIncompatible("Writer")
   static Writer separatingWriter(Writer var0, String var1, int var2) {
      Appendable var3 = separatingAppendable(var0, var1, var2);
      return new BaseEncoding$5(var3, var0);
   }
}
