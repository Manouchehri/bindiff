package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$Builder$BuilderParentImpl;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class GeneratedMessage$Builder extends AbstractMessage$Builder {
   private GeneratedMessage$BuilderParent builderParent;
   private GeneratedMessage$Builder$BuilderParentImpl meAsParent;
   private boolean isClean;
   private UnknownFieldSet unknownFields;

   protected GeneratedMessage$Builder() {
      this((GeneratedMessage$BuilderParent)null);
   }

   protected GeneratedMessage$Builder(GeneratedMessage$BuilderParent var1) {
      this.unknownFields = UnknownFieldSet.getDefaultInstance();
      this.builderParent = var1;
   }

   void dispose() {
      this.builderParent = null;
   }

   protected void onBuilt() {
      if(this.builderParent != null) {
         this.markClean();
      }

   }

   protected void markClean() {
      this.isClean = true;
   }

   protected boolean isClean() {
      return this.isClean;
   }

   public GeneratedMessage$Builder clone() {
      GeneratedMessage$Builder var1 = (GeneratedMessage$Builder)this.getDefaultInstanceForType().newBuilderForType();
      var1.mergeFrom(this.buildPartial());
      return var1;
   }

   public GeneratedMessage$Builder clear() {
      this.unknownFields = UnknownFieldSet.getDefaultInstance();
      this.onChanged();
      return this;
   }

   protected abstract GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable();

   public Descriptors$Descriptor getDescriptorForType() {
      return GeneratedMessage$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable());
   }

   public Map getAllFields() {
      return Collections.unmodifiableMap(this.getAllFieldsMutable());
   }

   private Map getAllFieldsMutable() {
      TreeMap var1 = new TreeMap();
      Descriptors$Descriptor var2 = GeneratedMessage$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable());
      Iterator var3 = var2.getFields().iterator();

      while(var3.hasNext()) {
         Descriptors$FieldDescriptor var4 = (Descriptors$FieldDescriptor)var3.next();
         if(var4.isRepeated()) {
            List var5 = (List)this.getField(var4);
            if(!var5.isEmpty()) {
               var1.put(var4, var5);
            }
         } else if(this.hasField(var4)) {
            var1.put(var4, this.getField(var4));
         }
      }

      return var1;
   }

   public Message$Builder newBuilderForField(Descriptors$FieldDescriptor var1) {
      return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).newBuilder();
   }

   public Message$Builder getFieldBuilder(Descriptors$FieldDescriptor var1) {
      return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).getBuilder(this);
   }

   public Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor var1, int var2) {
      return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).getRepeatedBuilder(this, var2);
   }

   public boolean hasOneof(Descriptors$OneofDescriptor var1) {
      return GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), var1).has(this);
   }

   public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor var1) {
      return GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), var1).get(this);
   }

   public boolean hasField(Descriptors$FieldDescriptor var1) {
      return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).has(this);
   }

   public Object getField(Descriptors$FieldDescriptor var1) {
      Object var2 = GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).get(this);
      return var1.isRepeated()?Collections.unmodifiableList((List)var2):var2;
   }

   public GeneratedMessage$Builder setField(Descriptors$FieldDescriptor var1, Object var2) {
      GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).set(this, var2);
      return this;
   }

   public GeneratedMessage$Builder clearField(Descriptors$FieldDescriptor var1) {
      GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).clear(this);
      return this;
   }

   public GeneratedMessage$Builder clearOneof(Descriptors$OneofDescriptor var1) {
      GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), var1).clear(this);
      return this;
   }

   public int getRepeatedFieldCount(Descriptors$FieldDescriptor var1) {
      return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).getRepeatedCount(this);
   }

   public Object getRepeatedField(Descriptors$FieldDescriptor var1, int var2) {
      return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).getRepeated(this, var2);
   }

   public GeneratedMessage$Builder setRepeatedField(Descriptors$FieldDescriptor var1, int var2, Object var3) {
      GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).setRepeated(this, var2, var3);
      return this;
   }

   public GeneratedMessage$Builder addRepeatedField(Descriptors$FieldDescriptor var1, Object var2) {
      GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), var1).addRepeated(this, var2);
      return this;
   }

   public GeneratedMessage$Builder setUnknownFields(UnknownFieldSet var1) {
      this.unknownFields = var1;
      this.onChanged();
      return this;
   }

   public GeneratedMessage$Builder mergeUnknownFields(UnknownFieldSet var1) {
      this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(var1).build();
      this.onChanged();
      return this;
   }

   public boolean isInitialized() {
      Iterator var1 = this.getDescriptorForType().getFields().iterator();

      while(true) {
         while(true) {
            Descriptors$FieldDescriptor var2;
            do {
               if(!var1.hasNext()) {
                  return true;
               }

               var2 = (Descriptors$FieldDescriptor)var1.next();
               if(var2.isRequired() && !this.hasField(var2)) {
                  return false;
               }
            } while(var2.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE);

            if(var2.isRepeated()) {
               List var3 = (List)this.getField(var2);
               Iterator var4 = var3.iterator();

               while(var4.hasNext()) {
                  Message var5 = (Message)var4.next();
                  if(!var5.isInitialized()) {
                     return false;
                  }
               }
            } else if(this.hasField(var2) && !((Message)this.getField(var2)).isInitialized()) {
               return false;
            }
         }
      }
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   protected boolean parseUnknownField(CodedInputStream var1, UnknownFieldSet$Builder var2, ExtensionRegistryLite var3, int var4) {
      return var2.mergeFieldFrom(var4, var1);
   }

   protected GeneratedMessage$BuilderParent getParentForChildren() {
      if(this.meAsParent == null) {
         this.meAsParent = new GeneratedMessage$Builder$BuilderParentImpl(this, (GeneratedMessage$1)null);
      }

      return this.meAsParent;
   }

   protected final void onChanged() {
      if(this.isClean && this.builderParent != null) {
         this.builderParent.markDirty();
         this.isClean = false;
      }

   }

   protected MapField internalGetMapField(int var1) {
      // $FF: Couldn't be decompiled
   }

   protected MapField internalGetMutableMapField(int var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static Map access$900(GeneratedMessage$Builder var0) {
      return var0.getAllFieldsMutable();
   }
}
