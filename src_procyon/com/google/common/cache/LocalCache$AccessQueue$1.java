package com.google.common.cache;

class LocalCache$AccessQueue$1 extends LocalCache$AbstractReferenceEntry
{
    LocalCache$ReferenceEntry nextAccess;
    LocalCache$ReferenceEntry previousAccess;
    final /* synthetic */ LocalCache$AccessQueue this$0;
    
    LocalCache$AccessQueue$1(final LocalCache$AccessQueue this$0) {
        this.this$0 = this$0;
        this.nextAccess = this;
        this.previousAccess = this;
    }
    
    @Override
    public long getAccessTime() {
        return Long.MAX_VALUE;
    }
    
    @Override
    public void setAccessTime(final long n) {
    }
    
    @Override
    public LocalCache$ReferenceEntry getNextInAccessQueue() {
        return this.nextAccess;
    }
    
    @Override
    public void setNextInAccessQueue(final LocalCache$ReferenceEntry nextAccess) {
        this.nextAccess = nextAccess;
    }
    
    @Override
    public LocalCache$ReferenceEntry getPreviousInAccessQueue() {
        return this.previousAccess;
    }
    
    @Override
    public void setPreviousInAccessQueue(final LocalCache$ReferenceEntry previousAccess) {
        this.previousAccess = previousAccess;
    }
}
