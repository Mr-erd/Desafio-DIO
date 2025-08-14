package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {

    private  String nome;
    private Set<Conteudo> conteudoInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudoConcluido = new LinkedHashSet<>();



    public void  inscreverBootcamp(Bootcamp bootcamp) {

        this.conteudoInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
       Optional<Conteudo> conteudo = this.conteudoInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudoConcluido.add(conteudo.get());
            this.conteudoInscritos.remove(conteudo.get());
        }else {
            System.err.println("Voce nao esta matriculado em nenhum conteudo");
        }
    }

    public double calcularTotalXp() {
        return this.conteudoConcluido
                .stream()
                .mapToDouble(Conteudo::calcularXP)
                .sum();


    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudoInscricao() {
        return conteudoInscritos;
    }

    public void setConteudoInscricao(Set<Conteudo> conteudoInscricao) {
        this.conteudoInscritos = conteudoInscricao;
    }

    public Set<Conteudo> getConteudoConcluido() {
        return conteudoConcluido;
    }

    public void setConteudoConcluido(Set<Conteudo> conteudoConcluido) {
        this.conteudoConcluido = conteudoConcluido;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudoInscritos, dev.conteudoInscritos) && Objects.equals(conteudoConcluido, dev.conteudoConcluido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudoInscritos, conteudoConcluido);
    }
}
