package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.general.Convert;
import java.awt.Color;
import java.util.HashSet;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public abstract class SyntaxDocument extends DefaultStyledDocument {
   private static final long serialVersionUID = 5437418885392724717L;
   private static final int DEFAULT_FONT_SIZE = 13;
   private final DefaultStyledDocument doc = this;
   private final Element rootElement;
   private boolean multiLineComment;
   private final MutableAttributeSet comment = new SimpleAttributeSet();
   private final MutableAttributeSet keyword = new SimpleAttributeSet();
   private final MutableAttributeSet type = new SimpleAttributeSet();
   private final MutableAttributeSet constant = new SimpleAttributeSet();
   private final MutableAttributeSet number = new SimpleAttributeSet();
   private final MutableAttributeSet quote = new SimpleAttributeSet();
   private final boolean m_addBraces;
   protected final MutableAttributeSet normal = new SimpleAttributeSet();

   public SyntaxDocument(boolean var1) {
      this.m_addBraces = var1;
      this.rootElement = this.doc.getDefaultRootElement();
      this.putProperty("__EndOfLine__", "\n");
      StyleConstants.setForeground(this.normal, Color.black);
      StyleConstants.setFontSize(this.normal, 13);
      StyleConstants.setForeground(this.comment, Color.gray);
      StyleConstants.setItalic(this.comment, true);
      StyleConstants.setFontSize(this.comment, 13);
      StyleConstants.setForeground(this.keyword, Color.blue.darker());
      StyleConstants.setFontSize(this.keyword, 13);
      StyleConstants.setForeground(this.quote, Color.red);
      StyleConstants.setFontSize(this.quote, 13);
      StyleConstants.setForeground(this.type, Color.PINK.darker());
      StyleConstants.setFontSize(this.type, 13);
      StyleConstants.setForeground(this.number, Color.green.darker());
      StyleConstants.setFontSize(this.number, 13);
      StyleConstants.setForeground(this.constant, Color.red.darker().darker());
      StyleConstants.setFontSize(this.constant, 13);
   }

   private void applyHighlighting(String var1, int var2) {
      int var3 = this.rootElement.getElement(var2).getStartOffset();
      int var4 = this.rootElement.getElement(var2).getEndOffset() - 1;
      int var5 = var4 - var3;
      int var6 = var1.length();
      if(var4 >= var6) {
         var4 = var6 - 1;
      }

      if(!this.endingMultiLineComment(var1, var3, var4) && !this.isMultiLineComment() && !this.startingMultiLineComment(var1, var3, var4)) {
         this.doc.setCharacterAttributes(var3, var5, this.normal, true);
         int var7 = var1.indexOf(this.getSingleLineDelimiter(), var3);
         if(var7 > -1 && var7 < var4) {
            this.doc.setCharacterAttributes(var7, var4 - var7 + 1, this.comment, false);
            var4 = var7 - 1;
         }

         this.checkForTokens(var1, var3, var4);
      } else {
         this.doc.setCharacterAttributes(var3, var4 - var3 + 1, this.comment, false);
      }
   }

   private void checkForTokens(String var1, int var2, int var3) {
      while(var2 <= var3) {
         while(this.isDelimiter(var1.substring(var2, var2 + 1))) {
            if(var2 >= var3) {
               return;
            }

            ++var2;
         }

         if(this.isQuoteDelimiter(var1.substring(var2, var2 + 1))) {
            var2 = this.getQuoteToken(var1, var2, var3);
         } else {
            var2 = this.getOtherToken(var1, var2, var3);
         }
      }

   }

   private void commentLinesAfter(String var1, int var2) {
      int var3 = this.rootElement.getElement(var2).getEndOffset();
      int var4 = this.indexOf(var1, this.getEndDelimiter(), var3);
      if(var4 >= 0) {
         int var5 = this.lastIndexOf(var1, this.getStartDelimiter(), var4);
         if(var5 < 0 || var5 <= var3) {
            this.doc.setCharacterAttributes(var3, var4 - var3 + 1, this.comment, false);
         }

      }
   }

   private boolean commentLinesBefore(String var1, int var2) {
      int var3 = this.rootElement.getElement(var2).getStartOffset();
      int var4 = this.lastIndexOf(var1, this.getStartDelimiter(), var3 - 2);
      if(var4 < 0) {
         return false;
      } else {
         int var5 = this.indexOf(var1, this.getEndDelimiter(), var4);
         if(var5 < var3 & var5 != -1) {
            return false;
         } else {
            this.doc.setCharacterAttributes(var4, var3 - var4 + 1, this.comment, false);
            return true;
         }
      }
   }

   private boolean endingMultiLineComment(String var1, int var2, int var3) {
      int var4 = this.indexOf(var1, this.getEndDelimiter(), var2);
      if(var4 >= 0 && var4 <= var3) {
         this.setMultiLineComment(false);
         return true;
      } else {
         return false;
      }
   }

   private String getLine(String var1, int var2) {
      int var3 = this.rootElement.getElementIndex(var2);
      Element var4 = this.rootElement.getElement(var3);
      int var5 = var4.getStartOffset();
      int var6 = var4.getEndOffset();
      return var1.substring(var5, var6 - 1);
   }

   private int getOtherToken(String var1, int var2, int var3) {
      int var4;
      for(var4 = var2 + 1; var4 <= var3 && !this.isDelimiter(var1.substring(var4, var4 + 1)); ++var4) {
         ;
      }

      String var5 = var1.substring(var2, var4);
      if(this.isKeyword(var5)) {
         this.doc.setCharacterAttributes(var2, var4 - var2, this.keyword, false);
      } else if(this.isType(var5)) {
         this.doc.setCharacterAttributes(var2, var4 - var2, this.type, false);
      } else if(this.isConstant(var5)) {
         this.doc.setCharacterAttributes(var2, var4 - var2, this.constant, false);
      } else if(Convert.isDecString(var5)) {
         this.doc.setCharacterAttributes(var2, var4 - var2, this.number, false);
      }

      return var4 + 1;
   }

   private int getQuoteToken(String var1, int var2, int var3) {
      String var4 = var1.substring(var2, var2 + 1);
      String var5 = this.getEscapeString(var4);
      int var7 = var2;

      int var6;
      for(var6 = var1.indexOf(var5, var2 + 1); var6 > -1 && var6 < var3; var6 = var1.indexOf(var5, var7)) {
         var7 = var6 + 1;
      }

      var6 = var1.indexOf(var4, var7 + 1);
      if(var6 >= 0 && var6 <= var3) {
         var7 = var6;
      } else {
         var7 = var3;
      }

      this.doc.setCharacterAttributes(var2, var7 - var2 + 1, this.quote, false);
      return var7 + 1;
   }

   private void highlightLinesAfter(String var1, int var2) {
      int var3 = this.rootElement.getElement(var2).getEndOffset();
      int var4 = this.indexOf(var1, this.getStartDelimiter(), var3);
      int var5 = this.indexOf(var1, this.getEndDelimiter(), var3);
      if(var4 < 0) {
         var4 = var1.length();
      }

      if(var5 < 0) {
         var5 = var1.length();
      }

      int var6 = Math.min(var4, var5);
      if(var6 >= var3) {
         int var7 = this.rootElement.getElementIndex(var6);

         for(int var8 = var2 + 1; var8 < var7; ++var8) {
            Element var9 = this.rootElement.getElement(var8);
            Element var10 = this.doc.getCharacterElement(var9.getStartOffset());
            AttributeSet var11 = var10.getAttributes();
            if(var11.isEqual(this.comment)) {
               this.applyHighlighting(var1, var8);
            }
         }

      }
   }

   private int indexOf(String var1, String var2, int var3) {
      while(true) {
         int var4;
         if((var4 = var1.indexOf(var2, var3)) != -1) {
            String var5 = this.getLine(var1, var4).trim();
            if(!var5.startsWith(var2) && !var5.endsWith(var2)) {
               var3 = var4 + 1;
               continue;
            }
         }

         return var4;
      }
   }

   private boolean isMultiLineComment() {
      return this.multiLineComment;
   }

   private int lastIndexOf(String var1, String var2, int var3) {
      while(true) {
         int var4;
         if((var4 = var1.lastIndexOf(var2, var3)) != -1) {
            String var5 = this.getLine(var1, var4).trim();
            if(!var5.startsWith(var2) && !var5.endsWith(var2)) {
               var3 = var4 - 1;
               continue;
            }
         }

         return var4;
      }
   }

   private void setMultiLineComment(boolean var1) {
      this.multiLineComment = var1;
   }

   private boolean startingMultiLineComment(String var1, int var2, int var3) {
      int var4 = this.indexOf(var1, this.getStartDelimiter(), var2);
      if(var4 >= 0 && var4 <= var3) {
         this.setMultiLineComment(true);
         return true;
      } else {
         return false;
      }
   }

   protected String addMatchingBrace(int var1) {
      StringBuffer var2 = new StringBuffer();
      int var3 = this.rootElement.getElementIndex(var1);
      int var4 = this.rootElement.getElement(var3).getStartOffset();

      while(true) {
         String var5 = this.doc.getText(var4, 1);
         if(!var5.equals(" ") && !var5.equals("\t")) {
            var5 = String.valueOf(var2.toString());
            String var6 = String.valueOf(var2.toString());
            return (new StringBuilder(5 + String.valueOf(var5).length() + String.valueOf(var6).length())).append("{\n").append(var5).append("\t\n").append(var6).append("}").toString();
         }

         var2.append(var5);
         ++var4;
      }
   }

   protected abstract String getEndDelimiter();

   protected abstract String getEscapeString(String var1);

   protected abstract String getSingleLineDelimiter();

   protected abstract String getStartDelimiter();

   protected abstract HashSet getTabCompletionWords();

   protected abstract boolean isConstant(String var1);

   protected abstract boolean isKeyword(String var1);

   protected abstract boolean isQuoteDelimiter(String var1);

   protected abstract boolean isType(String var1);

   public void insertString(int var1, String var2, AttributeSet var3) {
      if(this.m_addBraces && var2.equals("{")) {
         var2 = this.addMatchingBrace(var1);
      }

      super.insertString(var1, var2, var3);
      this.processChangedLines(var1, var2.length());
   }

   public abstract boolean isDelimiter(String var1);

   public void processChangedLines(int var1, int var2) {
      String var3 = this.doc.getText(0, this.doc.getLength());
      int var4 = this.rootElement.getElementIndex(var1);
      int var5 = this.rootElement.getElementIndex(var1 + var2);
      this.setMultiLineComment(this.commentLinesBefore(var3, var4));

      for(int var6 = var4; var6 <= var5; ++var6) {
         this.applyHighlighting(var3, var6);
      }

      if(this.isMultiLineComment()) {
         this.commentLinesAfter(var3, var5);
      } else {
         this.highlightLinesAfter(var3, var5);
      }

   }

   public void remove(int var1, int var2) {
      super.remove(var1, var2);
      this.processChangedLines(var1, 0);
   }
}
