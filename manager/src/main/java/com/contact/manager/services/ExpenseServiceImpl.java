package com.contact.manager.services;

import com.contact.manager.CustomException.ExpenseNotFoundException;
import com.contact.manager.dao.ExpenseRepository;
import com.contact.manager.dao.UserRepository;
import com.contact.manager.entities.Expense;
import com.contact.manager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl  implements ExpenseService{


    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<Expense> getAllExpenses(Pageable pageable) {
        return expenseRepository.findAll(pageable);
    }

    public List<Expense> readByCategory(String category, Pageable page){
        return expenseRepository.findByCategory(category,page).toList();
    }

    @Override
    public Expense getExpenseById(Long id){
        Optional<Expense> expenseOptional = expenseRepository.findById(id);
        if(expenseOptional.isPresent()){
            return expenseOptional.get();
        }
        else{
            throw new ExpenseNotFoundException("Expense Not found for id "+id);
        }
    }

    public void deleteExpenseById(Long id){
        expenseRepository.deleteById(id);
    }

    public User saveExpense(Expense expense, Long userId){
       User user = userService.getUserById(userId);
      expense.setUser(user);
//       if(user.getExpenseList()==null){
//           user.setExpenseList(new ArrayList<>());
//       }
//       List<Expense> extractedList = user.getExpenseList();
//       extractedList.add(expense);
//       user.setExpenseList(extractedList);
      // return userRepository.save(user);
       expenseRepository.save(expense);
       return user;
    }
    
    public Expense updateExpense(Long id,Expense expense){
        if(expense==null)
            return expense;
        Expense existingExpense = getExpenseById(id);
        existingExpense.setName(expense.getName()!=null ? expense.getName() : existingExpense.getName());
        existingExpense.setCategory(expense.getCategory()!=null ? expense.getCategory() : existingExpense.getCategory());
        existingExpense.setDescription(expense.getDescription()!=null ? expense.getDescription() : existingExpense.getDescription());
        existingExpense.setAmount(expense.getAmount()!=null ? expense.getAmount():existingExpense.getAmount());
        existingExpense.setDate(expense.getDate()!=null ? expense.getDate() : existingExpense.getDate());
        return expenseRepository.save(existingExpense);
    }
}
