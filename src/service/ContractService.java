package service;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

/**
 * @author joaovictorcmd
 * @date 2024 Jul 17
 */
public class ContractService {

    private IOnlinePaymentService onlinePaymentService;

    public ContractService(IOnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {

        double basicInstallment = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            Double interest = onlinePaymentService.interest(basicInstallment, i);
            Double paymentFee = onlinePaymentService.paymentFee(basicInstallment + interest);

            double installment = basicInstallment + interest + paymentFee;

            contract.getInstallments().add(new Installment(dueDate, installment));
        }

    }
}
