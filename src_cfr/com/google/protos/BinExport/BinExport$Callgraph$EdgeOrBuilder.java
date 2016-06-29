/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.MessageOrBuilder;

public interface BinExport$Callgraph$EdgeOrBuilder
extends MessageOrBuilder {
    public boolean hasSourceFunctionAddress();

    public long getSourceFunctionAddress();

    public boolean hasSourceInstructionAddress();

    public long getSourceInstructionAddress();

    public boolean hasTargetAddress();

    public long getTargetAddress();
}

