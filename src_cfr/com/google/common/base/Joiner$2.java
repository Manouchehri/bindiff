/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner$1;
import com.google.common.base.Joiner$MapJoiner;
import com.google.common.base.Preconditions;
import java.util.Iterator;

class Joiner$2
extends Joiner {
    final /* synthetic */ Joiner this$0;

    Joiner$2(Joiner joiner, Joiner joiner2) {
        this.this$0 = joiner;
        super(joiner2, null);
    }

    @Override
    public Appendable appendTo(Appendable appendable, Iterator iterator) {
        Object e2;
        Preconditions.checkNotNull(appendable, "appendable");
        Preconditions.checkNotNull(iterator, "parts");
        while (iterator.hasNext()) {
            e2 = iterator.next();
            if (e2 == null) continue;
            appendable.append(this.this$0.toString(e2));
            break;
        }
        while (iterator.hasNext()) {
            e2 = iterator.next();
            if (e2 == null) continue;
            appendable.append(Joiner.access$100(this.this$0));
            appendable.append(this.this$0.toString(e2));
        }
        return appendable;
    }

    @Override
    public Joiner useForNull(String string) {
        throw new UnsupportedOperationException("already specified skipNulls");
    }

    @Override
    public Joiner.MapJoiner withKeyValueSeparator(String string) {
        throw new UnsupportedOperationException("can't use .skipNulls() with maps");
    }
}

