/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.math.IntMath;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;

final class BaseEncoding$SeparatedBaseEncoding
extends BaseEncoding {
    private final BaseEncoding delegate;
    private final String separator;
    private final int afterEveryChars;
    private final CharMatcher separatorChars;

    BaseEncoding$SeparatedBaseEncoding(BaseEncoding baseEncoding, String string, int n2) {
        this.delegate = (BaseEncoding)Preconditions.checkNotNull(baseEncoding);
        this.separator = (String)Preconditions.checkNotNull(string);
        this.afterEveryChars = n2;
        Preconditions.checkArgument(n2 > 0, "Cannot add a separator after every %s chars", n2);
        this.separatorChars = CharMatcher.anyOf(string).precomputed();
    }

    @Override
    CharMatcher padding() {
        return this.delegate.padding();
    }

    @Override
    int maxEncodedSize(int n2) {
        int n3 = this.delegate.maxEncodedSize(n2);
        return n3 + this.separator.length() * IntMath.divide(Math.max(0, n3 - 1), this.afterEveryChars, RoundingMode.FLOOR);
    }

    @GwtIncompatible(value="Writer,OutputStream")
    @Override
    public OutputStream encodingStream(Writer writer) {
        return this.delegate.encodingStream(BaseEncoding$SeparatedBaseEncoding.separatingWriter(writer, this.separator, this.afterEveryChars));
    }

    @Override
    void encodeTo(Appendable appendable, byte[] arrby, int n2, int n3) {
        this.delegate.encodeTo(BaseEncoding$SeparatedBaseEncoding.separatingAppendable(appendable, this.separator, this.afterEveryChars), arrby, n2, n3);
    }

    @Override
    int maxDecodedSize(int n2) {
        return this.delegate.maxDecodedSize(n2);
    }

    @Override
    int decodeTo(byte[] arrby, CharSequence charSequence) {
        return this.delegate.decodeTo(arrby, this.separatorChars.removeFrom(charSequence));
    }

    @GwtIncompatible(value="Reader,InputStream")
    @Override
    public InputStream decodingStream(Reader reader) {
        return this.delegate.decodingStream(BaseEncoding$SeparatedBaseEncoding.ignoringReader(reader, this.separatorChars));
    }

    @Override
    public BaseEncoding omitPadding() {
        return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
    }

    @Override
    public BaseEncoding withPadChar(char c2) {
        return this.delegate.withPadChar(c2).withSeparator(this.separator, this.afterEveryChars);
    }

    @Override
    public BaseEncoding withSeparator(String string, int n2) {
        throw new UnsupportedOperationException("Already have a separator");
    }

    @Override
    public BaseEncoding upperCase() {
        return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
    }

    @Override
    public BaseEncoding lowerCase() {
        return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
    }

    public String toString() {
        String string = String.valueOf(this.delegate.toString());
        String string2 = this.separator;
        int n2 = this.afterEveryChars;
        return new StringBuilder(31 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(".withSeparator(\"").append(string2).append("\", ").append(n2).append(")").toString();
    }
}

