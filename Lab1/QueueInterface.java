public interface QueueInterface<E>{
  E dequeue();
  void enqueue(E e);
  int size();
  E first();
}
