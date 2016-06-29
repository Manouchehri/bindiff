package com.google.security.zynamics.zylib.types.trees;

import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.ArrayList;
import java.util.List;

public class TreeNode implements ITreeNode {
   private ITreeNode m_parent = null;
   private final List m_children = new ArrayList();
   private final Object m_object;

   public TreeNode(Object var1) {
      this.m_object = var1;
   }

   public void addChild(ITreeNode var1) {
      this.m_children.add(var1);
   }

   public List getChildren() {
      return new ArrayList(this.m_children);
   }

   public Object getObject() {
      return this.m_object;
   }

   public ITreeNode getParent() {
      return this.m_parent;
   }

   public void removeChild(ITreeNode var1) {
      this.m_children.remove(var1);
   }

   public void setParent(ITreeNode var1) {
      this.m_parent = var1;
   }

   public String toString() {
      String var1 = String.valueOf(this.m_object.toString());
      return (new StringBuilder(2 + String.valueOf(var1).length())).append("<").append(var1).append(">").toString();
   }
}
