package com.jpmc.midascore.component;

import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.entity.Incentive;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.TransactionRecordRepository;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransactionListener {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRecordRepository transactionRecordRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    @KafkaListener(topics = "trader-updates")
    public void listen(Transaction transaction) {
        UserRecord sender = userRepository.findById(transaction.getSenderId());
        UserRecord recipient = userRepository.findById(transaction.getRecipientId());

        if (sender == null || recipient == null) return;
        if (sender.getBalance() < transaction.getAmount()) return;

        sender.setBalance(sender.getBalance() - transaction.getAmount());
        recipient.setBalance(recipient.getBalance() + transaction.getAmount());

        Incentive incentive = restTemplate.postForObject("http://localhost:8080/incentive", transaction, Incentive.class);
        float incentiveAmount = incentive != null ? incentive.getAmount() : 0;
        recipient.setBalance(recipient.getBalance() + incentiveAmount);

        userRepository.save(sender);
        userRepository.save(recipient);
        if (sender.getName().equals("wilbur")) {
            System.out.println("WILBUR (sender) BALANCE: " + sender.getBalance());
        }
        if (recipient.getName().equals("wilbur")) {
            System.out.println("WILBUR (recipient) BALANCE: " + recipient.getBalance());
        }

        UserRecord waldorf = userRepository.findById(5L);
        if (waldorf != null) {
            System.out.println("WALDORF BALANCE: " + waldorf.getBalance());
        }

        TransactionRecord record = new TransactionRecord(sender, recipient, transaction.getAmount());
        record.setIncentive(incentiveAmount);
        transactionRecordRepository.save(record);
    }
}