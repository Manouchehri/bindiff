package com.google.protos.BinExport;

import com.google.protobuf.*;

public interface BinExport$Callgraph$EdgeOrBuilder extends MessageOrBuilder
{
    boolean hasSourceFunctionAddress();
    
    long getSourceFunctionAddress();
    
    boolean hasSourceInstructionAddress();
    
    long getSourceInstructionAddress();
    
    boolean hasTargetAddress();
    
    long getTargetAddress();
}
