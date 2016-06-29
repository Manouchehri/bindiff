/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import java.util.List;

public interface IGroupNodeListener {
    public void appendedGroupNodeComment(Object var1, Object var2);

    public void deletedGroupNodeComment(Object var1, Object var2);

    public void editedGroupNodeComment(Object var1, Object var2);

    public void initializedGroupNodeComment(Object var1, List var2);
}

