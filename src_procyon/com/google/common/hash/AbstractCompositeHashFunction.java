package com.google.common.hash;

import com.google.common.base.*;

abstract class AbstractCompositeHashFunction extends AbstractStreamingHashFunction
{
    final HashFunction[] functions;
    private static final long serialVersionUID = 0L;
    
    AbstractCompositeHashFunction(final HashFunction... functions) {
        for (int length = functions.length, i = 0; i < length; ++i) {
            Preconditions.checkNotNull(functions[i]);
        }
        this.functions = functions;
    }
    
    abstract HashCode makeHash(final Hasher[] p0);
    
    @Override
    public Hasher newHasher() {
        final Hasher[] array = new Hasher[this.functions.length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = this.functions[i].newHasher();
        }
        return new AbstractCompositeHashFunction$1(this, array);
    }
}
