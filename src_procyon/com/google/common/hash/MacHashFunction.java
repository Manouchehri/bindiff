package com.google.common.hash;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.crypto.*;
import java.security.*;

@GoogleInternal
final class MacHashFunction extends AbstractStreamingHashFunction
{
    private final String algorithmName;
    private final Key key;
    private final String toString;
    private final int bits;
    
    MacHashFunction(final String s, final Key key, final String s2) {
        this.algorithmName = (String)Preconditions.checkNotNull(s);
        this.key = (Key)Preconditions.checkNotNull(key);
        this.toString = (String)Preconditions.checkNotNull(s2);
        this.bits = getMac(s, key).getMacLength() * 8;
    }
    
    @Override
    public int bits() {
        return this.bits;
    }
    
    private static Mac getMac(final String s, final Key key) {
        try {
            final Mac instance = Mac.getInstance(s);
            instance.init(key);
            return instance;
        }
        catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException(ex);
        }
        catch (InvalidKeyException ex2) {
            throw new IllegalArgumentException(ex2);
        }
    }
    
    @Override
    public Hasher newHasher() {
        return new MacHashFunction$MacHasher(getMac(this.algorithmName, this.key), null);
    }
    
    @Override
    public String toString() {
        return this.toString;
    }
}
