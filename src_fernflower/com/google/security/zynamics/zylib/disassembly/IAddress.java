package com.google.security.zynamics.zylib.disassembly;

import java.math.BigInteger;

public interface IAddress extends Comparable {
   BigInteger toBigInteger();

   String toHexString();

   long toLong();
}
