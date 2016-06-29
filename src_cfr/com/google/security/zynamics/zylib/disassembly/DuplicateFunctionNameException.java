/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

@Deprecated
public class DuplicateFunctionNameException
extends Exception {
    private static final long serialVersionUID = 8935154529155710030L;
    private final StackTraceElement[] m_originalStacktrace = new Throwable().getStackTrace();

    public DuplicateFunctionNameException(String string) {
        super(string);
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return this.m_originalStacktrace;
    }
}

