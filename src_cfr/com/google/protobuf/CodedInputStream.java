/*
 * Decompiled with CFR 0_115.
 */
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
import java.nio.charset.Charset;
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

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    public static CodedInputStream newInstance(byte[] arrby) {
        return CodedInputStream.newInstance(arrby, 0, arrby.length);
    }

    public static CodedInputStream newInstance(byte[] arrby, int n2, int n3) {
        CodedInputStream codedInputStream = new CodedInputStream(arrby, n2, n3);
        try {
            codedInputStream.pushLimit(n3);
            return codedInputStream;
        }
        catch (InvalidProtocolBufferException var4_4) {
            throw new IllegalArgumentException(var4_4);
        }
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return CodedInputStream.newInstance(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        ByteBuffer byteBuffer2 = byteBuffer.duplicate();
        byte[] arrby = new byte[byteBuffer2.remaining()];
        byteBuffer2.get(arrby);
        return CodedInputStream.newInstance(arrby);
    }

    static CodedInputStream newInstance(LiteralByteString literalByteString) {
        CodedInputStream codedInputStream = new CodedInputStream(literalByteString);
        try {
            codedInputStream.pushLimit(literalByteString.size());
            return codedInputStream;
        }
        catch (InvalidProtocolBufferException var2_2) {
            throw new IllegalArgumentException(var2_2);
        }
    }

    public int readTag() {
        if (this.isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        this.lastTag = this.readRawVarint32();
        if (WireFormat.getTagFieldNumber(this.lastTag) != 0) return this.lastTag;
        throw InvalidProtocolBufferException.invalidTag();
    }

    public void checkLastTagWas(int n2) {
        if (this.lastTag == n2) return;
        throw InvalidProtocolBufferException.invalidEndTag();
    }

    public int getLastTag() {
        return this.lastTag;
    }

    public boolean skipField(int n2) {
        switch (WireFormat.getTagWireType(n2)) {
            case 0: {
                this.skipRawVarint();
                return true;
            }
            case 1: {
                this.skipRawBytes(8);
                return true;
            }
            case 2: {
                this.skipRawBytes(this.readRawVarint32());
                return true;
            }
            case 3: {
                this.skipMessage();
                this.checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(n2), 4));
                return true;
            }
            case 4: {
                return false;
            }
            case 5: {
                this.skipRawBytes(4);
                return true;
            }
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public boolean skipField(int n2, CodedOutputStream codedOutputStream) {
        switch (WireFormat.getTagWireType(n2)) {
            case 0: {
                long l2 = this.readInt64();
                codedOutputStream.writeRawVarint32(n2);
                codedOutputStream.writeUInt64NoTag(l2);
                return true;
            }
            case 1: {
                long l3 = this.readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(n2);
                codedOutputStream.writeFixed64NoTag(l3);
                return true;
            }
            case 2: {
                ByteString byteString = this.readBytes();
                codedOutputStream.writeRawVarint32(n2);
                codedOutputStream.writeBytesNoTag(byteString);
                return true;
            }
            case 3: {
                codedOutputStream.writeRawVarint32(n2);
                this.skipMessage(codedOutputStream);
                int n3 = WireFormat.makeTag(WireFormat.getTagFieldNumber(n2), 4);
                this.checkLastTagWas(n3);
                codedOutputStream.writeRawVarint32(n3);
                return true;
            }
            case 4: {
                return false;
            }
            case 5: {
                int n4 = this.readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(n2);
                codedOutputStream.writeFixed32NoTag(n4);
                return true;
            }
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public void skipMessage() {
        int n2;
        do {
            if ((n2 = this.readTag()) == 0) return;
        } while (this.skipField(n2));
    }

    public void skipMessage(CodedOutputStream codedOutputStream) {
        int n2;
        do {
            if ((n2 = this.readTag()) == 0) return;
        } while (this.skipField(n2, codedOutputStream));
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
        if (this.readRawVarint64() == 0) return false;
        return true;
    }

    public String readString() {
        int n2 = this.readRawVarint32();
        if (n2 <= this.bufferSize - this.bufferPos && n2 > 0) {
            String string = new String(this.buffer, this.bufferPos, n2, Internal.UTF_8);
            this.bufferPos += n2;
            return string;
        }
        if (n2 != 0) return new String(this.readRawBytesSlowPath(n2), Internal.UTF_8);
        return "";
    }

    public String readStringRequireUtf8() {
        byte[] arrby;
        int n2;
        int n3 = this.readRawVarint32();
        if (n3 <= this.bufferSize - (n2 = this.bufferPos) && n3 > 0) {
            arrby = this.buffer;
            this.bufferPos = n2 + n3;
        } else {
            if (n3 == 0) {
                return "";
            }
            arrby = this.readRawBytesSlowPath(n3);
            n2 = 0;
        }
        if (Utf8.isValidUtf8(arrby, n2, n2 + n3)) return new String(arrby, n2, n3, Internal.UTF_8);
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public void readGroup(int n2, MessageLite$Builder messageLite$Builder, ExtensionRegistryLite extensionRegistryLite) {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        ++this.recursionDepth;
        messageLite$Builder.mergeFrom(this, extensionRegistryLite);
        this.checkLastTagWas(WireFormat.makeTag(n2, 4));
        --this.recursionDepth;
    }

    public MessageLite readGroup(int n2, Parser parser, ExtensionRegistryLite extensionRegistryLite) {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        ++this.recursionDepth;
        MessageLite messageLite = (MessageLite)parser.parsePartialFrom(this, extensionRegistryLite);
        this.checkLastTagWas(WireFormat.makeTag(n2, 4));
        --this.recursionDepth;
        return messageLite;
    }

    @Deprecated
    public void readUnknownGroup(int n2, MessageLite$Builder messageLite$Builder) {
        this.readGroup(n2, messageLite$Builder, null);
    }

    public void readMessage(MessageLite$Builder messageLite$Builder, ExtensionRegistryLite extensionRegistryLite) {
        int n2 = this.readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int n3 = this.pushLimit(n2);
        ++this.recursionDepth;
        messageLite$Builder.mergeFrom(this, extensionRegistryLite);
        this.checkLastTagWas(0);
        --this.recursionDepth;
        this.popLimit(n3);
    }

    public MessageLite readMessage(Parser parser, ExtensionRegistryLite extensionRegistryLite) {
        int n2 = this.readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int n3 = this.pushLimit(n2);
        ++this.recursionDepth;
        MessageLite messageLite = (MessageLite)parser.parsePartialFrom(this, extensionRegistryLite);
        this.checkLastTagWas(0);
        --this.recursionDepth;
        this.popLimit(n3);
        return messageLite;
    }

    public ByteString readBytes() {
        int n2 = this.readRawVarint32();
        if (n2 <= this.bufferSize - this.bufferPos && n2 > 0) {
            ByteString byteString = this.bufferIsImmutable && this.enableAliasing ? new BoundedByteString(this.buffer, this.bufferPos, n2) : ByteString.copyFrom(this.buffer, this.bufferPos, n2);
            this.bufferPos += n2;
            return byteString;
        }
        if (n2 != 0) return new LiteralByteString(this.readRawBytesSlowPath(n2));
        return ByteString.EMPTY;
    }

    public byte[] readByteArray() {
        int n2 = this.readRawVarint32();
        if (n2 > this.bufferSize - this.bufferPos) return this.readRawBytesSlowPath(n2);
        if (n2 <= 0) return this.readRawBytesSlowPath(n2);
        byte[] arrby = Arrays.copyOfRange(this.buffer, this.bufferPos, this.bufferPos + n2);
        this.bufferPos += n2;
        return arrby;
    }

    public ByteBuffer readByteBuffer() {
        int n2 = this.readRawVarint32();
        if (n2 <= this.bufferSize - this.bufferPos && n2 > 0) {
            ByteBuffer byteBuffer = this.input == null && !this.bufferIsImmutable && this.enableAliasing ? ByteBuffer.wrap(this.buffer, this.bufferPos, n2).slice() : ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, this.bufferPos, this.bufferPos + n2));
            this.bufferPos += n2;
            return byteBuffer;
        }
        if (n2 != 0) return ByteBuffer.wrap(this.readRawBytesSlowPath(n2));
        return Internal.EMPTY_BYTE_BUFFER;
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
        return CodedInputStream.decodeZigZag32(this.readRawVarint32());
    }

    public long readSInt64() {
        return CodedInputStream.decodeZigZag64(this.readRawVarint64());
    }

    public int readRawVarint32() {
        int n2;
        int n3 = this.bufferPos;
        if (this.bufferSize == n3) {
            return (int)this.readRawVarint64SlowPath();
        }
        byte[] arrby = this.buffer;
        if ((n2 = arrby[n3++]) >= 0) {
            this.bufferPos = n3;
            return n2;
        }
        if (this.bufferSize - n3 < 9) {
            return (int)this.readRawVarint64SlowPath();
        }
        if ((n2 ^= arrby[n3++] << 7) < 0) {
            n2 ^= -128;
        } else if ((n2 ^= arrby[n3++] << 14) >= 0) {
            n2 ^= 16256;
        } else if ((n2 ^= arrby[n3++] << 21) < 0) {
            n2 ^= -2080896;
        } else {
            byte by2 = arrby[n3++];
            n2 ^= by2 << 28;
            n2 ^= 266354560;
            if (by2 < 0 && arrby[n3++] < 0 && arrby[n3++] < 0 && arrby[n3++] < 0 && arrby[n3++] < 0 && arrby[n3++] < 0) {
                return (int)this.readRawVarint64SlowPath();
            }
        }
        this.bufferPos = n3;
        return n2;
    }

    private void skipRawVarint() {
        if (this.bufferSize - this.bufferPos >= 10) {
            byte[] arrby = this.buffer;
            int n2 = this.bufferPos;
            for (int i2 = 0; i2 < 10; ++i2) {
                if (arrby[n2++] < 0) continue;
                this.bufferPos = n2;
                return;
            }
        }
        this.skipRawVarintSlowPath();
    }

    private void skipRawVarintSlowPath() {
        int n2 = 0;
        while (n2 < 10) {
            if (this.readRawByte() >= 0) {
                return;
            }
            ++n2;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    static int readRawVarint32(InputStream inputStream) {
        int n2 = inputStream.read();
        if (n2 != -1) return CodedInputStream.readRawVarint32(n2, inputStream);
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int readRawVarint32(int n2, InputStream inputStream) {
        int n3;
        int n4;
        if ((n2 & 128) == 0) {
            return n2;
        }
        int n5 = n2 & 127;
        for (n4 = 7; n4 < 32; n5 |= (n3 & 127) << n4, n4 += 7) {
            n3 = inputStream.read();
            if (n3 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((n3 & 128) != 0) continue;
            return n5;
        }
        while (n4 < 64) {
            n3 = inputStream.read();
            if (n3 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((n3 & 128) == 0) {
                return n5;
            }
            n4 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public long readRawVarint64() {
        long l2;
        int n2;
        int n3 = this.bufferPos;
        if (this.bufferSize == n3) {
            return this.readRawVarint64SlowPath();
        }
        byte[] arrby = this.buffer;
        if ((n2 = arrby[n3++]) >= 0) {
            this.bufferPos = n3;
            return n2;
        }
        if (this.bufferSize - n3 < 9) {
            return this.readRawVarint64SlowPath();
        }
        if ((n2 ^= arrby[n3++] << 7) < 0) {
            l2 = n2 ^ -128;
        } else if ((n2 ^= arrby[n3++] << 14) >= 0) {
            l2 = n2 ^ 16256;
        } else if ((n2 ^= arrby[n3++] << 21) < 0) {
            l2 = n2 ^ -2080896;
        } else if ((l2 = (long)n2 ^ (long)arrby[n3++] << 28) >= 0) {
            l2 ^= 266354560;
        } else if ((l2 ^= (long)arrby[n3++] << 35) < 0) {
            l2 ^= -34093383808L;
        } else if ((l2 ^= (long)arrby[n3++] << 42) >= 0) {
            l2 ^= 4363953127296L;
        } else if ((l2 ^= (long)arrby[n3++] << 49) < 0) {
            l2 ^= -558586000294016L;
        } else {
            l2 ^= (long)arrby[n3++] << 56;
            if ((l2 ^= 71499008037633920L) < 0 && (long)arrby[n3++] < 0) {
                return this.readRawVarint64SlowPath();
            }
        }
        this.bufferPos = n3;
        return l2;
    }

    long readRawVarint64SlowPath() {
        long l2 = 0;
        int n2 = 0;
        while (n2 < 64) {
            byte by2 = this.readRawByte();
            l2 |= (long)(by2 & 127) << n2;
            if ((by2 & 128) == 0) {
                return l2;
            }
            n2 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int readRawLittleEndian32() {
        int n2 = this.bufferPos;
        if (this.bufferSize - n2 < 4) {
            this.refillBuffer(4);
            n2 = this.bufferPos;
        }
        byte[] arrby = this.buffer;
        this.bufferPos = n2 + 4;
        return arrby[n2] & 255 | (arrby[n2 + 1] & 255) << 8 | (arrby[n2 + 2] & 255) << 16 | (arrby[n2 + 3] & 255) << 24;
    }

    public long readRawLittleEndian64() {
        int n2 = this.bufferPos;
        if (this.bufferSize - n2 < 8) {
            this.refillBuffer(8);
            n2 = this.bufferPos;
        }
        byte[] arrby = this.buffer;
        this.bufferPos = n2 + 8;
        return (long)arrby[n2] & 255 | ((long)arrby[n2 + 1] & 255) << 8 | ((long)arrby[n2 + 2] & 255) << 16 | ((long)arrby[n2 + 3] & 255) << 24 | ((long)arrby[n2 + 4] & 255) << 32 | ((long)arrby[n2 + 5] & 255) << 40 | ((long)arrby[n2 + 6] & 255) << 48 | ((long)arrby[n2 + 7] & 255) << 56;
    }

    public static int decodeZigZag32(int n2) {
        return n2 >>> 1 ^ - (n2 & 1);
    }

    public static long decodeZigZag64(long l2) {
        return l2 >>> 1 ^ - (l2 & 1);
    }

    private CodedInputStream(byte[] arrby, int n2, int n3) {
        this.buffer = arrby;
        this.bufferSize = n2 + n3;
        this.bufferPos = n2;
        this.totalBytesRetired = - n2;
        this.input = null;
        this.bufferIsImmutable = false;
    }

    private CodedInputStream(InputStream inputStream) {
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = inputStream;
        this.bufferIsImmutable = false;
    }

    private CodedInputStream(LiteralByteString literalByteString) {
        this.buffer = literalByteString.bytes;
        this.bufferPos = literalByteString.getOffsetIntoBytes();
        this.bufferSize = this.bufferPos + literalByteString.size();
        this.totalBytesRetired = - this.bufferPos;
        this.input = null;
        this.bufferIsImmutable = true;
    }

    public void enableAliasing(boolean bl2) {
        this.enableAliasing = bl2;
    }

    public int setRecursionLimit(int n2) {
        if (n2 < 0) {
            int n3 = n2;
            throw new IllegalArgumentException(new StringBuilder(47).append("Recursion limit cannot be negative: ").append(n3).toString());
        }
        int n4 = this.recursionLimit;
        this.recursionLimit = n2;
        return n4;
    }

    public int setSizeLimit(int n2) {
        if (n2 < 0) {
            int n3 = n2;
            throw new IllegalArgumentException(new StringBuilder(42).append("Size limit cannot be negative: ").append(n3).toString());
        }
        int n4 = this.sizeLimit;
        this.sizeLimit = n2;
        return n4;
    }

    public void resetSizeCounter() {
        this.totalBytesRetired = - this.bufferPos;
    }

    public int pushLimit(int n2) {
        if (n2 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int n3 = this.currentLimit;
        if ((n2 += this.totalBytesRetired + this.bufferPos) > n3) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.currentLimit = n2;
        this.recomputeBufferSizeAfterLimit();
        return n3;
    }

    private void recomputeBufferSizeAfterLimit() {
        this.bufferSize += this.bufferSizeAfterLimit;
        int n2 = this.totalBytesRetired + this.bufferSize;
        if (n2 > this.currentLimit) {
            this.bufferSizeAfterLimit = n2 - this.currentLimit;
            this.bufferSize -= this.bufferSizeAfterLimit;
            return;
        }
        this.bufferSizeAfterLimit = 0;
    }

    public void popLimit(int n2) {
        this.currentLimit = n2;
        this.recomputeBufferSizeAfterLimit();
    }

    public int getBytesUntilLimit() {
        if (this.currentLimit == Integer.MAX_VALUE) {
            return -1;
        }
        int n2 = this.totalBytesRetired + this.bufferPos;
        return this.currentLimit - n2;
    }

    public boolean isAtEnd() {
        if (this.bufferPos != this.bufferSize) return false;
        if (this.tryRefillBuffer(1)) return false;
        return true;
    }

    public int getTotalBytesRead() {
        return this.totalBytesRetired + this.bufferPos;
    }

    private void ensureAvailable(int n2) {
        if (this.bufferSize - this.bufferPos >= n2) return;
        this.refillBuffer(n2);
    }

    private void refillBuffer(int n2) {
        if (this.tryRefillBuffer(n2)) return;
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private boolean tryRefillBuffer(int n2) {
        int n3;
        if (this.bufferPos + n2 <= this.bufferSize) {
            int n4 = n2;
            throw new IllegalStateException(new StringBuilder(77).append("refillBuffer() called when ").append(n4).append(" bytes were already available in buffer").toString());
        }
        if (this.totalBytesRetired + this.bufferPos + n2 > this.currentLimit) {
            return false;
        }
        if (this.refillCallback != null) {
            this.refillCallback.onRefill();
        }
        if (this.input == null) return false;
        int n5 = this.bufferPos;
        if (n5 > 0) {
            if (this.bufferSize > n5) {
                System.arraycopy(this.buffer, n5, this.buffer, 0, this.bufferSize - n5);
            }
            this.totalBytesRetired += n5;
            this.bufferSize -= n5;
            this.bufferPos = 0;
        }
        if ((n3 = this.input.read(this.buffer, this.bufferSize, this.buffer.length - this.bufferSize)) == 0 || n3 < -1 || n3 > this.buffer.length) {
            int n6 = n3;
            throw new IllegalStateException(new StringBuilder(102).append("InputStream#read(byte[]) returned invalid result: ").append(n6).append("\nThe InputStream implementation is buggy.").toString());
        }
        if (n3 <= 0) return false;
        this.bufferSize += n3;
        if (this.totalBytesRetired + n2 - this.sizeLimit > 0) {
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        }
        this.recomputeBufferSizeAfterLimit();
        if (this.bufferSize >= n2) {
            return true;
        }
        boolean bl2 = this.tryRefillBuffer(n2);
        return bl2;
    }

    public byte readRawByte() {
        if (this.bufferPos != this.bufferSize) return this.buffer[this.bufferPos++];
        this.refillBuffer(1);
        return this.buffer[this.bufferPos++];
    }

    public byte[] readRawBytes(int n2) {
        int n3 = this.bufferPos;
        if (n2 > this.bufferSize - n3) return this.readRawBytesSlowPath(n2);
        if (n2 <= 0) return this.readRawBytesSlowPath(n2);
        this.bufferPos = n3 + n2;
        return Arrays.copyOfRange(this.buffer, n3, n3 + n2);
    }

    private byte[] readRawBytesSlowPath(int n2) {
        int n3;
        byte[] arrby;
        if (n2 <= 0) {
            if (n2 != 0) throw InvalidProtocolBufferException.negativeSize();
            return Internal.EMPTY_BYTE_ARRAY;
        }
        if (this.totalBytesRetired + this.bufferPos + n2 > this.currentLimit) {
            this.skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (n2 < 4096) {
            byte[] arrby2 = new byte[n2];
            int n4 = this.bufferSize - this.bufferPos;
            System.arraycopy(this.buffer, this.bufferPos, arrby2, 0, n4);
            this.bufferPos = this.bufferSize;
            this.ensureAvailable(n2 - n4);
            System.arraycopy(this.buffer, 0, arrby2, n4, n2 - n4);
            this.bufferPos = n2 - n4;
            return arrby2;
        }
        int n5 = this.bufferPos;
        int n6 = this.bufferSize;
        this.totalBytesRetired += this.bufferSize;
        this.bufferPos = 0;
        this.bufferSize = 0;
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        for (int i2 = n2 - (n6 - n5); i2 > 0; i2 -= arrby.length) {
            int n7;
            arrby = new byte[Math.min(i2, 4096)];
            for (n3 = 0; n3 < arrby.length; this.totalBytesRetired += n7, n3 += n7) {
                int n8 = n7 = this.input == null ? -1 : this.input.read(arrby, n3, arrby.length - n3);
                if (n7 != -1) continue;
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            arrayList.add(arrby);
        }
        arrby = new byte[n2];
        n3 = n6 - n5;
        System.arraycopy(this.buffer, n5, arrby, 0, n3);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            byte[] arrby3 = (byte[])iterator.next();
            System.arraycopy(arrby3, 0, arrby, n3, arrby3.length);
            n3 += arrby3.length;
        }
        return arrby;
    }

    public void skipRawBytes(int n2) {
        if (n2 <= this.bufferSize - this.bufferPos && n2 >= 0) {
            this.bufferPos += n2;
            return;
        }
        this.skipRawBytesSlowPath(n2);
    }

    private void skipRawBytesSlowPath(int n2) {
        if (n2 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (this.totalBytesRetired + this.bufferPos + n2 > this.currentLimit) {
            this.skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int n3 = this.bufferSize - this.bufferPos;
        this.bufferPos = this.bufferSize;
        this.refillBuffer(1);
        do {
            if (n2 - n3 <= this.bufferSize) {
                this.bufferPos = n2 - n3;
                return;
            }
            n3 += this.bufferSize;
            this.bufferPos = this.bufferSize;
            this.refillBuffer(1);
        } while (true);
    }

    static /* synthetic */ int access$000(CodedInputStream codedInputStream) {
        return codedInputStream.bufferPos;
    }

    static /* synthetic */ byte[] access$100(CodedInputStream codedInputStream) {
        return codedInputStream.buffer;
    }
}

