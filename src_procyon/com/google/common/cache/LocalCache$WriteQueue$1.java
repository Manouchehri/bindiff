package com.google.common.cache;

class LocalCache$WriteQueue$1 extends LocalCache$AbstractReferenceEntry
{
    LocalCache$ReferenceEntry nextWrite;
    LocalCache$ReferenceEntry previousWrite;
    final /* synthetic */ LocalCache$WriteQueue this$0;
    
    LocalCache$WriteQueue$1(final LocalCache$WriteQueue this$0) {
        this.this$0 = this$0;
        this.nextWrite = this;
        this.previousWrite = this;
    }
    
    @Override
    public long getWriteTime() {
        return Long.MAX_VALUE;
    }
    
    @Override
    public void setWriteTime(final long n) {
    }
    
    @Override
    public LocalCache$ReferenceEntry getNextInWriteQueue() {
        return this.nextWrite;
    }
    
    @Override
    public void setNextInWriteQueue(final LocalCache$ReferenceEntry nextWrite) {
        this.nextWrite = nextWrite;
    }
    
    @Override
    public LocalCache$ReferenceEntry getPreviousInWriteQueue() {
        return this.previousWrite;
    }
    
    @Override
    public void setPreviousInWriteQueue(final LocalCache$ReferenceEntry previousWrite) {
        this.previousWrite = previousWrite;
    }
}
