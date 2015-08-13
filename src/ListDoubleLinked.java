
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Classe ListDoubleLinked: implementa uma lista duplamente
 * encadeada genérica com sentinelas.
 * @author Isabel Harb Manssour
 */
public class ListDoubleLinked<E> implements ListTAD<E> {
    // Referência para o sentinela de início da lista encadeada.
    private Node<E> header;
    // Referência para o sentinela de fim da lista encadeada.
    private Node<E> trailer;
    // Contador do número de elementos da lista.
    private int count;

     private class Node<T> {
        public T element;
        public Node<T> next;
        public Node<T> prev;
        public Node(T e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public ListDoubleLinked() {
        header = new Node<>(null);
        trailer = new Node<>(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return (new Iterator<E>() {
            private Node<E> current = header.next;

            @Override
            public boolean hasNext() {
                return current != trailer;
            }

            @Override
            public E next() {
                if (current == trailer) {
                    throw new NoSuchElementException();
                }
                E item = current.element;
                current = current.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        });
    }

    @Override
    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(E element) {
        Node<E> n = new Node<>(element);
        Node<E> last = trailer.prev;
        n.prev = last;
        n.next = trailer;
        last.next = n;
        trailer.prev = n;
        count++;       
    }

    @Override
    /**
     * Insere um elemento em uma determinada posição da lista
     * @param index a posição da lista onde o elemento será inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        
        Node<E> n = new Node<>(element);
        
        if(index == count){
            n.next = trailer;
            n.prev = trailer.prev;
            trailer.prev.next = n;
            trailer.prev = n;
        } else {
            Node<E> aux = getRefNode(index);
            n.next = aux;
            n.prev = aux.prev;
            aux.prev.next = n;
            aux.prev = n;
        }
        
        count++;
    }

    @Override
    /**
     * Remove a primeira ocorrência do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contém o elemento especificado
     */
    public boolean remove(E element) {
        Node<E> aux = header.next;
        while(aux != trailer){
            if(element.equals(aux.element)){
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    @Override
    /**
     * Remove o elemento de uma determinada posição da lista
     * @param index a posição da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public E remove(int index) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        
        E removido = null;
        Node<E> aux = getRefNode(index);
        
        removido = aux.element;
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        count--;
        
        
        return removido;
    }

    @Override
    /**
     * Retorna o elemento de uma determinada posição da lista
     * @param index a posição da lista
     * @return o elemento da posição especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public E get(int index) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        
        Node<E> aux = getRefNode(index);
        
        return aux.element;
    }
	
    @Override
    /**
     * Retorna true se a lista contém o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(E element) {
        Node<E> aux = header.next;
        while (aux != trailer) {
            if (aux.element.equals(element)) {
                return (true);
            }
            aux = aux.next;
        }
        return false;
    }

    @Override
    /**
     * Retorna o índice da primeira ocorrência do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o índice da primeira ocorrência do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(E element) {
        Node<E> aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    @Override
   /**
    * Substitui o elemento armanzenado em uma determinada posição da lista pelo elemento indicado
    * @param index a posição da lista
    * @param element o elemento a ser armazenado na lista
    * @return o elemento armazenado anteriormente na posição da lista
    * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
    */
    public E set(int index, E element) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        
        Node<E> aux = getRefNode(index);
        
        E elementoAlterado = aux.element;
        aux.element = element;

        return elementoAlterado;
    }

    @Override
    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node<>(null);
        trailer = new Node<>(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }    
    
    @Override
    /**
     * Retorna o número de elementos da lista
     * @return o número de elementos da lista
     */
    public int size() {
        return count;
    }

    @Override
    /**
     * Retorna true se a lista não contêm elementos
     * @return true se a lista não contêm elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }
    
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node<E> aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }
    
    
    // Otimizar código, para nao 
    // private pois ninguem vai enxergar esse metodo.
    
    private Node<E> getRefNode(int index){

        Node<E> aux = null;
        
        if(index <= (count / 2)){
            aux = header.next;
            for(int i = 0; i < index ; i++)
                aux = aux.next;
        } else {
            aux = trailer.prev;
            for(int i = count-1 ; i > index ; i--){
                aux = aux.prev;
            }
        }
        return aux;
    }
    
    
    public Iterator<E> iteratorBackToFront(){
        
        return (new Iterator<E>() {
            private Node<E> current = trailer.prev;

            @Override
            public boolean hasNext() {
                return current != header;
            }

            @Override
            public E next() {
                if (current == header) {
                    throw new NoSuchElementException();
                }
                E item = current.element;
                current = current.prev;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        });  
    } 
    
}
