package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageReflection$BuilderAdapter;
import com.google.protobuf.MessageReflection$MergeTarget;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat$1;
import com.google.protobuf.TextFormat$3;
import com.google.protobuf.TextFormat$Parser$Builder;
import com.google.protobuf.TextFormat$Parser$SingularOverwritePolicy;
import com.google.protobuf.TextFormat$Tokenizer;
import java.nio.CharBuffer;
import java.util.Locale;
import java.util.logging.Logger;

public class TextFormat$Parser {
   private final boolean allowUnknownFields;
   private final TextFormat$Parser$SingularOverwritePolicy singularOverwritePolicy;
   private static final int BUFFER_SIZE = 4096;

   private TextFormat$Parser(boolean var1, TextFormat$Parser$SingularOverwritePolicy var2) {
      this.allowUnknownFields = var1;
      this.singularOverwritePolicy = var2;
   }

   public static TextFormat$Parser$Builder newBuilder() {
      return new TextFormat$Parser$Builder();
   }

   public void merge(Readable var1, Message$Builder var2) {
      this.merge(var1, ExtensionRegistry.getEmptyRegistry(), var2);
   }

   public void merge(CharSequence var1, Message$Builder var2) {
      this.merge(var1, ExtensionRegistry.getEmptyRegistry(), var2);
   }

   public void merge(Readable var1, ExtensionRegistry var2, Message$Builder var3) {
      this.merge((CharSequence)toStringBuilder(var1), var2, var3);
   }

   private static StringBuilder toStringBuilder(Readable var0) {
      StringBuilder var1 = new StringBuilder();
      CharBuffer var2 = CharBuffer.allocate(4096);

      while(true) {
         int var3 = var0.read(var2);
         if(var3 == -1) {
            return var1;
         }

         var2.flip();
         var1.append(var2, 0, var3);
      }
   }

   public void merge(CharSequence var1, ExtensionRegistry var2, Message$Builder var3) {
      TextFormat$Tokenizer var4 = new TextFormat$Tokenizer(var1, (TextFormat$1)null);
      MessageReflection$BuilderAdapter var5 = new MessageReflection$BuilderAdapter(var3);

      while(!var4.atEnd()) {
         this.mergeField(var4, var2, var5);
      }

   }

   private void mergeField(TextFormat$Tokenizer var1, ExtensionRegistry var2, MessageReflection$MergeTarget var3) {
      Descriptors$FieldDescriptor var4 = null;
      Descriptors$Descriptor var5 = var3.getDescriptorForType();
      ExtensionRegistry$ExtensionInfo var6 = null;
      Logger var10000;
      String var8;
      String var9;
      if(var1.tryConsume("[")) {
         StringBuilder var7 = new StringBuilder(var1.consumeIdentifier());

         while(var1.tryConsume(".")) {
            var7.append('.');
            var7.append(var1.consumeIdentifier());
         }

         var6 = var3.findExtensionByName(var2, var7.toString());
         if(var6 == null) {
            if(!this.allowUnknownFields) {
               var8 = String.valueOf(String.valueOf(var7));
               throw var1.parseExceptionPreviousToken((new StringBuilder(48 + var8.length())).append("Extension \"").append(var8).append("\" not found in the ExtensionRegistry.").toString());
            }

            var10000 = TextFormat.access$1100();
            var8 = String.valueOf(String.valueOf(var7));
            var10000.warning((new StringBuilder(48 + var8.length())).append("Extension \"").append(var8).append("\" not found in the ExtensionRegistry.").toString());
         } else {
            if(var6.descriptor.getContainingType() != var5) {
               var8 = String.valueOf(String.valueOf(var7));
               var9 = String.valueOf(String.valueOf(var5.getFullName()));
               throw var1.parseExceptionPreviousToken((new StringBuilder(45 + var8.length() + var9.length())).append("Extension \"").append(var8).append("\" does not extend message type \"").append(var9).append("\".").toString());
            }

            var4 = var6.descriptor;
         }

         var1.consume("]");
      } else {
         String var10 = var1.consumeIdentifier();
         var4 = var5.findFieldByName(var10);
         if(var4 == null) {
            var8 = var10.toLowerCase(Locale.US);
            var4 = var5.findFieldByName(var8);
            if(var4 != null && var4.getType() != Descriptors$FieldDescriptor$Type.GROUP) {
               var4 = null;
            }
         }

         if(var4 != null && var4.getType() == Descriptors$FieldDescriptor$Type.GROUP && !var4.getMessageType().getName().equals(var10)) {
            var4 = null;
         }

         if(var4 == null) {
            if(!this.allowUnknownFields) {
               var8 = String.valueOf(String.valueOf(var5.getFullName()));
               var9 = String.valueOf(String.valueOf(var10));
               throw var1.parseExceptionPreviousToken((new StringBuilder(38 + var8.length() + var9.length())).append("Message type \"").append(var8).append("\" has no field named \"").append(var9).append("\".").toString());
            }

            var10000 = TextFormat.access$1100();
            var8 = String.valueOf(String.valueOf(var5.getFullName()));
            var9 = String.valueOf(String.valueOf(var10));
            var10000.warning((new StringBuilder(38 + var8.length() + var9.length())).append("Message type \"").append(var8).append("\" has no field named \"").append(var9).append("\".").toString());
         }
      }

      if(var4 == null) {
         if(var1.tryConsume(":") && !var1.lookingAt("{") && !var1.lookingAt("<")) {
            this.skipFieldValue(var1);
         } else {
            this.skipFieldMessage(var1);
         }

      } else {
         if(var4.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            var1.tryConsume(":");
         } else {
            var1.consume(":");
         }

         if(var4.isRepeated() && var1.tryConsume("[")) {
            while(true) {
               this.consumeFieldValue(var1, var2, var3, var4, var6);
               if(var1.tryConsume("]")) {
                  break;
               }

               var1.consume(",");
            }
         } else {
            this.consumeFieldValue(var1, var2, var3, var4, var6);
         }

         if(!var1.tryConsume(";")) {
            var1.tryConsume(",");
         }

      }
   }

