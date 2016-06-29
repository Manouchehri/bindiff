package com.google.common.hash;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.security.*;
import javax.crypto.spec.*;
import com.google.common.base.*;
import java.util.*;
import java.util.zip.*;

@CheckReturnValue
@Beta
public final class Hashing
{
    private static final int GOOD_FAST_HASH_SEED;
    @GoogleInternal
    private static final long COMBINE_ORDERED_2011_MUL1 = -4132994306676758123L;
    @GoogleInternal
    private static final long COMBINE_ORDERED_2011_MUL2 = 155523078386399043L;
    
    public static HashFunction goodFastHash(final int n) {
        final int checkPositiveAndMakeMultipleOf32 = checkPositiveAndMakeMultipleOf32(n);
        if (checkPositiveAndMakeMultipleOf32 == 32) {
            return Hashing$Murmur3_32Holder.GOOD_FAST_HASH_FUNCTION_32;
        }
        if (checkPositiveAndMakeMultipleOf32 <= 128) {
            return Hashing$Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
        }
        final int n2 = (checkPositiveAndMakeMultipleOf32 + 127) / 128;
        final HashFunction[] array = new HashFunction[n2];
        array[0] = Hashing$Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
        int good_FAST_HASH_SEED = Hashing.GOOD_FAST_HASH_SEED;
        for (int i = 1; i < n2; ++i) {
            good_FAST_HASH_SEED += 1500450271;
            array[i] = murmur3_128(good_FAST_HASH_SEED);
        }
        return new Hashing$ConcatenatedHashFunction(array, null);
    }
    
    public static HashFunction murmur3_32(final int n) {
        return new Murmur3_32HashFunction(n);
    }
    
    public static HashFunction murmur3_32() {
        return Hashing$Murmur3_32Holder.MURMUR3_32;
    }
    
    public static HashFunction murmur3_128(final int n) {
        return new Murmur3_128HashFunction(n);
    }
    
    public static HashFunction murmur3_128() {
        return Hashing$Murmur3_128Holder.MURMUR3_128;
    }
    
    public static HashFunction sipHash24() {
        return Hashing$SipHash24Holder.SIP_HASH_24;
    }
    
    public static HashFunction sipHash24(final long n, final long n2) {
        return new SipHashFunction(2, 4, n, n2);
    }
    
    public static HashFunction md5() {
        return Hashing$Md5Holder.MD5;
    }
    
    public static HashFunction sha1() {
        return Hashing$Sha1Holder.SHA_1;
    }
    
    public static HashFunction sha256() {
        return Hashing$Sha256Holder.SHA_256;
    }
    
    public static HashFunction sha384() {
        return Hashing$Sha384Holder.SHA_384;
    }
    
    public static HashFunction sha512() {
        return Hashing$Sha512Holder.SHA_512;
    }
    
    @GoogleInternal
    public static HashFunction hmacMd5(final Key key) {
        return new MacHashFunction("HmacMD5", key, hmacToString("hmacMd5", key));
    }
    
    @GoogleInternal
    public static HashFunction hmacMd5(final byte[] array) {
        return hmacMd5(new SecretKeySpec((byte[])Preconditions.checkNotNull(array), "HmacMD5"));
    }
    
    @GoogleInternal
    public static HashFunction hmacSha1(final Key key) {
        return new MacHashFunction("HmacSHA1", key, hmacToString("hmacSha1", key));
    }
    
    @GoogleInternal
    public static HashFunction hmacSha1(final byte[] array) {
        return hmacSha1(new SecretKeySpec((byte[])Preconditions.checkNotNull(array), "HmacSHA1"));
    }
    
    @GoogleInternal
    public static HashFunction hmacSha256(final Key key) {
        return new MacHashFunction("HmacSHA256", key, hmacToString("hmacSha256", key));
    }
    
    @GoogleInternal
    public static HashFunction hmacSha256(final byte[] array) {
        return hmacSha256(new SecretKeySpec((byte[])Preconditions.checkNotNull(array), "HmacSHA256"));
    }
    
    @GoogleInternal
    public static HashFunction hmacSha512(final Key key) {
        return new MacHashFunction("HmacSHA512", key, hmacToString("hmacSha512", key));
    }
    
    @GoogleInternal
    public static HashFunction hmacSha512(final byte[] array) {
        return hmacSha512(new SecretKeySpec((byte[])Preconditions.checkNotNull(array), "HmacSHA512"));
    }
    
    @GoogleInternal
    private static String hmacToString(final String s, final Key key) {
        return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", s, key.getAlgorithm(), key.getFormat());
    }
    
    @GoogleInternal
    public static HashFunction crc8() {
        return Hashing$Crc8Holder.CRC_8;
    }
    
    public static HashFunction crc32c() {
        return Hashing$Crc32cHolder.CRC_32_C;
    }
    
    public static HashFunction crc32() {
        return Hashing$Crc32Holder.CRC_32;
    }
    
    public static HashFunction adler32() {
        return Hashing$Adler32Holder.ADLER_32;
    }
    
    private static HashFunction checksumHashFunction(final Hashing$ChecksumType hashing$ChecksumType, final String s) {
        return new ChecksumHashFunction(hashing$ChecksumType, hashing$ChecksumType.bits, s);
    }
    
    @GoogleInternal
    public static HashFunction fingerprint2011() {
        return Hashing$Fingerprint2011Holder.FINGERPRINT_2011;
    }
    
