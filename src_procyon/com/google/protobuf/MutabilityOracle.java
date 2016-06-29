package com.google.protobuf;

interface MutabilityOracle
{
    public static final MutabilityOracle IMMUTABLE = new MutabilityOracle$1();
    
    void ensureMutable();
}
