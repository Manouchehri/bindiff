package com.google.common.collect;

final class RegularImmutableMultiset$NonTerminalEntry extends Multisets$ImmutableEntry
{
    private final Multisets$ImmutableEntry nextInBucket;
    
    RegularImmutableMultiset$NonTerminalEntry(final Object o, final int n, final Multisets$ImmutableEntry nextInBucket) {
        super(o, n);
        this.nextInBucket = nextInBucket;
    }
    
    @Override
    public Multisets$ImmutableEntry nextInBucket() {
        return this.nextInBucket;
    }
}
