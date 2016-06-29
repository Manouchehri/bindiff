package com.google.protos.BinExport;

import com.google.protobuf.*;
import java.util.*;

public interface BinExport$FlowgraphOrBuilder extends MessageOrBuilder
{
    boolean hasAddress();
    
    long getAddress();
    
    List getVerticesList();
    
    BinExport$Flowgraph$Vertex getVertices(final int p0);
    
    int getVerticesCount();
    
    List getVerticesOrBuilderList();
    
    BinExport$Flowgraph$VertexOrBuilder getVerticesOrBuilder(final int p0);
    
    List getEdgesList();
    
    BinExport$Flowgraph$Edge getEdges(final int p0);
    
    int getEdgesCount();
    
    List getEdgesOrBuilderList();
    
    BinExport$Flowgraph$EdgeOrBuilder getEdgesOrBuilder(final int p0);
}
