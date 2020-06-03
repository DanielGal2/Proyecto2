package Proyecto2;

import java.util.ArrayList;

public class Vehiculo {
 
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    public static int idActual = 1;
 
    private int id;
    private int modelo;
    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();
    private String marca;
    private double valorComercial;
    private String color;
 
    public Vehiculo() {
 
        this.id = Vehiculo.idActual;
        Vehiculo.vehiculos.add(this);
        Vehiculo.idActual++;
    }
 
    public Vehiculo(int mo, String ma, double va) {
 
        this(mo, ma, va, "verde");
    }
 
    public Vehiculo(int mo, String ma, double va, String co) {
 
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = co;
        this.id = Vehiculo.idActual;
        Vehiculo.vehiculos.add(this);
        Vehiculo.idActual++;
    }
 
    public String toString() {
 
        String toString = "Id: "+this.getId()+"\nModelo: "+this.getModelo()+
                "\nMarca: "+this.getMarca()+"\nValor comercial: "+
                this.getValorComercial()+"\nColor: "+this.getColor()+"\n";
 
        for(Sensor s : this.sensores){
 
            toString = toString +"\n"+ s.toString(); //TODO
        }
 
        return toString;
    }
 
    public static String toStringVehiculos() {
 
        String toString = "";
 
        for(Vehiculo v: Vehiculo.vehiculos){
 
            toString = toString + v.toString()+"\n";
        }
 
        return toString;
    }
 
    public static String vehiculosColor(String c){
 
        String veh = "";
 
        for(Vehiculo v: Vehiculo.vehiculos){
 
            if(v.getColor().equalsIgnoreCase(c)){
 
                veh = veh + v.toString()+"\n";
            }
        }
 
        return veh;
    }
 
    public static int cantidadVehiculos() {
 
        return Vehiculo.vehiculos.size();
    }
 
    public int cantidadSensores(){
 
        return this.sensores.size();
    }
 
    public void anadirSensor(Sensor s){
 
        this.sensores.add(s);
    }
 
    //Getters
 
    public int getModelo() {
 
        return this.modelo;
    }
 
    public String getMarca() {
 
        return this.marca;
    }
 
    public double getValorComercial() {
 
        return this.valorComercial;
    }
 
    public String getColor() {
 
        return this.color;
    }
 
    public int getId(){
 
        return this.id;
    }
 
    public static Vehiculo getVehicleId(int i){
 
        if(Vehiculo.vehiculos.get(i-1) == null){
 
            return null;
        }
 
        return Vehiculo.vehiculos.get(i-1);
    }
 
    public ArrayList<Sensor> getSensores(){
 
        return this.sensores;
    }
 
    //Setters
 
    public void setModelo(int nuevoModelo) {
 
        this.modelo = nuevoModelo;
    }
 
    public void setMarca(String nuevaMarca) {
 
        this.marca = nuevaMarca;
    }
 
    public void setValorComercial(double nuevoValor) {
 
        this.valorComercial = nuevoValor;
    }
 
    public void setColor(String nuevoColor) {
 
        this.color = nuevoColor;
    }
 
    public void setSensores(ArrayList<Sensor> s){
 
        this.sensores = s;
    }
}