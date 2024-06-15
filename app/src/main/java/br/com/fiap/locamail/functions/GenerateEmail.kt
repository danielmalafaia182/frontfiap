package br.com.fiap.locamail.functions

import br.com.fiap.locamail.R
import br.com.fiap.locamail.classes.Email
import io.github.serpro69.kfaker.Faker
import kotlin.random.Random

val faker = Faker()

fun generateEmails(count: Int = Random.nextInt(1, 15)): List<Email> {
    val imageResources = listOf(
        R.drawable.rosto1,
        R.drawable.rosto2,
        R.drawable.rosto3,
        R.drawable.rosto4,
        R.drawable.rosto5,
    )


    return List(count) {
        Email(
            sender = faker.name.firstName().uppercase() + " " + faker.name.lastName().uppercase(),
            subject = faker.random.randomString(min = 3, max = 8).lowercase()
                .replaceFirstChar { it.uppercase() } + " " + faker.random.randomString(
                min = 2,
                max = 4
            ).lowercase().replaceFirstChar { it.uppercase() } + " " + faker.random.randomString(
                min = 3,
                max = 8
            ).lowercase().replaceFirstChar { it.uppercase() },
            body = faker.random.randomString(80, numericalChars = false),
            //body = faker.lorem.words(),
            isRead = Random.nextBoolean(),
            imageId = imageResources.random(),
            timestamp = String.format(
                "%02d",
                faker.random.nextInt(min = 0, max = 12)
            ) + ":" + String.format("%02d", faker.random.nextInt(min = 0, max = 59))
        )
    }.sortedByDescending { it.timestamp }
}