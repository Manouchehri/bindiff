package com.google.protobuf;

import java.io.*;
import java.nio.*;
import java.util.*;

public final class CodedInputStream
{
    private final byte[] buffer;
    private final boolean bufferIsImmutable;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int bufferPos;
    private final InputStream input;
    private int lastTag;
    private boolean enableAliasing;
    private int totalBytesRetired;
    private int currentLimit;
    private int recursionDepth;
    private int recursionLimit;
    private int sizeLimit;
    private static final int DEFAULT_RECURSION_LIMIT = 100;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private static final int BUFFER_SIZE = 4096;
    private CodedInputStream$RefillCallback refillCallback;
    
    public static CodedInputStream newInstance(final InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }
    
    public static CodedInputStream newInstance(final byte[] array) {
        return newInstance(array, 0, array.length);
    }
    
    public static CodedInputStream newInstance(final byte[] array, final int n, final int n2) {
        final CodedInputStream codedInputStream = new CodedInputStream(array, n, n2);
        try {
            codedInputStream.pushLimit(n2);
        }
        catch (InvalidProtocolBufferException ex) {
            throw new IllegalArgumentException(ex);
        }
        return codedInputStream;
    }
    
    public static CodedInputStream newInstance(final ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return newInstance(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        final ByteBuffer duplicate = byteBuffer.duplicate();
        final byte[] array = new byte[duplicate.remaining()];
        duplicate.get(array);
        return newInstance(array);
    }
    
    static CodedInputStream newInstance(final LiteralByteString literalByteString) {
        final CodedInputStream codedInputStream = new CodedInputStream(literalByteString);
        try {
            codedInputStream.pushLimit(literalByteString.size());
        }
        catch (InvalidProtocolBufferException ex) {
            throw new IllegalArgumentException(ex);
        }
        return codedInputStream;
    }
    
    public int readTag() {
        if (this.isAtEnd()) {
            return this.lastTag = 0;
        }
        this.lastTag = this.readRawVarint32();
        if (WireFormat.getTagFieldNumber(this.lastTag) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        return this.lastTag;
    }
    
    public void checkLastTagWas(final int n) {
        if (this.lastTag != n) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }
    
    public int getLastTag() {
        return this.lastTag;
    }
    
    public boolean skipField(final int n) {
        switch (WireFormat.getTagWireType(n)) {
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
                this.checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(n), 4));
                return true;
            }
            case 4: {
                return false;
            }
            case 5: {
                this.skipRawBytes(4);
                return true;
            }
            default: {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }
    
    public boolean skipField(final int n, final CodedOutputStream codedOutputStream) {
        switch (WireFormat.getTagWireType(n)) {
            case 0: {
                final long int64 = this.readInt64();
                codedOutputStream.writeRawVarint32(n);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            case 1: {
                final long rawLittleEndian64 = this.readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(n);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            case 2: {
                final ByteString bytes = this.readBytes();
                codedOutputStream.writeRawVarint32(n);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            case 3: {
                codedOutputStream.writeRawVarint32(n);
                this.skipMessage(codedOutputStream);
                final int tag = WireFormat.makeTag(WireFormat.getTagFieldNumber(n), 4);
                this.checkLastTagWas(tag);
                codedOutputStream.writeRawVarint32(tag);
                return true;
            }
            case 4: {
                return false;
            }
            case 5: {
                final int rawLittleEndian65 = this.readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(n);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian65);
                return true;
            }
            default: {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }
    
    public void skipMessage() {
        int tag;
        do {
            tag = this.readTag();
        } while (tag != 0 && this.skipField(tag));
    }
    
    public void skipMessage(final CodedOutputStream codedOutputStream) {
        int tag;
        do {
            tag = this.readTag();
        } while (tag != 0 && this.skipField(tag, codedOutputStream));
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
        final int rawVarint32 = this.readRawVarint32();
        if (rawVarint32 <= this.bufferSize - this.bufferPos && rawVarint32 > 0) {
            final String s = new String(this.buffer, this.bufferPos, rawVarint32, Internal.UTF_8);
            this.bufferPos += rawVarint32;
            return s;
        }
        if (rawVarint32 == 0) {
            return "";
        }
        return new String(this.readRawBytesSlowPath(rawVarint32), Internal.UTF_8);
    }
    
    public String readStringRequireUtf8() {
        final int rawVarint32 = this.readRawVarint32();
        int bufferPos = this.bufferPos;
        byte[] array;
        if (rawVarint32 <= this.bufferSize - bufferPos && rawVarint32 > 0) {
            array = this.buffer;
            this.bufferPos = bufferPos + rawVarint32;
        }
        else {
            if (rawVarint32 == 0) {
                return "";
            }
            array = this.readRawBytesSlowPath(rawVarint32);
            bufferPos = 0;
        }
        if (!Utf8.isValidUtf8(array, bufferPos, bufferPos + rawVarint32)) {
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        return new String(array, bufferPos, rawVarint32, Internal.UTF_8);
    }
    
    public void readGroup(final int n, final MessageLite$Builder messageLite$Builder, final ExtensionRegistryLite extensionRegistryLite) {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        ++this.recursionDepth;
        messageLite$Builder.mergeFrom(this, extensionRegistryLite);
        this.checkLastTagWas(WireFormat.makeTag(n, 4));
        --this.recursionDepth;
    }
    
    public MessageLite readGroup(final int n, final Parser parser, final ExtensionRegistryLite extensionRegistryLite) {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        ++this.recursionDepth;
        final MessageLite messageLite = (MessageLite)parser.parsePartialFrom(this, extensionRegistryLite);
        this.checkLastTagWas(WireFormat.makeTag(n, 4));
        --this.recursionDepth;
        return messageLite;
    }
    
    @Deprecated
    public void readUnknownGroup(final int n, final MessageLite$Builder messageLite$Builder) {
        this.readGroup(n, messageLite$Builder, null);
    }
    
    public void readMessage(final MessageLite$Builder messageLite$Builder, final ExtensionRegistryLite extensionRegistryLite) {
        final int rawVarint32 = this.readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        final int pushLimit = this.pushLimit(rawVarint32);
        ++this.recursionDepth;
        messageLite$Builder.mergeFrom(this, extensionRegistryLite);
        this.checkLastTagWas(0);
        --this.recursionDepth;
        this.popLimit(pushLimit);
    }
    
    public MessageLite readMessage(final Parser parser, final ExtensionRegistryLite extensionRegistryLite) {
        final int rawVarint32 = this.readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        final int pushLimit = this.pushLimit(rawVarint32);
        ++this.recursionDepth;
        final MessageLite messageLite = (MessageLite)parser.parsePartialFrom(this, extensionRegistryLite);
        this.checkLastTagWas(0);
        --this.recursionDepth;
        this.popLimit(pushLimit);
        return messageLite;
    }
    
    public ByteString readBytes() {
        final int rawVarint32 = this.readRawVarint32();
        if (rawVarint32 <= this.bufferSize - this.bufferPos && rawVarint32 > 0) {
            final ByteString byteString = (this.bufferIsImmutable && this.enableAliasing) ? new BoundedByteString(this.buffer, this.bufferPos, rawVarint32) : ByteString.copyFrom(this.buffer, this.bufferPos, rawVarint32);
            this.bufferPos += rawVarint32;
            return byteString;
        }
        if (rawVarint32 == 0) {
            return ByteString.EMPTY;
        }
        return new LiteralByteString(this.readRawBytesSlowPath(rawVarint32));
    }
    
    public byte[] readByteArray() {
        final int rawVarint32 = this.readRawVarint32();
        if (rawVarint32 <= this.bufferSize - this.bufferPos && rawVarint32 > 0) {
            final byte[] copyOfRange = Arrays.copyOfRange(this.buffer, this.bufferPos, this.bufferPos + rawVarint32);
            this.bufferPos += rawVarint32;
            return copyOfRange;
        }
        return this.readRawBytesSlowPath(rawVarint32);
    }
    
    public ByteBuffer readByteBuffer() {
        final int rawVarint32 = this.readRawVarint32();
        if (rawVarint32 <= this.bufferSize - this.bufferPos && rawVarint32 > 0) {
            final ByteBuffer byteBuffer = (this.input == null && !this.bufferIsImmutable && this.enableAliasing) ? ByteBuffer.wrap(this.buffer, this.bufferPos, rawVarint32).slice() : ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, this.bufferPos, this.bufferPos + rawVarint32));
            this.bufferPos += rawVarint32;
            return byteBuffer;
        }
        if (rawVarint32 == 0) {
            return Internal.EMPTY_BYTE_BUFFER;
        }
        return ByteBuffer.wrap(this.readRawBytesSlowPath(rawVarint32));
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
        int bufferPos = this.bufferPos;
        if (this.bufferSize != bufferPos) {
            final byte[] buffer = this.buffer;
            final byte b;
            if ((b = buffer[bufferPos++]) >= 0) {
                this.bufferPos = bufferPos;
                return b;
            }
            if (this.bufferSize - bufferPos >= 9) {
                final int n;
                int n2;
                if ((n = (b ^ buffer[bufferPos++] << 7)) < 0) {
                    n2 = (n ^ 0xFFFFFF80);
                }
                else {
                    final int n3;
                    if ((n3 = (n ^ buffer[bufferPos++] << 14)) >= 0) {
                        n2 = (n3 ^ 0x3F80);
                    }
                    else {
                        final int n4;
                        if ((n4 = (n3 ^ buffer[bufferPos++] << 21)) < 0) {
                            n2 = (n4 ^ 0xFFE03F80);
                        }
                        else {
                            final byte b2 = buffer[bufferPos++];
                            n2 = (n4 ^ b2 << 28 ^ 0xFE03F80);
                            if (b2 < 0 && buffer[bufferPos++] < 0 && buffer[bufferPos++] < 0 && buffer[bufferPos++] < 0 && buffer[bufferPos++] < 0 && buffer[bufferPos++] < 0) {
                                return (int)this.readRawVarint64SlowPath();
                            }
                        }
                    }
                }
                this.bufferPos = bufferPos;
                return n2;
            }
        }
        return (int)this.readRawVarint64SlowPath();
    }
    
    private void skipRawVarint() {
        if (this.bufferSize - this.bufferPos >= 10) {
            final byte[] buffer = this.buffer;
            int bufferPos = this.bufferPos;
            for (int i = 0; i < 10; ++i) {
                if (buffer[bufferPos++] >= 0) {
                    this.bufferPos = bufferPos;
                    return;
                }
            }
        }
        this.skipRawVarintSlowPath();
    }
    
    private void skipRawVarintSlowPath() {
        for (int i = 0; i < 10; ++i) {
            if (this.readRawByte() >= 0) {
                return;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }
    
    static int readRawVarint32(final InputStream inputStream) {
        final int read = inputStream.read();
        if (read == -1) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        return readRawVarint32(read, inputStream);
    }
    
    public static int readRawVarint32(final int n, final InputStream inputStream) {
        if ((n & 0x80) == 0x0) {
            return n;
        }
        int n2 = n & 0x7F;
        int i;
        for (i = 7; i < 32; i += 7) {
            final int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            n2 |= (read & 0x7F) << i;
            if ((read & 0x80) == 0x0) {
                return n2;
            }
        }
        while (i < 64) {
            final int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 0x80) == 0x0) {
                return n2;
            }
            i += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }
    
    public long readRawVarint64() {
        int bufferPos = this.bufferPos;
        if (this.bufferSize != bufferPos) {
            final byte[] buffer = this.buffer;
            final byte b;
            if ((b = buffer[bufferPos++]) >= 0) {
                this.bufferPos = bufferPos;
                return b;
            }
            if (this.bufferSize - bufferPos >= 9) {
                final int n;
                long n2;
                if ((n = (b ^ buffer[bufferPos++] << 7)) < 0) {
                    n2 = (n ^ 0xFFFFFF80);
                }
                else {
                    final int n3;
                    if ((n3 = (n ^ buffer[bufferPos++] << 14)) >= 0) {
                        n2 = (n3 ^ 0x3F80);
                    }
                    else {
                        final int n4;
                        if ((n4 = (n3 ^ buffer[bufferPos++] << 21)) < 0) {
                            n2 = (n4 ^ 0xFFE03F80);
                        }
                        else {
                            final long n5;
                            if ((n5 = (n4 ^ buffer[bufferPos++] << 28)) >= 0L) {
                                n2 = (n5 ^ 0xFE03F80L);
                            }
                            else {
                                final long n6;
                                if ((n6 = (n5 ^ buffer[bufferPos++] << 35)) < 0L) {
                                    n2 = (n6 ^ 0xFFFFFFF80FE03F80L);
                                }
                                else {
                                    final long n7;
                                    if ((n7 = (n6 ^ buffer[bufferPos++] << 42)) >= 0L) {
                                        n2 = (n7 ^ 0x3F80FE03F80L);
                                    }
                                    else {
                                        final long n8;
                                        if ((n8 = (n7 ^ buffer[bufferPos++] << 49)) < 0L) {
                                            n2 = (n8 ^ 0xFFFE03F80FE03F80L);
                                        }
                                        else {
                                            n2 = (n8 ^ buffer[bufferPos++] << 56 ^ 0xFE03F80FE03F80L);
                                            if (n2 < 0L && buffer[bufferPos++] < 0L) {
                                                return this.readRawVarint64SlowPath();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.bufferPos = bufferPos;
                return n2;
            }
        }
        return this.readRawVarint64SlowPath();
    }
    
    long readRawVarint64SlowPath() {
        long n = 0L;
        for (int i = 0; i < 64; i += 7) {
            final byte rawByte = this.readRawByte();
            n |= (rawByte & 0x7F) << i;
            if ((rawByte & 0x80) == 0x0) {
                return n;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }
    
    public int readRawLittleEndian32() {
        int n = this.bufferPos;
        if (this.bufferSize - n < 4) {
            this.refillBuffer(4);
            n = this.bufferPos;
        }
        final byte[] buffer = this.buffer;
        this.bufferPos = n + 4;
        return (buffer[n] & 0xFF) | (buffer[n + 1] & 0xFF) << 8 | (buffer[n + 2] & 0xFF) << 16 | (buffer[n + 3] & 0xFF) << 24;
    }
    
    public long readRawLittleEndian64() {
        int n = this.bufferPos;
        if (this.bufferSize - n < 8) {
            this.refillBuffer(8);
            n = this.bufferPos;
        }
        final byte[] buffer = this.buffer;
        this.bufferPos = n + 8;
        return (buffer[n] & 0xFFL) | (buffer[n + 1] & 0xFFL) << 8 | (buffer[n + 2] & 0xFFL) << 16 | (buffer[n + 3] & 0xFFL) << 24 | (buffer[n + 4] & 0xFFL) << 32 | (buffer[n + 5] & 0xFFL) << 40 | (buffer[n + 6] & 0xFFL) << 48 | (buffer[n + 7] & 0xFFL) << 56;
    }
    
    public static int decodeZigZag32(final int n) {
        return n >>> 1 ^ -(n & 0x1);
    }
    
    public static long decodeZigZag64(final long n) {
        return n >>> 1 ^ -(n & 0x1L);
    }
    
    private CodedInputStream(final byte[] buffer, final int bufferPos, final int n) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 100;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = buffer;
        this.bufferSize = bufferPos + n;
        this.bufferPos = bufferPos;
        this.totalBytesRetired = -bufferPos;
        this.input = null;
        this.bufferIsImmutable = false;
    }
    
    private CodedInputStream(final InputStream input) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 100;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = input;
        this.bufferIsImmutable = false;
    }
    
    private CodedInputStream(final LiteralByteString literalByteString) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 100;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = literalByteString.bytes;
        this.bufferPos = literalByteString.getOffsetIntoBytes();
        this.bufferSize = this.bufferPos + literalByteString.size();
        this.totalBytesRetired = -this.bufferPos;
        this.input = null;
        this.bufferIsImmutable = true;
    }
    
    public void enableAliasing(final boolean enableAliasing) {
        this.enableAliasing = enableAliasing;
    }
    
    public int setRecursionLimit(final int recursionLimit) {
        if (recursionLimit < 0) {
            throw new IllegalArgumentException(new StringBuilder(47).append("Recursion limit cannot be negative: ").append(recursionLimit).toString());
        }
        final int recursionLimit2 = this.recursionLimit;
        this.recursionLimit = recursionLimit;
        return recursionLimit2;
    }
    
    public int setSizeLimit(final int sizeLimit) {
        if (sizeLimit < 0) {
            throw new IllegalArgumentException(new StringBuilder(42).append("Size limit cannot be negative: ").append(sizeLimit).toString());
        }
        final int sizeLimit2 = this.sizeLimit;
        this.sizeLimit = sizeLimit;
        return sizeLimit2;
    }
    
    public void resetSizeCounter() {
        this.totalBytesRetired = -this.bufferPos;
    }
    
    public int pushLimit(int currentLimit) {
        if (currentLimit < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        currentLimit += this.totalBytesRetired + this.bufferPos;
        final int currentLimit2 = this.currentLimit;
        if (currentLimit > currentLimit2) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.currentLimit = currentLimit;
        this.recomputeBufferSizeAfterLimit();
        return currentLimit2;
    }
    
    private void recomputeBufferSizeAfterLimit() {
        this.bufferSize += this.bufferSizeAfterLimit;
        final int n = this.totalBytesRetired + this.bufferSize;
        if (n > this.currentLimit) {
            this.bufferSizeAfterLimit = n - this.currentLimit;
            this.bufferSize -= this.bufferSizeAfterLimit;
        }
        else {
            this.bufferSizeAfterLimit = 0;
        }
    }
    
    public void popLimit(final int currentLimit) {
        this.currentLimit = currentLimit;
        this.recomputeBufferSizeAfterLimit();
    }
    
    public int getBytesUntilLimit() {
        if (this.currentLimit == Integer.MAX_VALUE) {
            return -1;
        }
        return this.currentLimit - (this.totalBytesRetired + this.bufferPos);
    }
    
    public boolean isAtEnd() {
        return this.bufferPos == this.bufferSize && !this.tryRefillBuffer(1);
    }
    
    public int getTotalBytesRead() {
        return this.totalBytesRetired + this.bufferPos;
    }
    
    private void ensureAvailable(final int n) {
        if (this.bufferSize - this.bufferPos < n) {
            this.refillBuffer(n);
        }
    }
    
    private void refillBuffer(final int n) {
        if (!this.tryRefillBuffer(n)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }
    
    private boolean tryRefillBuffer(final int n) {
        if (this.bufferPos + n <= this.bufferSize) {
            throw new IllegalStateException(new StringBuilder(77).append("refillBuffer() called when ").append(n).append(" bytes were already available in buffer").toString());
        }
        if (this.totalBytesRetired + this.bufferPos + n > this.currentLimit) {
            return false;
        }
        if (this.refillCallback != null) {
            this.refillCallback.onRefill();
        }
        if (this.input != null) {
            final int bufferPos = this.bufferPos;
            if (bufferPos > 0) {
                if (this.bufferSize > bufferPos) {
                    System.arraycopy(this.buffer, bufferPos, this.buffer, 0, this.bufferSize - bufferPos);
                }
                this.totalBytesRetired += bufferPos;
                this.bufferSize -= bufferPos;
                this.bufferPos = 0;
            }
            final int read = this.input.read(this.buffer, this.bufferSize, this.buffer.length - this.bufferSize);
            if (read == 0 || read < -1 || read > this.buffer.length) {
                throw new IllegalStateException(new StringBuilder(102).append("InputStream#read(byte[]) returned invalid result: ").append(read).append("\nThe InputStream implementation is buggy.").toString());
            }
            if (read > 0) {
                this.bufferSize += read;
                if (this.totalBytesRetired + n - this.sizeLimit > 0) {
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
                this.recomputeBufferSizeAfterLimit();
                return this.bufferSize >= n || this.tryRefillBuffer(n);
            }
        }
        return false;
    }
    
    public byte readRawByte() {
        if (this.bufferPos == this.bufferSize) {
            this.refillBuffer(1);
        }
        return this.buffer[this.bufferPos++];
    }
    
    public byte[] readRawBytes(final int n) {
        final int bufferPos = this.bufferPos;
        if (n <= this.bufferSize - bufferPos && n > 0) {
            this.bufferPos = bufferPos + n;
            return Arrays.copyOfRange(this.buffer, bufferPos, bufferPos + n);
        }
        return this.readRawBytesSlowPath(n);
    }
    
    private byte[] readRawBytesSlowPath(final int n) {
        if (n <= 0) {
            if (n == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        else {
            if (this.totalBytesRetired + this.bufferPos + n > this.currentLimit) {
                this.skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (n < 4096) {
                final byte[] array = new byte[n];
                final int n2 = this.bufferSize - this.bufferPos;
                System.arraycopy(this.buffer, this.bufferPos, array, 0, n2);
                this.bufferPos = this.bufferSize;
                this.ensureAvailable(n - n2);
                System.arraycopy(this.buffer, 0, array, n2, n - n2);
                this.bufferPos = n - n2;
                return array;
            }
            final int bufferPos = this.bufferPos;
            final int bufferSize = this.bufferSize;
            this.totalBytesRetired += this.bufferSize;
            this.bufferPos = 0;
            this.bufferSize = 0;
            int i = n - (bufferSize - bufferPos);
            final ArrayList<byte[]> list = new ArrayList<byte[]>();
            while (i > 0) {
                final byte[] array2 = new byte[Math.min(i, 4096)];
                int n3;
                for (int j = 0; j < array2.length; j += n3) {
                    n3 = ((this.input == null) ? -1 : this.input.read(array2, j, array2.length - j));
                    if (n3 == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += n3;
                }
                i -= array2.length;
                list.add(array2);
            }
            final byte[] array3 = new byte[n];
            int n4 = bufferSize - bufferPos;
            System.arraycopy(this.buffer, bufferPos, array3, 0, n4);
            for (final byte[] array4 : list) {
                System.arraycopy(array4, 0, array3, n4, array4.length);
                n4 += array4.length;
            }
            return array3;
        }
    }
    
    public void skipRawBytes(final int n) {
        if (n <= this.bufferSize - this.bufferPos && n >= 0) {
            this.bufferPos += n;
        }
        else {
            this.skipRawBytesSlowPath(n);
        }
    }
    
    private void skipRawBytesSlowPath(final int n) {
        if (n < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (this.totalBytesRetired + this.bufferPos + n > this.currentLimit) {
            this.skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int n2 = this.bufferSize - this.bufferPos;
        this.bufferPos = this.bufferSize;
        this.refillBuffer(1);
        while (n - n2 > this.bufferSize) {
            n2 += this.bufferSize;
            this.bufferPos = this.bufferSize;
            this.refillBuffer(1);
        }
        this.bufferPos = n - n2;
    }
}
