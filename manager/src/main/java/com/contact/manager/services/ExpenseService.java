package com.contact.manager.services;

import com.contact.manager.entities.Expense;
import com.contact.manager.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable pageable);

    public Expense getExpenseById(Long id);

    public void deleteExpenseById(Long id);

    public User saveExpense(Expense expense, Long userId);

    public Expense updateExpense(Long id,Expense expense);
}
