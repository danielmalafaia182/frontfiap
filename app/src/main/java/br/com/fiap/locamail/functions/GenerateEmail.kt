package br.com.fiap.locamail.functions

import br.com.fiap.locamail.classes.Email
import io.github.serpro69.kfaker.Faker
import kotlin.random.Random

val faker = Faker()

fun generateEmails(count: Int): List<Email> {
    return List(count) {
        Email(
            sender = faker.name.name(),
            subject = faker.lorem.words(),
            body = faker.lorem.words(),
            isRead = Random.nextBoolean()
        )
    }
}

val emails = generateEmails(50)
