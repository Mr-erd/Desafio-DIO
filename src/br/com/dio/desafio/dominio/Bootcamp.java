package br.com.dio.desafio.dominio;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.util.*;


public class Bootcamp {
    private final String nome;
    private final String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private final Set<Dev> devsInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao) {
        this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo");
        this.descricao = Objects.requireNonNull(descricao, "Descrição não pode ser nula");
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return Collections.unmodifiableSet(devsInscritos);
    }

    public Set<Conteudo> getConteudos() {
        return Collections.unmodifiableSet(conteudos);
    }

    public void adicionarConteudo(Conteudo conteudo) {
        conteudos.add(conteudo);
    }

    protected void inscreverDev(Dev dev) {
        devsInscritos.add(dev);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bootcamp)) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public List<Dev> getRanking() {
        return this.devsInscritos.stream()
                .sorted(Comparator.comparingDouble(Dev::calcularTotalXp).reversed())
                .collect(Collectors.toList());
    }
}
