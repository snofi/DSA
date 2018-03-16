public class Queue<E> implements QueueInterface<E>{

  Stack<E> enqueueStack = new Stack<>();
  Stack<E> dequeueStack = new Stack<>();

  public E dequeue(){
    if(dequeueStack.isEmpty()){
      while(!enqueueStack.isEmpty()){
        dequeueStack.push(enqueueStack.pop());
      }
    }
    return dequeueStack.pop();
  }

  public void enqueue(E e){
    enqueueStack.push(e);
  }

  public int size(){
    return enqueueStack.size() + dequeueStack.size();
  }

  public E first(){
    return dequeueStack.top();
  }

  public static void main(String[] args){
    Queue<Integer> q = new Queue<>();
    q.enqueue(1);
    q.enqueue(5);
    q.enqueue(6);

    System.out.println("dequeue " + q.dequeue());
    System.out.println("dequeue " + q.dequeue());
    q.enqueue(8);
    System.out.println("dequeue " + q.dequeue());
    System.out.println("size: " + q.size());


  }
}
