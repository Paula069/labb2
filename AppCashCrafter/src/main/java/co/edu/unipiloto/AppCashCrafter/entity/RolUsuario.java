package co.edu.unipiloto.AppCashCrafter.entity;

public enum RolUsuario {
    USUARIO,
    ADMINISTRADOR;

  
   public static RolUsuario fromString(String value) {
        if (value != null) {
            for (RolUsuario rol : RolUsuario.values()) {
                if (rol.name().equalsIgnoreCase(value)) {
                    return rol;
                }
            }
        }
        throw new IllegalArgumentException("Valor no válido para el rol: " + value);
    }
}