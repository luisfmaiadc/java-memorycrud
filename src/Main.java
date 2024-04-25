import javax.swing.*;

/**
 * @author lf_mc
 */

public class Main {

    private static IClienteDAO iClienteDAO;
    static String opcao, dados, cpfCadastrado;
    static boolean correctNumber;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        dialog();

        while (!correctNumber) {
            opcaoEscolhida();
        }
    }

    private static void dialog() {
        opcao = JOptionPane.showInputDialog(null, "Digite qualquer número abaixo para prosseguir: \n 1 - Cadastrar \n 2 - Consultar \n 3 - Excluir \n 4 - Alterar \n 5 - Sair",
                "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void opcaoEscolhida() {
        switch (Integer.parseInt(opcao.trim())) {
            case 1:
                dados = JOptionPane.showInputDialog(null, "Digite o Nome, Endereço, Cidade, Estado e CPF, as informações devem estar separadas por vírgula.",
                        "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
                break;

            case 2:
                cpfCadastrado = JOptionPane.showInputDialog(null, "Digite apenas o CPF para consultar suas informações.",
                        "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
                consultar(cpfCadastrado);
                break;

            case 3:
                cpfCadastrado = JOptionPane.showInputDialog(null, "Digite apenas o CPF do cliente para excluí-lo.",
                        "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
                excluir(cpfCadastrado);
                break;

            case 4:
                dados = JOptionPane.showInputDialog(null, "Digite as novas informações do cliente mantendo-se o CPF.",
                        "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
                alterar(dados);
                break;

            case 5:
                correctNumber = true;
                sair();
                break;

            default:
                opcao = JOptionPane.showInputDialog(null, "Opção inválida! Digite qualquer número abaixo para prosseguir: \n 1 - Cadastrar \n 2 - Consultar \n 3 - Excluir \n 4 - Alterar \n 5 - Sair",
                        "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
                correctNumber = false;
        }
    }

    private static void cadastrar(String dados) {
        String[] dadosCliente = dados.split(",");
        Cliente cliente = new Cliente(dadosCliente[0], dadosCliente[1], dadosCliente[2], dadosCliente[3], dadosCliente[4]);
        boolean cadastrado = iClienteDAO.cadastrar(cliente);
        if (cadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!",
                    "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
            dialog();
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Cliente já cadastrado.",
                    "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
            dialog();
        }
    }

    private static void consultar(String cpfCadastrado) {
        Cliente cliente = iClienteDAO.consultar(Integer.valueOf(cpfCadastrado.trim()));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, cliente.toString(),
                    "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
            dialog();
        } else {
            JOptionPane.showMessageDialog(null, "CPF não encontrado ou não cadastrado.",
                    "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
            dialog();
        }
    }

    private static void alterar(String dados) {
        String[] novosDadosCliente = dados.split(",");
        Cliente cliente = new Cliente(novosDadosCliente[0], novosDadosCliente[1], novosDadosCliente[2], novosDadosCliente[3], novosDadosCliente[4]);
        boolean alterado = iClienteDAO.alterar(cliente);
        if (alterado) {
            JOptionPane.showMessageDialog(null, "Informações do cliente " + cliente.getNome() + " alteradas com sucesso!",
                    "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
            dialog();
        } else {
            JOptionPane.showMessageDialog(null, "CPF não encontrado ou não cadastrado.",
                    "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
            dialog();
        }
    }

    private static void excluir(String cpfCadastrado) {
        boolean excluido = iClienteDAO.excluir(Integer.valueOf(cpfCadastrado.trim()));
        if (excluido) {
            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!!",
                    "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
            dialog();
        } else {
            JOptionPane.showMessageDialog(null, "CPF não encontrado ou não cadastrado.",
                    "Java - CRUD", JOptionPane.INFORMATION_MESSAGE);
            dialog();
        }
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Obrigado por executar o CRUD em memória na linguagem Java de Luis Felipe Maia da Costa.",
                "Até mais!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}