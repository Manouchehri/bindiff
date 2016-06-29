package com.google.protos.BinExport;

import com.google.protobuf.*;
import java.util.*;

public interface BinExport$Flowgraph$Vertex$InstructionOrBuilder extends MessageOrBuilder
{
    boolean hasAddress();
    
    long getAddress();
    
    boolean hasPrime();
    
    int getPrime();
    
    boolean hasStringReference();
    
    int getStringReference();
    
    boolean hasMnemonic();
    
    String getMnemonic();
    
    ByteString getMnemonicBytes();
    
    boolean hasOperands();
    
    String getOperands();
    
    ByteString getOperandsBytes();
    
    boolean hasRawBytes();
    
    ByteString getRawBytes();
    
    List getCallTargetsList();
    
    int getCallTargetsCount();
    
    long getCallTargets(final int p0);
    
    List getCommentsList();
    
    BinExport$Flowgraph$Vertex$Instruction$Comment getComments(final int p0);
    
    int getCommentsCount();
    
    List getCommentsOrBuilderList();
    
    BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder getCommentsOrBuilder(final int p0);
}
