package com.google.common.cache;

final class LocalCache$KeyIterator extends LocalCache$HashIterator
{
    final /* synthetic */ LocalCache this$0;
    
    LocalCache$KeyIterator(final LocalCache this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public Object next() {
        return this.nextEntry().getKey();
    }
}
