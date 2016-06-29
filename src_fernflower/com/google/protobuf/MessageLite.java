package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.OutputStream;

public interface MessageLite extends MessageLiteOrBuilder {
   void writeTo(CodedOutputStream var1);

   int getSerializedSize();

   Parser getParserForType();

   ByteString toByteString();

   byte[] toByteArray();

   void writeTo(OutputStream var1);

   void writeDelimitedTo(OutputStream var1);

   MessageLite$Builder newBuilderForType();

   MessageLite$Builder toBuilder();
}
