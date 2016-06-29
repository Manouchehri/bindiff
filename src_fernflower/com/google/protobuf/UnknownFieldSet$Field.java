package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$1;
import com.google.protobuf.UnknownFieldSet$Field$Builder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class UnknownFieldSet$Field {
   private static final UnknownFieldSet$Field fieldDefaultInstance = newBuilder().build();
   private List varint;
   private List fixed32;
   private List fixed64;
   private List lengthDelimited;
   private List group;

   private UnknownFieldSet$Field() {
   }

   public static UnknownFieldSet$Field$Builder newBuilder() {
      return UnknownFieldSet$Field$Builder.access$300();
   }

   public static UnknownFieldSet$Field$Builder newBuilder(UnknownFieldSet$Field var0) {
      return newBuilder().mergeFrom(var0);
   }

   public static UnknownFieldSet$Field getDefaultInstance() {
      return fieldDefaultInstance;
   }

   public List getVarintList() {
      return this.varint;
   }

   public List getFixed32List() {
      return this.fixed32;
   }

   public List getFixed64List() {
      return this.fixed64;
   }

   public List getLengthDelimitedList() {
      return this.lengthDelimited;
   }

   public List getGroupList() {
      return this.group;
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof UnknownFieldSet$Field)?false:Arrays.equals(this.getIdentityArray(), ((UnknownFieldSet$Field)var1).getIdentityArray()));
   }

   public int hashCode() {
      return Arrays.hashCode(this.getIdentityArray());
   }

   private Object[] getIdentityArray() {
      return new Object[]{this.varint, this.fixed32, this.fixed64, this.lengthDelimited, this.group};
   }

   public void writeTo(int var1, CodedOutputStream var2) {
      Iterator var3 = this.varint.iterator();

      long var4;
      while(var3.hasNext()) {
         var4 = ((Long)var3.next()).longValue();
         var2.writeUInt64(var1, var4);
      }

      var3 = this.fixed32.iterator();

      while(var3.hasNext()) {
         int var6 = ((Integer)var3.next()).intValue();
         var2.writeFixed32(var1, var6);
      }

      var3 = this.fixed64.iterator();

      while(var3.hasNext()) {
         var4 = ((Long)var3.next()).longValue();
         var2.writeFixed64(var1, var4);
      }

      var3 = this.lengthDelimited.iterator();

      while(var3.hasNext()) {
         ByteString var7 = (ByteString)var3.next();
         var2.writeBytes(var1, var7);
      }

      var3 = this.group.iterator();

      while(var3.hasNext()) {
         UnknownFieldSet var8 = (UnknownFieldSet)var3.next();
         var2.writeGroup(var1, var8);
      }

   }

   public int getSerializedSize(int var1) {
      int var2 = 0;

      Iterator var3;
      long var4;
      for(var3 = this.varint.iterator(); var3.hasNext(); var2 += CodedOutputStream.computeUInt64Size(var1, var4)) {
         var4 = ((Long)var3.next()).longValue();
      }

      int var6;
      for(var3 = this.fixed32.iterator(); var3.hasNext(); var2 += CodedOutputStream.computeFixed32Size(var1, var6)) {
         var6 = ((Integer)var3.next()).intValue();
      }

      for(var3 = this.fixed64.iterator(); var3.hasNext(); var2 += CodedOutputStream.computeFixed64Size(var1, var4)) {
         var4 = ((Long)var3.next()).longValue();
      }

      ByteString var7;
      for(var3 = this.lengthDelimited.iterator(); var3.hasNext(); var2 += CodedOutputStream.computeBytesSize(var1, var7)) {
         var7 = (ByteString)var3.next();
      }

      UnknownFieldSet var8;
      for(var3 = this.group.iterator(); var3.hasNext(); var2 += CodedOutputStream.computeGroupSize(var1, var8)) {
         var8 = (UnknownFieldSet)var3.next();
      }

      return var2;
   }

   public void writeAsMessageSetExtensionTo(int var1, CodedOutputStream var2) {
      Iterator var3 = this.lengthDelimited.iterator();

      while(var3.hasNext()) {
         ByteString var4 = (ByteString)var3.next();
         var2.writeRawMessageSetExtension(var1, var4);
      }

   }

   public int getSerializedSizeAsMessageSetExtension(int var1) {
      int var2 = 0;

      ByteString var4;
      for(Iterator var3 = this.lengthDelimited.iterator(); var3.hasNext(); var2 += CodedOutputStream.computeRawMessageSetExtensionSize(var1, var4)) {
         var4 = (ByteString)var3.next();
      }

      return var2;
   }

   // $FF: synthetic method
   UnknownFieldSet$Field(UnknownFieldSet$1 var1) {
      this();
   }

   // $FF: synthetic method
   static List access$500(UnknownFieldSet$Field var0) {
      return var0.varint;
   }

   // $FF: synthetic method
   static List access$502(UnknownFieldSet$Field var0, List var1) {
      return var0.varint = var1;
   }

   // $FF: synthetic method
   static List access$600(UnknownFieldSet$Field var0) {
      return var0.fixed32;
   }

   // $FF: synthetic method
   static List access$602(UnknownFieldSet$Field var0, List var1) {
      return var0.fixed32 = var1;
   }

   // $FF: synthetic method
   static List access$700(UnknownFieldSet$Field var0) {
      return var0.fixed64;
   }

   // $FF: synthetic method
   static List access$702(UnknownFieldSet$Field var0, List var1) {
      return var0.fixed64 = var1;
   }

   // $FF: synthetic method
   static List access$800(UnknownFieldSet$Field var0) {
      return var0.lengthDelimited;
   }

   // $FF: synthetic method
   static List access$802(UnknownFieldSet$Field var0, List var1) {
      return var0.lengthDelimited = var1;
   }

   // $FF: synthetic method
   static List access$900(UnknownFieldSet$Field var0) {
      return var0.group;
   }

   // $FF: synthetic method
   static List access$902(UnknownFieldSet$Field var0, List var1) {
      return var0.group = var1;
   }
}
