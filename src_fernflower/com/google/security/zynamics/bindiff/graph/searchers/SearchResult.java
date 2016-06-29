package com.google.security.zynamics.bindiff.graph.searchers;

import java.awt.Color;
import java.util.List;

public class SearchResult {
   private final int line;
   private final int index;
   private final int length;
   private final List originalTextBackgroundStyleRun;
   private final Color originalBorderColor;
   private final Object object;
   private final String text;
   private Color objectMarkerColor;

   public SearchResult(Object var1, int var2, int var3, int var4, String var5, List var6, Color var7) {
      this.objectMarkerColor = Color.WHITE;
      this.object = var1;
      this.line = var2;
      this.index = var3;
      this.length = var4;
      this.text = var5;
      this.originalTextBackgroundStyleRun = var6;
      this.originalBorderColor = var7;
   }

   public int getLength() {
      return this.length;
   }

   public int getLine() {
      return this.line;
   }

   public Object getObject() {
      return this.object;
   }

   public Color getObjectMarkerColor() {
      return this.objectMarkerColor;
   }

   public Color getOriginalBorderColor() {
      return this.originalBorderColor;
   }

   public List getOriginalTextBackgroundStyleRun() {
      return this.originalTextBackgroundStyleRun;
   }

   public int getPosition() {
      return this.index;
   }

   public String getText() {
      return this.text;
   }

   public void setObjectMarkerColor(Color var1) {
      this.objectMarkerColor = var1;
   }
}
