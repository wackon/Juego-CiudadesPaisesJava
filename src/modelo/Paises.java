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
public class Paises {

    String codigo;
    String nombre;

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

    public Paises(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Paises() {
        this.codigo = "";
        this.nombre = "";
    }

}
