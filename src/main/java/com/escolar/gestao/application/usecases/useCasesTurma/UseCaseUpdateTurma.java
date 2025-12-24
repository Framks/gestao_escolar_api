package com.escolar.gestao.application.usecases.useCasesTurma;

public interface UseCaseUpdateTurma {
    void updateTurma(String codigo,
                     String codigoDisciplina,
                     String matriculaProfessor,
                     String semestre,
                     Integer capacidadeMaxima);
    void addAluno(String matricula, String codigoTurma);
    void removeAluno(String matricula, String codigoTurma);

}
