package com.google.common.io;

import java.math.*;
import com.google.common.math.*;
import java.util.*;
import java.io.*;
import com.google.common.base.*;

final class BaseEncoding$Alphabet extends CharMatcher
{
    private final String name;
    private final char[] chars;
    final int mask;
    final int bitsPerChar;
    final int charsPerChunk;
    final int bytesPerChunk;
    private final byte[] decodabet;
    private final boolean[] validPadding;
    
    BaseEncoding$Alphabet(final String s, final char[] array) {
        this.name = (String)Preconditions.checkNotNull(s);
        this.chars = (char[])Preconditions.checkNotNull(array);
        try {
            this.bitsPerChar = IntMath.log2(array.length, RoundingMode.UNNECESSARY);
        }
        catch (ArithmeticException ex) {
            throw new IllegalArgumentException(new StringBuilder(35).append("Illegal alphabet length ").append(array.length).toString(), ex);
        }
        final int min = Math.min(8, Integer.lowestOneBit(this.bitsPerChar));
        this.charsPerChunk = 8 / min;
        this.bytesPerChunk = this.bitsPerChar / min;
        this.mask = array.length - 1;
        final byte[] decodabet = new byte[128];
        Arrays.fill(decodabet, (byte)(-1));
        for (int i = 0; i < array.length; ++i) {
            final char c = array[i];
            Preconditions.checkArgument(CharMatcher.ASCII.matches(c), "Non-ASCII character: %s", c);
            Preconditions.checkArgument(decodabet[c] == -1, "Duplicate character: %s", c);
            decodabet[c] = (byte)i;
        }
        this.decodabet = decodabet;
        final boolean[] validPadding = new boolean[this.charsPerChunk];
        for (int j = 0; j < this.bytesPerChunk; ++j) {
            validPadding[IntMath.divide(j * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
        }
        this.validPadding = validPadding;
    }
    
    char encode(final int n) {
        return this.chars[n];
    }
    
    boolean isValidPaddingStartPosition(final int n) {
        return this.validPadding[n % this.charsPerChunk];
    }
    
    int decode(final char c) {
        if (c > '\u007f' || this.decodabet[c] == -1) {
            Serializable value2;
            if (CharMatcher.INVISIBLE.matches(c)) {
                final String s = "0x";
                final String value = String.valueOf(Integer.toHexString(c));
                value2 = ((value.length() != 0) ? s.concat(value) : new String(s));
            }
            else {
                value2 = c;
            }
            final String value3 = String.valueOf(value2);
            throw new BaseEncoding$DecodingException(new StringBuilder(24 + String.valueOf(value3).length()).append("Unrecognized character: ").append(value3).toString());
        }
        return this.decodabet[c];
    }
    
    private boolean hasLowerCase() {
        final char[] chars = this.chars;
        for (int length = chars.length, i = 0; i < length; ++i) {
            if (Ascii.isLowerCase(chars[i])) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasUpperCase() {
        final char[] chars = this.chars;
        for (int length = chars.length, i = 0; i < length; ++i) {
            if (Ascii.isUpperCase(chars[i])) {
                return true;
            }
        }
        return false;
    }
    
    BaseEncoding$Alphabet upperCase() {
        if (!this.hasLowerCase()) {
            return this;
        }
        Preconditions.checkState(!this.hasUpperCase(), (Object)"Cannot call upperCase() on a mixed-case alphabet");
        final char[] array = new char[this.chars.length];
        for (int i = 0; i < this.chars.length; ++i) {
            array[i] = Ascii.toUpperCase(this.chars[i]);
        }
        return new BaseEncoding$Alphabet(String.valueOf(this.name).concat(".upperCase()"), array);
    }
    
    BaseEncoding$Alphabet lowerCase() {
        if (!this.hasUpperCase()) {
            return this;
        }
        Preconditions.checkState(!this.hasLowerCase(), (Object)"Cannot call lowerCase() on a mixed-case alphabet");
        final char[] array = new char[this.chars.length];
        for (int i = 0; i < this.chars.length; ++i) {
            array[i] = Ascii.toLowerCase(this.chars[i]);
        }
        return new BaseEncoding$Alphabet(String.valueOf(this.name).concat(".lowerCase()"), array);
    }
    
    @Override
    public boolean matches(final char c) {
        return CharMatcher.ASCII.matches(c) && this.decodabet[c] != -1;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
