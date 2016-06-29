/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.collect.Lists;
import com.google.common.io.LineProcessor;
import java.util.List;

final class Resources$1
implements LineProcessor {
    final List result = Lists.newArrayList();

    Resources$1() {
    }

    @Override
    public boolean processLine(String string) {
        this.result.add(string);
        return true;
    }

    @Override
    public List getResult() {
        return this.result;
    }
}

