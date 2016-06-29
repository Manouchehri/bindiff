package com.google.protobuf;

import java.nio.*;
import java.util.*;
import java.io.*;
import java.nio.charset.*;

public abstract class ByteString implements Serializable, Iterable
{
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    public static final ByteString EMPTY;
    
    public abstract byte byteAt(final int p0);
    
    public abstract ByteString$ByteIterator iterator();
    
    public abstract int size();
    
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    public ByteString substring(final int n) {
        return this.substring(n, this.size());
    }
    
    public abstract ByteString substring(final int p0, final int p1);
    
    public boolean startsWith(final ByteString byteString) {
        return this.size() >= byteString.size() && this.substring(0, byteString.size()).equals(byteString);
    }
    
    public boolean endsWith(final ByteString byteString) {
        return this.size() >= byteString.size() && this.substring(this.size() - byteString.size()).equals(byteString);
    }
    
    public static ByteString copyFrom(final byte[] array, final int n, final int n2) {
        final byte[] array2 = new byte[n2];
        System.arraycopy(array, n, array2, 0, n2);
        return new LiteralByteString(array2);
    }
    
    public static ByteString copyFrom(final byte[] array) {
        return copyFrom(array, 0, array.length);
    }
    
    public static ByteString copyFrom(final ByteBuffer byteBuffer, final int n) {
        final byte[] array = new byte[n];
        byteBuffer.get(array);
        return new LiteralByteString(array);
    }
    
    public static ByteString copyFrom(final ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }
    
    public static ByteString copyFrom(final String s, final String s2) {
        return new LiteralByteString(s.getBytes(s2));
    }
    
    public static ByteString copyFrom(final String s, final Charset charset) {
        return new LiteralByteString(s.getBytes(charset));
    }
    
    public static ByteString copyFromUtf8(final String s) {
        return new LiteralByteString(s.getBytes(Internal.UTF_8));
    }
    
    public static ByteString readFrom(final InputStream inputStream) {
        return readFrom(inputStream, 256, 8192);
    }
    
    public static ByteString readFrom(final InputStream inputStream, final int n) {
        return readFrom(inputStream, n, n);
    }
    
    public static ByteString readFrom(final InputStream inputStream, final int n, final int n2) {
        final ArrayList<ByteString> list = new ArrayList<ByteString>();
        int min = n;
        while (true) {
            final ByteString chunk = readChunk(inputStream, min);
            if (chunk == null) {
                break;
            }
            list.add(chunk);
            min = Math.min(min * 2, n2);
        }
        return copyFrom(list);
    }
    
    private static ByteString readChunk(final InputStream inputStream, final int n) {
        final byte[] array = new byte[n];
        int i;
        int read;
        for (i = 0; i < n; i += read) {
            read = inputStream.read(array, i, n - i);
            if (read == -1) {
                break;
            }
        }
        if (i == 0) {
            return null;
        }
        return copyFrom(array, 0, i);
    }
    
    public ByteString concat(final ByteString byteString) {
        final int size = this.size();
        final int size2 = byteString.size();
        if (size + size2 >= 2147483647L) {
            throw new IllegalArgumentException(new StringBuilder(53).append("ByteString would be too long: ").append(size).append("+").append(size2).toString());
        }
        return RopeByteString.concatenate(this, byteString);
    }
    
    public static ByteString copyFrom(final Iterable iterable) {
        Collection<ByteString> collection;
        if (!(iterable instanceof Collection)) {
            collection = new ArrayList<ByteString>();
            final Iterator<ByteString> iterator = (Iterator<ByteString>)iterable.iterator();
            while (iterator.hasNext()) {
                collection.add(iterator.next());
            }
        }
        else {
            collection = (Collection<ByteString>)iterable;
        }
        ByteString byteString;
        if (collection.isEmpty()) {
            byteString = ByteString.EMPTY;
        }
        else {
            byteString = balancedConcat(collection.iterator(), collection.size());
        }
        return byteString;
    }
    
