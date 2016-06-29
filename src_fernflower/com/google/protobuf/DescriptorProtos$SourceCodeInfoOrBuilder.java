package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$SourceCodeInfoOrBuilder extends MessageOrBuilder {
   List getLocationList();

   DescriptorProtos$SourceCodeInfo$Location getLocation(int var1);

   int getLocationCount();

   List getLocationOrBuilderList();

   DescriptorProtos$SourceCodeInfo$LocationOrBuilder getLocationOrBuilder(int var1);
}
