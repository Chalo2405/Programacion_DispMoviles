import 'package:flutter/material.dart';
import '../models/user.dart';
//este es el view model , el cual se encarga de gestionar toda la lista de usurios

class UserViewModel extends ChangeNotifier {
  final List<User> _usuarios = [];

  List<User> get usuarios => _usuarios;

  //con esta funcion podremos agregar al usuario
  void agregarUsuario(User usuario) {
    _usuarios.add(usuario);
    notifyListeners();
  }

  //con esta funcion podemos realizar la edicion de cualquier usuario
  void editarUsuario(int index, User usuario) {
    _usuarios[index] = usuario;
    notifyListeners();
  }
// con esto eliminamos al usuario
  void eliminarUsuario(int index) {
    _usuarios.removeAt(index);
    notifyListeners();
  }
}
