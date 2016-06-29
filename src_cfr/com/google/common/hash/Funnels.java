/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels$ByteArrayFunnel;
import com.google.common.hash.Funnels$IntegerFunnel;
import com.google.common.hash.Funnels$LongFunnel;
import com.google.common.hash.Funnels$SequentialFunnel;
import com.google.common.hash.Funnels$SinkAsStream;
import com.google.common.hash.Funnels$StringCharsetFunnel;
import com.google.common.hash.Funnels$UnencodedCharsFunnel;
import com.google.common.hash.PrimitiveSink;
import java.io.OutputStream;
import java.nio.charset.Charset;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@Beta
public final class Funnels {
    private Funnels() {
    }

    public static Funnel byteArrayFunnel() {
        return Funnels$ByteArrayFunnel.INSTANCE;
    }

    public static Funnel unencodedCharsFunnel() {
        return Funnels$UnencodedCharsFunnel.INSTANCE;
    }

    public static Funnel stringFunnel(Charset charset) {
        return new Funnels$StringCharsetFunnel(charset);
    }

    public static Funnel integerFunnel() {
        return Funnels$IntegerFunnel.INSTANCE;
    }

    public static Funnel sequentialFunnel(Funnel funnel) {
        return new Funnels$SequentialFunnel(funnel);
    }

    public static Funnel longFunnel() {
        return Funnels$LongFunnel.INSTANCE;
    }

    public static OutputStream asOutputStream(PrimitiveSink primitiveSink) {
        return new Funnels$SinkAsStream(primitiveSink);
    }
}

