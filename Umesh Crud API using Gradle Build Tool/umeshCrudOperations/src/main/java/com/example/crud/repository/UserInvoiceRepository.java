package com.example.crud.repository;

import com.example.crud.model.entity.UserInvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInvoiceRepository extends JpaRepository<UserInvoiceEntity, String> {

}
