package com.google.protobuf;

import com.google.protobuf.BoundedByteString;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream$RefillCallback;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.Utf8;
import com.google.protobuf.WireFormat;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class CodedInputStream {
   private final byte[] buffer;
   private final boolean bufferIsImmutable;
   private int bufferSize;
   private int bufferSizeAfterLimit;
   private int bufferPos;
   private final InputStream input;
   private int lastTag;
   private boolean enableAliasing = false;
   private int totalBytesRetired;
   private int currentLimit = Integer.MAX_VALUE;
   private int recursionDepth;
   private int recursionLimit = 100;
   private int sizeLimit = 67108864;
   private static final int DEFAULT_RECURSION_LIMIT = 100;
   private static final int DEFAULT_SIZE_LIMIT = 67108864;
   private static final int BUFFER_SIZE = 4096;
   private CodedInputStream$RefillCallback refillCallback = null;

   public static CodedInputStream newInstance(InputStream var0) {
      return new CodedInputStream(var0);
   }

   public static CodedInputStream newInstance(byte[] var0) {
      return newInstance(var0, 0, var0.length);
   }

   public static CodedInputStream newInstance(byte[] var0, int var1, int var2) {
      CodedInputStream var3 = new CodedInputStream(var0, var1, var2);

      try {
         var3.pushLimit(var2);
         return var3;
      } catch (InvalidProtocolBufferException var5) {
         throw new IllegalArgumentException(var5);
      }
   }

   public static CodedInputStream newInstance(ByteBuffer var0) {
      if(var0.hasArray()) {
         return newInstance(var0.array(), var0.arrayOffset() + var0.position(), var0.remaining());
      } else {
         ByteBuffer var1 = var0.duplicate();
         byte[] var2 = new byte[var1.remaining()];
         var1.get(var2);
         return newInstance(var2);
      }
   }

   static CodedInputStream newInstance(LiteralByteString var0) {
      CodedInputStream var1 = new CodedInputStream(var0);

      try {
         var1.pushLimit(var0.size());
         return var1;
      } catch (InvalidProtocolBufferException var3) {
         throw new IllegalArgumentException(var3);
      }
   }

   public int readTag() {
      if(this.isAtEnd()) {
         this.lastTag = 0;
         return 0;
      } else {
         this.lastTag = this.readRawVarint32();
         if(WireFormat.getTagFieldNumber(this.lastTag) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
         } else {
            return this.lastTag;
         }
      }
   }

   public void checkLastTagWas(int var1) {
      if(this.lastTag != var1) {
         throw InvalidProtocolBufferException.invalidEndTag();
      }
   }

   public int getLastTag() {
      return this.lastTag;
   }

   public boolean skipField(int var1) {
      switch(WireFormat.getTagWireType(var1)) {
      case 0:
         this.skipRawVarint();
         return true;
      case 1:
         this.skipRawBytes(8);
         return true;
      case 2:
         this.skipRawBytes(this.readRawVarint32());
         return true;
      case 3:
         this.skipMessage();
         this.checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(var1), 4));
         return true;
      case 4:
         return false;
      case 5:
         this.skipRawBytes(4);
         return true;
      default:
         throw InvalidProtocolBufferException.invalidWireType();
      }
   }

   public boolean skipField(int var1, CodedOutputStream var2) {
      int var3;
      long var6;
      switch(WireFormat.getTagWireType(var1)) {
      case 0:
         var6 = this.readInt64();
         var2.writeRawVarint32(var1);
         var2.writeUInt64NoTag(var6);
         return true;
      case 1:
         var6 = this.readRawLittleEndian64();
         var2.writeRawVarint32(var1);
         var2.writeFixed64NoTag(var6);
         return true;
      case 2:
         ByteString var5 = this.readBytes();
         var2.writeRawVarint32(var1);
         var2.writeBytesNoTag(var5);
         return true;
      case 3:
         var2.writeRawVarint32(var1);
         this.skipMessage(var2);
         var3 = WireFormat.makeTag(WireFormat.getTagFieldNumber(var1), 4);
         this.checkLastTagWas(var3);
         var2.writeRawVarint32(var3);
         return true;
      case 4:
         return false;
      case 5:
         var3 = this.readRawLittleEndian32();
         var2.writeRawVarint32(var1);
         var2.writeFixed32NoTag(var3);
         return true;
      default:
         throw InvalidProtocolBufferException.invalidWireType();
      }
   }

   public void skipMessage() {
      int var1;
      do {
         var1 = this.readTag();
      } while(var1 != 0 && this.skipField(var1));

   }

   public void skipMessage(CodedOutputStream var1) {
      int var2;
      do {
         var2 = this.readTag();
      } while(var2 != 0 && this.skipField(var2, var1));

   }

   public double readDouble() {
      return Double.longBitsToDouble(this.readRawLittleEndian64());
   }

   public float readFloat() {
      return Float.intBitsToFloat(this.readRawLittleEndian32());
   }

   public long readUInt64() {
      return this.readRawVarint64();
   }

   public long readInt64() {
      return this.readRawVarint64();
   }

   public int readInt32() {
      return this.readRawVarint32();
   }

   public long readFixed64() {
      return this.readRawLittleEndian64();
   }

   public int readFixed32() {
      return this.readRawLittleEndian32();
   }

   public boolean readBool() {
      return this.readRawVarint64() != 0L;
   }

   public String readString() {
      int var1 = this.readRawVarint32();
      if(var1 <= this.bufferSize - this.bufferPos && var1 > 0) {
         String var2 = new String(this.buffer, this.bufferPos, var1, Internal.UTF_8);
         this.bufferPos += var1;
         return var2;
      } else {
         return var1 == 0?"":new String(this.readRawBytesSlowPath(var1), Internal.UTF_8);
      }
   }

   public String readStringRequireUtf8() {
      int var1 = this.readRawVarint32();
      int var3 = this.bufferPos;
      byte[] var2;
      if(var1 <= this.bufferSize - var3 && var1 > 0) {
         var2 = this.buffer;
         this.bufferPos = var3 + var1;
      } else {
         if(var1 == 0) {
            return "";
         }

         var2 = this.readRawBytesSlowPath(var1);
         var3 = 0;
      }

      if(!Utf8.isValidUtf8(var2, var3, var3 + var1)) {
         throw InvalidProtocolBufferException.invalidUtf8();
      } else {
         return new String(var2, var3, var1, Internal.UTF_8);
      }
   }

   public void readGroup(int var1, MessageLite$Builder var2, ExtensionRegistryLite var3) {
      if(this.recursionDepth >= this.recursionLimit) {
         throw InvalidProtocolBufferException.recursionLimitExceeded();
      } else {
         ++this.recursionDepth;
         var2.mergeFrom(this, var3);
         this.checkLastTagWas(WireFormat.makeTag(var1, 4));
         --this.recursionDepth;
      }
   }

   public MessageLite readGroup(int var1, Parser var2, ExtensionRegistryLite var3) {
      if(this.recursionDepth >= this.recursionLimit) {
         throw InvalidProtocolBufferException.recursionLimitExceeded();
      } else {
         ++this.recursionDepth;
         MessageLite var4 = (MessageLite)var2.parsePartialFrom(this, var3);
         this.checkLastTagWas(WireFormat.makeTag(var1, 4));
         --this.recursionDepth;
         return var4;
      }
   }

   @Deprecated
   public void readUnknownGroup(int var1, MessageLite$Builder var2) {
      this.readGroup(var1, (MessageLite$Builder)var2, (ExtensionRegistryLite)null);
   }

   public void readMessage(MessageLite$Builder var1, ExtensionRegistryLite var2) {
      int var3 = this.readRawVarint32();
      if(this.recursionDepth >= this.recursionLimit) {
         throw InvalidProtocolBufferException.recursionLimitExceeded();
      } else {
         int var4 = this.pushLimit(var3);
         ++this.recursionDepth;
         var1.mergeFrom(this, var2);
         this.checkLastTagWas(0);
         --this.recursionDepth;
         this.popLimit(var4);
      }
   }

   public MessageLite readMessage(Parser var1, ExtensionRegistryLite var2) {
      int var3 = this.readRawVarint32();
      if(this.recursionDepth >= this.recursionLimit) {
         throw InvalidProtocolBufferException.recursionLimitExceeded();
      } else {
         int var4 = this.pushLimit(var3);
         ++this.recursionDepth;
         MessageLite var5 = (MessageLite)var1.parsePartialFrom(this, var2);
         this.checkLastTagWas(0);
         --this.recursionDepth;
         this.popLimit(var4);
         return var5;
      }
   }

   public ByteString readBytes() {
      int var1 = this.readRawVarint32();
      if(var1 <= this.bufferSize - this.bufferPos && var1 > 0) {
         Object var2 = this.bufferIsImmutable && this.enableAliasing?new BoundedByteString(this.buffer, this.bufferPos, var1):ByteString.copyFrom(this.buffer, this.bufferPos, var1);
         this.bufferPos += var1;
         return (ByteString)var2;
      } else {
         return (ByteString)(var1 == 0?ByteString.EMPTY:new LiteralByteString(this.readRawBytesSlowPath(var1)));
      }
   }

   public byte[] readByteArray() {
      int var1 = this.readRawVarint32();
      if(var1 <= this.bufferSize - this.bufferPos && var1 > 0) {
         byte[] var2 = Arrays.copyOfRange(this.buffer, this.bufferPos, this.bufferPos + var1);
         this.bufferPos += var1;
         return var2;
      } else {
         return this.readRawBytesSlowPath(var1);
      }
   }

   public ByteBuffer readByteBuffer() {
      int var1 = this.readRawVarint32();
      if(var1 <= this.bufferSize - this.bufferPos && var1 > 0) {
         ByteBuffer var2 = this.input == null && !this.bufferIsImmutable && this.enableAliasing?ByteBuffer.wrap(this.buffer, this.bufferPos, var1).slice():ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, this.bufferPos, this.bufferPos + var1));
         this.bufferPos += var1;
         return var2;
      } else {
         return var1 == 0?Internal.EMPTY_BYTE_BUFFER:ByteBuffer.wrap(this.readRawBytesSlowPath(var1));
      }
   }

   public int readUInt32() {
      return this.readRawVarint32();
   }

   public int readEnum() {
      return this.readRawVarint32();
   }

   public int readSFixed32() {
      return this.readRawLittleEndian32();
   }

   public long readSFixed64() {
      return this.readRawLittleEndian64();
   }

   public int readSInt32() {
      return decodeZigZag32(this.readRawVarint32());
   }

   public long readSInt64() {
      return decodeZigZag64(this.readRawVarint64());
   }

   public int readRawVarint32() {
      int var1;
      int var5;
      label47: {
         var1 = this.bufferPos;
         if(this.bufferSize != var1) {
            byte[] var2 = this.buffer;
            byte var3;
            if((var3 = var2[var1++]) >= 0) {
               this.bufferPos = var1;
               return var3;
            }

            if(this.bufferSize - var1 >= 9) {
               if((var5 = var3 ^ var2[var1++] << 7) < 0) {
                  var5 ^= -128;
                  break label47;
               }

               if((var5 ^= var2[var1++] << 14) >= 0) {
                  var5 ^= 16256;
                  break label47;
               }

               if((var5 ^= var2[var1++] << 21) < 0) {
                  var5 ^= -2080896;
                  break label47;
               }

               byte var4 = var2[var1++];
               var5 ^= var4 << 28;
               var5 ^= 266354560;
               if(var4 >= 0 || var2[var1++] >= 0 || var2[var1++] >= 0 || var2[var1++] >= 0 || var2[var1++] >= 0 || var2[var1++] >= 0) {
                  break label47;
               }
            }
         }

         return (int)this.readRawVarint64SlowPath();
      }

      this.bufferPos = var1;
      return var5;
   }

   private void skipRawVarint() {
      if(this.bufferSize - this.bufferPos >= 10) {
         byte[] var1 = this.buffer;
         int var2 = this.bufferPos;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1[var2++] >= 0) {
               this.bufferPos = var2;
               return;
            }
         }
      }

      this.skipRawVarintSlowPath();
   }

   private void skipRawVarintSlowPath() {
      for(int var1 = 0; var1 < 10; ++var1) {
         if(this.readRawByte() >= 0) {
            return;
         }
      }

      throw InvalidProtocolBufferException.malformedVarint();
   }

   static int readRawVarint32(InputStream var0) {
      int var1 = var0.read();
      if(var1 == -1) {
         throw InvalidProtocolBufferException.truncatedMessage();
      } else {
         return readRawVarint32(var1, var0);
      }
   }

   public static int readRawVarint32(int var0, InputStream var1) {
      if((var0 & 128) == 0) {
         return var0;
      } else {
         int var2 = var0 & 127;

         int var3;
         int var4;
         for(var3 = 7; var3 < 32; var3 += 7) {
            var4 = var1.read();
            if(var4 == -1) {
               throw InvalidProtocolBufferException.truncatedMessage();
            }

            var2 |= (var4 & 127) << var3;
            if((var4 & 128) == 0) {
               return var2;
            }
         }

         while(var3 < 64) {
            var4 = var1.read();
            if(var4 == -1) {
               throw InvalidProtocolBufferException.truncatedMessage();
            }

            if((var4 & 128) == 0) {
               return var2;
            }

            var3 += 7;
         }

         throw InvalidProtocolBufferException.malformedVarint();
      }
   }

   public long readRawVarint64() {
      int var1;
      long var3;
      label51: {
         var1 = this.bufferPos;
         if(this.bufferSize != var1) {
            byte[] var2 = this.buffer;
            byte var5;
            if((var5 = var2[var1++]) >= 0) {
               this.bufferPos = var1;
               return (long)var5;
            }

            if(this.bufferSize - var1 >= 9) {
               int var6;
               if((var6 = var5 ^ var2[var1++] << 7) < 0) {
                  var3 = (long)(var6 ^ -128);
                  break label51;
               }

               if((var6 ^= var2[var1++] << 14) >= 0) {
                  var3 = (long)(var6 ^ 16256);
                  break label51;
               }

               if((var6 ^= var2[var1++] << 21) < 0) {
                  var3 = (long)(var6 ^ -2080896);
                  break label51;
               }

               if((var3 = (long)var6 ^ (long)var2[var1++] << 28) >= 0L) {
                  var3 ^= 266354560L;
                  break label51;
               }

               if((var3 ^= (long)var2[var1++] << 35) < 0L) {
                  var3 ^= -34093383808L;
                  break label51;
               }

               if((var3 ^= (long)var2[var1++] << 42) >= 0L) {
                  var3 ^= 4363953127296L;
                  break label51;
               }

               if((var3 ^= (long)var2[var1++] << 49) < 0L) {
                  var3 ^= -558586000294016L;
                  break label51;
               }

               var3 ^= (long)var2[var1++] << 56;
               var3 ^= 71499008037633920L;
               if(var3 >= 0L || (long)var2[var1++] >= 0L) {
                  break label51;
               }
            }
         }

         return this.readRawVarint64SlowPath();
      }

      this.bufferPos = var1;
      return var3;
   }

   long readRawVarint64SlowPath() {
      long var1 = 0L;

      for(int var3 = 0; var3 < 64; var3 += 7) {
         byte var4 = this.readRawByte();
         var1 |= (long)(var4 & 127) << var3;
         if((var4 & 128) == 0) {
            return var1;
         }
      }

      throw InvalidProtocolBufferException.malformedVarint();
   }

   public int readRawLittleEndian32() {
      int var1 = this.bufferPos;
      if(this.bufferSize - var1 < 4) {
         this.refillBuffer(4);
         var1 = this.bufferPos;
      }

      byte[] var2 = this.buffer;
      this.bufferPos = var1 + 4;
      return var2[var1] & 255 | (var2[var1 + 1] & 255) << 8 | (var2[var1 + 2] & 255) << 16 | (var2[var1 + 3] & 255) << 24;
   }

   public long readRawLittleEndian64() {
      int var1 = this.bufferPos;
      if(this.bufferSize - var1 < 8) {
         this.refillBuffer(8);
         var1 = this.bufferPos;
      }

      byte[] var2 = this.buffer;
      this.bufferPos = var1 + 8;
      return (long)var2[var1] & 255L | ((long)var2[var1 + 1] & 255L) << 8 | ((long)var2[var1 + 2] & 255L) << 16 | ((long)var2[var1 + 3] & 255L) << 24 | ((long)var2[var1 + 4] & 255L) << 32 | ((long)var2[var1 + 5] & 255L) << 40 | ((long)var2[var1 + 6] & 255L) << 48 | ((long)var2[var1 + 7] & 255L) << 56;
   }

   public static int decodeZigZag32(int var0) {
      return var0 >>> 1 ^ -(var0 & 1);
   }

   public static long decodeZigZag64(long var0) {
      return var0 >>> 1 ^ -(var0 & 1L);
   }

   private CodedInputStream(byte[] var1, int var2, int var3) {
      this.buffer = var1;
      this.bufferSize = var2 + var3;
      this.bufferPos = var2;
      this.totalBytesRetired = -var2;
      this.input = null;
      this.bufferIsImmutable = false;
   }

   private CodedInputStream(InputStream var1) {
      this.buffer = new byte[4096];
      this.bufferSize = 0;
      this.bufferPos = 0;
      this.totalBytesRetired = 0;
      this.input = var1;
      this.bufferIsImmutable = false;
   }

   private CodedInputStream(LiteralByteString var1) {
      this.buffer = var1.bytes;
      this.bufferPos = var1.getOffsetIntoBytes();
      this.bufferSize = this.bufferPos + var1.size();
      this.totalBytesRetired = -this.bufferPos;
      this.input = null;
      this.bufferIsImmutable = true;
   }

   public void enableAliasing(boolean var1) {
      this.enableAliasing = var1;
   }

   public int setRecursionLimit(int var1) {
      if(var1 < 0) {
         throw new IllegalArgumentException((new StringBuilder(47)).append("Recursion limit cannot be negative: ").append(var1).toString());
      } else {
         int var2 = this.recursionLimit;
         this.recursionLimit = var1;
         return var2;
      }
   }

   public int setSizeLimit(int var1) {
      if(var1 < 0) {
         throw new IllegalArgumentException((new StringBuilder(42)).append("Size limit cannot be negative: ").append(var1).toString());
      } else {
         int var2 = this.sizeLimit;
         this.sizeLimit = var1;
         return var2;
      }
   }

   public void resetSizeCounter() {
      this.totalBytesRetired = -this.bufferPos;
   }

   public int pushLimit(int var1) {
      if(var1 < 0) {
         throw InvalidProtocolBufferException.negativeSize();
      } else {
         var1 += this.totalBytesRetired + this.bufferPos;
         int var2 = this.currentLimit;
         if(var1 > var2) {
            throw InvalidProtocolBufferException.truncatedMessage();
         } else {
            this.currentLimit = var1;
            this.recomputeBufferSizeAfterLimit();
            return var2;
         }
      }
   }

   private void recomputeBufferSizeAfterLimit() {
      this.bufferSize += this.bufferSizeAfterLimit;
      int var1 = this.totalBytesRetired + this.bufferSize;
      if(var1 > this.currentLimit) {
         this.bufferSizeAfterLimit = var1 - this.currentLimit;
         this.bufferSize -= this.bufferSizeAfterLimit;
      } else {
         this.bufferSizeAfterLimit = 0;
      }

   }

   public void popLimit(int var1) {
      this.currentLimit = var1;
      this.recomputeBufferSizeAfterLimit();
   }

   public int getBytesUntilLimit() {
      if(this.currentLimit == Integer.MAX_VALUE) {
         return -1;
      } else {
         int var1 = this.totalBytesRetired + this.bufferPos;
         return this.currentLimit - var1;
      }
   }

   public boolean isAtEnd() {
      return this.bufferPos == this.bufferSize && !this.tryRefillBuffer(1);
   }

   public int getTotalBytesRead() {
      return this.totalBytesRetired + this.bufferPos;
   }

   private void ensureAvailable(int var1) {
      if(this.bufferSize - this.bufferPos < var1) {
         this.refillBuffer(var1);
      }

   }

   private void refillBuffer(int var1) {
      if(!this.tryRefillBuffer(var1)) {
         throw InvalidProtocolBufferException.truncatedMessage();
      }
   }

   private boolean tryRefillBuffer(int var1) {
      if(this.bufferPos + var1 <= this.bufferSize) {
         throw new IllegalStateException((new StringBuilder(77)).append("refillBuffer() called when ").append(var1).append(" bytes were already available in buffer").toString());
      } else if(this.totalBytesRetired + this.bufferPos + var1 > this.currentLimit) {
         return false;
      } else {
         if(this.refillCallback != null) {
            this.refillCallback.onRefill();
         }

         if(this.input != null) {
            int var2 = this.bufferPos;
            if(var2 > 0) {
               if(this.bufferSize > var2) {
                  System.arraycopy(this.buffer, var2, this.buffer, 0, this.bufferSize - var2);
               }

               this.totalBytesRetired += var2;
               this.bufferSize -= var2;
               this.bufferPos = 0;
            }

            int var3 = this.input.read(this.buffer, this.bufferSize, this.buffer.length - this.bufferSize);
            if(var3 == 0 || var3 < -1 || var3 > this.buffer.length) {
               throw new IllegalStateException((new StringBuilder(102)).append("InputStream#read(byte[]) returned invalid result: ").append(var3).append("\nThe InputStream implementation is buggy.").toString());
            }

            if(var3 > 0) {
               this.bufferSize += var3;
               if(this.totalBytesRetired + var1 - this.sizeLimit > 0) {
                  throw InvalidProtocolBufferException.sizeLimitExceeded();
               }

               this.recomputeBufferSizeAfterLimit();
               return this.bufferSize >= var1?true:this.tryRefillBuffer(var1);
            }
         }

         return false;
      }
   }

   public byte readRawByte() {
      if(this.bufferPos == this.bufferSize) {
         this.refillBuffer(1);
      }

      return this.buffer[this.bufferPos++];
   }

   public byte[] readRawBytes(int var1) {
      int var2 = this.bufferPos;
      if(var1 <= this.bufferSize - var2 && var1 > 0) {
         this.bufferPos = var2 + var1;
         return Arrays.copyOfRange(this.buffer, var2, var2 + var1);
      } else {
         return this.readRawBytesSlowPath(var1);
      }
   }

   private byte[] readRawBytesSlowPath(int var1) {
      if(var1 <= 0) {
         if(var1 == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
         } else {
            throw InvalidProtocolBufferException.negativeSize();
         }
      } else if(this.totalBytesRetired + this.bufferPos + var1 > this.currentLimit) {
         this.skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
         throw InvalidProtocolBufferException.truncatedMessage();
      } else {
         int var3;
         if(var1 < 4096) {
            byte[] var10 = new byte[var1];
            var3 = this.bufferSize - this.bufferPos;
            System.arraycopy(this.buffer, this.bufferPos, var10, 0, var3);
            this.bufferPos = this.bufferSize;
            this.ensureAvailable(var1 - var3);
            System.arraycopy(this.buffer, 0, var10, var3, var1 - var3);
            this.bufferPos = var1 - var3;
            return var10;
         } else {
            int var2 = this.bufferPos;
            var3 = this.bufferSize;
            this.totalBytesRetired += this.bufferSize;
            this.bufferPos = 0;
            this.bufferSize = 0;
            int var4 = var1 - (var3 - var2);
            ArrayList var5 = new ArrayList();

            byte[] var6;
            int var7;
            while(var4 > 0) {
               var6 = new byte[Math.min(var4, 4096)];

               int var8;
               for(var7 = 0; var7 < var6.length; var7 += var8) {
                  var8 = this.input == null?-1:this.input.read(var6, var7, var6.length - var7);
                  if(var8 == -1) {
                     throw InvalidProtocolBufferException.truncatedMessage();
                  }

                  this.totalBytesRetired += var8;
               }

               var4 -= var6.length;
               var5.add(var6);
            }

            var6 = new byte[var1];
            var7 = var3 - var2;
            System.arraycopy(this.buffer, var2, var6, 0, var7);

            byte[] var9;
            for(Iterator var11 = var5.iterator(); var11.hasNext(); var7 += var9.length) {
               var9 = (byte[])var11.next();
               System.arraycopy(var9, 0, var6, var7, var9.length);
            }

            return var6;
         }
      }
   }

   public void skipRawBytes(int var1) {
      if(var1 <= this.bufferSize - this.bufferPos && var1 >= 0) {
         this.bufferPos += var1;
      } else {
         this.skipRawBytesSlowPath(var1);
      }

   }

   private void skipRawBytesSlowPath(int var1) {
      if(var1 < 0) {
         throw InvalidProtocolBufferException.negativeSize();
      } else if(this.totalBytesRetired + this.bufferPos + var1 > this.currentLimit) {
         this.skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
         throw InvalidProtocolBufferException.truncatedMessage();
      } else {
         int var2 = this.bufferSize - this.bufferPos;
         this.bufferPos = this.bufferSize;
         this.refillBuffer(1);

         while(var1 - var2 > this.bufferSize) {
            var2 += this.bufferSize;
            this.bufferPos = this.bufferSize;
            this.refillBuffer(1);
         }

         this.bufferPos = var1 - var2;
      }
   }

   // $FF: synthetic method
   static int access$000(CodedInputStream var0) {
      return var0.bufferPos;
   }

   // $FF: synthetic method
   static byte[] access$100(CodedInputStream var0) {
      return var0.buffer;
   }
}
