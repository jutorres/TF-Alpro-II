/**
 *
 * @author bruno
 */

public class Ocorrencias {
    private String tipoEndereco;
    private String logradouro;
    private String numero;
    private String faixaHoraria;
    private String diaSemana;
    private String latit;
    private String longit;
    private double latitude;
    private double longitude;
    private int grauCrimin;

    public Ocorrencias(String tipoEndereco, String logradouro, String numero, String faixaHoraria, String diaSemana, String latit, String longit) {
        this.tipoEndereco = tipoEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.faixaHoraria = faixaHoraria;
        this.diaSemana = diaSemana;
        this.latit = latit;
        this.longit = longit;
    }

    public Ocorrencias(String tipoEndereco, String logradouro, String numero, String faixaHoraria, String diaSemana, double latitude, double longitude) {
        this.tipoEndereco = tipoEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.faixaHoraria = faixaHoraria;
        this.diaSemana = diaSemana;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getNumero() {
        return numero;
    }

    public String getFaixaHoraria() {
        return faixaHoraria;
    }

    public String getDiaSemana() {
        return diaSemana;
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
        return "\n\t Registro de Ocorrencias:\n"
               + "\tEndereço: " + tipoEndereco + " " + logradouro + "\n"
               + "\tNumero: " + numero + "\n"
               + "\tFaixa Horária: " + faixaHoraria + "\n"
               + "\tDia da Semana: " + diaSemana + "\n"
               + "\tLatitude: " + latitude + "\n"
               + "\tLongitude: " + longitude;
    }
}
