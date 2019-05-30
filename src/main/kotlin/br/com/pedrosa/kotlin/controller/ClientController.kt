package br.com.pedrosa.kotlin.controller

import br.com.pedrosa.kotlin.domain.Client
import br.com.pedrosa.kotlin.repository.ClientRepository
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus


@RestController
@RequestMapping("client")
class ClientController(private val clientRepository: ClientRepository){

    @GetMapping
    fun list(): List<Client> = this.clientRepository.findAll()

    @GetMapping("{id}")
    fun find(@PathVariable id: Long) =  this.clientRepository.findById(id).get()

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun add(@RequestBody client: Client) = this.clientRepository.save(client)


    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long,@RequestBody client: Client): Client? {
        var clientActual = this.clientRepository.findById(id).orElse(null)
        if(clientActual!=null){
            return this.clientRepository.save(clientActual.copy(name = client.name, age = client.age))
        }
        return null
    }

    @DeleteMapping(value = ["/{id}"])
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        var client = this.clientRepository.findById(id).orElse(null)
        if(client!=null) {
            this.clientRepository.deleteById(id)
        }    
    }
}


