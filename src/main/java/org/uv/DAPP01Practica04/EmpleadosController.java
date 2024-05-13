/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/RestController.java to edit this template
 */
package org.uv.DAPP01Practica04;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author emilioenriquerafaeldejesus
 */
@RestController
@RequestMapping("/api/v1")
public class EmpleadosController {

    @Autowired
    private EmpleadoRepository repositoryEmpleado;

    @GetMapping()
    public List<Empleado> list() {
        return repositoryEmpleado.findAll();
    }

    @GetMapping("/empleado/{id}")
    public Empleado get(@PathVariable Long id) {
        Optional<Empleado> optEmpleado = repositoryEmpleado.findById(id);
        if (optEmpleado.isPresent()) {
            return optEmpleado.get();
        } else {
            return null;
        }
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Empleado empleado) {
        Optional<Empleado> optEmpleado = repositoryEmpleado.findById(id);
        if (optEmpleado.isPresent()) {
            Empleado existingEmpleado = optEmpleado.get();
            existingEmpleado.setNombre(empleado.getNombre());
            repositoryEmpleado.save(existingEmpleado);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/empleado")
    public ResponseEntity<Empleado> post(@RequestBody Empleado empleado) {
        Empleado savedEmpleado = repositoryEmpleado.save(empleado);
        return ResponseEntity.ok(savedEmpleado);
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Empleado> optEmpleado = repositoryEmpleado.findById(id);
        if (optEmpleado.isPresent()) {
            repositoryEmpleado.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
