package com.google.common.collect;

final class ImmutableMultiset$EntrySet extends ImmutableSet$Indexed
{
    private static final long serialVersionUID = 0L;
    final /* synthetic */ ImmutableMultiset this$0;
    
    private ImmutableMultiset$EntrySet(final ImmutableMultiset this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    boolean isPartialView() {
        return this.this$0.isPartialView();
    }
    
    @Override
    Multiset$Entry get(final int n) {
        return this.this$0.getEntry(n);
    }
    
    @Override
    public int size() {
        return this.this$0.elementSet().size();
    }
    
    @Override
    public boolean contains(final Object o) {
        if (o instanceof Multiset$Entry) {
            final Multiset$Entry multiset$Entry = (Multiset$Entry)o;
            return multiset$Entry.getCount() > 0 && this.this$0.count(multiset$Entry.getElement()) == multiset$Entry.getCount();
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.this$0.hashCode();
    }
    
    @Override
    Object writeReplace() {
        return new ImmutableMultiset$EntrySetSerializedForm(this.this$0);
    }
}
