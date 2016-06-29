package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Field$Cardinality;
import com.google.protobuf.Field$Kind;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import java.util.List;

public interface FieldOrBuilder extends MessageOrBuilder {
   int getKindValue();

   Field$Kind getKind();

   int getCardinalityValue();

   Field$Cardinality getCardinality();

   int getNumber();

   String getName();

   ByteString getNameBytes();

   String getTypeUrl();

   ByteString getTypeUrlBytes();

   int getOneofIndex();

   boolean getPacked();

   List getOptionsList();

   Option getOptions(int var1);

   int getOptionsCount();

   List getOptionsOrBuilderList();

   OptionOrBuilder getOptionsOrBuilder(int var1);
}
