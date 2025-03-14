


import java.util.*;
public class MapFactory{
    public static Map<String, Pokemon> getMap(String type){
        switch (type.toLowerCase()){
            case "hashmap":
                return new HashMap<>();
            case "treemap":
                return new TreeMap<>();
            case "linkedhashmap":
                return new LinkedHashMap<>();
            default:
                System.out.println("Tu mapa no se encuentra disponible.");
                return new HashMap<>();
        }
    }
}

