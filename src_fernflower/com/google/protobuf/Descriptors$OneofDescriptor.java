package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Descriptors$OneofDescriptor {
   private final int index;
   private DescriptorProtos$OneofDescriptorProto proto;
   private final String fullName;
   private final Descriptors$FileDescriptor file;
   private Descriptors$Descriptor containingType;
   private int fieldCount;
   private Descriptors$FieldDescriptor[] fields;

   public int getIndex() {
      return this.index;
   }

   public String getName() {
      return this.proto.getName();
   }

   public Descriptors$FileDescriptor getFile() {
      return this.file;
   }

   public String getFullName() {
      return this.fullName;
   }

   public Descriptors$Descriptor getContainingType() {
      return this.containingType;
   }

   public int getFieldCount() {
      return this.fieldCount;
   }

   public List getFields() {
      return Collections.unmodifiableList(Arrays.asList(this.fields));
   }

   public Descriptors$FieldDescriptor getField(int var1) {
      return this.fields[var1];
   }

   private Descriptors$OneofDescriptor(DescriptorProtos$OneofDescriptorProto var1, Descriptors$FileDescriptor var2, Descriptors$Descriptor var3, int var4) {
      this.proto = var1;
      this.fullName = Descriptors.access$1600(var2, var3, var1.getName());
      this.file = var2;
      this.index = var4;
      this.containingType = var3;
      this.fieldCount = 0;
   }

   // $FF: synthetic method
   Descriptors$OneofDescriptor(DescriptorProtos$OneofDescriptorProto var1, Descriptors$FileDescriptor var2, Descriptors$Descriptor var3, int var4, Descriptors$1 var5) {
      this(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   static Descriptors$FieldDescriptor[] access$1802(Descriptors$OneofDescriptor var0, Descriptors$FieldDescriptor[] var1) {
      return var0.fields = var1;
   }

   // $FF: synthetic method
   static int access$1902(Descriptors$OneofDescriptor var0, int var1) {
      return var0.fieldCount = var1;
   }

   // $FF: synthetic method
   static Descriptors$FieldDescriptor[] access$1800(Descriptors$OneofDescriptor var0) {
      return var0.fields;
   }

   // $FF: synthetic method
   static int access$1908(Descriptors$OneofDescriptor var0) {
      return var0.fieldCount++;
   }
}
