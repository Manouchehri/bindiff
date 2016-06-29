package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

final class Lists$StringAsImmutableList extends ImmutableList
{
    private final String string;
    
    Lists$StringAsImmutableList(final String string) {
        this.string = string;
    }
    
    @Override
    public int indexOf(@Nullable final Object o) {
        return (o instanceof Character) ? this.string.indexOf((char)o) : -1;
    }
    
    @Override
    public int lastIndexOf(@Nullable final Object o) {
        return (o instanceof Character) ? this.string.lastIndexOf((char)o) : -1;
    }
    
    @Override
    public ImmutableList subList(final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n2, this.size());
        return Lists.charactersOf(this.string.substring(n, n2));
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public Character get(final int n) {
        Preconditions.checkElementIndex(n, this.size());
        return this.string.charAt(n);
    }
    
    @Override
    public int size() {
        return this.string.length();
    }
}
