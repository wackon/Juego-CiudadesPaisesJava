/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JOptionPane;
import modelo.Paises;

/**
 *
 * @author docenteitm
 */
public class ControlPais {

    Paises objPaises;

    public ControlPais(Paises objPaises) {
        this.objPaises = objPaises;
    }

    public void guardar() {
        String cod = objPaises.getCodigo();
        String nom = objPaises.getNombre();

        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaEscritura("paises.txt");

        boolean sw = esta_no_esta();
        if (sw == false) {
            String cadPais = cod + "," + nom;
            objArchivos.escribirUnaLineaYDebajo(cadPais);

        } else {
            JOptionPane.showMessageDialog(null, "El codigo ingresado ya existe");
        }
        objArchivos.cerrarArchivoParaEscritura();

    }

    public void modificar() {
        String linea;
        String[] arrLinea;
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaLectura("paises.txt");
        long nLineas = objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();

        Archivos objArchivos1 = new Archivos();
        objArchivos1.abrirArchivoParaEscritura("paises.tmp");
        objArchivos.abrirArchivoParaLectura("paises.txt");
        int i = 1;
        while (i <= nLineas) {
            linea = objArchivos.leerUnaLineaTexto();
            arrLinea = linea.split(",");
            if (!arrLinea[0].equals(objPaises.getCodigo())) {
                objArchivos1.escribirUnaLineaYDebajo(linea);
            } else {
                String cod = objPaises.getCodigo();
                String nom = objPaises.getNombre();
                String cadPais = cod + "," + nom;
                objArchivos1.escribirUnaLineaYDebajo(cadPais);
            }
            i = i + 1;
        }
        objArchivos1.cerrarArchivoParaEscritura();
        objArchivos.cerrarArchivoParaLectura();

        Archivos objArchivos2 = new Archivos();
        objArchivos2.borrarUnArchivo("paises.txt");
        objArchivos2.renombrarUnArchivo("paises.tmp", "paises.txt");
        objArchivos2.borrarUnArchivo("paises.tmp");
    }

    public void borrar() {
        String linea;
        String[] arr;

        String cod = objPaises.getCodigo();
        Archivos objArchivos1 = new Archivos();
        objArchivos1.abrirArchivoParaEscritura("paises.tmp");
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaLectura("paises.txt");
        long n = objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();
        objArchivos.abrirArchivoParaLectura("paises.txt");
        for (int i = 1; i <= n; i++) {
            linea = objArchivos.leerUnaLineaTexto();
            arr = linea.split(",");
            if (!cod.equals(arr[0])) {
                objArchivos1.escribirUnaLineaYDebajo(linea);
            }
        }
        objArchivos.cerrarArchivoParaLectura();
        objArchivos1.cerrarArchivoParaEscritura();
        objArchivos.borrarUnArchivo("paises.txt");
        objArchivos.renombrarUnArchivo("paises.tmp", "paises.txt");

    }

    public Paises consultar() {
        String cod = objPaises.getCodigo();
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaLectura("paises.txt");
        long n = objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();
        objArchivos.abrirArchivoParaLectura("paises.txt");
        int i = 1;

        while (i <= n) {
            String linea = objArchivos.leerUnaLineaTexto();
            String[] arr = linea.split(",");
            if (cod.equals(arr[0])) {
                objPaises.setNombre(arr[1]);
                i = (int) n + 1;
            }
            i++;
        }
        objArchivos.cerrarArchivoParaLectura();
        return objPaises;
    }

    public boolean esta_no_esta() {
        String cad;
        String[] arrCad;
        String cod = objPaises.getCodigo();
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaLectura("paises.txt");
        int i = 0;
        long n = objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();
        boolean sw = false;
        objArchivos.abrirArchivoParaLectura("paises.txt");
        while (i < n && sw == false) {
            cad = objArchivos.leerUnaLineaTexto();
            arrCad = cad.split(",");
            if (arrCad[0].equals(cod)) {
                sw = true;
            }
            i = i + 1;
        }
        objArchivos.cerrarArchivoParaLectura();
        return sw;
    }

    public String[][] listar() {//mejorar este algoritmo en caso de que el archivo sea grande ya que la matriz no resiste muchso datos
        String[][] mat;
        String linea;
        String[] arrLin;
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaLectura("paises.txt");
        long n = objArchivos.contarLineas();
        mat = new String[(int) n][2];
        objArchivos.cerrarArchivoParaLectura();
        objArchivos.abrirArchivoParaLectura("paises.txt");
        for (long i = 0; i < n; i++) {
            linea = objArchivos.leerUnaLineaTexto();
            arrLin = linea.split(",");
            for (int j = 0; j < 2; j++) {
                mat[(int) i][j] = arrLin[j];
            }
        }
        objArchivos.cerrarArchivoParaLectura();
        return mat;
    }
}
