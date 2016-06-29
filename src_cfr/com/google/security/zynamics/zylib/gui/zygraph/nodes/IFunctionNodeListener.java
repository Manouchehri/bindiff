/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNodeListener;
import java.util.List;

public interface IFunctionNodeListener
extends IViewNodeListener {
    public void appendedFunctionNodeComment(Object var1, Object var2);

    public void deletedFunctionNodeComment(Object var1, Object var2);

    public void editedFunctionNodeComment(Object var1, Object var2);

    public void initializedFunctionNodeComment(Object var1, List var2);
}

