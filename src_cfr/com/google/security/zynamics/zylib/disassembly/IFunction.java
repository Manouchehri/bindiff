/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.FunctionType;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public interface IFunction {
    public IAddress getAddress();

    public int getBasicBlockCount();

    public String getDescription();

    public int getEdgeCount();

    public int getIndegree();

    public String getName();

    public int getOutdegree();

    public FunctionType getType();
}

