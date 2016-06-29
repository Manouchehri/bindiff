package com.google.common.io;

import com.google.common.annotations.*;
import java.io.*;
import java.nio.*;
import java.util.*;
import com.google.common.base.*;

class LineReader$1 extends LineBuffer
{
    final /* synthetic */ LineReader this$0;
    
    LineReader$1(final LineReader this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    protected void handleLine(final String s, final String s2) {
        this.this$0.lines.add(s);
    }
}
