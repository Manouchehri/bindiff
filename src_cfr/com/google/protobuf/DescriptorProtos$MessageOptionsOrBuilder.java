/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.GeneratedMessage$ExtendableMessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$MessageOptionsOrBuilder
extends GeneratedMessage$ExtendableMessageOrBuilder {
    public boolean hasMessageSetWireFormat();

    public boolean getMessageSetWireFormat();

    public boolean hasNoStandardDescriptorAccessor();

    public boolean getNoStandardDescriptorAccessor();

    public boolean hasDeprecated();

    public boolean getDeprecated();

    public boolean hasMapEntry();

    public boolean getMapEntry();

    public List getUninterpretedOptionList();

    public DescriptorProtos$UninterpretedOption getUninterpretedOption(int var1);

    public int getUninterpretedOptionCount();

    public List getUninterpretedOptionOrBuilderList();

    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int var1);
}

