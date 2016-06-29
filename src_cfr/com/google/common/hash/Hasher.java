/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.PrimitiveSink;
import java.nio.charset.Charset;
import javax.annotation.CheckReturnValue;

@Beta
public interface Hasher
extends PrimitiveSink {
    @Override
    public Hasher putByte(byte var1);

    @Override
    public Hasher putBytes(byte[] var1);

    @Override
    public Hasher putBytes(byte[] var1, int var2, int var3);

    @Override
    public Hasher putShort(short var1);

    @Override
    public Hasher putInt(int var1);

    @Override
    public Hasher putLong(long var1);

    @Override
    public Hasher putFloat(float var1);

    @Override
    public Hasher putDouble(double var1);

    @Override
    public Hasher putBoolean(boolean var1);

    @Override
    public Hasher putChar(char var1);

    @Override
    public Hasher putUnencodedChars(CharSequence var1);

    @Deprecated
    @GoogleInternal
    @Override
    public Hasher putString(CharSequence var1);

    @Override
    public Hasher putString(CharSequence var1, Charset var2);

    public Hasher putObject(Object var1, Funnel var2);

    @CheckReturnValue
    public HashCode hash();
}

