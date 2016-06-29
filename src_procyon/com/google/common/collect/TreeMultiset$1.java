package com.google.common.collect;

class TreeMultiset$1 extends Multisets$AbstractEntry
{
    final /* synthetic */ TreeMultiset$AvlNode val$baseEntry;
    final /* synthetic */ TreeMultiset this$0;
    
    TreeMultiset$1(final TreeMultiset this$0, final TreeMultiset$AvlNode val$baseEntry) {
        this.this$0 = this$0;
        this.val$baseEntry = val$baseEntry;
    }
    
    @Override
    public Object getElement() {
        return this.val$baseEntry.getElement();
    }
    
    @Override
    public int getCount() {
        final int count = this.val$baseEntry.getCount();
        if (count == 0) {
            return this.this$0.count(this.getElement());
        }
        return count;
    }
}
