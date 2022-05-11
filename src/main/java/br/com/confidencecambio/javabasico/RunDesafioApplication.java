package br.com.confidencecambio.javabasico;

import br.com.confidencecambio.javabasico.model.Cliente;
import br.com.confidencecambio.javabasico.model.Gerente;
import br.com.confidencecambio.javabasico.model.ModelBase;
import br.com.confidencecambio.javabasico.model.Robo;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunDesafioApplication {

    public static void main(String[] args) {

        var cliente = new Cliente();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        cliente.setNome(scanner.nextLine());
        executar(cliente);

        var gerente = new Gerente();
        System.out.println("Digite o nome do Gerente: ");
        gerente.setNome(scanner.nextLine());
        executar(gerente);

        var robo = new Robo();
        System.out.println("Digite o nome do Robô: ");
        robo.setNome(scanner.nextLine());
        executar(robo);

    }

    private static void executar(ModelBase base) {

        if (StringUtils.isBlank(base.getNome())) {
            System.out.println("Nome não pode ser vazio ou nulo");
            return;
        }

        if (base.getNome().startsWith(" ") || base.getNome().endsWith(" ")) {
            System.out.println("Nome não pode conter espaços extras no início e no fim");
            return;
        }

        var nome = base.getNome();
        var regex = "\\S+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nome);

        if (matcher.find()) {
            System.out.println(String.format("-> Deve ser possível obter o primeiro nome: %s", matcher.group(0)));
            var indice = nome.indexOf(" ");
            System.out.println(String.format("-> Retornar o último nome: %s", nome.substring(indice).trim()));
            System.out.println(String.format("-> Retornar o nome todo em letras maiúsculas: %s", nome.toUpperCase()));

            var ultimosNomes = nome.substring(indice).trim();
            var nomeAbreviado = ultimosNomes.split(" ")[0];
            var letraInicialSobrenome = nomeAbreviado.substring(0,1);
            letraInicialSobrenome += ".";
            var index = ultimosNomes.indexOf(" ");
            var novosUltimosNomes = ultimosNomes.substring(index).trim();
            nome = matcher.group(0) + " " + letraInicialSobrenome + " " + novosUltimosNomes;
            System.out.println(String.format("-> Retornar o nome abreviado: %s", nome));
        }
    }
}
