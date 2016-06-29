/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.hash.ChecksumHashFunction;
import com.google.common.hash.CityHash128HashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing$1;
import com.google.common.hash.Hashing$Adler32Holder;
import com.google.common.hash.Hashing$ChecksumType;
import com.google.common.hash.Hashing$CityHash128Holder;
import com.google.common.hash.Hashing$ConcatenatedHashFunction;
import com.google.common.hash.Hashing$Crc32Holder;
import com.google.common.hash.Hashing$Crc32cHolder;
import com.google.common.hash.Hashing$Crc8Holder;
import com.google.common.hash.Hashing$Fingerprint2011Holder;
import com.google.common.hash.Hashing$LinearCongruentialGenerator;
import com.google.common.hash.Hashing$Md5Holder;
import com.google.common.hash.Hashing$Murmur3_128Holder;
import com.google.common.hash.Hashing$Murmur3_32Holder;
import com.google.common.hash.Hashing$Sha1Holder;
import com.google.common.hash.Hashing$Sha256Holder;
import com.google.common.hash.Hashing$Sha384Holder;
import com.google.common.hash.Hashing$Sha512Holder;
import com.google.common.hash.Hashing$SipHash24Holder;
import com.google.common.hash.MacHashFunction;
import com.google.common.hash.Murmur3_128HashFunction;
import com.google.common.hash.Murmur3_32HashFunction;
import com.google.common.hash.SipHashFunction;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;
import javax.crypto.spec.SecretKeySpec;

@CheckReturnValue
@Beta
public final class Hashing {
    private static final int GOOD_FAST_HASH_SEED = (int)System.currentTimeMillis();
    @GoogleInternal
    private static final long COMBINE_ORDERED_2011_MUL1 = -4132994306676758123L;
    @GoogleInternal
    private static final long COMBINE_ORDERED_2011_MUL2 = 155523078386399043L;

    public static HashFunction goodFastHash(int n2) {
        int n3 = Hashing.checkPositiveAndMakeMultipleOf32(n2);
        if (n3 == 32) {
            return Hashing$Murmur3_32Holder.GOOD_FAST_HASH_FUNCTION_32;
        }
        if (n3 <= 128) {
            return Hashing$Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
        }
        int n4 = (n3 + 127) / 128;
        HashFunction[] arrhashFunction = new HashFunction[n4];
        arrhashFunction[0] = Hashing$Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
        int n5 = GOOD_FAST_HASH_SEED;
        int n6 = 1;
        while (n6 < n4) {
            arrhashFunction[n6] = Hashing.murmur3_128(n5 += 1500450271);
            ++n6;
        }
        return new Hashing$ConcatenatedHashFunction(arrhashFunction, null);
    }

    public static HashFunction murmur3_32(int n2) {
        return new Murmur3_32HashFunction(n2);
    }

    public static HashFunction murmur3_32() {
        return Hashing$Murmur3_32Holder.MURMUR3_32;
    }

    public static HashFunction murmur3_128(int n2) {
        return new Murmur3_128HashFunction(n2);
    }

    public static HashFunction murmur3_128() {
        return Hashing$Murmur3_128Holder.MURMUR3_128;
    }

    public static HashFunction sipHash24() {
        return Hashing$SipHash24Holder.SIP_HASH_24;
    }

