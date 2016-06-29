package com.google.common.collect;

import com.google.common.base.*;
import java.io.*;
import java.util.*;

final class MultimapBuilder$HashSetSupplier implements Supplier, Serializable
{
    private final int expectedValuesPerKey;
    
    MultimapBuilder$HashSetSupplier(final int n) {
        this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(n, "expectedValuesPerKey");
    }
    
    @Override
    public Set get() {
        return Sets.newHashSetWithExpectedSize(this.expectedValuesPerKey);
    }
}
