/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import java.util.List;

public interface IBlockContainer {
    public List getBasicBlockEdges();

    public List getBasicBlocks();

    public String getName();
}

