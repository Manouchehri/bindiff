/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.MacHashFunction$1;
import com.google.common.hash.MacHashFunction$MacHasher;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

@GoogleInternal
final class MacHashFunction
extends AbstractStreamingHashFunction {
    private final String algorithmName;
    private final Key key;
    private final String toString;
    private final int bits;

    MacHashFunction(String string, Key key, String string2) {
        this.algorithmName = (String)Preconditions.checkNotNull(string);
        this.key = (Key)Preconditions.checkNotNull(key);
        this.toString = (String)Preconditions.checkNotNull(string2);
        this.bits = MacHashFunction.getMac(string, key).getMacLength() * 8;
    }

    @Override
    public int bits() {
        return this.bits;
    }

    private static Mac getMac(String string, Key key) {
        try {
            Mac mac = Mac.getInstance(string);
            mac.init(key);
            return mac;
        }
        catch (NoSuchAlgorithmException var2_3) {
            throw new IllegalStateException(var2_3);
        }
        catch (InvalidKeyException var2_4) {
            throw new IllegalArgumentException(var2_4);
        }
    }

    @Override
    public Hasher newHasher() {
        return new MacHashFunction$MacHasher(MacHashFunction.getMac(this.algorithmName, this.key), null);
    }

    public String toString() {
        return this.toString;
    }
}

