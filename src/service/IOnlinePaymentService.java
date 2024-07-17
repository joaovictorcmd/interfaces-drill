package service;

/**
 * @author joaovictorcmd
 * @date 2024 Jul 17
 */
public interface IOnlinePaymentService {
    Double paymentFee(Double amount);
    Double interest(Double amount, Integer months);
}
