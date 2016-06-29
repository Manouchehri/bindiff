package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplay$1;
import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplay$InternalListener;
import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplayCoordinate;
import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplayEventListener;
import com.google.security.zynamics.zylib.gui.CodeDisplay.FormattedCharacterBuffer;
import com.google.security.zynamics.zylib.gui.CodeDisplay.ICodeDisplayModel;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;
import javax.swing.JComponent;
import javax.swing.JScrollBar;

public class CodeDisplay extends JComponent {
   private FontMetrics fontMetrics;
   private Font textFont;
   private final JScrollBar verticalScrollbar = new JScrollBar(1, 0, 1, 0, 1);
   private final JScrollBar horizontalScrollbar = new JScrollBar(0, 0, 1, 0, 1);
   private final CodeDisplay$InternalListener listener = new CodeDisplay$InternalListener(this, (CodeDisplay$1)null);
   private final ICodeDisplayModel codeModel;
   private BufferedImage bufferedImage;
   private Graphics2D bufferedGraphics;
   private int fontCharWidth = 0;
   private int fontLineHeight = 0;
   private final JCaret caret = new JCaret();
   private CodeDisplayCoordinate caretPosition = new CodeDisplayCoordinate(0, 0, 0, 0);
   private int caretX = 0;
   private int caretY = 0;
   private int currentlyVisibleLines = 0;
   private int currentlyVisibleColumns = 0;
   private int currentFirstRow = 0;
   private int currentFirstLine = 0;
   private int currentFirstCharColumn = 0;
   private FormattedCharacterBuffer charBuffer = new FormattedCharacterBuffer(0, 0);
   private List eventListeners = new ArrayList();
   private TreeMap yCoordinateToRowAndLine = new TreeMap();

   public static String padRight(String var0, int var1) {
      return var1 == 0?"":String.format((new StringBuilder(16)).append("%1$-").append(var1).append("s").toString(), new Object[]{var0});
   }

   public CodeDisplay(ICodeDisplayModel var1) {
      this.codeModel = var1;
      this.textFont = new Font("Monospaced", 0, 12);
      this.setFocusable(true);
      this.setLayout(new BorderLayout());
      this.initializeListeners();
      this.initializeScrollbars();
      this.initializeFontMetrics(this.textFont);
      this.currentlyVisibleLines = this.getNumberOfVisibleLines();
      this.currentlyVisibleColumns = this.getNumberOfVisibleColumns();
      this.initializeGraphicsBuffer();
      this.setScrollBarMaximum();
      this.setEnabled(true);
      int var2 = 0;
      CodeDisplayCoordinate var3 = new CodeDisplayCoordinate(0, 0, 0, 0);

      for(int var4 = 0; var4 < this.codeModel.getNumberOfColumns(); ++var4) {
         var2 += this.codeModel.getColumnWidthInCharacters(var4);
         var3.setColumn(var4);
         if(this.codeModel.canHaveCaret(var3)) {
            this.setCaretPosition(var3);
            this.caretX = var2;
            this.caretY = 1;
         }
      }

   }

   private void initializeGraphicsBuffer() {
      this.bufferedImage = new BufferedImage((this.codeModel.getTotalWidthInCharacters() + 1) * this.fontCharWidth, (this.currentlyVisibleLines + 10) * this.fontLineHeight, 1);
      this.bufferedGraphics = (Graphics2D)this.bufferedImage.getGraphics();
   }

   private void notifyCaretListeners() {
      Iterator var1 = this.eventListeners.iterator();

      while(var1.hasNext()) {
         CodeDisplayEventListener var2 = (CodeDisplayEventListener)var1.next();
         var2.caretChanged(this.caretPosition);
      }

   }

   private void initializeFontMetrics(Font var1) {
      BufferedImage var2 = new BufferedImage(10, 10, 1);
      Graphics2D var3 = (Graphics2D)var2.getGraphics();
      var3.setFont(var1);
      this.fontMetrics = var3.getFontMetrics();
      this.fontCharWidth = this.fontMetrics.getMaxAdvance();
      this.fontLineHeight = this.fontMetrics.getHeight();
   }

   private void initializeListeners() {
      this.addMouseListener(this.listener);
      this.addMouseMotionListener(this.listener);
      this.addMouseWheelListener(this.listener);
      this.addFocusListener(this.listener);
      this.addComponentListener(this.listener);
      this.addKeyListener(this.listener);
      this.caret.addCaretListener(this.listener);
   }

   private void initializeScrollbars() {
      this.verticalScrollbar.addAdjustmentListener(this.listener);
      this.add(this.verticalScrollbar, "East");
      this.horizontalScrollbar.addAdjustmentListener(this.listener);
      this.add(this.horizontalScrollbar, "South");
   }

