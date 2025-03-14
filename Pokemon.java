

import java.util.List;
public class Pokemon{
    private String name;
    private int pokedexNum;
    private String type1;
    private String type2;
    private String classification;
    private double height;
    private double weight;
    private List<String> abilities;
    private int generation;
    private boolean legendaryStatus;

    public Pokemon(String name, int pokedexNum, String type1, String type2, String classification, double height, double weight , List<String> abilities, int generation, boolean legendaryStatus){
        this.name = name;
        this.pokedexNum = pokedexNum;
        this.type1 = type1;
        this.type2= type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight ;
        this.abilities = abilities;
        this.generation = generation;
        this.legendaryStatus = legendaryStatus;

    }

    public String getName(){return name; }
    public int getPokedexNum(){return pokedexNum; }
    public String getType1(){ return type1;}
    public String getType2(){ return type2;}
    public String getClassification(){ return classification; }
    public double getHeight(){ return height;}
    public double getWeight(){ return weight;}
    public List<String> getAbilities() { return abilities;}
    public int getGeneration(){return generation; }
    public boolean isLegendary(){return legendaryStatus; }

    @Override
    public String toString() {
        return "Pokemon Nombre = " + name +    ", type1=        " + type1 + (type2 != null ? ",    type2=       " + type2 : "   ") +  ",    abilities  =  " + String.join(", ", abilities) ;
    }

}
