/**
 *
 * @author 14203025
 */

public class PontosTaxis {
    private int codigoParada;
    private String tipoEndereco;
    private String logradouro;
    private String telefone;
    private String latit;
    private String longit;
    private double latitude;
    private double longitude;
    private int grauCrimin;
    
    

    public PontosTaxis(int codigoParada, String tipoEndereco, String logradouro, String telefone, String longit, String latit){
        this.codigoParada = codigoParada;
        this.tipoEndereco = tipoEndereco;
        this.logradouro = logradouro;
        this.telefone = telefone;
        this.longit = longit;
        this.latit = latit;
    }
    
    public PontosTaxis(int codigoParada, String tipoEndereco, String logradouro, String telefone, double longitude, double latitude){
        this.codigoParada = codigoParada;
        this.tipoEndereco = tipoEndereco;
        this.logradouro = logradouro;
        this.telefone = telefone;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getCodigoParada() {
        return codigoParada;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }
    
    public String getEndereco(){
        String end = getTipoEndereco() + " " + getLogradouro();
        return end;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getLatit() {
        return latit;
    }

    public String getLongit() {
        return longit;
    }

    public int getGrauCrimin() {
        return grauCrimin;
    }

    public void setGrauCrimin(int grauCrimin) {
        this.grauCrimin = grauCrimin;
    }
    
    

    @Override
    public String toString() {
        return "\n\tPontos de Taxi:\n"
               + "\tCódigo da Parada: " + codigoParada + "\n"
               + "\tEndereço: " + tipoEndereco + " " + logradouro + "\n"
               + "\tTelefone: " + telefone + "\n"
               + "\tLatitude: " + latitude + "\n"
               + "\tLongitude: " + longitude + "\n"
               + "\tGrau Criminalidade: " + grauCrimin;  
    }
    
    
    
    
}
