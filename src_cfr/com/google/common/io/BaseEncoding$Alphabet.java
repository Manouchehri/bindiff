/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;

final class BaseEncoding$Alphabet
extends CharMatcher {
    private final String name;
    private final char[] chars;
    final int mask;
    final int bitsPerChar;
    final int charsPerChunk;
    final int bytesPerChunk;
    private final byte[] decodabet;
    private final boolean[] validPadding;

    BaseEncoding$Alphabet(String string, char[] arrc) {
        char c2;
        this.name = (String)Preconditions.checkNotNull(string);
        this.chars = (char[])Preconditions.checkNotNull(arrc);
        try {
            this.bitsPerChar = IntMath.log2(arrc.length, RoundingMode.UNNECESSARY);
        }
        catch (ArithmeticException var3_3) {
            int n2 = arrc.length;
            throw new IllegalArgumentException(new StringBuilder(35).append("Illegal alphabet length ").append(n2).toString(), var3_3);
        }
        int n3 = Math.min(8, Integer.lowestOneBit(this.bitsPerChar));
        this.charsPerChunk = 8 / n3;
        this.bytesPerChunk = this.bitsPerChar / n3;
        this.mask = arrc.length - 1;
        byte[] arrby = new byte[128];
        Arrays.fill(arrby, -1);
        for (int i2 = 0; i2 < arrc.length; ++i2) {
            c2 = arrc[i2];
            Preconditions.checkArgument(CharMatcher.ASCII.matches(c2), "Non-ASCII character: %s", Character.valueOf(c2));
            Preconditions.checkArgument(arrby[c2] == -1, "Duplicate character: %s", Character.valueOf(c2));
            arrby[c2] = (byte)i2;
        }
        this.decodabet = arrby;
        boolean[] arrbl = new boolean[this.charsPerChunk];
        c2 = '\u0000';
        do {
            if (c2 >= this.bytesPerChunk) {
                this.validPadding = arrbl;
                return;
            }
            arrbl[IntMath.divide((int)(c2 * 8), (int)this.bitsPerChar, (RoundingMode)RoundingMode.CEILING)] = true;
            ++c2;
        } while (true);
    }

    char encode(int n2) {
        return this.chars[n2];
    }

    boolean isValidPaddingStartPosition(int n2) {
        return this.validPadding[n2 % this.charsPerChunk];
    }

    int decode(char c2) {
        Object object;
        if (c2 <= '') {
            if (this.decodabet[c2] != -1) return this.decodabet[c2];
        }
        if (CharMatcher.INVISIBLE.matches(c2)) {
            String string = String.valueOf(Integer.toHexString(c2));
            object = string.length() != 0 ? "0x".concat(string) : new String("0x");
        } else {
            object = Character.valueOf(c2);
        }
        String string = String.valueOf(object);
        throw new BaseEncoding$DecodingException(new StringBuilder(24 + String.valueOf(string).length()).append("Unrecognized character: ").append(string).toString());
    }

    private boolean hasLowerCase() {
        char[] arrc = this.chars;
        int n2 = arrc.length;
        int n3 = 0;
        while (n3 < n2) {
            char c2 = arrc[n3];
            if (Ascii.isLowerCase(c2)) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    private boolean hasUpperCase() {
        char[] arrc = this.chars;
        int n2 = arrc.length;
        int n3 = 0;
        while (n3 < n2) {
            char c2 = arrc[n3];
            if (Ascii.isUpperCase(c2)) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    BaseEncoding$Alphabet upperCase() {
        if (!this.hasLowerCase()) {
            return this;
        }
        Preconditions.checkState(!this.hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
        char[] arrc = new char[this.chars.length];
        int n2 = 0;
        while (n2 < this.chars.length) {
            arrc[n2] = Ascii.toUpperCase(this.chars[n2]);
            ++n2;
        }
        return new BaseEncoding$Alphabet(String.valueOf(this.name).concat(".upperCase()"), arrc);
    }

    BaseEncoding$Alphabet lowerCase() {
        if (!this.hasUpperCase()) {
            return this;
        }
        Preconditions.checkState(!this.hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
        char[] arrc = new char[this.chars.length];
        int n2 = 0;
        while (n2 < this.chars.length) {
            arrc[n2] = Ascii.toLowerCase(this.chars[n2]);
            ++n2;
        }
        return new BaseEncoding$Alphabet(String.valueOf(this.name).concat(".lowerCase()"), arrc);
    }

    @Override
    public boolean matches(char c2) {
        if (!CharMatcher.ASCII.matches(c2)) return false;
        if (this.decodabet[c2] == -1) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }

    static /* synthetic */ char[] access$000(BaseEncoding$Alphabet baseEncoding$Alphabet) {
        return baseEncoding$Alphabet.chars;
    }
}

