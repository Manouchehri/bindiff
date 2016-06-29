/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.MutabilityOracle$1;

interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = new MutabilityOracle$1();

    public void ensureMutable();
}

