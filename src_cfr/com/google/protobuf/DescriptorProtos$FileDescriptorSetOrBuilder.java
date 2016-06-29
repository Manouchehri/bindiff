/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$FileDescriptorSetOrBuilder
extends MessageOrBuilder {
    public List getFileList();

    public DescriptorProtos$FileDescriptorProto getFile(int var1);

    public int getFileCount();

    public List getFileOrBuilderList();

    public DescriptorProtos$FileDescriptorProtoOrBuilder getFileOrBuilder(int var1);
}

