# 🏆 Explicação da Funcionalidade de Ranking

A implementação da funcionalidade de ranking de desenvolvedores no projeto do Bootcamp, explicando a lógica de negócio e a camada de apresentação.

O objetivo da implementação foi criar uma lista dos desenvolvedores inscritos, ordenada daquele com mais XP para o que tem menos XP.

## 1. A Lógica Principal (Em `Bootcamp.java`)

A responsabilidade de gerar o ranking pertence à classe `Bootcamp`, pois é ela quem gerencia a lista de desenvolvedores inscritos. Para isso, foi criado o método `getRanking()`.

### Código-Fonte do Método

```java
// Em Bootcamp.java
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public List<Dev> getRanking() {
    return this.devsInscritos.stream()
            .sorted(Comparator.comparingDouble(Dev::calcularTotalXp).reversed())
            .collect(Collectors.toList());
}
