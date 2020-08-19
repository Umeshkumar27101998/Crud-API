package com.example.umeshfirstproject.crudapi.repository;

import com.example.umeshfirstproject.crudapi.model.entity.InvoiceEntity;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserInvoiceRepository extends JpaRepository<InvoiceEntity, String> {

}
