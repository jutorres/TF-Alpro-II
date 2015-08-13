import java.io.IOException;
import java.util.Iterator;


public class App {
    public static void main(String[] args) throws IOException{            
        JanelaConsulta janela = new JanelaConsulta();
        janela.setVisible(true);      
    
        
       
//    ListaPontosTaxis listaDePontos = ListaPontosTaxis.getInstance();
//    
//    if (listaDePontos.readPontosTaxis("taxis.csv")==false){
//            System.out.println("Problemas na leitura do arquivo!");
//        }
//        
//    System.out.println(listaDePontos.toString());
//    
    
        LeituraDados leit = new LeituraDados();
        LeituraDados leit2 = new LeituraDados();
        
        leit.readOcorrencias("roubos.csv");
        leit.readOcorrencias("furtos.csv");
        leit.readPontosTaxis("taxis.csv");        
        System.out.println(leit.calculaCriminalidade());
        
        
        
//    ListaOcorrencias ocorr = ListaOcorrencias.getInstance();
//    
//        if (ocorr.readRoubos("roubos.csv")==false){
//            System.out.println("Problemas na leitura do arquivo!");
//        }
        
//        if (ocorr.readFurtos("furtos.csv")==false){
//            System.out.println("Problemas na leitura do arquivo!");
//        }
        
        // Estão sendo adicionados na mesma lista.
    
//    System.out.println(ocorr.toString());
    
    }
    
    
}     

    
