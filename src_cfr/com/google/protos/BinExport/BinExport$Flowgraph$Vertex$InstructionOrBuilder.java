/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder;
import java.util.List;

public interface BinExport$Flowgraph$Vertex$InstructionOrBuilder
extends MessageOrBuilder {
    public boolean hasAddress();

    public long getAddress();

    public boolean hasPrime();

    public int getPrime();

    public boolean hasStringReference();

    public int getStringReference();

    public boolean hasMnemonic();

    public String getMnemonic();

    public ByteString getMnemonicBytes();

    public boolean hasOperands();

    public String getOperands();

    public ByteString getOperandsBytes();

    public boolean hasRawBytes();

    public ByteString getRawBytes();

    public List getCallTargetsList();

    public int getCallTargetsCount();

    public long getCallTargets(int var1);

    public List getCommentsList();

    public BinExport$Flowgraph$Vertex$Instruction$Comment getComments(int var1);

    public int getCommentsCount();

    public List getCommentsOrBuilderList();

    public BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder getCommentsOrBuilder(int var1);
}

