package me.vivanlabs.credit.application.system.repositories

import me.vivanlabs.credit.application.system.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
}