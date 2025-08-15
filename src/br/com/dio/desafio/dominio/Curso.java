package br.com.dio.desafio.dominio;


public class Curso extends Conteudo {

    private final int cargaHoraria;

    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        if (cargaHoraria <= 0) throw new IllegalArgumentException("Carga horária deve ser positiva");
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + ";" +
        ", descricao='" + getDescricao() + ";" +
        ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
