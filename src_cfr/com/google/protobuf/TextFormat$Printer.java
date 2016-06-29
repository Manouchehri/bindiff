/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.Descriptors$Descriptor;
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
import java.util.Map;
import java.util.Set;

final class TextFormat$Printer {
    boolean singleLineMode = false;
    boolean escapeNonAscii = true;

    private TextFormat$Printer() {
    }

    private TextFormat$Printer setSingleLineMode(boolean bl2) {
        this.singleLineMode = bl2;
        return this;
    }

    private TextFormat$Printer setEscapeNonAscii(boolean bl2) {
        this.escapeNonAscii = bl2;
        return this;
    }

    private void print(MessageOrBuilder messageOrBuilder, TextFormat$TextGenerator textGenerator) {
        Iterator iterator = messageOrBuilder.getAllFields().entrySet().iterator();
        do {
            if (!iterator.hasNext()) {
                this.printUnknownFields(messageOrBuilder.getUnknownFields(), textGenerator);
                return;
            }
            Map.Entry entry = iterator.next();
            this.printField((Descriptors$FieldDescriptor)entry.getKey(), entry.getValue(), textGenerator);
        } while (true);
    }

    private void printField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object, TextFormat$TextGenerator textGenerator) {
        if (!descriptors$FieldDescriptor.isRepeated()) {
            this.printSingleField(descriptors$FieldDescriptor, object, textGenerator);
            return;
        }
        Iterator iterator = ((List)object).iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            this.printSingleField(descriptors$FieldDescriptor, e2, textGenerator);
        }
    }

    private void printSingleField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object, TextFormat$TextGenerator textFormat$TextGenerator) {
        if (descriptors$FieldDescriptor.isExtension()) {
            textFormat$TextGenerator.print("[");
            if (descriptors$FieldDescriptor.getContainingType().getOptions().getMessageSetWireFormat() && descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.MESSAGE && descriptors$FieldDescriptor.isOptional() && descriptors$FieldDescriptor.getExtensionScope() == descriptors$FieldDescriptor.getMessageType()) {
                textFormat$TextGenerator.print(descriptors$FieldDescriptor.getMessageType().getFullName());
            } else {
                textFormat$TextGenerator.print(descriptors$FieldDescriptor.getFullName());
            }
            textFormat$TextGenerator.print("]");
        } else if (descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.GROUP) {
            textFormat$TextGenerator.print(descriptors$FieldDescriptor.getMessageType().getName());
        } else {
            textFormat$TextGenerator.print(descriptors$FieldDescriptor.getName());
        }
        if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            if (this.singleLineMode) {
                textFormat$TextGenerator.print(" { ");
            } else {
                textFormat$TextGenerator.print(" {\n");
                textFormat$TextGenerator.indent();
            }
        } else {
            textFormat$TextGenerator.print(": ");
        }
        this.printFieldValue(descriptors$FieldDescriptor, object, textFormat$TextGenerator);
        if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            if (this.singleLineMode) {
                textFormat$TextGenerator.print("} ");
                return;
            }
            textFormat$TextGenerator.outdent();
            textFormat$TextGenerator.print("}\n");
            return;
        }
        if (this.singleLineMode) {
            textFormat$TextGenerator.print(" ");
            return;
        }
        textFormat$TextGenerator.print("\n");
    }

    private void printFieldValue(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object, TextFormat$TextGenerator textFormat$TextGenerator) {
        switch (TextFormat$3.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[descriptors$FieldDescriptor.getType().ordinal()]) {
            case 1: 
            case 2: 
            case 3: {
                textFormat$TextGenerator.print(((Integer)object).toString());
                return;
            }
            case 4: 
            case 5: 
            case 6: {
                textFormat$TextGenerator.print(((Long)object).toString());
                return;
            }
            case 7: {
                textFormat$TextGenerator.print(((Boolean)object).toString());
                return;
            }
            case 8: {
                textFormat$TextGenerator.print(((Float)object).toString());
                return;
            }
            case 9: {
                textFormat$TextGenerator.print(((Double)object).toString());
                return;
            }
            case 10: 
            case 11: {
                textFormat$TextGenerator.print(TextFormat.unsignedToString((Integer)object));
                return;
            }
            case 12: 
            case 13: {
                textFormat$TextGenerator.print(TextFormat.unsignedToString((Long)object));
                return;
            }
            case 14: {
                textFormat$TextGenerator.print("\"");
                textFormat$TextGenerator.print(this.escapeNonAscii ? TextFormat.escapeText((String)object) : TextFormat.escapeDoubleQuotesAndBackslashes((String)object).replace("\n", "\\n"));
                textFormat$TextGenerator.print("\"");
                return;
            }
            case 15: {
                textFormat$TextGenerator.print("\"");
                if (object instanceof ByteString) {
                    textFormat$TextGenerator.print(TextFormat.escapeBytes((ByteString)object));
                } else {
                    textFormat$TextGenerator.print(TextFormat.escapeBytes((byte[])object));
                }
                textFormat$TextGenerator.print("\"");
                return;
            }
            case 16: {
                textFormat$TextGenerator.print(((Descriptors$EnumValueDescriptor)object).getName());
                return;
            }
            case 17: 
            case 18: {
                this.print((Message)object, textFormat$TextGenerator);
            }
        }
    }

    private void printUnknownFields(UnknownFieldSet unknownFieldSet, TextFormat$TextGenerator textFormat$TextGenerator) {
        Iterator iterator = unknownFieldSet.asMap().entrySet().iterator();
        block0 : while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            int n2 = (Integer)entry.getKey();
            UnknownFieldSet$Field unknownFieldSet$Field = (UnknownFieldSet$Field)entry.getValue();
            this.printUnknownField(n2, 0, unknownFieldSet$Field.getVarintList(), textFormat$TextGenerator);
            this.printUnknownField(n2, 5, unknownFieldSet$Field.getFixed32List(), textFormat$TextGenerator);
            this.printUnknownField(n2, 1, unknownFieldSet$Field.getFixed64List(), textFormat$TextGenerator);
            this.printUnknownField(n2, 2, unknownFieldSet$Field.getLengthDelimitedList(), textFormat$TextGenerator);
            Iterator iterator2 = unknownFieldSet$Field.getGroupList().iterator();
            do {
                if (!iterator2.hasNext()) continue block0;
                UnknownFieldSet unknownFieldSet2 = (UnknownFieldSet)iterator2.next();
                textFormat$TextGenerator.print(((Integer)entry.getKey()).toString());
                if (this.singleLineMode) {
                    textFormat$TextGenerator.print(" { ");
                } else {
                    textFormat$TextGenerator.print(" {\n");
                    textFormat$TextGenerator.indent();
                }
                this.printUnknownFields(unknownFieldSet2, textFormat$TextGenerator);
                if (this.singleLineMode) {
                    textFormat$TextGenerator.print("} ");
                    continue;
                }
                textFormat$TextGenerator.outdent();
                textFormat$TextGenerator.print("}\n");
            } while (true);
            break;
        }
        return;
    }

    private void printUnknownField(int n2, int n3, List list, TextFormat$TextGenerator textFormat$TextGenerator) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            textFormat$TextGenerator.print(String.valueOf(n2));
            textFormat$TextGenerator.print(": ");
            TextFormat.access$800(n3, e2, textFormat$TextGenerator);
            textFormat$TextGenerator.print(this.singleLineMode ? " " : "\n");
        }
    }

    /* synthetic */ TextFormat$Printer(TextFormat$1 textFormat$1) {
        this();
    }

    static /* synthetic */ TextFormat$Printer access$100(TextFormat$Printer textFormat$Printer, boolean bl2) {
        return textFormat$Printer.setSingleLineMode(bl2);
    }

    static /* synthetic */ TextFormat$Printer access$200(TextFormat$Printer textFormat$Printer, boolean bl2) {
        return textFormat$Printer.setEscapeNonAscii(bl2);
    }

    static /* synthetic */ void access$400(TextFormat$Printer textFormat$Printer, MessageOrBuilder messageOrBuilder, TextFormat$TextGenerator textFormat$TextGenerator) {
        textFormat$Printer.print(messageOrBuilder, textFormat$TextGenerator);
    }

    static /* synthetic */ void access$500(TextFormat$Printer textFormat$Printer, UnknownFieldSet unknownFieldSet, TextFormat$TextGenerator textFormat$TextGenerator) {
        textFormat$Printer.printUnknownFields(unknownFieldSet, textFormat$TextGenerator);
    }

    static /* synthetic */ void access$600(TextFormat$Printer textFormat$Printer, Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object, TextFormat$TextGenerator textFormat$TextGenerator) {
        textFormat$Printer.printField(descriptors$FieldDescriptor, object, textFormat$TextGenerator);
    }

    static /* synthetic */ void access$700(TextFormat$Printer textFormat$Printer, Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object, TextFormat$TextGenerator textFormat$TextGenerator) {
        textFormat$Printer.printFieldValue(descriptors$FieldDescriptor, object, textFormat$TextGenerator);
    }
}

