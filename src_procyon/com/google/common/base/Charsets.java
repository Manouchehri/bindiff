package com.google.common.base;

import java.nio.charset.*;
import com.google.common.annotations.*;

@GwtCompatible(emulated = true)
public final class Charsets
{
    @Deprecated
    @GwtIncompatible("Non-UTF-8 Charset")
    public static final Charset US_ASCII;
    @Deprecated
    @GwtIncompatible("Non-UTF-8 Charset")
    public static final Charset ISO_8859_1;
    @Deprecated
    public static final Charset UTF_8;
    @Deprecated
    @GwtIncompatible("Non-UTF-8 Charset")
    public static final Charset UTF_16BE;
    @Deprecated
    @GwtIncompatible("Non-UTF-8 Charset")
    public static final Charset UTF_16LE;
    @Deprecated
    @GwtIncompatible("Non-UTF-8 Charset")
    public static final Charset UTF_16;
    
    @Deprecated
    @GoogleInternal
    @GwtIncompatible("Non-UTF-8 Charset")
    public static Charset unsafeDefaultCharset() {
        return Charset.defaultCharset();
    }
    
    static {
        US_ASCII = Charset.forName("US-ASCII");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        UTF_8 = Charset.forName("UTF-8");
        UTF_16BE = Charset.forName("UTF-16BE");
        UTF_16LE = Charset.forName("UTF-16LE");
        UTF_16 = Charset.forName("UTF-16");
    }
}
