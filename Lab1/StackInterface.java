public interface StackInterface<E>{
  void push(E e);
  boolean isEmpty();
  E top();
  E pop();
  int size();
}
