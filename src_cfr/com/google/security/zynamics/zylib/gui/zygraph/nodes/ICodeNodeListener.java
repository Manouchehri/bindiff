/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import java.util.List;

public interface ICodeNodeListener {
    public void appendedGlobalCodeNodeComment(Object var1, Object var2);

    public void appendedLocalCodeNodeComment(Object var1, Object var2);

    public void appendedLocalInstructionComment(Object var1, Object var2, Object var3);

    public void deletedGlobalCodeNodeComment(Object var1, Object var2);

    public void deletedLocalCodeNodeComment(Object var1, Object var2);

    public void deletedLocalInstructionComment(Object var1, Object var2, Object var3);

    public void editedGlobalCodeNodeComment(Object var1, Object var2);

    public void editedLocalCodeNodeComment(Object var1, Object var2);

    public void editedLocalInstructionComment(Object var1, Object var2, Object var3);

    public void initializedGlobalCodeNodeComment(Object var1, List var2);

    public void initializedLocalCodeNodeComment(Object var1, List var2);

    public void initializedLocalInstructionComment(Object var1, Object var2, List var3);
}

