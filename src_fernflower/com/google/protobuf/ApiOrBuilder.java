package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Method;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContextOrBuilder;
import java.util.List;

public interface ApiOrBuilder extends MessageOrBuilder {
   String getName();

   ByteString getNameBytes();

   List getMethodsList();

   Method getMethods(int var1);

   int getMethodsCount();

   List getMethodsOrBuilderList();

   MethodOrBuilder getMethodsOrBuilder(int var1);

   List getOptionsList();

   Option getOptions(int var1);

   int getOptionsCount();

   List getOptionsOrBuilderList();

   OptionOrBuilder getOptionsOrBuilder(int var1);

   String getVersion();

   ByteString getVersionBytes();

   boolean hasSourceContext();

   SourceContext getSourceContext();

   SourceContextOrBuilder getSourceContextOrBuilder();
}
