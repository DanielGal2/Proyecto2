package Proyecto2;

import java.util.ArrayList;

public class Sensor {
 
    //Atributos
 
    private String tipo;
    private double valor;
    public static ArrayList<Sensor> sensores = new ArrayList<>();
 
    //Metodos
 
    public Sensor() {
 
    }
 
    public Sensor(String t, double v) {
 
        this.tipo = t;
        this.valor = v;
        sensores.add(this);
    }
 
    public String toString() {
 
        return "Tipo: " + this.tipo + "\n" + "Valor: " + this.valor + "\n";
    }
 
    public static Sensor[] sensoresOrdenadosTemperatura(){
 
        ArrayList<Sensor> arregloOrdenado = (ArrayList) sensores.clone();
 
        for(int x = 0; x < arregloOrdenado.size(); x++) {
 
            for (int i = 0; i < arregloOrdenado.size()-x-1; i++) {
 
                if(arregloOrdenado.get(i).getValor() > arregloOrdenado.get(i+1).getValor()){
 
                    Sensor temp = arregloOrdenado.get(i+1);
                    arregloOrdenado.set(i+1,arregloOrdenado.get(i));
                    arregloOrdenado.set(i, temp);
                }
            }
        }
 
        int vContador = 0;
 
        for(int i = 0; i < arregloOrdenado.size(); i++) {
 
            if(arregloOrdenado.get(i).getTipo().equalsIgnoreCase("temperatura")) {
 
                vContador++;
            }
        }
 
        Sensor[] arregloFinal = new Sensor[vContador];
        vContador = 0;
 
        for(int i = 0; i < arregloOrdenado.size(); i++) {
 
            if(arregloOrdenado.get(i).getTipo().equalsIgnoreCase("temperatura")) {
 
                arregloFinal[vContador] = arregloOrdenado.get(i);
                vContador++;
            }
        }
 
        return arregloFinal;
    }
 
    //Getters
 
    public String getTipo() {
 
        return this.tipo;
    }
 
    public double getValor(){
 
        return this.valor;
    }
 
    //Setters
 
    public void setTipo(String t) {
 
        this.tipo = t;
    }
 
    public void setValor(double v) {
 
        this.valor = v;
    }
}