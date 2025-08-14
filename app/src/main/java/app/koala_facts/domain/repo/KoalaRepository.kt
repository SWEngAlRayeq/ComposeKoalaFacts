package app.koala_facts.domain.repo

import app.koala_facts.domain.model.Koala

interface KoalaRepository {
    suspend fun getKoalaFact(): Result<Koala>
}