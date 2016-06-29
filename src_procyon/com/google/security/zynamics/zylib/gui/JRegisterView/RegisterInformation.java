package com.google.security.zynamics.zylib.gui.JRegisterView;

public class RegisterInformation
{
    private final String registerName;
    private final int registerSize;
    
    public RegisterInformation(final String registerName, final int registerSize) {
        this.registerName = registerName;
        this.registerSize = registerSize;
    }
    
    public String getRegisterName() {
        return this.registerName;
    }
    
    public int getRegisterSize() {
        return this.registerSize;
    }
}
