package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSetLite$Builder;

public abstract class GeneratedMessageLite$Builder extends AbstractMessageLite$Builder {
   private final GeneratedMessageLite defaultInstance;
   protected GeneratedMessageLite instance;
   protected boolean isBuilt;

   protected GeneratedMessageLite$Builder(GeneratedMessageLite var1) {
      this.defaultInstance = var1;
      this.instance = (GeneratedMessageLite)var1.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_INSTANCE, new Object[0]);
      this.isBuilt = false;
   }

   protected void copyOnWrite() {
      if(this.isBuilt) {
         GeneratedMessageLite var1 = (GeneratedMessageLite)this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_INSTANCE, new Object[0]);
         var1.dynamicMethod(GeneratedMessageLite$MethodToInvoke.MERGE_FROM, new Object[]{this.instance});
         this.instance = var1;
         this.isBuilt = false;
      }

   }

   public final boolean isInitialized() {
      return GeneratedMessageLite.isInitialized(this.instance, false);
   }

   public final GeneratedMessageLite$Builder clear() {
      this.instance = (GeneratedMessageLite)this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_INSTANCE, new Object[0]);
      return this;
   }

   public GeneratedMessageLite$Builder clone() {
      GeneratedMessageLite$Builder var1 = this.getDefaultInstanceForType().newBuilderForType();
      var1.mergeFrom(this.buildPartial());
      return var1;
   }

   public GeneratedMessageLite buildPartial() {
      this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.MAKE_IMMUTABLE, new Object[0]);
      this.isBuilt = true;
      return this.instance;
   }

   public final GeneratedMessageLite build() {
      GeneratedMessageLite var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public GeneratedMessageLite$Builder mergeFrom(GeneratedMessageLite var1) {
      this.copyOnWrite();
      this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.MERGE_FROM, new Object[]{var1});
      return this;
   }

   public GeneratedMessageLite getDefaultInstanceForType() {
      return this.defaultInstance;
   }

   protected boolean parseUnknownField(CodedInputStream var1, UnknownFieldSetLite$Builder var2, ExtensionRegistryLite var3, int var4) {
      return var2.mergeFieldFrom(var4, var1);
   }

   public GeneratedMessageLite$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      GeneratedMessageLite var3 = null;

      try {
         var3 = (GeneratedMessageLite)this.getDefaultInstanceForType().getParserForType().parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var8) {
         var3 = (GeneratedMessageLite)var8.getUnfinishedMessage();
         throw var8;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }
}
