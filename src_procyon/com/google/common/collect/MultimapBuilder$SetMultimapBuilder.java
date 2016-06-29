package com.google.common.collect;

public abstract class MultimapBuilder$SetMultimapBuilder extends MultimapBuilder
{
    MultimapBuilder$SetMultimapBuilder() {
        super(null);
    }
    
    @Override
    public abstract SetMultimap build();
    
    @Override
    public SetMultimap build(final Multimap multimap) {
        return (SetMultimap)super.build(multimap);
    }
}
