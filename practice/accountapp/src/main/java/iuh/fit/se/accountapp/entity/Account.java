package iuh.fit.se.accountapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    private int id;
    @Column(name = "owner_name")

    private  String name;
    @Column(name = "card_number")

    private  String card;
    @Column(name = "owner_address")

    private  String address;
private  double amount;
}
