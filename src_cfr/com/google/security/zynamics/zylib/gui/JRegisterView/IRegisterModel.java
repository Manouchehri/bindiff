/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JRegisterView;

import com.google.security.zynamics.zylib.gui.JRegisterView.IRegistersChangedListener;
import com.google.security.zynamics.zylib.gui.JRegisterView.RegisterInformationInternal;
import java.math.BigInteger;

public interface IRegisterModel {
    public void addListener(IRegistersChangedListener var1);

    public int getNumberOfRegisters();

    public RegisterInformationInternal[] getRegisterInformation();

    public RegisterInformationInternal getRegisterInformation(int var1);

    public void setValue(String var1, BigInteger var2);
}

