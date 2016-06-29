package com.google.common.collect;

final class RegularImmutableTable$Values extends ImmutableList
{
    final /* synthetic */ RegularImmutableTable this$0;
    
    private RegularImmutableTable$Values(final RegularImmutableTable this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public int size() {
        return this.this$0.size();
    }
    
    @Override
    public Object get(final int n) {
        return this.this$0.getValue(n);
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
}
