package com.google.common.base;

import java.util.*;

class Joiner$2 extends Joiner
{
    final /* synthetic */ Joiner this$0;
    
    Joiner$2(final Joiner this$0, final Joiner joiner) {
        this.this$0 = this$0;
        super(joiner, null);
    }
    
    @Override
    public Appendable appendTo(final Appendable appendable, final Iterator iterator) {
        Preconditions.checkNotNull(appendable, (Object)"appendable");
        Preconditions.checkNotNull(iterator, (Object)"parts");
        while (iterator.hasNext()) {
            final Object next = iterator.next();
            if (next != null) {
                appendable.append(this.this$0.toString(next));
                break;
            }
        }
        while (iterator.hasNext()) {
            final Object next2 = iterator.next();
            if (next2 != null) {
                appendable.append(Joiner.access$100(this.this$0));
                appendable.append(this.this$0.toString(next2));
            }
        }
        return appendable;
    }
    
    @Override
    public Joiner useForNull(final String s) {
        throw new UnsupportedOperationException("already specified skipNulls");
    }
    
    @Override
    public Joiner$MapJoiner withKeyValueSeparator(final String s) {
        throw new UnsupportedOperationException("can't use .skipNulls() with maps");
    }
}
