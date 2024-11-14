ZAD1
package com.example.demo.controller; // Definiuje pakiet, w którym znajduje się klasa (dopasuj do swojej struktury katalogów).

import org.springframework.web.bind.annotation.GetMapping; // Importuje adnotację do definiowania ścieżki dla żądań GET.
import org.springframework.web.bind.annotation.RestController; // Importuje adnotację oznaczającą klasę jako kontroler REST.

@RestController // Oznacza klasę jako kontroler REST, dzięki czemu może obsługiwać żądania HTTP.
public class HelloController { // Definicja klasy kontrolera o nazwie "HelloController".

    @GetMapping("/hello") // Mapuje metodę na ścieżkę "/hello", co oznacza, że kiedy użytkownik odwiedzi /hello, wywoła tę metodę.
    public String sayHello() { // Definiuje metodę, która odpowiada na żądanie GET.
        return "Hello, Spring Boot!"; // Zwraca tekst "Hello, Spring Boot!" jako odpowiedź na żądanie.
    }
}
ZAD2
package com.example.demo.controller; // Definiuje pakiet, w którym znajduje się klasa.

import org.springframework.web.bind.annotation.GetMapping; // Importuje adnotację do definiowania ścieżki dla żądań GET.
import org.springframework.web.bind.annotation.RequestParam; // Importuje adnotację, która pozwala przyjąć parametry z zapytania.
import org.springframework.web.bind.annotation.RestController; // Importuje adnotację oznaczającą klasę jako kontroler REST.

@RestController // Oznacza klasę jako kontroler REST.
public class GreetingController { // Definicja klasy kontrolera o nazwie "GreetingController".

    @GetMapping("/greet") // Mapuje metodę na ścieżkę "/greet", co oznacza, że kiedy użytkownik odwiedzi /greet, wywoła tę metodę.
    public String greetUser(@RequestParam String name, @RequestParam int age) { 
        // Metoda przyjmuje dwa parametry: "name" jako String i "age" jako int. @RequestParam oznacza, że te wartości są przekazywane jako parametry zapytania.
        return "Hello, " + name + ", you are " + age + " y.o."; 
        // Zwraca tekst "Hello, <name>, you are <age> y.o.", gdzie <name> i <age> to wartości przekazane przez użytkownika.
    }
}
ZAD3
package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.dto.ItemDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    // Metoda obsługuje żądania GET na ścieżce "/item/{id}"
    @GetMapping("/item/{id}")
    public ItemDTO getItemById(@PathVariable Long id) {
        // Tworzymy przykładowy obiekt Item (w praktyce byłoby to pobrane z bazy danych)
        Item item = new Item(id, "Laptop", "Gaming laptop", 1500.0, 10);
        
        // Tworzymy obiekt ItemDTO z danych obiektu Item
        return new ItemDTO(item.getName(), item.getDescription(), item.getPrice());
    }
}