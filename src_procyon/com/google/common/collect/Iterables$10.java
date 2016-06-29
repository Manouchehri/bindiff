package com.google.common.collect;

import java.util.*;

final class Iterables$10 extends FluentIterable
{
    final /* synthetic */ List val$list;
    final /* synthetic */ int val$numberToSkip;
    
    Iterables$10(final List val$list, final int val$numberToSkip) {
        this.val$list = val$list;
        this.val$numberToSkip = val$numberToSkip;
    }
    
    @Override
    public Iterator iterator() {
        return this.val$list.subList(Math.min(this.val$list.size(), this.val$numberToSkip), this.val$list.size()).iterator();
    }
}
