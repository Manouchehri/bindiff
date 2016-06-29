package org.jfree.data.gantt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimePeriod;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class Task implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 1094303785346988894L;
   private String description;
   private TimePeriod duration;
   private Double percentComplete;
   private List subtasks;

   public Task(String var1, TimePeriod var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'description\' argument.");
      } else {
         this.description = var1;
         this.duration = var2;
         this.percentComplete = null;
         this.subtasks = new ArrayList();
      }
   }

   public Task(String var1, Date var2, Date var3) {
      this(var1, new SimpleTimePeriod(var2, var3));
   }

   public String getDescription() {
      return this.description;
   }

   public void setDescription(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'description\' argument.");
      } else {
         this.description = var1;
      }
   }

   public TimePeriod getDuration() {
      return this.duration;
   }

   public void setDuration(TimePeriod var1) {
      this.duration = var1;
   }

   public Double getPercentComplete() {
      return this.percentComplete;
   }

   public void setPercentComplete(Double var1) {
      this.percentComplete = var1;
   }

   public void setPercentComplete(double var1) {
      this.setPercentComplete(new Double(var1));
   }

   public void addSubtask(Task var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'subtask\' argument.");
      } else {
         this.subtasks.add(var1);
      }
   }

   public void removeSubtask(Task var1) {
      this.subtasks.remove(var1);
   }

   public int getSubtaskCount() {
      return this.subtasks.size();
   }

   public Task getSubtask(int var1) {
      return (Task)this.subtasks.get(var1);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Task)) {
         return false;
      } else {
         Task var2 = (Task)var1;
         return !ObjectUtilities.equal(this.description, var2.description)?false:(!ObjectUtilities.equal(this.duration, var2.duration)?false:(!ObjectUtilities.equal(this.percentComplete, var2.percentComplete)?false:ObjectUtilities.equal(this.subtasks, var2.subtasks)));
      }
   }

   public Object clone() {
      Task var1 = (Task)super.clone();
      return var1;
   }
}
