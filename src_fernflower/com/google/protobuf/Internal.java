package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.Utf8;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Internal {
   protected static final Charset UTF_8 = Charset.forName("UTF-8");
   protected static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
   private static final int DEFAULT_BUFFER_SIZE = 4096;
   public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
   public static final ByteBuffer EMPTY_BYTE_BUFFER;
   public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;

   public static String stringDefaultValue(String var0) {
      return new String(var0.getBytes(ISO_8859_1), UTF_8);
   }

   public static ByteString bytesDefaultValue(String var0) {
      return ByteString.copyFrom(var0.getBytes(ISO_8859_1));
   }

   public static byte[] byteArrayDefaultValue(String var0) {
      return var0.getBytes(ISO_8859_1);
   }

   public static ByteBuffer byteBufferDefaultValue(String var0) {
      return ByteBuffer.wrap(byteArrayDefaultValue(var0));
   }

   public static ByteBuffer copyByteBuffer(ByteBuffer var0) {
      ByteBuffer var1 = var0.duplicate();
      var1.clear();
      ByteBuffer var2 = ByteBuffer.allocate(var1.capacity());
      var2.put(var1);
      var2.clear();
      return var2;
   }

   public static boolean isValidUtf8(ByteString var0) {
      return var0.isValidUtf8();
   }

   public static boolean isValidUtf8(byte[] var0) {
      return Utf8.isValidUtf8(var0);
   }

   public static byte[] toByteArray(String var0) {
      return var0.getBytes(UTF_8);
   }

   public static String toStringUtf8(byte[] var0) {
      return new String(var0, UTF_8);
   }

   public static int hashLong(long var0) {
      return (int)(var0 ^ var0 >>> 32);
   }

   public static int hashBoolean(boolean var0) {
      return var0?1231:1237;
   }

   public static int hashEnum(Internal$EnumLite var0) {
      return var0.getNumber();
   }

   public static int hashEnumList(List var0) {
      int var1 = 1;

      Internal$EnumLite var3;
      for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 = 31 * var1 + hashEnum(var3)) {
         var3 = (Internal$EnumLite)var2.next();
      }

      return var1;
   }

   public static boolean equals(List var0, List var1) {
      if(var0.size() != var1.size()) {
         return false;
      } else {
         for(int var2 = 0; var2 < var0.size(); ++var2) {
            if(!Arrays.equals((byte[])var0.get(var2), (byte[])var1.get(var2))) {
               return false;
            }
         }

         return true;
      }
   }

   public static int hashCode(List var0) {
      int var1 = 1;

      byte[] var3;
      for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 = 31 * var1 + hashCode(var3)) {
         var3 = (byte[])var2.next();
      }

      return var1;
   }

   public static int hashCode(byte[] var0) {
      return LiteralByteString.hashCode(var0);
   }

   public static boolean equalsByteBuffer(ByteBuffer var0, ByteBuffer var1) {
      return var0.capacity() != var1.capacity()?false:var0.duplicate().clear().equals(var1.duplicate().clear());
   }

   public static boolean equalsByteBuffer(List var0, List var1) {
      if(var0.size() != var1.size()) {
         return false;
      } else {
         for(int var2 = 0; var2 < var0.size(); ++var2) {
            if(!equalsByteBuffer((ByteBuffer)var0.get(var2), (ByteBuffer)var1.get(var2))) {
               return false;
            }
         }

         return true;
      }
   }

   public static int hashCodeByteBuffer(List var0) {
      int var1 = 1;

      ByteBuffer var3;
      for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 = 31 * var1 + hashCodeByteBuffer(var3)) {
         var3 = (ByteBuffer)var2.next();
      }

      return var1;
   }

   public static int hashCodeByteBuffer(ByteBuffer var0) {
      int var1;
      if(var0.hasArray()) {
         var1 = LiteralByteString.hashCode(var0.capacity(), var0.array(), var0.arrayOffset(), var0.capacity());
         return var1 == 0?1:var1;
      } else {
         var1 = var0.capacity() > 4096?4096:var0.capacity();
         byte[] var2 = new byte[var1];
         ByteBuffer var3 = var0.duplicate();
         var3.clear();

         int var4;
         int var5;
         for(var4 = var0.capacity(); var3.remaining() > 0; var4 = LiteralByteString.hashCode(var4, var2, 0, var5)) {
            var5 = var3.remaining() <= var1?var3.remaining():var1;
            var3.get(var2, 0, var5);
         }

         return var4 == 0?1:var4;
      }
   }

   static {
      EMPTY_BYTE_BUFFER = ByteBuffer.wrap(EMPTY_BYTE_ARRAY);
      EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(EMPTY_BYTE_ARRAY);
   }
}
