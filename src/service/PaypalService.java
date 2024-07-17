package service;

/**
 * @author joaovictorcmd
 * @date 2024 Jul 17
 */
public class PaypalService implements IOnlinePaymentService {

    private static final double FEE_PERCENTAGE = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;

    @Override
    public Double paymentFee(Double amount) {
        return amount * FEE_PERCENTAGE;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount * months * MONTHLY_INTEREST;
    }
}
