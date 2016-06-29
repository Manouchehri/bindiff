/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex$FunctionType;

public interface BinExport$Callgraph$VertexOrBuilder
extends MessageOrBuilder {
    public boolean hasAddress();

    public long getAddress();

    public boolean hasPrime();

    public long getPrime();

    public boolean hasFunctionType();

    public BinExport$Callgraph$Vertex$FunctionType getFunctionType();

    public boolean hasHasRealName();

    public boolean getHasRealName();

    public boolean hasMangledName();

    public String getMangledName();

    public ByteString getMangledNameBytes();

    public boolean hasDemangledName();

    public String getDemangledName();

    public ByteString getDemangledNameBytes();
}

