/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$UninterpretedOptionOrBuilder
extends MessageOrBuilder {
    public List getNameList();

    public DescriptorProtos$UninterpretedOption$NamePart getName(int var1);

    public int getNameCount();

    public List getNameOrBuilderList();

    public DescriptorProtos$UninterpretedOption$NamePartOrBuilder getNameOrBuilder(int var1);

    public boolean hasIdentifierValue();

    public String getIdentifierValue();

    public ByteString getIdentifierValueBytes();

    public boolean hasPositiveIntValue();

    public long getPositiveIntValue();

    public boolean hasNegativeIntValue();

    public long getNegativeIntValue();

    public boolean hasDoubleValue();

    public double getDoubleValue();

    public boolean hasStringValue();

    public ByteString getStringValue();

    public boolean hasAggregateValue();

    public String getAggregateValue();

    public ByteString getAggregateValueBytes();
}