   private int getNumberOfVisibleColumns() {
      int var1 = this.getWidth() - this.verticalScrollbar.getWidth();
      return var1 / this.fontCharWidth + (var1 % this.fontCharWidth == 0?0:1);
   }

   private int getNumberOfVisibleLines() {
      int var1 = this.getHeight() - this.horizontalScrollbar.getHeight();
      return var1 / this.fontLineHeight + (var1 % this.fontLineHeight == 0?0:1);
   }

   private void setScrollBarMaximum() {
      int var1 = this.codeModel.getNumberOfRows();
      int var2 = var1;
      if(var1 < 0) {
         var2 = 0;
         this.verticalScrollbar.setValue(0);
         this.verticalScrollbar.setEnabled(false);
      } else {
         this.verticalScrollbar.setEnabled(true);
      }

      this.verticalScrollbar.setMaximum(var2);
      int var3 = this.codeModel.getTotalWidthInCharacters();
      int var4 = this.getWidth();
      var4 -= this.verticalScrollbar.getWidth();
      if(var4 >= var3 * this.fontCharWidth) {
         this.horizontalScrollbar.setValue(0);
         this.horizontalScrollbar.setEnabled(false);
      } else {
         this.horizontalScrollbar.setMaximum(var3 + 1);
         this.horizontalScrollbar.setEnabled(true);
      }

   }

   private void updateCharacterBufferFromModel() {
      this.charBuffer.clear();
      this.charBuffer.setBackgroundColor(Color.LIGHT_GRAY.brighter());
      this.currentFirstRow = this.verticalScrollbar.getValue();
      this.currentFirstCharColumn = this.horizontalScrollbar.getValue();
      int var1 = 0;
      int var2;
      int var3;
      if(this.codeModel.hasHeaderRow()) {
         var1 = 1;
         var2 = 0;

         for(var3 = 0; var3 < this.codeModel.getNumberOfColumns(); ++var3) {
            this.charBuffer.copyInto(0, var2, this.codeModel.getHeader(var3));
            var2 += this.codeModel.getColumnWidthInCharacters(var3);
         }
      }

      for(var2 = this.currentFirstRow; var2 < Math.min(this.currentFirstRow + this.currentlyVisibleLines, this.codeModel.getNumberOfRows()); ++var2) {
         for(var3 = var2 == this.currentFirstRow?this.currentFirstLine:0; var3 < this.codeModel.getMaximumLinesForRow(var2); ++var3) {
            int var4 = 0;

            for(int var5 = 0; var5 < this.codeModel.getNumberOfColumns(); ++var5) {
               if(this.caretPosition.getRow() == var2 && this.caretPosition.getLine() == var3 && this.caretPosition.getColumn() == var5) {
                  this.caretX = var4 + this.caretPosition.getFieldIndex();
                  this.caretY = var1;
               }

               FormattedCharacterBuffer var6 = this.codeModel.getLineFormatted(var2, var5, var3);
               if(var6 != null) {
                  this.charBuffer.copyInto(var1, var4, var6);
               }

               int var7 = var1 * this.fontLineHeight + this.fontLineHeight / 2;
               if(!this.yCoordinateToRowAndLine.containsKey(Integer.valueOf(var7))) {
                  this.yCoordinateToRowAndLine.put(Integer.valueOf(var7), new CodeDisplayCoordinate(var2, var3, 0, 0));
               } else {
                  CodeDisplayCoordinate var8 = (CodeDisplayCoordinate)this.yCoordinateToRowAndLine.get(Integer.valueOf(var7));
                  var8.setRow(var2);
                  var8.setLine(var3);
               }

               var4 += this.codeModel.getColumnWidthInCharacters(var5);
            }

            ++var1;
         }
      }

      this.setScrollBarMaximum();
   }

