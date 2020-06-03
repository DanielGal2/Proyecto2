package Proyecto2;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Principal {
 
    public static void main(String[] args) throws IOException {
 
        mostrarMenu();
    }
 
    public static void mostrarMenu() throws IOException {
 
        Scanner S = new Scanner(System.in);
 
        while(true){
 
            System.out.print("Ingresa un número: ");
            int vNumero = S.nextInt();
 
            switch(vNumero) {
 
                case 0:
                    System.out.print("\nEjecución finalizada.");
                    return;
 
                case 1:
                    System.out.print("\nIngresa el modelo: ");
                    int vModelo = S.nextInt();
 
                    System.out.print("Ingresa la marca: ");
                    String vMarca = S.next();
 
                    System.out.print("Ingresa el valor comercial: ");
                    double vValor = S.nextDouble();
 
                    System.out.print("Ingresa el color: ");
                    String vColor = S.next();
 
                    System.out.println();
 
                    Vehiculo vCarro = new Vehiculo(vModelo, vMarca, vValor, vColor);
                    continue;
 
                case 2:
                    if (Vehiculo.cantidadVehiculos() == 0) {
 
                        System.out.println("Arreglo vacío");
                        continue;
                    }
 
                    System.out.print("\n"+Vehiculo.toStringVehiculos());
                    continue;
 
                case 3:
                    System.out.println("\nCantidad de vehículos actual: " + Vehiculo.cantidadVehiculos()+"\n");
                    continue;
 
                case 4:
                    if (Vehiculo.cantidadVehiculos() == 0) {
 
                        System.out.println("Arreglo vacío");
                        continue;
                    }
 
                    if(Vehiculo.vehiculosColor("verde").equalsIgnoreCase("")){
 
                        System.out.println("\nNo hay vehículos de color verde\n");
                        continue;
                    }
 
                    System.out.print("\n"+Vehiculo.vehiculosColor("verde"));
                    continue;
 
                case 5:
 
                    if (Vehiculo.cantidadVehiculos() == 0) {
 
                        System.out.println("Arreglo vacío");
                        continue;
                    }
 
                    System.out.print("Ingrese un ID: ");
                    int id = S.nextInt();
 
                    try{
 
                        System.out.println("\n"+Vehiculo.getVehicleId(id).toString());
                        continue;
                    }
                    catch (Exception e) {
 
                        System.out.println("\nError, ese ID no corresponde a ningún vehículo.");
                        System.out.println("Excepción: "+e.getMessage()+"\n");
                        continue;
                    }
 
                case 6:
                    System.out.print("Ingrese un ID: ");
                    int id2 = S.nextInt();
                    Vehiculo vehiculo;
 
                    try{
 
                         vehiculo = Vehiculo.getVehicleId(id2);
 
                    } catch(Exception e){
 
                        System.out.println("\nError, ese ID no corresponde a ningún vehículo.");
                        System.out.println("Excepción: "+e.getMessage()+"\n");
                        continue;
                    }
 
                    System.out.print("\n(SENSOR) Ingrese un Tipo: ");
                    String tipo = S.next();
                    System.out.print("(SENSOR) Ingrese un Valor: ");
                    double valor = S.nextDouble();
                    System.out.println();
 
                    Sensor sensor = new Sensor(tipo, valor);
                    vehiculo.anadirSensor(sensor);
                    continue;
 
                case 7:
                    System.out.print("Ingrese un ID: ");
                    int id3 = S.nextInt();
                    Vehiculo vehiculo2;
 
                    try{
 
                        vehiculo2 = Vehiculo.getVehicleId(id3);
 
                    } catch(Exception e){
 
                        System.out.println("\nError, ese ID no corresponde a ningún vehículo.");
                        System.out.println("Excepción: "+e.getMessage()+"\n");
                        continue;
                    }
 
                    if(vehiculo2.getSensores().size() == 0){
 
                        System.out.println("\nEl vehículo no posee ningún sensor\n");
                        continue;
                    }
 
                    System.out.println();
 
                    for (Sensor s : vehiculo2.getSensores()) {
 
                        System.out.println(s.toString());
                    }
 
                    continue;
 
                case 8:
 
                    if(Sensor.sensores.size() == 0){
 
                        System.out.println("Arreglo vacío");
                        continue;
                    }
 
                    for (Vehiculo v : Vehiculo.vehiculos) {
 
                        for (Sensor s : v.getSensores()) {
 
                            if (s.getTipo().equalsIgnoreCase("temperatura")) {
 
                                System.out.print(s.toString());
                                continue;
                            }
                        }
                    }
 
                    continue;
 
                case 9:
 
                    if (Vehiculo.cantidadVehiculos() == 0) {
 
                        System.out.println("Arreglo vacío");
                        continue;
                    }
 
                    Vehiculo vehicleFinal = null;
 
                    for (Vehiculo v : Vehiculo.vehiculos) {
 
                        if (vehicleFinal == null) {
 
                            vehicleFinal = v;
 
                        } else if (v.getSensores().size() > vehicleFinal.getSensores().size()) {
 
                            vehicleFinal = v;
                        }
                    }
 
                    System.out.println("\n"+vehicleFinal.toString());
                    continue;
 
                case 10:
 
                    File file = new File("carros.txt");
                    Scanner input;
 
                    try {
 
                        input = new Scanner(file);
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
 
                    while(input.hasNextLine()){
 
                        String line = input.nextLine();
                        String[] carReaded = line.split(",");
 
                        Vehiculo v = new Vehiculo(Integer.parseInt(carReaded[0]), carReaded[1], Double.parseDouble(carReaded[2]), carReaded[3]);
                        continue;
                    }
 
                case 666:
 
                    if(Sensor.sensores.size() == 0) {
 
                        System.out.println("\nArreglo vacío\n");
                        continue;
                    }
 
                    Sensor[] vSensores = Sensor.sensoresOrdenadosTemperatura();
                    System.out.println();
 
                    for(int i = 0; i < vSensores.length; i++) {
 
                        System.out.println(vSensores[i].toString());
                    }
 
                    continue;
 
                case 777:
 
                    System.out.print("¿Cuantas instancias quieres crear? ");
                    int instancias = S.nextInt();
                    System.out.println();
                    String source = obtenerCodigoFuente("https://www.carroya.com/buscar/vehiculos/medellin/t4c239.do");
 
                    ArrayList<Integer> arrID = new ArrayList<>();
                    ArrayList<Long> arrModelos = new ArrayList<>();
                    ArrayList<String> arrMarcas = new ArrayList<>();
                    ArrayList<Long> arrPrecios = new ArrayList<>();
 
                    int indiceID = 0;
                    int indiceActualID;
                    int indiceComillaID;
 
                    int indiceModelos = 0;
                    int indiceActualModelos;
                    int indiceComillaModelos;
 
                    int indiceMarcas = 0;
                    int indiceActualMarcas;
                    int indiceComillaMarcas;
 
                    int indicePrecios = 0;
                    int indiceActualPrecios;
                    int indiceComillaPrecios;
 
                    String searchID = "data-idvehiculo=\"";
                    String searchModelo = "data-ano=\"";
                    String searchMarca = "data-brand=\"";
                    String searchPrecio = "data-price=\"";
 
                    for(int i = 0; i < instancias; i++){
 
                        indiceActualModelos = source.indexOf(searchModelo, indiceModelos)+ searchModelo.length();
                        indiceComillaModelos = source.indexOf("\"", indiceActualModelos);
                        arrModelos.add(Long.parseLong(source.substring(indiceActualModelos, indiceComillaModelos)));
                        indiceModelos = indiceActualModelos;
 
                        indiceActualMarcas = source.indexOf(searchMarca, indiceMarcas)+ searchMarca.length();
                        indiceComillaMarcas = source.indexOf("\"", indiceActualMarcas);
                        arrMarcas.add(source.substring(indiceActualMarcas, indiceComillaMarcas));
                        indiceMarcas = indiceActualMarcas;
 
                        indiceActualPrecios = source.indexOf(searchPrecio, indicePrecios)+ searchPrecio.length();
                        indiceComillaPrecios = source.indexOf("\"", indiceActualPrecios);
                        arrPrecios.add(Long.parseLong(source.substring(indiceActualPrecios, indiceComillaPrecios)));
                        indicePrecios = indiceActualPrecios;
 
                        indiceActualID = source.indexOf(searchID, indiceID)+ searchID.length();
                        indiceComillaID = source.indexOf("\"", indiceActualID);
 
                        if(arrID.contains(Integer.parseInt(source.substring(indiceActualID, indiceComillaID)))){
 
                            arrModelos.remove(arrModelos.size()-1);
                            arrMarcas.remove(arrMarcas.size()-1);
                            arrPrecios.remove(arrPrecios.size()-1);
                            indiceID = indiceActualID;
                            i--;
                            continue;
                        }
 
                        arrID.add(Integer.parseInt(source.substring(indiceActualID, indiceComillaID)));
                        indiceID = indiceActualID;
                    }
 
                   /* int indice = 0;
                    int indiceActual;
                    int indiceComilla;
 
                    String searchModelo = "data-ano=\"";
                    String searchMarca = "data-brand=\"";
                    String searchPrecio = "data-price=\"";
 
                    for(int i = 0; i < instancias; i++){
 
                        indiceActual = source.indexOf(searchModelo, indice)+ searchModelo.length();
                        indiceComilla = source.indexOf("\"", indiceActual);
                        arrModelos.add(Long.parseLong(source.substring(indiceActual, indiceComilla)));
                        indice = indiceActual;
                    }
 
                    for(int i = 0; i < instancias; i++){
 
                        indiceActual = source.indexOf(searchMarca, indice)+ searchMarca.length();
                        indiceComilla = source.indexOf("\"", indiceActual);
                        arrMarcas.add(source.substring(indiceActual, indiceComilla));
                        indice = indiceActual;
                    }
 
                    for(int i = 0; i < instancias; i++){
 
                        indiceActual = source.indexOf(searchPrecio, indice)+ searchPrecio.length();
                        indiceComilla = source.indexOf("\"", indiceActual);
                        arrPrecios.add(Long.parseLong(source.substring(indiceActual, indiceComilla)));
                        indice = indiceActual;
                    }
 
 
                    */
 
                    for(int i = 0; i<instancias; i++){
 
                        Vehiculo v = new Vehiculo(arrModelos.get(i).intValue(), arrMarcas.get(i), arrPrecios.get(i));
                    }
 
                    continue;
 
                default:
                    throw new IllegalStateException("Valor no válido: " + vNumero);
            }
        }
    }
 
    private static String obtenerCodigoFuente(String ruta) throws IOException {
 
        URL url = new URL(ruta);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String sourceCode = "";
        String lineaActual;
 
        while((lineaActual = reader.readLine()) != null){
 
            sourceCode = sourceCode + lineaActual;
        }
 
        reader.close();
        return sourceCode;
    }
}