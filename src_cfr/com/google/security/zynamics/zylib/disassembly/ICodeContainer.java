/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.disassembly.IInstruction;
import java.util.List;

public interface ICodeContainer {
    public IAddress getAddress();

    public Iterable getInstructions();

    public IInstruction getLastInstruction();

    public List getOutgoingEdges();

    public boolean hasInstruction(IInstruction var1);
}

