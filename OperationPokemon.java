

import java.util.*;

public class OperationPokemon{
    private Map<String, Pokemon> pokedex;

    public OperationPokemon(Map<String, Pokemon> pokedex){
        this.pokedex = pokedex;
    }

    public void addPokemon(Pokemon pokemon){
        pokedex.put(pokemon.getName(), pokemon);
    }

    public Pokemon getPokemon(String name){
        return pokedex.get(name);
    }

    public void allType1(){
        //Medición del tiempo:
        long startTime = System.nanoTime(); 

        List<Pokemon> sortedList = new ArrayList<>(pokedex.values());
        Collections.sort(sortedList, Comparator.comparing(Pokemon::getType1));

        for (Pokemon p : sortedList){
            System.out.println(p);
        }long endTime = System.nanoTime(); // Fin de medición
        System.out.println("Tiempo de ejecución: " + (endTime-startTime)/1e6 + " ms");
    }

    public void searchByAbility(String ability){
        long startTime = System.nanoTime(); // Inicio de medición

        pokedex.values().stream()
                .filter(pokemon -> pokemon.getAbilities().contains(ability))
                .forEach(System.out::println);

        long endTime = System.nanoTime(); // Fin de medición
        System.out.println("Tiempo de ejecución: " + (endTime-startTime)/1e6 + " ms");
    }

    public Collection<Pokemon> getAllPokemons(){
        return pokedex.values();
    }
}
