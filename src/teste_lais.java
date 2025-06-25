import Cesaeland.Controllers.ClienteController;
import Cesaeland.Repositories.AtracoesRepository;
import java.io.FileNotFoundException;

public class teste_lais {
    public static void main(String[] args) throws FileNotFoundException {
        AtracoesRepository ar = new AtracoesRepository();
        ClienteController cc = new ClienteController();
        cc.consultarAtracoesDisponiveis();

        cc.consultarAtracoesDisponiveisMinSeg();
    }
}
