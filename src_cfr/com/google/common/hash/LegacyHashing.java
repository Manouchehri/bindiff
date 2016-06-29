/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.hash.Fingerprint1999;
import com.google.common.hash.GoogleLegacy32HashFunction;
import com.google.common.hash.GoogleLegacy32HashFunction$FingerprintStrategy;
import com.google.common.hash.GoogleLegacy64HashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.MessageDigestHashFunction;
import com.google.common.hash.Murmur2_64AHashFunction;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GoogleInternal
public final class LegacyHashing {
    private static final int FINGERPRINT_SEED = 102072;
    static final int SEED32 = 314159265;
    static final int CONSTANT32 = -1640531527;
    static final long SEED64 = 3141592653589793238L;
    static final long CONSTANT64 = -2266404186210603134L;
    private static final HashFunction GOOGLE_LEGACY_32 = new GoogleLegacy32HashFunction(314159265, GoogleLegacy32HashFunction$FingerprintStrategy.WORKING);
    private static final HashFunction GOOGLE_LEGACY_64 = new GoogleLegacy64HashFunction(3141592653589793238L);
    private static final HashFunction FPRINT_96 = new MessageDigestHashFunction("SHA-1", 12, "LegacyHashing.fprint96()");
    private static final HashFunction FINGERPRINT_1999 = new Fingerprint1999(LegacyHashing.googleHash32(0), LegacyHashing.googleHash32(102072), "LegacyHashing.fingerprint1999()");
    private static final HashFunction BROKEN_FINGERPRINT_1999 = new Fingerprint1999(new GoogleLegacy32HashFunction(0, GoogleLegacy32HashFunction$FingerprintStrategy.BROKEN), new GoogleLegacy32HashFunction(102072, GoogleLegacy32HashFunction$FingerprintStrategy.BROKEN), "LegacyHashing.brokenFingerprint1999()");
    private static final HashFunction MURMUR_HASH_2_64 = LegacyHashing.murmur2_64(0);
    private static final char[] hexDigits = "0123456789ABCDEF".toCharArray();

    private LegacyHashing() {
    }

    public static HashFunction googleHash32() {
        return GOOGLE_LEGACY_32;
    }

    public static HashFunction googleHash32(int n2) {
        return new GoogleLegacy32HashFunction(n2, GoogleLegacy32HashFunction$FingerprintStrategy.WORKING);
    }

    public static HashFunction googleHash64() {
        return GOOGLE_LEGACY_64;
    }

    public static HashFunction googleHash64(long l2) {
        return new GoogleLegacy64HashFunction(l2);
    }

    public static HashFunction fprint96() {
        return FPRINT_96;
    }

    public static HashFunction fingerprint1999() {
        return FINGERPRINT_1999;
    }

    public static HashFunction brokenFingerprint1999() {
        return BROKEN_FINGERPRINT_1999;
    }

    public static HashCode mix32(int n2) {
        return HashCode.fromInt(GoogleLegacy32HashFunction.mix32(n2, -1640531527, 314159265));
    }

    public static HashCode mix32(int n2, int n3) {
        return HashCode.fromInt(GoogleLegacy32HashFunction.mix32(n2, -1640531527, n3));
    }

