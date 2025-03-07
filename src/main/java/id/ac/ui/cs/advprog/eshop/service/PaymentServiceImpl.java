package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        Payment payment = new Payment(method, paymentData);

        if (method.equals("VOUCHER")) {
            validateVoucher(payment);
        } else if (method.equals("BANK_TRANSFER")) {
            validateBankTransfer(payment);
        }

        paymentRepository.save(payment);
        return payment;
    }

    private void validateVoucher(Payment payment) {
        String voucherCode = payment.getPaymentData().get("voucherCode");

        if (voucherCode != null && voucherCode.length() == 16 &&
                voucherCode.startsWith("ESHOP") &&
                Pattern.compile("[0-9]{8}").matcher(voucherCode.substring(5)).find()) {
            payment.setStatus("SUCCESS");
        } else {
            payment.setStatus("REJECTED");
        }
    }

    private void validateBankTransfer(Payment payment) {
        Map<String, String> data = payment.getPaymentData();
        if (data.get("bankName") == null || data.get("bankName").isEmpty() ||
                data.get("referenceCode") == null || data.get("referenceCode").isEmpty()) {
            payment.setStatus("REJECTED");
        } else {
            payment.setStatus("SUCCESS");
        }
    }

    @Override
    public Payment setStatus(Payment payment, String status) {
        payment.setStatus(status);
        return payment;
    }

    @Override
    public Payment getPayment(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
