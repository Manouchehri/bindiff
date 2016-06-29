/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.ZyTree.IZyTreeNode;
import com.google.security.zynamics.zylib.disassembly.ExpressionType;
import com.google.security.zynamics.zylib.disassembly.IReplacement;
import java.util.List;

public interface IOperandTreeNode
extends IZyTreeNode {
    @Override
    public List getChildren();

    public List getReferences();

    public IReplacement getReplacement();

    public ExpressionType getType();

    public String getValue();
}

