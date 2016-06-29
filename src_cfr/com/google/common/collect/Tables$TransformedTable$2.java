/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Tables$TransformedTable;
import java.util.Map;

class Tables$TransformedTable$2
implements Function {
    final /* synthetic */ Tables$TransformedTable this$0;

    Tables$TransformedTable$2(Tables$TransformedTable tables$TransformedTable) {
        this.this$0 = tables$TransformedTable;
    }

    public Map apply(Map map) {
        return Maps.transformValues(map, this.this$0.function);
    }
}

