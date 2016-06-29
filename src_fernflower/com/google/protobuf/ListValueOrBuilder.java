package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Value;
import com.google.protobuf.ValueOrBuilder;
import java.util.List;

public interface ListValueOrBuilder extends MessageOrBuilder {
   List getValuesList();

   Value getValues(int var1);

   int getValuesCount();

   List getValuesOrBuilderList();

   ValueOrBuilder getValuesOrBuilder(int var1);
}
