package org.jfree.chart.title;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.VerticalAlignment;

public class DateTitle extends TextTitle implements Serializable {
   private static final long serialVersionUID = -465434812763159881L;

   public DateTitle() {
      this(1);
   }

   public DateTitle(int var1) {
      this(var1, Locale.getDefault(), new Font("Dialog", 0, 12), Color.black);
   }

   public DateTitle(int var1, Locale var2, Font var3, Paint var4) {
      this(var1, var2, var3, var4, RectangleEdge.BOTTOM, HorizontalAlignment.RIGHT, VerticalAlignment.CENTER, Title.DEFAULT_PADDING);
   }

   public DateTitle(int var1, Locale var2, Font var3, Paint var4, RectangleEdge var5, HorizontalAlignment var6, VerticalAlignment var7, RectangleInsets var8) {
      super(DateFormat.getDateInstance(var1, var2).format(new Date()), var3, var4, var5, var6, var7, var8);
   }

   public void setDateFormat(int var1, Locale var2) {
      this.setText(DateFormat.getDateInstance(var1, var2).format(new Date()));
   }
}
