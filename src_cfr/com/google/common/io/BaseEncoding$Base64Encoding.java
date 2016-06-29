/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import javax.annotation.Nullable;

final class BaseEncoding$Base64Encoding
extends BaseEncoding$StandardBaseEncoding {
    BaseEncoding$Base64Encoding(String string, String string2, @Nullable Character c2) {
        this(new BaseEncoding$Alphabet(string, string2.toCharArray()), c2);
    }

    private BaseEncoding$Base64Encoding(BaseEncoding$Alphabet baseEncoding$Alphabet, @Nullable Character c2) {
        super(baseEncoding$Alphabet, c2);
        Preconditions.checkArgument(BaseEncoding$Alphabet.access$000(baseEncoding$Alphabet).length == 64);
    }

    @Override
    void encodeTo(Appendable appendable, byte[] arrby, int n2, int n3) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkPositionIndexes(n2, n2 + n3, arrby.length);
        int n4 = n2;
        int n5 = n3;
        do {
            if (n5 < 3) {
                if (n4 >= n2 + n3) return;
                this.encodeChunkTo(appendable, arrby, n4, n2 + n3 - n4);
                return;
            }
            int n6 = (arrby[n4++] & 255) << 16 | (arrby[n4++] & 255) << 8 | arrby[n4++] & 255;
            appendable.append(this.alphabet.encode(n6 >>> 18));
            appendable.append(this.alphabet.encode(n6 >>> 12 & 63));
            appendable.append(this.alphabet.encode(n6 >>> 6 & 63));
            appendable.append(this.alphabet.encode(n6 & 63));
            n5 -= 3;
        } while (true);
    }

    @Override
    int decodeTo(byte[] arrby, CharSequence charSequence) {
        Preconditions.checkNotNull(arrby);
        charSequence = this.padding().trimTrailingFrom(charSequence);
        if (!this.alphabet.isValidPaddingStartPosition(charSequence.length())) {
            int n2 = charSequence.length();
            throw new BaseEncoding$DecodingException(new StringBuilder(32).append("Invalid input length ").append(n2).toString());
        }
        int n3 = 0;
        int n4 = 0;
        while (n4 < charSequence.length()) {
            int n5 = this.alphabet.decode(charSequence.charAt(n4++)) << 18;
            arrby[n3++] = (byte)((n5 |= this.alphabet.decode(charSequence.charAt(n4++)) << 12) >>> 16);
            if (n4 >= charSequence.length()) continue;
            arrby[n3++] = (byte)((n5 |= this.alphabet.decode(charSequence.charAt(n4++)) << 6) >>> 8 & 255);
            if (n4 >= charSequence.length()) continue;
            arrby[n3++] = (byte)((n5 |= this.alphabet.decode(charSequence.charAt(n4++))) & 255);
        }
        return n3;
    }

    @Override
    BaseEncoding newInstance(BaseEncoding$Alphabet baseEncoding$Alphabet, @Nullable Character c2) {
        return new BaseEncoding$Base64Encoding(baseEncoding$Alphabet, c2);
    }
}

