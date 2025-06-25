package Cesaeland.Controllers;

import Cesaeland.Models.Atracao;
import Cesaeland.Models.Venda;
import Cesaeland.Repositories.AtracoesRepository;
import Cesaeland.Repositories.VendasRepository;

import java.io.FileNotFoundException;
import java.util.*;

public class EngenheiroManutencaoController {

    private AtracoesRepository atracoesRepository;
    private VendasRepository vendasRepository;

    public EngenheiroManutencaoController() throws FileNotFoundException {
        this.atracoesRepository = new AtracoesRepository();
        this.vendasRepository = new VendasRepository();
    }

    public Map<Atracao,Integer> vendasPorAtracao() {
        // crair mapa vazio
        Map<Atracao,Integer> vendasPorAtracao = new HashMap<>();

        // preencher com as atracoes (colocar as vendas a zero por enquanto)
        for( Atracao atracao : this.atracoesRepository.getAtracaoArray()) {
            vendasPorAtracao.put(atracao,0);
        }

        // agora iterar o vendasRepository e o mapa para somar as vendas por atracao
        for (Venda venda : this.vendasRepository.getVendasArray()) {
            for (Atracao atracao : vendasPorAtracao.keySet()) {
                if (atracao.getIdAtracao() == venda.getIdAtracao()) {
                    // pega o valor atual e soma 1
                    int atual = vendasPorAtracao.get(atracao);
                    vendasPorAtracao.put(atracao, atual + 1);
                }
            }
        }

        return vendasPorAtracao;
    }

    public Map<Atracao,Integer> proximasRevisoes(Map<Atracao,Integer> vendasPorAtracao) {
        // criar um novo map auxiliar com as atracoes e o numero de bilhetes qua faltam para a proxima revisao
        Map<Atracao,Integer> proximasRevisoes = new HashMap<>();

        // Prencher o mapa auxiliar
        for(Atracao atracao : vendasPorAtracao.keySet()) {
            proximasRevisoes.put(atracao, (vendasPorAtracao.get(atracao)%50));
        }

        // identificar as 3 proximas revisoes
        // ordenar o map proximasRevisoes por valores, do maior para o menor

        // Converter para lista de entradas
        List<Map.Entry<Atracao, Integer>> listaOrdenada = new ArrayList<>(proximasRevisoes.entrySet());

        // Ordenar pelos valores (revisões), do MAIOR para o MENOR
        listaOrdenada.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Criar um LinkedHashMap para manter a ordem da lista
        Map<Atracao, Integer> proximasRevisoesOrdenadas = new LinkedHashMap<>();

        for (int i = 0; i < Math.min(3, listaOrdenada.size()); i++) {
            Map.Entry<Atracao, Integer> entry = listaOrdenada.get(i);
            proximasRevisoesOrdenadas.put(entry.getKey(), entry.getValue());
        }

        return proximasRevisoesOrdenadas;

    }


    public Map<Atracao,Integer> historicoRevisoes(Map<Atracao,Integer> vendasPorAtracao) {
        // criar um novo mapa com as atrações e o número de bilhetes desde a última revisão
        Map<Atracao,Integer> historicoRevisoes = new HashMap<>();

        // Prencher o mapa auxiliar
        for(Atracao atracao : vendasPorAtracao.keySet()) {
            historicoRevisoes.put(atracao, (vendasPorAtracao.get(atracao)%50));
        }

        // identificar as 3 ultimas revisoes
        // ordenar o map historicoRevisoes por valores, do menor para o maior

        // Converter para lista de entradas
        List<Map.Entry<Atracao, Integer>> listaOrdenada = new ArrayList<>(historicoRevisoes.entrySet());

        // Ordenar pelos valores (revisões), do MAIOR para o MENOR
        listaOrdenada.sort(Map.Entry.comparingByValue(Comparator.naturalOrder()));

        // Criar um LinkedHashMap para manter a ordem da lista
        Map<Atracao, Integer> historicoRevisoesOrdenadas = new LinkedHashMap<>();

        for (int i = 0; i < Math.min(3, listaOrdenada.size()); i++) {
            Map.Entry<Atracao, Integer> entry = listaOrdenada.get(i);
            historicoRevisoesOrdenadas.put(entry.getKey(), entry.getValue());
        }

        return historicoRevisoesOrdenadas;

    }


}
