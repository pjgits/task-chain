package com.task.chain.queue;

import com.task.chain.define.TaskLevel;
import com.task.chain.task.AbstractTask;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pengj on 2017-03-10.
 */
public class NormalTaskQueue {
    private Node head;
    private AtomicInteger count = new AtomicInteger(0);

    public NormalTaskQueue(){
        Node low = new Node(9,null);
        Node mid = new Node(5,low);
        head = new Node(1,mid);
    }

    public void addTask(AbstractTask task) throws InterruptedException {
        Node node = head;
        while(node.next!=null){
            if(node.level.getLevel()==task.getLevel().getLevel()){

                node.data.put(task);
                count.incrementAndGet();
            }
            node = node.next;
        }
    }

    public AbstractTask getTask(){
        Node node = head;
        AbstractTask task = null;
        while(node.next!=null){
            if((task = this.getNodeTask(node))!=null){
                return task;
            }
            node = node.next;
        }
        return null;
    }
    public int getCount(){

        return count.get();
    }

    private AbstractTask getNodeTask(Node node){
       return node.data.poll();
    }

    private static class Node{
        TaskLevel level;
        Node next;
        LinkedBlockingQueue<AbstractTask> data;
        public Node(int level,Node node){
            this.level = TaskLevel.createByLevel(level);
            this.next = node;
            data = new LinkedBlockingQueue<AbstractTask>();
        }
    }
}
