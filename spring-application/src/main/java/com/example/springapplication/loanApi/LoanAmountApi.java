package com.example.springapplication.loanApi;

import com.example.springapplication.entity.Loan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("api/v1/emi")
@RestController
public class LoanAmountApi {

    @RequestMapping(method = RequestMethod.GET, path = "calculateTotalLoan")
    public ResponseEntity<Object> calculateRateOfInterest(@RequestBody Loan loan){
        double loanAmount =  loan.getLoanAmount();
        double tenure =  loan.getTenure();
        double rate =  loan.getRate()/100;
        double totalLoan = loanAmount * rate * (Math.pow((1+rate),tenure)/(Math.pow((1+rate),tenure) - 1)) * 1/12;
        return new ResponseEntity<>(totalLoan, HttpStatus.OK);
    }
}
