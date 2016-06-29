package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Field;
import com.google.protobuf.FieldOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContextOrBuilder;
import java.util.List;

public interface TypeOrBuilder extends MessageOrBuilder {
   String getName();

   ByteString getNameBytes();

   List getFieldsList();

   Field getFields(int var1);

   int getFieldsCount();

   List getFieldsOrBuilderList();

   FieldOrBuilder getFieldsOrBuilder(int var1);

   ProtocolStringList getOneofsList();

   int getOneofsCount();

   String getOneofs(int var1);

   ByteString getOneofsBytes(int var1);

   List getOptionsList();

   Option getOptions(int var1);

   int getOptionsCount();

   List getOptionsOrBuilderList();

   OptionOrBuilder getOptionsOrBuilder(int var1);

   boolean hasSourceContext();

   SourceContext getSourceContext();

   SourceContextOrBuilder getSourceContextOrBuilder();
}
