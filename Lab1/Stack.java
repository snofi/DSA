public class Stack<E> implements StackInterface<E>{
  
    private int index;
    private E[] data;

    public Stack() {
        data = (E[]) new Object[100];
        index = 0;
    }

    public void push(E e) {

        data[index] = e;
        index++;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public E top() {
        if(index == 0)
          return null;

        return data[index - 1];
    }


    public E pop() {
        E last = top();
        if (index > 0) {
            data[index - 1] = null;
            index--;
        }
        return last;
    }

    public int size() {
        return index;
    }

}
