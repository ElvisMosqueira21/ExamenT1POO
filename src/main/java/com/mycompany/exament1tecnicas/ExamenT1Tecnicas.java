/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exament1tecnicas;
import java.util.Scanner;
/**
 *
 * @author quant
 */
public class ExamenT1Tecnicas {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        AlumnoController controlador = new AlumnoController();
        String rpta = "s";
        
        System.out.println("=== SISTEMA DE REGISTRO DE ALUMNOS - INSTITUCIÓN INNOVA ===");

        while (rpta.equalsIgnoreCase("s")) {
            Alumno a = new Alumno();

            System.out.println("\n--- Registrando nuevo alumno ---");
            
            // Validación para tipo de documento
            while (true) {
                System.out.println("Ingrese el tipo de documento (Ej: DNI / Carnet):");
                String tp = sc.nextLine().trim();
                if (!tp.isEmpty()) {
                    a.setTipo_documento(tp);
                    break;
                }
                System.out.println("El campo no puede estar vacío. Intente nuevamente.");
            }

            // Validación estricta para número de documento (8 u 11 dígitos)
            while (true) {
                System.out.println("Ingrese el número de documento (8 dígitos para DNI / 11 para Carnet):");
                String num = sc.nextLine().trim();
                try {
                    a.setNro_documento(num);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + " Intente nuevamente.");
                }
            }

            // Validación para nombre
            while (true) {
                System.out.println("Ingrese el nombre:");
                String nom = sc.nextLine().trim();
                if (!nom.isEmpty()) {
                    a.setNombre(nom);
                    break;
                }
                System.out.println("El campo no puede estar vacío. Intente nuevamente.");
            }

            // Validación para apellido paterno
            while (true) {
                System.out.println("Ingrese el apellido paterno:");
                String ap = sc.nextLine().trim();
                if (!ap.isEmpty()) {
                    a.setApellido_paterno(ap);
                    break;
                }
                System.out.println("El campo no puede estar vacío. Intente nuevamente.");
            }

            // Validación para apellido materno
            while (true) {
                System.out.println("Ingrese el apellido materno:");
                String am = sc.nextLine().trim();
                if (!am.isEmpty()) {
                    a.setApellido_materno(am);
                    break;
                }
                System.out.println("El campo no puede estar vacío. Intente nuevamente.");
            }

            // Validación para teléfono
            while (true) {
                System.out.println("Ingrese el teléfono:");
                String tel = sc.nextLine().trim();
                if (!tel.isEmpty()) {
                    a.setTelefono(tel);
                    break;
                }
                System.out.println("El campo no puede estar vacío. Intente nuevamente.");
            }
             
            // Validación para nivel socioeconómico (A, B, C)
            while (true) {
                System.out.println("Ingrese el nivel socioeconómico (A, B, C):");
                String nivStr = sc.nextLine().trim();
                if (!nivStr.isEmpty()) {
                    try {
                        a.setNivel_socioeconomico(nivStr.charAt(0));
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage() + " Intente nuevamente.");
                    }
                } else {
                    System.out.println("El campo no puede estar vacío.");
                }
            }

            // Validación para tipo de beca (Parcial / Total)
            while (true) {
                System.out.println("Ingrese el tipo de beca (Ej: Ninguna, Parcial 50%, Total 100%):");
                String beca = sc.nextLine().trim();
                if (!beca.isEmpty()) {
                    a.setTipo_beca(beca);
                    break;
                }
                System.out.println("El campo no puede estar vacío.");
            }

            // Agregamos al controlador
            controlador.agregar(a);
            System.out.println("¡Alumno registrado exitosamente!");
            
            System.out.println("\n¿Desea agregar otro alumno? (s/n): ");
            rpta = sc.nextLine().trim();
        }   
        
        sc.close();

        // Listamos todos los objetos agregados usando el controlador
        controlador.listar();
    }
    
}
