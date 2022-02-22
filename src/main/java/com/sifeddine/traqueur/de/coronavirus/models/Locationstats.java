package com.sifeddine.traqueur.de.coronavirus.models;

public class Locationstats {
    private String pays;
    private String nombreTotalDeCas;
    private String nombreTotalDeDeces;
    private String personnesEntierementVaccinees;

    public String getPersonnesEntierementVaccinees() {
        return personnesEntierementVaccinees;
    }

    public void setPersonnesEntierementVaccinees(String personnesEntierementVaccinees) {
        this.personnesEntierementVaccinees = personnesEntierementVaccinees;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getNombreTotalDeCas() {
        return nombreTotalDeCas;
    }

    public void setNombreTotalDeCas(String nombreTotalDeCas) {
        this.nombreTotalDeCas = nombreTotalDeCas;
    }

    public String getNombreTotalDeDeces() {
        return nombreTotalDeDeces;
    }

    public void setNombreTotalDeDeces(String nombreTotalDeDeces) {
        this.nombreTotalDeDeces = nombreTotalDeDeces;
    }
}
