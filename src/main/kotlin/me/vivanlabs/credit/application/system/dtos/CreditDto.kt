package me.vivanlabs.credit.application.system.dtos

import me.vivanlabs.credit.application.system.model.Credit
import me.vivanlabs.credit.application.system.model.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto (
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
) {

    fun toEntity (): Credit = Credit(
        creditValue = creditValue,
        dayFirstInstallment = dayFirstOfInstallment,
        numberOfInstallments = numberOfInstallments,
        customer = Customer(id = customerId)
    )

}