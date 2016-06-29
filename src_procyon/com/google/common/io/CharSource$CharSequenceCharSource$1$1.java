package com.google.common.io;

import java.util.*;
import java.io.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.regex.*;

class CharSource$CharSequenceCharSource$1$1 extends AbstractIterator
{
    Iterator lines;
    final /* synthetic */ CharSource$CharSequenceCharSource$1 this$1;
    
    CharSource$CharSequenceCharSource$1$1(final CharSource$CharSequenceCharSource$1 this$1) {
        this.this$1 = this$1;
        this.lines = CharSource$CharSequenceCharSource.LINE_SPLITTER.split(this.this$1.this$0.seq).iterator();
    }
    
    @Override
    protected String computeNext() {
        if (this.lines.hasNext()) {
            final String s = this.lines.next();
            if (this.lines.hasNext() || !s.isEmpty()) {
                return s;
            }
        }
        return (String)this.endOfData();
    }
}
