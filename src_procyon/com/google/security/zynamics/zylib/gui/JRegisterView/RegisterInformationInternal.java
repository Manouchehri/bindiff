package com.google.security.zynamics.zylib.gui.JRegisterView;

import java.math.*;

public class RegisterInformationInternal extends RegisterInformation
{
    private BigInteger value;
    private boolean modified;
    
    public RegisterInformationInternal(final String s, final int n) {
        super(s, n);
        this.value = BigInteger.ZERO;
        this.modified = false;
    }
    
    public BigInteger getValue() {
        return this.value;
    }
    
    public boolean isModified() {
        return this.modified;
    }
    
    public void setModified(final boolean modified) {
        this.modified = modified;
    }
    
    public void setValue(final BigInteger value) {
        this.value = value;
    }
}
