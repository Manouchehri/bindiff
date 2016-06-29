package com.google.protos.BinExport;

import com.google.protobuf.*;

public interface BinExport$Callgraph$VertexOrBuilder extends MessageOrBuilder
{
    boolean hasAddress();
    
    long getAddress();
    
    boolean hasPrime();
    
    long getPrime();
    
    boolean hasFunctionType();
    
    BinExport$Callgraph$Vertex$FunctionType getFunctionType();
    
    boolean hasHasRealName();
    
    boolean getHasRealName();
    
    boolean hasMangledName();
    
    String getMangledName();
    
    ByteString getMangledNameBytes();
    
    boolean hasDemangledName();
    
    String getDemangledName();
    
    ByteString getDemangledNameBytes();
}
