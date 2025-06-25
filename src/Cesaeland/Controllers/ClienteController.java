package Cesaeland.Controllers;
import Cesaeland.Models.Atracao;
import Cesaeland.Models.Venda;
import Cesaeland.Repositories.AtracoesRepository;
import Cesaeland.Repositories.VendasRepository;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// Consultar Atrações Disponíveis: Deve imprimir em forma de tabela, as atrações,
// preços dos bilhetes e duração da atração no formato min:seg.

// Consultar Atrações Favoritas: Deve imprimir a atração mais procurada
// por adultos e a atração mais procurada por crianças
// (que vendeu mais bilhetes no total, para o respetivo segmento de clientes).

public class ClienteController {
    private AtracoesRepository atracoesRepository;
    private VendasRepository vendasRepository;

    public ClienteController() throws FileNotFoundException {
        this.atracoesRepository = new AtracoesRepository();
        this.vendasRepository = new VendasRepository();
    }

    public ArrayList<Atracao> consultarAtracoesDisponiveis(){
        return atracoesRepository.getAtracaoArray();
    }

    public String consultarAtracoesDisponiveisMinSeg(){
        int minutos = 0;
        int segundos = 0;
        for (Atracao atracao : this.atracoesRepository.getAtracaoArray()){
            int segundosTotais = (int) atracao.getDuracaoSegundos();
            minutos = segundosTotais / 60;
            segundos = segundosTotais % 60;
        }
        return minutos + ":" + segundos;
    }

    public String atracoesFavoritasAdultos(){
        return "";
    }
}