   protected void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      this.bufferedGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      this.updateVisibleLinesAndColumns();
      this.updateCharacterBufferFromModel();
      this.currentFirstRow = this.verticalScrollbar.getValue();
      this.currentFirstCharColumn = this.horizontalScrollbar.getValue();
      this.charBuffer.paintBuffer(this.bufferedGraphics, 0, 0, this.currentFirstCharColumn);
      var1.drawImage(this.bufferedImage, 2, 2, this);
      this.caret.draw(var1, 2 + this.caretX * this.fontCharWidth, 6 + this.caretY * this.fontLineHeight, this.fontLineHeight - 1);
   }

   void updateVisibleLinesAndColumns() {
      int var1 = this.getNumberOfVisibleLines();
      int var2 = this.getNumberOfVisibleColumns();
      if(this.currentlyVisibleLines != var1 || this.currentlyVisibleColumns != var2) {
         this.currentlyVisibleLines = var1;
         this.currentlyVisibleColumns = var2;
         int var3 = this.codeModel.getTotalWidthInCharacters();
         int var4 = this.currentlyVisibleLines + 1;
         this.charBuffer = new FormattedCharacterBuffer(var4, var3);
         this.bufferedImage = new BufferedImage(var3 * this.fontCharWidth, var4 * this.fontLineHeight, 1);
         this.bufferedGraphics = (Graphics2D)this.bufferedImage.getGraphics();
      }

   }

   void setSelectionStart() {
   }

   private boolean fillColumnAndFieldIndexFromX(int var1, CodeDisplayCoordinate var2) {
      var1 += this.currentFirstCharColumn * this.fontCharWidth;
      int var3 = 0;
      boolean var4 = false;

      for(int var5 = 0; var5 < this.codeModel.getNumberOfColumns(); ++var5) {
         int var6 = var3 + this.codeModel.getColumnWidthInCharacters(var5) * this.fontCharWidth;
         if(var1 >= var3 && var1 < var6) {
            var1 -= var3;
            int var7 = var1 / this.fontCharWidth;
            var2.setColumn(var5);
            var2.setFieldIndex(var7);
            return true;
         }

         var3 = var6;
      }

      return false;
   }

   private boolean fillCoordinateFromXY(int var1, int var2, CodeDisplayCoordinate var3) {
      Entry var4 = this.yCoordinateToRowAndLine.floorEntry(Integer.valueOf(var2));
      if(var4 == null) {
         var3.setRow(2);
         var3.setColumn(1);
         return true;
      } else {
         var3.setRow(((CodeDisplayCoordinate)var4.getValue()).getRow());
         var3.setLine(((CodeDisplayCoordinate)var4.getValue()).getLine());
         return this.fillColumnAndFieldIndexFromX(var1, var3);
      }
   }

   public CodeDisplayCoordinate getCaretPosition() {
      return this.caretPosition;
   }

   public void setCaretPosition(CodeDisplayCoordinate var1) {
      this.caretPosition = var1;
   }

   public int rowAtPoint(Point var1) {
      CodeDisplayCoordinate var2 = new CodeDisplayCoordinate(0, 0, 0, 0);
      this.fillCoordinateFromXY(var1.x, var1.y, var2);
      return var2.getRow();
   }

   public int columnAtPoint(Point var1) {
      CodeDisplayCoordinate var2 = new CodeDisplayCoordinate(0, 0, 0, 0);
      this.fillCoordinateFromXY(var1.x, var1.y, var2);
      return var2.getColumn();
   }

   public int lineAtPoint(Point var1) {
      CodeDisplayCoordinate var2 = new CodeDisplayCoordinate(0, 0, 0, 0);
      this.fillCoordinateFromXY(var1.x, var1.y, var2);
      return var2.getLine();
   }

   public void addCaretChangedListener(CodeDisplayEventListener var1) {
      this.eventListeners.add(var1);
   }

   public void removeCaretChangedListener(CodeDisplayEventListener var1) {
      this.eventListeners.remove(var1);
   }

   public Dimension getPreferredSize() {
      return new Dimension(this.fontCharWidth * this.codeModel.getTotalWidthInCharacters(), this.fontLineHeight * 40);
   }

   // $FF: synthetic method
   static void access$100(CodeDisplay var0) {
      var0.updateCharacterBufferFromModel();
   }

   // $FF: synthetic method
   static void access$200(CodeDisplay var0) {
      var0.setScrollBarMaximum();
   }

   // $FF: synthetic method
   static CodeDisplayCoordinate access$300(CodeDisplay var0) {
      return var0.caretPosition;
   }

   // $FF: synthetic method
   static ICodeDisplayModel access$400(CodeDisplay var0) {
      return var0.codeModel;
   }

   // $FF: synthetic method
   static int access$500(CodeDisplay var0) {
      return var0.currentlyVisibleLines;
   }

   // $FF: synthetic method
   static JScrollBar access$600(CodeDisplay var0) {
      return var0.verticalScrollbar;
   }

   // $FF: synthetic method
   static void access$700(CodeDisplay var0) {
      var0.notifyCaretListeners();
   }

   // $FF: synthetic method
   static boolean access$800(CodeDisplay var0, int var1, int var2, CodeDisplayCoordinate var3) {
      return var0.fillCoordinateFromXY(var1, var2, var3);
   }
}
