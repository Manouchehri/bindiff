package com.google.common.base;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;
import java.security.*;

@CheckReturnValue
@GoogleInternal
public final class Randoms
{
    private static final Random RANDOM;
    private static final SecureRandom SECURE_RANDOM;
    
    public static SecureRandom secureRandom() {
        return Randoms.SECURE_RANDOM;
    }
    
    public static SecureRandom secureRandom(final byte[] array) {
        final SecureRandom secureRandom = new SecureRandom(array);
        secureRandom.nextLong();
        return secureRandom;
    }
    
    public static Random insecureRandom() {
        return Randoms.RANDOM;
    }
    
    public static Random insecureRandom(final long n) {
        return new Random(n);
    }
    
    private static SecureRandom newDefaultSecureRandom() {
        final SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }
    
    static {
        RANDOM = new Randoms$ReadOnlyRandom(null);
        SECURE_RANDOM = newDefaultSecureRandom();
    }
}
