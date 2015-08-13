/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.GeoPosition;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 *
 * @author 14203025
 */
public class JanelaConsulta extends javax.swing.JFrame {

    private GerenciadorMapa gerenciador;
    private JanelaConsulta.EventosMouse mouse;
    
    private LeituraDados leituraDosDados;
    
    private Ocorrencias ocorrencias;
    private PontosTaxis pontosTaxis;
    
    private JPanel painelMapa;
    private JPanel painelLateral1;
    private JPanel painelLateral2;
     
    
    /**
     * Creates new form JanelaConsulta
     */
    public JanelaConsulta() {
    	super();    	
        //initComponents();

        GeoPosition poa = new GeoPosition(-30.05, -51.18);
        gerenciador = new GerenciadorMapa(poa, GerenciadorMapa.FonteImagens.VirtualEarth);
        mouse = new JanelaConsulta.EventosMouse();        		
        gerenciador.getMapKit().getMainMap().addMouseListener(mouse);
        gerenciador.getMapKit().getMainMap().addMouseMotionListener(mouse);       
        
        leituraDosDados = new LeituraDados();
        
        painelMapa = new JPanel();
        painelMapa.setLayout(new BorderLayout());
        painelMapa.add(gerenciador.getMapKit(), BorderLayout.CENTER);
                
        getContentPane().add(painelMapa, BorderLayout.CENTER);
        
        painelLateral1 = new JPanel();
        getContentPane().add(painelLateral1, BorderLayout.NORTH);
        
        painelLateral2 = new JPanel();
        getContentPane().add(painelLateral2, BorderLayout.SOUTH);
        
        JButton btnNewButton = new JButton("Paradas de táxi (região/distância)");
        btnNewButton.addActionListener(new ActionListener() {
                @Override
        	public void actionPerformed(ActionEvent e) {
        		consulta(e);
        	}
        });
        painelLateral1.add(btnNewButton);
        
        this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                
        JButton btnNewButton2 = new JButton("Paradas de táxi (região/criminalidade)");
        btnNewButton2.addActionListener(new ActionListener() {
                @Override
        	public void actionPerformed(ActionEvent e) {
        		consulta(e);
        	}
        });
        painelLateral1.add(btnNewButton2);
        
        this.setSize(800,900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        JButton btnNewButton6 = new JButton("Paradas de táxi (rua/distância)");
        btnNewButton6.addActionListener(new ActionListener() {
                @Override
        	public void actionPerformed(ActionEvent e) {
        		consulta(e);
        	}
        });
        painelLateral1.add(btnNewButton6);
        
        this.setSize(800,900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        JButton btnNewButton7 = new JButton("Paradas de táxi (rua/criminalidade)");
        btnNewButton7.addActionListener(new ActionListener() {
                @Override
        	public void actionPerformed(ActionEvent e) {
        		consulta(e);
        	}
        });
        painelLateral1.add(btnNewButton7);
        
        this.setSize(800,900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        JButton btnNewButton3 = new JButton("As 10 paradas de táxi mais perigosas");
        btnNewButton3.addActionListener(new ActionListener() {
                @Override
        	public void actionPerformed(ActionEvent e) {
        		consulta(e);
        	}
        });
        painelLateral2.add(btnNewButton3);
        
        this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        JButton btnNewButton4 = new JButton("10 paradas mais seguras (madrugada)");
        btnNewButton4.addActionListener(new ActionListener() {
                @Override
        	public void actionPerformed(ActionEvent e) {
        		consulta(e);
        	}
        });
        painelLateral2.add(btnNewButton4);
        
        this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        JButton btnNewButton5 = new JButton("10 paradas mais seguras (consulta/dia)");
        btnNewButton5.addActionListener(new ActionListener() {
                @Override
        	public void actionPerformed(ActionEvent e) {
        		consulta(e);
        	}
        });
        painelLateral2.add(btnNewButton5);
        
        this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    private void consulta(java.awt.event.ActionEvent evt) {

        // Para obter o centro e o raio, usar como segue:
    	GeoPosition centro = gerenciador.getSelecaoCentro();
    	int raio = gerenciador.getRaio();        

        // Lista para armazenar o resultado da consulta
        List<MyWaypoint> lstPoints = new ArrayList<>();
        
        
        double valor = 250; // ex: valor da consulta (criminalidade ou distância)
        GeoPosition loc = new GeoPosition(-30.05, -51.18); // ex: localização da parada
        lstPoints.add(new MyWaypoint(Color.BLUE, valor, loc));            

        valor = 100;
        loc = new GeoPosition(-30.0525, -51.181); // ex: localização da parada
        lstPoints.add(new MyWaypoint(Color.BLUE, valor, loc));
        
        // Informa o resultado para o gerenciador
        gerenciador.setPontos(lstPoints);
        // Informa o intervalo de valores gerados, para calcular a cor de cada ponto
        double menorValor = 15;  // exemplo
        double maiorValor = 250; // exemplo
        gerenciador.setIntervaloValores(menorValor, maiorValor);        
        
        this.repaint();
//       
//        
        // Ideia sobre leitura e colocar os pontos no mapa. ainda não está certo...
        ListDoubleLinked<LeituraDados> lista1 = new ListDoubleLinked<>();
        
        try{
        leituraDosDados.readOcorrencias("roubos.csv");
        leituraDosDados.readOcorrencias("taxis.csv");
        leituraDosDados.calculaCriminalidade();
        } catch(IOException e){
            System.err.format("Erro de E/S: %s%n", e);
        }
//        
//        
//        
//        
//        List<MyWaypoint> listaPontosMapa = new ArrayList<>();
//        valor = 0;
//        loc = new GeoPosition(pontosTaxis.getLatitude(), pontosTaxis.getLongitude());
//        listaPontosMapa.add(new MyWaypoint(Color.BLUE, valor, loc)); 
//        

    }
    
    private class EventosMouse extends MouseAdapter
    {
    	private int lastButton = -1;    	
    	
    	@Override
    	public void mousePressed(MouseEvent e) {
    		JXMapViewer mapa = gerenciador.getMapKit().getMainMap();
    		GeoPosition loc = mapa.convertPointToGeoPosition(e.getPoint());
//    		System.out.println(loc.getLatitude()+", "+loc.getLongitude());
    		lastButton = e.getButton();
    		// Botão 3: seleciona localização
    		if(lastButton==MouseEvent.BUTTON3) {  			
    			gerenciador.setSelecaoCentro(loc);
    			gerenciador.setSelecaoBorda(loc);
    			//gerenciador.getMapKit().setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    			gerenciador.getMapKit().repaint();    			
    		}
    	}    
        
            @Override
    	public void mouseDragged(MouseEvent e) {
    		// Arrasta com o botão 3 para definir o raio
    		if(lastButton ==  MouseEvent.BUTTON3) {    			
    			JXMapViewer mapa = gerenciador.getMapKit().getMainMap();
    			gerenciador.setSelecaoBorda(mapa.convertPointToGeoPosition(e.getPoint()));
    			gerenciador.getMapKit().repaint();
    		}    			
    	}
        
        
        
    /**
     * Creates new form JanelaConsul
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelMapa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlstDistancia = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlstViolencia = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button1 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout painelMapaLayout = new javax.swing.GroupLayout(painelMapa);
        painelMapa.setLayout(painelMapaLayout);
        painelMapaLayout.setHorizontalGroup(
            painelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );
        painelMapaLayout.setVerticalGroup(
            painelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jlstDistancia.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlstDistancia);

        jlstViolencia.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jlstViolencia);

        jButton1.setText("Consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Por distancia:");
        jLabel1.setToolTipText("");

        jLabel2.setText("Por violencia:");

        button1.setLabel("button1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList jlstDistancia;
    private javax.swing.JList jlstViolencia;
    private javax.swing.JPanel painelMapa;
    // End of variables declaration//GEN-END:variables

    }
}