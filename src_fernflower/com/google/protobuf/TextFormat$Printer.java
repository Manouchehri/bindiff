package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat$1;
import com.google.protobuf.TextFormat$3;
import com.google.protobuf.TextFormat$TextGenerator;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class TextFormat$Printer {
   boolean singleLineMode;
   boolean escapeNonAscii;

   private TextFormat$Printer() {
      this.singleLineMode = false;
      this.escapeNonAscii = true;
   }

   private TextFormat$Printer setSingleLineMode(boolean var1) {
      this.singleLineMode = var1;
      return this;
   }

   private TextFormat$Printer setEscapeNonAscii(boolean var1) {
      this.escapeNonAscii = var1;
      return this;
   }

   private void print(MessageOrBuilder var1, TextFormat$TextGenerator var2) {
      Iterator var3 = var1.getAllFields().entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         this.printField((Descriptors$FieldDescriptor)var4.getKey(), var4.getValue(), var2);
      }

      this.printUnknownFields(var1.getUnknownFields(), var2);
   }

   private void printField(Descriptors$FieldDescriptor var1, Object var2, TextFormat$TextGenerator var3) {
      if(var1.isRepeated()) {
         Iterator var4 = ((List)var2).iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            this.printSingleField(var1, var5, var3);
         }
      } else {
         this.printSingleField(var1, var2, var3);
      }

   }

   private void printSingleField(Descriptors$FieldDescriptor var1, Object var2, TextFormat$TextGenerator var3) {
      if(var1.isExtension()) {
         var3.print("[");
         if(var1.getContainingType().getOptions().getMessageSetWireFormat() && var1.getType() == Descriptors$FieldDescriptor$Type.MESSAGE && var1.isOptional() && var1.getExtensionScope() == var1.getMessageType()) {
            var3.print(var1.getMessageType().getFullName());
         } else {
            var3.print(var1.getFullName());
         }

         var3.print("]");
      } else if(var1.getType() == Descriptors$FieldDescriptor$Type.GROUP) {
         var3.print(var1.getMessageType().getName());
      } else {
         var3.print(var1.getName());
      }

      if(var1.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
         if(this.singleLineMode) {
            var3.print(" { ");
         } else {
            var3.print(" {\n");
            var3.indent();
         }
      } else {
         var3.print(": ");
      }

      this.printFieldValue(var1, var2, var3);
      if(var1.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
         if(this.singleLineMode) {
            var3.print("} ");
         } else {
            var3.outdent();
            var3.print("}\n");
         }
      } else if(this.singleLineMode) {
         var3.print(" ");
      } else {
         var3.print("\n");
      }

   }

   private void printFieldValue(Descriptors$FieldDescriptor var1, Object var2, TextFormat$TextGenerator var3) {
      switch(TextFormat$3.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[var1.getType().ordinal()]) {
      case 1:
      case 2:
      case 3:
         var3.print(((Integer)var2).toString());
         break;
      case 4:
      case 5:
      case 6:
         var3.print(((Long)var2).toString());
         break;
      case 7:
         var3.print(((Boolean)var2).toString());
         break;
      case 8:
         var3.print(((Float)var2).toString());
         break;
      case 9:
         var3.print(((Double)var2).toString());
         break;
      case 10:
      case 11:
         var3.print(TextFormat.unsignedToString(((Integer)var2).intValue()));
         break;
      case 12:
      case 13:
         var3.print(TextFormat.unsignedToString(((Long)var2).longValue()));
         break;
      case 14:
         var3.print("\"");
         var3.print(this.escapeNonAscii?TextFormat.escapeText((String)var2):TextFormat.escapeDoubleQuotesAndBackslashes((String)var2).replace("\n", "\\n"));
         var3.print("\"");
         break;
      case 15:
         var3.print("\"");
         if(var2 instanceof ByteString) {
            var3.print(TextFormat.escapeBytes((ByteString)var2));
         } else {
            var3.print(TextFormat.escapeBytes((byte[])((byte[])var2)));
         }

         var3.print("\"");
         break;
      case 16:
         var3.print(((Descriptors$EnumValueDescriptor)var2).getName());
         break;
      case 17:
      case 18:
         this.print((Message)var2, var3);
      }

   }

   private void printUnknownFields(UnknownFieldSet var1, TextFormat$TextGenerator var2) {
      Iterator var3 = var1.asMap().entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         int var5 = ((Integer)var4.getKey()).intValue();
         UnknownFieldSet$Field var6 = (UnknownFieldSet$Field)var4.getValue();
         this.printUnknownField(var5, 0, var6.getVarintList(), var2);
         this.printUnknownField(var5, 5, var6.getFixed32List(), var2);
         this.printUnknownField(var5, 1, var6.getFixed64List(), var2);
         this.printUnknownField(var5, 2, var6.getLengthDelimitedList(), var2);
         Iterator var7 = var6.getGroupList().iterator();

         while(var7.hasNext()) {
            UnknownFieldSet var8 = (UnknownFieldSet)var7.next();
            var2.print(((Integer)var4.getKey()).toString());
            if(this.singleLineMode) {
               var2.print(" { ");
            } else {
               var2.print(" {\n");
               var2.indent();
            }

            this.printUnknownFields(var8, var2);
            if(this.singleLineMode) {
               var2.print("} ");
            } else {
               var2.outdent();
               var2.print("}\n");
            }
         }
      }

   }

   private void printUnknownField(int var1, int var2, List var3, TextFormat$TextGenerator var4) {
      Iterator var5 = var3.iterator();

      while(var5.hasNext()) {
         Object var6 = var5.next();
         var4.print(String.valueOf(var1));
         var4.print(": ");
         TextFormat.access$800(var2, var6, var4);
         var4.print(this.singleLineMode?" ":"\n");
      }

   }

   // $FF: synthetic method
   TextFormat$Printer(TextFormat$1 var1) {
      this();
   }

   // $FF: synthetic method
   static TextFormat$Printer access$100(TextFormat$Printer var0, boolean var1) {
      return var0.setSingleLineMode(var1);
   }

   // $FF: synthetic method
   static TextFormat$Printer access$200(TextFormat$Printer var0, boolean var1) {
      return var0.setEscapeNonAscii(var1);
   }

   // $FF: synthetic method
   static void access$400(TextFormat$Printer var0, MessageOrBuilder var1, TextFormat$TextGenerator var2) {
      var0.print(var1, var2);
   }

   // $FF: synthetic method
   static void access$500(TextFormat$Printer var0, UnknownFieldSet var1, TextFormat$TextGenerator var2) {
      var0.printUnknownFields(var1, var2);
   }

   // $FF: synthetic method
   static void access$600(TextFormat$Printer var0, Descriptors$FieldDescriptor var1, Object var2, TextFormat$TextGenerator var3) {
      var0.printField(var1, var2, var3);
   }

   // $FF: synthetic method
   static void access$700(TextFormat$Printer var0, Descriptors$FieldDescriptor var1, Object var2, TextFormat$TextGenerator var3) {
      var0.printFieldValue(var1, var2, var3);
   }
}
