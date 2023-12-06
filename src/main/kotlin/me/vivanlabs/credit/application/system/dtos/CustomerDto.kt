package me.vivanlabs.credit.application.system.dtos

import me.vivanlabs.credit.application.system.model.Address
import me.vivanlabs.credit.application.system.model.Customer
import java.math.BigDecimal

class CustomerDto (
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipcode: String,
    val street: String
) {

    fun toEntity(): Customer = Customer(
        firstName,
        lastName,
        cpf,
        email,
        password,
        Address(zipcode, street),
        income
    )

}