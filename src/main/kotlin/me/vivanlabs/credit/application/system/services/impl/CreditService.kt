package me.vivanlabs.credit.application.system.services.impl

import me.vivanlabs.credit.application.system.model.Credit
import me.vivanlabs.credit.application.system.repositories.CreditRepository
import me.vivanlabs.credit.application.system.services.ICreditService
import java.util.*

class CreditService (
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {

        // verifica se o customer existe no banco de dados
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }

        return creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomer(customerId) ?: throw RuntimeException("Não Existe Nenhum Crédito para este usuário")
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {

        // basicamente está escrito que:
        //  caso credito com o uuid passado não exista, lança execption que o crédito não existe
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("Credit Code Not Found"))

        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contacte o Admin")

    }
}