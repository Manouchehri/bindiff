package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import java.util.List;

public interface MethodOrBuilder extends MessageOrBuilder {
   String getName();

   ByteString getNameBytes();

   String getRequestTypeUrl();

   ByteString getRequestTypeUrlBytes();

   boolean getRequestStreaming();

   String getResponseTypeUrl();

   ByteString getResponseTypeUrlBytes();

   boolean getResponseStreaming();

   List getOptionsList();

   Option getOptions(int var1);

   int getOptionsCount();

   List getOptionsOrBuilderList();

   OptionOrBuilder getOptionsOrBuilder(int var1);
}
