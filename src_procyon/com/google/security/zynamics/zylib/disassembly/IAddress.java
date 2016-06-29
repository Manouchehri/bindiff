package com.google.security.zynamics.zylib.disassembly;

import java.math.*;

public interface IAddress extends Comparable
{
    BigInteger toBigInteger();
    
    String toHexString();
    
    long toLong();
}
