# Proyecto Hackusach: Sistema Web para aprendizaje de programación

# API 

## Login [/login]
Obtención de token de autenticación para obtener acceso al sistema. El token es retornado desde el Header, 
por esa razón se utiliza el Access-Control-Headers, de otra forma no sería posible acceder al token.

### Login Success  [POST]
+ Request(application/json)

    + Body
    {
        "username": "userTest",
        "password": "magicpass"
    }

+ Response 200 (application/json)
    
    + Headers
        Authorization: bearer 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
        Access-Control-Expose-Headers: Authorization
    + Body
    {

    }

## Alumnos [/api/v1/alumnos/]

### Creacion [POST]

+ Request(application/json)

    + Body
    {
        "nombres": "nombre test",
        "apellidos": "apellido test",
        "username": "mai@mail.dom",
        "password": "pass"
    }

+ Response 200 (application/json)

    + Body
    {
        "id": 1,
        "nombres": "nombre test",
        "apellidos": "apellido test",
        "username": "mai@mail.dom",
        "password": "pass"
    }

## Alumnos [/api/v1/alumnos/:id]

### Obtener [GET]

+ Request(application/json)

+ Response 200 (application/json)

    + Body
    {
        "id": 1,
        "nombres": "nombre modificado",
        "apellidos": "apellido test",
        "username": "mai@mail.dom",
        "password": "pass"
    }

## Alumnos [/api/v1/alumnos/:id]

### Update [PUT]

+ Request(application/json)

    + Body
    {
        "nombres": "nombre modificado",
        "apellidos": "apellido test",
        "username": "mai@mail.dom",
        "password": "pass"
    }

+ Response 200 (application/json)

    + Body
    {
        "id": 1,
        "nombres": "nombre modificado",
        "apellidos": "apellido test",
        "username": "mai@mail.dom",
        "password": "pass"
    }

## Alumnos [/api/v1/alumnos/:id]

### Eliminar [DELETE]

+ Request(application/json)

+ Response 200 (application/json)

## Alumnos [/api/v1/alumnos/all]

### Obtener [GET]

+ Request(application/json)

+ Response 200 (application/json)

    + Body
    [
        {
            "id": 1,
            "nombres": "nombre modificado",
            "apellidos": "apellido test",
            "username": "mai@mail.dom",
            "password": "pass"
        },
        {
            "id": 2,
            "nombres": "nombre test2",
            "apellidos": "apellido test",
            "username": "mai2@mail.dom",
            "password": "pass"
        }

    ]

## Profesores [/api/v1/profesores/]

### Creacion [POST]

+ Request(application/json)

    + Body
    {
        "nombres": "nombre test",
        "apellidos": "apellido test",
        "username": "mai@mail.dom",
        "password": "pass"
    }

+ Response 200 (application/json)

    + Body
    {
        "id": 1,
        "nombres": "nombre test",
        "apellidos": "apellido test",
        "username": "mai@mail.dom",
        "password": "pass"
    }

## Profesores [/api/v1/profesores/:id]

### Obtener [GET]

+ Request(application/json)

+ Response 200 (application/json)

    + Body
    {
        "id": 1,
        "nombres": "nombre modificado",
        "apellidos": "apellido test",
        "username": "mai@mail.dom",
        "password": "pass"
    }

## Alumnos [/api/v1/profesores/:id]

### Update [PUT]

+ Request(application/json)

    + Body
    {
        "nombres": "nombre modificado",
        "apellidos": "apellido test",
        "username": "mai@mail.dom",
        "password": "pass"
    }

+ Response 200 (application/json)

    + Body
    {
        "id": 1,
        "nombres": "nombre modificado",
        "apellidos": "apellido test",
        "username": "mai@mail.dom",
        "password": "pass"
    }

## Profesores [/api/v1/profesores/:id]

### Eliminar [DELETE]

+ Request(application/json)

+ Response 200 (application/json)

## Profesores [/api/v1/profesores/all]

### Obtener [GET]

+ Request(application/json)

