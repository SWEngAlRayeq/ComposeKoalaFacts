package app.koala_facts.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.koala_facts.domain.model.Koala
import app.koala_facts.domain.usecase.GetKoalaFactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class KoalaUiState(
    val koala: Koala? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class KoalaViewModel @Inject constructor(
    private val getKoalaFactUseCase: GetKoalaFactUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(KoalaUiState(isLoading = true))
    val state: StateFlow<KoalaUiState> = _state

    init {
        fetchKoala()
    }

    fun fetchKoala() {
        _state.value = KoalaUiState(isLoading = true)
        viewModelScope.launch {
            val response = getKoalaFactUseCase()
            if (response.isSuccess) {
                _state.value = KoalaUiState(koala = response.getOrNull())
            } else {
                _state.value = KoalaUiState(error = response.exceptionOrNull()?.localizedMessage)
            }
        }
    }

}