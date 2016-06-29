package com.google.common.hash;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.nio.charset.*;
import java.io.*;

@CheckReturnValue
@Beta
public final class Funnels
{
    public static Funnel byteArrayFunnel() {
        return Funnels$ByteArrayFunnel.INSTANCE;
    }
    
    public static Funnel unencodedCharsFunnel() {
        return Funnels$UnencodedCharsFunnel.INSTANCE;
    }
    
    public static Funnel stringFunnel(final Charset charset) {
        return new Funnels$StringCharsetFunnel(charset);
    }
    
    public static Funnel integerFunnel() {
        return Funnels$IntegerFunnel.INSTANCE;
    }
    
    public static Funnel sequentialFunnel(final Funnel funnel) {
        return new Funnels$SequentialFunnel(funnel);
    }
    
    public static Funnel longFunnel() {
        return Funnels$LongFunnel.INSTANCE;
    }
    
    public static OutputStream asOutputStream(final PrimitiveSink primitiveSink) {
        return new Funnels$SinkAsStream(primitiveSink);
    }
}
