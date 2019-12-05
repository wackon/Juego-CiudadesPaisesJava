/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author docenteitm
 */
public class Ciudades {

    String codigo;
    String nombre;
    String ruta;
    String codigoPais;
    Paises pais;

    public Ciudades(String codigo, String nombre, String ruta, String codigoPais, Paises pais) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ruta = ruta;
        this.codigoPais = codigoPais;
        this.pais = pais;
    }

    public Ciudades() {
        this.codigo = "";
        this.nombre = "";
        this.ruta = "";
        this.codigoPais = "";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

}
