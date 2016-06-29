/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.ProtocolStringList;
import java.util.List;

public interface DescriptorProtos$SourceCodeInfo$LocationOrBuilder
extends MessageOrBuilder {
    public List getPathList();

    public int getPathCount();

    public int getPath(int var1);

    public List getSpanList();

    public int getSpanCount();

    public int getSpan(int var1);

    public boolean hasLeadingComments();

    public String getLeadingComments();

    public ByteString getLeadingCommentsBytes();

    public boolean hasTrailingComments();

    public String getTrailingComments();

    public ByteString getTrailingCommentsBytes();

    public ProtocolStringList getLeadingDetachedCommentsList();

    public int getLeadingDetachedCommentsCount();

    public String getLeadingDetachedComments(int var1);

    public ByteString getLeadingDetachedCommentsBytes(int var1);
}

