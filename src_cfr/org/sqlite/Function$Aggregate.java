/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import org.sqlite.Function;

public abstract class Function$Aggregate
extends Function
implements Cloneable {
    @Override
    protected final void xFunc() {
    }

    protected abstract void xStep();

    protected abstract void xFinal();

    public Object clone() {
        return super.clone();
    }
}

