package fr.evanperreau.service;

import fr.evanperreau.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TasksManagerService {

    private final List<Task> tasks;

    public TasksManagerService(){
        this.tasks = new ArrayList<Task>();
    }

    /**
     * Add a task to the task list
     * @param task the task to add
     */
    public void addTask(Task task){
        this.tasks.add(task);
    }

    /**
     * Method to get a task from the task list
     * @param index the index of the task you want to get
     * @return the task
     * @throws ArrayIndexOutOfBoundsException if the index parameter is greater than task list size
     */
    public Task getTask(int index){
        Task result;

        if (index >= this.tasks.size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        result = this.tasks.get(index);

        return result;
    }

    /**
     * Remove a task by he's index
     * @param index the index of the task to remove in the task list
     */
    public void removeTask(int index){
        if (index >= this.tasks.size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        this.tasks.remove(index);
    }

    /**
     * Delete a task from the task list if the task is present in the task list
     * @param task the task to remove
     */
    public void removeTask(Task task){
        this.tasks.remove(task);
    }

    /**
     * @return Expired tasks from task list
     */
    public List<Task> getExpiredTasks(){
        List<Task> result = new ArrayList<>();

        for (Task task : this.tasks){
            if (task.isExpired()){
                result.add(task);
            }
        }

        return result;
    }

    /**
     * @return Coming tasks from task list
     */
    public List<Task> getComingTasks(){
        List<Task> result = new ArrayList<>();

        for(Task task : this.tasks){
            if(task.isComing()){
                result.add(task);
            }
        }

        return result;
    }
}
