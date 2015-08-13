
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author bruno
 */
public class ListaQuadrupla {
    
    // Referência para o sentinela de início da lista encadeada.
    private Node header;
    // Referência para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Contador do número de elementos da lista.
    private int count;

    private class Node {
        public PontosTaxis ponto;
        public Node next;
        public Node prev;
        public Node(PontosTaxis p) {
            ponto = p;
            next = null;
            prev = null;
        }
    }
    
    public ListaQuadrupla() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }
    
    public int size() {
        return count;
    }
    
    public void add(PontosTaxis ponto) {
        Node p = new Node(ponto);
        Node last = trailer.prev;
        p.prev = last;
        p.next = trailer;
        last.next = p;
        trailer.prev = p;
        count++;
        System.out.println(ponto);
    }
//    
//    public void addOrdenada(PontosTaxis ponto) {
//        Node p = new Node(ponto);
//        
//        if (count == 0) {
//            header.next = p;
//            trailer.prev = p;
//            p.prev = header;
//            p.next = trailer;
//            System.out.println(ponto);
//        }
//        Node aux = header.next;
//        if (ponto.getGrauCrimin() > aux.ponto.getGrauCrimin()) {
//            for (int i = 0; i < count; i++) {
//                p.next = aux;
//                p.prev = aux.prev;
//                aux.prev.next = p;
//                aux.prev = p;
//                System.out.println(ponto);
//            }
//        } else {
//            p.next = trailer;
//            p.prev = trailer.prev;
//            trailer.prev = p;
//            p.prev.next = p;
//            System.out.println(ponto);
//        }
//        count++;
//    }
//           
//    
//    
//    public void addOrdenada2(PontosTaxis ponto) {
//        Node p = new Node(ponto);
//        Node aux = header.next;
//
//        Node last = trailer.prev;
//        p.prev = last;
//        p.next = trailer;
//        last.next = p;
//        trailer.prev = p;
//        count++;
//        System.out.println(ponto);
//        
//        if (ponto.getGrauCrimin() > aux.ponto.getGrauCrimin()) {
//            for (int i = 0; i < count; i++) {
//                p.next = aux;
//                p.prev = aux.prev;
//                aux.prev.next = p;
//                aux.prev = p;
//                System.out.println(ponto);
//            }
//        } else {
//            p.next = trailer;
//            p.prev = trailer.prev;
//            trailer.prev = p;
//            p.prev.next = p;
//            System.out.println(ponto);
//        }
//        count++;
//    }
//    
     
//    public Iterator iteratorCrimin() {
//        return (new Iterator() {
//            private Node current = header.next;
//
//            @Override
//            public boolean hasNext() {
//                return current != trailer;
//            }
//
//            @Override
//            public PontosTaxis next() {
//                if (current == trailer) {
//                    throw new NoSuchElementException();
//                }
//                PontosTaxis item = current.ponto;
//                current = current.next;
//                return item;
//            }
//       
//                
    
//     
//     add
//             
//             
//             
//             
//             iteradorcrim
//             
//             iteratordist
//             
//             
//     



}
