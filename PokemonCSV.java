
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PokemonCSV{
    private Map<String, Pokemon> pokedex = new HashMap<>();

    public PokemonCSV(String filePath){
        cargarDatos(filePath);
    }

    private void cargarDatos(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            br.readLine();

            while ((linea = br.readLine()) != null) {
                // Eliminar comillas dobles y espacios extra
                linea = linea.replace("\"", "").trim();

                // Separar por comas, pero con control de habilidades
                String[] datos = linea.split(",");

  
                if (datos.length > 10) {
                    String habilidadesCompletas = String.join(",", Arrays.copyOfRange(datos, 7, datos.length - 2));
                    datos = new String[]{
                        datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6],
                        habilidadesCompletas, datos[datos.length -2], datos[datos.length- 1]
                    };
                }


                if (datos.length != 10) {
                    System.out.println("Línea mal formateada, ignorando: " + linea);
                    continue;
                }

                try {
                    String name = datos[0].trim();
                    int pokedexNum = Integer.parseInt(datos[1].trim());
                    String type1 = datos[2].trim();
                    String type2 = datos[3].trim().isEmpty() ? null : datos[3].trim();
                    String classification = datos[4].trim();
                    double height = Double.parseDouble(datos[5].trim());
                    double weight = Double.parseDouble(datos[6].trim());

                    List<String> abilities = Arrays.asList(datos[7].trim().split(", "));

                    int generation = Integer.parseInt(datos[8].trim());
                    boolean legendaryStatus = Boolean.parseBoolean(datos[9].trim());

                    Pokemon pokemon = new Pokemon(name, pokedexNum, type1, type2, classification, height, weight, abilities, generation, legendaryStatus);
                    pokedex.put(name.toLowerCase(), pokemon); 

                } catch (NumberFormatException e) {
                    System.out.println("Error en conversión de datos en línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public Map<String, Pokemon> getPokedex() {
        return pokedex;
    }
}
