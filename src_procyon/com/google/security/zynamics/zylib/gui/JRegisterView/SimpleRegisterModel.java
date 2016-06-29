package com.google.security.zynamics.zylib.gui.JRegisterView;

import java.util.*;
import com.google.common.base.*;
import java.math.*;

public class SimpleRegisterModel implements IRegisterModel
{
    private final HashMap registerMap;
    private final RegisterInformationInternal[] registers;
    
    public SimpleRegisterModel(final RegisterInformation[] array) {
        this.registerMap = new HashMap();
        this.registers = new RegisterInformationInternal[array.length];
        this.initializeRegisterInformation(array);
    }
    
    private void initializeRegisterInformation(final RegisterInformation[] array) {
        for (int i = 0; i < array.length; ++i) {
            final RegisterInformation registerInformation = array[i];
            Preconditions.checkNotNull(registerInformation.getRegisterName(), (Object)"Error: register.getRegisterName() argument can not be null");
            final boolean containsKey = this.registerMap.containsKey(registerInformation.getRegisterName());
            final String s = "Error: Duplicate register name ";
            final String value = String.valueOf(registerInformation.getRegisterName());
            Preconditions.checkArgument(containsKey, (Object)((value.length() != 0) ? s.concat(value) : new String(s)));
            final RegisterInformationInternal registerInformationInternal = new RegisterInformationInternal(registerInformation.getRegisterName(), registerInformation.getRegisterSize());
            this.registers[i] = registerInformationInternal;
            this.registerMap.put(registerInformation.getRegisterName(), registerInformationInternal);
        }
    }
    
    @Override
    public void addListener(final IRegistersChangedListener registersChangedListener) {
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
    public RegisterInformationInternal getRegisterInformation(final int n) {
        return this.registers[n];
    }
    
    @Override
    public void setValue(final String s, final BigInteger value) {
        Preconditions.checkNotNull(s, (Object)"Error: Argument register can't be null");
        Preconditions.checkArgument(this.registerMap.containsKey(s), (Object)"Error: Invalid register name");
        final RegisterInformationInternal registerInformationInternal = this.registerMap.get(s);
        registerInformationInternal.setValue(value);
        registerInformationInternal.setModified(true);
    }
}
