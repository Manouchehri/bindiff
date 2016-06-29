package com.google.common.io;

import com.google.common.base.*;
import java.math.*;
import com.google.common.math.*;
import com.google.common.annotations.*;
import java.io.*;

final class BaseEncoding$SeparatedBaseEncoding extends BaseEncoding
{
    private final BaseEncoding delegate;
    private final String separator;
    private final int afterEveryChars;
    private final CharMatcher separatorChars;
    
    BaseEncoding$SeparatedBaseEncoding(final BaseEncoding baseEncoding, final String s, final int afterEveryChars) {
        this.delegate = (BaseEncoding)Preconditions.checkNotNull(baseEncoding);
        this.separator = (String)Preconditions.checkNotNull(s);
        this.afterEveryChars = afterEveryChars;
        Preconditions.checkArgument(afterEveryChars > 0, "Cannot add a separator after every %s chars", afterEveryChars);
        this.separatorChars = CharMatcher.anyOf(s).precomputed();
    }
    
    @Override
    CharMatcher padding() {
        return this.delegate.padding();
    }
    
    @Override
    int maxEncodedSize(final int n) {
        final int maxEncodedSize = this.delegate.maxEncodedSize(n);
        return maxEncodedSize + this.separator.length() * IntMath.divide(Math.max(0, maxEncodedSize - 1), this.afterEveryChars, RoundingMode.FLOOR);
    }
    
    @GwtIncompatible("Writer,OutputStream")
    @Override
    public OutputStream encodingStream(final Writer writer) {
        return this.delegate.encodingStream(BaseEncoding.separatingWriter(writer, this.separator, this.afterEveryChars));
    }
    
    @Override
    void encodeTo(final Appendable appendable, final byte[] array, final int n, final int n2) {
        this.delegate.encodeTo(BaseEncoding.separatingAppendable(appendable, this.separator, this.afterEveryChars), array, n, n2);
    }
    
    @Override
    int maxDecodedSize(final int n) {
        return this.delegate.maxDecodedSize(n);
    }
    
    @Override
    int decodeTo(final byte[] array, final CharSequence charSequence) {
        return this.delegate.decodeTo(array, this.separatorChars.removeFrom(charSequence));
    }
    
    @GwtIncompatible("Reader,InputStream")
    @Override
    public InputStream decodingStream(final Reader reader) {
        return this.delegate.decodingStream(BaseEncoding.ignoringReader(reader, this.separatorChars));
    }
    
    @Override
    public BaseEncoding omitPadding() {
        return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
    }
    
    @Override
    public BaseEncoding withPadChar(final char c) {
        return this.delegate.withPadChar(c).withSeparator(this.separator, this.afterEveryChars);
    }
    
    @Override
    public BaseEncoding withSeparator(final String s, final int n) {
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
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.delegate.toString());
        final String separator = this.separator;
        return new StringBuilder(31 + String.valueOf(value).length() + String.valueOf(separator).length()).append(value).append(".withSeparator(\"").append(separator).append("\", ").append(this.afterEveryChars).append(")").toString();
    }
}
