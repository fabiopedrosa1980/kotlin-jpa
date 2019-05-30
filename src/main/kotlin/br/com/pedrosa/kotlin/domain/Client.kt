package br.com.pedrosa.kotlin.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue

@Entity
data class Client (@Id @GeneratedValue val  id : Long , val name: String, val age: Int  )