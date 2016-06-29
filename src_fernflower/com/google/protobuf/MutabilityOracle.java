package com.google.protobuf;

import com.google.protobuf.MutabilityOracle$1;

interface MutabilityOracle {
   MutabilityOracle IMMUTABLE = new MutabilityOracle$1();

   void ensureMutable();
}
