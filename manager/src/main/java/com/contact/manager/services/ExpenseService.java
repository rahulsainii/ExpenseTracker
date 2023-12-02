package com.contact.manager.services;

import com.contact.manager.entities.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable pageable);

    public Expense getExpenseById(Long id);

    public void deleteExpenseById(Long id);

    public Expense saveExpense(Expense expense);

    public Expense updateExpense(Long id,Expense expense);
}
