package com.example.springapplication.loanApi;

import com.example.springapplication.entity.Loan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/emi")
@RestController
public class LoanAmountApi {

    @RequestMapping(method = RequestMethod.GET, path = "calculateTotalLoan")
    public ResponseEntity<Object> calculateRateOfInterest(@RequestBody Loan loan){
        double loanAmount =  loan.getLoanAmount();
        double tenure =  loan.getTenure();
        double rate =  loan.getRate()/100;
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }
}
