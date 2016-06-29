package com.google.protos.BinExport;

import com.google.protobuf.MessageOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge;
import com.google.protos.BinExport.BinExport$Flowgraph$EdgeOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex;
import com.google.protos.BinExport.BinExport$Flowgraph$VertexOrBuilder;
import java.util.List;

public interface BinExport$FlowgraphOrBuilder extends MessageOrBuilder {
   boolean hasAddress();

   long getAddress();

   List getVerticesList();

   BinExport$Flowgraph$Vertex getVertices(int var1);

   int getVerticesCount();

   List getVerticesOrBuilderList();

   BinExport$Flowgraph$VertexOrBuilder getVerticesOrBuilder(int var1);

   List getEdgesList();

   BinExport$Flowgraph$Edge getEdges(int var1);

   int getEdgesCount();

   List getEdgesOrBuilderList();

   BinExport$Flowgraph$EdgeOrBuilder getEdgesOrBuilder(int var1);
}
