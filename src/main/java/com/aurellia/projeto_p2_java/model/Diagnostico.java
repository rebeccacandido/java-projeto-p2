package com.aurellia.projeto_p2_java.model;

public class Diagnostico {

    private Long alunoId;
    private int acertos;
    private int total;
    private String trilha;

    public Diagnostico() {
    }

    public Diagnostico(Long alunoId, int acertos, int total, String trilha) {
        this.alunoId = alunoId;
        this.acertos = acertos;
        this.total = total;   // importante!
        this.trilha = trilha;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTrilha() {
        return trilha;
    }

    public void setTrilha(String trilha) {
        this.trilha = trilha;
    }
}
