/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public interface IZyEditableObject {
    public int getEnd();

    public int getLength();

    public Object getPersistentModel();

    public int getStart();

    public boolean isCommentDelimiter();

    public boolean isPlaceholder();

    public boolean update(String var1);

    public boolean updateComment(String var1, ECommentPlacement var2);
}

