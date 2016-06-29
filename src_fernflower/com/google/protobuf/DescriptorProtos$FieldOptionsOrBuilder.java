package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldOptions$CType;
import com.google.protobuf.DescriptorProtos$FieldOptions$JSType;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.GeneratedMessage$ExtendableMessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$FieldOptionsOrBuilder extends GeneratedMessage$ExtendableMessageOrBuilder {
   boolean hasCtype();

   DescriptorProtos$FieldOptions$CType getCtype();

   boolean hasPacked();

   boolean getPacked();

   boolean hasJstype();

   DescriptorProtos$FieldOptions$JSType getJstype();

   boolean hasLazy();

   boolean getLazy();

   boolean hasDeprecated();

   boolean getDeprecated();

   boolean hasWeak();

   boolean getWeak();

   List getUninterpretedOptionList();

   DescriptorProtos$UninterpretedOption getUninterpretedOption(int var1);

   int getUninterpretedOptionCount();

   List getUninterpretedOptionOrBuilderList();

   DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int var1);
}
