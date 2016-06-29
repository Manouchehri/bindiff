package com.google.common.cache;

import com.google.common.base.*;

final class LongAddables$1 implements Supplier
{
    @Override
    public LongAddable get() {
        return new LongAdder();
    }
}
