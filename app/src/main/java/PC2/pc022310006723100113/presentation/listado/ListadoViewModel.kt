package PC2.pc022310006723100113.presentation.listado

import PC2.pc022310006723100113.model.Equipo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.snapshots
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ListadoViewModel : ViewModel() {

    val equipos: StateFlow<List<Equipo>> = FirebaseFirestore.getInstance()
        .collection("Equipos")
        .orderBy("nombre")
        .snapshots() // Ahora funciona gracias a la dependencia -ktx
        .map { snapshot ->
            // Revertimos a la forma idiomática de Kotlin
            snapshot.toObjects<Equipo>()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
}
