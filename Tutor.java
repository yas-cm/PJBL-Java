import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class Tutor{
   // Atributos
   private int codigo;
   private String nome;
   private String endereco;
   private LocalDate dataNasc;
   private ArrayList<Pet> pet=new ArrayList<Pet>();
   
   // Construtor
   public Tutor(int c, String n, String e, LocalDate d){
      codigo = c;
      nome = n;
      endereco = e;
      dataNasc = d;
   }
   
   // Getters
   public int getCodigo() {return codigo;}
   public String getNome() {return nome;}
   public String getEndereco() {return endereco;}
   
   public String getDataNasc() {
      DateTimeFormatter fmt=DateTimeFormatter.ofPattern("dd/MM/yyyy");
      return dataNasc.format(fmt);
   }
   public int getIdade(){
      LocalDate dataSistema=LocalDate.now();
      int idade=Period.between(dataNasc,dataSistema).getYears();
      return idade;
   }
   
   // Adiciona pet
   public void incluiPet(String nomePet, String tipoPet){
      pet.add(new Pet(nomePet,tipoPet));
   }
   
   // Geração de string com os dados do tutor   
   public String toString(){
      String ts = String.format("Cod. do tutor: %d\n", codigo);
      ts += String.format("  Nome...........: %s\n", nome);
      ts += "  Data nascimento: "+getDataNasc()+ " ("+ getIdade() +" anos)\n";
      ts += String.format("  Endereco.......: %s\n", endereco);
      ts += "  Relacao de pets:\n";
      if (pet.size() == 0)
         ts+="Nenhum pet cadastrado.\n";
      else{
         for(Pet p:pet){ 
            ts+= "  - Nome do pet: "+p.getNomePet()+"; ";
            ts+= "Tipo: "+p.getTipoPet()+".\n";
            }
      }
      return ts;
      }
}   

// 
// // pelo menos três tutores com seus pets
// public static void popularCadastro() {
//    Tutor t; // Objeto tutor.
//    
//    int codTut = geraCodTut(); // Cria código sequencial inicando em 1.
//    t = new Tutor(codTut,"Josefina das Gracas");
//    t.setD
//    
//    cont.add(c);
//    System.out.println(c.getNome()+": cadastrado.");
//    // Adiciona contribuinte 2 com dependente.
//    codCont=geraCodCont(); // Cria próximo código sequencial.
//    c=new Contribuinte(codCont,"Maria Cardoso");
//    c.incluiDep("Pedro Cardoso",2,4,2012);
//    cont.add(c);
//    System.out.println(c.getNome()+": cadastrado.");
//    // Adiciona contribuinte 3.
//    codCont=geraCodCont(); // Cria próximo código sequencial.
//    c=new Contribuinte(codCont,"Roberto Silva");
//    cont.add(c);
//    System.out.println(c.getNome()+": cadastrado.");
// }
//    
//    
   
   
   
   
   
   
   
   
   
   
   
   
