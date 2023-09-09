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


### los request que necesito:

- al cargar la pagina: mostrar una lista limitada de categorias con sus items
  - /roomkless/consulta?filter=false&items=true&sizeItems=3&page=0&size=1

- al cargar mas categorias en la pagina principal, usar la paginacion
  - /roomkless/consulta?filter=false&items=true&sizeItems=3&page=0&size=1

- al crear una categoria
  - /roomkless/categoria/create
- al actualizar una categoria
  - /roomkless/categoria/{id}
- al eliminar una categoria
- /roomkless/categoria/{id}

- al crear un item
  - /roomkless/item/create
- al actualizar un item
  - /roomkless/item/{id}
- al eliminar un item
  - /roomkless/item/{id}

- al cargar mas items de una categoria, usar la paginacion
  - /roomkless/categoria/{id}/items

- al buscar categorias, items y descripciones de items
  - 

- al actualizar el link_status de los items
    - /roomkless/item/{id}

testear opciones:

al cargar una sesion en roomkless

al cambiar el tema de la pagina