package com.google.common.collect;

import com.google.common.base.*;
import java.io.*;
import java.util.*;

class HashBasedTable$Factory implements Supplier, Serializable
{
    final int expectedSize;
    private static final long serialVersionUID = 0L;
    
    HashBasedTable$Factory(final int expectedSize) {
        this.expectedSize = expectedSize;
    }
    
    @Override
    public Map get() {
        return Maps.newHashMapWithExpectedSize(this.expectedSize);
    }
}
