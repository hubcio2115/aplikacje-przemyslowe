# Lab 9

## Zadanie 1

W zapytaniach wykorzystaj parametr `fetch`  ustawiając jego wartość na 'LAZY' i 'EAGER'. Dodaj
adnotację `@Transactional` w serwisie i obserwuj różnice w pobieraniu encji przy adnotacjach `@OneToMany`
i `@ManyToMany`. Zdefiniuj i przetestuj różne rodzaje kaskadowości za pomocą parametru `cascade`.

> `@Transactional` w klasie serwisowej z relacjami `@OneToMany` i `@ManyToMany` może być korzystne, aby uniknąć
> problemów
> z `LazyInitializationException`. Dzieje się tak, ponieważ domyślnie JPA pobiera te relacje leniwie, i jeśli próbujemy
> uzyskać do nich dostęp poza aktywną transakcją lub sesją Hibernate, może wystąpić błąd.

1. **ALL**: Wszystkie operacje kaskadowe są stosowane *(tj. PERSIST, MERGE, REMOVE, REFRESH i DETACH)*.
2. **PERSIST**: Gdy encja nadrzędna jest zapisywana, skojarzone z nią encje potomne również zostaną zapisane.
3. **MERGE**: Gdy encja nadrzędna jest aktualizowana, skojarzone z nią encje potomne również zostaną zaktualizowane.
   Kiedy zostały odłączone od nadrzędnej encji zostaną dołączone do nowej
4. **REMOVE**: Gdy encja nadrzędna jest usuwana, skojarzone z nią encje potomne również zostaną usunięte.
5. **REFRESH**: Gdy encja nadrzędna jest przywracana do stanu z bazy danych, skojarzone z nią encje potomne również
   zostaną przywrócone.
6. **DETACH**: Gdy encja nadrzędna jest odłączana od persistance context, skojarzone z nią encje potomne również zostaną
   odłączone.

## Zadanie 2

W projekcie z poprzednich zajęć uzupełnić repozytoria o metody 'findBy' z wykorzystaniem słów kluczowych '...And...', '
...Or...'.
Zapoznać się z [przykładami zapytań w języku JPQL](https://en.wikibooks.org/wiki/Java_Persistence/JPQL) i zdefiniować
własne.

## Zadanie 3

Dodać warstwę kontrolerów i wykorzystać metody serwisu do obsłgui logiki biznesowej (metod CRUD). Napisać testy w
Postmanie.
