package com.google.protobuf;

import java.io.*;
import java.nio.*;

public final class CodedOutputStream
{
    private final byte[] buffer;
    private final int limit;
    private int position;
    private int totalBytesWritten;
    private final OutputStream output;
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final int LITTLE_ENDIAN_64_SIZE = 8;
    
    static int computePreferredBufferSize(final int n) {
        if (n > 4096) {
            return 4096;
        }
        return n;
    }
    
    private CodedOutputStream(final byte[] buffer, final int position, final int n) {
        this.totalBytesWritten = 0;
        this.output = null;
        this.buffer = buffer;
        this.position = position;
        this.limit = position + n;
    }
    
    private CodedOutputStream(final OutputStream output, final byte[] buffer) {
        this.totalBytesWritten = 0;
        this.output = output;
        this.buffer = buffer;
        this.position = 0;
        this.limit = buffer.length;
    }
    
    public static CodedOutputStream newInstance(final OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }
    
    public static CodedOutputStream newInstance(final OutputStream outputStream, final int n) {
        return new CodedOutputStream(outputStream, new byte[n]);
    }
    
    public static CodedOutputStream newInstance(final byte[] array) {
        return newInstance(array, 0, array.length);
    }
    
    public static CodedOutputStream newInstance(final byte[] array, final int n, final int n2) {
        return new CodedOutputStream(array, n, n2);
    }
    
    public static CodedOutputStream newInstance(final ByteBuffer byteBuffer) {
        return newInstance(byteBuffer, 4096);
    }
    
    public static CodedOutputStream newInstance(final ByteBuffer byteBuffer, final int n) {
        return newInstance(new CodedOutputStream$ByteBufferOutputStream(byteBuffer), n);
    }
    
    public void writeDouble(final int n, final double n2) {
        this.writeTag(n, 1);
        this.writeDoubleNoTag(n2);
    }
    
    public void writeFloat(final int n, final float n2) {
        this.writeTag(n, 5);
        this.writeFloatNoTag(n2);
    }
    
    public void writeUInt64(final int n, final long n2) {
        this.writeTag(n, 0);
        this.writeUInt64NoTag(n2);
    }
    
    public void writeInt64(final int n, final long n2) {
        this.writeTag(n, 0);
        this.writeInt64NoTag(n2);
    }
    
    public void writeInt32(final int n, final int n2) {
        this.writeTag(n, 0);
        this.writeInt32NoTag(n2);
    }
    
    public void writeFixed64(final int n, final long n2) {
        this.writeTag(n, 1);
        this.writeFixed64NoTag(n2);
    }
    
    public void writeFixed32(final int n, final int n2) {
        this.writeTag(n, 5);
        this.writeFixed32NoTag(n2);
    }
    
    public void writeBool(final int n, final boolean b) {
        this.writeTag(n, 0);
        this.writeBoolNoTag(b);
    }
    
    public void writeString(final int n, final String s) {
        this.writeTag(n, 2);
        this.writeStringNoTag(s);
    }
    
    public void writeGroup(final int n, final MessageLite messageLite) {
        this.writeTag(n, 3);
        this.writeGroupNoTag(messageLite);
        this.writeTag(n, 4);
    }
    
    @Deprecated
    public void writeUnknownGroup(final int n, final MessageLite messageLite) {
        this.writeGroup(n, messageLite);
    }
    
    public void writeMessage(final int n, final MessageLite messageLite) {
        this.writeTag(n, 2);
        this.writeMessageNoTag(messageLite);
    }
    
    public void writeBytes(final int n, final ByteString byteString) {
        this.writeTag(n, 2);
        this.writeBytesNoTag(byteString);
    }
    
    public void writeByteArray(final int n, final byte[] array) {
        this.writeTag(n, 2);
        this.writeByteArrayNoTag(array);
    }
    
    public void writeByteArray(final int n, final byte[] array, final int n2, final int n3) {
        this.writeTag(n, 2);
        this.writeByteArrayNoTag(array, n2, n3);
    }
    
    public void writeByteBuffer(final int n, final ByteBuffer byteBuffer) {
        this.writeTag(n, 2);
        this.writeByteBufferNoTag(byteBuffer);
    }
    
    public void writeUInt32(final int n, final int n2) {
        this.writeTag(n, 0);
        this.writeUInt32NoTag(n2);
    }
    
    public void writeEnum(final int n, final int n2) {
        this.writeTag(n, 0);
        this.writeEnumNoTag(n2);
    }
    
