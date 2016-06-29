/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Randoms$1;
import com.google.common.base.Randoms$ReadOnlyRandom;
import java.security.SecureRandom;
import java.util.Random;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GoogleInternal
public final class Randoms {
    private static final Random RANDOM = new Randoms$ReadOnlyRandom(null);
    private static final SecureRandom SECURE_RANDOM = Randoms.newDefaultSecureRandom();

    private Randoms() {
    }

    public static SecureRandom secureRandom() {
        return SECURE_RANDOM;
    }

    public static SecureRandom secureRandom(byte[] arrby) {
        SecureRandom secureRandom = new SecureRandom(arrby);
        secureRandom.nextLong();
        return secureRandom;
    }

    public static Random insecureRandom() {
        return RANDOM;
    }

    public static Random insecureRandom(long l2) {
        return new Random(l2);
    }

    private static SecureRandom newDefaultSecureRandom() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }
}

