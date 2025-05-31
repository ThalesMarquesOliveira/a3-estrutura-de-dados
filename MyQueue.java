
package estrutura;
    
// Contrato mínimo para uma fila dinâmica.
public interface MyQueue<E> {
   void enqueue(E e);       // Insere no fim da fila. 
    
   E dequeue();             // Remove e retorna do início da fila; retorna null se vazia. 

   boolean isEmpty();       // Retorna true se não houver elementos. 

   int size();              // Quantos elementos há na fila. 

   void clear();            // Limpa todos os elementos. 
}

