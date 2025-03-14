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

        public void AllType1(){
            List<Pokemon> List= new ArrayList<>(pokedex.values());
        }
}
    

