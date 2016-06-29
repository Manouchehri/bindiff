/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Interner;

class Interners$InternerFunction
implements Function {
    private final Interner interner;

    public Interners$InternerFunction(Interner interner) {
        this.interner = interner;
    }

    @Override
    public Object apply(Object object) {
        return this.interner.intern(object);
    }

    public int hashCode() {
        return this.interner.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Interners$InternerFunction)) return false;
        Interners$InternerFunction interners$InternerFunction = (Interners$InternerFunction)object;
        return this.interner.equals(interners$InternerFunction.interner);
    }
}

