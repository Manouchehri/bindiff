/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding$1;
import com.google.common.io.BaseEncoding$2;
import com.google.common.io.BaseEncoding$3;
import com.google.common.io.BaseEncoding$4;
import com.google.common.io.BaseEncoding$5;
import com.google.common.io.BaseEncoding$Base16Encoding;
import com.google.common.io.BaseEncoding$Base64Encoding;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible(emulated=1)
public abstract class BaseEncoding {
    private static final BaseEncoding BASE64 = new BaseEncoding$Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", Character.valueOf('='));
    private static final BaseEncoding BASE64_URL = new BaseEncoding$Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", Character.valueOf('='));
    private static final BaseEncoding BASE32 = new BaseEncoding$StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", Character.valueOf('='));
    private static final BaseEncoding BASE32_HEX = new BaseEncoding$StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", Character.valueOf('='));
    private static final BaseEncoding BASE16 = new BaseEncoding$Base16Encoding("base16()", "0123456789ABCDEF");

    BaseEncoding() {
    }

    public String encode(byte[] arrby) {
        return this.encode(arrby, 0, arrby.length);
    }

    public final String encode(byte[] arrby, int n2, int n3) {
        Preconditions.checkPositionIndexes(n2, n2 + n3, arrby.length);
        StringBuilder stringBuilder = new StringBuilder(this.maxEncodedSize(n3));
        try {
            this.encodeTo(stringBuilder, arrby, n2, n3);
            return stringBuilder.toString();
        }
        catch (IOException var5_5) {
            throw new AssertionError(var5_5);
        }
    }

    @GwtIncompatible(value="Writer,OutputStream")
    public abstract OutputStream encodingStream(Writer var1);

    @GwtIncompatible(value="ByteSink,CharSink")
    public final ByteSink encodingSink(CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new BaseEncoding$1(this, charSink);
    }

    private static byte[] extract(byte[] arrby, int n2) {
        if (n2 == arrby.length) {
            return arrby;
        }
        byte[] arrby2 = new byte[n2];
        System.arraycopy(arrby, 0, arrby2, 0, n2);
        return arrby2;
    }

    public final byte[] decode(CharSequence charSequence) {
        try {
            return this.decodeChecked(charSequence);
        }
        catch (BaseEncoding$DecodingException var2_2) {
            throw new IllegalArgumentException(var2_2);
        }
    }

    public final byte[] decodeChecked(CharSequence charSequence) {
        charSequence = this.padding().trimTrailingFrom(charSequence);
        byte[] arrby = new byte[this.maxDecodedSize(charSequence.length())];
        int n2 = this.decodeTo(arrby, charSequence);
        return BaseEncoding.extract(arrby, n2);
    }

    @GwtIncompatible(value="Reader,InputStream")
    public abstract InputStream decodingStream(Reader var1);

    @GwtIncompatible(value="ByteSource,CharSource")
    public final ByteSource decodingSource(CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new BaseEncoding$2(this, charSource);
    }

    abstract int maxEncodedSize(int var1);

    abstract void encodeTo(Appendable var1, byte[] var2, int var3, int var4);

    abstract int maxDecodedSize(int var1);

    abstract int decodeTo(byte[] var1, CharSequence var2);

    abstract CharMatcher padding();

    @CheckReturnValue
    public abstract BaseEncoding omitPadding();

    @CheckReturnValue
    public abstract BaseEncoding withPadChar(char var1);

    @CheckReturnValue
    public abstract BaseEncoding withSeparator(String var1, int var2);

    @CheckReturnValue
    public abstract BaseEncoding upperCase();

    @CheckReturnValue
    public abstract BaseEncoding lowerCase();

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    @GwtIncompatible(value="Reader")
    static Reader ignoringReader(Reader reader, CharMatcher charMatcher) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(charMatcher);
        return new BaseEncoding$3(reader, charMatcher);
    }

    static Appendable separatingAppendable(Appendable appendable, String string, int n2) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(string);
        Preconditions.checkArgument(n2 > 0);
        return new BaseEncoding$4(n2, appendable, string);
    }

    @GwtIncompatible(value="Writer")
    static Writer separatingWriter(Writer writer, String string, int n2) {
        Appendable appendable = BaseEncoding.separatingAppendable(writer, string, n2);
        return new BaseEncoding$5(appendable, writer);
    }
}

