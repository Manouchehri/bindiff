package com.google.common.hash;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.io.*;

@CheckReturnValue
@GoogleInternal
public final class LegacyHashing
{
    private static final int FINGERPRINT_SEED = 102072;
    static final int SEED32 = 314159265;
    static final int CONSTANT32 = -1640531527;
    static final long SEED64 = 3141592653589793238L;
    static final long CONSTANT64 = -2266404186210603134L;
    private static final HashFunction GOOGLE_LEGACY_32;
    private static final HashFunction GOOGLE_LEGACY_64;
    private static final HashFunction FPRINT_96;
    private static final HashFunction FINGERPRINT_1999;
    private static final HashFunction BROKEN_FINGERPRINT_1999;
    private static final HashFunction MURMUR_HASH_2_64;
    private static final char[] hexDigits;
    
    public static HashFunction googleHash32() {
        return LegacyHashing.GOOGLE_LEGACY_32;
    }
    
    public static HashFunction googleHash32(final int n) {
        return new GoogleLegacy32HashFunction(n, GoogleLegacy32HashFunction$FingerprintStrategy.WORKING);
    }
    
    public static HashFunction googleHash64() {
        return LegacyHashing.GOOGLE_LEGACY_64;
    }
    
    public static HashFunction googleHash64(final long n) {
        return new GoogleLegacy64HashFunction(n);
    }
    
    public static HashFunction fprint96() {
        return LegacyHashing.FPRINT_96;
    }
    
    public static HashFunction fingerprint1999() {
        return LegacyHashing.FINGERPRINT_1999;
    }
    
    public static HashFunction brokenFingerprint1999() {
        return LegacyHashing.BROKEN_FINGERPRINT_1999;
    }
    
    public static HashCode mix32(final int n) {
        return HashCode.fromInt(GoogleLegacy32HashFunction.mix32(n, -1640531527, 314159265));
    }
    
    public static HashCode mix32(final int n, final int n2) {
        return HashCode.fromInt(GoogleLegacy32HashFunction.mix32(n, -1640531527, n2));
    }
    
