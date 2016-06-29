package com.google.security.zynamics.zylib.gui;

public abstract class DefaultWrapper {
   private final Object m_object;

   protected DefaultWrapper(Object var1) {
      this.m_object = var1;
   }

   public Object getObject() {
      return this.m_object;
   }

   public abstract String toString();
}
