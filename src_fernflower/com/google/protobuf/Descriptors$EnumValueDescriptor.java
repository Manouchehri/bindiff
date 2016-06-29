package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueOptions;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Internal$EnumLite;

public final class Descriptors$EnumValueDescriptor extends Descriptors$GenericDescriptor implements Internal$EnumLite {
   private final int index;
   private DescriptorProtos$EnumValueDescriptorProto proto;
   private final String fullName;
   private final Descriptors$FileDescriptor file;
   private final Descriptors$EnumDescriptor type;
   private Integer number;

   public int getIndex() {
      return this.index;
   }

   public DescriptorProtos$EnumValueDescriptorProto toProto() {
      return this.proto;
   }

   public String getName() {
      return this.proto.getName();
   }

   public int getNumber() {
      return this.proto.getNumber();
   }

   public String toString() {
      return this.proto.getName();
   }

   public String getFullName() {
      return this.fullName;
   }

   public Descriptors$FileDescriptor getFile() {
      return this.file;
   }

   public Descriptors$EnumDescriptor getType() {
      return this.type;
   }

   public DescriptorProtos$EnumValueOptions getOptions() {
      return this.proto.getOptions();
   }

   private Descriptors$EnumValueDescriptor(DescriptorProtos$EnumValueDescriptorProto var1, Descriptors$FileDescriptor var2, Descriptors$EnumDescriptor var3, int var4) {
      this.index = var4;
      this.proto = var1;
      this.file = var2;
      this.type = var3;
      String var5 = String.valueOf(String.valueOf(var3.getFullName()));
      String var6 = String.valueOf(String.valueOf(var1.getName()));
      this.fullName = (new StringBuilder(1 + var5.length() + var6.length())).append(var5).append(".").append(var6).toString();
      Descriptors$FileDescriptor.access$1400(var2).addSymbol(this);
      Descriptors$FileDescriptor.access$1400(var2).addEnumValueByNumber(this);
   }

   private Descriptors$EnumValueDescriptor(Descriptors$FileDescriptor var1, Descriptors$EnumDescriptor var2, Integer var3) {
      String var5 = String.valueOf(String.valueOf(var2.getName()));
      String var6 = String.valueOf(String.valueOf(var3));
      String var4 = (new StringBuilder(20 + var5.length() + var6.length())).append("UNKNOWN_ENUM_VALUE_").append(var5).append("_").append(var6).toString();
      DescriptorProtos$EnumValueDescriptorProto var7 = DescriptorProtos$EnumValueDescriptorProto.newBuilder().setName(var4).setNumber(var3.intValue()).build();
      this.index = -1;
      this.proto = var7;
      this.file = var1;
      this.type = var2;
      String var8 = String.valueOf(String.valueOf(var2.getFullName()));
      String var9 = String.valueOf(String.valueOf(var7.getName()));
      this.fullName = (new StringBuilder(1 + var8.length() + var9.length())).append(var8).append(".").append(var9).toString();
      this.number = var3;
   }

   private void setProto(DescriptorProtos$EnumValueDescriptorProto var1) {
      this.proto = var1;
   }

   // $FF: synthetic method
   Descriptors$EnumValueDescriptor(Descriptors$FileDescriptor var1, Descriptors$EnumDescriptor var2, Integer var3, Descriptors$1 var4) {
      this(var1, var2, var3);
   }

   // $FF: synthetic method
   Descriptors$EnumValueDescriptor(DescriptorProtos$EnumValueDescriptorProto var1, Descriptors$FileDescriptor var2, Descriptors$EnumDescriptor var3, int var4, Descriptors$1 var5) {
      this(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   static void access$2600(Descriptors$EnumValueDescriptor var0, DescriptorProtos$EnumValueDescriptorProto var1) {
      var0.setProto(var1);
   }
}
