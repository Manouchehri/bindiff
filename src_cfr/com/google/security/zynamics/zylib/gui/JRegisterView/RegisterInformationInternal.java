/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JRegisterView;

import com.google.security.zynamics.zylib.gui.JRegisterView.RegisterInformation;
import java.math.BigInteger;

public class RegisterInformationInternal
extends RegisterInformation {
    private BigInteger value = BigInteger.ZERO;
    private boolean modified = false;

    public RegisterInformationInternal(String string, int n2) {
        super(string, n2);
    }

    public BigInteger getValue() {
        return this.value;
    }

    public boolean isModified() {
        return this.modified;
    }

    public void setModified(boolean bl2) {
        this.modified = bl2;
    }

    public void setValue(BigInteger bigInteger) {
        this.value = bigInteger;
    }
}

