/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldOptions$CType;
import com.google.protobuf.DescriptorProtos$FieldOptions$JSType;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.GeneratedMessage$ExtendableMessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$FieldOptionsOrBuilder
extends GeneratedMessage$ExtendableMessageOrBuilder {
    public boolean hasCtype();

    public DescriptorProtos$FieldOptions$CType getCtype();

    public boolean hasPacked();

    public boolean getPacked();

    public boolean hasJstype();

    public DescriptorProtos$FieldOptions$JSType getJstype();

    public boolean hasLazy();

    public boolean getLazy();

    public boolean hasDeprecated();

    public boolean getDeprecated();

    public boolean hasWeak();

    public boolean getWeak();

    public List getUninterpretedOptionList();

    public DescriptorProtos$UninterpretedOption getUninterpretedOption(int var1);

    public int getUninterpretedOptionCount();

    public List getUninterpretedOptionOrBuilderList();

    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int var1);
}

