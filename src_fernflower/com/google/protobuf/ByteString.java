package com.google.protobuf;

import com.google.protobuf.ByteString$1;
import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.ByteString$CodedBuilder;
import com.google.protobuf.ByteString$Output;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Internal;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.RopeByteString;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class ByteString implements Serializable, Iterable {
   static final int CONCATENATE_BY_COPY_SIZE = 128;
   static final int MIN_READ_FROM_CHUNK_SIZE = 256;
   static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
   public static final ByteString EMPTY = new LiteralByteString(new byte[0]);

   public abstract byte byteAt(int var1);

   public abstract ByteString$ByteIterator iterator();

   public abstract int size();

   public boolean isEmpty() {
      return this.size() == 0;
   }

   public ByteString substring(int var1) {
      return this.substring(var1, this.size());
   }

   public abstract ByteString substring(int var1, int var2);

   public boolean startsWith(ByteString var1) {
      return this.size() >= var1.size() && this.substring(0, var1.size()).equals(var1);
   }

   public boolean endsWith(ByteString var1) {
      return this.size() >= var1.size() && this.substring(this.size() - var1.size()).equals(var1);
   }

   public static ByteString copyFrom(byte[] var0, int var1, int var2) {
      byte[] var3 = new byte[var2];
      System.arraycopy(var0, var1, var3, 0, var2);
      return new LiteralByteString(var3);
   }

   public static ByteString copyFrom(byte[] var0) {
      return copyFrom(var0, 0, var0.length);
   }

   public static ByteString copyFrom(ByteBuffer var0, int var1) {
      byte[] var2 = new byte[var1];
      var0.get(var2);
      return new LiteralByteString(var2);
   }

   public static ByteString copyFrom(ByteBuffer var0) {
      return copyFrom(var0, var0.remaining());
   }

   public static ByteString copyFrom(String var0, String var1) {
      return new LiteralByteString(var0.getBytes(var1));
   }

   public static ByteString copyFrom(String var0, Charset var1) {
      return new LiteralByteString(var0.getBytes(var1));
   }

   public static ByteString copyFromUtf8(String var0) {
      return new LiteralByteString(var0.getBytes(Internal.UTF_8));
   }

   public static ByteString readFrom(InputStream var0) {
      return readFrom(var0, 256, 8192);
   }

   public static ByteString readFrom(InputStream var0, int var1) {
      return readFrom(var0, var1, var1);
   }

   public static ByteString readFrom(InputStream var0, int var1, int var2) {
      ArrayList var3 = new ArrayList();
      int var4 = var1;

      while(true) {
         ByteString var5 = readChunk(var0, var4);
         if(var5 == null) {
            return copyFrom((Iterable)var3);
         }

         var3.add(var5);
         var4 = Math.min(var4 * 2, var2);
      }
   }

   private static ByteString readChunk(InputStream var0, int var1) {
      byte[] var2 = new byte[var1];

      int var3;
      int var4;
      for(var3 = 0; var3 < var1; var3 += var4) {
         var4 = var0.read(var2, var3, var1 - var3);
         if(var4 == -1) {
            break;
         }
      }

      return var3 == 0?null:copyFrom(var2, 0, var3);
   }

   public ByteString concat(ByteString var1) {
      int var2 = this.size();
      int var3 = var1.size();
      if((long)var2 + (long)var3 >= 2147483647L) {
         throw new IllegalArgumentException((new StringBuilder(53)).append("ByteString would be too long: ").append(var2).append("+").append(var3).toString());
      } else {
         return RopeByteString.concatenate(this, var1);
      }
   }

   public static ByteString copyFrom(Iterable var0) {
      Object var1;
      if(!(var0 instanceof Collection)) {
         var1 = new ArrayList();
         Iterator var2 = var0.iterator();

         while(var2.hasNext()) {
            ByteString var3 = (ByteString)var2.next();
            ((Collection)var1).add(var3);
         }
      } else {
         var1 = (Collection)var0;
      }

      ByteString var4;
      if(((Collection)var1).isEmpty()) {
         var4 = EMPTY;
      } else {
         var4 = balancedConcat(((Collection)var1).iterator(), ((Collection)var1).size());
      }

      return var4;
   }

   private static ByteString balancedConcat(Iterator var0, int var1) {
      assert var1 >= 1;

      ByteString var2;
      if(var1 == 1) {
         var2 = (ByteString)var0.next();
      } else {
         int var3 = var1 >>> 1;
         ByteString var4 = balancedConcat(var0, var3);
         ByteString var5 = balancedConcat(var0, var1 - var3);
         var2 = var4.concat(var5);
      }

      return var2;
   }

   public void copyTo(byte[] var1, int var2) {
      this.copyTo(var1, 0, var2, this.size());
   }

   public void copyTo(byte[] var1, int var2, int var3, int var4) {
      if(var2 < 0) {
         throw new IndexOutOfBoundsException((new StringBuilder(30)).append("Source offset < 0: ").append(var2).toString());
      } else if(var3 < 0) {
         throw new IndexOutOfBoundsException((new StringBuilder(30)).append("Target offset < 0: ").append(var3).toString());
      } else if(var4 < 0) {
         throw new IndexOutOfBoundsException((new StringBuilder(23)).append("Length < 0: ").append(var4).toString());
      } else {
         int var5;
         if(var2 + var4 > this.size()) {
            var5 = var2 + var4;
            throw new IndexOutOfBoundsException((new StringBuilder(34)).append("Source end offset < 0: ").append(var5).toString());
         } else if(var3 + var4 > var1.length) {
            var5 = var3 + var4;
            throw new IndexOutOfBoundsException((new StringBuilder(34)).append("Target end offset < 0: ").append(var5).toString());
         } else {
            if(var4 > 0) {
               this.copyToInternal(var1, var2, var3, var4);
            }

         }
      }
   }

   protected abstract void copyToInternal(byte[] var1, int var2, int var3, int var4);

   public abstract void copyTo(ByteBuffer var1);

   public byte[] toByteArray() {
      int var1 = this.size();
      if(var1 == 0) {
         return Internal.EMPTY_BYTE_ARRAY;
      } else {
         byte[] var2 = new byte[var1];
         this.copyToInternal(var2, 0, 0, var1);
         return var2;
      }
   }

   public abstract void writeTo(OutputStream var1);

   void writeTo(OutputStream var1, int var2, int var3) {
      if(var2 < 0) {
         throw new IndexOutOfBoundsException((new StringBuilder(30)).append("Source offset < 0: ").append(var2).toString());
      } else if(var3 < 0) {
         throw new IndexOutOfBoundsException((new StringBuilder(23)).append("Length < 0: ").append(var3).toString());
      } else if(var2 + var3 > this.size()) {
         int var4 = var2 + var3;
         throw new IndexOutOfBoundsException((new StringBuilder(39)).append("Source end offset exceeded: ").append(var4).toString());
      } else {
         if(var3 > 0) {
            this.writeToInternal(var1, var2, var3);
         }

      }
   }

   abstract void writeToInternal(OutputStream var1, int var2, int var3);

   public abstract ByteBuffer asReadOnlyByteBuffer();

   public abstract List asReadOnlyByteBufferList();

   public String toString(String var1) {
      try {
         return this.toString(Charset.forName(var1));
      } catch (UnsupportedCharsetException var4) {
         UnsupportedEncodingException var3 = new UnsupportedEncodingException(var1);
         var3.initCause(var4);
         throw var3;
      }
   }

   public String toString(Charset var1) {
      return this.size() == 0?"":this.toStringInternal(var1);
   }

   protected abstract String toStringInternal(Charset var1);

   public String toStringUtf8() {
      return this.toString(Internal.UTF_8);
   }

   public abstract boolean isValidUtf8();

   protected abstract int partialIsValidUtf8(int var1, int var2, int var3);

   public abstract boolean equals(Object var1);

   public abstract int hashCode();

   public abstract InputStream newInput();

   public abstract CodedInputStream newCodedInput();

   public static ByteString$Output newOutput(int var0) {
      return new ByteString$Output(var0);
   }

   public static ByteString$Output newOutput() {
      return new ByteString$Output(128);
   }

   static ByteString$CodedBuilder newCodedBuilder(int var0) {
      return new ByteString$CodedBuilder(var0, (ByteString$1)null);
   }

   protected abstract int getTreeDepth();

   protected abstract boolean isBalanced();

   protected abstract int peekCachedHashCode();

   protected abstract int partialHash(int var1, int var2, int var3);

   public String toString() {
      return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(this.size())});
   }
}
