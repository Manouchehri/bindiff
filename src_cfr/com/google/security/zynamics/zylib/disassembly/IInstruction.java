/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.List;

public interface IInstruction {
    public IAddress getAddress();

    public String getArchitecture();

    public byte[] getData();

    public long getLength();

    public String getMnemonic();

    public Integer getMnemonicCode();

    public List getOperands();
}

