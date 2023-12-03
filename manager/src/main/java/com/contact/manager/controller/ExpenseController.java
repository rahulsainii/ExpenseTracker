package com.contact.manager.controller;

import com.contact.manager.entities.Expense;
import com.contact.manager.entities.User;
import com.contact.manager.services.ExpenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ExpenseController {


    @Autowired
    ExpenseServiceImpl expenseService;

    // it will give pages of data
    // no need to pass any other info like page number separatly but we can pass in url
    // http://localhost:8080/expenses?page=1&size=3
    // we can send sort also as a parameter.
    // http://localhost:8080/expenses?page=1&size=3&sort=amount
    // send in desc order :- http://localhost:8080/expenses?page=1&size=3&sort=amount,desc
    // it can work without these extra variables


    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(Pageable pageable){
        return expenseService.getAllExpenses(pageable).toList();
    }


    // passing parameter as part of url method = 1
    // http://localhost:8080/expenses/45
    @GetMapping("/expense/{id}")
    public Expense getExpenseById(@PathVariable("id") Long id){
//        try{
//            Expense ex=expenseService.getExpenseById(id);
//            return ex;
//        }
//        catch (Exception ex){
//            return (Expense) new Object();
//        }
        return expenseService.getExpenseById(id);
    }


    @GetMapping("/expenses/category")
    public List<Expense> getExpensesByCategory(@RequestParam("category") String category, Pageable page){
        return expenseService.readByCategory(category,page);
    }

    // passing value as request parameter
    //http://localhost:8080/expense?id=45
    @GetMapping("/expense")
    public Expense getExpenseByIdInRequestParam(@RequestParam("id") Long id){
        return expenseService.getExpenseById(id);
    }

    // http://localhost:8080/expenses?id=45&userId=10
    @GetMapping("/user/expenses")
    public List<Expense> getExpensesByUserId(@RequestParam("userId") Long user, @RequestParam Long id){
        return null;
        //ResponseEntity responseEntity=new ResponseEntity();
    }


    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    @DeleteMapping("/expense")
    public String deleteExpenseById(@RequestParam("id") Long id){
        expenseService.deleteExpenseById(id);
        return "user deleted";
    }

    @PostMapping("/expense/user/{id}")
    @ResponseStatus(value= HttpStatus.CREATED)
    public User saveExpense(@RequestBody Expense expense, @PathVariable("id") Long userId){
        return expenseService.saveExpense(expense,userId);
    }

    @PutMapping("/expense/{id}")
    public Expense updateExpense(@RequestBody Expense expense,@PathVariable Long id)
    {
      return expenseService.updateExpense(id,expense);
    }




}
