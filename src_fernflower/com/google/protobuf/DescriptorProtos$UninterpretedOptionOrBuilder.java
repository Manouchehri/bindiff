package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$UninterpretedOptionOrBuilder extends MessageOrBuilder {
   List getNameList();

   DescriptorProtos$UninterpretedOption$NamePart getName(int var1);

   int getNameCount();

   List getNameOrBuilderList();

   DescriptorProtos$UninterpretedOption$NamePartOrBuilder getNameOrBuilder(int var1);

   boolean hasIdentifierValue();

   String getIdentifierValue();

   ByteString getIdentifierValueBytes();

   boolean hasPositiveIntValue();

   long getPositiveIntValue();

   boolean hasNegativeIntValue();

   long getNegativeIntValue();

   boolean hasDoubleValue();

   double getDoubleValue();

   boolean hasStringValue();

   ByteString getStringValue();

   boolean hasAggregateValue();

   String getAggregateValue();

   ByteString getAggregateValueBytes();
}
