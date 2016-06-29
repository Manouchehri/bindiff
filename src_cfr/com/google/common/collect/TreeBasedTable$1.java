/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.TreeBasedTable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class TreeBasedTable$1
implements Function {
    final /* synthetic */ TreeBasedTable this$0;

    TreeBasedTable$1(TreeBasedTable treeBasedTable) {
        this.this$0 = treeBasedTable;
    }

    public Iterator apply(Map map) {
        return map.keySet().iterator();
    }
}

