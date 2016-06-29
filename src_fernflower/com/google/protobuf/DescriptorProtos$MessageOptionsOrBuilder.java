package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.GeneratedMessage$ExtendableMessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$MessageOptionsOrBuilder extends GeneratedMessage$ExtendableMessageOrBuilder {
   boolean hasMessageSetWireFormat();

   boolean getMessageSetWireFormat();

   boolean hasNoStandardDescriptorAccessor();

   boolean getNoStandardDescriptorAccessor();

   boolean hasDeprecated();

   boolean getDeprecated();

   boolean hasMapEntry();

   boolean getMapEntry();

   List getUninterpretedOptionList();

   DescriptorProtos$UninterpretedOption getUninterpretedOption(int var1);

   int getUninterpretedOptionCount();

   List getUninterpretedOptionOrBuilderList();

   DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int var1);
}
