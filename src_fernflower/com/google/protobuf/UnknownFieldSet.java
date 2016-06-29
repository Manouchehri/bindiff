package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$CodedBuilder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.TextFormat;
import com.google.protobuf.UnknownFieldSet$1;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.UnknownFieldSet$Field;
import com.google.protobuf.UnknownFieldSet$Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class UnknownFieldSet implements MessageLite {
   private static final UnknownFieldSet defaultInstance = new UnknownFieldSet(Collections.emptyMap());
   private Map fields;
   private static final UnknownFieldSet$Parser PARSER = new UnknownFieldSet$Parser();

   private UnknownFieldSet() {
   }

   public static UnknownFieldSet$Builder newBuilder() {
      return UnknownFieldSet$Builder.access$000();
   }

   public static UnknownFieldSet$Builder newBuilder(UnknownFieldSet var0) {
      return newBuilder().mergeFrom(var0);
   }

   public static UnknownFieldSet getDefaultInstance() {
      return defaultInstance;
   }

   public UnknownFieldSet getDefaultInstanceForType() {
      return defaultInstance;
   }

   private UnknownFieldSet(Map var1) {
      this.fields = var1;
   }

   public boolean equals(Object var1) {
      return this == var1?true:var1 instanceof UnknownFieldSet && this.fields.equals(((UnknownFieldSet)var1).fields);
   }

   public int hashCode() {
      return this.fields.hashCode();
   }

   public Map asMap() {
      return this.fields;
   }

   public boolean hasField(int var1) {
      return this.fields.containsKey(Integer.valueOf(var1));
   }

   public UnknownFieldSet$Field getField(int var1) {
      UnknownFieldSet$Field var2 = (UnknownFieldSet$Field)this.fields.get(Integer.valueOf(var1));
      return var2 == null?UnknownFieldSet$Field.getDefaultInstance():var2;
   }

   public void writeTo(CodedOutputStream var1) {
      Iterator var2 = this.fields.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         ((UnknownFieldSet$Field)var3.getValue()).writeTo(((Integer)var3.getKey()).intValue(), var1);
      }

   }

   public String toString() {
      return TextFormat.printToString(this);
   }

   public ByteString toByteString() {
      try {
         ByteString$CodedBuilder var1 = ByteString.newCodedBuilder(this.getSerializedSize());
         this.writeTo(var1.getCodedOutput());
         return var1.build();
      } catch (IOException var2) {
         throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", var2);
      }
   }

   public byte[] toByteArray() {
      try {
         byte[] var1 = new byte[this.getSerializedSize()];
         CodedOutputStream var2 = CodedOutputStream.newInstance(var1);
         this.writeTo(var2);
         var2.checkNoSpaceLeft();
         return var1;
      } catch (IOException var3) {
         throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", var3);
      }
   }

   public void writeTo(OutputStream var1) {
      CodedOutputStream var2 = CodedOutputStream.newInstance(var1);
      this.writeTo(var2);
      var2.flush();
   }

   public void writeDelimitedTo(OutputStream var1) {
      CodedOutputStream var2 = CodedOutputStream.newInstance(var1);
      var2.writeRawVarint32(this.getSerializedSize());
      this.writeTo(var2);
      var2.flush();
   }

   public int getSerializedSize() {
      int var1 = 0;

      Entry var3;
      for(Iterator var2 = this.fields.entrySet().iterator(); var2.hasNext(); var1 += ((UnknownFieldSet$Field)var3.getValue()).getSerializedSize(((Integer)var3.getKey()).intValue())) {
         var3 = (Entry)var2.next();
      }

      return var1;
   }

   public void writeAsMessageSetTo(CodedOutputStream var1) {
      Iterator var2 = this.fields.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         ((UnknownFieldSet$Field)var3.getValue()).writeAsMessageSetExtensionTo(((Integer)var3.getKey()).intValue(), var1);
      }

   }

   public int getSerializedSizeAsMessageSet() {
      int var1 = 0;

      Entry var3;
      for(Iterator var2 = this.fields.entrySet().iterator(); var2.hasNext(); var1 += ((UnknownFieldSet$Field)var3.getValue()).getSerializedSizeAsMessageSetExtension(((Integer)var3.getKey()).intValue())) {
         var3 = (Entry)var2.next();
      }

      return var1;
   }

   public boolean isInitialized() {
      return true;
   }

   public static UnknownFieldSet parseFrom(CodedInputStream var0) {
      return newBuilder().mergeFrom(var0).build();
   }

   public static UnknownFieldSet parseFrom(ByteString var0) {
      return newBuilder().mergeFrom(var0).build();
   }

   public static UnknownFieldSet parseFrom(byte[] var0) {
      return newBuilder().mergeFrom(var0).build();
   }

   public static UnknownFieldSet parseFrom(InputStream var0) {
      return newBuilder().mergeFrom(var0).build();
   }

   public UnknownFieldSet$Builder newBuilderForType() {
      return newBuilder();
   }

   public UnknownFieldSet$Builder toBuilder() {
      return newBuilder().mergeFrom(this);
   }

   public final UnknownFieldSet$Parser getParserForType() {
      return PARSER;
   }

   // $FF: synthetic method
   UnknownFieldSet(Map var1, UnknownFieldSet$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Map access$200(UnknownFieldSet var0) {
      return var0.fields;
   }
}
