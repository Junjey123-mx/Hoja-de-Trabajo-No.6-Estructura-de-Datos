

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n ---------- Selección el tipo Mapa con el que quieres que funcione este programa -----------");
            System.out.println("\n Opciones: ");
            System.out.println("1) HashMap         = Sin orden)");
            System.out.println("2) TreeMap         = Ordenados por nombre)");
            System.out.println("3) LinkedHashMap   =Orden de inserción)");
            System.out.print("Elige una de estas opciones: ");
            int option;
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
            } else{
                System.out.println(" --------------------------------------------------------------- ");
                System.out.println("¡Lo siento!");
                System.out.println("Has escogido una entrada no implementada. Vuelve a escoger.");
                option = 1;
            }
            scanner.nextLine(); 
            String mapType = switch (option) {
                case 1 -> "hashmap";
                case 2 -> "treemap";
                case 3 -> "linkedhashmap";
                default -> "hashmap";
            };

            //Datos CSV: 
            String filePath = "pokemon_data_pokeapi.csv";

            //Análisis del tiempo: 
            long startTime = System.nanoTime();
            PokemonCSV reader = new PokemonCSV(filePath);
            long endTime = System.nanoTime();
            System.out.println("Tiempo de carga de datos: " + (endTime - startTime) / 1e6 + " ms");

            Map<String, Pokemon> pokedex = MapFactory.getMap(mapType);
            pokedex.putAll(reader.getPokedex());

            OperationPokemon operations = new OperationPokemon(pokedex);
            UserCollection userCollection = new UserCollection();

            int choice = -1;

            while (choice != 7) {
                System.out.println("\n --------------------------- Menú --------------------------------");
                System.out.println("1) Agrega un nuevo Pokémon a tu colección");
                System.out.println("2) Mostrar los datos de un Pokémon en específico");
                System.out.println("3) Mostrar tu colección ordenada por el Tipo No.1");
                System.out.println("4) Mostrar todos los Pokémon ordenados por el Tipo No.1");
                System.out.println("5) Buscar un Pokémon por medio de sus habilidades");
                System.out.println("6) Cerrar este programa, luego reinicia.");
                System.out.println("7) Reiniciar programa para escoger otro tipo de Mapa");
                System.out.print("\n Elige una de estas opciones: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("¡Lo siento!");
                    System.out.println("Tu entrada es incorrecta. Prueba con un número.");
                    scanner.next(); 
                    continue;
                }

                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1 -> {
                        System.out.print("\n Ingresa el nombre del Pokémon: ");
                        String pokemonName = scanner.nextLine().trim().toLowerCase();
                        System.out.println(userCollection.addPokemon(pokemonName, pokedex));
                    }
                    case 2 -> {
                        System.out.print("\n Ingresa el nombre del Pokémon: ");
                        String pokemonName = scanner.nextLine().trim().toLowerCase();
                        Pokemon p = operations.getPokemon(pokemonName);
                        System.out.println((p != null) ? p : "El Pokémon no ha sido encontrado.");
                    }
                    case 3 -> {
                        System.out.println("\n Los Pokémones en tu colección ordenados por Tipo No.1: ");
                        userCollection.collectionType1(pokedex);
                    }
                    case 4 -> {
                        System.out.println("\n Todos los Pokémon ordenados por Tipo No.1 : ");
                        operations.allType1();
                    }
                    case 5 -> {
                        System.out.print("Ingresa la habilidad que deseas buscar: ");
                        String ability = scanner.nextLine().trim();
                        operations.searchByAbility(ability);
                    }
                    case 6 -> {
                        System.out.println("Has cerrado este programa.");
                        continuar = false; 
                    }
                    case 7 -> {
                        System.out.println("Has reiniciado este programa.");
                        choice = 7;
                    }
                    default -> System.out.println("¡Tu opción es incorrecta! Mejor peueba con una que se encuentre en el menú.");
                }
            }
        }

        scanner.close();
    }
}
