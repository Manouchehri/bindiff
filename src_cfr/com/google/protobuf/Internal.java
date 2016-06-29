/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.Utf8;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Internal {
    protected static final Charset UTF_8 = Charset.forName("UTF-8");
    protected static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final ByteBuffer EMPTY_BYTE_BUFFER = ByteBuffer.wrap(EMPTY_BYTE_ARRAY);
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(EMPTY_BYTE_ARRAY);

    public static String stringDefaultValue(String string) {
        return new String(string.getBytes(ISO_8859_1), UTF_8);
    }

    public static ByteString bytesDefaultValue(String string) {
        return ByteString.copyFrom(string.getBytes(ISO_8859_1));
    }

    public static byte[] byteArrayDefaultValue(String string) {
        return string.getBytes(ISO_8859_1);
    }

    public static ByteBuffer byteBufferDefaultValue(String string) {
        return ByteBuffer.wrap(Internal.byteArrayDefaultValue(string));
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer.duplicate();
        byteBuffer2.clear();
        ByteBuffer byteBuffer3 = ByteBuffer.allocate(byteBuffer2.capacity());
        byteBuffer3.put(byteBuffer2);
        byteBuffer3.clear();
        return byteBuffer3;
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    public static boolean isValidUtf8(byte[] arrby) {
        return Utf8.isValidUtf8(arrby);
    }

    public static byte[] toByteArray(String string) {
        return string.getBytes(UTF_8);
    }

    public static String toStringUtf8(byte[] arrby) {
        return new String(arrby, UTF_8);
    }

    public static int hashLong(long l2) {
        return (int)(l2 ^ l2 >>> 32);
    }

    public static int hashBoolean(boolean bl2) {
        if (!bl2) return 1237;
        return 1231;
    }

    public static int hashEnum(Internal$EnumLite internal$EnumLite) {
        return internal$EnumLite.getNumber();
    }

    public static int hashEnumList(List list) {
        int n2 = 1;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Internal$EnumLite internal$EnumLite = (Internal$EnumLite)iterator.next();
            n2 = 31 * n2 + Internal.hashEnum(internal$EnumLite);
        }
        return n2;
    }

    public static boolean equals(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        int n2 = 0;
        while (n2 < list.size()) {
            if (!Arrays.equals((byte[])list.get(n2), (byte[])list2.get(n2))) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public static int hashCode(List list) {
        int n2 = 1;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            byte[] arrby = (byte[])iterator.next();
            n2 = 31 * n2 + Internal.hashCode(arrby);
        }
        return n2;
    }

    public static int hashCode(byte[] arrby) {
        return LiteralByteString.hashCode(arrby);
    }

    public static boolean equalsByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() == byteBuffer2.capacity()) return byteBuffer.duplicate().clear().equals(byteBuffer2.duplicate().clear());
        return false;
    }

    public static boolean equalsByteBuffer(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        int n2 = 0;
        while (n2 < list.size()) {
            if (!Internal.equalsByteBuffer((ByteBuffer)list.get(n2), (ByteBuffer)list2.get(n2))) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public static int hashCodeByteBuffer(List list) {
        int n2 = 1;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer)iterator.next();
            n2 = 31 * n2 + Internal.hashCodeByteBuffer(byteBuffer);
        }
        return n2;
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int n2 = LiteralByteString.hashCode(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (n2 == 0) {
                return 1;
            }
            int n3 = n2;
            return n3;
        }
        int n4 = byteBuffer.capacity() > 4096 ? 4096 : byteBuffer.capacity();
        byte[] arrby = new byte[n4];
        ByteBuffer byteBuffer2 = byteBuffer.duplicate();
        byteBuffer2.clear();
        int n5 = byteBuffer.capacity();
        while (byteBuffer2.remaining() > 0) {
            int n6 = byteBuffer2.remaining() <= n4 ? byteBuffer2.remaining() : n4;
            byteBuffer2.get(arrby, 0, n6);
            n5 = LiteralByteString.hashCode(n5, arrby, 0, n6);
        }
        if (n5 == 0) {
            return 1;
        }
        int n7 = n5;
        return n7;
    }
}

