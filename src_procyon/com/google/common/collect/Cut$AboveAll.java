package com.google.common.collect;

final class Cut$AboveAll extends Cut
{
    private static final Cut$AboveAll INSTANCE;
    private static final long serialVersionUID = 0L;
    
    private Cut$AboveAll() {
        super(null);
    }
    
    @Override
    Comparable endpoint() {
        throw new IllegalStateException("range unbounded on this side");
    }
    
    @Override
    boolean isLessThan(final Comparable comparable) {
        return false;
    }
    
    @Override
    BoundType typeAsLowerBound() {
        throw new AssertionError((Object)"this statement should be unreachable");
    }
    
    @Override
    BoundType typeAsUpperBound() {
        throw new IllegalStateException();
    }
    
    @Override
    Cut withLowerBoundType(final BoundType boundType, final DiscreteDomain discreteDomain) {
        throw new AssertionError((Object)"this statement should be unreachable");
    }
    
    @Override
    Cut withUpperBoundType(final BoundType boundType, final DiscreteDomain discreteDomain) {
        throw new IllegalStateException();
    }
    
    @Override
    void describeAsLowerBound(final StringBuilder sb) {
        throw new AssertionError();
    }
    
    @Override
    void describeAsUpperBound(final StringBuilder sb) {
        sb.append("+\u221e)");
    }
    
    @Override
    Comparable leastValueAbove(final DiscreteDomain discreteDomain) {
        throw new AssertionError();
    }
    
    @Override
    Comparable greatestValueBelow(final DiscreteDomain discreteDomain) {
        return discreteDomain.maxValue();
    }
    
    @Override
    public int compareTo(final Cut cut) {
        return (cut != this) ? 1 : 0;
    }
    
    @Override
    public String toString() {
        return "+\u221e";
    }
    
    private Object readResolve() {
        return Cut$AboveAll.INSTANCE;
    }
    
    static {
        INSTANCE = new Cut$AboveAll();
    }
}
