package com.google.protos.BinExport;

import com.google.protobuf.*;
import java.util.*;

public interface BinExport$Flowgraph$VertexOrBuilder extends MessageOrBuilder
{
    boolean hasPrime();
    
    long getPrime();
    
    List getInstructionsList();
    
    BinExport$Flowgraph$Vertex$Instruction getInstructions(final int p0);
    
    int getInstructionsCount();
    
    List getInstructionsOrBuilderList();
    
    BinExport$Flowgraph$Vertex$InstructionOrBuilder getInstructionsOrBuilder(final int p0);
}
