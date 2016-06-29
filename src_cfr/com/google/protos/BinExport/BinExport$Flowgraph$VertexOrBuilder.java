/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.MessageOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$InstructionOrBuilder;
import java.util.List;

public interface BinExport$Flowgraph$VertexOrBuilder
extends MessageOrBuilder {
    public boolean hasPrime();

    public long getPrime();

    public List getInstructionsList();

    public BinExport$Flowgraph$Vertex$Instruction getInstructions(int var1);

    public int getInstructionsCount();

    public List getInstructionsOrBuilderList();

    public BinExport$Flowgraph$Vertex$InstructionOrBuilder getInstructionsOrBuilder(int var1);
}

