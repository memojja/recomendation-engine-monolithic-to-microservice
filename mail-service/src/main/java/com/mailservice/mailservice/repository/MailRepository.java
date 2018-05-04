package com.mailservice.mailservice.repository;


import com.mailservice.mailservice.entity.Mail;
import org.springframework.data.repository.CrudRepository;

public interface MailRepository extends CrudRepository<Mail, Long> {

}