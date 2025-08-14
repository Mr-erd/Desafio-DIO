import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso java");
        curso1.setDescricao("descriçao Curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso js");
        curso2.setDescricao("descriçao Curso js");
        curso2.setCargaHoraria(4);


        Conteudo conteudo = new Curso();


        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria java");
        mentoria.setDescricao("descricao mentoria java");
        mentoria.setData(LocalDate.now());


       /* System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devBred = new Dev();
        devBred.setNome("Bred");
        devBred.inscreverBootcamp(bootcamp);
        System.out.println("conteudos iniciados Bred" + devBred.getConteudoInscricao());
        devBred.progredir();
        System.out.println("conteudos concluidos Bred" + devBred.getConteudoConcluido());
        System.out.println("XP: " + devBred.calcularTotalXp());


        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("conteudos iniciados Joao" + devJoao.getConteudoInscricao());
        devJoao.progredir();
        System.out.println("conteudos concluidos Joao" + devJoao.getConteudoConcluido());
        System.out.println("XP: " + devJoao.calcularTotalXp());



    }
}