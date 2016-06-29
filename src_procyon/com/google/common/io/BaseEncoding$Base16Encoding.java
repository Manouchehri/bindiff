package com.google.common.io;

import javax.annotation.*;
import java.math.*;
import com.google.common.math.*;
import java.util.*;
import java.io.*;
import com.google.common.base.*;

final class BaseEncoding$Base16Encoding extends BaseEncoding$StandardBaseEncoding
{
    final char[] encoding;
    
    BaseEncoding$Base16Encoding(final String s, final String s2) {
        this(new BaseEncoding$Alphabet(s, s2.toCharArray()));
    }
    
    private BaseEncoding$Base16Encoding(final BaseEncoding$Alphabet baseEncoding$Alphabet) {
        super(baseEncoding$Alphabet, null);
        this.encoding = new char[512];
        Preconditions.checkArgument(baseEncoding$Alphabet.chars.length == 16);
        for (int i = 0; i < 256; ++i) {
            this.encoding[i] = baseEncoding$Alphabet.encode(i >>> 4);
            this.encoding[i | 0x100] = baseEncoding$Alphabet.encode(i & 0xF);
        }
    }
    
    @Override
    void encodeTo(final Appendable appendable, final byte[] array, final int n, final int n2) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkPositionIndexes(n, n + n2, array.length);
        for (int i = 0; i < n2; ++i) {
            final int n3 = array[n + i] & 0xFF;
            appendable.append(this.encoding[n3]);
            appendable.append(this.encoding[n3 | 0x100]);
        }
    }
    
    @Override
    int decodeTo(final byte[] array, final CharSequence charSequence) {
        Preconditions.checkNotNull(array);
        if (charSequence.length() % 2 == 1) {
            throw new BaseEncoding$DecodingException(new StringBuilder(32).append("Invalid input length ").append(charSequence.length()).toString());
        }
        int n = 0;
        for (int i = 0; i < charSequence.length(); i += 2) {
            array[n++] = (byte)(this.alphabet.decode(charSequence.charAt(i)) << 4 | this.alphabet.decode(charSequence.charAt(i + 1)));
        }
        return n;
    }
    
    @Override
    BaseEncoding newInstance(final BaseEncoding$Alphabet baseEncoding$Alphabet, @Nullable final Character c) {
        return new BaseEncoding$Base16Encoding(baseEncoding$Alphabet);
    }
}
