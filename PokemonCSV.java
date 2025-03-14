import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PokemonCSV {
    //Almacenamiento para un nuevo pokemon que se agrega en el repertorio del usuario:
    private Map<String, Pokemon> pokedex = new HashMap<>();
    
    public PokemonCSV(String filePath) {
        Dates(filePath);
    } 
    
    private void Dates(String filePath){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            br.readLine();


            while((line = br.readLine()) != null){
                String[] dates = line.split(",");

                String name = dates[0].trim();
                int pokedexNum = Integer.parseInt(dates[1].trim());
                String type1 = dates[2].trim();
                String type2 = dates[3].trim().isEmpty() ? null : dates[3].trim();
                String classification = dates[4].trim();
                double height = Double.parseDouble(dates[5].trim());
                double weight = Double.parseDouble(dates[6].trim());
                List<String> abilities = Arrays.asList(dates[7].trim().split(";")); // Separadas por ";"
                int generation = Integer.parseInt(dates[8].trim());
                boolean lengendaryStatus = Boolean.parseBoolean(dates[9].trim());
                
                Pokemon pokemon = new Pokemon(name, pokedexNum, type1, type2, classification, height, weight, abilities, generation, lengendaryStatus);

                pokedex.put(name, pokemon);
            }
        
        
        }
        catch (IOException e){
            System.out.println("Se ha producido un error al leer el archivo: " + e.getMessage());
        }
        catch(NumberFormatException e){
            System.out.println("Se ha producido un error de interpretación de datos" + e.getMessage());
        } 
    }

    public Map<String, Pokemon> getPokedex(){
        return pokedex;
    }
}
