package app.koala_facts.data.repo_impl

import android.util.Log.e
import app.koala_facts.data.remote.KoalaApi
import app.koala_facts.domain.model.Koala
import app.koala_facts.domain.repo.KoalaRepository
import javax.inject.Inject

class KoalaRepositoryImpl @Inject constructor(
    private val api: KoalaApi
): KoalaRepository {
    override suspend fun getKoalaFact(): Result<Koala> {
        return try {
            val dto = api.getKoala()
            val fact = dto.fact?.takeIf { it.isNotBlank() } ?: "No Fact Available"
            Result.success(Koala(fact, dto.image))
        }catch (e: Exception) {
            Result.failure(e)
        }
    }
}