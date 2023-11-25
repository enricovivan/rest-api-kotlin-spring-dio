package me.vivanlabs.credit.application.system.services.impl

import me.vivanlabs.credit.application.system.model.Customer
import me.vivanlabs.credit.application.system.repositories.CustomerRepository
import me.vivanlabs.credit.application.system.services.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {
    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow { // if not found, throws an exception
            throw RuntimeException("Id $id not found")
        }
    }

    override fun delete(id: Long) {
        this.customerRepository.deleteById(id)
    }
}