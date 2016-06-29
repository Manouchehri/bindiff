package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$FileDescriptorSetOrBuilder extends MessageOrBuilder {
   List getFileList();

   DescriptorProtos$FileDescriptorProto getFile(int var1);

   int getFileCount();

   List getFileOrBuilderList();

   DescriptorProtos$FileDescriptorProtoOrBuilder getFileOrBuilder(int var1);
}
