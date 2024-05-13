package org.uv.DAPP01Practica04;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author emilioenriquerafaeldejesus
 */
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(generator = "empleado_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "empleado_id_seq", sequenceName = "empleado_id_seq", initialValue = 1, allocationSize = 1)
    private long id;
    
    @Column
    private String nombre;
    
    @Column
    private String direccion;
    
    @Column
    private String telefono;

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
