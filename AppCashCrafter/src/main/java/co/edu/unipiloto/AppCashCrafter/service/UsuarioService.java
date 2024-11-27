package co.edu.unipiloto.AppCashCrafter.service;

import co.edu.unipiloto.AppCashCrafter.entity.Usuario;
import co.edu.unipiloto.AppCashCrafter.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario insertar(Usuario usuario) {
        validarUsuario(usuario);
        return usuarioRepository.save(usuario);
    }
    
public Usuario actualizar(Usuario usuario) {

    Usuario existente = usuarioRepository.findById(usuario.getCodigo())
            .orElseThrow(() -> new UsuarioNoEncontradoException("Usuario no encontrado con ID: " + usuario.getCodigo()));


    existente.setNombre(usuario.getNombre());
    existente.setEmail(usuario.getEmail());
    existente.setPassword(usuario.getPassword());
    existente.setRol(usuario.getRol());
    existente.setActivo(usuario.isActivo());
    existente.setNUsuario(usuario.getNUsuario());


    return usuarioRepository.save(existente);
}

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }


    public void eliminar(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new UsuarioNoEncontradoException("Usuario no encontrado con ID: " + id);
        }
    }

    public Usuario deshabilitarUsuario(Long id) {
    Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new UsuarioNoEncontradoException("Usuario no encontrado con ID: " + id));
    
    System.out.println("Antes de deshabilitar: " + usuario);
    usuario.setActivo(false);
    Usuario actualizado = usuarioRepository.save(usuario);
    System.out.println("DespuÃ©s de deshabilitar: " + actualizado);
    
    return actualizado;
}

    private void validarUsuario(Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El campo 'nombre' es obligatorio.");
        }
        if (usuario.getNUsuario() == null || usuario.getNUsuario().isEmpty()) {
            throw new IllegalArgumentException("El campo 'nUsuario' es obligatorio.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El campo 'email' es obligatorio.");
        }
        if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
            throw new IllegalArgumentException("El campo 'password' es obligatorio.");
        }
        if (usuario.getRol() == null) {
            throw new IllegalArgumentException("El campo 'rol' es obligatorio.");
        }
    }

    public static class UsuarioNoEncontradoException extends RuntimeException {
        public UsuarioNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }
}