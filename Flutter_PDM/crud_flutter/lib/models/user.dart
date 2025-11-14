class User {
  String nombre;
  int edad;
  String correo;
  String genero; // 'Masculino' o 'Femenino'
  bool activo;

  User({
    required this.nombre,
    required this.edad,
    required this.correo,
    required this.genero,
    required this.activo,
  });
}
