package com.google.security.zynamics.zylib.disassembly;

import java.util.*;

public interface IInstruction
{
    IAddress getAddress();
    
    String getArchitecture();
    
    byte[] getData();
    
    long getLength();
    
    String getMnemonic();
    
    Integer getMnemonicCode();
    
    List getOperands();
}