    public static HashFunction sipHash24(long l2, long l3) {
        return new SipHashFunction(2, 4, l2, l3);
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
    public static HashFunction hmacMd5(Key key) {
        return new MacHashFunction("HmacMD5", key, Hashing.hmacToString("hmacMd5", key));
    }

    @GoogleInternal
    public static HashFunction hmacMd5(byte[] arrby) {
        return Hashing.hmacMd5(new SecretKeySpec((byte[])Preconditions.checkNotNull(arrby), "HmacMD5"));
    }

    @GoogleInternal
    public static HashFunction hmacSha1(Key key) {
        return new MacHashFunction("HmacSHA1", key, Hashing.hmacToString("hmacSha1", key));
    }

    @GoogleInternal
    public static HashFunction hmacSha1(byte[] arrby) {
        return Hashing.hmacSha1(new SecretKeySpec((byte[])Preconditions.checkNotNull(arrby), "HmacSHA1"));
    }

    @GoogleInternal
    public static HashFunction hmacSha256(Key key) {
        return new MacHashFunction("HmacSHA256", key, Hashing.hmacToString("hmacSha256", key));
    }

    @GoogleInternal
    public static HashFunction hmacSha256(byte[] arrby) {
        return Hashing.hmacSha256(new SecretKeySpec((byte[])Preconditions.checkNotNull(arrby), "HmacSHA256"));
    }

    @GoogleInternal
    public static HashFunction hmacSha512(Key key) {
        return new MacHashFunction("HmacSHA512", key, Hashing.hmacToString("hmacSha512", key));
    }

    @GoogleInternal
    public static HashFunction hmacSha512(byte[] arrby) {
        return Hashing.hmacSha512(new SecretKeySpec((byte[])Preconditions.checkNotNull(arrby), "HmacSHA512"));
    }

    @GoogleInternal
    private static String hmacToString(String string, Key key) {
        return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", string, key.getAlgorithm(), key.getFormat());
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

    private static HashFunction checksumHashFunction(Hashing$ChecksumType hashing$ChecksumType, String string) {
        return new ChecksumHashFunction(hashing$ChecksumType, Hashing$ChecksumType.access$300(hashing$ChecksumType), string);
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
    public static HashFunction cityHash128(long l2, long l3) {
        return new CityHash128HashFunction(l2, l3);
    }

    public static int consistentHash(HashCode hashCode, int n2) {
        return Hashing.consistentHash(hashCode.padToLong(), n2);
    }

    public static int consistentHash(long l2, int n2) {
        int n3;
        Preconditions.checkArgument(n2 > 0, "buckets must be positive: %s", n2);
        Hashing$LinearCongruentialGenerator hashing$LinearCongruentialGenerator = new Hashing$LinearCongruentialGenerator(l2);
        int n4 = 0;
        while ((n3 = (int)((double)(n4 + 1) / hashing$LinearCongruentialGenerator.nextDouble())) >= 0) {
            if (n3 >= n2) return n4;
            n4 = n3;
        }
        return n4;
    }

    @GoogleInternal
    public static int weightedConsistentHash(HashCode hashCode, double[] arrd) {
        return Hashing.weightedConsistentHash(hashCode.padToLong(), arrd);
    }

    @GoogleInternal
    public static int weightedConsistentHash(long l2, double[] arrd) {
        Preconditions.checkArgument(arrd.length > 0, "bucketWeights must not be empty.");
        Hashing$LinearCongruentialGenerator hashing$LinearCongruentialGenerator = new Hashing$LinearCongruentialGenerator(l2);
        double d2 = Double.NEGATIVE_INFINITY;
        int n2 = -1;
        for (int i2 = 0; i2 < arrd.length; ++i2) {
            double d3;
            double d4 = arrd[i2];
            double d5 = hashing$LinearCongruentialGenerator.nextDouble();
            Preconditions.checkArgument(d4 >= 0.0, "Weights must be non-negative. index=%s", i2);
            if (d4 == 0.0 || (d3 = Math.log(d5) / d4) <= d2) continue;
            n2 = i2;
            d2 = d3;
        }
        Preconditions.checkArgument(n2 >= 0, "There must be at least one positive weight.");
        return n2;
    }

    public static HashCode combineOrdered(Iterable iterable) {
        Iterator iterator = iterable.iterator();
        Preconditions.checkArgument(iterator.hasNext(), "Must be at least 1 hash code to combine.");
        int n2 = ((HashCode)iterator.next()).bits();
        byte[] arrby = new byte[n2 / 8];
        Iterator iterator2 = iterable.iterator();
        block0 : while (iterator2.hasNext()) {
            HashCode hashCode = (HashCode)iterator2.next();
            byte[] arrby2 = hashCode.asBytes();
            Preconditions.checkArgument(arrby2.length == arrby.length, "All hashcodes must have the same bit length.");
            int n3 = 0;
            do {
                if (n3 >= arrby2.length) continue block0;
                arrby[n3] = (byte)(arrby[n3] * 37 ^ arrby2[n3]);
                ++n3;
            } while (true);
            break;
        }
        return HashCode.fromBytesNoCopy(arrby);
    }

    public static HashCode combineUnordered(Iterable iterable) {
        Iterator iterator = iterable.iterator();
        Preconditions.checkArgument(iterator.hasNext(), "Must be at least 1 hash code to combine.");
        byte[] arrby = new byte[((HashCode)iterator.next()).bits() / 8];
        Iterator iterator2 = iterable.iterator();
        block0 : while (iterator2.hasNext()) {
            HashCode hashCode = (HashCode)iterator2.next();
            byte[] arrby2 = hashCode.asBytes();
            Preconditions.checkArgument(arrby2.length == arrby.length, "All hashcodes must have the same bit length.");
            int n2 = 0;
            do {
                if (n2 >= arrby2.length) continue block0;
                byte[] arrby3 = arrby;
                int n3 = n2;
                arrby3[n3] = (byte)(arrby3[n3] + arrby2[n2]);
                ++n2;
            } while (true);
            break;
        }
        return HashCode.fromBytesNoCopy(arrby);
    }

    static int checkPositiveAndMakeMultipleOf32(int n2) {
        Preconditions.checkArgument(n2 > 0, "Number of bits must be positive");
        return n2 + 31 & -32;
    }

    public static /* varargs */ HashFunction concatenating(HashFunction hashFunction, HashFunction hashFunction2, HashFunction ... arrhashFunction) {
        ArrayList<HashFunction> arrayList = new ArrayList<HashFunction>();
        arrayList.add(hashFunction);
        arrayList.add(hashFunction2);
        HashFunction[] arrhashFunction2 = arrhashFunction;
        int n2 = arrhashFunction2.length;
        int n3 = 0;
        while (n3 < n2) {
            HashFunction hashFunction3 = arrhashFunction2[n3];
            arrayList.add(hashFunction3);
            ++n3;
        }
        return new Hashing$ConcatenatedHashFunction(arrayList.toArray(new HashFunction[0]), null);
    }

    public static HashFunction concatenating(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        ArrayList<HashFunction> arrayList = new ArrayList<HashFunction>();
        for (HashFunction hashFunction : iterable) {
            arrayList.add(hashFunction);
        }
        Preconditions.checkArgument(arrayList.size() > 0, "number of hash functions (%s) must be > 0", arrayList.size());
        return new Hashing$ConcatenatedHashFunction(arrayList.toArray(new HashFunction[0]), null);
    }

    @GoogleInternal
    public static HashCode combineOrdered2011(HashCode hashCode, HashCode hashCode2) {
        Preconditions.checkArgument(hashCode.bits() >= 64, "fp1 must have at least 64 bits, but was only %s", hashCode.bits());
        Preconditions.checkArgument(hashCode2.bits() >= 64, "fp2 must have at least 64 bits, but was only %s", hashCode2.bits());
        long l2 = hashCode.asLong() * -4132994306676758123L + hashCode2.asLong() * 155523078386399043L;
        return HashCode.fromLong(l2 + ((l2 ^ -1) >>> 47));
    }

    private Hashing() {
    }

    static /* synthetic */ int access$100() {
        return GOOD_FAST_HASH_SEED;
    }

    static /* synthetic */ HashFunction access$200(Hashing$ChecksumType hashing$ChecksumType, String string) {
        return Hashing.checksumHashFunction(hashing$ChecksumType, string);
    }
}

