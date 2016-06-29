package com.google.common.collect;

import java.util.*;

class Maps$SortedMapDifferenceImpl extends Maps$MapDifferenceImpl implements SortedMapDifference
{
    Maps$SortedMapDifferenceImpl(final SortedMap sortedMap, final SortedMap sortedMap2, final SortedMap sortedMap3, final SortedMap sortedMap4) {
        super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
    }
    
    @Override
    public SortedMap entriesDiffering() {
        return (SortedMap)super.entriesDiffering();
    }
    
    @Override
    public SortedMap entriesInCommon() {
        return (SortedMap)super.entriesInCommon();
    }
    
    @Override
    public SortedMap entriesOnlyOnLeft() {
        return (SortedMap)super.entriesOnlyOnLeft();
    }
    
    @Override
    public SortedMap entriesOnlyOnRight() {
        return (SortedMap)super.entriesOnlyOnRight();
    }
}
