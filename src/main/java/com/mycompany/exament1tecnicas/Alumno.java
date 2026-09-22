/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exament1tecnicas;

/**
 *
 * @author quant
 */
public class Alumno {
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String telefono;
    private String tipo_documento;
    private String nro_documento;
    private char nivel_socioeconomico; //a,b,c
    private String tipo_beca; 

    // --- Getters y Setters ---

    public String getNombre()
    { return nombre; }
    public void setNombre(String nombre) 
    { this.nombre = nombre; }

    public String getApellido_paterno()
    { return apellido_paterno; }
    public void setApellido_paterno(String apellido_paterno)
    { this.apellido_paterno = apellido_paterno; }

    public String getApellido_materno() 
    { return apellido_materno; }
    public void setApellido_materno(String apellido_materno)
    { this.apellido_materno = apellido_materno; }

    public String getTelefono()
    { return telefono; }
    public void setTelefono(String telefono)
    { this.telefono = telefono; }

    public String getTipo_documento() 
    { return tipo_documento; }
    public void setTipo_documento(String tipo_documento)
    { this.tipo_documento = tipo_documento; }

    public String getNro_documento()
    { return nro_documento; }
    
    // Validación para dni
    public void setNro_documento(String nro_documento) {
        if (tipo_documento != null) {
            String tipo = tipo_documento.trim().toUpperCase();
            if (tipo.equals("DNI")) {
                if (nro_documento.matches("\\d{8}")) {
                    this.nro_documento = nro_documento;
                } else {
                    throw new IllegalArgumentException("Error: El DNI debe tener exactamente 8 dígitos numéricos.");
                }
            } else if (tipo.equals("CARNET") || tipo.equals("RESIDENCIA")) {
                if (nro_documento.matches("\\d{11}")) {
                    this.nro_documento = nro_documento;
                } else {
                    throw new IllegalArgumentException("Error: El carné de residencia debe tener exactamente 11 dígitos numéricos.");
                }
            } else {
                this.nro_documento = nro_documento; 
            }
        } else {
            this.nro_documento = nro_documento;
        }
    }

    public char getNivel_socioeconomico() { return nivel_socioeconomico; }
    public void setNivel_socioeconomico(char nivel_socioeconomico) {
        char nivel = Character.toUpperCase(nivel_socioeconomico);
        if (nivel == 'A' || nivel == 'B' || nivel == 'C') {
            this.nivel_socioeconomico = nivel;
        } else {
            throw new IllegalArgumentException("Error: El nivel socioeconómico debe ser A, B o C.");
        }
    }

    public String getTipo_beca() { return tipo_beca; }
    public void setTipo_beca(String tipo_beca) { this.tipo_beca = tipo_beca; }


    // Método para calcular la pensión final 
    public double calcularPensionFinal() {
        double tarifaBase = 0.0;
        
        // Asignación de tarifa base según nivel socioeconómico
        switch (Character.toUpperCase(this.nivel_socioeconomico)) {
            case 'A': tarifaBase = 800.0; break;
            case 'B': tarifaBase = 600.0; break;
            case 'C': tarifaBase = 400.0; break;
            default: tarifaBase = 500.0; break;
        }

        double descuento = 0.0;
        if (this.tipo_beca != null) {
            String beca = this.tipo_beca.trim().toLowerCase();
            if (beca.contains("parcial") || beca.contains("50")) {
                descuento = 0.50; // 50% de descuento
            } else if (beca.contains("total") || beca.contains("100") || beca.equals("0")) {
                descuento = 1.00; // 100% de descuento (pago 0)
            }
        }

        return tarifaBase * (1.0 - descuento);
    }

    public void verDatos() {
        System.out.println("Doc: " + this.tipo_documento + " [" + this.nro_documento + "] | " +
                           "Nombre: " + this.nombre + " " + this.apellido_paterno + " " + this.apellido_materno + " | " +
                           "Nivel: " + this.nivel_socioeconomico + " | Beca: " + this.tipo_beca + " | " +
                           "Pensión Final: S/. " + calcularPensionFinal());
    }
}
