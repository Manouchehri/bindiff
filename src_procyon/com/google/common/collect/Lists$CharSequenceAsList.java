package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

final class Lists$CharSequenceAsList extends AbstractList
{
    private final CharSequence sequence;
    
    Lists$CharSequenceAsList(final CharSequence sequence) {
        this.sequence = sequence;
    }
    
    @Override
    public Character get(final int n) {
        Preconditions.checkElementIndex(n, this.size());
        return this.sequence.charAt(n);
    }
    
    @Override
    public int size() {
        return this.sequence.length();
    }
}
