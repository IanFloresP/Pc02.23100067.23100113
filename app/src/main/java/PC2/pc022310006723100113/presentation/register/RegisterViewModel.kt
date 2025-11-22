package PC2.pc022310006723100113.presentation.register

import PC2.pc022310006723100113.model.Equipo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    fun guardarEquipo(equipo: Equipo) {
        viewModelScope.launch {
            val db = FirebaseFirestore.getInstance()
            db.collection("Equipos").add(equipo)
        }
    }
}
