/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public interface IAddressPair {
    public long getAddress(ESide var1);

    public IAddress getIAddress(ESide var1);
}

