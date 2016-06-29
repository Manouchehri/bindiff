package com.google.common.io;

import javax.annotation.*;
import java.math.*;
import com.google.common.math.*;
import java.util.*;
import java.io.*;
import com.google.common.base.*;

final class BaseEncoding$Base64Encoding extends BaseEncoding$StandardBaseEncoding
{
    BaseEncoding$Base64Encoding(final String s, final String s2, @Nullable final Character c) {
        this(new BaseEncoding$Alphabet(s, s2.toCharArray()), c);
    }
    
    private BaseEncoding$Base64Encoding(final BaseEncoding$Alphabet baseEncoding$Alphabet, @Nullable final Character c) {
        super(baseEncoding$Alphabet, c);
        Preconditions.checkArgument(baseEncoding$Alphabet.chars.length == 64);
    }
    
    @Override
    void encodeTo(final Appendable appendable, final byte[] array, final int n, final int n2) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkPositionIndexes(n, n + n2, array.length);
        int n3 = n;
        for (int i = n2; i >= 3; i -= 3) {
            final int n4 = (array[n3++] & 0xFF) << 16 | (array[n3++] & 0xFF) << 8 | (array[n3++] & 0xFF);
            appendable.append(this.alphabet.encode(n4 >>> 18));
            appendable.append(this.alphabet.encode(n4 >>> 12 & 0x3F));
            appendable.append(this.alphabet.encode(n4 >>> 6 & 0x3F));
            appendable.append(this.alphabet.encode(n4 & 0x3F));
        }
        if (n3 < n + n2) {
            this.encodeChunkTo(appendable, array, n3, n + n2 - n3);
        }
    }
    
    @Override
    int decodeTo(final byte[] array, final CharSequence charSequence) {
        Preconditions.checkNotNull(array);
        final String trimTrailing = this.padding().trimTrailingFrom(charSequence);
        if (!this.alphabet.isValidPaddingStartPosition(trimTrailing.length())) {
            throw new BaseEncoding$DecodingException(new StringBuilder(32).append("Invalid input length ").append(trimTrailing.length()).toString());
        }
        int n = 0;
        int i = 0;
        while (i < trimTrailing.length()) {
            final int n2 = this.alphabet.decode(trimTrailing.charAt(i++)) << 18 | this.alphabet.decode(trimTrailing.charAt(i++)) << 12;
            array[n++] = (byte)(n2 >>> 16);
            if (i < trimTrailing.length()) {
                final int n3 = n2 | this.alphabet.decode(trimTrailing.charAt(i++)) << 6;
                array[n++] = (byte)(n3 >>> 8 & 0xFF);
                if (i >= trimTrailing.length()) {
                    continue;
                }
                array[n++] = (byte)((n3 | this.alphabet.decode(trimTrailing.charAt(i++))) & 0xFF);
            }
        }
        return n;
    }
    
    @Override
    BaseEncoding newInstance(final BaseEncoding$Alphabet baseEncoding$Alphabet, @Nullable final Character c) {
        return new BaseEncoding$Base64Encoding(baseEncoding$Alphabet, c);
    }
}
