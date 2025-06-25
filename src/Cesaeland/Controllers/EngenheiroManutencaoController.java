package Cesaeland.Controllers;

import Cesaeland.Models.Atracao;
import Cesaeland.Repositories.AtracoesRepository;
import Cesaeland.Repositories.VendasRepository;

import java.io.FileNotFoundException;
import java.util.Map;

public class EngenheiroManutencaoController {

    private AtracoesRepository atracoesRepository;
    private VendasRepository vendasRepository;

    public EngenheiroManutencaoController() throws FileNotFoundException {
        this.atracoesRepository = new AtracoesRepository();
        this.vendasRepository = new VendasRepository();
    }



    // • Consultar Próximas Revisões: Consulta as 3 próximas revisões a serem efetuadas e o número de bilhetes que
    //faltam vender para a revisão ter de ser efetuada. Deve identificar o ID da Atração, Nome de Atração e Número
    //de Bilhetes que Faltam.

    //• Consultar Histórico de Revisões: Consulta as 3 últimas revisões que foram efetuadas. Deve identificar o ID da
    //Atração, Nome de Atração e Número de Bilhetes vendidos depois da última revisão.

//    public Map<Atracao,Integer> proximasRevisoes() {
//        // identificar as 3 proximas revisoes
//    }


}