    public void writeSFixed32(final int n, final int n2) {
        this.writeTag(n, 5);
        this.writeSFixed32NoTag(n2);
    }
    
    public void writeSFixed64(final int n, final long n2) {
        this.writeTag(n, 1);
        this.writeSFixed64NoTag(n2);
    }
    
    public void writeSInt32(final int n, final int n2) {
        this.writeTag(n, 0);
        this.writeSInt32NoTag(n2);
    }
    
    public void writeSInt64(final int n, final long n2) {
        this.writeTag(n, 0);
        this.writeSInt64NoTag(n2);
    }
    
    public void writeMessageSetExtension(final int n, final MessageLite messageLite) {
        this.writeTag(1, 3);
        this.writeUInt32(2, n);
        this.writeMessage(3, messageLite);
        this.writeTag(1, 4);
    }
    
    public void writeRawMessageSetExtension(final int n, final ByteString byteString) {
        this.writeTag(1, 3);
        this.writeUInt32(2, n);
        this.writeBytes(3, byteString);
        this.writeTag(1, 4);
    }
    
    public void writeDoubleNoTag(final double n) {
        this.writeRawLittleEndian64(Double.doubleToRawLongBits(n));
    }
    
    public void writeFloatNoTag(final float n) {
        this.writeRawLittleEndian32(Float.floatToRawIntBits(n));
    }
    
    public void writeUInt64NoTag(final long n) {
        this.writeRawVarint64(n);
    }
    
    public void writeInt64NoTag(final long n) {
        this.writeRawVarint64(n);
    }
    
    public void writeInt32NoTag(final int n) {
        if (n >= 0) {
            this.writeRawVarint32(n);
        }
        else {
            this.writeRawVarint64(n);
        }
    }
    
    public void writeFixed64NoTag(final long n) {
        this.writeRawLittleEndian64(n);
    }
    
    public void writeFixed32NoTag(final int n) {
        this.writeRawLittleEndian32(n);
    }
    
    public void writeBoolNoTag(final boolean b) {
        this.writeRawByte(b ? 1 : 0);
    }
    
    public void writeStringNoTag(final String s) {
        final byte[] bytes = s.getBytes(Internal.UTF_8);
        this.writeRawVarint32(bytes.length);
        this.writeRawBytes(bytes);
    }
    
    public void writeGroupNoTag(final MessageLite messageLite) {
        messageLite.writeTo(this);
    }
    
    @Deprecated
    public void writeUnknownGroupNoTag(final MessageLite messageLite) {
        this.writeGroupNoTag(messageLite);
    }
    
