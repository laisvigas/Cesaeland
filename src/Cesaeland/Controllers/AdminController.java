package Cesaeland.Controllers;

import Cesaeland.Models.Atracao;
import Cesaeland.Models.Venda;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AdminController {

    public static final String ATRACOES_FILE = "Files/Cesaeland_atracoes.csv";
    public static final String CUSTOS_FILE = "Files/Cesaeland_custos.csv";
    public static final String LOGINS_FILE = "Files/Cesaeland_logins.csv";
    public static final String VENDAS_FILE = "Files/Cesaeland_vendas.csv";

    private ArrayList<Atracao> atracoes;
    private ArrayList<Venda> vendas;

    public AdminController(ArrayList<Atracao> atracoes, ArrayList<Venda> vendas) {
        this.atracoes = atracoes;
        this.vendas = vendas;
    }

    public void consultarTotalVendas() {
        System.out.println("Total de bilhetes vendidos: " + vendas.size());
    }

    public void consultarLucroTotal() {
        double total = vendas.stream()
                .mapToDouble(v -> {
                    Atracao a = getAtracaoById(v.getIdAtracao());
                    return v.getTipoCliente().equalsIgnoreCase("adulto")
                            ? a.getPrecoAdulto()
                            : a.getPrecoCrianca();
                })
                .sum();
        System.out.printf("Lucro total: %.2f €%n", total);
    }

    public void consultarVendasLucroPorMes() {
        Map<Integer, List<Venda>> agrupado = vendas.stream()
                .collect(Collectors.groupingBy(Venda::getData)); // Ex: "04/2024"

        for (Integer mesAno : agrupado.keySet()) {
            List<Venda> lista = agrupado.get(mesAno);
            int total = lista.size();
            double lucro = lista.stream().mapToDouble(v -> {
                Atracao a = getAtracaoById(v.getIdAtracao());
                return v.getTipoCliente().equalsIgnoreCase("adulto")
                        ? a.getPrecoAdulto()
                        : a.getPrecoCrianca();
            }).sum();
            System.out.printf("%s: %d bilhetes vendidos, %.2f € de lucro%n", mesAno, total, lucro);
        }
    }

    public void atracaoMaisProcuradaPorAdultos() {
        atracaoMaisProcurada("adulto");
    }

    public void atracaoMaisProcuradaPorCriancas() {
        atracaoMaisProcurada("crianca");
    }

    public void atracaoMaisProcuradaGeral() {
        Map<Integer, Long> contagem = vendas.stream()
                .collect(Collectors.groupingBy(Venda::getIdAtracao, Collectors.counting()));

        int id = Collections.max(contagem.entrySet(), Map.Entry.comparingByValue()).getKey();
        Atracao atracao = getAtracaoById(id);
        System.out.println("Mais procurada (geral): " + atracao.getNome());
    }

    public void atracaoMaisLucrativa() {
        Map<Integer, Double> lucros = new HashMap<>();
        for (Venda v : vendas) {
            Atracao a = getAtracaoById(v.getIdAtracao());
            double preco = v.getTipoCliente().equalsIgnoreCase("adulto")
                    ? a.getPrecoAdulto()
                    : a.getPrecoCrianca();
            int id = a.getIdAtracao();
            lucros.put(id, lucros.getOrDefault(id, 0.0) + preco);
        }

        int id = Collections.max(lucros.entrySet(), Map.Entry.comparingByValue()).getKey();
        Atracao a = getAtracaoById(id);
        System.out.println("Mais lucrativa: " + a.getNome());
    }

    public void atracaoMenosLucrativa() {
        Map<Integer, Double> lucros = new HashMap<>();
        for (Venda v : vendas) {
            Atracao a = getAtracaoById(v.getIdAtracao());
            double preco = v.getTipoCliente().equalsIgnoreCase("adulto")
                    ? a.getPrecoAdulto()
                    : a.getPrecoCrianca();
            int id = a.getIdAtracao();
            lucros.put(id, lucros.getOrDefault(id, 0.0) + preco);
        }

        int id = Collections.min(lucros.entrySet(), Map.Entry.comparingByValue()).getKey();
        Atracao a = getAtracaoById(id);
        System.out.println("Menos lucrativa: " + a.getNome());
    }

    public void atracaoMelhorPrecoTempo() {
        Atracao melhor = atracoes.stream()
                .min(Comparator.comparingDouble(a -> {
                    double precoMedio = (a.getPrecoAdulto() + a.getPrecoCrianca()) / 2.0;
                    return precoMedio / a.getDuracaoSegundos();
                }))
                .orElse(null);

        if (melhor != null) {
            System.out.println("Melhor preço/tempo: " + melhor.getNome());
        }
    }

    public void adicionarNovoLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tipo de Acesso (ADMIN/ENG): ");
        String tipo = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOGINS_FILE, true))) {
            writer.write(tipo + ";" + username + ";" + password);
            writer.newLine();
            System.out.println("✅ Novo login guardado com sucesso.");
        } catch (IOException e) {
            System.out.println("❌ Erro ao guardar login: " + e.getMessage());
        }
    }

    // === Métodos auxiliares ===

    private void atracaoMaisProcurada(String tipoCliente) {
        Map<Integer, Long> contagem = vendas.stream()
                .filter(v -> v.getTipoCliente().equalsIgnoreCase(tipoCliente))
                .collect(Collectors.groupingBy(Venda::getIdAtracao, Collectors.counting()));

        int id = Collections.max(contagem.entrySet(), Map.Entry.comparingByValue()).getKey();
        Atracao atracao = getAtracaoById(id);
        System.out.printf("Mais procurada por %s: %s%n", tipoCliente, atracao.getNome());
    }

    private Atracao getAtracaoById(int id) {
        return atracoes.stream()
                .filter(a -> a.getIdAtracao() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Atração não encontrada: " + id));
    }
}