import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso("Java", "Curso de Java completo", 8);
        Curso curso2 = new Curso("Spring Boot", "API REST com Spring Boot", 6);
        Mentoria mentoria = new Mentoria("Mentoria Java", "Dicas de carreira", LocalDate.now());

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Formação completa Java");
        bootcamp.adicionarConteudo(curso1);
        bootcamp.adicionarConteudo(curso2);
        bootcamp.adicionarConteudo(mentoria);

        Dev dev1 = new Dev("João");
        Dev dev2 = new Dev("Maria");

        inscreverDev(dev1, bootcamp);
        inscreverDev(dev2, bootcamp);

        dev1.progredir();
        dev1.progredir();

        dev2.progredir();

        exibirStatus(dev1);
        exibirStatus(dev2);




       exibirStatus(dev1);
       exibirStatus(dev2);

       exibirRanking(bootcamp);

    }

    private static void inscreverDev(Dev dev, Bootcamp bootcamp) {
        dev.inscreverBootcamp(bootcamp);
        System.out.println(dev.getNome() + " inscrito no bootcamp " + bootcamp.getNome());
    }

    private static void exibirStatus(Dev dev) {
        System.out.println("Dev: " + dev.getNome());
        System.out.println("Conteúdos Inscritos: " + dev.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos: " + dev.getConteudosConcluidos());
        System.out.println("XP Total: " + dev.calcularTotalXp());
        System.out.println("------");
    }




    private static void exibirRanking(Bootcamp bootcamp) {
        System.out.println("🏆 --- Ranking do Bootcamp: " + bootcamp.getNome() + " --- 🏆");
        List<Dev> ranking = bootcamp.getRanking();

        for (int i = 0; i < ranking.size(); i++) {
            Dev dev = ranking.get(i);
            System.out.printf("%dº Lugar: %-15s | XP Total: %.2f%n",
                    (i + 1),
                    dev.getNome(),
                    dev.calcularTotalXp());
        }
        System.out.println("-------------------------------------------------");
    }



}
