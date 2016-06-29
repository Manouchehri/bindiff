package com.google.common.io;

import javax.annotation.*;
import com.google.common.base.*;
import java.math.*;
import com.google.common.math.*;
import com.google.common.annotations.*;
import java.io.*;

class BaseEncoding$StandardBaseEncoding extends BaseEncoding
{
    final BaseEncoding$Alphabet alphabet;
    @Nullable
    final Character paddingChar;
    private transient BaseEncoding upperCase;
    private transient BaseEncoding lowerCase;
    
    BaseEncoding$StandardBaseEncoding(final String s, final String s2, @Nullable final Character c) {
        this(new BaseEncoding$Alphabet(s, s2.toCharArray()), c);
    }
    
    BaseEncoding$StandardBaseEncoding(final BaseEncoding$Alphabet baseEncoding$Alphabet, @Nullable final Character paddingChar) {
        this.alphabet = (BaseEncoding$Alphabet)Preconditions.checkNotNull(baseEncoding$Alphabet);
        Preconditions.checkArgument(paddingChar == null || !baseEncoding$Alphabet.matches(paddingChar), "Padding character %s was already in alphabet", paddingChar);
        this.paddingChar = paddingChar;
    }
    
    @Override
    CharMatcher padding() {
        return (this.paddingChar == null) ? CharMatcher.NONE : CharMatcher.is(this.paddingChar);
    }
    
    @Override
    int maxEncodedSize(final int n) {
        return this.alphabet.charsPerChunk * IntMath.divide(n, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
    }
    
    @GwtIncompatible("Writer,OutputStream")
    @Override
    public OutputStream encodingStream(final Writer writer) {
        Preconditions.checkNotNull(writer);
        return new BaseEncoding$StandardBaseEncoding$1(this, writer);
    }
    
    @Override
    void encodeTo(final Appendable appendable, final byte[] array, final int n, final int n2) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkPositionIndexes(n, n + n2, array.length);
        for (int i = 0; i < n2; i += this.alphabet.bytesPerChunk) {
            this.encodeChunkTo(appendable, array, n + i, Math.min(this.alphabet.bytesPerChunk, n2 - i));
        }
    }
    
    void encodeChunkTo(final Appendable appendable, final byte[] array, final int n, final int n2) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkPositionIndexes(n, n + n2, array.length);
        Preconditions.checkArgument(n2 <= this.alphabet.bytesPerChunk);
        long n3 = 0L;
        for (int i = 0; i < n2; ++i) {
            n3 = (n3 | (array[n + i] & 0xFF)) << 8;
        }
        final int n4 = (n2 + 1) * 8 - this.alphabet.bitsPerChar;
        int j;
        for (j = 0; j < n2 * 8; j += this.alphabet.bitsPerChar) {
            appendable.append(this.alphabet.encode((int)(n3 >>> n4 - j) & this.alphabet.mask));
        }
        if (this.paddingChar != null) {
            while (j < this.alphabet.bytesPerChunk * 8) {
                appendable.append(this.paddingChar);
                j += this.alphabet.bitsPerChar;
            }
        }
    }
    
    @Override
    int maxDecodedSize(final int n) {
        return (int)((this.alphabet.bitsPerChar * n + 7L) / 8L);
    }
    
    @Override
    int decodeTo(final byte[] array, final CharSequence charSequence) {
        Preconditions.checkNotNull(array);
        final String trimTrailing = this.padding().trimTrailingFrom(charSequence);
        if (!this.alphabet.isValidPaddingStartPosition(trimTrailing.length())) {
            throw new BaseEncoding$DecodingException(new StringBuilder(32).append("Invalid input length ").append(trimTrailing.length()).toString());
        }
        int n = 0;
        for (int i = 0; i < trimTrailing.length(); i += this.alphabet.charsPerChunk) {
            long n2 = 0L;
            int n3 = 0;
            for (int j = 0; j < this.alphabet.charsPerChunk; ++j) {
                n2 <<= this.alphabet.bitsPerChar;
                if (i + j < trimTrailing.length()) {
                    n2 |= this.alphabet.decode(trimTrailing.charAt(i + n3++));
                }
            }
            for (int n4 = this.alphabet.bytesPerChunk * 8 - n3 * this.alphabet.bitsPerChar, k = (this.alphabet.bytesPerChunk - 1) * 8; k >= n4; k -= 8) {
                array[n++] = (byte)(n2 >>> k & 0xFFL);
            }
        }
        return n;
    }
    
    @GwtIncompatible("Reader,InputStream")
    @Override
    public InputStream decodingStream(final Reader reader) {
        Preconditions.checkNotNull(reader);
        return new BaseEncoding$StandardBaseEncoding$2(this, reader);
    }
    
    @Override
    public BaseEncoding omitPadding() {
        return (this.paddingChar == null) ? this : this.newInstance(this.alphabet, null);
    }
    
    @Override
    public BaseEncoding withPadChar(final char c) {
        if (8 % this.alphabet.bitsPerChar == 0 || (this.paddingChar != null && this.paddingChar == c)) {
            return this;
        }
        return this.newInstance(this.alphabet, c);
    }
    
    @Override
    public BaseEncoding withSeparator(final String s, final int n) {
        Preconditions.checkArgument(this.padding().or(this.alphabet).matchesNoneOf(s), "Separator (%s) cannot contain alphabet or padding characters", s);
        return new BaseEncoding$SeparatedBaseEncoding(this, s, n);
    }
    
    @Override
    public BaseEncoding upperCase() {
        BaseEncoding upperCase = this.upperCase;
        if (upperCase == null) {
            final BaseEncoding$Alphabet upperCase2 = this.alphabet.upperCase();
            BaseEncoding baseEncoding;
            BaseEncoding$StandardBaseEncoding instance;
            if (upperCase2 == this.alphabet) {
                baseEncoding = this;
                instance = this;
            }
            else {
                baseEncoding = (instance = (BaseEncoding$StandardBaseEncoding)this.newInstance(upperCase2, this.paddingChar));
            }
            this.upperCase = instance;
            upperCase = baseEncoding;
        }
        return upperCase;
    }
    
    @Override
    public BaseEncoding lowerCase() {
        BaseEncoding lowerCase = this.lowerCase;
        if (lowerCase == null) {
            final BaseEncoding$Alphabet lowerCase2 = this.alphabet.lowerCase();
            BaseEncoding baseEncoding;
            BaseEncoding$StandardBaseEncoding instance;
            if (lowerCase2 == this.alphabet) {
                baseEncoding = this;
                instance = this;
            }
            else {
                baseEncoding = (instance = (BaseEncoding$StandardBaseEncoding)this.newInstance(lowerCase2, this.paddingChar));
            }
            this.lowerCase = instance;
            lowerCase = baseEncoding;
        }
        return lowerCase;
    }
    
    BaseEncoding newInstance(final BaseEncoding$Alphabet baseEncoding$Alphabet, @Nullable final Character c) {
        return new BaseEncoding$StandardBaseEncoding(baseEncoding$Alphabet, c);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.alphabet.toString());
        if (8 % this.alphabet.bitsPerChar != 0) {
            if (this.paddingChar == null) {
                sb.append(".omitPadding()");
            }
            else {
                sb.append(".withPadChar(").append(this.paddingChar).append(')');
            }
        }
        return sb.toString();
    }
}
