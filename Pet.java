import java.util.ArrayList;
public class Pet{ //Cria a classe Pet
   //Atributos
   private String nomePet;
   private String tipoPet;
   //Construtor
   public Pet(String nomePet, String tipoPet){
      this.nomePet = nomePet;
      this.tipoPet = tipoPet;
   }
   //Getters
   public String getNomePet(){ //Recebe o nome do Pet
      return nomePet;
   }
   public String getTipoPet(){ //Recebe o tipo do Pet
      return tipoPet;
   }
}
