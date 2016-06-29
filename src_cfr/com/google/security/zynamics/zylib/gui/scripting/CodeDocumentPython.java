/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.SyntaxDocument;
import java.util.HashSet;

public class CodeDocumentPython
extends SyntaxDocument {
    private static final long serialVersionUID = 3801352080461814771L;
    private static HashSet keywords = new HashSet();

    public CodeDocumentPython(boolean bl2) {
        super(bl2);
        keywords.add("import");
        keywords.add("for");
        keywords.add("from");
        keywords.add("print");
        keywords.add("in");
        keywords.add("while");
        keywords.add("if");
        keywords.add("is");
        keywords.add("and");
        keywords.add("not");
        keywords.add("or");
        keywords.add("else");
        keywords.add("elif");
        keywords.add("lambda");
        keywords.add("continue");
        keywords.add("break");
        keywords.add("return");
        keywords.add("assert");
        keywords.add("class");
        keywords.add("def");
        keywords.add("del");
        keywords.add("except");
        keywords.add("exec");
        keywords.add("finally");
        keywords.add("global");
        keywords.add("pass");
        keywords.add("raise");
        keywords.add("try");
        keywords.add("yield");
    }

    @Override
    protected String getEndDelimiter() {
        return "\"\"\"";
    }

    @Override
    protected String getEscapeString(String string) {
        String string2;
        String string3 = String.valueOf(string);
        if (string3.length() != 0) {
            string2 = "\\".concat(string3);
            return string2;
        }
        string2 = new String("\\");
        return string2;
    }

    @Override
    protected String getSingleLineDelimiter() {
        return "#";
    }

    @Override
    protected String getStartDelimiter() {
        return "\"\"\"";
    }

    @Override
    protected boolean isConstant(String string) {
        if (string.equals("True")) return true;
        if (string.equals("False")) return true;
        if (string.equals("None")) return true;
        return false;
    }

    @Override
    protected boolean isKeyword(String string) {
        return keywords.contains(string);
    }

    @Override
    protected boolean isQuoteDelimiter(String string) {
        if ("\"'".indexOf(string) >= 0) return true;
        return false;
    }

    @Override
    protected boolean isType(String string) {
        return false;
    }

    @Override
    public HashSet getTabCompletionWords() {
        return keywords;
    }

    @Override
    public boolean isDelimiter(String string) {
        if (Character.isWhitespace(string.charAt(0))) return true;
        if (";:{}()[]+-/%<=>!&|^~*,".indexOf(string) == -1) return false;
        return true;
    }
}

