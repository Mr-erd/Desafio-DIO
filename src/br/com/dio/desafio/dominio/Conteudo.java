package br.com.dio.desafio.dominio;

import java.util.Objects;


public abstract class Conteudo {
    protected static final double XP_PADRAO = 10d;

    private final String titulo;
    private final String descricao;

    public Conteudo(String titulo, String descricao) {
        this.titulo = Objects.requireNonNull(titulo, "Título não pode ser nulo");
        this.descricao = Objects.requireNonNull(descricao, "Descrição não pode ser nula");
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract double calcularXp();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conteudo)) return false;
        Conteudo conteudo = (Conteudo) o;
        return Objects.equals(titulo, conteudo.titulo) && Objects.equals(descricao, conteudo.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao);
    }
}
