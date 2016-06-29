package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool;
import com.google.protobuf.Descriptors$DescriptorPool$DescriptorIntPair;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

public final class Descriptors$EnumDescriptor extends Descriptors$GenericDescriptor implements Internal$EnumLiteMap {
   private final int index;
   private DescriptorProtos$EnumDescriptorProto proto;
   private final String fullName;
   private final Descriptors$FileDescriptor file;
   private final Descriptors$Descriptor containingType;
   private Descriptors$EnumValueDescriptor[] values;
   private final WeakHashMap unknownValues;

   public int getIndex() {
      return this.index;
   }

   public DescriptorProtos$EnumDescriptorProto toProto() {
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

   public DescriptorProtos$EnumOptions getOptions() {
      return this.proto.getOptions();
   }

   public List getValues() {
      return Collections.unmodifiableList(Arrays.asList(this.values));
   }

   public Descriptors$EnumValueDescriptor findValueByName(String var1) {
      Descriptors$DescriptorPool var10000 = Descriptors$FileDescriptor.access$1400(this.file);
      String var3 = String.valueOf(String.valueOf(this.fullName));
      String var4 = String.valueOf(String.valueOf(var1));
      Descriptors$GenericDescriptor var2 = var10000.findSymbol((new StringBuilder(1 + var3.length() + var4.length())).append(var3).append(".").append(var4).toString());
      return var2 != null && var2 instanceof Descriptors$EnumValueDescriptor?(Descriptors$EnumValueDescriptor)var2:null;
   }

   public Descriptors$EnumValueDescriptor findValueByNumber(int var1) {
      return (Descriptors$EnumValueDescriptor)Descriptors$DescriptorPool.access$2300(Descriptors$FileDescriptor.access$1400(this.file)).get(new Descriptors$DescriptorPool$DescriptorIntPair(this, var1));
   }

   public Descriptors$EnumValueDescriptor findValueByNumberCreatingIfUnknown(int var1) {
      Descriptors$EnumValueDescriptor var2 = this.findValueByNumber(var1);
      if(var2 != null) {
         return var2;
      } else {
         synchronized(this) {
            Integer var4 = new Integer(var1);
            WeakReference var5 = (WeakReference)this.unknownValues.get(var4);
            if(var5 != null) {
               var2 = (Descriptors$EnumValueDescriptor)var5.get();
            }

            if(var2 == null) {
               var2 = new Descriptors$EnumValueDescriptor(this.file, this, var4, (Descriptors$1)null);
               this.unknownValues.put(var4, new WeakReference(var2));
            }

            return var2;
         }
      }
   }

   int getUnknownEnumValueDescriptorCount() {
      return this.unknownValues.size();
   }

   private Descriptors$EnumDescriptor(DescriptorProtos$EnumDescriptorProto var1, Descriptors$FileDescriptor var2, Descriptors$Descriptor var3, int var4) {
      this.unknownValues = new WeakHashMap();
      this.index = var4;
      this.proto = var1;
      this.fullName = Descriptors.access$1600(var2, var3, var1.getName());
      this.file = var2;
      this.containingType = var3;
      if(var1.getValueCount() == 0) {
         throw new Descriptors$DescriptorValidationException(this, "Enums must contain at least one value.", (Descriptors$1)null);
      } else {
         this.values = new Descriptors$EnumValueDescriptor[var1.getValueCount()];

         for(int var5 = 0; var5 < var1.getValueCount(); ++var5) {
            this.values[var5] = new Descriptors$EnumValueDescriptor(var1.getValue(var5), var2, this, var5, (Descriptors$1)null);
         }

         Descriptors$FileDescriptor.access$1400(var2).addSymbol(this);
      }
   }

   private void setProto(DescriptorProtos$EnumDescriptorProto var1) {
      this.proto = var1;

      for(int var2 = 0; var2 < this.values.length; ++var2) {
         Descriptors$EnumValueDescriptor.access$2600(this.values[var2], var1.getValue(var2));
      }

   }

   // $FF: synthetic method
   Descriptors$EnumDescriptor(DescriptorProtos$EnumDescriptorProto var1, Descriptors$FileDescriptor var2, Descriptors$Descriptor var3, int var4, Descriptors$1 var5) {
      this(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   static void access$1100(Descriptors$EnumDescriptor var0, DescriptorProtos$EnumDescriptorProto var1) {
      var0.setProto(var1);
   }
}
