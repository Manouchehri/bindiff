package org.jfree.ui;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import org.jfree.ui.KeyedComboBoxModel$ComboBoxItemPair;

public class KeyedComboBoxModel implements ComboBoxModel {
   private int selectedItemIndex;
   private Object selectedItemValue;
   private ArrayList data;
   private ArrayList listdatalistener;
   private transient ListDataListener[] tempListeners;
   private boolean allowOtherValue;

   public KeyedComboBoxModel() {
      this.data = new ArrayList();
      this.listdatalistener = new ArrayList();
   }

   public KeyedComboBoxModel(Object[] var1, Object[] var2) {
      this();
      this.setData(var1, var2);
   }

   public void setData(Object[] var1, Object[] var2) {
      if(var2.length != var1.length) {
         throw new IllegalArgumentException("Values and text must have the same length.");
      } else {
         this.data.clear();
         this.data.ensureCapacity(var1.length);

         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.add(var1[var3], var2[var3]);
         }

         this.selectedItemIndex = -1;
         ListDataEvent var4 = new ListDataEvent(this, 0, 0, this.data.size() - 1);
         this.fireListDataEvent(var4);
      }
   }

   protected synchronized void fireListDataEvent(ListDataEvent var1) {
      if(this.tempListeners == null) {
         this.tempListeners = (ListDataListener[])((ListDataListener[])this.listdatalistener.toArray(new ListDataListener[this.listdatalistener.size()]));
      }

      for(int var2 = 0; var2 < this.tempListeners.length; ++var2) {
         ListDataListener var3 = this.tempListeners[var2];
         var3.contentsChanged(var1);
      }

   }

   public Object getSelectedItem() {
      return this.selectedItemValue;
   }

   public void setSelectedKey(Object var1) {
      if(var1 == null) {
         this.selectedItemIndex = -1;
         this.selectedItemValue = null;
      } else {
         int var2 = this.findDataElementIndex(var1);
         if(var2 == -1) {
            this.selectedItemIndex = -1;
            this.selectedItemValue = null;
         } else {
            this.selectedItemIndex = var2;
            this.selectedItemValue = this.getElementAt(this.selectedItemIndex);
         }
      }

      this.fireListDataEvent(new ListDataEvent(this, 0, -1, -1));
   }

   public void setSelectedItem(Object var1) {
      if(var1 == null) {
         this.selectedItemIndex = -1;
         this.selectedItemValue = null;
      } else {
         int var2 = this.findElementIndex(var1);
         if(var2 == -1) {
            if(this.isAllowOtherValue()) {
               this.selectedItemIndex = -1;
               this.selectedItemValue = var1;
            } else {
               this.selectedItemIndex = -1;
               this.selectedItemValue = null;
            }
         } else {
            this.selectedItemIndex = var2;
            this.selectedItemValue = this.getElementAt(this.selectedItemIndex);
         }
      }

      this.fireListDataEvent(new ListDataEvent(this, 0, -1, -1));
   }

   private boolean isAllowOtherValue() {
      return this.allowOtherValue;
   }

   public void setAllowOtherValue(boolean var1) {
      this.allowOtherValue = var1;
   }

   public synchronized void addListDataListener(ListDataListener var1) {
      this.listdatalistener.add(var1);
      this.tempListeners = null;
   }

   public Object getElementAt(int var1) {
      if(var1 >= this.data.size()) {
         return null;
      } else {
         KeyedComboBoxModel$ComboBoxItemPair var2 = (KeyedComboBoxModel$ComboBoxItemPair)this.data.get(var1);
         return var2 == null?null:var2.getValue();
      }
   }

   public Object getKeyAt(int var1) {
      if(var1 >= this.data.size()) {
         return null;
      } else if(var1 < 0) {
         return null;
      } else {
         KeyedComboBoxModel$ComboBoxItemPair var2 = (KeyedComboBoxModel$ComboBoxItemPair)this.data.get(var1);
         return var2 == null?null:var2.getKey();
      }
   }

   public Object getSelectedKey() {
      return this.getKeyAt(this.selectedItemIndex);
   }

   public int getSize() {
      return this.data.size();
   }

   public void removeListDataListener(ListDataListener var1) {
      this.listdatalistener.remove(var1);
      this.tempListeners = null;
   }

   private int findDataElementIndex(Object var1) {
      if(var1 == null) {
         throw new NullPointerException("Item to find must not be null");
      } else {
         for(int var2 = 0; var2 < this.data.size(); ++var2) {
            KeyedComboBoxModel$ComboBoxItemPair var3 = (KeyedComboBoxModel$ComboBoxItemPair)this.data.get(var2);
            if(var1.equals(var3.getKey())) {
               return var2;
            }
         }

         return -1;
      }
   }

   public int findElementIndex(Object var1) {
      if(var1 == null) {
         throw new NullPointerException("Item to find must not be null");
      } else {
         for(int var2 = 0; var2 < this.data.size(); ++var2) {
            KeyedComboBoxModel$ComboBoxItemPair var3 = (KeyedComboBoxModel$ComboBoxItemPair)this.data.get(var2);
            if(var1.equals(var3.getValue())) {
               return var2;
            }
         }

         return -1;
      }
   }

   public void removeDataElement(Object var1) {
      int var2 = this.findDataElementIndex(var1);
      if(var2 != -1) {
         this.data.remove(var2);
         ListDataEvent var3 = new ListDataEvent(this, 2, var2, var2);
         this.fireListDataEvent(var3);
      }
   }

   public void add(Object var1, Object var2) {
      KeyedComboBoxModel$ComboBoxItemPair var3 = new KeyedComboBoxModel$ComboBoxItemPair(var1, var2);
      this.data.add(var3);
      ListDataEvent var4 = new ListDataEvent(this, 1, this.data.size() - 2, this.data.size() - 2);
      this.fireListDataEvent(var4);
   }

   public void clear() {
      int var1 = this.getSize();
      this.data.clear();
      ListDataEvent var2 = new ListDataEvent(this, 2, 0, var1 - 1);
      this.fireListDataEvent(var2);
   }
}
