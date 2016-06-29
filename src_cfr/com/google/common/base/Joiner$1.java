/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Joiner;
import javax.annotation.Nullable;

class Joiner$1
extends Joiner {
    final /* synthetic */ String val$nullText;
    final /* synthetic */ Joiner this$0;

    Joiner$1(Joiner joiner, Joiner joiner2, String string) {
        this.this$0 = joiner;
        this.val$nullText = string;
        super(joiner2, null);
    }

    @Override
    CharSequence toString(@Nullable Object object) {
        String string /* !! */ ;
        if (object == null) {
            string /* !! */  = this.val$nullText;
            return string /* !! */ ;
        }
        string /* !! */  = this.this$0.toString(object);
        return string /* !! */ ;
    }

    @Override
    public Joiner useForNull(String string) {
        throw new UnsupportedOperationException("already specified useForNull");
    }

    @Override
    public Joiner skipNulls() {
        throw new UnsupportedOperationException("already specified useForNull");
    }
}

