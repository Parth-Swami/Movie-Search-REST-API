# Movie-Search-REST-API

Create new Movie.
---
>URL: http://localhost:8084
>Request Type:POST

```
Request Body: 
{
	"movie":"Jai Ho"
}
```
```
Response:
{
    "movie": "Jai Ho",
    "id": "5e29f75ffb0a2341e51cc9b7"
}
```

Get Movies List
---
URL: http://localhost:8084/search/prefix/limit/\
Request Type:GET

```
Ex: http://localhost:8084/search/Jai/3/
Response Body: 
[
    "Jai",
    "Jai ho",
    "Jai Ram"

]
```
