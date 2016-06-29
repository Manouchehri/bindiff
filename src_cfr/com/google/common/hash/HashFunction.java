/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.charset.Charset;

@Beta
public interface HashFunction {
    public Hasher newHasher();

    public Hasher newHasher(int var1);

    public HashCode hashInt(int var1);

    public HashCode hashLong(long var1);

    public HashCode hashBytes(byte[] var1);

    public HashCode hashBytes(byte[] var1, int var2, int var3);

    public HashCode hashUnencodedChars(CharSequence var1);

    @Deprecated
    @GoogleInternal
    public HashCode hashString(CharSequence var1);

    public HashCode hashString(CharSequence var1, Charset var2);

    public HashCode hashObject(Object var1, Funnel var2);

    public int bits();
}

