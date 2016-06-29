package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.block.AbstractBlock;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockResult;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EntityBlockParams;
import org.jfree.chart.block.EntityBlockResult;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.ui.Size2D;
import org.jfree.util.PublicCloneable;

public class BlockContainer extends AbstractBlock implements Serializable, Cloneable, Block, PublicCloneable {
   private static final long serialVersionUID = 8199508075695195293L;
   private List blocks;
   private Arrangement arrangement;

   public BlockContainer() {
      this(new BorderArrangement());
   }

   public BlockContainer(Arrangement var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'arrangement\' argument.");
      } else {
         this.arrangement = var1;
         this.blocks = new ArrayList();
      }
   }

   public Arrangement getArrangement() {
      return this.arrangement;
   }

   public void setArrangement(Arrangement var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'arrangement\' argument.");
      } else {
         this.arrangement = var1;
      }
   }

   public boolean isEmpty() {
      return this.blocks.isEmpty();
   }

   public List getBlocks() {
      return Collections.unmodifiableList(this.blocks);
   }

   public void add(Block var1) {
      this.add(var1, (Object)null);
   }

   public void add(Block var1, Object var2) {
      this.blocks.add(var1);
      this.arrangement.add(var1, var2);
   }

   public void clear() {
      this.blocks.clear();
      this.arrangement.clear();
   }

   public Size2D arrange(Graphics2D var1, RectangleConstraint var2) {
      return this.arrangement.arrange(this, var1, var2);
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      this.draw(var1, var2, (Object)null);
   }

   public Object draw(Graphics2D var1, Rectangle2D var2, Object var3) {
      EntityBlockParams var4 = null;
      StandardEntityCollection var5 = null;
      if(var3 instanceof EntityBlockParams) {
         var4 = (EntityBlockParams)var3;
         if(var4.getGenerateEntities()) {
            var5 = new StandardEntityCollection();
         }
      }

      Rectangle2D var6 = (Rectangle2D)var2.clone();
      var6 = this.trimMargin(var6);
      this.drawBorder(var1, var6);
      var6 = this.trimBorder(var6);
      this.trimPadding(var6);
      Iterator var7 = this.blocks.iterator();

      while(var7.hasNext()) {
         Block var8 = (Block)var7.next();
         Rectangle2D var9 = var8.getBounds();
         Double var10 = new Double(var9.getX() + var2.getX(), var9.getY() + var2.getY(), var9.getWidth(), var9.getHeight());
         Object var11 = var8.draw(var1, var10, var3);
         if(var5 != null && var11 instanceof EntityBlockResult) {
            EntityBlockResult var12 = (EntityBlockResult)var11;
            EntityCollection var13 = var12.getEntityCollection();
            var5.addAll(var13);
         }
      }

      BlockResult var14 = null;
      if(var5 != null) {
         var14 = new BlockResult();
         var14.setEntityCollection(var5);
      }

      return var14;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof BlockContainer)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         BlockContainer var2 = (BlockContainer)var1;
         return !this.arrangement.equals(var2.arrangement)?false:this.blocks.equals(var2.blocks);
      }
   }

   public Object clone() {
      BlockContainer var1 = (BlockContainer)super.clone();
      return var1;
   }
}
