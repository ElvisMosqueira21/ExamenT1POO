/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exament1tecnicas;
import java.util.ArrayList;
/**
 *
 * @author quant
 */
public class AlumnoController {
    
    private ArrayList<Alumno> listapersonas = new ArrayList<>();
    
    // Método para agregar objetos a la lista
    public void agregar(Alumno nuevapersona) {
        if (nuevapersona != null) {
            listapersonas.add(nuevapersona);
        }
    }

    // Método para listar todos los objetos agregados
    public void listar() {
        System.out.println("\n==================================================");
        System.out.println("            LISTA DE ALUMNOS REGISTRADOS         ");
        System.out.println("==================================================");
        
        if (listapersonas.isEmpty()) {
            System.out.println("No hay registros en la lista.");
        } else {
            for (int i = 0; i < listapersonas.size(); i++) {
                System.out.print((i + 1) + ". ");
                listapersonas.get(i).verDatos();
            }
        }
        System.out.println("==================================================");
    }
}