+ Response 200 (application/json)

    + Body
    [
        {
            "id": 1,
            "nombres": "nombre modificado",
            "apellidos": "apellido test",
            "username": "mai@mail.dom",
            "password": "pass"
        },
        {
            "id": 2,
            "nombres": "nombre test2",
            "apellidos": "apellido test",
            "username": "mai2@mail.dom",
            "password": "pass"
        }

    ]

## Enunciados [/api/v1/enunciados/]
### Creacion [POST]

+ Request(application/json)

    + Body
    {
        "titulo": "Problema Vendedor de Cecina en ciudad Escoria",
        "descripcion": "El vendedor de cecinas debe ingeniarselas en el yermo, si los conocimientos del nuevo mundo ...",
        "entradas": ["1", "2"],
        "salidas": ["4", "8"]
    }

+ Response 200 (application/json)

    + Body
    {
        "id": 1,
        "titulo": "Problema Vendedor de Cecina en ciudad Escoria",
        "descripcion": "El vendedor de cecinas debe ingeniarselas en el yermo, si los conocimientos del nuevo mundo ...",
        "entradas": ["1", "2"],
        "salidas": ["4", "8"]
    }

## Enunciados [/api/v1/enunciados/:id]
### Obtener [GET]

+ Request(application/json)

+ Response 200 (application/json)

    + Body
    {
        "id": 1,
        "titulo": "Problema Vendedor de Cecina en ciudad Escoria",
        "descripcion": "El vendedor de cecinas debe ingeniarselas en el yermo, si los conocimientos del nuevo mundo ...",
        "entradas": ["1", "2"],
        "salidas": ["4", "8"]
    }

## Enunciados [/api/v1/enunciados/:id]
### Obtener [PUT]

+ Request(application/json)

    + Body
    {
        "titulo": "Problema Vendedor de Cecina en ciudad Escoria v2 modificada y version extrema",
        "descripcion": "El vendedor de cecinas debe ingeniarselas en el yermo, si los conocimientos del nuevo mundo ...",
        "entradas": ["1", "2"],
        "salidas": ["4", "8"]
    }

+ Response 200 (application/json)

    + Body
    {
        "id": 1,
        "titulo": "Problema Vendedor de Cecina en ciudad Escoria v2 modificada y version extrema",
        "descripcion": "El vendedor de cecinas debe ingeniarselas en el yermo, si los conocimientos del nuevo mundo ...",
        "entradas": ["1", "2"],
        "salidas": ["4", "8"]
    }

## Enunciados [/api/v1/enunciados/:id]
### Obtener [DELETE]

+ Request(application/json)

+ Response 200 (application/json)

## Enunciados [/api/v1/enunciados/all]
### Obtener [GET]

+ Request(application/json)

+ Response 200 (application/json)

    + Body
        [
            {
                "id": 1,
                "titulo": "Problema Vendedor de Cecina en ciudad Escoria",
                "descripcion": "El vendedor de cecinas debe ingeniarselas en el yermo, si los conocimientos del nuevo mundo ...",
                "entradas": ["1", "2"],
                "salidas": ["4", "8"]
            },
            {
                "id": 2,
                "titulo": "Problema Vendedor Viajero",
                "descripcion": "El vendedor viajero debe encontrar su camino , de otra forma la mafia se llevara a su familia...",
                "entradas": ["1", "2"],
                "salidas": ["4", "8"]
            }


## Explicación

Se listarán las funcionalidades de la API así como sus entradas y salidas, esto 
a medida que el proyecto avance.
El estandard a utilizar será API Blueprint.

# Instrucciones

A continuación las intrucciones acerca de este artefacto.

## Instalación de herramientas

Si se desea generar documentación, debe instalar aglio y drakov, usando el comando:

```console
~$ npm install -g aglio
~$ npm install -g drakov
>$ npm run  

```

## Generación de documentación

Para generar documentación usar:

```console
~$ npm run build-docs

```

Para entrar a la documentación en modo Debug:

```console
~$ npm run build-debug

```

## Mockup

Para generar levantar servidor de mockup:

```console
~$ npm start

```

Para levantar servidor mockup sin validaciones(Debug):

```console
~$ npm run dev

```