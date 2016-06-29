/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.IModuleConfiguration;
import com.google.security.zynamics.zylib.disassembly.IModuleContent;

public interface IModule {
    public IModuleConfiguration getConfiguration();

    public IModuleContent getContent();
}

