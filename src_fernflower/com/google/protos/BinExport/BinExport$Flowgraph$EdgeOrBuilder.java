package com.google.protos.BinExport;

import com.google.protobuf.MessageOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge$EdgeType;

public interface BinExport$Flowgraph$EdgeOrBuilder extends MessageOrBuilder {
   boolean hasSourceAddress();

   long getSourceAddress();

   boolean hasTargetAddress();

   long getTargetAddress();

   boolean hasType();

   BinExport$Flowgraph$Edge$EdgeType getType();
}
