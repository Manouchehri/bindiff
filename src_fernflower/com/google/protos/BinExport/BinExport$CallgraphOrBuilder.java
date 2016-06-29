package com.google.protos.BinExport;

import com.google.protobuf.MessageOrBuilder;
import com.google.protos.BinExport.BinExport$Callgraph$Edge;
import com.google.protos.BinExport.BinExport$Callgraph$EdgeOrBuilder;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex;
import com.google.protos.BinExport.BinExport$Callgraph$VertexOrBuilder;
import java.util.List;

public interface BinExport$CallgraphOrBuilder extends MessageOrBuilder {
   List getVerticesList();

   BinExport$Callgraph$Vertex getVertices(int var1);

   int getVerticesCount();

   List getVerticesOrBuilderList();

   BinExport$Callgraph$VertexOrBuilder getVerticesOrBuilder(int var1);

   List getEdgesList();

   BinExport$Callgraph$Edge getEdges(int var1);

   int getEdgesCount();

   List getEdgesOrBuilderList();

   BinExport$Callgraph$EdgeOrBuilder getEdgesOrBuilder(int var1);
}
