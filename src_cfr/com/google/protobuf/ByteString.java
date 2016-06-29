/*
 * Decompiled with CFR 0_115.
 */
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

public abstract class ByteString
implements Serializable,
Iterable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    public static final ByteString EMPTY = new LiteralByteString(new byte[0]);

    ByteString() {
    }

    public abstract byte byteAt(int var1);

    public abstract ByteString$ByteIterator iterator();

    public abstract int size();

    public boolean isEmpty() {
        if (this.size() != 0) return false;
        return true;
    }

    public ByteString substring(int n2) {
        return this.substring(n2, this.size());
    }

    public abstract ByteString substring(int var1, int var2);

    public boolean startsWith(ByteString byteString) {
        if (this.size() < byteString.size()) return false;
        if (!this.substring(0, byteString.size()).equals(byteString)) return false;
        return true;
    }

    public boolean endsWith(ByteString byteString) {
        if (this.size() < byteString.size()) return false;
        if (!this.substring(this.size() - byteString.size()).equals(byteString)) return false;
        return true;
    }

    public static ByteString copyFrom(byte[] arrby, int n2, int n3) {
        byte[] arrby2 = new byte[n3];
        System.arraycopy(arrby, n2, arrby2, 0, n3);
        return new LiteralByteString(arrby2);
    }

    public static ByteString copyFrom(byte[] arrby) {
        return ByteString.copyFrom(arrby, 0, arrby.length);
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int n2) {
        byte[] arrby = new byte[n2];
        byteBuffer.get(arrby);
        return new LiteralByteString(arrby);
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return ByteString.copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(String string, String string2) {
        return new LiteralByteString(string.getBytes(string2));
    }

    public static ByteString copyFrom(String string, Charset charset) {
        return new LiteralByteString(string.getBytes(charset));
    }

    public static ByteString copyFromUtf8(String string) {
        return new LiteralByteString(string.getBytes(Internal.UTF_8));
    }

    public static ByteString readFrom(InputStream inputStream) {
        return ByteString.readFrom(inputStream, 256, 8192);
    }

    public static ByteString readFrom(InputStream inputStream, int n2) {
        return ByteString.readFrom(inputStream, n2, n2);
    }

    public static ByteString readFrom(InputStream inputStream, int n2, int n3) {
        ArrayList<ByteString> arrayList = new ArrayList<ByteString>();
        int n4 = n2;
        ByteString byteString;
        while ((byteString = ByteString.readChunk(inputStream, n4)) != null) {
            arrayList.add(byteString);
            n4 = Math.min(n4 * 2, n3);
        }
        return ByteString.copyFrom(arrayList);
    }

    private static ByteString readChunk(InputStream inputStream, int n2) {
        byte[] arrby = new byte[n2];
        int n3 = 0;
        while (n3 < n2) {
            int n4 = inputStream.read(arrby, n3, n2 - n3);
            if (n4 == -1) {
                if (n3 != 0) return ByteString.copyFrom(arrby, 0, n3);
                return null;
            }
            n3 += n4;
        }
        return null;
    }

    public ByteString concat(ByteString byteString) {
        int n2;
        int n3 = this.size();
        if ((long)n3 + (long)(n2 = byteString.size()) < Integer.MAX_VALUE) return RopeByteString.concatenate(this, byteString);
        int n4 = n3;
        int n5 = n2;
        throw new IllegalArgumentException(new StringBuilder(53).append("ByteString would be too long: ").append(n4).append("+").append(n5).toString());
    }

    public static ByteString copyFrom(Iterable iterable) {
        ArrayList<ByteString> arrayList;
        if (!(iterable instanceof Collection)) {
            arrayList = new ArrayList<ByteString>();
            for (ByteString byteString : iterable) {
                arrayList.add(byteString);
            }
        } else {
            arrayList = (ArrayList<ByteString>)iterable;
        }
        if (!arrayList.isEmpty()) return ByteString.balancedConcat(arrayList.iterator(), arrayList.size());
        return EMPTY;
    }

    private static ByteString balancedConcat(Iterator iterator, int n2) {
        assert (n2 >= 1);
        if (n2 == 1) {
            return (ByteString)iterator.next();
        }
        int n3 = n2 >>> 1;
        ByteString byteString = ByteString.balancedConcat(iterator, n3);
        ByteString byteString2 = ByteString.balancedConcat(iterator, n2 - n3);
        return byteString.concat(byteString2);
    }

    public void copyTo(byte[] arrby, int n2) {
        this.copyTo(arrby, 0, n2, this.size());
    }

    public void copyTo(byte[] arrby, int n2, int n3, int n4) {
        if (n2 < 0) {
            int n5 = n2;
            throw new IndexOutOfBoundsException(new StringBuilder(30).append("Source offset < 0: ").append(n5).toString());
        }
        if (n3 < 0) {
            int n6 = n3;
            throw new IndexOutOfBoundsException(new StringBuilder(30).append("Target offset < 0: ").append(n6).toString());
        }
        if (n4 < 0) {
            int n7 = n4;
            throw new IndexOutOfBoundsException(new StringBuilder(23).append("Length < 0: ").append(n7).toString());
        }
        if (n2 + n4 > this.size()) {
            int n8 = n2 + n4;
            throw new IndexOutOfBoundsException(new StringBuilder(34).append("Source end offset < 0: ").append(n8).toString());
        }
        if (n3 + n4 > arrby.length) {
            int n9 = n3 + n4;
            throw new IndexOutOfBoundsException(new StringBuilder(34).append("Target end offset < 0: ").append(n9).toString());
        }
        if (n4 <= 0) return;
        this.copyToInternal(arrby, n2, n3, n4);
    }

    protected abstract void copyToInternal(byte[] var1, int var2, int var3, int var4);

    public abstract void copyTo(ByteBuffer var1);

    public byte[] toByteArray() {
        int n2 = this.size();
        if (n2 == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] arrby = new byte[n2];
        this.copyToInternal(arrby, 0, 0, n2);
        return arrby;
    }

    public abstract void writeTo(OutputStream var1);

    void writeTo(OutputStream outputStream, int n2, int n3) {
        if (n2 < 0) {
            int n4 = n2;
            throw new IndexOutOfBoundsException(new StringBuilder(30).append("Source offset < 0: ").append(n4).toString());
        }
        if (n3 < 0) {
            int n5 = n3;
            throw new IndexOutOfBoundsException(new StringBuilder(23).append("Length < 0: ").append(n5).toString());
        }
        if (n2 + n3 > this.size()) {
            int n6 = n2 + n3;
            throw new IndexOutOfBoundsException(new StringBuilder(39).append("Source end offset exceeded: ").append(n6).toString());
        }
        if (n3 <= 0) return;
        this.writeToInternal(outputStream, n2, n3);
    }

    abstract void writeToInternal(OutputStream var1, int var2, int var3);

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List asReadOnlyByteBufferList();

    public String toString(String string) {
        try {
            return this.toString(Charset.forName(string));
        }
        catch (UnsupportedCharsetException var2_2) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(string);
            unsupportedEncodingException.initCause(var2_2);
            throw unsupportedEncodingException;
        }
    }

    public String toString(Charset charset) {
        if (this.size() == 0) {
            return "";
        }
        String string = this.toStringInternal(charset);
        return string;
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

    public static ByteString$Output newOutput(int n2) {
        return new ByteString$Output(n2);
    }

    public static ByteString$Output newOutput() {
        return new ByteString$Output(128);
    }

    static ByteString$CodedBuilder newCodedBuilder(int n2) {
        return new ByteString$CodedBuilder(n2, null);
    }

    protected abstract int getTreeDepth();

    protected abstract boolean isBalanced();

    protected abstract int peekCachedHashCode();

    protected abstract int partialHash(int var1, int var2, int var3);

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), this.size());
    }
}

