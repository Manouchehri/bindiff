package com.google.protos.BinExport;

import com.google.protobuf.*;
import java.util.*;

public interface BinExport$CallgraphOrBuilder extends MessageOrBuilder
{
    List getVerticesList();
    
    BinExport$Callgraph$Vertex getVertices(final int p0);
    
    int getVerticesCount();
    
    List getVerticesOrBuilderList();
    
    BinExport$Callgraph$VertexOrBuilder getVerticesOrBuilder(final int p0);
    
    List getEdgesList();
    
    BinExport$Callgraph$Edge getEdges(final int p0);
    
    int getEdgesCount();
    
    List getEdgesOrBuilderList();
    
    BinExport$Callgraph$EdgeOrBuilder getEdgesOrBuilder(final int p0);
}
