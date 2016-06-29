package com.google.protobuf;

import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class Internal
{
    protected static final Charset UTF_8;
    protected static final Charset ISO_8859_1;
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;
    
    public static String stringDefaultValue(final String s) {
        return new String(s.getBytes(Internal.ISO_8859_1), Internal.UTF_8);
    }
    
    public static ByteString bytesDefaultValue(final String s) {
        return ByteString.copyFrom(s.getBytes(Internal.ISO_8859_1));
    }
    
    public static byte[] byteArrayDefaultValue(final String s) {
        return s.getBytes(Internal.ISO_8859_1);
    }
    
    public static ByteBuffer byteBufferDefaultValue(final String s) {
        return ByteBuffer.wrap(byteArrayDefaultValue(s));
    }
    
    public static ByteBuffer copyByteBuffer(final ByteBuffer byteBuffer) {
        final ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        final ByteBuffer allocate = ByteBuffer.allocate(duplicate.capacity());
        allocate.put(duplicate);
        allocate.clear();
        return allocate;
    }
    
    public static boolean isValidUtf8(final ByteString byteString) {
        return byteString.isValidUtf8();
    }
    
    public static boolean isValidUtf8(final byte[] array) {
        return Utf8.isValidUtf8(array);
    }
    
    public static byte[] toByteArray(final String s) {
        return s.getBytes(Internal.UTF_8);
    }
    
    public static String toStringUtf8(final byte[] array) {
        return new String(array, Internal.UTF_8);
    }
    
    public static int hashLong(final long n) {
        return (int)(n ^ n >>> 32);
    }
    
    public static int hashBoolean(final boolean b) {
        return b ? 1231 : 1237;
    }
    
    public static int hashEnum(final Internal$EnumLite internal$EnumLite) {
        return internal$EnumLite.getNumber();
    }
    
    public static int hashEnumList(final List list) {
        int n = 1;
        final Iterator<Internal$EnumLite> iterator = list.iterator();
        while (iterator.hasNext()) {
            n = 31 * n + hashEnum(iterator.next());
        }
        return n;
    }
    
    public static boolean equals(final List list, final List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); ++i) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static int hashCode(final List list) {
        int n = 1;
        final Iterator<byte[]> iterator = list.iterator();
        while (iterator.hasNext()) {
            n = 31 * n + hashCode(iterator.next());
        }
        return n;
    }
    
    public static int hashCode(final byte[] array) {
        return LiteralByteString.hashCode(array);
    }
    
    public static boolean equalsByteBuffer(final ByteBuffer byteBuffer, final ByteBuffer byteBuffer2) {
        return byteBuffer.capacity() == byteBuffer2.capacity() && byteBuffer.duplicate().clear().equals(byteBuffer2.duplicate().clear());
    }
    
    public static boolean equalsByteBuffer(final List list, final List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); ++i) {
            if (!equalsByteBuffer(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static int hashCodeByteBuffer(final List list) {
        int n = 1;
        final Iterator<ByteBuffer> iterator = list.iterator();
        while (iterator.hasNext()) {
            n = 31 * n + hashCodeByteBuffer(iterator.next());
        }
        return n;
    }
    
    public static int hashCodeByteBuffer(final ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            final int hashCode = LiteralByteString.hashCode(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            return (hashCode == 0) ? 1 : hashCode;
        }
        final int n = (byteBuffer.capacity() > 4096) ? 4096 : byteBuffer.capacity();
        final byte[] array = new byte[n];
        final ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        int n2 = byteBuffer.capacity();
        while (duplicate.remaining() > 0) {
            final int n3 = (duplicate.remaining() <= n) ? duplicate.remaining() : n;
            duplicate.get(array, 0, n3);
            n2 = LiteralByteString.hashCode(n2, array, 0, n3);
        }
        return (n2 == 0) ? 1 : n2;
    }
    
    static {
        UTF_8 = Charset.forName("UTF-8");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        EMPTY_BYTE_ARRAY = new byte[0];
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(Internal.EMPTY_BYTE_ARRAY);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(Internal.EMPTY_BYTE_ARRAY);
    }
}
