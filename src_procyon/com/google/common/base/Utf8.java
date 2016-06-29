package com.google.common.base;

import javax.annotation.*;
import java.nio.*;
import com.google.common.annotations.*;

@Beta
@GwtCompatible
public final class Utf8
{
    @CheckReturnValue
    public static int encodedLength(final CharSequence charSequence) {
        int length;
        int n;
        int i;
        for (n = (length = charSequence.length()), i = '\0'; i < n && charSequence.charAt(i) < '\u0080'; ++i) {}
        while (i < n) {
            final char char1 = charSequence.charAt(i);
            if (char1 >= '\u0800') {
                length += encodedLengthGeneral(charSequence, i);
                break;
            }
            length += '\u007f' - char1 >>> 31;
            ++i;
        }
        if (length < n) {
            throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(length + 4294967296L).toString());
        }
        return length;
    }
    
    private static int encodedLengthGeneral(final CharSequence charSequence, final int n) {
        final int length = charSequence.length();
        char c = '\0';
        for (int i = n; i < length; ++i) {
            final char char1 = charSequence.charAt(i);
            if (char1 < '\u0800') {
                c += (char)('\u007f' - char1 >>> 31);
            }
            else {
                c += '\u0002';
                if ('\ud800' <= char1 && char1 <= '\udfff') {
                    if (Character.codePointAt(charSequence, i) == char1) {
                        throw new IllegalArgumentException(unpairedSurrogateMsg(i));
                    }
                    ++i;
                }
            }
        }
        return c;
    }
    
    @GwtIncompatible("ByteBuffer")
    @GoogleInternal
    public static void encode(final CharSequence charSequence, final ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(encode(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
                return;
            }
            catch (ArrayIndexOutOfBoundsException ex2) {
                final BufferOverflowException ex = new BufferOverflowException();
                ex.initCause(ex2);
                throw ex;
            }
        }
        encodeDirect(charSequence, byteBuffer);
    }
    
    @GwtIncompatible("ByteBuffer")
    @GoogleInternal
    private static void encodeDirect(final CharSequence charSequence, final ByteBuffer byteBuffer) {
        int length;
        int i;
        char char1;
        for (length = charSequence.length(), i = 0; i < length && (char1 = charSequence.charAt(i)) < '\u0080'; ++i) {
            byteBuffer.put((byte)char1);
        }
        while (i < length) {
            final char char2 = charSequence.charAt(i);
            if (char2 < '\u0080') {
                byteBuffer.put((byte)char2);
            }
            else if (char2 < '\u0800') {
                byteBuffer.put((byte)('\u03c0' | char2 >>> 6));
                byteBuffer.put((byte)('\u0080' | ('?' & char2)));
            }
            else {
                if (char2 >= '\ud800' && '\udfff' >= char2) {
                    encodeDirectGeneral(charSequence, byteBuffer, i);
                    return;
                }
                byteBuffer.put((byte)('\u01e0' | char2 >>> 12));
                byteBuffer.put((byte)('\u0080' | ('?' & char2 >>> 6)));
                byteBuffer.put((byte)('\u0080' | ('?' & char2)));
            }
            ++i;
        }
    }
    
    @GwtIncompatible("ByteBuffer")
    @GoogleInternal
    private static void encodeDirectGeneral(final CharSequence charSequence, final ByteBuffer byteBuffer, int i) {
        while (i < charSequence.length()) {
            final char char1 = charSequence.charAt(i);
            if (char1 < '\u0080') {
                byteBuffer.put((byte)char1);
            }
            else if (char1 < '\u0800') {
                byteBuffer.put((byte)('\u03c0' | char1 >>> 6));
                byteBuffer.put((byte)('\u0080' | ('?' & char1)));
            }
            else if (char1 < '\ud800' || '\udfff' < char1) {
                byteBuffer.put((byte)('\u01e0' | char1 >>> 12));
                byteBuffer.put((byte)('\u0080' | ('?' & char1 >>> 6)));
                byteBuffer.put((byte)('\u0080' | ('?' & char1)));
            }
            else {
                final int codePoint;
                if ((codePoint = Character.codePointAt(charSequence, i)) == char1) {
                    throw new IllegalArgumentException(unpairedSurrogateMsg(i));
                }
                ++i;
                byteBuffer.put((byte)(0xF0 | codePoint >>> 18));
                byteBuffer.put((byte)(0x80 | (0x3F & codePoint >>> 12)));
                byteBuffer.put((byte)(0x80 | (0x3F & codePoint >>> 6)));
                byteBuffer.put((byte)(0x80 | (0x3F & codePoint)));
            }
            ++i;
        }
    }
    
    @GoogleInternal
    public static int encode(final CharSequence charSequence, final byte[] array) {
        return encode(charSequence, array, 0, array.length);
    }
    
    @GoogleInternal
    public static int encode(final CharSequence charSequence, final byte[] array, final int n) {
        return encode(charSequence, array, n, array.length - n);
    }
    
    @GoogleInternal
    private static int encode(final CharSequence charSequence, final byte[] array, final int n, final int n2) {
        int length;
        int i;
        int n3;
        char char1;
        for (length = charSequence.length(), i = 0, n3 = n + n2; i < length && i + n < n3 && (char1 = charSequence.charAt(i)) < '\u0080'; ++i) {
            array[n + i] = (byte)char1;
        }
        if (i == length) {
            return n + length;
        }
        int n4 = n + i;
        while (i < length) {
            final char char2 = charSequence.charAt(i);
            if (char2 < '\u0080' && n4 < n3) {
                array[n4++] = (byte)char2;
            }
            else if (char2 < '\u0800' && n4 <= n3 - 2) {
                array[n4++] = (byte)('\u03c0' | char2 >>> 6);
                array[n4++] = (byte)('\u0080' | ('?' & char2));
            }
            else if ((char2 < '\ud800' || '\udfff' < char2) && n4 <= n3 - 3) {
                array[n4++] = (byte)('\u01e0' | char2 >>> 12);
                array[n4++] = (byte)('\u0080' | ('?' & char2 >>> 6));
                array[n4++] = (byte)('\u0080' | ('?' & char2));
            }
            else if (n4 <= n3 - 4) {
                final int codePoint;
                if ((codePoint = Character.codePointAt(charSequence, i)) == char2) {
                    throw new IllegalArgumentException(unpairedSurrogateMsg(i));
                }
                ++i;
                array[n4++] = (byte)(0xF0 | codePoint >>> 18);
                array[n4++] = (byte)(0x80 | (0x3F & codePoint >>> 12));
                array[n4++] = (byte)(0x80 | (0x3F & codePoint >>> 6));
                array[n4++] = (byte)(0x80 | (0x3F & codePoint));
            }
            else {
                if (unpairedSurrogateAt(charSequence, i)) {
                    throw new IllegalArgumentException(unpairedSurrogateMsg(i));
                }
                throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(char2).append(" at index ").append(n4).toString());
            }
            ++i;
        }
        return n4;
    }
    
    @CheckReturnValue
    public static boolean isWellFormed(final byte[] array) {
        return isWellFormed(array, 0, array.length);
    }
    
    @CheckReturnValue
    public static boolean isWellFormed(final byte[] array, final int n, final int n2) {
        final int n3 = n + n2;
        Preconditions.checkPositionIndexes(n, n3, array.length);
        for (int i = n; i < n3; ++i) {
            if (array[i] < 0) {
                return isWellFormedSlowPath(array, i, n3);
            }
        }
        return true;
    }
    
    private static boolean isWellFormedSlowPath(final byte[] array, final int n, final int n2) {
        int i = n;
        while (i < n2) {
            final byte b;
            if ((b = array[i++]) < 0) {
                if (b < -32) {
                    if (i == n2) {
                        return false;
                    }
                    if (b < -62 || array[i++] > -65) {
                        return false;
                    }
                    continue;
                }
                else if (b < -16) {
                    if (i + 1 >= n2) {
                        return false;
                    }
                    final byte b2 = array[i++];
                    if (b2 > -65 || (b == -32 && b2 < -96) || (b == -19 && -96 <= b2) || array[i++] > -65) {
                        return false;
                    }
                    continue;
                }
                else {
                    if (i + 2 >= n2) {
                        return false;
                    }
                    final byte b3 = array[i++];
                    if (b3 > -65 || (b << 28) + (b3 + 112) >> 30 != 0 || array[i++] > -65 || array[i++] > -65) {
                        return false;
                    }
                    continue;
                }
            }
        }
        return true;
    }
    
    @GoogleInternal
    private static boolean unpairedSurrogateAt(final CharSequence charSequence, final int n) {
        final int codePoint = Character.codePointAt(charSequence, n);
        return 55296 <= codePoint && codePoint <= 57343;
    }
    
    private static String unpairedSurrogateMsg(final int n) {
        return new StringBuilder(39).append("Unpaired surrogate at index ").append(n).toString();
    }
}
