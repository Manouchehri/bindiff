/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.MessageOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge$EdgeType;

public interface BinExport$Flowgraph$EdgeOrBuilder
extends MessageOrBuilder {
    public boolean hasSourceAddress();

    public long getSourceAddress();

    public boolean hasTargetAddress();

    public long getTargetAddress();

    public boolean hasType();

    public BinExport$Flowgraph$Edge$EdgeType getType();
}

