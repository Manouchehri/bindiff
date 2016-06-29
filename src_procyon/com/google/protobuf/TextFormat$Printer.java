package com.google.protobuf;

import java.util.logging.*;
import java.io.*;
import java.util.*;
import java.math.*;

final class TextFormat$Printer
{
    boolean singleLineMode;
    boolean escapeNonAscii;
    
    private TextFormat$Printer() {
        this.singleLineMode = false;
        this.escapeNonAscii = true;
    }
    
    private TextFormat$Printer setSingleLineMode(final boolean singleLineMode) {
        this.singleLineMode = singleLineMode;
        return this;
    }
    
    private TextFormat$Printer setEscapeNonAscii(final boolean escapeNonAscii) {
        this.escapeNonAscii = escapeNonAscii;
        return this;
    }
    
    private void print(final MessageOrBuilder messageOrBuilder, final TextFormat$TextGenerator textFormat$TextGenerator) {
        for (final Map.Entry<Descriptors$FieldDescriptor, V> entry : messageOrBuilder.getAllFields().entrySet()) {
            this.printField(entry.getKey(), entry.getValue(), textFormat$TextGenerator);
        }
        this.printUnknownFields(messageOrBuilder.getUnknownFields(), textFormat$TextGenerator);
    }
    
    private void printField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o, final TextFormat$TextGenerator textFormat$TextGenerator) {
        if (descriptors$FieldDescriptor.isRepeated()) {
            final Iterator<Object> iterator = ((List)o).iterator();
            while (iterator.hasNext()) {
                this.printSingleField(descriptors$FieldDescriptor, iterator.next(), textFormat$TextGenerator);
            }
        }
        else {
            this.printSingleField(descriptors$FieldDescriptor, o, textFormat$TextGenerator);
        }
    }
    
    private void printSingleField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o, final TextFormat$TextGenerator textFormat$TextGenerator) {
        if (descriptors$FieldDescriptor.isExtension()) {
            textFormat$TextGenerator.print("[");
            if (descriptors$FieldDescriptor.getContainingType().getOptions().getMessageSetWireFormat() && descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.MESSAGE && descriptors$FieldDescriptor.isOptional() && descriptors$FieldDescriptor.getExtensionScope() == descriptors$FieldDescriptor.getMessageType()) {
                textFormat$TextGenerator.print(descriptors$FieldDescriptor.getMessageType().getFullName());
            }
            else {
                textFormat$TextGenerator.print(descriptors$FieldDescriptor.getFullName());
            }
            textFormat$TextGenerator.print("]");
        }
        else if (descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.GROUP) {
            textFormat$TextGenerator.print(descriptors$FieldDescriptor.getMessageType().getName());
        }
        else {
            textFormat$TextGenerator.print(descriptors$FieldDescriptor.getName());
        }
        if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            if (this.singleLineMode) {
                textFormat$TextGenerator.print(" { ");
            }
            else {
                textFormat$TextGenerator.print(" {\n");
                textFormat$TextGenerator.indent();
            }
        }
        else {
            textFormat$TextGenerator.print(": ");
        }
        this.printFieldValue(descriptors$FieldDescriptor, o, textFormat$TextGenerator);
        if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            if (this.singleLineMode) {
                textFormat$TextGenerator.print("} ");
            }
            else {
                textFormat$TextGenerator.outdent();
                textFormat$TextGenerator.print("}\n");
            }
        }
        else if (this.singleLineMode) {
            textFormat$TextGenerator.print(" ");
        }
        else {
            textFormat$TextGenerator.print("\n");
        }
    }
    
    private void printFieldValue(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o, final TextFormat$TextGenerator textFormat$TextGenerator) {
        switch (TextFormat$3.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[descriptors$FieldDescriptor.getType().ordinal()]) {
            case 1:
            case 2:
            case 3: {
                textFormat$TextGenerator.print(((Integer)o).toString());
                break;
            }
            case 4:
            case 5:
            case 6: {
                textFormat$TextGenerator.print(((Long)o).toString());
                break;
            }
            case 7: {
                textFormat$TextGenerator.print(((Boolean)o).toString());
                break;
            }
            case 8: {
                textFormat$TextGenerator.print(((Float)o).toString());
                break;
            }
            case 9: {
                textFormat$TextGenerator.print(((Double)o).toString());
                break;
            }
            case 10:
            case 11: {
                textFormat$TextGenerator.print(TextFormat.unsignedToString((int)o));
                break;
            }
            case 12:
            case 13: {
                textFormat$TextGenerator.print(TextFormat.unsignedToString((long)o));
                break;
            }
            case 14: {
                textFormat$TextGenerator.print("\"");
                textFormat$TextGenerator.print(this.escapeNonAscii ? TextFormat.escapeText((String)o) : TextFormat.escapeDoubleQuotesAndBackslashes((String)o).replace("\n", "\\n"));
                textFormat$TextGenerator.print("\"");
                break;
            }
            case 15: {
                textFormat$TextGenerator.print("\"");
                if (o instanceof ByteString) {
                    textFormat$TextGenerator.print(TextFormat.escapeBytes((ByteString)o));
                }
                else {
                    textFormat$TextGenerator.print(TextFormat.escapeBytes((byte[])o));
                }
                textFormat$TextGenerator.print("\"");
                break;
            }
            case 16: {
                textFormat$TextGenerator.print(((Descriptors$EnumValueDescriptor)o).getName());
                break;
            }
            case 17:
            case 18: {
                this.print((MessageOrBuilder)o, textFormat$TextGenerator);
                break;
            }
        }
    }
    
    private void printUnknownFields(final UnknownFieldSet set, final TextFormat$TextGenerator textFormat$TextGenerator) {
        for (final Map.Entry<Integer, V> entry : set.asMap().entrySet()) {
            final int intValue = entry.getKey();
            final UnknownFieldSet$Field unknownFieldSet$Field = (UnknownFieldSet$Field)entry.getValue();
            this.printUnknownField(intValue, 0, unknownFieldSet$Field.getVarintList(), textFormat$TextGenerator);
            this.printUnknownField(intValue, 5, unknownFieldSet$Field.getFixed32List(), textFormat$TextGenerator);
            this.printUnknownField(intValue, 1, unknownFieldSet$Field.getFixed64List(), textFormat$TextGenerator);
            this.printUnknownField(intValue, 2, unknownFieldSet$Field.getLengthDelimitedList(), textFormat$TextGenerator);
            for (final UnknownFieldSet set2 : unknownFieldSet$Field.getGroupList()) {
                textFormat$TextGenerator.print(entry.getKey().toString());
                if (this.singleLineMode) {
                    textFormat$TextGenerator.print(" { ");
                }
                else {
                    textFormat$TextGenerator.print(" {\n");
                    textFormat$TextGenerator.indent();
                }
                this.printUnknownFields(set2, textFormat$TextGenerator);
                if (this.singleLineMode) {
                    textFormat$TextGenerator.print("} ");
                }
                else {
                    textFormat$TextGenerator.outdent();
                    textFormat$TextGenerator.print("}\n");
                }
            }
        }
    }
    
    private void printUnknownField(final int n, final int n2, final List list, final TextFormat$TextGenerator textFormat$TextGenerator) {
        for (final Object next : list) {
            textFormat$TextGenerator.print(String.valueOf(n));
            textFormat$TextGenerator.print(": ");
            printUnknownFieldValue(n2, next, textFormat$TextGenerator);
            textFormat$TextGenerator.print(this.singleLineMode ? " " : "\n");
        }
    }
}
