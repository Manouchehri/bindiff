package com.google.common.collect;

import com.google.common.base.*;
import java.io.*;
import java.util.*;

final class MultimapBuilder$ArrayListSupplier implements Supplier, Serializable
{
    private final int expectedValuesPerKey;
    
    MultimapBuilder$ArrayListSupplier(final int n) {
        this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(n, "expectedValuesPerKey");
    }
    
    @Override
    public List get() {
        return new ArrayList(this.expectedValuesPerKey);
    }
}
