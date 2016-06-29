package com.google.security.zynamics.zylib.gui.JRegisterView;

import java.math.*;

public interface IRegisterModel
{
    void addListener(final IRegistersChangedListener p0);
    
    int getNumberOfRegisters();
    
    RegisterInformationInternal[] getRegisterInformation();
    
    RegisterInformationInternal getRegisterInformation(final int p0);
    
    void setValue(final String p0, final BigInteger p1);
}
