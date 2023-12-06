package me.vivanlabs.credit.application.system.controllers

import me.vivanlabs.credit.application.system.dtos.CreditDto
import me.vivanlabs.credit.application.system.dtos.CreditListView
import me.vivanlabs.credit.application.system.dtos.CreditView
import me.vivanlabs.credit.application.system.model.Credit
import me.vivanlabs.credit.application.system.services.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditResource (
    private val creditService: CreditService
) {

    // CREATE
    @PostMapping
    fun saveCredit(@RequestBody creditDto: CreditDto): ResponseEntity<String> {
        val credit: Credit = this.creditService.save(creditDto.toEntity())

        val message = "Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!!"

        return ResponseEntity.status(HttpStatus.CREATED).body(message)
    }

    // UPDATE


    // DELETE


    // READS
    @GetMapping
    fun findAllByCustomerId (@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditListView>> {
        val creditList = this.creditService.findAllByCustomer(customerId).stream().map {
            credit:Credit -> CreditListView(credit)
        }.collect(Collectors.toList())

        return ResponseEntity.status(HttpStatus.OK).body(creditList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode (@RequestParam(value = "customerId") customerId: Long, @PathVariable creditCode: UUID): ResponseEntity<CreditView> {
        val credit: Credit = this.creditService.findByCreditCode(customerId, creditCode)

        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }


}