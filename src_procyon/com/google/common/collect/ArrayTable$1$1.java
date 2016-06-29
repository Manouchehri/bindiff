package com.google.common.collect;

import java.io.*;
import javax.annotation.*;
import java.lang.reflect.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class ArrayTable$1$1 extends Tables$AbstractCell
{
    final int rowIndex;
    final int columnIndex;
    final /* synthetic */ int val$index;
    final /* synthetic */ ArrayTable$1 this$1;
    
    ArrayTable$1$1(final ArrayTable$1 this$1, final int val$index) {
        this.this$1 = this$1;
        this.val$index = val$index;
        this.rowIndex = this.val$index / this.this$1.this$0.columnList.size();
        this.columnIndex = this.val$index % this.this$1.this$0.columnList.size();
    }
    
    @Override
    public Object getRowKey() {
        return this.this$1.this$0.rowList.get(this.rowIndex);
    }
    
    @Override
    public Object getColumnKey() {
        return this.this$1.this$0.columnList.get(this.columnIndex);
    }
    
    @Override
    public Object getValue() {
        return this.this$1.this$0.at(this.rowIndex, this.columnIndex);
    }
}
