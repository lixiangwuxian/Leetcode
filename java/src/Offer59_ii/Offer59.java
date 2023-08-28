package Offer59_ii;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Pair{
    int first;
    int second;
    public Pair(int count,int val){
        first=count;
        second=val;
    }
}

class MaxQueue {
    Queue<Integer> numsQeque=new ArrayDeque<>();
    Deque<Pair> maxDeque=new ArrayDeque<>();
    Integer popCount=0;
    Integer count=0;

    public MaxQueue() {}
    
    public int max_value() {
        if(maxDeque.peek()==null){
            return -1;
        }
        while(maxDeque.peek()!=null&&maxDeque.peekFirst().first<popCount){
            maxDeque.removeFirst();
        }
        if(maxDeque.peek()==null){
            return -1;
        }
        return maxDeque.peekFirst().second;
    }
    
    public void push_back(int value) {
        numsQeque.add(value);
        while(maxDeque.peek()!=null&&maxDeque.peekLast().second<value){
            maxDeque.removeLast();
        }
        maxDeque.addLast(new Pair(count, value));
        count++;
    }
    
    public int pop_front() {
        if(numsQeque.peek()==null){
            return -1;
        }
        popCount++;
        return numsQeque.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */

public class Offer59 {
    
}
