import java.util.ArrayList;
public class Pet{
   //Atributos
   private String nomePet;
   private String tipoPet;
   //Construtor
   public Pet(String nomePet, String tipoPet){
      this.nomePet = nomePet;
      this.tipoPet = tipoPet;
   }
   //Getters
   public String getNomePet(){
      return nomePet;
   }
   public String getTipoPet(){
      return tipoPet;
   }
}