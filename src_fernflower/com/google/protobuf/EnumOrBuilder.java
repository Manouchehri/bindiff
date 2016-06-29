package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.EnumValue;
import com.google.protobuf.EnumValueOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContextOrBuilder;
import java.util.List;

public interface EnumOrBuilder extends MessageOrBuilder {
   String getName();

   ByteString getNameBytes();

   List getEnumvalueList();

   EnumValue getEnumvalue(int var1);

   int getEnumvalueCount();

   List getEnumvalueOrBuilderList();

   EnumValueOrBuilder getEnumvalueOrBuilder(int var1);

   List getOptionsList();

   Option getOptions(int var1);

   int getOptionsCount();

   List getOptionsOrBuilderList();

   OptionOrBuilder getOptionsOrBuilder(int var1);

   boolean hasSourceContext();

   SourceContext getSourceContext();

   SourceContextOrBuilder getSourceContextOrBuilder();
}
