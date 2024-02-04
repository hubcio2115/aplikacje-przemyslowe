# Lab 8

## Zadanie 1

W projekcie z poprzednich zajęć dodać warstwę repozytoriów czyli interfejsów rozszerzających `CRUDRepository<T, ID>`. W
metodzie szkoleniowej `setUpApp` w komponencie `CommandLineRunner` i serwisie (por. przykład z wykładu) wykonuj opreacje
typu CRUD zdefiniowane w tym interfejsie. Do kolejnych zadań usunąć powiazania między encjami (uzupełnimy to na kolejnym
wykładzie).
Kontrakt/interfejs [CRUDRepository<T, ID>](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html)

## Zadanie 2

Bardzo uważnie i starannie przeczytać, przeanalizować, wykonać własne przykłady z prawidłowym wykorzystaniem typu
typu [Optional](https://dzone.com/articles/using-optional-correctly-is-not-optional)

## Zadanie 3

Dodać warstwę kontrolerów, które będą wykorzystywały nowy serwis (wykorzystujący Repozytorium) i zaimplementować metod
dodawania nowej encji, wyszukiwania po id i usuwania po id, w sposób anaologiczny jak robiliśmy to z implementacją
serwisu 'inMemory'
