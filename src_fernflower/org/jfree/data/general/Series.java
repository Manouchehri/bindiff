package org.jfree.data.general;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.swing.event.EventListenerList;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.util.ObjectUtilities;

public abstract class Series implements Serializable, Cloneable {
   private static final long serialVersionUID = -6906561437538683581L;
   private Comparable key;
   private String description;
   private EventListenerList listeners;
   private PropertyChangeSupport propertyChangeSupport;
   private boolean notify;
   static Class class$org$jfree$data$general$SeriesChangeListener;

   protected Series(Comparable var1) {
      this(var1, (String)null);
   }

   protected Series(Comparable var1, String var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         this.key = var1;
         this.description = var2;
         this.listeners = new EventListenerList();
         this.propertyChangeSupport = new PropertyChangeSupport(this);
         this.notify = true;
      }
   }

   public Comparable getKey() {
      return this.key;
   }

   public void setKey(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         Comparable var2 = this.key;
         this.key = var1;
         this.propertyChangeSupport.firePropertyChange("Key", var2, var1);
      }
   }

   public String getDescription() {
      return this.description;
   }

   public void setDescription(String var1) {
      String var2 = this.description;
      this.description = var1;
      this.propertyChangeSupport.firePropertyChange("Description", var2, var1);
   }

   public boolean getNotify() {
      return this.notify;
   }

   public void setNotify(boolean var1) {
      if(this.notify != var1) {
         this.notify = var1;
         this.fireSeriesChanged();
      }

   }

   public Object clone() {
      Series var1 = (Series)super.clone();
      var1.listeners = new EventListenerList();
      var1.propertyChangeSupport = new PropertyChangeSupport(var1);
      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Series)) {
         return false;
      } else {
         Series var2 = (Series)var1;
         return !this.getKey().equals(var2.getKey())?false:ObjectUtilities.equal(this.getDescription(), var2.getDescription());
      }
   }

   public int hashCode() {
      int var1 = this.key.hashCode();
      var1 = 29 * var1 + (this.description != null?this.description.hashCode():0);
      return var1;
   }

   public void addChangeListener(SeriesChangeListener var1) {
      this.listeners.add(class$org$jfree$data$general$SeriesChangeListener == null?(class$org$jfree$data$general$SeriesChangeListener = class$("org.jfree.data.general.SeriesChangeListener")):class$org$jfree$data$general$SeriesChangeListener, var1);
   }

   public void removeChangeListener(SeriesChangeListener var1) {
      this.listeners.remove(class$org$jfree$data$general$SeriesChangeListener == null?(class$org$jfree$data$general$SeriesChangeListener = class$("org.jfree.data.general.SeriesChangeListener")):class$org$jfree$data$general$SeriesChangeListener, var1);
   }

   public void fireSeriesChanged() {
      if(this.notify) {
         this.notifyListeners(new SeriesChangeEvent(this));
      }

   }

   protected void notifyListeners(SeriesChangeEvent var1) {
      Object[] var2 = this.listeners.getListenerList();

      for(int var3 = var2.length - 2; var3 >= 0; var3 -= 2) {
         if(var2[var3] == (class$org$jfree$data$general$SeriesChangeListener == null?(class$org$jfree$data$general$SeriesChangeListener = class$("org.jfree.data.general.SeriesChangeListener")):class$org$jfree$data$general$SeriesChangeListener)) {
            ((SeriesChangeListener)var2[var3 + 1]).seriesChanged(var1);
         }
      }

   }

   public void addPropertyChangeListener(PropertyChangeListener var1) {
      this.propertyChangeSupport.addPropertyChangeListener(var1);
   }

   public void removePropertyChangeListener(PropertyChangeListener var1) {
      this.propertyChangeSupport.removePropertyChangeListener(var1);
   }

   protected void firePropertyChange(String var1, Object var2, Object var3) {
      this.propertyChangeSupport.firePropertyChange(var1, var2, var3);
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