    private static ByteString balancedConcat(final Iterator iterator, final int n) {
        assert n >= 1;
        ByteString concat;
        if (n == 1) {
            concat = iterator.next();
        }
        else {
            final int n2 = n >>> 1;
            concat = balancedConcat(iterator, n2).concat(balancedConcat(iterator, n - n2));
        }
        return concat;
    }
    
    public void copyTo(final byte[] array, final int n) {
        this.copyTo(array, 0, n, this.size());
    }
    
    public void copyTo(final byte[] array, final int n, final int n2, final int n3) {
        if (n < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(30).append("Source offset < 0: ").append(n).toString());
        }
        if (n2 < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(30).append("Target offset < 0: ").append(n2).toString());
        }
        if (n3 < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(23).append("Length < 0: ").append(n3).toString());
        }
        if (n + n3 > this.size()) {
            throw new IndexOutOfBoundsException(new StringBuilder(34).append("Source end offset < 0: ").append(n + n3).toString());
        }
        if (n2 + n3 > array.length) {
            throw new IndexOutOfBoundsException(new StringBuilder(34).append("Target end offset < 0: ").append(n2 + n3).toString());
        }
        if (n3 > 0) {
            this.copyToInternal(array, n, n2, n3);
        }
    }
    
    protected abstract void copyToInternal(final byte[] p0, final int p1, final int p2, final int p3);
    
    public abstract void copyTo(final ByteBuffer p0);
    
    public byte[] toByteArray() {
        final int size = this.size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        final byte[] array = new byte[size];
        this.copyToInternal(array, 0, 0, size);
        return array;
    }
    
    public abstract void writeTo(final OutputStream p0);
    
    void writeTo(final OutputStream outputStream, final int n, final int n2) {
        if (n < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(30).append("Source offset < 0: ").append(n).toString());
        }
        if (n2 < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(23).append("Length < 0: ").append(n2).toString());
        }
        if (n + n2 > this.size()) {
            throw new IndexOutOfBoundsException(new StringBuilder(39).append("Source end offset exceeded: ").append(n + n2).toString());
        }
        if (n2 > 0) {
            this.writeToInternal(outputStream, n, n2);
        }
    }
    
    abstract void writeToInternal(final OutputStream p0, final int p1, final int p2);
    
    public abstract ByteBuffer asReadOnlyByteBuffer();
    
    public abstract List asReadOnlyByteBufferList();
    
    public String toString(final String s) {
        try {
            return this.toString(Charset.forName(s));
        }
        catch (UnsupportedCharsetException ex2) {
            final UnsupportedEncodingException ex = new UnsupportedEncodingException(s);
            ex.initCause(ex2);
            throw ex;
        }
    }
    
    public String toString(final Charset charset) {
        return (this.size() == 0) ? "" : this.toStringInternal(charset);
    }
    
    protected abstract String toStringInternal(final Charset p0);
    
    public String toStringUtf8() {
        return this.toString(Internal.UTF_8);
    }
    
    public abstract boolean isValidUtf8();
    
    protected abstract int partialIsValidUtf8(final int p0, final int p1, final int p2);
    
    public abstract boolean equals(final Object p0);
    
    public abstract int hashCode();
    
    public abstract InputStream newInput();
    
    public abstract CodedInputStream newCodedInput();
    
    public static ByteString$Output newOutput(final int n) {
        return new ByteString$Output(n);
    }
    
    public static ByteString$Output newOutput() {
        return new ByteString$Output(128);
    }
    
    static ByteString$CodedBuilder newCodedBuilder(final int n) {
        return new ByteString$CodedBuilder(n, null);
    }
    
    protected abstract int getTreeDepth();
    
    protected abstract boolean isBalanced();
    
    protected abstract int peekCachedHashCode();
    
    protected abstract int partialHash(final int p0, final int p1, final int p2);
    
    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), this.size());
    }
    
    static {
        EMPTY = new LiteralByteString(new byte[0]);
    }
}
