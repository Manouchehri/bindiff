package com.google.protobuf;

import java.util.*;

public interface DescriptorProtos$SourceCodeInfo$LocationOrBuilder extends MessageOrBuilder
{
    List getPathList();
    
    int getPathCount();
    
    int getPath(final int p0);
    
    List getSpanList();
    
    int getSpanCount();
    
    int getSpan(final int p0);
    
    boolean hasLeadingComments();
    
    String getLeadingComments();
    
    ByteString getLeadingCommentsBytes();
    
    boolean hasTrailingComments();
    
    String getTrailingComments();
    
    ByteString getTrailingCommentsBytes();
    
    ProtocolStringList getLeadingDetachedCommentsList();
    
    int getLeadingDetachedCommentsCount();
    
    String getLeadingDetachedComments(final int p0);
    
    ByteString getLeadingDetachedCommentsBytes(final int p0);
}
