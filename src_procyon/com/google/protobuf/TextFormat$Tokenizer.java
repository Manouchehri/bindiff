package com.google.protobuf;

import java.util.regex.*;
import java.util.*;

final class TextFormat$Tokenizer
{
    private final CharSequence text;
    private final Matcher matcher;
    private String currentToken;
    private int pos;
    private int line;
    private int column;
    private int previousLine;
    private int previousColumn;
    private static final Pattern WHITESPACE;
    private static final Pattern TOKEN;
    private static final Pattern DOUBLE_INFINITY;
    private static final Pattern FLOAT_INFINITY;
    private static final Pattern FLOAT_NAN;
    
    private TextFormat$Tokenizer(final CharSequence text) {
        this.pos = 0;
        this.line = 0;
        this.column = 0;
        this.previousLine = 0;
        this.previousColumn = 0;
        this.text = text;
        this.matcher = TextFormat$Tokenizer.WHITESPACE.matcher(text);
        this.skipWhitespace();
        this.nextToken();
    }
    
    public boolean atEnd() {
        return this.currentToken.length() == 0;
    }
    
    public void nextToken() {
        this.previousLine = this.line;
        this.previousColumn = this.column;
        while (this.pos < this.matcher.regionStart()) {
            if (this.text.charAt(this.pos) == '\n') {
                ++this.line;
                this.column = 0;
            }
            else {
                ++this.column;
            }
            ++this.pos;
        }
        if (this.matcher.regionStart() == this.matcher.regionEnd()) {
            this.currentToken = "";
        }
        else {
            this.matcher.usePattern(TextFormat$Tokenizer.TOKEN);
            if (this.matcher.lookingAt()) {
                this.currentToken = this.matcher.group();
                this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
            }
            else {
                this.currentToken = String.valueOf(this.text.charAt(this.pos));
                this.matcher.region(this.pos + 1, this.matcher.regionEnd());
            }
            this.skipWhitespace();
        }
    }
    
    private void skipWhitespace() {
        this.matcher.usePattern(TextFormat$Tokenizer.WHITESPACE);
        if (this.matcher.lookingAt()) {
            this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
        }
    }
    
    public boolean tryConsume(final String s) {
        if (this.currentToken.equals(s)) {
            this.nextToken();
            return true;
        }
        return false;
    }
    
    public void consume(final String s) {
        if (!this.tryConsume(s)) {
            final String value = String.valueOf(String.valueOf(s));
            throw this.parseException(new StringBuilder(12 + value.length()).append("Expected \"").append(value).append("\".").toString());
        }
    }
    
    public boolean lookingAtInteger() {
        if (this.currentToken.length() == 0) {
            return false;
        }
        final char char1 = this.currentToken.charAt(0);
        return ('0' <= char1 && char1 <= '9') || char1 == '-' || char1 == '+';
    }
    
    public boolean lookingAt(final String s) {
        return this.currentToken.equals(s);
    }
    
    public String consumeIdentifier() {
        for (int i = 0; i < this.currentToken.length(); ++i) {
            final char char1 = this.currentToken.charAt(i);
            if (('a' > char1 || char1 > 'z') && ('A' > char1 || char1 > 'Z') && ('0' > char1 || char1 > '9') && char1 != '_' && char1 != '.') {
                final String value = String.valueOf(String.valueOf(this.currentToken));
                throw this.parseException(new StringBuilder(29 + value.length()).append("Expected identifier. Found '").append(value).append("'").toString());
            }
        }
        final String currentToken = this.currentToken;
        this.nextToken();
        return currentToken;
    }
    
    public boolean tryConsumeIdentifier() {
        try {
            this.consumeIdentifier();
            return true;
        }
        catch (TextFormat$ParseException ex) {
            return false;
        }
    }
    
    public int consumeInt32() {
        try {
            final int int32 = TextFormat.parseInt32(this.currentToken);
            this.nextToken();
            return int32;
        }
        catch (NumberFormatException ex) {
            throw this.integerParseException(ex);
        }
    }
    
    public int consumeUInt32() {
        try {
            final int uInt32 = TextFormat.parseUInt32(this.currentToken);
            this.nextToken();
            return uInt32;
        }
        catch (NumberFormatException ex) {
            throw this.integerParseException(ex);
        }
    }
    
    public long consumeInt64() {
        try {
            final long int64 = TextFormat.parseInt64(this.currentToken);
            this.nextToken();
            return int64;
        }
        catch (NumberFormatException ex) {
            throw this.integerParseException(ex);
        }
    }
    
    public boolean tryConsumeInt64() {
        try {
            this.consumeInt64();
            return true;
        }
        catch (TextFormat$ParseException ex) {
            return false;
        }
    }
    
