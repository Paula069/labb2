package co.edu.unipiloto.AppCashCrafter.controller;

import co.edu.unipiloto.AppCashCrafter.entity.Usuario;
import co.edu.unipiloto.AppCashCrafter.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @PostMapping
    public Usuario insertar(@RequestBody Usuario usuario) {
        return usuarioService.insertar(usuario);
    }

    @PutMapping
    public Usuario actualizar(@RequestBody Usuario usuario) {
        return usuarioService.actualizar(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }

    @PutMapping("/deshabilitar/{id}")
    public Usuario deshabilitarUsuario(@PathVariable Long id) {
        return usuarioService.deshabilitarUsuario(id);
    }
}
