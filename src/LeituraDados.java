

import algoritmos.AlgoritmosGeograficos;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author bruno
 */
public class LeituraDados {

    public ArrayList<PontosTaxis> listaTaxis;
    public ArrayList<Ocorrencias> listaOcorrencias;
    public ListaQuadrupla lstPontosTaxis = new ListaQuadrupla();
    
    
    public LeituraDados() {
        listaTaxis = new ArrayList<>();
        listaOcorrencias = new ArrayList<>();

    }

    public ArrayList<PontosTaxis> getListaTaxis() {
        return listaTaxis;
    }

    public ArrayList<Ocorrencias> getListaOcorrencias() {
        return listaOcorrencias;
    }
    
    
    
    public boolean readPontosTaxis(String nomeArq) {
        Path path2 = Paths.get(nomeArq);
        try(BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset())){
            String linha = null;
            while ((linha = br.readLine()) != null){
                // separador : ;
                Scanner sc = new Scanner(linha).useDelimiter(";");
                int codigoParada = Integer.parseInt(sc.next());
                
                String endereco = sc.next();
                
                String tipoEndereco = null;
                if(endereco.startsWith("R")){
                    tipoEndereco = endereco.substring(0,1);
                } else if (endereco.startsWith("A")){
                    tipoEndereco = endereco.substring(0,2);
                } else if(endereco.startsWith("L")){
                    tipoEndereco = endereco.substring(0,2);
                } else if (endereco.startsWith("P")){
                    tipoEndereco = endereco.substring(0,3);
                } else if(endereco.startsWith("T")) {
                    tipoEndereco = endereco.substring(0,4);
                }
                
                
                String logradouro = null;
                if(endereco.startsWith("R")){
                    logradouro = endereco.substring(2);
                } else if (endereco.startsWith("A")){
                    logradouro = endereco.substring(3);
                } else if(endereco.startsWith("L")){
                    logradouro = endereco.substring(3);
                } else if (endereco.startsWith("P")){
                    logradouro = endereco.substring(4);
                } else if(endereco.startsWith("T")) {
                    logradouro = endereco.substring(5);
                }
                
                String telefone = sc.next();
                if(telefone.equals("")){
                    telefone = "NÃO INFORMADO";
                }
                
                String longit = sc.next();               
                double longitude = Double.parseDouble(longit);
                
                String  latit = sc.next();               
                double latitude = Double.parseDouble(latit);

                
                PontosTaxis taxis = new PontosTaxis(codigoParada, tipoEndereco, logradouro, telefone, longitude, latitude);
                listaTaxis.add(taxis);
            }
        } catch(IOException e){
            System.err.format("Erro de E/S: %s%n", e);
            return false;
        }
        return true;
    }
    
    public boolean readOcorrencias(String nomeArq) throws IOException {
        Path path2 = Paths.get(nomeArq);
        try(BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset())){
            String linha = null;
            br.readLine();                                              // Ler cabeçalho do arquivo.
            while ((linha = br.readLine()) != null){
                // separador : ;
                Scanner sc = new Scanner(linha).useDelimiter(";");
                
                sc.next(); // Leitura Localidade
                
                sc.next(); // Leitura Bairro
                
                String endereco = sc.next().toUpperCase();
                if(endereco.equals(" ")){
                    endereco = "NÃO INFORMADO";
                }
                
                String tipoEndereco = null;
                if (endereco.startsWith("A")) {
                    tipoEndereco = endereco.substring(0, 2);
                } else if (endereco.startsWith("B")) {
                    tipoEndereco = endereco.substring(0, 2);
                } else if (endereco.startsWith("E")) {
                    tipoEndereco = endereco.substring(0, 4);
                } else if (endereco.startsWith("J")) {
                    tipoEndereco = endereco.substring(0, 2);
                } else if (endereco.startsWith("L")) {
                    tipoEndereco = endereco.substring(0, 2);
                } else if (endereco.startsWith("P")) {
                    tipoEndereco = endereco.substring(0, 3);
                } else if (endereco.startsWith("R")) {
                    tipoEndereco = endereco.substring(0, 3);
                } else if (endereco.startsWith("T")) {
                    tipoEndereco = endereco.substring(0, 2);
                } else if (endereco.startsWith("V")){
                    tipoEndereco = endereco.substring(0,3);
                }

                
                String logradouro = null;
                if (endereco.startsWith("A")) {
                    logradouro = endereco.substring(3);
                } else if (endereco.startsWith("B")) {
                    logradouro = endereco.substring(3);
                } else if (endereco.startsWith("E")) {
                    logradouro = endereco.substring(5);
                } else if (endereco.startsWith("J")) {
                    logradouro = endereco.substring(3);
                } else if (endereco.startsWith("L")) {
                    logradouro = endereco.substring(3);
                } else if (endereco.startsWith("P")) {
                    logradouro = endereco.substring(4);
                } else if (endereco.startsWith("R")) {
                    logradouro = endereco.substring(4);
                } else if (endereco.startsWith("T")) {
                    logradouro = endereco.substring(3);
                } else if (endereco.startsWith("V")){
                    logradouro = endereco.substring(4);
                }

                
                sc.next(); // Leitura do Ponto de Referência
                
                sc.next(); // leitura Coordenadas

                String numero = sc.next();
                if(numero.equals(" ")){
                    numero = "NÃO INFORMADO";
                }

                sc.next(); // Leitura Ocorrencia


                sc.next(); // Leitura Status


                sc.next(); // Leitura Data do Fato


                String faixaHoraria = sc.next();
                if(faixaHoraria.equals(" ")){
                    faixaHoraria = "NÃO INFORMADO";
                }

                String diaSemana = sc.next().toUpperCase();
                if(diaSemana.equals(" ")){
                    diaSemana = "NÃO INFORMADO";
                }
                
                
                String latit = sc.next();
                if(latit.equals(" ")){
                    latit = "0";
                }
                double latitude = Double.parseDouble(latit);

                String longit = sc.next();
                if(longit.equals(" ")){
                    longit = "0";
                }
                double longitude = Double.parseDouble(longit);

                Ocorrencias ocorr = new Ocorrencias(tipoEndereco, logradouro, numero, faixaHoraria, diaSemana, latitude, longitude);
                listaOcorrencias.add(ocorr);
            }
            
        } catch(IOException e){
            System.err.format("Erro de E/S: %s%n", e);
            return false;
        }
        return true;
        
        }
    
    public ListaQuadrupla calculaCriminalidade(){
        double valor;
        int cont;
        
        for(PontosTaxis pts : listaTaxis){
            cont=0;
            for(Ocorrencias oco : listaOcorrencias){
                valor = AlgoritmosGeograficos.haversine(pts.getLatitude(), pts.getLongitude(), oco.getLatitude(), oco.getLongitude());
                if(valor<=1.5){
                    cont++;                   
                }
            }
            pts.setGrauCrimin(cont);
            lstPontosTaxis.add(pts); // fazer adicao ordenada.
            
        }
        return lstPontosTaxis;
 
    }

    @Override
    public String toString() {
        return "LeituraDados{" + "listaTaxis=" + listaTaxis + ", listaOcorrencias=" + listaOcorrencias + '}';
    }
    
    
    
    
    
    
    
}

    

