package me.vivanlabs.credit.application.system.services

import me.vivanlabs.credit.application.system.model.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)
}