package com.google.common.collect;

import java.io.*;
import javax.annotation.*;
import java.lang.reflect.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class ArrayTable$Column extends ArrayTable$ArrayMap
{
    final int columnIndex;
    final /* synthetic */ ArrayTable this$0;
    
    ArrayTable$Column(final ArrayTable this$0, final int columnIndex) {
        this.this$0 = this$0;
        super(this$0.rowKeyToIndex, null);
        this.columnIndex = columnIndex;
    }
    
    @Override
    String getKeyRole() {
        return "Row";
    }
    
    @Override
    Object getValue(final int n) {
        return this.this$0.at(n, this.columnIndex);
    }
    
    @Override
    Object setValue(final int n, final Object o) {
        return this.this$0.set(n, this.columnIndex, o);
    }
}
