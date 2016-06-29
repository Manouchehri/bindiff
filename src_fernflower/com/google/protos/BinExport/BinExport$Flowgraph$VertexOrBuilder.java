package com.google.protos.BinExport;

import com.google.protobuf.MessageOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$InstructionOrBuilder;
import java.util.List;

public interface BinExport$Flowgraph$VertexOrBuilder extends MessageOrBuilder {
   boolean hasPrime();

   long getPrime();

   List getInstructionsList();

   BinExport$Flowgraph$Vertex$Instruction getInstructions(int var1);

   int getInstructionsCount();

   List getInstructionsOrBuilderList();

   BinExport$Flowgraph$Vertex$InstructionOrBuilder getInstructionsOrBuilder(int var1);
}
