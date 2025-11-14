//creamos la clase del usuario , en donde tenemos sus variables clave.
class User {
  String nombre;
  String genero; // 'Masculino' o 'Femenino'
  bool activo;

  User({
    required this.nombre,
    required this.genero,
    required this.activo,
  });
}
