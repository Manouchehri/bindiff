package com.google.common.collect;

import java.util.concurrent.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

class Maps$MapDifferenceImpl implements MapDifference
{
    final Map onlyOnLeft;
    final Map onlyOnRight;
    final Map onBoth;
    final Map differences;
    
    Maps$MapDifferenceImpl(final Map map, final Map map2, final Map map3, final Map map4) {
        this.onlyOnLeft = unmodifiableMap(map);
        this.onlyOnRight = unmodifiableMap(map2);
        this.onBoth = unmodifiableMap(map3);
        this.differences = unmodifiableMap(map4);
    }
    
    @Override
    public boolean areEqual() {
        return this.onlyOnLeft.isEmpty() && this.onlyOnRight.isEmpty() && this.differences.isEmpty();
    }
    
    @Override
    public Map entriesOnlyOnLeft() {
        return this.onlyOnLeft;
    }
    
    @Override
    public Map entriesOnlyOnRight() {
        return this.onlyOnRight;
    }
    
    @Override
    public Map entriesInCommon() {
        return this.onBoth;
    }
    
    @Override
    public Map entriesDiffering() {
        return this.differences;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof MapDifference) {
            final MapDifference mapDifference = (MapDifference)o;
            return this.entriesOnlyOnLeft().equals(mapDifference.entriesOnlyOnLeft()) && this.entriesOnlyOnRight().equals(mapDifference.entriesOnlyOnRight()) && this.entriesInCommon().equals(mapDifference.entriesInCommon()) && this.entriesDiffering().equals(mapDifference.entriesDiffering());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.entriesOnlyOnLeft(), this.entriesOnlyOnRight(), this.entriesInCommon(), this.entriesDiffering());
    }
    
    @Override
    public String toString() {
        if (this.areEqual()) {
            return "equal";
        }
        final StringBuilder sb = new StringBuilder("not equal");
        if (!this.onlyOnLeft.isEmpty()) {
            sb.append(": only on left=").append(this.onlyOnLeft);
        }
        if (!this.onlyOnRight.isEmpty()) {
            sb.append(": only on right=").append(this.onlyOnRight);
        }
        if (!this.differences.isEmpty()) {
            sb.append(": value differences=").append(this.differences);
        }
        return sb.toString();
    }
}
