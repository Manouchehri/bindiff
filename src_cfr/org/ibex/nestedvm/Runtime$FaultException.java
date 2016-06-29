/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$ExecutionException;

public class Runtime$FaultException
extends Runtime$ExecutionException {
    public final int addr;
    public final RuntimeException cause;

    public Runtime$FaultException(int n2) {
        super(new StringBuffer().append("fault at: ").append(Runtime.toHex(n2)).toString());
        this.addr = n2;
        this.cause = null;
    }

    public Runtime$FaultException(RuntimeException runtimeException) {
        super(runtimeException.toString());
        this.addr = -1;
        this.cause = runtimeException;
    }
}

