package com.google.protos.BinExport;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder;
import java.util.List;

public interface BinExport$Flowgraph$Vertex$InstructionOrBuilder extends MessageOrBuilder {
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

   long getCallTargets(int var1);

   List getCommentsList();

   BinExport$Flowgraph$Vertex$Instruction$Comment getComments(int var1);

   int getCommentsCount();

   List getCommentsOrBuilderList();

   BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder getCommentsOrBuilder(int var1);
}
