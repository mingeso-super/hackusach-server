# Proyecto Hackusach: Sistema Web para aprendizaje de programación

# API 

## Login [/login]
Obtención de token de autenticación para obtener acceso al sistema. El token es retornado desde el Header, 
por esa razón se utiliza el Access-Control-Headers, de otra forma no sería posible acceder al token.

## Login Success  [POST]
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

## Creacion [POST]

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

## Update [GET]

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

## Update [PUT]

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

## Eliminar [DELETE]

+ Request(application/json)

+ Response 200 (application/json)

## Alumnos [/api/v1/alumnos/all]

## Update [GET]

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

## Creacion [POST]

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

## Update [GET]

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

## Update [PUT]

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

## Eliminar [DELETE]

+ Request(application/json)

+ Response 200 (application/json)

## Profesores [/api/v1/profesores/all]

## Update [GET]

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