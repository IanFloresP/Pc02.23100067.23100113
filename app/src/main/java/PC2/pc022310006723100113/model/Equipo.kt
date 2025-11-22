package PC2.pc022310006723100113.model

import com.google.firebase.firestore.DocumentId

data class Equipo(
    @DocumentId
    val id: String? = null,
    val nombre: String = "",
    val fundacion: Int = 0,
    val titulos: Int = 0,
    val imagenUrl: String = ""
)
