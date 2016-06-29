/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$SeparatedBaseEncoding;
import com.google.common.io.BaseEncoding$StandardBaseEncoding$1;
import com.google.common.io.BaseEncoding$StandardBaseEncoding$2;
import com.google.common.math.IntMath;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import javax.annotation.Nullable;

class BaseEncoding$StandardBaseEncoding
extends BaseEncoding {
    final BaseEncoding$Alphabet alphabet;
    @Nullable
    final Character paddingChar;
    private transient BaseEncoding upperCase;
    private transient BaseEncoding lowerCase;

    BaseEncoding$StandardBaseEncoding(String string, String string2, @Nullable Character c2) {
        this(new BaseEncoding$Alphabet(string, string2.toCharArray()), c2);
    }

    BaseEncoding$StandardBaseEncoding(BaseEncoding$Alphabet baseEncoding$Alphabet, @Nullable Character c2) {
        this.alphabet = (BaseEncoding$Alphabet)Preconditions.checkNotNull(baseEncoding$Alphabet);
        Preconditions.checkArgument(c2 == null || !baseEncoding$Alphabet.matches(c2.charValue()), "Padding character %s was already in alphabet", c2);
        this.paddingChar = c2;
    }

    @Override
    CharMatcher padding() {
        CharMatcher charMatcher;
        if (this.paddingChar == null) {
            charMatcher = CharMatcher.NONE;
            return charMatcher;
        }
        charMatcher = CharMatcher.is(this.paddingChar.charValue());
        return charMatcher;
    }

    @Override
    int maxEncodedSize(int n2) {
        return this.alphabet.charsPerChunk * IntMath.divide(n2, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
    }

    @GwtIncompatible(value="Writer,OutputStream")
    @Override
    public OutputStream encodingStream(Writer writer) {
        Preconditions.checkNotNull(writer);
        return new BaseEncoding$StandardBaseEncoding$1(this, writer);
    }

    @Override
    void encodeTo(Appendable appendable, byte[] arrby, int n2, int n3) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkPositionIndexes(n2, n2 + n3, arrby.length);
        int n4 = 0;
        while (n4 < n3) {
            this.encodeChunkTo(appendable, arrby, n2 + n4, Math.min(this.alphabet.bytesPerChunk, n3 - n4));
            n4 += this.alphabet.bytesPerChunk;
        }
    }

    void encodeChunkTo(Appendable appendable, byte[] arrby, int n2, int n3) {
        int n4;
        int n5;
        Preconditions.checkNotNull(appendable);
        Preconditions.checkPositionIndexes(n2, n2 + n3, arrby.length);
        Preconditions.checkArgument(n3 <= this.alphabet.bytesPerChunk);
        long l2 = 0;
        for (n4 = 0; n4 < n3; l2 <<= 8, ++n4) {
            l2 |= (long)(arrby[n2 + n4] & 255);
        }
        n4 = (n3 + 1) * 8 - this.alphabet.bitsPerChar;
        for (n5 = 0; n5 < n3 * 8; n5 += this.alphabet.bitsPerChar) {
            int n6 = (int)(l2 >>> n4 - n5) & this.alphabet.mask;
            appendable.append(this.alphabet.encode(n6));
        }
        if (this.paddingChar == null) return;
        while (n5 < this.alphabet.bytesPerChunk * 8) {
            appendable.append(this.paddingChar.charValue());
            n5 += this.alphabet.bitsPerChar;
        }
    }

    @Override
    int maxDecodedSize(int n2) {
        return (int)(((long)this.alphabet.bitsPerChar * (long)n2 + 7) / 8);
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
            int n5;
            long l2 = 0;
            int n6 = 0;
            for (n5 = 0; n5 < this.alphabet.charsPerChunk; ++n5) {
                l2 <<= this.alphabet.bitsPerChar;
                if (n4 + n5 >= charSequence.length()) continue;
                l2 |= (long)this.alphabet.decode(charSequence.charAt(n4 + n6++));
            }
            n5 = this.alphabet.bytesPerChunk * 8 - n6 * this.alphabet.bitsPerChar;
            for (int i2 = (this.alphabet.bytesPerChunk - 1) * 8; i2 >= n5; i2 -= 8) {
                arrby[n3++] = (byte)(l2 >>> i2 & 255);
            }
            n4 += this.alphabet.charsPerChunk;
        }
        return n3;
    }

    @GwtIncompatible(value="Reader,InputStream")
    @Override
    public InputStream decodingStream(Reader reader) {
        Preconditions.checkNotNull(reader);
        return new BaseEncoding$StandardBaseEncoding$2(this, reader);
    }

    @Override
    public BaseEncoding omitPadding() {
        BaseEncoding$StandardBaseEncoding baseEncoding$StandardBaseEncoding /* !! */ ;
        if (this.paddingChar == null) {
            baseEncoding$StandardBaseEncoding /* !! */  = this;
            return baseEncoding$StandardBaseEncoding /* !! */ ;
        }
        baseEncoding$StandardBaseEncoding /* !! */  = this.newInstance(this.alphabet, null);
        return baseEncoding$StandardBaseEncoding /* !! */ ;
    }

    @Override
    public BaseEncoding withPadChar(char c2) {
        if (8 % this.alphabet.bitsPerChar == 0) return this;
        if (this.paddingChar == null) return this.newInstance(this.alphabet, Character.valueOf(c2));
        if (this.paddingChar.charValue() != c2) return this.newInstance(this.alphabet, Character.valueOf(c2));
        return this;
    }

    @Override
    public BaseEncoding withSeparator(String string, int n2) {
        Preconditions.checkArgument(this.padding().or(this.alphabet).matchesNoneOf(string), "Separator (%s) cannot contain alphabet or padding characters", string);
        return new BaseEncoding$SeparatedBaseEncoding(this, string, n2);
    }

    @Override
    public BaseEncoding upperCase() {
        BaseEncoding baseEncoding = this.upperCase;
        if (baseEncoding != null) return baseEncoding;
        BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet.upperCase();
        this.upperCase = baseEncoding$Alphabet == this.alphabet ? this : this.newInstance(baseEncoding$Alphabet, this.paddingChar);
        return this.upperCase;
    }

    @Override
    public BaseEncoding lowerCase() {
        BaseEncoding baseEncoding = this.lowerCase;
        if (baseEncoding != null) return baseEncoding;
        BaseEncoding$Alphabet baseEncoding$Alphabet = this.alphabet.lowerCase();
        this.lowerCase = baseEncoding$Alphabet == this.alphabet ? this : this.newInstance(baseEncoding$Alphabet, this.paddingChar);
        return this.lowerCase;
    }

    BaseEncoding newInstance(BaseEncoding$Alphabet baseEncoding$Alphabet, @Nullable Character c2) {
        return new BaseEncoding$StandardBaseEncoding(baseEncoding$Alphabet, c2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("BaseEncoding.");
        stringBuilder.append(this.alphabet.toString());
        if (8 % this.alphabet.bitsPerChar == 0) return stringBuilder.toString();
        if (this.paddingChar == null) {
            stringBuilder.append(".omitPadding()");
            return stringBuilder.toString();
        }
        stringBuilder.append(".withPadChar(").append(this.paddingChar).append(')');
        return stringBuilder.toString();
    }
}

