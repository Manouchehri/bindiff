package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplayCoordinate;
import com.google.security.zynamics.zylib.gui.CodeDisplay.FormattedCharacterBuffer;
import com.google.security.zynamics.zylib.gui.CodeDisplay.ICodeDisplayModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CodeDisplayModelExample implements ICodeDisplayModel {
   private ArrayList data = new ArrayList();
   private int totalNumberOfLines = 0;
   private Font fontColumnA = new Font("Monospaced", 1, 12);
   private Font fontColumnB = new Font("Monospaced", 0, 12);
   private Font fontColumnC = new Font("Monospaced", 2, 12);

   public CodeDisplayModelExample() {
      for(int var1 = 0; var1 < 10000; ++var1) {
         ArrayList var2 = new ArrayList();
         ArrayList var3 = new ArrayList();
         ArrayList var4 = new ArrayList();
         var2.add(String.format("* %d *", new Object[]{Integer.valueOf(var1)}));
         var3.add(String.format("Code for line %d", new Object[]{Integer.valueOf(var1)}));
         var4.add(String.format("First comment in line %d", new Object[]{Integer.valueOf(var1)}));
         var4.add(String.format("Second comment in line %d", new Object[]{Integer.valueOf(var1)}));
         this.totalNumberOfLines += 2;
         ArrayList var5 = new ArrayList();
         var5.add(var2);
         var5.add(var3);
         var5.add(var4);
         this.data.add(var5);
      }

   }

   public int getNumberOfRows() {
      return this.data.size();
   }

   public int getTotalNumberOfLines() {
      return this.totalNumberOfLines;
   }

   public int getColumnWidthInCharacters(int var1) {
      switch(var1) {
      case 0:
         return 15;
      case 1:
         return 40;
      case 2:
         return 40;
      default:
         throw new ArrayIndexOutOfBoundsException();
      }
   }

   public int getTotalWidthInCharacters() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.getNumberOfColumns(); ++var2) {
         var1 += this.getColumnWidthInCharacters(var2);
      }

      return var1;
   }

   public int getMaximumLinesForRow(int var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.getNumberOfColumns(); ++var3) {
         var2 = Math.max(((ArrayList)((ArrayList)this.data.get(var1)).get(var3)).size(), var2);
      }

      return var2;
   }

   public int getNumberOfColumns() {
      return 3;
   }

   public String getColumnName(int var1) {
      switch(var1) {
      case 0:
         return "Line:";
      case 1:
         return "Code:";
      case 2:
         return "Comment:";
      default:
         throw new ArrayIndexOutOfBoundsException();
      }
   }

   public static String padRight(String var0, int var1) {
      return String.format((new StringBuilder(16)).append("%1$-").append(var1).append("s").toString(), new Object[]{var0});
   }

   public FormattedCharacterBuffer getLineFormatted(int var1, int var2, int var3) {
      ArrayList var4 = (ArrayList)((ArrayList)this.data.get(var1)).get(var2);
      String var5;
      if(var3 >= var4.size()) {
         var5 = padRight("", this.getColumnWidthInCharacters(var2));
      } else {
         var5 = padRight((String)var4.get(var3), this.getColumnWidthInCharacters(var2));
      }

      var5 = var5.substring(0, Math.min(var5.length(), this.getColumnWidthInCharacters(var2)));
      switch(var2) {
      case 0:
         return new FormattedCharacterBuffer(var5, this.fontColumnA, Color.BLACK, Color.LIGHT_GRAY);
      case 1:
         return new FormattedCharacterBuffer(var5, this.fontColumnB, Color.WHITE, Color.DARK_GRAY);
      case 2:
         return new FormattedCharacterBuffer(var5, this.fontColumnC, Color.LIGHT_GRAY, Color.BLACK);
      default:
         return null;
      }
   }

   public boolean canHaveCaret(CodeDisplayCoordinate var1) {
      return var1.getColumn() != 0;
   }

   public boolean isEditable(CodeDisplayCoordinate var1) {
      return var1.getColumn() == 2;
   }

   public void keyPressedOrTyped(CodeDisplayCoordinate var1, KeyEvent var2) {
      if(!var2.isActionKey()) {
         switch(var2.getKeyCode()) {
         case 10:
            break;
         default:
            String var3 = (String)((ArrayList)((ArrayList)this.data.get(var1.getRow())).get(var1.getColumn())).get(var1.getLine());
            if(var3.length() < var1.getFieldIndex()) {
               var3 = padRight(var3, var1.getFieldIndex());
            }

            String var5 = String.valueOf(var3.substring(0, var1.getFieldIndex()));
            char var6 = var2.getKeyChar();
            String var7 = String.valueOf(var3.substring(var1.getFieldIndex()));
            String var4 = (new StringBuilder(1 + String.valueOf(var5).length() + String.valueOf(var7).length())).append(var5).append(var6).append(var7).toString();
            ((ArrayList)((ArrayList)this.data.get(var1.getRow())).get(var1.getColumn())).set(var1.getLine(), var4);
            var1.setFieldIndex(var1.getFieldIndex() + 1);
         }
      } else {
         switch(var2.getKeyCode()) {
         case 37:
            var1.setFieldIndex(var1.getFieldIndex() - 1);
         case 38:
         case 40:
         default:
            break;
         case 39:
            var1.setFieldIndex(var1.getFieldIndex() + 1);
         }
      }

   }

   public boolean hasHeaderRow() {
      return false;
   }

   public FormattedCharacterBuffer getHeader(int var1) {
      return null;
   }
}
