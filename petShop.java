import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

class petShop{
    private static ArrayList<Tutor> tutores = new ArrayList<Tutor>();
    public static void main(String[] args){
        int cont = 1;
        char op = 'n';

        cont = popularCadastro(cont);

        while (op != 'x'){
            op = Menu();
            Scanner input = new Scanner(System.in);
            switch (op){
                case 'c':
                    System.out.println("Digite nome do tutor (vazio encerra cadastro tutor): ");
                    String nome_tutor = input.nextLine();
                    if (nome_tutor == ""){
                        break;
                    }
                    String[] data_com = {"ano","mes","dia"};
                    boolean veridata = false;
                    while (!veridata) {
                        System.out.println("Digite dia (dd), mes (mm) e ano (aaaa) de nascimento do tutor:  \n (separados por espa�os)");
                        String data_nasc = input.nextLine();
                        clearBuffer(input);
                        data_com = data_nasc.split(" ");
                        veridata = dataveri(Integer.parseInt(data_com[2]),Integer.parseInt(data_com[1]), Integer.parseInt(data_com[0]));
                        if (!veridata){
                            System.out.println("Dava invalida");
                        }
                    }
                    LocalDate data = LocalDate.of(Integer.parseInt(data_com[2]),Integer.parseInt(data_com[1]), Integer.parseInt(data_com[0]));
                    System.out.println("Digite endereco do tutor/pet: ");
                    String endereco = input.nextLine(); 
                    Tutor tutor = new Tutor(cont, nome_tutor, endereco, data);
                    System.out.println("Digite o nome do pet: ");
                    String nomePet = input.nextLine(); 
                    System.out.println("Digite o tipo de pet: ");
                    String tipoPet = input.nextLine(); 
                    tutor.incluiPet(nomePet, tipoPet);
                    tutores.add(tutor);
                    cont++;
                    break;
                case 'i':
                    for (Tutor ttl: tutores){
                        System.out.println(ttl.toString());
                    }
                    break;
                case 'b':
                    System.out.println("Digite codigo do tutor a ser localizado: ");
                    int tutor_num = input.nextInt(); clearBuffer(input);
                    boolean verificador = false;
                    for(Tutor tt: tutores) {
                        if (tt.getCodigo() == tutor_num) {
                            System.out.println(tt.toString());
                            verificador = true;
                            break;
                        }

                    }
                    if(verificador == false) {
                        System.out.println("codigo n�o localizado");
                    }
                    break;

                case 'e':
                    System.out.println("Digite o codigo do tutor a ser excluido: ");
                    int tutor_num_del = input.nextInt(); clearBuffer(input);
                    boolean verificadel = false;
                    for (Tutor ttd: tutores){
                        if (tutor_num_del == ttd.getCodigo()){
                            tutores.remove(tutores.indexOf(ttd));
                            System.out.println("Tutor codigo " + tutor_num_del + " excluido");
                            verificadel = true;
                            break;
                        }
                    }
                    if (verificadel == false){
                        System.out.println("esse Codigo nao existe");
                    }
                    break;
                    
                case 'x':
                    System.out.println("Programa encerrando");
                    break;
                default:
                    System.out.println("Opcao invalida!!!");


            }
        }
    }

    static char Menu(){
        System.out.println("*****ESCOLHER UMA OPCAO*****");
        System.out.println("c: cadastrar tutor + pet(s)");
        System.out.println("i: imprimir cadastro");
        System.out.println("b: buscar pets por codigo tutor");
        System.out.println("e: excluir pets por codigo tutor");
        System.out.println("x: encerrar.");
        System.out.println("Opcao escolhida:");
        Scanner sop = new Scanner(System.in);
        char op = sop.next().charAt(0);
        return op;
    }
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    // pelo menos tr�s tutores com seus pets
    public static int popularCadastro(int cont) {
        Tutor t; // Objeto tutor.

        //int codTut = geraCodTut(); // Cria c�digo sequencial inicando em 1.
        t = new Tutor(cont,"Josefina das Gracas","Rua  Jeronimo Luiz, 123",LocalDate.of(1968,9,13));
        t.incluiPet("Filomena","Cachorro");
        tutores.add(t);

        Tutor t2;

        t2 = new Tutor(cont+1,"Bernardo Ribeirinho","Rua Presidente Patrick, 456",LocalDate.of(1990,12,4));
        t2.incluiPet("Assobio","Passaro");
        tutores.add(t2);


        return cont+2;
    }
    private static boolean dataveri(int ano, int mes, int dia){
        if (ano < 1900){
            return false;
        }

        if (mes < 12){
            return false;
        }

        if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia > 31)){
            return false;
        }
        if (ano % 4 == 0 && mes == 2 && dia > 29){
            return false;
        }
        if (ano % 4 != 0 && mes == 2 && dia > 28){
            return false;
        }

        if ((mes == 4 || mes == 6 || mes == 9 || mes== 11) && dia<30){
            return false;
        }
        return true;

    }
}



