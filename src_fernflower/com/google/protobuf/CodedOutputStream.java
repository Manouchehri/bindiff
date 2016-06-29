package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream$ByteBufferOutputStream;
import com.google.protobuf.CodedOutputStream$OutOfSpaceException;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyFieldLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public final class CodedOutputStream {
   private final byte[] buffer;
   private final int limit;
   private int position;
   private int totalBytesWritten = 0;
   private final OutputStream output;
   public static final int DEFAULT_BUFFER_SIZE = 4096;
   public static final int LITTLE_ENDIAN_32_SIZE = 4;
   public static final int LITTLE_ENDIAN_64_SIZE = 8;

   static int computePreferredBufferSize(int var0) {
      return var0 > 4096?4096:var0;
   }

   private CodedOutputStream(byte[] var1, int var2, int var3) {
      this.output = null;
      this.buffer = var1;
      this.position = var2;
      this.limit = var2 + var3;
   }

   private CodedOutputStream(OutputStream var1, byte[] var2) {
      this.output = var1;
      this.buffer = var2;
      this.position = 0;
      this.limit = var2.length;
   }

   public static CodedOutputStream newInstance(OutputStream var0) {
      return newInstance((OutputStream)var0, 4096);
   }

   public static CodedOutputStream newInstance(OutputStream var0, int var1) {
      return new CodedOutputStream(var0, new byte[var1]);
   }

   public static CodedOutputStream newInstance(byte[] var0) {
      return newInstance(var0, 0, var0.length);
   }

   public static CodedOutputStream newInstance(byte[] var0, int var1, int var2) {
      return new CodedOutputStream(var0, var1, var2);
   }

   public static CodedOutputStream newInstance(ByteBuffer var0) {
      return newInstance((ByteBuffer)var0, 4096);
   }

   public static CodedOutputStream newInstance(ByteBuffer var0, int var1) {
      return newInstance((OutputStream)(new CodedOutputStream$ByteBufferOutputStream(var0)), var1);
   }

   public void writeDouble(int var1, double var2) {
      this.writeTag(var1, 1);
      this.writeDoubleNoTag(var2);
   }

   public void writeFloat(int var1, float var2) {
      this.writeTag(var1, 5);
      this.writeFloatNoTag(var2);
   }

   public void writeUInt64(int var1, long var2) {
      this.writeTag(var1, 0);
      this.writeUInt64NoTag(var2);
   }

   public void writeInt64(int var1, long var2) {
      this.writeTag(var1, 0);
      this.writeInt64NoTag(var2);
   }

   public void writeInt32(int var1, int var2) {
      this.writeTag(var1, 0);
      this.writeInt32NoTag(var2);
   }

   public void writeFixed64(int var1, long var2) {
      this.writeTag(var1, 1);
      this.writeFixed64NoTag(var2);
   }

   public void writeFixed32(int var1, int var2) {
      this.writeTag(var1, 5);
      this.writeFixed32NoTag(var2);
   }

   public void writeBool(int var1, boolean var2) {
      this.writeTag(var1, 0);
      this.writeBoolNoTag(var2);
   }

   public void writeString(int var1, String var2) {
      this.writeTag(var1, 2);
      this.writeStringNoTag(var2);
   }

   public void writeGroup(int var1, MessageLite var2) {
      this.writeTag(var1, 3);
      this.writeGroupNoTag(var2);
      this.writeTag(var1, 4);
   }

   @Deprecated
   public void writeUnknownGroup(int var1, MessageLite var2) {
      this.writeGroup(var1, var2);
   }

   public void writeMessage(int var1, MessageLite var2) {
      this.writeTag(var1, 2);
      this.writeMessageNoTag(var2);
   }

   public void writeBytes(int var1, ByteString var2) {
      this.writeTag(var1, 2);
      this.writeBytesNoTag(var2);
   }

   public void writeByteArray(int var1, byte[] var2) {
      this.writeTag(var1, 2);
      this.writeByteArrayNoTag(var2);
   }

   public void writeByteArray(int var1, byte[] var2, int var3, int var4) {
      this.writeTag(var1, 2);
      this.writeByteArrayNoTag(var2, var3, var4);
   }

   public void writeByteBuffer(int var1, ByteBuffer var2) {
      this.writeTag(var1, 2);
      this.writeByteBufferNoTag(var2);
   }

   public void writeUInt32(int var1, int var2) {
      this.writeTag(var1, 0);
      this.writeUInt32NoTag(var2);
   }

   public void writeEnum(int var1, int var2) {
      this.writeTag(var1, 0);
      this.writeEnumNoTag(var2);
   }

   public void writeSFixed32(int var1, int var2) {
      this.writeTag(var1, 5);
      this.writeSFixed32NoTag(var2);
   }

   public void writeSFixed64(int var1, long var2) {
      this.writeTag(var1, 1);
      this.writeSFixed64NoTag(var2);
   }

   public void writeSInt32(int var1, int var2) {
      this.writeTag(var1, 0);
      this.writeSInt32NoTag(var2);
   }

   public void writeSInt64(int var1, long var2) {
      this.writeTag(var1, 0);
      this.writeSInt64NoTag(var2);
   }

   public void writeMessageSetExtension(int var1, MessageLite var2) {
      this.writeTag(1, 3);
      this.writeUInt32(2, var1);
      this.writeMessage(3, var2);
      this.writeTag(1, 4);
   }

   public void writeRawMessageSetExtension(int var1, ByteString var2) {
      this.writeTag(1, 3);
      this.writeUInt32(2, var1);
      this.writeBytes(3, var2);
      this.writeTag(1, 4);
   }

   public void writeDoubleNoTag(double var1) {
      this.writeRawLittleEndian64(Double.doubleToRawLongBits(var1));
   }

   public void writeFloatNoTag(float var1) {
      this.writeRawLittleEndian32(Float.floatToRawIntBits(var1));
   }

   public void writeUInt64NoTag(long var1) {
      this.writeRawVarint64(var1);
   }

   public void writeInt64NoTag(long var1) {
      this.writeRawVarint64(var1);
   }

   public void writeInt32NoTag(int var1) {
      if(var1 >= 0) {
         this.writeRawVarint32(var1);
      } else {
         this.writeRawVarint64((long)var1);
      }

   }

   public void writeFixed64NoTag(long var1) {
      this.writeRawLittleEndian64(var1);
   }

   public void writeFixed32NoTag(int var1) {
      this.writeRawLittleEndian32(var1);
   }

   public void writeBoolNoTag(boolean var1) {
      this.writeRawByte(var1?1:0);
   }

   public void writeStringNoTag(String var1) {
      byte[] var2 = var1.getBytes(Internal.UTF_8);
      this.writeRawVarint32(var2.length);
      this.writeRawBytes(var2);
   }

   public void writeGroupNoTag(MessageLite var1) {
      var1.writeTo(this);
   }

   @Deprecated
   public void writeUnknownGroupNoTag(MessageLite var1) {
      this.writeGroupNoTag(var1);
   }

   public void writeMessageNoTag(MessageLite var1) {
      this.writeRawVarint32(var1.getSerializedSize());
      var1.writeTo(this);
   }

   public void writeBytesNoTag(ByteString var1) {
      this.writeRawVarint32(var1.size());
      this.writeRawBytes(var1);
   }

   public void writeByteArrayNoTag(byte[] var1) {
      this.writeRawVarint32(var1.length);
      this.writeRawBytes(var1);
   }

   public void writeByteArrayNoTag(byte[] var1, int var2, int var3) {
      this.writeRawVarint32(var3);
      this.writeRawBytes(var1, var2, var3);
   }

   public void writeByteBufferNoTag(ByteBuffer var1) {
      this.writeRawVarint32(var1.capacity());
      this.writeRawBytes(var1);
   }

   public void writeUInt32NoTag(int var1) {
      this.writeRawVarint32(var1);
   }

   public void writeEnumNoTag(int var1) {
      this.writeInt32NoTag(var1);
   }

   public void writeSFixed32NoTag(int var1) {
      this.writeRawLittleEndian32(var1);
   }

   public void writeSFixed64NoTag(long var1) {
      this.writeRawLittleEndian64(var1);
   }

   public void writeSInt32NoTag(int var1) {
      this.writeRawVarint32(encodeZigZag32(var1));
   }

   public void writeSInt64NoTag(long var1) {
      this.writeRawVarint64(encodeZigZag64(var1));
   }

   public static int computeDoubleSize(int var0, double var1) {
      return computeTagSize(var0) + computeDoubleSizeNoTag(var1);
   }

   public static int computeFloatSize(int var0, float var1) {
      return computeTagSize(var0) + computeFloatSizeNoTag(var1);
   }

   public static int computeUInt64Size(int var0, long var1) {
      return computeTagSize(var0) + computeUInt64SizeNoTag(var1);
   }

   public static int computeInt64Size(int var0, long var1) {
      return computeTagSize(var0) + computeInt64SizeNoTag(var1);
   }

   public static int computeInt32Size(int var0, int var1) {
      return computeTagSize(var0) + computeInt32SizeNoTag(var1);
   }

   public static int computeFixed64Size(int var0, long var1) {
      return computeTagSize(var0) + computeFixed64SizeNoTag(var1);
   }

   public static int computeFixed32Size(int var0, int var1) {
      return computeTagSize(var0) + computeFixed32SizeNoTag(var1);
   }

   public static int computeBoolSize(int var0, boolean var1) {
      return computeTagSize(var0) + computeBoolSizeNoTag(var1);
   }

   public static int computeStringSize(int var0, String var1) {
      return computeTagSize(var0) + computeStringSizeNoTag(var1);
   }

   public static int computeGroupSize(int var0, MessageLite var1) {
      return computeTagSize(var0) * 2 + computeGroupSizeNoTag(var1);
   }

   @Deprecated
   public static int computeUnknownGroupSize(int var0, MessageLite var1) {
      return computeGroupSize(var0, var1);
   }

   public static int computeMessageSize(int var0, MessageLite var1) {
      return computeTagSize(var0) + computeMessageSizeNoTag(var1);
   }

   public static int computeBytesSize(int var0, ByteString var1) {
      return computeTagSize(var0) + computeBytesSizeNoTag(var1);
   }

   public static int computeByteArraySize(int var0, byte[] var1) {
      return computeTagSize(var0) + computeByteArraySizeNoTag(var1);
   }

   public static int computeByteBufferSize(int var0, ByteBuffer var1) {
      return computeTagSize(var0) + computeByteBufferSizeNoTag(var1);
   }

   public static int computeLazyFieldSize(int var0, LazyFieldLite var1) {
      return computeTagSize(var0) + computeLazyFieldSizeNoTag(var1);
   }

   public static int computeUInt32Size(int var0, int var1) {
      return computeTagSize(var0) + computeUInt32SizeNoTag(var1);
   }

   public static int computeEnumSize(int var0, int var1) {
      return computeTagSize(var0) + computeEnumSizeNoTag(var1);
   }

   public static int computeSFixed32Size(int var0, int var1) {
      return computeTagSize(var0) + computeSFixed32SizeNoTag(var1);
   }

   public static int computeSFixed64Size(int var0, long var1) {
      return computeTagSize(var0) + computeSFixed64SizeNoTag(var1);
   }

   public static int computeSInt32Size(int var0, int var1) {
      return computeTagSize(var0) + computeSInt32SizeNoTag(var1);
   }

   public static int computeSInt64Size(int var0, long var1) {
      return computeTagSize(var0) + computeSInt64SizeNoTag(var1);
   }

   public static int computeMessageSetExtensionSize(int var0, MessageLite var1) {
      return computeTagSize(1) * 2 + computeUInt32Size(2, var0) + computeMessageSize(3, var1);
   }

   public static int computeRawMessageSetExtensionSize(int var0, ByteString var1) {
      return computeTagSize(1) * 2 + computeUInt32Size(2, var0) + computeBytesSize(3, var1);
   }

   public static int computeLazyFieldMessageSetExtensionSize(int var0, LazyFieldLite var1) {
      return computeTagSize(1) * 2 + computeUInt32Size(2, var0) + computeLazyFieldSize(3, var1);
   }

   public static int computeDoubleSizeNoTag(double var0) {
      return 8;
   }

   public static int computeFloatSizeNoTag(float var0) {
      return 4;
   }

   public static int computeUInt64SizeNoTag(long var0) {
      return computeRawVarint64Size(var0);
   }

   public static int computeInt64SizeNoTag(long var0) {
      return computeRawVarint64Size(var0);
   }

   public static int computeInt32SizeNoTag(int var0) {
      return var0 >= 0?computeRawVarint32Size(var0):10;
   }

   public static int computeFixed64SizeNoTag(long var0) {
      return 8;
   }

   public static int computeFixed32SizeNoTag(int var0) {
      return 4;
   }

   public static int computeBoolSizeNoTag(boolean var0) {
      return 1;
   }

   public static int computeStringSizeNoTag(String var0) {
      byte[] var1 = var0.getBytes(Internal.UTF_8);
      return computeRawVarint32Size(var1.length) + var1.length;
   }

   public static int computeGroupSizeNoTag(MessageLite var0) {
      return var0.getSerializedSize();
   }

   @Deprecated
   public static int computeUnknownGroupSizeNoTag(MessageLite var0) {
      return computeGroupSizeNoTag(var0);
   }

   public static int computeMessageSizeNoTag(MessageLite var0) {
      int var1 = var0.getSerializedSize();
      return computeRawVarint32Size(var1) + var1;
   }

   public static int computeLazyFieldSizeNoTag(LazyFieldLite var0) {
      int var1 = var0.getSerializedSize();
      return computeRawVarint32Size(var1) + var1;
   }

   public static int computeBytesSizeNoTag(ByteString var0) {
      return computeRawVarint32Size(var0.size()) + var0.size();
   }

   public static int computeByteArraySizeNoTag(byte[] var0) {
      return computeRawVarint32Size(var0.length) + var0.length;
   }

   public static int computeByteBufferSizeNoTag(ByteBuffer var0) {
      return computeRawVarint32Size(var0.capacity()) + var0.capacity();
   }

   public static int computeUInt32SizeNoTag(int var0) {
      return computeRawVarint32Size(var0);
   }

   public static int computeEnumSizeNoTag(int var0) {
      return computeInt32SizeNoTag(var0);
   }

   public static int computeSFixed32SizeNoTag(int var0) {
      return 4;
   }

   public static int computeSFixed64SizeNoTag(long var0) {
      return 8;
   }

   public static int computeSInt32SizeNoTag(int var0) {
      return computeRawVarint32Size(encodeZigZag32(var0));
   }

   public static int computeSInt64SizeNoTag(long var0) {
      return computeRawVarint64Size(encodeZigZag64(var0));
   }

   private void refreshBuffer() {
      if(this.output == null) {
         throw new CodedOutputStream$OutOfSpaceException();
      } else {
         this.output.write(this.buffer, 0, this.position);
         this.position = 0;
      }
   }

   public void flush() {
      if(this.output != null) {
         this.refreshBuffer();
      }

   }

   public int spaceLeft() {
      if(this.output == null) {
         return this.limit - this.position;
      } else {
         throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
      }
   }

   public void checkNoSpaceLeft() {
      if(this.spaceLeft() != 0) {
         throw new IllegalStateException("Did not write as much data as expected.");
      }
   }

   public int getTotalBytesWritten() {
      return this.totalBytesWritten;
   }

   public void writeRawByte(byte var1) {
      if(this.position == this.limit) {
         this.refreshBuffer();
      }

      this.buffer[this.position++] = var1;
      ++this.totalBytesWritten;
   }

   public void writeRawByte(int var1) {
      this.writeRawByte((byte)var1);
   }

   public void writeRawBytes(ByteString var1) {
      this.writeRawBytes((ByteString)var1, 0, var1.size());
   }

   public void writeRawBytes(byte[] var1) {
      this.writeRawBytes((byte[])var1, 0, var1.length);
   }

   public void writeRawBytes(ByteBuffer var1) {
      if(var1.hasArray()) {
         this.writeRawBytes(var1.array(), var1.arrayOffset(), var1.capacity());
      } else {
         ByteBuffer var2 = var1.duplicate();
         var2.clear();
         this.writeRawBytesInternal(var2);
      }

   }

   private void writeRawBytesInternal(ByteBuffer var1) {
      int var2 = var1.remaining();
      if(this.limit - this.position >= var2) {
         var1.get(this.buffer, this.position, var2);
         this.position += var2;
         this.totalBytesWritten += var2;
      } else {
         int var3 = this.limit - this.position;
         var1.get(this.buffer, this.position, var3);
         var2 -= var3;
         this.position = this.limit;
         this.totalBytesWritten += var3;
         this.refreshBuffer();

         while(var2 > this.limit) {
            var1.get(this.buffer, 0, this.limit);
            this.output.write(this.buffer, 0, this.limit);
            var2 -= this.limit;
            this.totalBytesWritten += this.limit;
         }

         var1.get(this.buffer, 0, var2);
         this.position = var2;
         this.totalBytesWritten += var2;
      }

   }

   public void writeRawBytes(byte[] var1, int var2, int var3) {
      if(this.limit - this.position >= var3) {
         System.arraycopy(var1, var2, this.buffer, this.position, var3);
         this.position += var3;
         this.totalBytesWritten += var3;
      } else {
         int var4 = this.limit - this.position;
         System.arraycopy(var1, var2, this.buffer, this.position, var4);
         var2 += var4;
         var3 -= var4;
         this.position = this.limit;
         this.totalBytesWritten += var4;
         this.refreshBuffer();
         if(var3 <= this.limit) {
            System.arraycopy(var1, var2, this.buffer, 0, var3);
            this.position = var3;
         } else {
            this.output.write(var1, var2, var3);
         }

         this.totalBytesWritten += var3;
      }

   }

   public void writeRawBytes(ByteString var1, int var2, int var3) {
      if(this.limit - this.position >= var3) {
         var1.copyTo(this.buffer, var2, this.position, var3);
         this.position += var3;
         this.totalBytesWritten += var3;
      } else {
         int var4 = this.limit - this.position;
         var1.copyTo(this.buffer, var2, this.position, var4);
         var2 += var4;
         var3 -= var4;
         this.position = this.limit;
         this.totalBytesWritten += var4;
         this.refreshBuffer();
         if(var3 <= this.limit) {
            var1.copyTo(this.buffer, var2, 0, var3);
            this.position = var3;
         } else {
            var1.writeTo(this.output, var2, var3);
         }

         this.totalBytesWritten += var3;
      }

   }

   public void writeTag(int var1, int var2) {
      this.writeRawVarint32(WireFormat.makeTag(var1, var2));
   }

   public static int computeTagSize(int var0) {
      return computeRawVarint32Size(WireFormat.makeTag(var0, 0));
   }

   public void writeRawVarint32(int var1) {
      while((var1 & -128) != 0) {
         this.writeRawByte(var1 & 127 | 128);
         var1 >>>= 7;
      }

      this.writeRawByte(var1);
   }

   public static int computeRawVarint32Size(int var0) {
      return (var0 & -128) == 0?1:((var0 & -16384) == 0?2:((var0 & -2097152) == 0?3:((var0 & -268435456) == 0?4:5)));
   }

   public void writeRawVarint64(long var1) {
      while((var1 & -128L) != 0L) {
         this.writeRawByte((int)var1 & 127 | 128);
         var1 >>>= 7;
      }

      this.writeRawByte((int)var1);
   }

   public static int computeRawVarint64Size(long var0) {
      return (var0 & -128L) == 0L?1:((var0 & -16384L) == 0L?2:((var0 & -2097152L) == 0L?3:((var0 & -268435456L) == 0L?4:((var0 & -34359738368L) == 0L?5:((var0 & -4398046511104L) == 0L?6:((var0 & -562949953421312L) == 0L?7:((var0 & -72057594037927936L) == 0L?8:((var0 & Long.MIN_VALUE) == 0L?9:10))))))));
   }

   public void writeRawLittleEndian32(int var1) {
      this.writeRawByte(var1 & 255);
      this.writeRawByte(var1 >> 8 & 255);
      this.writeRawByte(var1 >> 16 & 255);
      this.writeRawByte(var1 >> 24 & 255);
   }

   public void writeRawLittleEndian64(long var1) {
      this.writeRawByte((int)var1 & 255);
      this.writeRawByte((int)(var1 >> 8) & 255);
      this.writeRawByte((int)(var1 >> 16) & 255);
      this.writeRawByte((int)(var1 >> 24) & 255);
      this.writeRawByte((int)(var1 >> 32) & 255);
      this.writeRawByte((int)(var1 >> 40) & 255);
      this.writeRawByte((int)(var1 >> 48) & 255);
      this.writeRawByte((int)(var1 >> 56) & 255);
   }

   public static int encodeZigZag32(int var0) {
      return var0 << 1 ^ var0 >> 31;
   }

   public static long encodeZigZag64(long var0) {
      return var0 << 1 ^ var0 >> 63;
   }
}
