/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.IFunction;
import java.util.List;

public interface IFunctionListener {
    public void appendedComment(IFunction var1, Object var2);

    public void changedDescription(IFunction var1, String var2);

    public void changedName(IFunction var1, String var2);

    public void changedForwardedFunction(IFunction var1);

    public void closed(IFunction var1);

    public void deletedComment(IFunction var1, Object var2);

    public void editedComment(IFunction var1, Object var2);

    public void initializedComment(IFunction var1, List var2);

    public void loadedFunction(IFunction var1);
}

