package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import java.awt.Color;

public class CStyleRunData {
   private final int m_start;
   private final int m_length;
   private final Color m_color;
   private final IZyEditableObject m_lineObject;
   private Object m_object;

   public CStyleRunData(int var1, int var2, Color var3) {
      this(var1, var2, var3, (IZyEditableObject)null);
   }

   public CStyleRunData(int var1, int var2, Color var3, IZyEditableObject var4) {
      Preconditions.checkArgument(var2 != 0, "Error: Invalid style run length");
      this.m_start = var1;
      this.m_length = var2;
      this.m_color = var3;
      this.m_lineObject = var4;
   }

   public CStyleRunData(int var1, int var2, Color var3, Object var4) {
      this(var1, var2, var3, (IZyEditableObject)null);
      this.m_object = var4;
   }

   public Color getColor() {
      return this.m_color;
   }

   public int getEnd() {
      return this.m_start + this.m_length;
   }

   public int getLength() {
      return this.m_length;
   }

   public IZyEditableObject getLineObject() {
      return this.m_lineObject;
   }

   public Object getObject() {
      return this.m_object;
   }

   public int getStart() {
      return this.m_start;
   }
}
