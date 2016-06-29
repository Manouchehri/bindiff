/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$SourceCodeInfoOrBuilder
extends MessageOrBuilder {
    public List getLocationList();

    public DescriptorProtos$SourceCodeInfo$Location getLocation(int var1);

    public int getLocationCount();

    public List getLocationOrBuilderList();

    public DescriptorProtos$SourceCodeInfo$LocationOrBuilder getLocationOrBuilder(int var1);
}

