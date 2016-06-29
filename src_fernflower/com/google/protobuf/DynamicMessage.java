package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.DynamicMessage$1;
import com.google.protobuf.DynamicMessage$Builder;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.FieldSet;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public final class DynamicMessage extends AbstractMessage {
   private final Descriptors$Descriptor type;
   private final FieldSet fields;
   private final Descriptors$FieldDescriptor[] oneofCases;
   private final UnknownFieldSet unknownFields;
   private int memoizedSize = -1;

   DynamicMessage(Descriptors$Descriptor var1, FieldSet var2, Descriptors$FieldDescriptor[] var3, UnknownFieldSet var4) {
      this.type = var1;
      this.fields = var2;
      this.oneofCases = var3;
      this.unknownFields = var4;
   }

   public static DynamicMessage getDefaultInstance(Descriptors$Descriptor var0) {
      int var1 = var0.toProto().getOneofDeclCount();
      Descriptors$FieldDescriptor[] var2 = new Descriptors$FieldDescriptor[var1];
      return new DynamicMessage(var0, FieldSet.emptySet(), var2, UnknownFieldSet.getDefaultInstance());
   }

   public static DynamicMessage parseFrom(Descriptors$Descriptor var0, CodedInputStream var1) {
      return DynamicMessage$Builder.access$000((DynamicMessage$Builder)newBuilder(var0).mergeFrom((CodedInputStream)var1));
   }

   public static DynamicMessage parseFrom(Descriptors$Descriptor var0, CodedInputStream var1, ExtensionRegistry var2) {
      return DynamicMessage$Builder.access$000((DynamicMessage$Builder)newBuilder(var0).mergeFrom(var1, var2));
   }

   public static DynamicMessage parseFrom(Descriptors$Descriptor var0, ByteString var1) {
      return DynamicMessage$Builder.access$000((DynamicMessage$Builder)newBuilder(var0).mergeFrom((ByteString)var1));
   }

   public static DynamicMessage parseFrom(Descriptors$Descriptor var0, ByteString var1, ExtensionRegistry var2) {
      return DynamicMessage$Builder.access$000((DynamicMessage$Builder)newBuilder(var0).mergeFrom(var1, var2));
   }

   public static DynamicMessage parseFrom(Descriptors$Descriptor var0, byte[] var1) {
      return DynamicMessage$Builder.access$000((DynamicMessage$Builder)newBuilder(var0).mergeFrom((byte[])var1));
   }

   public static DynamicMessage parseFrom(Descriptors$Descriptor var0, byte[] var1, ExtensionRegistry var2) {
      return DynamicMessage$Builder.access$000((DynamicMessage$Builder)newBuilder(var0).mergeFrom(var1, var2));
   }

   public static DynamicMessage parseFrom(Descriptors$Descriptor var0, InputStream var1) {
      return DynamicMessage$Builder.access$000((DynamicMessage$Builder)newBuilder(var0).mergeFrom((InputStream)var1));
   }

   public static DynamicMessage parseFrom(Descriptors$Descriptor var0, InputStream var1, ExtensionRegistry var2) {
      return DynamicMessage$Builder.access$000((DynamicMessage$Builder)newBuilder(var0).mergeFrom(var1, var2));
   }

   public static DynamicMessage$Builder newBuilder(Descriptors$Descriptor var0) {
      return new DynamicMessage$Builder(var0, (DynamicMessage$1)null);
   }

   public static DynamicMessage$Builder newBuilder(Message var0) {
      return (new DynamicMessage$Builder(var0.getDescriptorForType(), (DynamicMessage$1)null)).mergeFrom(var0);
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return this.type;
   }

   public DynamicMessage getDefaultInstanceForType() {
      return getDefaultInstance(this.type);
   }

   public Map getAllFields() {
      return this.fields.getAllFields();
   }

   public boolean hasOneof(Descriptors$OneofDescriptor var1) {
      this.verifyOneofContainingType(var1);
      Descriptors$FieldDescriptor var2 = this.oneofCases[var1.getIndex()];
      return var2 != null;
   }

   public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor var1) {
      this.verifyOneofContainingType(var1);
      return this.oneofCases[var1.getIndex()];
   }

   public boolean hasField(Descriptors$FieldDescriptor var1) {
      this.verifyContainingType(var1);
      return this.fields.hasField(var1);
   }

   public Object getField(Descriptors$FieldDescriptor var1) {
      this.verifyContainingType(var1);
      Object var2 = this.fields.getField(var1);
      if(var2 == null) {
         if(var1.isRepeated()) {
            var2 = Collections.emptyList();
         } else if(var1.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            var2 = getDefaultInstance(var1.getMessageType());
         } else {
            var2 = var1.getDefaultValue();
         }
      }

      return var2;
   }

   public int getRepeatedFieldCount(Descriptors$FieldDescriptor var1) {
      this.verifyContainingType(var1);
      return this.fields.getRepeatedFieldCount(var1);
   }

   public Object getRepeatedField(Descriptors$FieldDescriptor var1, int var2) {
      this.verifyContainingType(var1);
      return this.fields.getRepeatedField(var1, var2);
   }

   public UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   static boolean isInitialized(Descriptors$Descriptor var0, FieldSet var1) {
      Iterator var2 = var0.getFields().iterator();

      Descriptors$FieldDescriptor var3;
      do {
         if(!var2.hasNext()) {
            return var1.isInitialized();
         }

         var3 = (Descriptors$FieldDescriptor)var2.next();
      } while(!var3.isRequired() || var1.hasField(var3));

      return false;
   }

   public boolean isInitialized() {
      return isInitialized(this.type, this.fields);
   }

   public void writeTo(CodedOutputStream var1) {
      if(this.type.getOptions().getMessageSetWireFormat()) {
         this.fields.writeMessageSetTo(var1);
         this.unknownFields.writeAsMessageSetTo(var1);
      } else {
         this.fields.writeTo(var1);
         this.unknownFields.writeTo(var1);
      }

   }

   public int getSerializedSize() {
      int var1 = this.memoizedSize;
      if(var1 != -1) {
         return var1;
      } else {
         if(this.type.getOptions().getMessageSetWireFormat()) {
            var1 = this.fields.getMessageSetSerializedSize();
            var1 += this.unknownFields.getSerializedSizeAsMessageSet();
         } else {
            var1 = this.fields.getSerializedSize();
            var1 += this.unknownFields.getSerializedSize();
         }

         this.memoizedSize = var1;
         return var1;
      }
   }

   public DynamicMessage$Builder newBuilderForType() {
      return new DynamicMessage$Builder(this.type, (DynamicMessage$1)null);
   }

   public DynamicMessage$Builder toBuilder() {
      return this.newBuilderForType().mergeFrom(this);
   }

   public Parser getParserForType() {
      return new DynamicMessage$1(this);
   }

   private void verifyContainingType(Descriptors$FieldDescriptor var1) {
      if(var1.getContainingType() != this.type) {
         throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
   }

   private void verifyOneofContainingType(Descriptors$OneofDescriptor var1) {
      if(var1.getContainingType() != this.type) {
         throw new IllegalArgumentException("OneofDescriptor does not match message type.");
      }
   }

   // $FF: synthetic method
   static Descriptors$Descriptor access$200(DynamicMessage var0) {
      return var0.type;
   }

   // $FF: synthetic method
   static FieldSet access$300(DynamicMessage var0) {
      return var0.fields;
   }

   // $FF: synthetic method
   static UnknownFieldSet access$400(DynamicMessage var0) {
      return var0.unknownFields;
   }

   // $FF: synthetic method
   static Descriptors$FieldDescriptor[] access$500(DynamicMessage var0) {
      return var0.oneofCases;
   }
}
