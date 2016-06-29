/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JRegisterView;

public class RegisterInformation {
    private final String registerName;
    private final int registerSize;

    public RegisterInformation(String string, int n2) {
        this.registerName = string;
        this.registerSize = n2;
    }

    public String getRegisterName() {
        return this.registerName;
    }

    public int getRegisterSize() {
        return this.registerSize;
    }
}

