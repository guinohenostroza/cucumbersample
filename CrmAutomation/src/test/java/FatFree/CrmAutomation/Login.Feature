#language: es
@tag
Característica: Login de usuario
  Como UsuarioCRM 
  Quiero ingresar a FatFreeCrm
  Para poder administrar mis oportunidades de venta

  @tag1
  Escenario: Login con Usuario Existente
    Dado que estoy en la pagina de inicio
    Cuando Ingreso con los siguientes detalles de usuario
      | Username | Password |
      | user     | i6MkCg3I |
    Entonces debo ir a la pagina principal
