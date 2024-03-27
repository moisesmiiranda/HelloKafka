package com.mmiranda.producer.controller


import com.mmiranda.producer.service.MensagemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mensagem")
class MensagemController @Autowired constructor (
    private val mensagemService: MensagemService
) {
    @PostMapping
    fun enviarMensagem(@RequestBody mensagem: String): ResponseEntity<String> {
        mensagemService.sendMessage(mensagem)
        return ResponseEntity.ok().body("Mensagem enviada com sucesso: $mensagem")
    }

}