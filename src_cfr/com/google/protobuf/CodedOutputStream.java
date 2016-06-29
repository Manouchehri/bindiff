/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream$ByteBufferOutputStream;
import com.google.protobuf.CodedOutputStream$OutOfSpaceException;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyFieldLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class CodedOutputStream {
    private final byte[] buffer;
    private final int limit;
    private int position;
    private int totalBytesWritten = 0;
    private final OutputStream output;
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final int LITTLE_ENDIAN_64_SIZE = 8;

    static int computePreferredBufferSize(int n2) {
        if (n2 <= 4096) return n2;
        return 4096;
    }

    private CodedOutputStream(byte[] arrby, int n2, int n3) {
        this.output = null;
        this.buffer = arrby;
        this.position = n2;
        this.limit = n2 + n3;
    }

    private CodedOutputStream(OutputStream outputStream, byte[] arrby) {
        this.output = outputStream;
        this.buffer = arrby;
        this.position = 0;
        this.limit = arrby.length;
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return CodedOutputStream.newInstance(outputStream, 4096);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int n2) {
        return new CodedOutputStream(outputStream, new byte[n2]);
    }

    public static CodedOutputStream newInstance(byte[] arrby) {
        return CodedOutputStream.newInstance(arrby, 0, arrby.length);
    }

    public static CodedOutputStream newInstance(byte[] arrby, int n2, int n3) {
        return new CodedOutputStream(arrby, n2, n3);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        return CodedOutputStream.newInstance(byteBuffer, 4096);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int n2) {
        return CodedOutputStream.newInstance(new CodedOutputStream$ByteBufferOutputStream(byteBuffer), n2);
    }

    public void writeDouble(int n2, double d2) {
        this.writeTag(n2, 1);
        this.writeDoubleNoTag(d2);
    }

    public void writeFloat(int n2, float f2) {
        this.writeTag(n2, 5);
        this.writeFloatNoTag(f2);
    }

    public void writeUInt64(int n2, long l2) {
        this.writeTag(n2, 0);
        this.writeUInt64NoTag(l2);
    }

    public void writeInt64(int n2, long l2) {
        this.writeTag(n2, 0);
        this.writeInt64NoTag(l2);
    }

    public void writeInt32(int n2, int n3) {
        this.writeTag(n2, 0);
        this.writeInt32NoTag(n3);
    }

    public void writeFixed64(int n2, long l2) {
        this.writeTag(n2, 1);
        this.writeFixed64NoTag(l2);
    }

    public void writeFixed32(int n2, int n3) {
        this.writeTag(n2, 5);
        this.writeFixed32NoTag(n3);
    }

    public void writeBool(int n2, boolean bl2) {
        this.writeTag(n2, 0);
        this.writeBoolNoTag(bl2);
    }

    public void writeString(int n2, String string) {
        this.writeTag(n2, 2);
        this.writeStringNoTag(string);
    }

    public void writeGroup(int n2, MessageLite messageLite) {
        this.writeTag(n2, 3);
        this.writeGroupNoTag(messageLite);
        this.writeTag(n2, 4);
    }

    @Deprecated
    public void writeUnknownGroup(int n2, MessageLite messageLite) {
        this.writeGroup(n2, messageLite);
    }

    public void writeMessage(int n2, MessageLite messageLite) {
        this.writeTag(n2, 2);
        this.writeMessageNoTag(messageLite);
    }

    public void writeBytes(int n2, ByteString byteString) {
        this.writeTag(n2, 2);
        this.writeBytesNoTag(byteString);
    }

    public void writeByteArray(int n2, byte[] arrby) {
        this.writeTag(n2, 2);
        this.writeByteArrayNoTag(arrby);
    }

    public void writeByteArray(int n2, byte[] arrby, int n3, int n4) {
        this.writeTag(n2, 2);
        this.writeByteArrayNoTag(arrby, n3, n4);
    }

    public void writeByteBuffer(int n2, ByteBuffer byteBuffer) {
        this.writeTag(n2, 2);
        this.writeByteBufferNoTag(byteBuffer);
    }

    public void writeUInt32(int n2, int n3) {
        this.writeTag(n2, 0);
        this.writeUInt32NoTag(n3);
    }

    public void writeEnum(int n2, int n3) {
        this.writeTag(n2, 0);
        this.writeEnumNoTag(n3);
    }

    public void writeSFixed32(int n2, int n3) {
        this.writeTag(n2, 5);
        this.writeSFixed32NoTag(n3);
    }

    public void writeSFixed64(int n2, long l2) {
        this.writeTag(n2, 1);
        this.writeSFixed64NoTag(l2);
    }

    public void writeSInt32(int n2, int n3) {
        this.writeTag(n2, 0);
        this.writeSInt32NoTag(n3);
    }

    public void writeSInt64(int n2, long l2) {
        this.writeTag(n2, 0);
        this.writeSInt64NoTag(l2);
    }

    public void writeMessageSetExtension(int n2, MessageLite messageLite) {
        this.writeTag(1, 3);
        this.writeUInt32(2, n2);
        this.writeMessage(3, messageLite);
        this.writeTag(1, 4);
    }

    public void writeRawMessageSetExtension(int n2, ByteString byteString) {
        this.writeTag(1, 3);
        this.writeUInt32(2, n2);
        this.writeBytes(3, byteString);
        this.writeTag(1, 4);
    }

    public void writeDoubleNoTag(double d2) {
        this.writeRawLittleEndian64(Double.doubleToRawLongBits(d2));
    }

    public void writeFloatNoTag(float f2) {
        this.writeRawLittleEndian32(Float.floatToRawIntBits(f2));
    }

    public void writeUInt64NoTag(long l2) {
        this.writeRawVarint64(l2);
    }

    public void writeInt64NoTag(long l2) {
        this.writeRawVarint64(l2);
    }

    public void writeInt32NoTag(int n2) {
        if (n2 >= 0) {
            this.writeRawVarint32(n2);
            return;
        }
        this.writeRawVarint64(n2);
    }

    public void writeFixed64NoTag(long l2) {
        this.writeRawLittleEndian64(l2);
    }

    public void writeFixed32NoTag(int n2) {
        this.writeRawLittleEndian32(n2);
    }

    public void writeBoolNoTag(boolean bl2) {
        this.writeRawByte(bl2 ? 1 : 0);
    }

    public void writeStringNoTag(String string) {
        byte[] arrby = string.getBytes(Internal.UTF_8);
        this.writeRawVarint32(arrby.length);
        this.writeRawBytes(arrby);
    }

    public void writeGroupNoTag(MessageLite messageLite) {
        messageLite.writeTo(this);
    }

    @Deprecated
    public void writeUnknownGroupNoTag(MessageLite messageLite) {
        this.writeGroupNoTag(messageLite);
    }

    public void writeMessageNoTag(MessageLite messageLite) {
        this.writeRawVarint32(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    public void writeBytesNoTag(ByteString byteString) {
        this.writeRawVarint32(byteString.size());
        this.writeRawBytes(byteString);
    }

    public void writeByteArrayNoTag(byte[] arrby) {
        this.writeRawVarint32(arrby.length);
        this.writeRawBytes(arrby);
    }

    public void writeByteArrayNoTag(byte[] arrby, int n2, int n3) {
        this.writeRawVarint32(n3);
        this.writeRawBytes(arrby, n2, n3);
    }

    public void writeByteBufferNoTag(ByteBuffer byteBuffer) {
        this.writeRawVarint32(byteBuffer.capacity());
        this.writeRawBytes(byteBuffer);
    }

    public void writeUInt32NoTag(int n2) {
        this.writeRawVarint32(n2);
    }

    public void writeEnumNoTag(int n2) {
        this.writeInt32NoTag(n2);
    }

    public void writeSFixed32NoTag(int n2) {
        this.writeRawLittleEndian32(n2);
    }

    public void writeSFixed64NoTag(long l2) {
        this.writeRawLittleEndian64(l2);
    }

    public void writeSInt32NoTag(int n2) {
        this.writeRawVarint32(CodedOutputStream.encodeZigZag32(n2));
    }

    public void writeSInt64NoTag(long l2) {
        this.writeRawVarint64(CodedOutputStream.encodeZigZag64(l2));
    }

    public static int computeDoubleSize(int n2, double d2) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeDoubleSizeNoTag(d2);
    }

    public static int computeFloatSize(int n2, float f2) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeFloatSizeNoTag(f2);
    }

    public static int computeUInt64Size(int n2, long l2) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeUInt64SizeNoTag(l2);
    }

    public static int computeInt64Size(int n2, long l2) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeInt64SizeNoTag(l2);
    }

    public static int computeInt32Size(int n2, int n3) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeInt32SizeNoTag(n3);
    }

    public static int computeFixed64Size(int n2, long l2) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeFixed64SizeNoTag(l2);
    }

    public static int computeFixed32Size(int n2, int n3) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeFixed32SizeNoTag(n3);
    }

    public static int computeBoolSize(int n2, boolean bl2) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeBoolSizeNoTag(bl2);
    }

    public static int computeStringSize(int n2, String string) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeStringSizeNoTag(string);
    }

    public static int computeGroupSize(int n2, MessageLite messageLite) {
        return CodedOutputStream.computeTagSize(n2) * 2 + CodedOutputStream.computeGroupSizeNoTag(messageLite);
    }

    @Deprecated
    public static int computeUnknownGroupSize(int n2, MessageLite messageLite) {
        return CodedOutputStream.computeGroupSize(n2, messageLite);
    }

    public static int computeMessageSize(int n2, MessageLite messageLite) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeMessageSizeNoTag(messageLite);
    }

    public static int computeBytesSize(int n2, ByteString byteString) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeBytesSizeNoTag(byteString);
    }

    public static int computeByteArraySize(int n2, byte[] arrby) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeByteArraySizeNoTag(arrby);
    }

    public static int computeByteBufferSize(int n2, ByteBuffer byteBuffer) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeByteBufferSizeNoTag(byteBuffer);
    }

    public static int computeLazyFieldSize(int n2, LazyFieldLite lazyFieldLite) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeLazyFieldSizeNoTag(lazyFieldLite);
    }

    public static int computeUInt32Size(int n2, int n3) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeUInt32SizeNoTag(n3);
    }

    public static int computeEnumSize(int n2, int n3) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeEnumSizeNoTag(n3);
    }

    public static int computeSFixed32Size(int n2, int n3) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeSFixed32SizeNoTag(n3);
    }

    public static int computeSFixed64Size(int n2, long l2) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeSFixed64SizeNoTag(l2);
    }

    public static int computeSInt32Size(int n2, int n3) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeSInt32SizeNoTag(n3);
    }

    public static int computeSInt64Size(int n2, long l2) {
        return CodedOutputStream.computeTagSize(n2) + CodedOutputStream.computeSInt64SizeNoTag(l2);
    }

    public static int computeMessageSetExtensionSize(int n2, MessageLite messageLite) {
        return CodedOutputStream.computeTagSize(1) * 2 + CodedOutputStream.computeUInt32Size(2, n2) + CodedOutputStream.computeMessageSize(3, messageLite);
    }

    public static int computeRawMessageSetExtensionSize(int n2, ByteString byteString) {
        return CodedOutputStream.computeTagSize(1) * 2 + CodedOutputStream.computeUInt32Size(2, n2) + CodedOutputStream.computeBytesSize(3, byteString);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int n2, LazyFieldLite lazyFieldLite) {
        return CodedOutputStream.computeTagSize(1) * 2 + CodedOutputStream.computeUInt32Size(2, n2) + CodedOutputStream.computeLazyFieldSize(3, lazyFieldLite);
    }

    public static int computeDoubleSizeNoTag(double d2) {
        return 8;
    }

    public static int computeFloatSizeNoTag(float f2) {
        return 4;
    }

    public static int computeUInt64SizeNoTag(long l2) {
        return CodedOutputStream.computeRawVarint64Size(l2);
    }

    public static int computeInt64SizeNoTag(long l2) {
        return CodedOutputStream.computeRawVarint64Size(l2);
    }

    public static int computeInt32SizeNoTag(int n2) {
        if (n2 < 0) return 10;
        return CodedOutputStream.computeRawVarint32Size(n2);
    }

    public static int computeFixed64SizeNoTag(long l2) {
        return 8;
    }

    public static int computeFixed32SizeNoTag(int n2) {
        return 4;
    }

    public static int computeBoolSizeNoTag(boolean bl2) {
        return 1;
    }

    public static int computeStringSizeNoTag(String string) {
        byte[] arrby = string.getBytes(Internal.UTF_8);
        return CodedOutputStream.computeRawVarint32Size(arrby.length) + arrby.length;
    }

    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    @Deprecated
    public static int computeUnknownGroupSizeNoTag(MessageLite messageLite) {
        return CodedOutputStream.computeGroupSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        int n2 = messageLite.getSerializedSize();
        return CodedOutputStream.computeRawVarint32Size(n2) + n2;
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        int n2 = lazyFieldLite.getSerializedSize();
        return CodedOutputStream.computeRawVarint32Size(n2) + n2;
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return CodedOutputStream.computeRawVarint32Size(byteString.size()) + byteString.size();
    }

    public static int computeByteArraySizeNoTag(byte[] arrby) {
        return CodedOutputStream.computeRawVarint32Size(arrby.length) + arrby.length;
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return CodedOutputStream.computeRawVarint32Size(byteBuffer.capacity()) + byteBuffer.capacity();
    }

    public static int computeUInt32SizeNoTag(int n2) {
        return CodedOutputStream.computeRawVarint32Size(n2);
    }

    public static int computeEnumSizeNoTag(int n2) {
        return CodedOutputStream.computeInt32SizeNoTag(n2);
    }

    public static int computeSFixed32SizeNoTag(int n2) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long l2) {
        return 8;
    }

    public static int computeSInt32SizeNoTag(int n2) {
        return CodedOutputStream.computeRawVarint32Size(CodedOutputStream.encodeZigZag32(n2));
    }

    public static int computeSInt64SizeNoTag(long l2) {
        return CodedOutputStream.computeRawVarint64Size(CodedOutputStream.encodeZigZag64(l2));
    }

    private void refreshBuffer() {
        if (this.output == null) {
            throw new CodedOutputStream$OutOfSpaceException();
        }
        this.output.write(this.buffer, 0, this.position);
        this.position = 0;
    }

    public void flush() {
        if (this.output == null) return;
        this.refreshBuffer();
    }

    public int spaceLeft() {
        if (this.output != null) throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
        return this.limit - this.position;
    }

    public void checkNoSpaceLeft() {
        if (this.spaceLeft() == 0) return;
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public int getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public void writeRawByte(byte by2) {
        if (this.position == this.limit) {
            this.refreshBuffer();
        }
        this.buffer[this.position++] = by2;
        ++this.totalBytesWritten;
    }

    public void writeRawByte(int n2) {
        this.writeRawByte((byte)n2);
    }

    public void writeRawBytes(ByteString byteString) {
        this.writeRawBytes(byteString, 0, byteString.size());
    }

    public void writeRawBytes(byte[] arrby) {
        this.writeRawBytes(arrby, 0, arrby.length);
    }

    public void writeRawBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            this.writeRawBytes(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            return;
        }
        ByteBuffer byteBuffer2 = byteBuffer.duplicate();
        byteBuffer2.clear();
        this.writeRawBytesInternal(byteBuffer2);
    }

    private void writeRawBytesInternal(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.remaining();
        if (this.limit - this.position >= n2) {
            byteBuffer.get(this.buffer, this.position, n2);
            this.position += n2;
            this.totalBytesWritten += n2;
            return;
        }
        int n3 = this.limit - this.position;
        byteBuffer.get(this.buffer, this.position, n3);
        n2 -= n3;
        this.position = this.limit;
        this.totalBytesWritten += n3;
        this.refreshBuffer();
        do {
            if (n2 <= this.limit) {
                byteBuffer.get(this.buffer, 0, n2);
                this.position = n2;
                this.totalBytesWritten += n2;
                return;
            }
            byteBuffer.get(this.buffer, 0, this.limit);
            this.output.write(this.buffer, 0, this.limit);
            n2 -= this.limit;
            this.totalBytesWritten += this.limit;
        } while (true);
    }

    public void writeRawBytes(byte[] arrby, int n2, int n3) {
        if (this.limit - this.position >= n3) {
            System.arraycopy(arrby, n2, this.buffer, this.position, n3);
            this.position += n3;
            this.totalBytesWritten += n3;
            return;
        }
        int n4 = this.limit - this.position;
        System.arraycopy(arrby, n2, this.buffer, this.position, n4);
        n2 += n4;
        this.position = this.limit;
        this.totalBytesWritten += n4;
        this.refreshBuffer();
        if ((n3 -= n4) <= this.limit) {
            System.arraycopy(arrby, n2, this.buffer, 0, n3);
            this.position = n3;
        } else {
            this.output.write(arrby, n2, n3);
        }
        this.totalBytesWritten += n3;
    }

    public void writeRawBytes(ByteString byteString, int n2, int n3) {
        if (this.limit - this.position >= n3) {
            byteString.copyTo(this.buffer, n2, this.position, n3);
            this.position += n3;
            this.totalBytesWritten += n3;
            return;
        }
        int n4 = this.limit - this.position;
        byteString.copyTo(this.buffer, n2, this.position, n4);
        n2 += n4;
        this.position = this.limit;
        this.totalBytesWritten += n4;
        this.refreshBuffer();
        if ((n3 -= n4) <= this.limit) {
            byteString.copyTo(this.buffer, n2, 0, n3);
            this.position = n3;
        } else {
            byteString.writeTo(this.output, n2, n3);
        }
        this.totalBytesWritten += n3;
    }

    public void writeTag(int n2, int n3) {
        this.writeRawVarint32(WireFormat.makeTag(n2, n3));
    }

    public static int computeTagSize(int n2) {
        return CodedOutputStream.computeRawVarint32Size(WireFormat.makeTag(n2, 0));
    }

    public void writeRawVarint32(int n2) {
        do {
            if ((n2 & -128) == 0) {
                this.writeRawByte(n2);
                return;
            }
            this.writeRawByte(n2 & 127 | 128);
            n2 >>>= 7;
        } while (true);
    }

    public static int computeRawVarint32Size(int n2) {
        if ((n2 & -128) == 0) {
            return 1;
        }
        if ((n2 & -16384) == 0) {
            return 2;
        }
        if ((n2 & -2097152) == 0) {
            return 3;
        }
        if ((n2 & -268435456) != 0) return 5;
        return 4;
    }

    public void writeRawVarint64(long l2) {
        do {
            if ((l2 & -128) == 0) {
                this.writeRawByte((int)l2);
                return;
            }
            this.writeRawByte((int)l2 & 127 | 128);
            l2 >>>= 7;
        } while (true);
    }

    public static int computeRawVarint64Size(long l2) {
        if ((l2 & -128) == 0) {
            return 1;
        }
        if ((l2 & -16384) == 0) {
            return 2;
        }
        if ((l2 & -2097152) == 0) {
            return 3;
        }
        if ((l2 & -268435456) == 0) {
            return 4;
        }
        if ((l2 & -34359738368L) == 0) {
            return 5;
        }
        if ((l2 & -4398046511104L) == 0) {
            return 6;
        }
        if ((l2 & -562949953421312L) == 0) {
            return 7;
        }
        if ((l2 & -72057594037927936L) == 0) {
            return 8;
        }
        if ((l2 & Long.MIN_VALUE) != 0) return 10;
        return 9;
    }

    public void writeRawLittleEndian32(int n2) {
        this.writeRawByte(n2 & 255);
        this.writeRawByte(n2 >> 8 & 255);
        this.writeRawByte(n2 >> 16 & 255);
        this.writeRawByte(n2 >> 24 & 255);
    }

    public void writeRawLittleEndian64(long l2) {
        this.writeRawByte((int)l2 & 255);
        this.writeRawByte((int)(l2 >> 8) & 255);
        this.writeRawByte((int)(l2 >> 16) & 255);
        this.writeRawByte((int)(l2 >> 24) & 255);
        this.writeRawByte((int)(l2 >> 32) & 255);
        this.writeRawByte((int)(l2 >> 40) & 255);
        this.writeRawByte((int)(l2 >> 48) & 255);
        this.writeRawByte((int)(l2 >> 56) & 255);
    }

    public static int encodeZigZag32(int n2) {
        return n2 << 1 ^ n2 >> 31;
    }

    public static long encodeZigZag64(long l2) {
        return l2 << 1 ^ l2 >> 63;
    }
}

