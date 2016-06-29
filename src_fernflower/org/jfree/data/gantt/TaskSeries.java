package org.jfree.data.gantt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jfree.data.gantt.Task;
import org.jfree.data.general.Series;

public class TaskSeries extends Series {
   private List tasks = new ArrayList();

   public TaskSeries(String var1) {
      super(var1);
   }

   public void add(Task var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'task\' argument.");
      } else {
         this.tasks.add(var1);
         this.fireSeriesChanged();
      }
   }

   public void remove(Task var1) {
      this.tasks.remove(var1);
      this.fireSeriesChanged();
   }

   public void removeAll() {
      this.tasks.clear();
      this.fireSeriesChanged();
   }

   public int getItemCount() {
      return this.tasks.size();
   }

   public Task get(int var1) {
      return (Task)this.tasks.get(var1);
   }

   public Task get(String var1) {
      Task var2 = null;
      int var3 = this.tasks.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         Task var5 = (Task)this.tasks.get(var4);
         if(var5.getDescription().equals(var1)) {
            var2 = var5;
            break;
         }
      }

      return var2;
   }

   public List getTasks() {
      return Collections.unmodifiableList(this.tasks);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof TaskSeries)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         TaskSeries var2 = (TaskSeries)var1;
         return this.tasks.equals(var2.tasks);
      }
   }
}
