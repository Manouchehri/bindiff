/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible
public final class Utf8 {
    @CheckReturnValue
    public static int encodedLength(CharSequence charSequence) {
        int n2;
        int n3;
        int n4 = n2 = charSequence.length();
        for (n3 = 0; n3 < n2 && charSequence.charAt(n3) < '?'; ++n3) {
        }
        while (n3 < n2) {
            char c2 = charSequence.charAt(n3);
            if (c2 < '\u0800') {
                n4 += 127 - c2 >>> 31;
                ++n3;
                continue;
            }
            n4 += Utf8.encodedLengthGeneral(charSequence, n3);
            break;
        }
        if (n4 >= n2) return n4;
        long l2 = (long)n4 + 0x100000000L;
        throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(l2).toString());
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int n2) {
        int n3 = charSequence.length();
        int n4 = 0;
        int n5 = n2;
        while (n5 < n3) {
            char c2 = charSequence.charAt(n5);
            if (c2 < '\u0800') {
                n4 += 127 - c2 >>> 31;
            } else {
                n4 += 2;
                if ('\ud800' <= c2 && c2 <= '\udfff') {
                    if (Character.codePointAt(charSequence, n5) == c2) {
                        throw new IllegalArgumentException(Utf8.unpairedSurrogateMsg(n5));
                    }
                    ++n5;
                }
            }
            ++n5;
        }
        return n4;
    }

    @GwtIncompatible(value="ByteBuffer")
    @GoogleInternal
    public static void encode(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (!byteBuffer.hasArray()) {
            Utf8.encodeDirect(charSequence, byteBuffer);
            return;
        }
        try {
            int n2 = Utf8.encode(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(n2 - byteBuffer.arrayOffset());
            return;
        }
        catch (ArrayIndexOutOfBoundsException var2_3) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(var2_3);
            throw bufferOverflowException;
        }
    }

    @GwtIncompatible(value="ByteBuffer")
    @GoogleInternal
    private static void encodeDirect(CharSequence charSequence, ByteBuffer byteBuffer) {
        char c2;
        int n2;
        int n3 = charSequence.length();
        for (n2 = 0; n2 < n3 && (c2 = charSequence.charAt(n2)) < '?'; ++n2) {
            byteBuffer.put((byte)c2);
        }
        while (n2 < n3) {
            c2 = charSequence.charAt(n2);
            if (c2 < '?') {
                byteBuffer.put((byte)c2);
            } else if (c2 < '\u0800') {
                byteBuffer.put((byte)(960 | c2 >>> 6));
                byteBuffer.put((byte)(128 | 63 & c2));
            } else {
                if (c2 >= '\ud800' && '\udfff' >= c2) {
                    Utf8.encodeDirectGeneral(charSequence, byteBuffer, n2);
                    return;
                }
                byteBuffer.put((byte)(480 | c2 >>> 12));
                byteBuffer.put((byte)(128 | 63 & c2 >>> 6));
                byteBuffer.put((byte)(128 | 63 & c2));
            }
            ++n2;
        }
    }

    @GwtIncompatible(value="ByteBuffer")
    @GoogleInternal
    private static void encodeDirectGeneral(CharSequence charSequence, ByteBuffer byteBuffer, int n2) {
        int n3 = charSequence.length();
        while (n2 < n3) {
            char c2 = charSequence.charAt(n2);
            if (c2 < '?') {
                byteBuffer.put((byte)c2);
            } else if (c2 < '\u0800') {
                byteBuffer.put((byte)(960 | c2 >>> 6));
                byteBuffer.put((byte)(128 | 63 & c2));
            } else if (c2 < '\ud800' || '\udfff' < c2) {
                byteBuffer.put((byte)(480 | c2 >>> 12));
                byteBuffer.put((byte)(128 | 63 & c2 >>> 6));
                byteBuffer.put((byte)(128 | 63 & c2));
            } else {
                int n4 = Character.codePointAt(charSequence, n2);
                if (n4 == c2) {
                    throw new IllegalArgumentException(Utf8.unpairedSurrogateMsg(n2));
                }
                ++n2;
                byteBuffer.put((byte)(240 | n4 >>> 18));
                byteBuffer.put((byte)(128 | 63 & n4 >>> 12));
                byteBuffer.put((byte)(128 | 63 & n4 >>> 6));
                byteBuffer.put((byte)(128 | 63 & n4));
            }
            ++n2;
        }
    }

    @GoogleInternal
    public static int encode(CharSequence charSequence, byte[] arrby) {
        return Utf8.encode(charSequence, arrby, 0, arrby.length);
    }

    @GoogleInternal
    public static int encode(CharSequence charSequence, byte[] arrby, int n2) {
        return Utf8.encode(charSequence, arrby, n2, arrby.length - n2);
    }

    @GoogleInternal
    private static int encode(CharSequence charSequence, byte[] arrby, int n2, int n3) {
        int n4;
        char c2;
        int n5 = charSequence.length();
        int n6 = n2;
        int n7 = n2 + n3;
        for (n4 = 0; n4 < n5 && n4 + n6 < n7 && (c2 = charSequence.charAt(n4)) < '?'; ++n4) {
            arrby[n6 + n4] = (byte)c2;
        }
        if (n4 == n5) {
            return n6 + n5;
        }
        n6 += n4;
        while (n4 < n5) {
            int n8;
            c2 = charSequence.charAt(n4);
            if (c2 < '?' && n6 < n7) {
                arrby[n6++] = (byte)c2;
            } else if (c2 < '\u0800' && n6 <= n7 - 2) {
                arrby[n6++] = (byte)(960 | c2 >>> 6);
                arrby[n6++] = (byte)(128 | 63 & c2);
            } else if ((c2 < '\ud800' || '\udfff' < c2) && n6 <= n7 - 3) {
                arrby[n6++] = (byte)(480 | c2 >>> 12);
                arrby[n6++] = (byte)(128 | 63 & c2 >>> 6);
                arrby[n6++] = (byte)(128 | 63 & c2);
            } else if (n6 <= n7 - 4) {
                n8 = Character.codePointAt(charSequence, n4);
                if (n8 == c2) {
                    throw new IllegalArgumentException(Utf8.unpairedSurrogateMsg(n4));
                }
                ++n4;
                arrby[n6++] = (byte)(240 | n8 >>> 18);
                arrby[n6++] = (byte)(128 | 63 & n8 >>> 12);
                arrby[n6++] = (byte)(128 | 63 & n8 >>> 6);
                arrby[n6++] = (byte)(128 | 63 & n8);
            } else {
                if (Utf8.unpairedSurrogateAt(charSequence, n4)) {
                    throw new IllegalArgumentException(Utf8.unpairedSurrogateMsg(n4));
                }
                n8 = c2;
                int n9 = n6;
                throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append((char)n8).append(" at index ").append(n9).toString());
            }
            ++n4;
        }
        return n6;
    }

    @CheckReturnValue
    public static boolean isWellFormed(byte[] arrby) {
        return Utf8.isWellFormed(arrby, 0, arrby.length);
    }

    @CheckReturnValue
    public static boolean isWellFormed(byte[] arrby, int n2, int n3) {
        int n4 = n2 + n3;
        Preconditions.checkPositionIndexes(n2, n4, arrby.length);
        int n5 = n2;
        while (n5 < n4) {
            if (arrby[n5] < 0) {
                return Utf8.isWellFormedSlowPath(arrby, n5, n4);
            }
            ++n5;
        }
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private static boolean isWellFormedSlowPath(byte[] var0, int var1_1, int var2_2) {
        var3_3 = var1_1;
        do lbl-1000: // 5 sources:
        {
            if (var3_3 >= var2_2) {
                return true;
            }
            if ((var4_4 = var0[var3_3++]) >= 0) ** GOTO lbl-1000
            if (var4_4 >= -32) ** GOTO lbl12
            if (var3_3 == var2_2) {
                return false;
            }
            if (var4_4 < -62) return false;
            if (var0[var3_3++] <= -65) ** GOTO lbl-1000
            return false;
lbl12: // 1 sources:
            if (var4_4 >= -16) ** GOTO lbl22
            if (var3_3 + 1 >= var2_2) {
                return false;
            }
            if ((var5_5 = var0[var3_3++]) > -65) return false;
            if (var4_4 == -32) {
                if (var5_5 < -96) return false;
            }
            if (var4_4 == -19) {
                if (-96 <= var5_5) return false;
            }
            if (var0[var3_3++] <= -65) ** GOTO lbl-1000
            return false;
lbl22: // 1 sources:
            if (var3_3 + 2 >= var2_2) {
                return false;
            }
            if ((var5_5 = var0[var3_3++]) > -65) return false;
            if ((var4_4 << 28) + (var5_5 - -112) >> 30 != 0) return false;
            if (var0[var3_3++] > -65) return false;
        } while (var0[var3_3++] <= -65);
        return false;
    }

    @GoogleInternal
    private static boolean unpairedSurrogateAt(CharSequence charSequence, int n2) {
        int n3 = Character.codePointAt(charSequence, n2);
        if (55296 > n3) return false;
        if (n3 > 57343) return false;
        return true;
    }

    private static String unpairedSurrogateMsg(int n2) {
        return new StringBuilder(39).append("Unpaired surrogate at index ").append(n2).toString();
    }

    private Utf8() {
    }
}

