/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.CityHash128HashFunction;
import com.google.common.hash.CityHash128HashFunction$1;
import com.google.common.hash.CityHash128HashFunction$Internal;
import com.google.common.hash.HashCode;
import com.google.common.hash.LittleEndianByteArray;

final class CityHash128HashFunction$Internal$1
extends CityHash128HashFunction$Internal {
    CityHash128HashFunction$Internal$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    protected HashCode fingerprint(byte[] arrby, int n2, int n3, long l2, long l3) {
        if (n3 < 128) {
            return CityHash128HashFunction.access$100(arrby, n2, n3, l2, l3);
        }
        byte[] arrby2 = new byte[16];
        long[] arrl = new long[2];
        long[] arrl2 = new long[2];
        long l4 = (long)n3 * -8261664234251669945L;
        arrl[0] = Long.rotateRight(l3 ^ -8261664234251669945L, 49) * -8261664234251669945L + LittleEndianByteArray.load64(arrby, n2);
        arrl[1] = Long.rotateRight(arrl[0], 42) * -8261664234251669945L + LittleEndianByteArray.load64(arrby, n2 + 8);
        arrl2[0] = Long.rotateRight(l3 + l4, 35) * -8261664234251669945L + l2;
        arrl2[1] = Long.rotateRight(l2 + LittleEndianByteArray.load64(arrby, n2 + 88), 53) * -8261664234251669945L;
        do {
            l2 = Long.rotateRight(l2 + l3 + arrl[0] + LittleEndianByteArray.load64(arrby, n2 + 16), 37) * -8261664234251669945L;
            l3 = Long.rotateRight(l3 + arrl[1] + LittleEndianByteArray.load64(arrby, n2 + 48), 42) * -8261664234251669945L;
            l4 = Long.rotateRight(l4 ^ arrl2[0], 33);
            this.weakHashLength32WithSeeds(arrby, n2, arrl[1] * -8261664234251669945L, (l2 ^= arrl2[1]) + arrl2[0], arrl);
            this.weakHashLength32WithSeeds(arrby, n2 + 32, l4 + arrl2[1], l3 ^= arrl[0], arrl2);
            l4 = Long.rotateRight(l4 + l3 + arrl[0] + LittleEndianByteArray.load64(arrby, n2 + 80), 37) * -8261664234251669945L;
            l3 = Long.rotateRight(l3 + arrl[1] + LittleEndianByteArray.load64(arrby, n2 + 112), 42) * -8261664234251669945L;
            l2 = Long.rotateRight(l2 ^ arrl2[0], 33);
            this.weakHashLength32WithSeeds(arrby, n2 + 64, arrl[1] * -8261664234251669945L, (l4 ^= arrl2[1]) + arrl2[0], arrl);
            this.weakHashLength32WithSeeds(arrby, n2 + 96, l2 + arrl2[1], l3 ^= arrl[0], arrl2);
            n2 += 128;
        } while ((n3 -= 128) >= 128);
        l3 += Long.rotateRight(arrl2[0], 37) * -6505348102511208375L + l4;
        l2 += Long.rotateRight(arrl[0] + l4, 49) * -6505348102511208375L;
        n2 += n3 - 32;
        do {
            if (n3 <= 0) {
                l2 = CityHash128HashFunction.access$200(l2, arrl[0]);
                l3 = CityHash128HashFunction.access$200(l3, arrl2[0]);
                LittleEndianByteArray.store64(arrby2, 0, CityHash128HashFunction.access$200(l2 + arrl2[1], l3 + arrl[1]));
                LittleEndianByteArray.store64(arrby2, 8, CityHash128HashFunction.access$200(l2 + arrl[1], arrl2[1]) + l3);
                return HashCode.fromBytesNoCopy(arrby2);
            }
            l3 = Long.rotateRight(l3 - l2, 42) * -6505348102511208375L + arrl[1];
            long[] arrl3 = arrl2;
            arrl3[0] = arrl3[0] + LittleEndianByteArray.load64(arrby, n2 + 16);
            l2 = Long.rotateRight(l2, 49) * -6505348102511208375L + arrl2[0];
            long[] arrl4 = arrl2;
            arrl4[0] = arrl4[0] + arrl[0];
            this.weakHashLength32WithSeeds(arrby, n2, arrl[0], arrl[1], arrl);
            n2 -= 32;
            n3 -= 32;
        } while (true);
    }

    private void weakHashLength32WithSeeds(byte[] arrby, int n2, long l2, long l3, long[] arrl) {
        long l4 = LittleEndianByteArray.load64(arrby, n2);
        long l5 = LittleEndianByteArray.load64(arrby, n2 + 8);
        long l6 = LittleEndianByteArray.load64(arrby, n2 + 16);
        long l7 = LittleEndianByteArray.load64(arrby, n2 + 24);
        l3 = Long.rotateRight(l3 + (l2 += l4) + l7, 51);
        long l8 = l2;
        l2 += l5;
        arrl[0] = l2 + l7;
        arrl[1] = (l3 += Long.rotateRight(l2 += l6, 23)) + l8;
    }
}

