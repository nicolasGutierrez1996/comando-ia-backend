package com.malvinas.comandoia.controladores;

import com.malvinas.comandoia.modelo.Rol;
import com.malvinas.comandoia.servicios.RolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*") // para permitir peticiones desde Angular durante el desarrollo
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public Iterable<Rol> listarRoles() {
        return rolService.listarRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerRolPorId(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();

        Optional<Rol> rol = rolService.obtenerRolPorId(id);

        if (!rol.isPresent()) {
            response.put("success", false);
            response.put("mensaje", String.format("El rol con ID %d no existe", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        response.put("success", true);
        response.put("rol", rol.get());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> crearRol(@Valid @RequestBody Rol rol, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> errores = new HashMap<>();

        // Validaciones de campos
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            response.put("success", false);
            response.put("errores", errores);
            return ResponseEntity.badRequest().body(response);
        }

        // Guardar el nuevo rol
        Rol nuevo = rolService.guardarRol(rol);
        response.put("success", true);
        response.put("rol", nuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarRol(@PathVariable Integer id, @Valid @RequestBody Rol rol, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> errores = new HashMap<>();

        // Validación de datos
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            response.put("success", false);
            response.put("errores", errores);
            return ResponseEntity.badRequest().body(response);
        }

        // Verificación si el rol existe
        Optional<Rol> existente = rolService.obtenerRolPorId(id);
        if (!existente.isPresent()) {
            response.put("success", false);
            response.put("mensaje", String.format("El rol con ID %d no existe", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        rol.setId(id);
        Rol actualizado = rolService.guardarRol(rol);
        response.put("success", true);
        response.put("rol", actualizado);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRol(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();

        Optional<Rol> rol = rolService.obtenerRolPorId(id);

        if (!rol.isPresent()) {
            response.put("success", false);
            response.put("mensaje", String.format("No se puede eliminar. El rol con ID %d no existe", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        rolService.eliminarRol(id);
        response.put("success", true);
        response.put("mensaje", String.format("Rol con ID %d eliminado correctamente", id));
        return ResponseEntity.ok(response);
    }
}