    public long consumeUInt64() {
        try {
            final long uInt64 = TextFormat.parseUInt64(this.currentToken);
            this.nextToken();
            return uInt64;
        }
        catch (NumberFormatException ex) {
            throw this.integerParseException(ex);
        }
    }
    
    public boolean tryConsumeUInt64() {
        try {
            this.consumeUInt64();
            return true;
        }
        catch (TextFormat$ParseException ex) {
            return false;
        }
    }
    
    public double consumeDouble() {
        if (TextFormat$Tokenizer.DOUBLE_INFINITY.matcher(this.currentToken).matches()) {
            final boolean startsWith = this.currentToken.startsWith("-");
            this.nextToken();
            return startsWith ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        if (this.currentToken.equalsIgnoreCase("nan")) {
            this.nextToken();
            return Double.NaN;
        }
        try {
            final double double1 = Double.parseDouble(this.currentToken);
            this.nextToken();
            return double1;
        }
        catch (NumberFormatException ex) {
            throw this.floatParseException(ex);
        }
    }
    
    public boolean tryConsumeDouble() {
        try {
            this.consumeDouble();
            return true;
        }
        catch (TextFormat$ParseException ex) {
            return false;
        }
    }
    
    public float consumeFloat() {
        if (TextFormat$Tokenizer.FLOAT_INFINITY.matcher(this.currentToken).matches()) {
            final boolean startsWith = this.currentToken.startsWith("-");
            this.nextToken();
            return startsWith ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
        }
        if (TextFormat$Tokenizer.FLOAT_NAN.matcher(this.currentToken).matches()) {
            this.nextToken();
            return Float.NaN;
        }
        try {
            final float float1 = Float.parseFloat(this.currentToken);
            this.nextToken();
            return float1;
        }
        catch (NumberFormatException ex) {
            throw this.floatParseException(ex);
        }
    }
    
    public boolean tryConsumeFloat() {
        try {
            this.consumeFloat();
            return true;
        }
        catch (TextFormat$ParseException ex) {
            return false;
        }
    }
    
    public boolean consumeBoolean() {
        if (this.currentToken.equals("true") || this.currentToken.equals("t") || this.currentToken.equals("1")) {
            this.nextToken();
            return true;
        }
        if (this.currentToken.equals("false") || this.currentToken.equals("f") || this.currentToken.equals("0")) {
            this.nextToken();
            return false;
        }
        throw this.parseException("Expected \"true\" or \"false\".");
    }
    
    public String consumeString() {
        return this.consumeByteString().toStringUtf8();
    }
    
    public boolean tryConsumeString() {
        try {
            this.consumeString();
            return true;
        }
        catch (TextFormat$ParseException ex) {
            return false;
        }
    }
    
    public ByteString consumeByteString() {
        final ArrayList list = new ArrayList();
        this.consumeByteString(list);
        while (this.currentToken.startsWith("'") || this.currentToken.startsWith("\"")) {
            this.consumeByteString(list);
        }
        return ByteString.copyFrom(list);
    }
    
    private void consumeByteString(final List list) {
        final char c = (this.currentToken.length() > 0) ? this.currentToken.charAt(0) : '\0';
        if (c != '\"' && c != '\'') {
            throw this.parseException("Expected string.");
        }
        if (this.currentToken.length() < 2 || this.currentToken.charAt(this.currentToken.length() - 1) != c) {
            throw this.parseException("String missing ending quote.");
        }
        try {
            final ByteString unescapeBytes = TextFormat.unescapeBytes(this.currentToken.substring(1, this.currentToken.length() - 1));
            this.nextToken();
            list.add(unescapeBytes);
        }
        catch (TextFormat$InvalidEscapeSequenceException ex) {
            throw this.parseException(ex.getMessage());
        }
    }
    
    public TextFormat$ParseException parseException(final String s) {
        return new TextFormat$ParseException(this.line + 1, this.column + 1, s);
    }
    
    public TextFormat$ParseException parseExceptionPreviousToken(final String s) {
        return new TextFormat$ParseException(this.previousLine + 1, this.previousColumn + 1, s);
    }
    
    private TextFormat$ParseException integerParseException(final NumberFormatException ex) {
        final String s = "Couldn't parse integer: ";
        final String value = String.valueOf(ex.getMessage());
        return this.parseException((value.length() != 0) ? s.concat(value) : new String(s));
    }
    
    private TextFormat$ParseException floatParseException(final NumberFormatException ex) {
        final String s = "Couldn't parse number: ";
        final String value = String.valueOf(ex.getMessage());
        return this.parseException((value.length() != 0) ? s.concat(value) : new String(s));
    }
    
    static {
        WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
        TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
        DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
        FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
        FLOAT_NAN = Pattern.compile("nanf?", 2);
    }
}
