package org.jfree.data.general;

import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.EventListener;
import java.util.List;
import javax.swing.event.EventListenerList;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;

public abstract class AbstractDataset implements ObjectInputValidation, Serializable, Cloneable, Dataset {
   private static final long serialVersionUID = 1918768939869230744L;
   private DatasetGroup group = new DatasetGroup();
   private transient EventListenerList listenerList = new EventListenerList();
   static Class class$org$jfree$data$general$DatasetChangeListener;

   public DatasetGroup getGroup() {
      return this.group;
   }

   public void setGroup(DatasetGroup var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'group\' argument.");
      } else {
         this.group = var1;
      }
   }

   public void addChangeListener(DatasetChangeListener var1) {
      this.listenerList.add(class$org$jfree$data$general$DatasetChangeListener == null?(class$org$jfree$data$general$DatasetChangeListener = class$("org.jfree.data.general.DatasetChangeListener")):class$org$jfree$data$general$DatasetChangeListener, var1);
   }

   public void removeChangeListener(DatasetChangeListener var1) {
      this.listenerList.remove(class$org$jfree$data$general$DatasetChangeListener == null?(class$org$jfree$data$general$DatasetChangeListener = class$("org.jfree.data.general.DatasetChangeListener")):class$org$jfree$data$general$DatasetChangeListener, var1);
   }

   public boolean hasListener(EventListener var1) {
      List var2 = Arrays.asList(this.listenerList.getListenerList());
      return var2.contains(var1);
   }

   protected void fireDatasetChanged() {
      this.notifyListeners(new DatasetChangeEvent(this, this));
   }

   protected void notifyListeners(DatasetChangeEvent var1) {
      Object[] var2 = this.listenerList.getListenerList();

      for(int var3 = var2.length - 2; var3 >= 0; var3 -= 2) {
         if(var2[var3] == (class$org$jfree$data$general$DatasetChangeListener == null?(class$org$jfree$data$general$DatasetChangeListener = class$("org.jfree.data.general.DatasetChangeListener")):class$org$jfree$data$general$DatasetChangeListener)) {
            ((DatasetChangeListener)var2[var3 + 1]).datasetChanged(var1);
         }
      }

   }

   public Object clone() {
      AbstractDataset var1 = (AbstractDataset)super.clone();
      var1.listenerList = new EventListenerList();
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.listenerList = new EventListenerList();
      var1.registerValidation(this, 10);
   }

   public void validateObject() {
      this.fireDatasetChanged();
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