   private void consumeFieldValue(TextFormat$Tokenizer var1, ExtensionRegistry var2, MessageReflection$MergeTarget var3, Descriptors$FieldDescriptor var4, ExtensionRegistry$ExtensionInfo var5) {
      Object var6 = null;
      String var7;
      String var9;
      String var10;
      String var14;
      if(var4.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
         if(var1.tryConsume("<")) {
            var7 = ">";
         } else {
            var1.consume("{");
            var7 = "}";
         }

         MessageReflection$MergeTarget var8 = var3.newMergeTargetForField(var4, var5 == null?null:var5.defaultInstance);

         while(!var1.tryConsume(var7)) {
            if(var1.atEnd()) {
               var9 = String.valueOf(String.valueOf(var7));
               throw var1.parseException((new StringBuilder(12 + var9.length())).append("Expected \"").append(var9).append("\".").toString());
            }

            this.mergeField(var1, var2, var8);
         }

         var6 = var8.finish();
      } else {
         switch(TextFormat$3.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[var4.getType().ordinal()]) {
         case 1:
         case 2:
         case 3:
            var6 = Integer.valueOf(var1.consumeInt32());
            break;
         case 4:
         case 5:
         case 6:
            var6 = Long.valueOf(var1.consumeInt64());
            break;
         case 7:
            var6 = Boolean.valueOf(var1.consumeBoolean());
            break;
         case 8:
            var6 = Float.valueOf(var1.consumeFloat());
            break;
         case 9:
            var6 = Double.valueOf(var1.consumeDouble());
            break;
         case 10:
         case 11:
            var6 = Integer.valueOf(var1.consumeUInt32());
            break;
         case 12:
         case 13:
            var6 = Long.valueOf(var1.consumeUInt64());
            break;
         case 14:
            var6 = var1.consumeString();
            break;
         case 15:
            var6 = var1.consumeByteString();
            break;
         case 16:
            Descriptors$EnumDescriptor var11 = var4.getEnumType();
            if(var1.lookingAtInteger()) {
               int var12 = var1.consumeInt32();
               var6 = var11.findValueByNumber(var12);
               if(var6 == null) {
                  var9 = String.valueOf(String.valueOf(var11.getFullName()));
                  throw var1.parseExceptionPreviousToken((new StringBuilder(50 + var9.length())).append("Enum type \"").append(var9).append("\" has no value with number ").append(var12).append(".").toString());
               }
            } else {
               var14 = var1.consumeIdentifier();
               var6 = var11.findValueByName(var14);
               if(var6 == null) {
                  var9 = String.valueOf(String.valueOf(var11.getFullName()));
                  var10 = String.valueOf(String.valueOf(var14));
                  throw var1.parseExceptionPreviousToken((new StringBuilder(35 + var9.length() + var10.length())).append("Enum type \"").append(var9).append("\" has no value named \"").append(var10).append("\".").toString());
               }
            }
            break;
         case 17:
         case 18:
            throw new RuntimeException("Can\'t get here.");
         }
      }

      if(var4.isRepeated()) {
         var3.addRepeatedField(var4, var6);
      } else {
         if(this.singularOverwritePolicy == TextFormat$Parser$SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES && var3.hasField(var4)) {
            var7 = String.valueOf(String.valueOf(var4.getFullName()));
            throw var1.parseExceptionPreviousToken((new StringBuilder(44 + var7.length())).append("Non-repeated field \"").append(var7).append("\" cannot be overwritten.").toString());
         }

         if(this.singularOverwritePolicy == TextFormat$Parser$SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES && var4.getContainingOneof() != null && var3.hasOneof(var4.getContainingOneof())) {
            Descriptors$OneofDescriptor var13 = var4.getContainingOneof();
            var14 = String.valueOf(String.valueOf(var4.getFullName()));
            var9 = String.valueOf(String.valueOf(var3.getOneofFieldDescriptor(var13).getFullName()));
            var10 = String.valueOf(String.valueOf(var13.getName()));
            throw var1.parseExceptionPreviousToken((new StringBuilder(70 + var14.length() + var9.length() + var10.length())).append("Field \"").append(var14).append("\" is specified along with field \"").append(var9).append("\", another member of oneof \"").append(var10).append("\".").toString());
         }

         var3.setField(var4, var6);
      }

   }

   private void skipField(TextFormat$Tokenizer var1) {
      if(var1.tryConsume("[")) {
         do {
            var1.consumeIdentifier();
         } while(var1.tryConsume("."));

         var1.consume("]");
      } else {
         var1.consumeIdentifier();
      }

      if(var1.tryConsume(":") && !var1.lookingAt("<") && !var1.lookingAt("{")) {
         this.skipFieldValue(var1);
      } else {
         this.skipFieldMessage(var1);
      }

      if(!var1.tryConsume(";")) {
         var1.tryConsume(",");
      }

   }

   private void skipFieldMessage(TextFormat$Tokenizer var1) {
      String var2;
      if(var1.tryConsume("<")) {
         var2 = ">";
      } else {
         var1.consume("{");
         var2 = "}";
      }

      while(!var1.lookingAt(">") && !var1.lookingAt("}")) {
         this.skipField(var1);
      }

      var1.consume(var2);
   }

   private void skipFieldValue(TextFormat$Tokenizer var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   TextFormat$Parser(boolean var1, TextFormat$Parser$SingularOverwritePolicy var2, TextFormat$1 var3) {
      this(var1, var2);
   }
}
