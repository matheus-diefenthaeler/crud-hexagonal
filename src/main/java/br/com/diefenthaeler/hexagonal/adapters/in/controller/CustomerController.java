package br.com.diefenthaeler.hexagonal.adapters.in.controller;

import br.com.diefenthaeler.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.diefenthaeler.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.diefenthaeler.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.diefenthaeler.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.diefenthaeler.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final CustomerMapper customerMapper;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCostumer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }
}
