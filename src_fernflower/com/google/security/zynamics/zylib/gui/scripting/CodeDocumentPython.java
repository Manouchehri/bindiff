package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.SyntaxDocument;
import java.util.HashSet;

public class CodeDocumentPython extends SyntaxDocument {
   private static final long serialVersionUID = 3801352080461814771L;
   private static HashSet keywords = new HashSet();

   public CodeDocumentPython(boolean var1) {
      super(var1);
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

   protected String getEndDelimiter() {
      return "\"\"\"";
   }

   protected String getEscapeString(String var1) {
      // $FF: Couldn't be decompiled
   }

   protected String getSingleLineDelimiter() {
      return "#";
   }

   protected String getStartDelimiter() {
      return "\"\"\"";
   }

   protected boolean isConstant(String var1) {
      return var1.equals("True") || var1.equals("False") || var1.equals("None");
   }

   protected boolean isKeyword(String var1) {
      return keywords.contains(var1);
   }

   protected boolean isQuoteDelimiter(String var1) {
      return "\"\'".indexOf(var1) >= 0;
   }

   protected boolean isType(String var1) {
      return false;
   }

   public HashSet getTabCompletionWords() {
      return keywords;
   }

   public boolean isDelimiter(String var1) {
      return Character.isWhitespace(var1.charAt(0)) || ";:{}()[]+-/%<=>!&|^~*,".indexOf(var1) != -1;
   }
}
