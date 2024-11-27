package co.edu.unipiloto.AppCashCrafter.repository;

import co.edu.unipiloto.AppCashCrafter.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}