    public static HashCode mix64(long l2) {
        return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(l2, -2266404186210603134L, 3141592653589793238L));
    }

    public static HashCode mix64(long l2, long l3) {
        return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(l2, -2266404186210603134L, l3));
    }

    public static HashFunction murmur2_64() {
        return MURMUR_HASH_2_64;
    }

    public static HashFunction murmur2_64(long l2) {
        return new Murmur2_64AHashFunction(l2);
    }

    public static HashCode stringHash64(CharSequence charSequence) {
        int n2;
        long l2;
        long l3 = l2 = -2266404186210603134L;
        long l4 = 3141592653589793238L;
        int n3 = 0;
        for (n2 = charSequence.length(); n2 >= 12; l2 -= (l4 ^= l3 >>> 11), l3 -= (l2 ^= l4 >>> 12), l4 ^= l3 >>> 22, n2 -= 12, n3 += 12) {
            l2 += LegacyHashing.word64CharAt(charSequence, n3);
            l2 -= (l3 += LegacyHashing.word64CharAt(charSequence, n3 + 4));
            l2 -= (l4 += LegacyHashing.word64CharAt(charSequence, n3 + 8));
            l3 -= l4;
            l3 -= (l2 ^= l4 >>> 43);
            l4 -= l2;
            l4 -= (l3 ^= l2 << 9);
            l2 -= l3;
            l2 -= (l4 ^= l3 >>> 8);
            l3 -= l4;
            l3 -= (l2 ^= l4 >>> 38);
            l4 -= l2;
            l4 -= (l3 ^= l2 << 23);
            l2 -= l3;
            l2 -= (l4 ^= l3 >>> 5);
            l3 -= l4;
            l3 -= (l2 ^= l4 >>> 35);
            l4 -= l2;
            l4 -= (l3 ^= l2 << 49);
            l2 -= l3;
            l3 -= l4;
            l4 -= l2;
            l4 -= (l3 ^= l2 << 18);
        }
        l4 += (long)charSequence.length();
        switch (n2) {
            case 11: {
                l4 += ((long)charSequence.charAt(n3 + 10) & 65535) << 40;
            }
            case 10: {
                l4 += ((long)charSequence.charAt(n3 + 9) & 65535) << 24;
            }
            case 9: {
                l4 += ((long)charSequence.charAt(n3 + 8) & 65535) << 8;
            }
            case 8: {
                return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(l2 += LegacyHashing.word64CharAt(charSequence, n3), l3 += LegacyHashing.word64CharAt(charSequence, n3 + 4), l4));
            }
            case 7: {
                l3 += ((long)charSequence.charAt(n3 + 6) & 65535) << 32;
            }
            case 6: {
                l3 += ((long)charSequence.charAt(n3 + 5) & 65535) << 16;
            }
            case 5: {
                l3 += (long)charSequence.charAt(n3 + 4) & 65535;
            }
            case 4: {
                return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(l2 += LegacyHashing.word64CharAt(charSequence, n3), l3, l4));
            }
            case 3: {
                l2 += ((long)charSequence.charAt(n3 + 2) & 65535) << 32;
            }
            case 2: {
                l2 += ((long)charSequence.charAt(n3 + 1) & 65535) << 16;
            }
            case 1: {
                l2 += (long)charSequence.charAt(n3) & 65535;
            }
            case 0: {
                return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(l2, l3, l4));
            }
        }
        throw new AssertionError();
    }

    private static long word64CharAt(CharSequence charSequence, int n2) {
        return ((long)charSequence.charAt(n2) & 65535) + (((long)charSequence.charAt(n2 + 1) & 65535) << 16) + (((long)charSequence.charAt(n2 + 2) & 65535) << 32) + (((long)charSequence.charAt(n2 + 3) & 65535) << 48);
    }

    public static String toSeparatedString(HashCode hashCode) {
        Preconditions.checkArgument(hashCode.bits() % 32 == 0, "HashCode must have a multiple of 32 bits, but had %s bits.", hashCode.bits());
        byte[] arrby = hashCode.asBytes();
        StringBuilder stringBuilder = new StringBuilder(2 * arrby.length + arrby.length / 4);
        int n2 = 0;
        while (n2 < arrby.length) {
            for (int i2 = 0; i2 < 4; ++i2) {
                byte by2 = arrby[n2 + i2];
                stringBuilder.append(hexDigits[by2 >> 4 & 15]).append(hexDigits[by2 & 15]);
            }
            stringBuilder.append('_');
            n2 += 4;
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    public static String toBrokenString(HashCode hashCode) {
        byte[] arrby = hashCode.asBytes();
        char[] arrc = new char[arrby.length];
        int n2 = 0;
        while (n2 < arrc.length) {
            arrc[n2] = (char)(arrby[n2] & 255);
            ++n2;
        }
        return new String(arrc);
    }
}

