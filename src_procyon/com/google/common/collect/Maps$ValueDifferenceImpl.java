package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;

class Maps$ValueDifferenceImpl implements MapDifference$ValueDifference
{
    private final Object left;
    private final Object right;
    
    static MapDifference$ValueDifference create(@Nullable final Object o, @Nullable final Object o2) {
        return new Maps$ValueDifferenceImpl(o, o2);
    }
    
    private Maps$ValueDifferenceImpl(@Nullable final Object left, @Nullable final Object right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public Object leftValue() {
        return this.left;
    }
    
    @Override
    public Object rightValue() {
        return this.right;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof MapDifference$ValueDifference) {
            final MapDifference$ValueDifference mapDifference$ValueDifference = (MapDifference$ValueDifference)o;
            return Objects.equal(this.left, mapDifference$ValueDifference.leftValue()) && Objects.equal(this.right, mapDifference$ValueDifference.rightValue());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.left, this.right);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.left);
        final String value2 = String.valueOf(this.right);
        return new StringBuilder(4 + String.valueOf(value).length() + String.valueOf(value2).length()).append("(").append(value).append(", ").append(value2).append(")").toString();
    }
}
