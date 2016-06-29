/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import java.math.BigInteger;

public interface IAddress
extends Comparable {
    public BigInteger toBigInteger();

    public String toHexString();

    public long toLong();
}

