/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JRegisterView;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.JRegisterView.IRegisterModel;
import com.google.security.zynamics.zylib.gui.JRegisterView.IRegistersChangedListener;
import com.google.security.zynamics.zylib.gui.JRegisterView.RegisterInformation;
import com.google.security.zynamics.zylib.gui.JRegisterView.RegisterInformationInternal;
import java.math.BigInteger;
import java.util.HashMap;

public class SimpleRegisterModel
implements IRegisterModel {
    private final HashMap registerMap = new HashMap();
    private final RegisterInformationInternal[] registers;

    public SimpleRegisterModel(RegisterInformation[] arrregisterInformation) {
        this.registers = new RegisterInformationInternal[arrregisterInformation.length];
        this.initializeRegisterInformation(arrregisterInformation);
    }

    private void initializeRegisterInformation(RegisterInformation[] arrregisterInformation) {
        int n2 = 0;
        while (n2 < arrregisterInformation.length) {
            RegisterInformationInternal registerInformationInternal;
            RegisterInformation registerInformation = arrregisterInformation[n2];
            Preconditions.checkNotNull(registerInformation.getRegisterName(), "Error: register.getRegisterName() argument can not be null");
            String string = String.valueOf(registerInformation.getRegisterName());
            Preconditions.checkArgument(this.registerMap.containsKey(registerInformation.getRegisterName()), string.length() != 0 ? "Error: Duplicate register name ".concat(string) : new String("Error: Duplicate register name "));
            this.registers[n2] = registerInformationInternal = new RegisterInformationInternal(registerInformation.getRegisterName(), registerInformation.getRegisterSize());
            this.registerMap.put(registerInformation.getRegisterName(), registerInformationInternal);
            ++n2;
        }
    }

    @Override
    public void addListener(IRegistersChangedListener iRegistersChangedListener) {
    }

    @Override
    public int getNumberOfRegisters() {
        return this.registers.length;
    }

    @Override
    public RegisterInformationInternal[] getRegisterInformation() {
        return this.registers;
    }

    @Override
    public RegisterInformationInternal getRegisterInformation(int n2) {
        return this.registers[n2];
    }

    @Override
    public void setValue(String string, BigInteger bigInteger) {
        Preconditions.checkNotNull(string, "Error: Argument register can't be null");
        Preconditions.checkArgument(this.registerMap.containsKey(string), "Error: Invalid register name");
        RegisterInformationInternal registerInformationInternal = (RegisterInformationInternal)this.registerMap.get(string);
        registerInformationInternal.setValue(bigInteger);
        registerInformationInternal.setModified(true);
    }
}

