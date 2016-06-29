/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat$1;
import com.google.protobuf.TextFormat$InvalidEscapeSequenceException;
import com.google.protobuf.TextFormat$ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class TextFormat$Tokenizer {
    private final CharSequence text;
    private final Matcher matcher;
    private String currentToken;
    private int pos = 0;
    private int line = 0;
    private int column = 0;
    private int previousLine = 0;
    private int previousColumn = 0;
    private static final Pattern WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
    private static final Pattern TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
    private static final Pattern DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
    private static final Pattern FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
    private static final Pattern FLOAT_NAN = Pattern.compile("nanf?", 2);

    private TextFormat$Tokenizer(CharSequence charSequence) {
        this.text = charSequence;
        this.matcher = WHITESPACE.matcher(charSequence);
        this.skipWhitespace();
        this.nextToken();
    }

    public boolean atEnd() {
        if (this.currentToken.length() != 0) return false;
        return true;
    }

    public void nextToken() {
        this.previousLine = this.line;
        this.previousColumn = this.column;
        while (this.pos < this.matcher.regionStart()) {
            if (this.text.charAt(this.pos) == '\n') {
                ++this.line;
                this.column = 0;
            } else {
                ++this.column;
            }
            ++this.pos;
        }
        if (this.matcher.regionStart() == this.matcher.regionEnd()) {
            this.currentToken = "";
            return;
        }
        this.matcher.usePattern(TOKEN);
        if (this.matcher.lookingAt()) {
            this.currentToken = this.matcher.group();
            this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
        } else {
            this.currentToken = String.valueOf(this.text.charAt(this.pos));
            this.matcher.region(this.pos + 1, this.matcher.regionEnd());
        }
        this.skipWhitespace();
    }

    private void skipWhitespace() {
        this.matcher.usePattern(WHITESPACE);
        if (!this.matcher.lookingAt()) return;
        this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
    }

    public boolean tryConsume(String string) {
        if (!this.currentToken.equals(string)) return false;
        this.nextToken();
        return true;
    }

    public void consume(String string) {
        if (this.tryConsume(string)) return;
        String string2 = String.valueOf(String.valueOf(string));
        throw this.parseException(new StringBuilder(12 + string2.length()).append("Expected \"").append(string2).append("\".").toString());
    }

    public boolean lookingAtInteger() {
        if (this.currentToken.length() == 0) {
            return false;
        }
        char c2 = this.currentToken.charAt(0);
        if ('0' <= c2) {
            if (c2 <= '9') return true;
        }
        if (c2 == '-') return true;
        if (c2 == '+') return true;
        return false;
    }

    public boolean lookingAt(String string) {
        return this.currentToken.equals(string);
    }

    public String consumeIdentifier() {
        int n2 = 0;
        do {
            if (n2 >= this.currentToken.length()) {
                String string = this.currentToken;
                this.nextToken();
                return string;
            }
            char c2 = this.currentToken.charAt(n2);
            if (!('a' <= c2 && c2 <= 'z' || 'A' <= c2 && c2 <= 'Z' || '0' <= c2 && c2 <= '9' || c2 == '_' || c2 == '.')) {
                String string = String.valueOf(String.valueOf(this.currentToken));
                throw this.parseException(new StringBuilder(29 + string.length()).append("Expected identifier. Found '").append(string).append("'").toString());
            }
            ++n2;
        } while (true);
    }

    public boolean tryConsumeIdentifier() {
        try {
            this.consumeIdentifier();
            return true;
        }
        catch (TextFormat$ParseException var1_1) {
            return false;
        }
    }

    public int consumeInt32() {
        try {
            int n2 = TextFormat.parseInt32(this.currentToken);
            this.nextToken();
            return n2;
        }
        catch (NumberFormatException var1_2) {
            throw this.integerParseException(var1_2);
        }
    }

    public int consumeUInt32() {
        try {
            int n2 = TextFormat.parseUInt32(this.currentToken);
            this.nextToken();
            return n2;
        }
        catch (NumberFormatException var1_2) {
            throw this.integerParseException(var1_2);
        }
    }

    public long consumeInt64() {
        try {
            long l2 = TextFormat.parseInt64(this.currentToken);
            this.nextToken();
            return l2;
        }
        catch (NumberFormatException var1_2) {
            throw this.integerParseException(var1_2);
        }
    }

    public boolean tryConsumeInt64() {
        try {
            this.consumeInt64();
            return true;
        }
        catch (TextFormat$ParseException var1_1) {
            return false;
        }
    }

    public long consumeUInt64() {
        try {
            long l2 = TextFormat.parseUInt64(this.currentToken);
            this.nextToken();
            return l2;
        }
        catch (NumberFormatException var1_2) {
            throw this.integerParseException(var1_2);
        }
    }

    public boolean tryConsumeUInt64() {
        try {
            this.consumeUInt64();
            return true;
        }
        catch (TextFormat$ParseException var1_1) {
            return false;
        }
    }

    public double consumeDouble() {
        if (DOUBLE_INFINITY.matcher(this.currentToken).matches()) {
            boolean bl2 = this.currentToken.startsWith("-");
            this.nextToken();
            if (!bl2) return Double.POSITIVE_INFINITY;
            return Double.NEGATIVE_INFINITY;
        }
        if (this.currentToken.equalsIgnoreCase("nan")) {
            this.nextToken();
            return Double.NaN;
        }
        try {
            double d2 = Double.parseDouble(this.currentToken);
            this.nextToken();
            return d2;
        }
        catch (NumberFormatException var1_3) {
            throw this.floatParseException(var1_3);
        }
    }

    public boolean tryConsumeDouble() {
        try {
            this.consumeDouble();
            return true;
        }
        catch (TextFormat$ParseException var1_1) {
            return false;
        }
    }

    public float consumeFloat() {
        if (FLOAT_INFINITY.matcher(this.currentToken).matches()) {
            boolean bl2 = this.currentToken.startsWith("-");
            this.nextToken();
            if (!bl2) return Float.POSITIVE_INFINITY;
            return Float.NEGATIVE_INFINITY;
        }
        if (FLOAT_NAN.matcher(this.currentToken).matches()) {
            this.nextToken();
            return Float.NaN;
        }
        try {
            float f2 = Float.parseFloat(this.currentToken);
            this.nextToken();
            return f2;
        }
        catch (NumberFormatException var1_3) {
            throw this.floatParseException(var1_3);
        }
    }

    public boolean tryConsumeFloat() {
        try {
            this.consumeFloat();
            return true;
        }
        catch (TextFormat$ParseException var1_1) {
            return false;
        }
    }

    public boolean consumeBoolean() {
        if (this.currentToken.equals("true") || this.currentToken.equals("t") || this.currentToken.equals("1")) {
            this.nextToken();
            return true;
        }
        if (!this.currentToken.equals("false") && !this.currentToken.equals("f")) {
            if (!this.currentToken.equals("0")) throw this.parseException("Expected \"true\" or \"false\".");
        }
        this.nextToken();
        return false;
    }

    public String consumeString() {
        return this.consumeByteString().toStringUtf8();
    }

    public boolean tryConsumeString() {
        try {
            this.consumeString();
            return true;
        }
        catch (TextFormat$ParseException var1_1) {
            return false;
        }
    }

    public ByteString consumeByteString() {
        ArrayList arrayList = new ArrayList();
        this.consumeByteString(arrayList);
        do {
            if (!this.currentToken.startsWith("'")) {
                if (!this.currentToken.startsWith("\"")) return ByteString.copyFrom(arrayList);
            }
            this.consumeByteString(arrayList);
        } while (true);
    }

    private void consumeByteString(List list) {
        char c2;
        char c3 = c2 = this.currentToken.length() > 0 ? this.currentToken.charAt(0) : '\u0000';
        if (c2 != '\"' && c2 != '\'') {
            throw this.parseException("Expected string.");
        }
        if (this.currentToken.length() < 2) throw this.parseException("String missing ending quote.");
        if (this.currentToken.charAt(this.currentToken.length() - 1) != c2) {
            throw this.parseException("String missing ending quote.");
        }
        try {
            String string = this.currentToken.substring(1, this.currentToken.length() - 1);
            ByteString byteString = TextFormat.unescapeBytes(string);
            this.nextToken();
            list.add(byteString);
            return;
        }
        catch (TextFormat$InvalidEscapeSequenceException var3_4) {
            throw this.parseException(var3_4.getMessage());
        }
    }

    public TextFormat$ParseException parseException(String string) {
        return new TextFormat$ParseException(this.line + 1, this.column + 1, string);
    }

    public TextFormat$ParseException parseExceptionPreviousToken(String string) {
        return new TextFormat$ParseException(this.previousLine + 1, this.previousColumn + 1, string);
    }

    private TextFormat$ParseException integerParseException(NumberFormatException numberFormatException) {
        String string;
        String string2 = String.valueOf(numberFormatException.getMessage());
        if (string2.length() != 0) {
            string = "Couldn't parse integer: ".concat(string2);
            return this.parseException(string);
        }
        string = new String("Couldn't parse integer: ");
        return this.parseException(string);
    }

    private TextFormat$ParseException floatParseException(NumberFormatException numberFormatException) {
        String string;
        String string2 = String.valueOf(numberFormatException.getMessage());
        if (string2.length() != 0) {
            string = "Couldn't parse number: ".concat(string2);
            return this.parseException(string);
        }
        string = new String("Couldn't parse number: ");
        return this.parseException(string);
    }

    /* synthetic */ TextFormat$Tokenizer(CharSequence charSequence, TextFormat$1 textFormat$1) {
        this(charSequence);
    }

    static /* synthetic */ String access$1200(TextFormat$Tokenizer textFormat$Tokenizer) {
        return textFormat$Tokenizer.currentToken;
    }
}

