/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general.undo;

public interface IUndoable {
    public String getDescription();

    public String getSubCommandDescription(int var1);

    public int getSubCommands();

    public void revertToSnapshot();

    public void undo();
}

