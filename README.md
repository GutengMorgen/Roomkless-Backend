# Roomkless_API
Esto es una API para el projecto Roomkless

/roomkless
 - categoria
    - items
 
- categoria:
  - nombre
  - numero de items
  - (test) orden de items
- items:
  - nombre
  - link
  - status
  - descripcion

- opcion: un parametro en items para que sera el orden de como se mostraran


- deberia incluir en parametro para poner el orden en como se mostrara los items
 de una categoria?

- agregar opciones de como mostrar la pagina
  - tree
  - table
- creo que tambien debo crear una nueva tabla(usuario) en sql para guardar
    como se ve la pagina

- mostrar las categorias con items, paginacion de categorias
  - roomkless/consulta?page=0&size=1
    - original=true : sin filtrar parametros
    - original=false : filtra parametros
    - items=true : incluye lista de items
    - items=false : no incluye lista de items

- mostrar una categoria
  - roomkless/categoria/{id}
    - items=true : incluye lista de items, paginacion items
    - items=false : no incluye lista de items 