package com.google.common.collect;

import java.io.*;
import javax.annotation.*;
import java.lang.reflect.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class ArrayTable$RowMap extends ArrayTable$ArrayMap
{
    final /* synthetic */ ArrayTable this$0;
    
    private ArrayTable$RowMap(final ArrayTable this$0) {
        this.this$0 = this$0;
        super(this$0.rowKeyToIndex, null);
    }
    
    @Override
    String getKeyRole() {
        return "Row";
    }
    
    @Override
    Map getValue(final int n) {
        return new ArrayTable$Row(this.this$0, n);
    }
    
    Map setValue(final int n, final Map map) {
        throw new UnsupportedOperationException();
    }
    
    public Map put(final Object o, final Map map) {
        throw new UnsupportedOperationException();
    }
}
