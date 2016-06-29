package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool$SearchFilter;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat$InvalidEscapeSequenceException;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;

public final class Descriptors$FieldDescriptor extends Descriptors$GenericDescriptor implements FieldSet$FieldDescriptorLite, Comparable {
   private static final WireFormat$FieldType[] table = WireFormat$FieldType.values();
   private final int index;
   private DescriptorProtos$FieldDescriptorProto proto;
   private final String fullName;
   private final Descriptors$FileDescriptor file;
   private final Descriptors$Descriptor extensionScope;
   private Descriptors$FieldDescriptor$Type type;
   private Descriptors$Descriptor containingType;
   private Descriptors$Descriptor messageType;
   private Descriptors$OneofDescriptor containingOneof;
   private Descriptors$EnumDescriptor enumType;
   private Object defaultValue;

   public int getIndex() {
      return this.index;
   }

   public DescriptorProtos$FieldDescriptorProto toProto() {
      return this.proto;
   }

   public String getName() {
      return this.proto.getName();
   }

   public int getNumber() {
      return this.proto.getNumber();
   }

   public String getFullName() {
      return this.fullName;
   }

   public Descriptors$FieldDescriptor$JavaType getJavaType() {
      return this.type.getJavaType();
   }

   public WireFormat$JavaType getLiteJavaType() {
      return this.getLiteType().getJavaType();
   }

   public Descriptors$FileDescriptor getFile() {
      return this.file;
   }

   public Descriptors$FieldDescriptor$Type getType() {
      return this.type;
   }

   public WireFormat$FieldType getLiteType() {
      return table[this.type.ordinal()];
   }

   public boolean needsUtf8Check() {
      return this.type == Descriptors$FieldDescriptor$Type.STRING && this.getFile().getOptions().getJavaStringCheckUtf8();
   }

   public boolean isMapField() {
      return this.getType() == Descriptors$FieldDescriptor$Type.MESSAGE && this.isRepeated() && this.getMessageType().getOptions().getMapEntry();
   }

   public boolean isRequired() {
      return this.proto.getLabel() == DescriptorProtos$FieldDescriptorProto$Label.LABEL_REQUIRED;
   }

   public boolean isOptional() {
      return this.proto.getLabel() == DescriptorProtos$FieldDescriptorProto$Label.LABEL_OPTIONAL;
   }

   public boolean isRepeated() {
      return this.proto.getLabel() == DescriptorProtos$FieldDescriptorProto$Label.LABEL_REPEATED;
   }

   public boolean isPacked() {
      return !this.isPackable()?false:(this.getFile().getSyntax() == Descriptors$FileDescriptor$Syntax.PROTO2?this.getOptions().getPacked():!this.getOptions().hasPacked() || this.getOptions().getPacked());
   }

   public boolean isPackable() {
      return this.isRepeated() && this.getLiteType().isPackable();
   }

   public boolean hasDefaultValue() {
      return this.proto.hasDefaultValue();
   }

   public Object getDefaultValue() {
      if(this.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
         throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
      } else {
         return this.defaultValue;
      }
   }

   public DescriptorProtos$FieldOptions getOptions() {
      return this.proto.getOptions();
   }

   public boolean isExtension() {
      return this.proto.hasExtendee();
   }

   public Descriptors$Descriptor getContainingType() {
      return this.containingType;
   }

   public Descriptors$OneofDescriptor getContainingOneof() {
      return this.containingOneof;
   }

   public Descriptors$Descriptor getExtensionScope() {
      if(!this.isExtension()) {
         throw new UnsupportedOperationException("This field is not an extension.");
      } else {
         return this.extensionScope;
      }
   }

   public Descriptors$Descriptor getMessageType() {
      if(this.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
         throw new UnsupportedOperationException("This field is not of message type.");
      } else {
         return this.messageType;
      }
   }

   public Descriptors$EnumDescriptor getEnumType() {
      if(this.getJavaType() != Descriptors$FieldDescriptor$JavaType.ENUM) {
         throw new UnsupportedOperationException("This field is not of enum type.");
      } else {
         return this.enumType;
      }
   }

   public int compareTo(Descriptors$FieldDescriptor var1) {
      if(var1.containingType != this.containingType) {
         throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
      } else {
         return this.getNumber() - var1.getNumber();
      }
   }

   public String toString() {
      return this.getFullName();
   }

   private Descriptors$FieldDescriptor(DescriptorProtos$FieldDescriptorProto var1, Descriptors$FileDescriptor var2, Descriptors$Descriptor var3, int var4, boolean var5) {
      // $FF: Couldn't be decompiled
   }

   private void crossLink() {
      // $FF: Couldn't be decompiled
   }

   private void setProto(DescriptorProtos$FieldDescriptorProto var1) {
      this.proto = var1;
   }

   public MessageLite$Builder internalMergeFrom(MessageLite$Builder var1, MessageLite var2) {
      return ((Message$Builder)var1).mergeFrom((Message)var2);
   }

   // $FF: synthetic method
   Descriptors$FieldDescriptor(DescriptorProtos$FieldDescriptorProto var1, Descriptors$FileDescriptor var2, Descriptors$Descriptor var3, int var4, boolean var5, Descriptors$1 var6) {
      this(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   static void access$900(Descriptors$FieldDescriptor var0) {
      var0.crossLink();
   }

   // $FF: synthetic method
   static void access$1300(Descriptors$FieldDescriptor var0, DescriptorProtos$FieldDescriptorProto var1) {
      var0.setProto(var1);
   }

   static {
      if(Descriptors$FieldDescriptor$Type.values().length != DescriptorProtos$FieldDescriptorProto$Type.values().length) {
         throw new RuntimeException("descriptor.proto has a new declared type but Desrciptors.java wasn\'t updated.");
      }
   }
}
