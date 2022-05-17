package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
