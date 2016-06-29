package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.MessageOrBuilder;

public class SingleFieldBuilder implements GeneratedMessage$BuilderParent {
   private GeneratedMessage$BuilderParent parent;
   private GeneratedMessage$Builder builder;
   private GeneratedMessage message;
   private boolean isClean;

   public SingleFieldBuilder(GeneratedMessage var1, GeneratedMessage$BuilderParent var2, boolean var3) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.message = var1;
         this.parent = var2;
         this.isClean = var3;
      }
   }

   public void dispose() {
      this.parent = null;
   }

   public GeneratedMessage getMessage() {
      if(this.message == null) {
         this.message = (GeneratedMessage)this.builder.buildPartial();
      }

      return this.message;
   }

   public GeneratedMessage build() {
      this.isClean = true;
      return this.getMessage();
   }

   public GeneratedMessage$Builder getBuilder() {
      if(this.builder == null) {
         this.builder = (GeneratedMessage$Builder)this.message.newBuilderForType(this);
         this.builder.mergeFrom(this.message);
         this.builder.markClean();
      }

      return this.builder;
   }

   public MessageOrBuilder getMessageOrBuilder() {
      return (MessageOrBuilder)(this.builder != null?this.builder:this.message);
   }

   public SingleFieldBuilder setMessage(GeneratedMessage var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.message = var1;
         if(this.builder != null) {
            this.builder.dispose();
            this.builder = null;
         }

         this.onChanged();
         return this;
      }
   }

   public SingleFieldBuilder mergeFrom(GeneratedMessage var1) {
      if(this.builder == null && this.message == this.message.getDefaultInstanceForType()) {
         this.message = var1;
      } else {
         this.getBuilder().mergeFrom(var1);
      }

      this.onChanged();
      return this;
   }

   public SingleFieldBuilder clear() {
      this.message = (GeneratedMessage)((GeneratedMessage)(this.message != null?this.message.getDefaultInstanceForType():this.builder.getDefaultInstanceForType()));
      if(this.builder != null) {
         this.builder.dispose();
         this.builder = null;
      }

      this.onChanged();
      return this;
   }

   private void onChanged() {
      if(this.builder != null) {
         this.message = null;
      }

      if(this.isClean && this.parent != null) {
         this.parent.markDirty();
         this.isClean = false;
      }

   }

   public void markDirty() {
      this.onChanged();
   }
}
