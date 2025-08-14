package app.koala_facts.domain.usecase

import app.koala_facts.domain.repo.KoalaRepository
import javax.inject.Inject

class GetKoalaFactUseCase @Inject constructor(
    private val repository: KoalaRepository
) {
    suspend operator fun invoke() = repository.getKoalaFact()
}