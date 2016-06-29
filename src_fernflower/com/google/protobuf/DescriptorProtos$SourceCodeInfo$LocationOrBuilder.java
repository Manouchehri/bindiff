package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.ProtocolStringList;
import java.util.List;

public interface DescriptorProtos$SourceCodeInfo$LocationOrBuilder extends MessageOrBuilder {
   List getPathList();

   int getPathCount();

   int getPath(int var1);

   List getSpanList();

   int getSpanCount();

   int getSpan(int var1);

   boolean hasLeadingComments();

   String getLeadingComments();

   ByteString getLeadingCommentsBytes();

   boolean hasTrailingComments();

   String getTrailingComments();

   ByteString getTrailingCommentsBytes();

   ProtocolStringList getLeadingDetachedCommentsList();

   int getLeadingDetachedCommentsCount();

   String getLeadingDetachedComments(int var1);

   ByteString getLeadingDetachedCommentsBytes(int var1);
}
