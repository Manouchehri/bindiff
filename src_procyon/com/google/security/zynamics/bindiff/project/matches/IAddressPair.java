package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;

public interface IAddressPair
{
    long getAddress(final ESide p0);
    
    IAddress getIAddress(final ESide p0);
}
