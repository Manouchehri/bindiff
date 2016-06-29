package org.jfree.chart.title;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.event.EventListenerList;
import org.jfree.chart.block.AbstractBlock;
import org.jfree.chart.block.Block;
import org.jfree.chart.event.TitleChangeEvent;
import org.jfree.chart.event.TitleChangeListener;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.VerticalAlignment;
import org.jfree.util.ObjectUtilities;

public abstract class Title extends AbstractBlock implements Serializable, Cloneable, Block {
   private static final long serialVersionUID = -6675162505277817221L;
   public static final RectangleEdge DEFAULT_POSITION;
   public static final HorizontalAlignment DEFAULT_HORIZONTAL_ALIGNMENT;
   public static final VerticalAlignment DEFAULT_VERTICAL_ALIGNMENT;
   public static final RectangleInsets DEFAULT_PADDING;
   private RectangleEdge position;
   private HorizontalAlignment horizontalAlignment;
   private VerticalAlignment verticalAlignment;
   private transient EventListenerList listenerList;
   private boolean notify;
   static Class class$org$jfree$chart$event$TitleChangeListener;

   protected Title() {
      this(DEFAULT_POSITION, DEFAULT_HORIZONTAL_ALIGNMENT, DEFAULT_VERTICAL_ALIGNMENT, DEFAULT_PADDING);
   }

   protected Title(RectangleEdge var1, HorizontalAlignment var2, VerticalAlignment var3) {
      this(var1, var2, var3, DEFAULT_PADDING);
   }

   protected Title(RectangleEdge var1, HorizontalAlignment var2, VerticalAlignment var3, RectangleInsets var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'position\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'horizontalAlignment\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'verticalAlignment\' argument.");
      } else if(var4 == null) {
         throw new IllegalArgumentException("Null \'spacer\' argument.");
      } else {
         this.position = var1;
         this.horizontalAlignment = var2;
         this.verticalAlignment = var3;
         this.setPadding(var4);
         this.listenerList = new EventListenerList();
         this.notify = true;
      }
   }

   public RectangleEdge getPosition() {
      return this.position;
   }

   public void setPosition(RectangleEdge var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'position\' argument.");
      } else {
         if(this.position != var1) {
            this.position = var1;
            this.notifyListeners(new TitleChangeEvent(this));
         }

      }
   }

   public HorizontalAlignment getHorizontalAlignment() {
      return this.horizontalAlignment;
   }

   public void setHorizontalAlignment(HorizontalAlignment var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'alignment\' argument.");
      } else {
         if(this.horizontalAlignment != var1) {
            this.horizontalAlignment = var1;
            this.notifyListeners(new TitleChangeEvent(this));
         }

      }
   }

   public VerticalAlignment getVerticalAlignment() {
      return this.verticalAlignment;
   }

   public void setVerticalAlignment(VerticalAlignment var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'alignment\' argument.");
      } else {
         if(this.verticalAlignment != var1) {
            this.verticalAlignment = var1;
            this.notifyListeners(new TitleChangeEvent(this));
         }

      }
   }

   public boolean getNotify() {
      return this.notify;
   }

   public void setNotify(boolean var1) {
      this.notify = var1;
      if(var1) {
         this.notifyListeners(new TitleChangeEvent(this));
      }

   }

   public abstract void draw(Graphics2D var1, Rectangle2D var2);

   public Object clone() {
      Title var1 = (Title)super.clone();
      var1.listenerList = new EventListenerList();
      return var1;
   }

   public void addChangeListener(TitleChangeListener var1) {
      this.listenerList.add(class$org$jfree$chart$event$TitleChangeListener == null?(class$org$jfree$chart$event$TitleChangeListener = class$("org.jfree.chart.event.TitleChangeListener")):class$org$jfree$chart$event$TitleChangeListener, var1);
   }

   public void removeChangeListener(TitleChangeListener var1) {
      this.listenerList.remove(class$org$jfree$chart$event$TitleChangeListener == null?(class$org$jfree$chart$event$TitleChangeListener = class$("org.jfree.chart.event.TitleChangeListener")):class$org$jfree$chart$event$TitleChangeListener, var1);
   }

   protected void notifyListeners(TitleChangeEvent var1) {
      if(this.notify) {
         Object[] var2 = this.listenerList.getListenerList();

         for(int var3 = var2.length - 2; var3 >= 0; var3 -= 2) {
            if(var2[var3] == (class$org$jfree$chart$event$TitleChangeListener == null?(class$org$jfree$chart$event$TitleChangeListener = class$("org.jfree.chart.event.TitleChangeListener")):class$org$jfree$chart$event$TitleChangeListener)) {
               ((TitleChangeListener)var2[var3 + 1]).titleChanged(var1);
            }
         }
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Title)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         Title var2 = (Title)var1;
         return this.position != var2.position?false:(this.horizontalAlignment != var2.horizontalAlignment?false:(this.verticalAlignment != var2.verticalAlignment?false:this.notify == var2.notify));
      }
   }

   public int hashCode() {
      short var1 = 193;
      int var2 = 37 * var1 + ObjectUtilities.hashCode(this.position);
      var2 = 37 * var2 + ObjectUtilities.hashCode(this.horizontalAlignment);
      var2 = 37 * var2 + ObjectUtilities.hashCode(this.verticalAlignment);
      return var2;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.listenerList = new EventListenerList();
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      DEFAULT_POSITION = RectangleEdge.TOP;
      DEFAULT_HORIZONTAL_ALIGNMENT = HorizontalAlignment.CENTER;
      DEFAULT_VERTICAL_ALIGNMENT = VerticalAlignment.CENTER;
      DEFAULT_PADDING = new RectangleInsets(1.0D, 1.0D, 1.0D, 1.0D);
   }
}
