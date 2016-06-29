/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.disassembly.ICodeContainer;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ICodeNodeListener;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ILineNode;

public interface ICodeNode
extends ICodeContainer,
ILineNode {
    public void addListener(ICodeNodeListener var1);

    @Override
    public Iterable getInstructions();

    public int instructionCount();
}

