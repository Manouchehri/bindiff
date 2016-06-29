package com.google.common.collect;

import com.google.common.math.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.annotations.*;

final class Collections2$PermutationCollection extends AbstractCollection
{
    final ImmutableList inputList;
    
    Collections2$PermutationCollection(final ImmutableList inputList) {
        this.inputList = inputList;
    }
    
    @Override
    public int size() {
        return IntMath.factorial(this.inputList.size());
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    public Iterator iterator() {
        return new Collections2$PermutationIterator(this.inputList);
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return o instanceof List && isPermutation(this.inputList, (List)o);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.inputList);
        return new StringBuilder(14 + String.valueOf(value).length()).append("permutations(").append(value).append(")").toString();
    }
}
