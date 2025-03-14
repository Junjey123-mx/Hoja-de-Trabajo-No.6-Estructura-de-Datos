
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserCollection {
    private Set<String> pokemonsOfUser; // Usamos HashSet para evitar duplicados

    // Constructor
    public UserCollection() {
        this.pokemonsOfUser = new HashSet<>();
    }

    // Verificar si el Pokémon ya está en la colección del usuario
    public boolean verifyPokemon(String name){
        return pokemonsOfUser.contains(name);
    }

    // Agregar un Pokémon a la colección del usuario
    public String addPokemon(String name, Map<String, Pokemon> pokedex){
        if (!pokedex.containsKey(name)) {
            return "¡Uy! El Pokémon " + name + " no se encuentra en la base de datos.";
        }
        if (pokemonsOfUser.contains(name)) {
            return "El Pokémon " + name + " ya está en tu colección.";
        }
        pokemonsOfUser.add(name);
        return "¡El Pokémon '" + name + "' ha sido agregado a tu colección!";
    }

    // Mostrar los Pokémon de la colección del usuario
    public void collection(){
        if (pokemonsOfUser.isEmpty()){
            System.out.println("¡Uy! Tu colección aún se encuentra vacía.");
        } else {
            for (String name : pokemonsOfUser) {
                System.out.println(name);
            }
        }
    }

    // Mostrar los Pokémon de la colección del usuario ordenados por Type1
    public void collectionType1(Map<String, Pokemon> pokedex) {
        if (pokemonsOfUser.isEmpty()) { // Verifica si la colección está vacía
            System.out.println("¡Tu colección está vacía!");
            return; // Salir del método si no hay Pokémon
        }
    
        long startTime = System.nanoTime(); // Inicio del tiempo
    
        pokemonsOfUser.stream()
            .map(pokedex::get)
            .sorted(Comparator.comparing(Pokemon::getType1))
            .forEach(System.out::println);
    
        long endTime = System.nanoTime(); // Fin del tiempo
        System.out.println("Tiempo de ejecución: " + (endTime- startTime)/ 1e6 + " ms");
    }
    

    // Buscar Pokémon por habilidad en la colección del usuario
    public void searchAbility(String ability, Map<String, Pokemon> pokedex){
        boolean found = false;
        for (String name : pokemonsOfUser){
            Pokemon p = pokedex.get(name);
            if (p.getAbilities().contains(ability)){
                System.out.println(p.getName());
                found = true;
            }
        }
        if (!found){
            System.out.println("No hay Pokémon en tu colección con la habilidad: " + ability);
        }
    }

}