    public static HashCode mix64(final long n) {
        return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(n, -2266404186210603134L, 3141592653589793238L));
    }
    
    public static HashCode mix64(final long n, final long n2) {
        return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(n, -2266404186210603134L, n2));
    }
    
    public static HashFunction murmur2_64() {
        return LegacyHashing.MURMUR_HASH_2_64;
    }
    
    public static HashFunction murmur2_64(final long n) {
        return new Murmur2_64AHashFunction(n);
    }
    
    public static HashCode stringHash64(final CharSequence charSequence) {
        long n2;
        long n = n2 = -2266404186210603134L;
        long n3 = 3141592653589793238L;
        int n4;
        int i;
        for (n4 = 0, i = charSequence.length(); i >= 12; i -= 12, n4 += 12) {
            final long n5 = n + word64CharAt(charSequence, n4);
            final long n6 = n2 + word64CharAt(charSequence, n4 + 4);
            final long n7 = n3 + word64CharAt(charSequence, n4 + 8);
            final long n8 = n5 - n6 - n7 ^ n7 >>> 43;
            final long n9 = n6 - n7 - n8 ^ n8 << 9;
            final long n10 = n7 - n8 - n9 ^ n9 >>> 8;
            final long n11 = n8 - n9 - n10 ^ n10 >>> 38;
            final long n12 = n9 - n10 - n11 ^ n11 << 23;
            final long n13 = n10 - n11 - n12 ^ n12 >>> 5;
            final long n14 = n11 - n12 - n13 ^ n13 >>> 35;
            final long n15 = n12 - n13 - n14 ^ n14 << 49;
            final long n16 = n13 - n14 - n15 ^ n15 >>> 11;
            n = (n14 - n15 - n16 ^ n16 >>> 12);
            n2 = (n15 - n16 - n ^ n << 18);
            n3 = (n16 - n - n2 ^ n2 >>> 22);
        }
        long n17 = n3 + charSequence.length();
        switch (i) {
            case 11: {
                n17 += (charSequence.charAt(n4 + 10) & 0xFFFFL) << 40;
            }
            case 10: {
                n17 += (charSequence.charAt(n4 + 9) & 0xFFFFL) << 24;
            }
            case 9: {
                n17 += (charSequence.charAt(n4 + 8) & 0xFFFFL) << 8;
            }
            case 8: {
                n2 += word64CharAt(charSequence, n4 + 4);
                n += word64CharAt(charSequence, n4);
                break;
            }
            case 7: {
                n2 += (charSequence.charAt(n4 + 6) & 0xFFFFL) << 32;
            }
            case 6: {
                n2 += (charSequence.charAt(n4 + 5) & 0xFFFFL) << 16;
            }
            case 5: {
                n2 += (charSequence.charAt(n4 + 4) & 0xFFFFL);
            }
            case 4: {
                n += word64CharAt(charSequence, n4);
                break;
            }
            case 3: {
                n += (charSequence.charAt(n4 + 2) & 0xFFFFL) << 32;
            }
            case 2: {
                n += (charSequence.charAt(n4 + 1) & 0xFFFFL) << 16;
            }
            case 1: {
                n += (charSequence.charAt(n4) & 0xFFFFL);
            }
            case 0: {
                break;
            }
            default: {
                throw new AssertionError();
            }
        }
        return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(n, n2, n17));
    }
    
    private static long word64CharAt(final CharSequence charSequence, final int n) {
        return (charSequence.charAt(n) & 0xFFFFL) + ((charSequence.charAt(n + 1) & 0xFFFFL) << 16) + ((charSequence.charAt(n + 2) & 0xFFFFL) << 32) + ((charSequence.charAt(n + 3) & 0xFFFFL) << 48);
    }
    
    public static String toSeparatedString(final HashCode hashCode) {
        Preconditions.checkArgument(hashCode.bits() % 32 == 0, "HashCode must have a multiple of 32 bits, but had %s bits.", hashCode.bits());
        final byte[] bytes = hashCode.asBytes();
        final StringBuilder sb = new StringBuilder(2 * bytes.length + bytes.length / 4);
        for (int i = 0; i < bytes.length; i += 4) {
            for (int j = 0; j < 4; ++j) {
                final byte b = bytes[i + j];
                sb.append(LegacyHashing.hexDigits[b >> 4 & 0xF]).append(LegacyHashing.hexDigits[b & 0xF]);
            }
            sb.append('_');
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
    
    public static String toBrokenString(final HashCode hashCode) {
        final byte[] bytes = hashCode.asBytes();
        final char[] array = new char[bytes.length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = (char)(bytes[i] & 0xFF);
        }
        return new String(array);
    }
    
    static {
        GOOGLE_LEGACY_32 = new GoogleLegacy32HashFunction(314159265, GoogleLegacy32HashFunction$FingerprintStrategy.WORKING);
        GOOGLE_LEGACY_64 = new GoogleLegacy64HashFunction(3141592653589793238L);
        FPRINT_96 = new MessageDigestHashFunction("SHA-1", 12, "LegacyHashing.fprint96()");
        FINGERPRINT_1999 = new Fingerprint1999(googleHash32(0), googleHash32(102072), "LegacyHashing.fingerprint1999()");
        BROKEN_FINGERPRINT_1999 = new Fingerprint1999(new GoogleLegacy32HashFunction(0, GoogleLegacy32HashFunction$FingerprintStrategy.BROKEN), new GoogleLegacy32HashFunction(102072, GoogleLegacy32HashFunction$FingerprintStrategy.BROKEN), "LegacyHashing.brokenFingerprint1999()");
        MURMUR_HASH_2_64 = murmur2_64(0L);
        hexDigits = "0123456789ABCDEF".toCharArray();
    }
}
