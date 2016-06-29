package com.google.security.zynamics.zylib.gui.scripting;

import java.util.*;

public class CodeDocumentPython extends SyntaxDocument
{
    private static final long serialVersionUID = 3801352080461814771L;
    private static HashSet keywords;
    
    public CodeDocumentPython(final boolean b) {
        super(b);
        CodeDocumentPython.keywords.add("import");
        CodeDocumentPython.keywords.add("for");
        CodeDocumentPython.keywords.add("from");
        CodeDocumentPython.keywords.add("print");
        CodeDocumentPython.keywords.add("in");
        CodeDocumentPython.keywords.add("while");
        CodeDocumentPython.keywords.add("if");
        CodeDocumentPython.keywords.add("is");
        CodeDocumentPython.keywords.add("and");
        CodeDocumentPython.keywords.add("not");
        CodeDocumentPython.keywords.add("or");
        CodeDocumentPython.keywords.add("else");
        CodeDocumentPython.keywords.add("elif");
        CodeDocumentPython.keywords.add("lambda");
        CodeDocumentPython.keywords.add("continue");
        CodeDocumentPython.keywords.add("break");
        CodeDocumentPython.keywords.add("return");
        CodeDocumentPython.keywords.add("assert");
        CodeDocumentPython.keywords.add("class");
        CodeDocumentPython.keywords.add("def");
        CodeDocumentPython.keywords.add("del");
        CodeDocumentPython.keywords.add("except");
        CodeDocumentPython.keywords.add("exec");
        CodeDocumentPython.keywords.add("finally");
        CodeDocumentPython.keywords.add("global");
        CodeDocumentPython.keywords.add("pass");
        CodeDocumentPython.keywords.add("raise");
        CodeDocumentPython.keywords.add("try");
        CodeDocumentPython.keywords.add("yield");
    }
    
    @Override
    protected String getEndDelimiter() {
        return "\"\"\"";
    }
    
    @Override
    protected String getEscapeString(final String s) {
        final String s2 = "\\";
        final String value = String.valueOf(s);
        return (value.length() != 0) ? s2.concat(value) : new String(s2);
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
    protected boolean isConstant(final String s) {
        return s.equals("True") || s.equals("False") || s.equals("None");
    }
    
    @Override
    protected boolean isKeyword(final String s) {
        return CodeDocumentPython.keywords.contains(s);
    }
    
    @Override
    protected boolean isQuoteDelimiter(final String s) {
        return "\"'".indexOf(s) >= 0;
    }
    
    @Override
    protected boolean isType(final String s) {
        return false;
    }
    
    public HashSet getTabCompletionWords() {
        return CodeDocumentPython.keywords;
    }
    
    @Override
    public boolean isDelimiter(final String s) {
        return Character.isWhitespace(s.charAt(0)) || ";:{}()[]+-/%<=>!&|^~*,".indexOf(s) != -1;
    }
    
    static {
        CodeDocumentPython.keywords = new HashSet();
    }
}
