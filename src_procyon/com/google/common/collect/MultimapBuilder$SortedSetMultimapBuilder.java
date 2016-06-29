package com.google.common.collect;

public abstract class MultimapBuilder$SortedSetMultimapBuilder extends MultimapBuilder$SetMultimapBuilder
{
    @Override
    public abstract SortedSetMultimap build();
    
    @Override
    public SortedSetMultimap build(final Multimap multimap) {
        return (SortedSetMultimap)super.build(multimap);
    }
}
