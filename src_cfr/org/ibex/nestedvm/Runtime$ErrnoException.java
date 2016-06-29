/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

public class Runtime$ErrnoException
extends Exception {
    public int errno;

    public Runtime$ErrnoException(int n2) {
        super(new StringBuffer().append("Errno: ").append(n2).toString());
        this.errno = n2;
    }
}

