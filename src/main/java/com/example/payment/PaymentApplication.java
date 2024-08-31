package com.example.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PaymentApplication {

    private final PaymentDatabaseService paymentDatabaseService = new PaymentDatabaseService();

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @GetMapping("/methods")
    public String allPaymentMethodsAsHtmlList() {
        String[] methodsList = paymentDatabaseService.getAllPaymentMethods();
        String methods = "\n <h1> Zahlungsmöglichkeiten </h1> \n<ul>";

        for (String m : methodsList) {
            methods = String.format("%s \n <li> %s </li>", methods, m);
        }

        String htmlListEnd = "\n</ul>";
        return String.format(methods + htmlListEnd);
    }
}