    @GoogleInternal
    public static HashFunction cityHash128() {
        return Hashing$CityHash128Holder.CITY_HASH_128;
    }
    
    @GoogleInternal
    public static HashFunction cityHash128(final long n, final long n2) {
        return new CityHash128HashFunction(n, n2);
    }
    
    public static int consistentHash(final HashCode hashCode, final int n) {
        return consistentHash(hashCode.padToLong(), n);
    }
    
    public static int consistentHash(final long n, final int n2) {
        Preconditions.checkArgument(n2 > 0, "buckets must be positive: %s", n2);
        final Hashing$LinearCongruentialGenerator hashing$LinearCongruentialGenerator = new Hashing$LinearCongruentialGenerator(n);
        int n3 = 0;
        while (true) {
            final int n4 = (int)((n3 + 1) / hashing$LinearCongruentialGenerator.nextDouble());
            if (n4 < 0 || n4 >= n2) {
                break;
            }
            n3 = n4;
        }
        return n3;
    }
    
    @GoogleInternal
    public static int weightedConsistentHash(final HashCode hashCode, final double[] array) {
        return weightedConsistentHash(hashCode.padToLong(), array);
    }
    
    @GoogleInternal
    public static int weightedConsistentHash(final long n, final double[] array) {
        Preconditions.checkArgument(array.length > 0, (Object)"bucketWeights must not be empty.");
        final Hashing$LinearCongruentialGenerator hashing$LinearCongruentialGenerator = new Hashing$LinearCongruentialGenerator(n);
        double n2 = Double.NEGATIVE_INFINITY;
        int n3 = -1;
        for (int i = 0; i < array.length; ++i) {
            final double n4 = array[i];
            final double nextDouble = hashing$LinearCongruentialGenerator.nextDouble();
            Preconditions.checkArgument(n4 >= 0.0, "Weights must be non-negative. index=%s", i);
            if (n4 != 0.0) {
                final double n5 = Math.log(nextDouble) / n4;
                if (n5 > n2) {
                    n3 = i;
                    n2 = n5;
                }
            }
        }
        Preconditions.checkArgument(n3 >= 0, (Object)"There must be at least one positive weight.");
        return n3;
    }
    
    public static HashCode combineOrdered(final Iterable iterable) {
        final Iterator<HashCode> iterator = iterable.iterator();
        Preconditions.checkArgument(iterator.hasNext(), (Object)"Must be at least 1 hash code to combine.");
        final byte[] array = new byte[iterator.next().bits() / 8];
        final Iterator<HashCode> iterator2 = iterable.iterator();
        while (iterator2.hasNext()) {
            final byte[] bytes = iterator2.next().asBytes();
            Preconditions.checkArgument(bytes.length == array.length, (Object)"All hashcodes must have the same bit length.");
            for (int i = 0; i < bytes.length; ++i) {
                array[i] = (byte)(array[i] * 37 ^ bytes[i]);
            }
        }
        return HashCode.fromBytesNoCopy(array);
    }
    
    public static HashCode combineUnordered(final Iterable iterable) {
        final Iterator<HashCode> iterator = iterable.iterator();
        Preconditions.checkArgument(iterator.hasNext(), (Object)"Must be at least 1 hash code to combine.");
        final byte[] array = new byte[iterator.next().bits() / 8];
        final Iterator<HashCode> iterator2 = iterable.iterator();
        while (iterator2.hasNext()) {
            final byte[] bytes = iterator2.next().asBytes();
            Preconditions.checkArgument(bytes.length == array.length, (Object)"All hashcodes must have the same bit length.");
            for (int i = 0; i < bytes.length; ++i) {
                final byte[] array2 = array;
                final int n = i;
                array2[n] += bytes[i];
            }
        }
        return HashCode.fromBytesNoCopy(array);
    }
    
    static int checkPositiveAndMakeMultipleOf32(final int n) {
        Preconditions.checkArgument(n > 0, (Object)"Number of bits must be positive");
        return n + 31 & 0xFFFFFFE0;
    }
    
    public static HashFunction concatenating(final HashFunction hashFunction, final HashFunction hashFunction2, final HashFunction... array) {
        final ArrayList<HashFunction> list = new ArrayList<HashFunction>();
        list.add(hashFunction);
        list.add(hashFunction2);
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(array[i]);
        }
        return new Hashing$ConcatenatedHashFunction(list.toArray(new HashFunction[0]), null);
    }
    
    public static HashFunction concatenating(final Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        final ArrayList<HashFunction> list = new ArrayList<HashFunction>();
        final Iterator<HashFunction> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        Preconditions.checkArgument(list.size() > 0, "number of hash functions (%s) must be > 0", list.size());
        return new Hashing$ConcatenatedHashFunction(list.toArray(new HashFunction[0]), null);
    }
    
    @GoogleInternal
    public static HashCode combineOrdered2011(final HashCode hashCode, final HashCode hashCode2) {
        Preconditions.checkArgument(hashCode.bits() >= 64, "fp1 must have at least 64 bits, but was only %s", hashCode.bits());
        Preconditions.checkArgument(hashCode2.bits() >= 64, "fp2 must have at least 64 bits, but was only %s", hashCode2.bits());
        final long n = hashCode.asLong() * -4132994306676758123L + hashCode2.asLong() * 155523078386399043L;
        return HashCode.fromLong(n + (~n >>> 47));
    }
    
    static {
        GOOD_FAST_HASH_SEED = (int)System.currentTimeMillis();
    }
}
