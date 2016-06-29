package com.google.common.collect;

class ImmutableBiMap$SerializedForm extends ImmutableMap$SerializedForm
{
    private static final long serialVersionUID = 0L;
    
    ImmutableBiMap$SerializedForm(final ImmutableBiMap immutableBiMap) {
        super(immutableBiMap);
    }
    
    @Override
    Object readResolve() {
        return this.createMap(new ImmutableBiMap$Builder());
    }
}
