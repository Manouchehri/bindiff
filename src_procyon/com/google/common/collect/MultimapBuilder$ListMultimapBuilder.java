package com.google.common.collect;

public abstract class MultimapBuilder$ListMultimapBuilder extends MultimapBuilder
{
    MultimapBuilder$ListMultimapBuilder() {
        super(null);
    }
    
    @Override
    public abstract ListMultimap build();
    
    @Override
    public ListMultimap build(final Multimap multimap) {
        return (ListMultimap)super.build(multimap);
    }
}
