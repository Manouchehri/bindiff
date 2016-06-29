/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import java.util.Date;

public interface IViewListener {
    public void changedDescription(Object var1, String var2);

    public void changedModificationDate(Object var1, Date var2);

    public void changedName(Object var1, String var2);

    public boolean closingView(Object var1);

    public void loadedView(Object var1);
}

