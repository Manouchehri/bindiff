package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$DescriptorPool;
import com.google.protobuf.Descriptors$DescriptorPool$DescriptorIntPair;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Descriptors$Descriptor extends Descriptors$GenericDescriptor {
   private final int index;
   private DescriptorProtos$DescriptorProto proto;
   private final String fullName;
   private final Descriptors$FileDescriptor file;
   private final Descriptors$Descriptor containingType;
   private final Descriptors$Descriptor[] nestedTypes;
   private final Descriptors$EnumDescriptor[] enumTypes;
   private final Descriptors$FieldDescriptor[] fields;
   private final Descriptors$FieldDescriptor[] extensions;
   private final Descriptors$OneofDescriptor[] oneofs;

   public int getIndex() {
      return this.index;
   }

   public DescriptorProtos$DescriptorProto toProto() {
      return this.proto;
   }

   public String getName() {
      return this.proto.getName();
   }

   public String getFullName() {
      return this.fullName;
   }

   public Descriptors$FileDescriptor getFile() {
      return this.file;
   }

   public Descriptors$Descriptor getContainingType() {
      return this.containingType;
   }

   public DescriptorProtos$MessageOptions getOptions() {
      return this.proto.getOptions();
   }

   public List getFields() {
      return Collections.unmodifiableList(Arrays.asList(this.fields));
   }

   public List getOneofs() {
      return Collections.unmodifiableList(Arrays.asList(this.oneofs));
   }

   public List getExtensions() {
      return Collections.unmodifiableList(Arrays.asList(this.extensions));
   }

   public List getNestedTypes() {
      return Collections.unmodifiableList(Arrays.asList(this.nestedTypes));
   }

   public List getEnumTypes() {
      return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
   }

   public boolean isExtensionNumber(int var1) {
      Iterator var2 = this.proto.getExtensionRangeList().iterator();

      DescriptorProtos$DescriptorProto$ExtensionRange var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (DescriptorProtos$DescriptorProto$ExtensionRange)var2.next();
      } while(var3.getStart() > var1 || var1 >= var3.getEnd());

      return true;
   }

   public boolean isReservedNumber(int var1) {
      Iterator var2 = this.proto.getReservedRangeList().iterator();

      DescriptorProtos$DescriptorProto$ReservedRange var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (DescriptorProtos$DescriptorProto$ReservedRange)var2.next();
      } while(var3.getStart() > var1 || var1 >= var3.getEnd());

      return true;
   }

   public boolean isReservedName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         Iterator var2 = this.proto.getReservedNameList().iterator();

         String var3;
         do {
            if(!var2.hasNext()) {
               return false;
            }

            var3 = (String)var2.next();
         } while(!var3.equals(var1));

         return true;
      }
   }

   public boolean isExtendable() {
      return this.proto.getExtensionRangeList().size() != 0;
   }

   public Descriptors$FieldDescriptor findFieldByName(String var1) {
      Descriptors$DescriptorPool var10000 = Descriptors$FileDescriptor.access$1400(this.file);
      String var3 = String.valueOf(String.valueOf(this.fullName));
      String var4 = String.valueOf(String.valueOf(var1));
      Descriptors$GenericDescriptor var2 = var10000.findSymbol((new StringBuilder(1 + var3.length() + var4.length())).append(var3).append(".").append(var4).toString());
      return var2 != null && var2 instanceof Descriptors$FieldDescriptor?(Descriptors$FieldDescriptor)var2:null;
   }

   public Descriptors$FieldDescriptor findFieldByNumber(int var1) {
      return (Descriptors$FieldDescriptor)Descriptors$DescriptorPool.access$1500(Descriptors$FileDescriptor.access$1400(this.file)).get(new Descriptors$DescriptorPool$DescriptorIntPair(this, var1));
   }

   public Descriptors$Descriptor findNestedTypeByName(String var1) {
      Descriptors$DescriptorPool var10000 = Descriptors$FileDescriptor.access$1400(this.file);
      String var3 = String.valueOf(String.valueOf(this.fullName));
      String var4 = String.valueOf(String.valueOf(var1));
      Descriptors$GenericDescriptor var2 = var10000.findSymbol((new StringBuilder(1 + var3.length() + var4.length())).append(var3).append(".").append(var4).toString());
      return var2 != null && var2 instanceof Descriptors$Descriptor?(Descriptors$Descriptor)var2:null;
   }

   public Descriptors$EnumDescriptor findEnumTypeByName(String var1) {
      Descriptors$DescriptorPool var10000 = Descriptors$FileDescriptor.access$1400(this.file);
      String var3 = String.valueOf(String.valueOf(this.fullName));
      String var4 = String.valueOf(String.valueOf(var1));
      Descriptors$GenericDescriptor var2 = var10000.findSymbol((new StringBuilder(1 + var3.length() + var4.length())).append(var3).append(".").append(var4).toString());
      return var2 != null && var2 instanceof Descriptors$EnumDescriptor?(Descriptors$EnumDescriptor)var2:null;
   }

   Descriptors$Descriptor(String var1) {
      String var2 = var1;
      String var3 = "";
      int var4 = var1.lastIndexOf(46);
      if(var4 != -1) {
         var2 = var1.substring(var4 + 1);
         var3 = var1.substring(0, var4);
      }

      this.index = 0;
      this.proto = DescriptorProtos$DescriptorProto.newBuilder().setName(var2).addExtensionRange(DescriptorProtos$DescriptorProto$ExtensionRange.newBuilder().setStart(1).setEnd(536870912).build()).build();
      this.fullName = var1;
      this.containingType = null;
      this.nestedTypes = new Descriptors$Descriptor[0];
      this.enumTypes = new Descriptors$EnumDescriptor[0];
      this.fields = new Descriptors$FieldDescriptor[0];
      this.extensions = new Descriptors$FieldDescriptor[0];
      this.oneofs = new Descriptors$OneofDescriptor[0];
      this.file = new Descriptors$FileDescriptor(var3, this);
   }

   private Descriptors$Descriptor(DescriptorProtos$DescriptorProto var1, Descriptors$FileDescriptor var2, Descriptors$Descriptor var3, int var4) {
      this.index = var4;
      this.proto = var1;
      this.fullName = Descriptors.access$1600(var2, var3, var1.getName());
      this.file = var2;
      this.containingType = var3;
      this.oneofs = new Descriptors$OneofDescriptor[var1.getOneofDeclCount()];

      int var5;
      for(var5 = 0; var5 < var1.getOneofDeclCount(); ++var5) {
         this.oneofs[var5] = new Descriptors$OneofDescriptor(var1.getOneofDecl(var5), var2, this, var5, (Descriptors$1)null);
      }

      this.nestedTypes = new Descriptors$Descriptor[var1.getNestedTypeCount()];

      for(var5 = 0; var5 < var1.getNestedTypeCount(); ++var5) {
         this.nestedTypes[var5] = new Descriptors$Descriptor(var1.getNestedType(var5), var2, this, var5);
      }

      this.enumTypes = new Descriptors$EnumDescriptor[var1.getEnumTypeCount()];

      for(var5 = 0; var5 < var1.getEnumTypeCount(); ++var5) {
         this.enumTypes[var5] = new Descriptors$EnumDescriptor(var1.getEnumType(var5), var2, this, var5, (Descriptors$1)null);
      }

      this.fields = new Descriptors$FieldDescriptor[var1.getFieldCount()];

      for(var5 = 0; var5 < var1.getFieldCount(); ++var5) {
         this.fields[var5] = new Descriptors$FieldDescriptor(var1.getField(var5), var2, this, var5, false, (Descriptors$1)null);
      }

      this.extensions = new Descriptors$FieldDescriptor[var1.getExtensionCount()];

      for(var5 = 0; var5 < var1.getExtensionCount(); ++var5) {
         this.extensions[var5] = new Descriptors$FieldDescriptor(var1.getExtension(var5), var2, this, var5, true, (Descriptors$1)null);
      }

      for(var5 = 0; var5 < var1.getOneofDeclCount(); ++var5) {
         Descriptors$OneofDescriptor.access$1802(this.oneofs[var5], new Descriptors$FieldDescriptor[this.oneofs[var5].getFieldCount()]);
         Descriptors$OneofDescriptor.access$1902(this.oneofs[var5], 0);
      }

      for(var5 = 0; var5 < var1.getFieldCount(); ++var5) {
         Descriptors$OneofDescriptor var6 = this.fields[var5].getContainingOneof();
         if(var6 != null) {
            Descriptors$OneofDescriptor.access$1800(var6)[Descriptors$OneofDescriptor.access$1908(var6)] = this.fields[var5];
         }
      }

      Descriptors$FileDescriptor.access$1400(var2).addSymbol(this);
   }

   private void crossLink() {
      Descriptors$Descriptor[] var1 = this.nestedTypes;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         Descriptors$Descriptor var4 = var1[var3];
         var4.crossLink();
      }

      Descriptors$FieldDescriptor[] var5 = this.fields;
      var2 = var5.length;

      Descriptors$FieldDescriptor var6;
      for(var3 = 0; var3 < var2; ++var3) {
         var6 = var5[var3];
         Descriptors$FieldDescriptor.access$900(var6);
      }

      var5 = this.extensions;
      var2 = var5.length;

      for(var3 = 0; var3 < var2; ++var3) {
         var6 = var5[var3];
         Descriptors$FieldDescriptor.access$900(var6);
      }

   }

   private void setProto(DescriptorProtos$DescriptorProto var1) {
      this.proto = var1;

      int var2;
      for(var2 = 0; var2 < this.nestedTypes.length; ++var2) {
         this.nestedTypes[var2].setProto(var1.getNestedType(var2));
      }

      for(var2 = 0; var2 < this.enumTypes.length; ++var2) {
         Descriptors$EnumDescriptor.access$1100(this.enumTypes[var2], var1.getEnumType(var2));
      }

      for(var2 = 0; var2 < this.fields.length; ++var2) {
         Descriptors$FieldDescriptor.access$1300(this.fields[var2], var1.getField(var2));
      }

      for(var2 = 0; var2 < this.extensions.length; ++var2) {
         Descriptors$FieldDescriptor.access$1300(this.extensions[var2], var1.getExtension(var2));
      }

   }

   // $FF: synthetic method
   Descriptors$Descriptor(DescriptorProtos$DescriptorProto var1, Descriptors$FileDescriptor var2, Descriptors$Descriptor var3, int var4, Descriptors$1 var5) {
      this(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   static void access$700(Descriptors$Descriptor var0) {
      var0.crossLink();
   }

   // $FF: synthetic method
   static void access$1000(Descriptors$Descriptor var0, DescriptorProtos$DescriptorProto var1) {
      var0.setProto(var1);
   }
}
