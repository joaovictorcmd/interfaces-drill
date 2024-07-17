package application;

import entities.Contract;
import entities.Installment;
import service.ContractService;
import service.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author joaovictorcmd
 * @date 2024 Jul 17
 */
public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("DADOS DO CONTRATO");
        System.out.print("Número: ");
        int numberContract = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate dateContract = LocalDate.parse(sc.next(), fmt);
        System.out.print("Valor do contrato: ");
        double totalValueContract = sc.nextDouble();

        Contract contract = new Contract(numberContract, dateContract, totalValueContract);

        System.out.print("Entre com o número de parcelas: ");
        int numberInstallments = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, numberInstallments);

        System.out.println();
        System.out.println("PARCELAS:");

        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }
    }
}
