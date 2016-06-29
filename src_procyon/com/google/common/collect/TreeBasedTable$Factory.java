package com.google.common.collect;

import com.google.common.base.*;
import java.io.*;
import java.util.*;

class TreeBasedTable$Factory implements Supplier, Serializable
{
    final Comparator comparator;
    private static final long serialVersionUID = 0L;
    
    TreeBasedTable$Factory(final Comparator comparator) {
        this.comparator = comparator;
    }
    
    @Override
    public TreeMap get() {
        return new TreeMap(this.comparator);
    }
}
