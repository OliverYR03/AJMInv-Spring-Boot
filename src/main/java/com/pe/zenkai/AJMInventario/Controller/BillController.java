package com.pe.zenkai.AJMInventario.Controller;

import com.pe.zenkai.AJMInventario.Exceptions.ResourceNotFoundException;
import com.pe.zenkai.AJMInventario.Models.Bill;
import com.pe.zenkai.AJMInventario.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/factura")
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @GetMapping("/list")
    public List<Bill> getAllBills()
    {
        return billRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Bill> getBillsId(@PathVariable(value = "id") Integer numfactura)
        throws ResourceNotFoundException {

        Bill bills = billRepository.findById(numfactura).orElseThrow(() ->
                new ResourceNotFoundException("Bill not found for this id : : " + numfactura));
        return ResponseEntity.ok(bills);
    }

    @PostMapping("/new")
    public Bill createBill(@Validated @RequestBody Bill bills)
    {
        return billRepository.save(bills);
    }

    @PutMapping("/list/{id}")
    public ResponseEntity <Bill> updateBill(@PathVariable(value = "id") Integer numfactura,
                                            @Validated @RequestBody Bill billDetails) throws ResourceNotFoundException{
        Bill bills = billRepository.findById(numfactura)
                .orElseThrow(() -> new ResourceNotFoundException("Bill not found for this id : :" + numfactura));
        bills.setClient(billDetails.getClient());

        final Bill updateBill = billRepository.save(bills);
        return ResponseEntity.ok(updateBill);
    }

    @DeleteMapping("/list/{id}")
    public Map<String, Boolean> deleteBill (@PathVariable (value = "id") Integer numfactura)
        throws ResourceNotFoundException{
        Bill bills = billRepository.findById(numfactura)
                .orElseThrow(() -> new ResourceNotFoundException("Bill not found for this id : :" + numfactura + " Try again..."));
        billRepository.delete(bills);
        Map<String, Boolean> response = new HashMap<>();
        response.put("The Bill for id" + numfactura + "deleted", Boolean.TRUE);
        return response;
    }
}
