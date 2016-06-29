package com.google.common.cache;

final class LocalCache$WeightedStrongValueReference extends LocalCache$StrongValueReference
{
    final int weight;
    
    LocalCache$WeightedStrongValueReference(final Object o, final int weight) {
        super(o);
        this.weight = weight;
    }
    
    @Override
    public int getWeight() {
        return this.weight;
    }
}
