package com.google.common.collect;

import java.io.*;
import javax.annotation.*;
import java.lang.reflect.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class ArrayTable$Row extends ArrayTable$ArrayMap
{
    final int rowIndex;
    final /* synthetic */ ArrayTable this$0;
    
    ArrayTable$Row(final ArrayTable this$0, final int rowIndex) {
        this.this$0 = this$0;
        super(this$0.columnKeyToIndex, null);
        this.rowIndex = rowIndex;
    }
    
    @Override
    String getKeyRole() {
        return "Column";
    }
    
    @Override
    Object getValue(final int n) {
        return this.this$0.at(this.rowIndex, n);
    }
    
    @Override
    Object setValue(final int n, final Object o) {
        return this.this$0.set(this.rowIndex, n, o);
    }
}
