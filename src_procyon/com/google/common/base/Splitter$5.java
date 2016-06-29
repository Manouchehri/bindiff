package com.google.common.base;

import javax.annotation.*;
import java.util.regex.*;
import java.util.*;
import com.google.common.annotations.*;

class Splitter$5 implements Iterable
{
    final /* synthetic */ CharSequence val$sequence;
    final /* synthetic */ Splitter this$0;
    
    Splitter$5(final Splitter this$0, final CharSequence val$sequence) {
        this.this$0 = this$0;
        this.val$sequence = val$sequence;
    }
    
    @Override
    public Iterator iterator() {
        return this.this$0.splittingIterator(this.val$sequence);
    }
    
    @Override
    public String toString() {
        return Joiner.on(", ").appendTo(new StringBuilder().append('['), this).append(']').toString();
    }
}
