/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;

@Beta
public interface LineProcessor {
    public boolean processLine(String var1);

    public Object getResult();
}

