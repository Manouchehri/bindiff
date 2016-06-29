/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import javax.annotation.Nullable;

final class BaseEncoding$Base16Encoding
extends BaseEncoding$StandardBaseEncoding {
    final char[] encoding = new char[512];

    BaseEncoding$Base16Encoding(String string, String string2) {
        this(new BaseEncoding$Alphabet(string, string2.toCharArray()));
    }

    private BaseEncoding$Base16Encoding(BaseEncoding$Alphabet baseEncoding$Alphabet) {
        super(baseEncoding$Alphabet, null);
        Preconditions.checkArgument(BaseEncoding$Alphabet.access$000(baseEncoding$Alphabet).length == 16);
        int n2 = 0;
        while (n2 < 256) {
            this.encoding[n2] = baseEncoding$Alphabet.encode(n2 >>> 4);
            this.encoding[n2 | 256] = baseEncoding$Alphabet.encode(n2 & 15);
            ++n2;
        }
    }

    @Override
    void encodeTo(Appendable appendable, byte[] arrby, int n2, int n3) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkPositionIndexes(n2, n2 + n3, arrby.length);
        int n4 = 0;
        while (n4 < n3) {
            int n5 = arrby[n2 + n4] & 255;
            appendable.append(this.encoding[n5]);
            appendable.append(this.encoding[n5 | 256]);
            ++n4;
        }
    }

    @Override
    int decodeTo(byte[] arrby, CharSequence charSequence) {
        Preconditions.checkNotNull(arrby);
        if (charSequence.length() % 2 == 1) {
            int n2 = charSequence.length();
            throw new BaseEncoding$DecodingException(new StringBuilder(32).append("Invalid input length ").append(n2).toString());
        }
        int n3 = 0;
        int n4 = 0;
        while (n4 < charSequence.length()) {
            int n5 = this.alphabet.decode(charSequence.charAt(n4)) << 4 | this.alphabet.decode(charSequence.charAt(n4 + 1));
            arrby[n3++] = (byte)n5;
            n4 += 2;
        }
        return n3;
    }

    @Override
    BaseEncoding newInstance(BaseEncoding$Alphabet baseEncoding$Alphabet, @Nullable Character c2) {
        return new BaseEncoding$Base16Encoding(baseEncoding$Alphabet);
    }
}

