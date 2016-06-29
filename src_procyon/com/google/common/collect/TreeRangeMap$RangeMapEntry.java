package com.google.common.collect;

final class TreeRangeMap$RangeMapEntry extends AbstractMapEntry
{
    private final Range range;
    private final Object value;
    
    TreeRangeMap$RangeMapEntry(final Cut cut, final Cut cut2, final Object o) {
        this(Range.create(cut, cut2), o);
    }
    
    TreeRangeMap$RangeMapEntry(final Range range, final Object value) {
        this.range = range;
        this.value = value;
    }
    
    @Override
    public Range getKey() {
        return this.range;
    }
    
    @Override
    public Object getValue() {
        return this.value;
    }
    
    public boolean contains(final Comparable comparable) {
        return this.range.contains(comparable);
    }
    
    Cut getLowerBound() {
        return this.range.lowerBound;
    }
    
    Cut getUpperBound() {
        return this.range.upperBound;
    }
}
