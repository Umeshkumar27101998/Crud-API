package com.example.umeshfirstproject.crudapi.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "UmeshKumar_Invoice")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class InvoiceEntity {

    @Id
    @Column(name = "user_id")
    String userID;

    @Column(name = "amount")
    Long amount;

    @Column(name = "name")
    String name;

    @Column(name = "mobile_no")
    String mobileNo;

    @Column(name = "created_at")
    @CreationTimestamp
    Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    Timestamp updatedAt;

}