    public void writeMessageNoTag(final MessageLite messageLite) {
        this.writeRawVarint32(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }
    
    public void writeBytesNoTag(final ByteString byteString) {
        this.writeRawVarint32(byteString.size());
        this.writeRawBytes(byteString);
    }
    
    public void writeByteArrayNoTag(final byte[] array) {
        this.writeRawVarint32(array.length);
        this.writeRawBytes(array);
    }
    
    public void writeByteArrayNoTag(final byte[] array, final int n, final int n2) {
        this.writeRawVarint32(n2);
        this.writeRawBytes(array, n, n2);
    }
    
    public void writeByteBufferNoTag(final ByteBuffer byteBuffer) {
        this.writeRawVarint32(byteBuffer.capacity());
        this.writeRawBytes(byteBuffer);
    }
    
    public void writeUInt32NoTag(final int n) {
        this.writeRawVarint32(n);
    }
    
    public void writeEnumNoTag(final int n) {
        this.writeInt32NoTag(n);
    }
    
    public void writeSFixed32NoTag(final int n) {
        this.writeRawLittleEndian32(n);
    }
    
    public void writeSFixed64NoTag(final long n) {
        this.writeRawLittleEndian64(n);
    }
    
    public void writeSInt32NoTag(final int n) {
        this.writeRawVarint32(encodeZigZag32(n));
    }
    
    public void writeSInt64NoTag(final long n) {
        this.writeRawVarint64(encodeZigZag64(n));
    }
    
    public static int computeDoubleSize(final int n, final double n2) {
        return computeTagSize(n) + computeDoubleSizeNoTag(n2);
    }
    
    public static int computeFloatSize(final int n, final float n2) {
        return computeTagSize(n) + computeFloatSizeNoTag(n2);
    }
    
    public static int computeUInt64Size(final int n, final long n2) {
        return computeTagSize(n) + computeUInt64SizeNoTag(n2);
    }
    
    public static int computeInt64Size(final int n, final long n2) {
        return computeTagSize(n) + computeInt64SizeNoTag(n2);
    }
    
    public static int computeInt32Size(final int n, final int n2) {
        return computeTagSize(n) + computeInt32SizeNoTag(n2);
    }
    
    public static int computeFixed64Size(final int n, final long n2) {
        return computeTagSize(n) + computeFixed64SizeNoTag(n2);
    }
    
    public static int computeFixed32Size(final int n, final int n2) {
        return computeTagSize(n) + computeFixed32SizeNoTag(n2);
    }
    
    public static int computeBoolSize(final int n, final boolean b) {
        return computeTagSize(n) + computeBoolSizeNoTag(b);
    }
    
    public static int computeStringSize(final int n, final String s) {
        return computeTagSize(n) + computeStringSizeNoTag(s);
    }
    
    public static int computeGroupSize(final int n, final MessageLite messageLite) {
        return computeTagSize(n) * 2 + computeGroupSizeNoTag(messageLite);
    }
    
    @Deprecated
    public static int computeUnknownGroupSize(final int n, final MessageLite messageLite) {
        return computeGroupSize(n, messageLite);
    }
    
    public static int computeMessageSize(final int n, final MessageLite messageLite) {
        return computeTagSize(n) + computeMessageSizeNoTag(messageLite);
    }
    
    public static int computeBytesSize(final int n, final ByteString byteString) {
        return computeTagSize(n) + computeBytesSizeNoTag(byteString);
    }
    
    public static int computeByteArraySize(final int n, final byte[] array) {
        return computeTagSize(n) + computeByteArraySizeNoTag(array);
    }
    
    public static int computeByteBufferSize(final int n, final ByteBuffer byteBuffer) {
        return computeTagSize(n) + computeByteBufferSizeNoTag(byteBuffer);
    }
    
    public static int computeLazyFieldSize(final int n, final LazyFieldLite lazyFieldLite) {
        return computeTagSize(n) + computeLazyFieldSizeNoTag(lazyFieldLite);
    }
    
    public static int computeUInt32Size(final int n, final int n2) {
        return computeTagSize(n) + computeUInt32SizeNoTag(n2);
    }
    
    public static int computeEnumSize(final int n, final int n2) {
        return computeTagSize(n) + computeEnumSizeNoTag(n2);
    }
    
    public static int computeSFixed32Size(final int n, final int n2) {
        return computeTagSize(n) + computeSFixed32SizeNoTag(n2);
    }
    
    public static int computeSFixed64Size(final int n, final long n2) {
        return computeTagSize(n) + computeSFixed64SizeNoTag(n2);
    }
    
    public static int computeSInt32Size(final int n, final int n2) {
        return computeTagSize(n) + computeSInt32SizeNoTag(n2);
    }
    
    public static int computeSInt64Size(final int n, final long n2) {
        return computeTagSize(n) + computeSInt64SizeNoTag(n2);
    }
    
    public static int computeMessageSetExtensionSize(final int n, final MessageLite messageLite) {
        return computeTagSize(1) * 2 + computeUInt32Size(2, n) + computeMessageSize(3, messageLite);
    }
    
    public static int computeRawMessageSetExtensionSize(final int n, final ByteString byteString) {
        return computeTagSize(1) * 2 + computeUInt32Size(2, n) + computeBytesSize(3, byteString);
    }
    
    public static int computeLazyFieldMessageSetExtensionSize(final int n, final LazyFieldLite lazyFieldLite) {
        return computeTagSize(1) * 2 + computeUInt32Size(2, n) + computeLazyFieldSize(3, lazyFieldLite);
    }
    
    public static int computeDoubleSizeNoTag(final double n) {
        return 8;
    }
    
    public static int computeFloatSizeNoTag(final float n) {
        return 4;
    }
    
    public static int computeUInt64SizeNoTag(final long n) {
        return computeRawVarint64Size(n);
    }
    
    public static int computeInt64SizeNoTag(final long n) {
        return computeRawVarint64Size(n);
    }
    
    public static int computeInt32SizeNoTag(final int n) {
        if (n >= 0) {
            return computeRawVarint32Size(n);
        }
        return 10;
    }
    
    public static int computeFixed64SizeNoTag(final long n) {
        return 8;
    }
    
    public static int computeFixed32SizeNoTag(final int n) {
        return 4;
    }
    
    public static int computeBoolSizeNoTag(final boolean b) {
        return 1;
    }
    
    public static int computeStringSizeNoTag(final String s) {
        final byte[] bytes = s.getBytes(Internal.UTF_8);
        return computeRawVarint32Size(bytes.length) + bytes.length;
    }
    
    public static int computeGroupSizeNoTag(final MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }
    
    @Deprecated
    public static int computeUnknownGroupSizeNoTag(final MessageLite messageLite) {
        return computeGroupSizeNoTag(messageLite);
    }
    
    public static int computeMessageSizeNoTag(final MessageLite messageLite) {
        final int serializedSize = messageLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }
    
    public static int computeLazyFieldSizeNoTag(final LazyFieldLite lazyFieldLite) {
        final int serializedSize = lazyFieldLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }
    
    public static int computeBytesSizeNoTag(final ByteString byteString) {
        return computeRawVarint32Size(byteString.size()) + byteString.size();
    }
    
    public static int computeByteArraySizeNoTag(final byte[] array) {
        return computeRawVarint32Size(array.length) + array.length;
    }
    
    public static int computeByteBufferSizeNoTag(final ByteBuffer byteBuffer) {
        return computeRawVarint32Size(byteBuffer.capacity()) + byteBuffer.capacity();
    }
    
    public static int computeUInt32SizeNoTag(final int n) {
        return computeRawVarint32Size(n);
    }
    
    public static int computeEnumSizeNoTag(final int n) {
        return computeInt32SizeNoTag(n);
    }
    
    public static int computeSFixed32SizeNoTag(final int n) {
        return 4;
    }
    
    public static int computeSFixed64SizeNoTag(final long n) {
        return 8;
    }
    
    public static int computeSInt32SizeNoTag(final int n) {
        return computeRawVarint32Size(encodeZigZag32(n));
    }
    
    public static int computeSInt64SizeNoTag(final long n) {
        return computeRawVarint64Size(encodeZigZag64(n));
    }
    
    private void refreshBuffer() {
        if (this.output == null) {
            throw new CodedOutputStream$OutOfSpaceException();
        }
        this.output.write(this.buffer, 0, this.position);
        this.position = 0;
    }
    
    public void flush() {
        if (this.output != null) {
            this.refreshBuffer();
        }
    }
    
    public int spaceLeft() {
        if (this.output == null) {
            return this.limit - this.position;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }
    
    public void checkNoSpaceLeft() {
        if (this.spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }
    
    public int getTotalBytesWritten() {
        return this.totalBytesWritten;
    }
    
    public void writeRawByte(final byte b) {
        if (this.position == this.limit) {
            this.refreshBuffer();
        }
        this.buffer[this.position++] = b;
        ++this.totalBytesWritten;
    }
    
    public void writeRawByte(final int n) {
        this.writeRawByte((byte)n);
    }
    
    public void writeRawBytes(final ByteString byteString) {
        this.writeRawBytes(byteString, 0, byteString.size());
    }
    
    public void writeRawBytes(final byte[] array) {
        this.writeRawBytes(array, 0, array.length);
    }
    
    public void writeRawBytes(final ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            this.writeRawBytes(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
        }
        else {
            final ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            this.writeRawBytesInternal(duplicate);
        }
    }
    
    private void writeRawBytesInternal(final ByteBuffer byteBuffer) {
        final int remaining = byteBuffer.remaining();
        if (this.limit - this.position >= remaining) {
            byteBuffer.get(this.buffer, this.position, remaining);
            this.position += remaining;
            this.totalBytesWritten += remaining;
        }
        else {
            final int n = this.limit - this.position;
            byteBuffer.get(this.buffer, this.position, n);
            int i = remaining - n;
            this.position = this.limit;
            this.totalBytesWritten += n;
            this.refreshBuffer();
            while (i > this.limit) {
                byteBuffer.get(this.buffer, 0, this.limit);
                this.output.write(this.buffer, 0, this.limit);
                i -= this.limit;
                this.totalBytesWritten += this.limit;
            }
            byteBuffer.get(this.buffer, 0, i);
            this.position = i;
            this.totalBytesWritten += i;
        }
    }
    
    public void writeRawBytes(final byte[] array, int n, int position) {
        if (this.limit - this.position >= position) {
            System.arraycopy(array, n, this.buffer, this.position, position);
            this.position += position;
            this.totalBytesWritten += position;
        }
        else {
            final int n2 = this.limit - this.position;
            System.arraycopy(array, n, this.buffer, this.position, n2);
            n += n2;
            position -= n2;
            this.position = this.limit;
            this.totalBytesWritten += n2;
            this.refreshBuffer();
            if (position <= this.limit) {
                System.arraycopy(array, n, this.buffer, 0, position);
                this.position = position;
            }
            else {
                this.output.write(array, n, position);
            }
            this.totalBytesWritten += position;
        }
    }
    
    public void writeRawBytes(final ByteString byteString, int n, int position) {
        if (this.limit - this.position >= position) {
            byteString.copyTo(this.buffer, n, this.position, position);
            this.position += position;
            this.totalBytesWritten += position;
        }
        else {
            final int n2 = this.limit - this.position;
            byteString.copyTo(this.buffer, n, this.position, n2);
            n += n2;
            position -= n2;
            this.position = this.limit;
            this.totalBytesWritten += n2;
            this.refreshBuffer();
            if (position <= this.limit) {
                byteString.copyTo(this.buffer, n, 0, position);
                this.position = position;
            }
            else {
                byteString.writeTo(this.output, n, position);
            }
            this.totalBytesWritten += position;
        }
    }
    
    public void writeTag(final int n, final int n2) {
        this.writeRawVarint32(WireFormat.makeTag(n, n2));
    }
    
    public static int computeTagSize(final int n) {
        return computeRawVarint32Size(WireFormat.makeTag(n, 0));
    }
    
    public void writeRawVarint32(int n) {
        while ((n & 0xFFFFFF80) != 0x0) {
            this.writeRawByte((n & 0x7F) | 0x80);
            n >>>= 7;
        }
        this.writeRawByte(n);
    }
    
    public static int computeRawVarint32Size(final int n) {
        if ((n & 0xFFFFFF80) == 0x0) {
            return 1;
        }
        if ((n & 0xFFFFC000) == 0x0) {
            return 2;
        }
        if ((n & 0xFFE00000) == 0x0) {
            return 3;
        }
        if ((n & 0xF0000000) == 0x0) {
            return 4;
        }
        return 5;
    }
    
    public void writeRawVarint64(long n) {
        while ((n & 0xFFFFFFFFFFFFFF80L) != 0x0L) {
            this.writeRawByte(((int)n & 0x7F) | 0x80);
            n >>>= 7;
        }
        this.writeRawByte((int)n);
    }
    
    public static int computeRawVarint64Size(final long n) {
        if ((n & 0xFFFFFFFFFFFFFF80L) == 0x0L) {
            return 1;
        }
        if ((n & 0xFFFFFFFFFFFFC000L) == 0x0L) {
            return 2;
        }
        if ((n & 0xFFFFFFFFFFE00000L) == 0x0L) {
            return 3;
        }
        if ((n & 0xFFFFFFFFF0000000L) == 0x0L) {
            return 4;
        }
        if ((n & 0xFFFFFFF800000000L) == 0x0L) {
            return 5;
        }
        if ((n & 0xFFFFFC0000000000L) == 0x0L) {
            return 6;
        }
        if ((n & 0xFFFE000000000000L) == 0x0L) {
            return 7;
        }
        if ((n & 0xFF00000000000000L) == 0x0L) {
            return 8;
        }
        if ((n & Long.MIN_VALUE) == 0x0L) {
            return 9;
        }
        return 10;
    }
    
    public void writeRawLittleEndian32(final int n) {
        this.writeRawByte(n & 0xFF);
        this.writeRawByte(n >> 8 & 0xFF);
        this.writeRawByte(n >> 16 & 0xFF);
        this.writeRawByte(n >> 24 & 0xFF);
    }
    
    public void writeRawLittleEndian64(final long n) {
        this.writeRawByte((int)n & 0xFF);
        this.writeRawByte((int)(n >> 8) & 0xFF);
        this.writeRawByte((int)(n >> 16) & 0xFF);
        this.writeRawByte((int)(n >> 24) & 0xFF);
        this.writeRawByte((int)(n >> 32) & 0xFF);
        this.writeRawByte((int)(n >> 40) & 0xFF);
        this.writeRawByte((int)(n >> 48) & 0xFF);
        this.writeRawByte((int)(n >> 56) & 0xFF);
    }
    
    public static int encodeZigZag32(final int n) {
        return n << 1 ^ n >> 31;
    }
    
    public static long encodeZigZag64(final long n) {
        return n << 1 ^ n >> 63;
    }
}
