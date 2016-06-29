package com.google.common.collect;

import com.google.common.base.*;

class Interners$InternerFunction implements Function
{
    private final Interner interner;
    
    public Interners$InternerFunction(final Interner interner) {
        this.interner = interner;
    }
    
    @Override
    public Object apply(final Object o) {
        return this.interner.intern(o);
    }
    
    @Override
    public int hashCode() {
        return this.interner.hashCode();
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof Interners$InternerFunction && this.interner.equals(((Interners$InternerFunction)o).interner);
    }
}
