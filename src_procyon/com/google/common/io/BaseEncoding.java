package com.google.common.io;

import com.google.common.annotations.*;
import java.io.*;
import com.google.common.base.*;
import javax.annotation.*;

@Beta
@GwtCompatible(emulated = true)
public abstract class BaseEncoding
{
    private static final BaseEncoding BASE64;
    private static final BaseEncoding BASE64_URL;
    private static final BaseEncoding BASE32;
    private static final BaseEncoding BASE32_HEX;
    private static final BaseEncoding BASE16;
    
    public String encode(final byte[] array) {
        return this.encode(array, 0, array.length);
    }
    
    public final String encode(final byte[] array, final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n + n2, array.length);
        final StringBuilder sb = new StringBuilder(this.maxEncodedSize(n2));
        try {
            this.encodeTo(sb, array, n, n2);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
        return sb.toString();
    }
    
    @GwtIncompatible("Writer,OutputStream")
    public abstract OutputStream encodingStream(final Writer p0);
    
    @GwtIncompatible("ByteSink,CharSink")
    public final ByteSink encodingSink(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new BaseEncoding$1(this, charSink);
    }
    
    private static byte[] extract(final byte[] array, final int n) {
        if (n == array.length) {
            return array;
        }
        final byte[] array2 = new byte[n];
        System.arraycopy(array, 0, array2, 0, n);
        return array2;
    }
    
    public final byte[] decode(final CharSequence charSequence) {
        try {
            return this.decodeChecked(charSequence);
        }
        catch (BaseEncoding$DecodingException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
    
    public final byte[] decodeChecked(final CharSequence charSequence) {
        final String trimTrailing = this.padding().trimTrailingFrom(charSequence);
        final byte[] array = new byte[this.maxDecodedSize(trimTrailing.length())];
        return extract(array, this.decodeTo(array, trimTrailing));
    }
    
    @GwtIncompatible("Reader,InputStream")
    public abstract InputStream decodingStream(final Reader p0);
    
    @GwtIncompatible("ByteSource,CharSource")
    public final ByteSource decodingSource(final CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new BaseEncoding$2(this, charSource);
    }
    
    abstract int maxEncodedSize(final int p0);
    
    abstract void encodeTo(final Appendable p0, final byte[] p1, final int p2, final int p3);
    
    abstract int maxDecodedSize(final int p0);
    
    abstract int decodeTo(final byte[] p0, final CharSequence p1);
    
    abstract CharMatcher padding();
    
    @CheckReturnValue
    public abstract BaseEncoding omitPadding();
    
    @CheckReturnValue
    public abstract BaseEncoding withPadChar(final char p0);
    
    @CheckReturnValue
    public abstract BaseEncoding withSeparator(final String p0, final int p1);
    
    @CheckReturnValue
    public abstract BaseEncoding upperCase();
    
    @CheckReturnValue
    public abstract BaseEncoding lowerCase();
    
    public static BaseEncoding base64() {
        return BaseEncoding.BASE64;
    }
    
    public static BaseEncoding base64Url() {
        return BaseEncoding.BASE64_URL;
    }
    
    public static BaseEncoding base32() {
        return BaseEncoding.BASE32;
    }
    
    public static BaseEncoding base32Hex() {
        return BaseEncoding.BASE32_HEX;
    }
    
    public static BaseEncoding base16() {
        return BaseEncoding.BASE16;
    }
    
    @GwtIncompatible("Reader")
    static Reader ignoringReader(final Reader reader, final CharMatcher charMatcher) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(charMatcher);
        return new BaseEncoding$3(reader, charMatcher);
    }
    
    static Appendable separatingAppendable(final Appendable appendable, final String s, final int n) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(s);
        Preconditions.checkArgument(n > 0);
        return new BaseEncoding$4(n, appendable, s);
    }
    
    @GwtIncompatible("Writer")
    static Writer separatingWriter(final Writer writer, final String s, final int n) {
        return new BaseEncoding$5(separatingAppendable(writer, s, n), writer);
    }
    
    static {
        BASE64 = new BaseEncoding$Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
        BASE64_URL = new BaseEncoding$Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        BASE32 = new BaseEncoding$StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        BASE32_HEX = new BaseEncoding$StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        BASE16 = new BaseEncoding$Base16Encoding("base16()", "0123456789ABCDEF");
    }
}
