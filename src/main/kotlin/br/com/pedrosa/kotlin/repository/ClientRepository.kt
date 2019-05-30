package br.com.pedrosa.kotlin.repository

import br.com.pedrosa.kotlin.domain.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository: JpaRepository<Client,Long>{

}