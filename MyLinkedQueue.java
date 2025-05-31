
package estrutura;

        @SuppressWarnings("unchecked")
public class MyLinkedQueue<E> implements MyQueue<E> {
   private static class Node<E> {
       E value;
       Node<E> next;
       Node(E v){ this.value = v; }
   }

   private Node<E> head;  // retirada
   private Node<E> tail;  // inserção
   private int size;

   @Override
   public void enqueue(E e) {
       Node<E> novo = new Node(e);
       if (tail != null) {
           tail.next = novo;
       } else {
           head = novo;
       }
       tail = novo;
       size++;
   }

   @Override
   public E dequeue() {
       if (head == null) return null;
       E v = head.value;
       head = head.next;
       if (head == null) tail = null;
       size--;
       return v;
   }

   @Override
   public boolean isEmpty() {
       return head == null;
   }

   @Override
   public int size() {
       return size;
   }

   @Override
   public void clear() {
       head = tail = null;
       size = 0;
   }
    
}
